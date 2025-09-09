package avanis.noticias.relacionadas.portlet.portlet;

import avanis.noticias.relacionadas.portlet.constants.AvanisNoticiasRelacionadasPortletKeys;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.blogs.model.BlogsEntry;
import com.liferay.blogs.service.BlogsEntryLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author davidhorreo y jblasco
 */
@Component(
	property = {
		"com.liferay.portlet.display-category=avanis",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=AvanisNoticiasRelacionadas",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + AvanisNoticiasRelacionadasPortletKeys.AVANISNOTICIASRELACIONADAS,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AvanisNoticiasRelacionadasPortlet extends MVCPortlet {
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        try {

			BlogsEntry blogEntry = BlogsEntryLocalServiceUtil.getEntry(themeDisplay.getScopeGroupId(),
																		getTitleByUrl(themeDisplay.getURLCurrent()));
			Map<BlogsEntry, Integer> mapRelacionsCategoryByOrdenado = getBlogsEntryRelacionsByCategory(blogEntry, 4);
			List<BlogsEntry> sortedEntriesRelacionsCategory = new ArrayList<>(mapRelacionsCategoryByOrdenado.keySet());
			HashMap<Long,String> urlstitlesMap = new HashMap<>();
			sortedEntriesRelacionsCategory.forEach(entry -> urlstitlesMap.put(entry.getEntryId(), entry.getUrlTitle()));

			renderRequest.setAttribute("blogsUrl", urlstitlesMap);
			renderRequest.setAttribute("blogs", sortedEntriesRelacionsCategory);

        } catch (PortalException e) {
            throw new RuntimeException(e);
        }

        super.doView(renderRequest, renderResponse);
	}

	private static Map<Long, String> getDatesByEntriesblogRelacionsCategory(List<BlogsEntry> sortedEntriesRelacionsCategory) {
		Map<Long, String> blogEntryDatesMap = new HashMap<>();

		for (BlogsEntry tmp : sortedEntriesRelacionsCategory) {

			Date publishDate = tmp.getDisplayDate();
			// Formatear la fecha
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy - HH:mm:ss");
			String formattedDate = dateFormat.format(publishDate);
			blogEntryDatesMap.put(tmp.getEntryId(),formattedDate);
		}
		return blogEntryDatesMap;
	}

	public static String getTitleByUrl(String url) {
		if (url == null || url.isEmpty()) {
			return null;
		}
		String[] parts = url.split(StringPool.SLASH);
		// Devolver la última parte de la cadena
		String subCadena = parts[parts.length - 1];
		if(parts[parts.length - 1].contains(StringPool.QUESTION)){
			String[] partstmp = subCadena.split("\\?");
			subCadena = partstmp[0];
		}
		return subCadena;
	}

	private static Map<BlogsEntry, Integer> getBlogsEntryRelacionsByCategory(BlogsEntry blogEntry, int maxElements) throws PortalException {

		List<AssetCategory> myAssetEntryCategories = AssetEntryLocalServiceUtil.fetchEntry(BlogsEntry.class.getName(), blogEntry.getEntryId()).getCategories();
		Map<BlogsEntry, Integer> mapRelacionsCategory = new HashMap<BlogsEntry, Integer>();
		List<BlogsEntry> allEntryBlog = BlogsEntryLocalServiceUtil.getBlogsEntries(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		// Iterar sobre todos los BlogsEntry
		for (BlogsEntry entry : allEntryBlog) {
			// Saltar el BlogEntry actual
			if (entry.equals(blogEntry)) {
				continue;
			}
			// Obtener las categorías del BlogEntry actual
			AssetEntry tempAssetEntry = AssetEntryLocalServiceUtil.fetchEntry(BlogsEntry.class.getName(), entry.getEntryId());

			// Contar las categorías que coinciden
			int matchingCategoriesCount = 0;
			for (AssetCategory category : tempAssetEntry.getCategories()) {
				if (myAssetEntryCategories.contains(category)) {
					matchingCategoriesCount++;
				}
			}
			// Agregar el BlogEntry y su numero de coincidencias a la lista
			if (matchingCategoriesCount > 0) {
				mapRelacionsCategory.put(entry, matchingCategoriesCount);
			}
		}
		// Ordenar los BlogsEntry por numero de coincidencias en orden descendente
		Map<BlogsEntry, Integer> mapRelacionsCategoryByOrdenado = getSortedRelacionsCategoryMax4(mapRelacionsCategory, maxElements);

		return mapRelacionsCategoryByOrdenado;
	}

	private static Map<BlogsEntry, Integer> getSortedRelacionsCategoryMax4(Map<BlogsEntry, Integer> mapRelacionsCategory, int maxElements) {
		Map<BlogsEntry, Integer> mapRelacionsCategoryByOrdenado = mapRelacionsCategory.entrySet()
				.stream()
				.sorted(Map.Entry.<BlogsEntry, Integer>comparingByValue().reversed())
				.limit(maxElements) // Limitar a los primeros N elementos
				.collect(Collectors.toMap(
						Map.Entry::getKey,
						Map.Entry::getValue,
						(e1, e2) -> e1,
						LinkedHashMap::new
				));
		return mapRelacionsCategoryByOrdenado;
	}
}