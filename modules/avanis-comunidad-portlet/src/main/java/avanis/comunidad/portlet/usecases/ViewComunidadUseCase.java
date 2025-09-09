package avanis.comunidad.portlet.usecases;

import avanis.comunidad.portlet.portlet.AvanisComunidadPortlet;
import avanis.comunidad.portlet.portlet.MBMessageDateComparator;
import avanis.comunidad.portlet.portlet.MBThreadRelevanceComparator;
import avanis.comunidad.portlet.util.AvanisComunidadUtil;
import avanis.social.follow.sb.service.SocialFollowLocalServiceUtil;
import com.liferay.asset.entry.rel.service.AssetEntryAssetCategoryRelLocalServiceUtil;
import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.blogs.model.BlogsEntry;
import com.liferay.expando.kernel.service.ExpandoValueLocalServiceUtil;
import com.liferay.message.boards.model.MBMessage;
import com.liferay.message.boards.model.MBThread;
import com.liferay.message.boards.service.MBMessageLocalServiceUtil;
import com.liferay.message.boards.service.MBThreadLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.*;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.AuthTokenUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.sound.sampled.Port;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ViewComunidadUseCase {
    private static final Log _log = LogFactoryUtil.getLog(ViewComunidadUseCase.class);
    private static final Integer MB_MESSAGE_PER_PAGE = 10;
    private long expandoColumnVisibilityId;
    private long expandoTableMessageId;
    private int offset;

    public ViewComunidadUseCase(long expandoColumnVisibilityId, long expandoTableMessageId, int offset) {
        this.expandoColumnVisibilityId = expandoColumnVisibilityId;
        this.expandoTableMessageId = expandoTableMessageId;
        this.offset = offset;
    }

    public void viewComunidad(PortletRequest renderRequest, PortletResponse renderResponse) throws PortletException, IOException {
        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        long actualUserId = themeDisplay.getUserId();
        long groupId = themeDisplay.getScopeGroupId();
        long companyId = themeDisplay.getCompanyId();

        // Orden
        String ordenMessages = ParamUtil.getString(renderRequest, "ordenMessages");

        // Filtros
        String tabMessages = ParamUtil.getString(renderRequest, "tabMessages");
        String categoriesFilter = ParamUtil.getString(renderRequest, "categoriesFilter", "-1");

        String pAuth = AuthTokenUtil.getToken(PortalUtil.getHttpServletRequest(renderRequest));
        renderRequest.setAttribute("pAuth", pAuth);

        List<MBThread> userThreads = this.getVisibleThreadsByPrincipal(actualUserId, themeDisplay.isSignedIn(), this.offset, categoriesFilter, ordenMessages);

        List<MBThread> filteredThreads = new ArrayList<>(userThreads);

        //TODO: Ordenación hilos - Hay que hacerlo por query, ya que ya no vamos a traer todos los datos
        if (ordenMessages.equals("ordenarPorRelevancia")) {
            Comparator<MBThread> comparatorThread = new MBThreadRelevanceComparator(false);
            filteredThreads.sort(comparatorThread);
        }

        // Lista de categorías
        List<AssetCategory> categories = AvanisComunidadUtil.getAssetCategoryGlobalList(companyId, groupId);

        long[] categoriesIds = AvanisComunidadUtil.getCategoriesIds(categories);
        int newOffset = offset + filteredThreads.size();

        renderRequest.setAttribute("categories", categories);
        renderRequest.setAttribute("categoriesIds", categoriesIds);

        renderRequest.setAttribute("threads", filteredThreads);
        //TODO: Ordenación de hilos, hay que paginarlo y eliminar el ordenar por relevancia este
        renderRequest.setAttribute("showSentinel", !"ordenarPorRelevancia".equals(ordenMessages) && isThereMoreMessages(newOffset, offset));
        renderRequest.setAttribute("offset", newOffset);
        renderRequest.setAttribute("ordenMessages", ordenMessages);
        renderRequest.setAttribute("tabMessages", tabMessages);
        renderRequest.setAttribute("categoriesFilter", categoriesFilter);
        renderRequest.setAttribute("actualUserId", actualUserId);


    }

    private boolean isThereMoreMessages(int shownMessages, int offset) {
        return shownMessages > offset && shownMessages % MB_MESSAGE_PER_PAGE == 0;

    }

    private List<MBThread> getVisibleThreadsByPrincipal(long principalId, boolean isSignedIn, int offset, String categoryIds, String order) {
        System.out.println("INICIO METODO getVisibleThreadsByPrincipal");
        DynamicQuery threadQuery = MBThreadLocalServiceUtil.dynamicQuery();

// Obtener mensajes públicos o registrados según el estado del usuario
        DynamicQuery publicMessagesQuery = ExpandoValueLocalServiceUtil.dynamicQuery();
        publicMessagesQuery.setProjection(ProjectionFactoryUtil.property("classPK"));
        publicMessagesQuery.add(RestrictionsFactoryUtil.eq("columnId", this.expandoColumnVisibilityId));
        publicMessagesQuery.add(RestrictionsFactoryUtil.eq("tableId", this.expandoTableMessageId));
        publicMessagesQuery.add(RestrictionsFactoryUtil.in("data", isSignedIn ? new String[]{"public", "registered"} : new String[]{"public"}));

        List<Long> publicMessagesIds = ExpandoValueLocalServiceUtil.dynamicQuery(publicMessagesQuery);

        Disjunction disjunction = RestrictionsFactoryUtil.disjunction();
        disjunction.add(RestrictionsFactoryUtil.in("rootMessageId", publicMessagesIds));

        if (isSignedIn) {
            DynamicQuery followingUsersQuery = SocialFollowLocalServiceUtil.dynamicQuery();
            followingUsersQuery.setProjection(ProjectionFactoryUtil.property("followsTo"));
            followingUsersQuery.add(RestrictionsFactoryUtil.eq("userId", principalId));
            followingUsersQuery.add(RestrictionsFactoryUtil.eq("accepted", true));

            List<Long> followingUserIds = SocialFollowLocalServiceUtil.dynamicQuery(followingUsersQuery);

            disjunction.add(RestrictionsFactoryUtil.in("rootMessageUserId", followingUserIds));
            disjunction.add(RestrictionsFactoryUtil.eq("rootMessageUserId", principalId));
        }

        threadQuery.add(disjunction);

// Filtrar por categorías si es necesario
        if (!categoryIds.isEmpty() && !categoryIds.equals("-1")) {
            threadQuery.setProjection(ProjectionFactoryUtil.property("rootMessageId"));
            List<Long> visibleThreadIds = MBThreadLocalServiceUtil.dynamicQuery(threadQuery);
            return filterThreadsByCategories(visibleThreadIds, offset, categoryIds, order);
        }
        System.out.println("FIN METODO getVisibleThreadsByPrincipal");
// Ordenar y aplicar paginación
        if (!"ordenarPorRelevancia".equals(order)) {
            threadQuery.addOrder(OrderFactoryUtil.desc("createDate"));
            return MBThreadLocalServiceUtil.dynamicQuery(threadQuery, offset, offset + MB_MESSAGE_PER_PAGE);
        } else {
            return MBThreadLocalServiceUtil.dynamicQuery(threadQuery);
        }


    }

    private List<MBThread> filterThreadsByCategories(List<Long> visibleThreadsId, int offset, String categoryIds, String order) {

        long mbMessageClassId = PortalUtil.getClassNameId(MBMessage.class.getName());


        DynamicQuery assetEntriesQuery = AssetEntryLocalServiceUtil.dynamicQuery();
        assetEntriesQuery.setProjection(ProjectionFactoryUtil.distinct(ProjectionFactoryUtil.property("entryId")));
        assetEntriesQuery.add(RestrictionsFactoryUtil.eq("classNameId", mbMessageClassId));
        assetEntriesQuery.add(RestrictionsFactoryUtil.in("classPK", visibleThreadsId));


        List<Long> visibleAssetsId = AssetEntryLocalServiceUtil.dynamicQuery(assetEntriesQuery);

        DynamicQuery filteredAssetEntriesQuery = AssetEntryAssetCategoryRelLocalServiceUtil.dynamicQuery();
        filteredAssetEntriesQuery.setProjection(ProjectionFactoryUtil.distinct(ProjectionFactoryUtil.property("assetEntryId")));
        filteredAssetEntriesQuery.add(RestrictionsFactoryUtil.in("assetCategoryId", fromCategoryStringToLong(categoryIds)));
        filteredAssetEntriesQuery.add(RestrictionsFactoryUtil.in("assetEntryId", visibleAssetsId));

        List<Long> filteredAssetEntryId = AssetEntryAssetCategoryRelLocalServiceUtil.dynamicQuery(filteredAssetEntriesQuery);


        assetEntriesQuery = AssetEntryLocalServiceUtil.dynamicQuery();
        assetEntriesQuery.setProjection(ProjectionFactoryUtil.distinct(ProjectionFactoryUtil.property("classPK")));
        assetEntriesQuery.add(RestrictionsFactoryUtil.eq("classNameId", mbMessageClassId));
        assetEntriesQuery.add(RestrictionsFactoryUtil.in("entryId", filteredAssetEntryId));

        List<Long> filteredMessageIds = AssetEntryLocalServiceUtil.dynamicQuery(assetEntriesQuery);


        DynamicQuery threadQuery = MBThreadLocalServiceUtil.dynamicQuery();
        threadQuery.add(RestrictionsFactoryUtil.in("rootMessageId", filteredMessageIds));
        threadQuery.addOrder(OrderFactoryUtil.desc("createDate"));

        //TODO: Ordenación de hilos paginada
        if (!"ordenarPorRelevancia".equals(order)) {
            threadQuery.addOrder(OrderFactoryUtil.desc("createDate"));
            return MBThreadLocalServiceUtil.dynamicQuery(threadQuery, offset, offset + MB_MESSAGE_PER_PAGE);
        } else {
            return MBThreadLocalServiceUtil.dynamicQuery(threadQuery);
        }

    }

    private Long[] fromCategoryStringToLong(String categories) {
        String[] categoryArray = categories.split(",");
        Long[] result = new Long[categoryArray.length];

        for (int i = 0; i < categoryArray.length; i++) {
            try {
                result[i] = Long.parseLong(categoryArray[i]);
            } catch (NumberFormatException e) {
                result[i] = 0L;
            }
        }

        return result;

    }


}
