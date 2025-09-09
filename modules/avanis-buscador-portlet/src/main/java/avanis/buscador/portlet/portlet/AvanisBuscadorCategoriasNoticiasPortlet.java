package avanis.buscador.portlet.portlet;

import avanis.buscador.portlet.constants.AvanisBuscadorPortletKeys;
import avanis.buscador.portlet.utils.NoticiasUtils;
import avanis.buscador.portlet.vo.Noticia;
import avanis.utils.api.util.CategoriasUtils;
import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.service.AssetCategoryLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author VictorAntunez
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=avanis",
		"com.liferay.portlet.header-portlet-css=/css/noticias/noticias.css",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=Avanis Buscador Categorias Noticias",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/noticias/viewCategorias.jsp",
		"javax.portlet.name=" + AvanisBuscadorPortletKeys.AVANISBUSCADORNOTICIASCATEGORIAS,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AvanisBuscadorCategoriasNoticiasPortlet extends MVCPortlet {
	private static final Log _log = LogFactoryUtil.getLog(AvanisBuscadorCategoriasNoticiasPortlet.class);

	@Reference
	private NoticiasUtils _noticiasUtils;

	@Reference
	private CategoriasUtils _categoriasUtils;

	@Reference
	private AssetCategoryLocalService _assetCategoryLocalService;

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		String fullURL = themeDisplay.getURLCurrent();
		String friendlyURL = themeDisplay.getLayout().getFriendlyURL();

		_log.debug("URL Completa: " + fullURL);
		_log.debug("Friendly URL: " + friendlyURL);

		String category = null;
		String categoryAux = null;
		String[] urlSegments = friendlyURL.split("/");
		if (urlSegments.length > 3) {
			category = urlSegments[3];
			categoryAux = urlSegments[2];
			categoryAux = categoryAux.replace("-", " ");
			categoryAux = categoryAux.substring(0, 1).toUpperCase() + categoryAux.substring(1);
		} else if (urlSegments.length > 2) {
			category = urlSegments[2];
		}

		if (category != null) {
			category = category.replace("-", " ");
			category = category.substring(0, 1).toUpperCase() + category.substring(1);
		}

		category = _noticiasUtils.normalizeText(category);

		AssetCategory categoriaPadre = null;
		List<AssetCategory> rootCategories = null;

		if (urlSegments.length > 3) {
			List<AssetCategory> categoriasAux = _assetCategoryLocalService.getVocabularyRootCategories(_categoriasUtils.getVocabularioAvanis(), -1, -1, null);
			for (AssetCategory rootCategory : categoriasAux) {
				if (_noticiasUtils.normalizeText(rootCategory.getName()).equalsIgnoreCase(categoryAux)) {
					rootCategories = _assetCategoryLocalService.getChildCategories(rootCategory.getCategoryId());
					renderRequest.setAttribute("categoriaPrincipal", rootCategory.getName());
					break;
				}
			}
		} else if (urlSegments.length > 2) {
			rootCategories = _assetCategoryLocalService.getVocabularyRootCategories(_categoriasUtils.getVocabularioAvanis(), -1, -1, null);
		}

		for (AssetCategory rootCategory : rootCategories) {
			if (_noticiasUtils.normalizeText(rootCategory.getName()).equalsIgnoreCase(category)) {
				categoriaPadre = rootCategory;
				break;
			}
		}

		if (categoriaPadre == null) {
			renderRequest.setAttribute("listaNoticias", new ArrayList<>());
			renderRequest.setAttribute("totalBlogs", 0);
			return;
		}

		_log.debug("categoriaPadre detectada: " + categoriaPadre.getName() + " " + categoriaPadre.getCategoryId());
		renderRequest.setAttribute("categoriaPadre", categoriaPadre.getCategoryId());
		renderRequest.setAttribute("categoria", categoriaPadre.getName());

		List<Long> categoryIds = new ArrayList<>();
		categoryIds.add(categoriaPadre.getCategoryId());

		List<AssetCategory> childCategories = _assetCategoryLocalService.getChildCategories(categoriaPadre.getCategoryId());
		renderRequest.setAttribute("categoriasHijasSize", childCategories.size());
		for (AssetCategory childCategory : childCategories) {
			categoryIds.add(childCategory.getCategoryId());
		}

		String categoryIdsString = categoryIds.stream()
				.map(String::valueOf)
				.collect(Collectors.joining(","));
		_log.debug("Categorías para búsqueda: " + categoryIdsString);
		renderRequest.setAttribute("categoryIds", categoryIdsString);

		List<Noticia> noticias = _noticiasUtils.getNoticiasPorCategorias(themeDisplay, categoryIds);
		int totalNoticias = noticias.size();
		int start = ParamUtil.getInteger(renderRequest, "start", 0);
		int end = ParamUtil.getInteger(renderRequest, "end", 6);

		List<Noticia> noticiasPaginadas = noticias.subList(
				Math.min(start, totalNoticias),
				Math.min(end, totalNoticias)
		);

		renderRequest.setAttribute("listaNoticias", noticiasPaginadas);
		renderRequest.setAttribute("totalBlogs", totalNoticias);
		renderRequest.setAttribute("urlPortal", themeDisplay.getURLPortal());
		renderRequest.setAttribute("start", start);
		renderRequest.setAttribute("end", end);
		renderRequest.setAttribute("mostrarTitulos", _categoriasUtils.mostrarTitulosBuscador());

		super.doView(renderRequest, renderResponse);
	}
}