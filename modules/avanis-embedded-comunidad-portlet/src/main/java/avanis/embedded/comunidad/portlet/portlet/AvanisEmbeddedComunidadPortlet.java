package avanis.embedded.comunidad.portlet.portlet;

import avanis.embedded.comunidad.portlet.constants.AvanisEmbeddedComunidadPortletKeys;

import com.liferay.blogs.model.BlogsEntry;
import com.liferay.blogs.service.BlogsEntryLocalServiceUtil;
import com.liferay.calendar.model.CalendarBooking;
import com.liferay.calendar.service.CalendarBookingLocalServiceUtil;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.service.ExpandoValueLocalServiceUtil;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.message.boards.model.MBMessage;
import com.liferay.message.boards.model.MBThread;
import com.liferay.message.boards.service.MBMessageLocalServiceUtil;
import com.liferay.message.boards.service.MBThreadLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.*;
import javax.portlet.annotations.ServeResourceMethod;

import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.*;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.ratings.kernel.service.RatingsEntryLocalServiceUtil;
import org.osgi.service.component.annotations.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author angelperez
 */
@Component(
        property = {
                "javax.portlet.version=3.0",
                "com.liferay.portlet.display-category=avanis",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.instanceable=true",
                "com.liferay.portlet.add-default-resource=true",
                "javax.portlet.display-name=AvanisEmbeddedComunidad",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/view.jsp",
                "javax.portlet.name=" + AvanisEmbeddedComunidadPortletKeys.AVANISEMBEDDEDCOMUNIDAD,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class AvanisEmbeddedComunidadPortlet extends MVCPortlet {

    private static final Log _log = LogFactoryUtil.getLog(AvanisEmbeddedComunidadPortlet.class);

    private static final Map<String, String> MAP_CLASS_BODY = Map.of(
            "com.liferay.calendar.model.CalendarBooking", "¿Aún no has visto lo que se está comentando sobre este evento? ¡Únete al debate!",
            "com.liferay.blogs.model.BlogsEntry", "¿Aún no has visto lo que se está comentando sobre esta noticia? ¡Únete al debate!",
            "com.liferay.journal.model.JournalArticle", "¿Aún no has visto lo que se está comentando sobre esta ayuda? ¡Únete al debate!",
            "lonja", "¿Aún no has visto lo que se está comentando sobre este producto? ¡Únete al debate!"
    );

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

        String className = renderRequest.getRenderParameters().getValue("resourceClassName");
        long classPK = parseId(renderRequest.getRenderParameters().getValue("resourceId"));

        MBThread thread = getRelatedThread(className, classPK);

        if (!themeDisplay.isSignedIn() && thread != null) {
            countInteractions(thread, renderRequest);
            getInteractingUsers(thread, renderRequest);
        }

        String resourceType = "";
        if ("com.liferay.calendar.model.CalendarBooking".equals(className)) {
            resourceType = "evento";
        } else if ("com.liferay.blogs.model.BlogsEntry".equals(className)) {
            resourceType = "noticia";
        } else if ("com.liferay.journal.model.JournalArticle".equals(className)) {
            resourceType = "ayuda";
        } else if ("lonja".equals(className)) {
            resourceType = "lonja";
        }

        String view = renderRequest.getRenderParameters().getValue("view");
        if (view == null) {
            view = "default"; // Valor por defecto si no está presente
        }

        renderRequest.setAttribute("resourceType", resourceType);
        renderRequest.setAttribute("vista", view);
        renderRequest.setAttribute("thread", thread);
        renderRequest.setAttribute("isSignedIn", themeDisplay.isSignedIn());
        renderRequest.setAttribute("resourceId", classPK);
        renderRequest.setAttribute("resourceName", className);

        super.doView(renderRequest, renderResponse);
    }

    @ServeResourceMethod(portletNames = AvanisEmbeddedComunidadPortletKeys.AVANISEMBEDDEDCOMUNIDAD, resourceID = "createThread")
    public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {

        ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

        try {
            String className = ParamUtil.getString(resourceRequest, "resourceName");
            long classPK = ParamUtil.getLong(resourceRequest, "resourceId", 0);
            String body = ParamUtil.getString(resourceRequest, "body");



            String resourceUrlTitle = null;
            long lonjaId = 0;
            String eventTitle="";

            if ("lonja".equals(className)) {
                resourceUrlTitle = "CREO Hilo de LONJA";
                lonjaId = ParamUtil.getLong(resourceRequest, "lonjaId", 0);
                if (lonjaId == 0) {
                    throw new IllegalArgumentException("El parámetro lonjaId es obligatorio.");
                }
            }
            else if("evento".equals(className)){
                eventTitle = String.valueOf(ParamUtil.get(resourceRequest, "eventTitle", String.valueOf(0)));
                System.out.println("EVENTO: " + eventTitle);
            }
            else {
                resourceUrlTitle = getResourceUrlTitle(className, classPK, themeDisplay);
            }

            if (resourceUrlTitle != null && getRelatedThread(className, classPK) == null) {
                MBThread thread = createMBThread(className, classPK, resourceUrlTitle, themeDisplay, resourceRequest);

                MBMessage rootMessage = MBMessageLocalServiceUtil.getMBMessage(thread.getRootMessageId());
                rootMessage.getExpandoBridge().setAttribute("visibility", "registered");

                MBMessageLocalServiceUtil.addMessage(
                        themeDisplay.getUserId(),
                        themeDisplay.getUser().getScreenName(),
                        themeDisplay.getScopeGroupId(),
                        0L,
                        thread.getThreadId(),
                        thread.getRootMessageId(),
                        body,
                        body,
                        "html",
                        new ArrayList(),
                        false,
                        0D,
                        false,
                        new ServiceContext()
                );
                String redirectURL = "";
                // URL de redirección
                System.out.println("_________________CLASSNAME______________ = "+className);
                System.out.println("*****resourceUrlTitle: "+resourceUrlTitle);
                System.out.println("_______________________________________________________");
                if ("lonja".equals(className)) {
                    redirectURL = themeDisplay.getPortalURL() + "/detalle-lonja?lonjaId=" + lonjaId + "&productoId=" + classPK;
                }

                if("com.liferay.calendar.model.CalendarBooking".equals(className)){
                    redirectURL = themeDisplay.getPortalURL() + "/detalle-del-evento?eventTitle="  + resourceUrlTitle;
                }
                if("com.liferay.journal.model.JournalArticle".equals(className)){
                    redirectURL = themeDisplay.getPortalURL() + "/w/"  + resourceUrlTitle;
                }
                if("com.liferay.blogs.model.BlogsEntry".equals(className)){
                    redirectURL = themeDisplay.getPortalURL() + "/b/"  + resourceUrlTitle;
                }


                System.out.println("Redirigiendo a la URL: " + redirectURL);

                // Redirigir al usuario
                resourceResponse.setProperty(ResourceResponse.HTTP_STATUS_CODE, "302");
                resourceResponse.setProperty("Location", redirectURL);
            } else {
                System.out.println("Ya existe un hilo relacionado o el resourceUrlTitle es nulo.");
            }

        } catch (Exception e) {
            System.out.println("Error en serveResource:");
            e.printStackTrace();
        }
    }

    private String getResourceUrlTitle(String className, long classPK, ThemeDisplay themeDisplay) {
        try {
            System.out.println("=== GET RESOURCE URL TITLE ===");
            System.out.println("className: " + className);
            System.out.println("classPK: " + classPK);

            switch (className) {
                case "com.liferay.calendar.model.CalendarBooking":
                    CalendarBooking calendarBooking = CalendarBookingLocalServiceUtil.getCalendarBooking(classPK);
                    String eventUrl = (String) calendarBooking.getExpandoBridge().getAttribute("event_url");
                    System.out.println("Event URL: " + eventUrl);
                    return eventUrl;

                case "com.liferay.blogs.model.BlogsEntry":
                    BlogsEntry blogsEntry = BlogsEntryLocalServiceUtil.getBlogsEntry(classPK);
                    System.out.println("Blog URL Title: " + blogsEntry.getUrlTitle());
                    return blogsEntry.getUrlTitle();

                case "com.liferay.journal.model.JournalArticle":
                    JournalArticle journalArticle = JournalArticleLocalServiceUtil.getArticle(themeDisplay.getScopeGroupId(), String.valueOf(classPK));
                    System.out.println("Journal Article URL Title: " + journalArticle.getUrlTitle());
                    return journalArticle.getUrlTitle();

                default:
                    System.out.println("Clase no reconocida: " + className);
                    return null;
            }
        } catch (PortalException exception) {
            System.out.println("Error en getResourceUrlTitle:");
            exception.printStackTrace();
            return null;
        }
    }

    private MBThread createMBThread(String className, long classPK, String resourceUrlTitle, ThemeDisplay themeDisplay, PortletRequest portletRequest) {
        MBThread res = null;

        try {
            long avanisUserId = 20122; // Usuario predeterminado
            User avanisUser = UserLocalServiceUtil.getUser(avanisUserId);

            String body = MAP_CLASS_BODY.get(className);

            System.out.println("=== CREATE MB THREAD ===");
            System.out.println("className: " + className);
            System.out.println("classPK: " + classPK);
            System.out.println("resourceUrlTitle: " + resourceUrlTitle);
            System.out.println("avanisUserId: " + avanisUserId);
            System.out.println("body: " + body);

            MBMessage message = MBMessageLocalServiceUtil.addMessage(
                    avanisUser.getUserId(),
                    avanisUser.getScreenName(),
                    themeDisplay.getScopeGroupId(),
                    0L,
                    0L,
                    0L,
                    body,
                    "",
                    "html",
                    new ArrayList(),
                    false,
                    0D,
                    false,
                    new ServiceContext()
            );

            res = message.getThread();

            ExpandoBridge expandoBridge = res.getExpandoBridge();
            expandoBridge.setAttribute("resourceClassAndId", className + "." + classPK);

            System.out.println("Hilo creado exitosamente. Thread ID: " + res.getThreadId());

        } catch (Exception e) {
            System.out.println("Error en createMBThread:");
            e.printStackTrace();
        }

        return res;
    }

    private MBThread getRelatedThread(String className, long classPK) {
        MBThread thread = null;

        try {
            DynamicQuery dynamicQuery = ExpandoValueLocalServiceUtil.dynamicQuery();
            dynamicQuery.setProjection(ProjectionFactoryUtil.property("classPK"));
            dynamicQuery.add(RestrictionsFactoryUtil.eq("data", className + "." + classPK));

            //System.out.println("=== GET RELATED THREAD ===");
            //System.out.println("Buscando hilo relacionado para: " + className + "." + classPK);

            List<Long> threadIds = ExpandoValueLocalServiceUtil.dynamicQuery(dynamicQuery);

            //System.out.println("Thread IDs encontrados: " + threadIds);

            if (!threadIds.isEmpty()) {
                thread = MBThreadLocalServiceUtil.getThread(threadIds.get(0));
                //System.out.println("Hilo relacionado encontrado. Thread ID: " + thread.getThreadId());
            } else {
                //System.out.println("No se encontró ningún hilo relacionado.");
            }

        } catch (Exception e) {
            System.out.println("Error en getRelatedThread:");
            e.printStackTrace();
        }

        return thread;
    }

    private void countInteractions(MBThread thread, RenderRequest renderRequest) {
        int likes = 0;
        int comments = 0;

        try {
            if (thread != null) {
                MBMessage message = MBMessageLocalServiceUtil.getMessage(thread.getRootMessageId());
                likes = RatingsEntryLocalServiceUtil.getEntriesCount(MBMessage.class.getName(), message.getMessageId(), 1d);
                comments = MBMessageLocalServiceUtil.getChildMessagesCount(message.getMessageId(), WorkflowConstants.STATUS_APPROVED);
            }
        } catch (Exception e) {
            System.out.println("Error en countInteractions:");
            e.printStackTrace();
        }

        renderRequest.setAttribute("likes", likes);
        renderRequest.setAttribute("comments", comments);
    }

    private void getInteractingUsers(MBThread mbThread, RenderRequest renderRequest) {
        try {
            DynamicQuery messageQuery = MBMessageLocalServiceUtil.dynamicQuery();

            messageQuery.setProjection(ProjectionFactoryUtil.distinct(ProjectionFactoryUtil.property("userId")));
            messageQuery.add(RestrictionsFactoryUtil.eq("rootMessageId", mbThread.getRootMessageId()));
            messageQuery.setLimit(0, 4);

            List<Long> userIds = MBMessageLocalServiceUtil.dynamicQuery(messageQuery);

            DynamicQuery usersQuery = UserLocalServiceUtil.dynamicQuery();
            usersQuery.add(RestrictionsFactoryUtil.in("userId", userIds));

            renderRequest.setAttribute("users", UserLocalServiceUtil.dynamicQuery(usersQuery));
        } catch (Exception e) {
            System.out.println("Error en getInteractingUsers:");
            e.printStackTrace();
        }
    }

    private Long parseId(String id) {
        try {
            return Long.parseLong(id);
        } catch (NumberFormatException e) {
            return 0L;
        }
    }
}