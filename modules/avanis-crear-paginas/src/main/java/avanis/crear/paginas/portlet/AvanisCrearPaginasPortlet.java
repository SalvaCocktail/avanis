package avanis.crear.paginas.portlet;

import avanis.crear.paginas.constants.AvanisCrearPaginasPortletKeys;
import avanis.utils.api.util.CategoriasUtils;
import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.service.AssetCategoryLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.LayoutConstants;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.LayoutLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author VictorAntunez
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=avanis",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Avanis Crear Paginas",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + AvanisCrearPaginasPortletKeys.AVANISCREARPAGINAS,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AvanisCrearPaginasPortlet extends MVCPortlet {
	private static final Log _log = LogFactoryUtil.getLog(AvanisCrearPaginasPortlet.class);

	@Reference
	private AssetCategoryLocalService _assetCategoryLocalService;

	@Reference
	private CategoriasUtils _categoriasUtils;

	@Reference
	private LayoutLocalService _layoutLocalService;

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getScopeGroupId();
		long userId = themeDisplay.getUserId();

		String actionName = actionRequest.getParameter(ActionRequest.ACTION_NAME);

		try {
			if ("crearPaginasPadre".equals(actionName)) {
				_crearPaginasPadre(groupId, userId);
			} else if ("crearPaginasHijas".equals(actionName)) {
				_crearPaginasHijas(groupId, userId);
			}
		} catch (Exception e) {
			_log.error("Error ejecutando la acción: " + actionName, e);
		}
	}

	private void _crearPaginasPadre(long groupId, long userId) throws PortalException {
		Layout parentPage = _getOrCreateParentPage(groupId, userId);

		String baseFriendlyURL = "/actualidad";

		List<AssetCategory> rootCategories = _assetCategoryLocalService.getVocabularyRootCategories(
				_categoriasUtils.getVocabularioAvanis(), -1, -1, null
		);

		for (AssetCategory category : rootCategories) {
			String pageName = generateFriendlyURL(category.getName());
			String friendlyURL = baseFriendlyURL + "/" + pageName;

			Layout existingPage = _layoutLocalService.fetchLayoutByFriendlyURL(groupId, false, friendlyURL);
			if (existingPage != null) {
				_log.info("La página para la categoría padre " + category.getName() + " ya existe: " + friendlyURL);
				continue;
			}

			Layout layout = _layoutLocalService.addLayout(
					userId, groupId, false, parentPage.getLayoutId(),
					category.getName(), category.getDescription(), StringPool.BLANK,
					LayoutConstants.TYPE_PORTLET, false, friendlyURL, new ServiceContext()
			);

			UnicodeProperties typeSettingsProperties = layout.getTypeSettingsProperties();
			typeSettingsProperties.setProperty("layout-template-id", "1_column");

			_layoutLocalService.updateLayout(layout);
			_log.info("Página creada para la categoría padre: " + category.getName() + " con diseño 1 columna y URL: " + friendlyURL);
		}
	}

	private void _crearPaginasHijas(long groupId, long userId) throws PortalException {
		String baseFriendlyURL = "/actualidad";

		List<AssetCategory> rootCategories = _assetCategoryLocalService.getVocabularyRootCategories(
				_categoriasUtils.getVocabularioAvanis(), -1, -1, null
		);

		for (AssetCategory rootCategory : rootCategories) {
			String pageName = generateFriendlyURL(rootCategory.getName());
			String parentFriendlyURL = baseFriendlyURL + "/" + pageName.toLowerCase().replace(" ", "-");
			Layout parentPage = _layoutLocalService.fetchLayoutByFriendlyURL(groupId, false, parentFriendlyURL);

			if (parentPage == null) {
				_log.warn("La página de la categoría raíz " + rootCategory.getName() + " no existe. No se pueden crear subcategorías.");
				continue;
			}

			List<AssetCategory> childCategories = _assetCategoryLocalService.getChildCategories(rootCategory.getCategoryId());

			for (AssetCategory childCategory : childCategories) {
				String childPageName = generateFriendlyURL(childCategory.getName());
				String friendlyURL = parentFriendlyURL + "/" + childPageName;

				Layout existingPage = _layoutLocalService.fetchLayoutByFriendlyURL(groupId, false, friendlyURL);
				if (existingPage != null) {
					_log.info("La página para la categoría hija " + childCategory.getName() + " ya existe: " + friendlyURL);
					continue;
				}

				Layout layout = _layoutLocalService.addLayout(
						userId, groupId, false, parentPage.getLayoutId(),
						childCategory.getName(), childCategory.getDescription(), StringPool.BLANK,
						LayoutConstants.TYPE_PORTLET, false, friendlyURL, new ServiceContext()
				);

				UnicodeProperties typeSettingsProperties = layout.getTypeSettingsProperties();
				typeSettingsProperties.setProperty("layout-template-id", "1_column");

				_layoutLocalService.updateLayout(layout);

				_log.info("Página creada para la categoría hija: " + childCategory.getName() + " con diseño 1 columna y URL: " + friendlyURL);
			}
		}
	}

	private Layout _getOrCreateParentPage(long groupId, long userId) throws PortalException {
		String parentPageFriendlyURL = "/actualidad";
		String parentPageName = "Actualidad";

		Layout parentPage = _layoutLocalService.fetchLayoutByFriendlyURL(groupId, false, parentPageFriendlyURL);

		if (parentPage == null) {
			parentPage = _layoutLocalService.addLayout(
					userId, groupId, false, LayoutConstants.DEFAULT_PARENT_LAYOUT_ID,
					parentPageName, "Página principal de Actualidad", StringPool.BLANK,
					LayoutConstants.TYPE_PORTLET, false, parentPageFriendlyURL, new ServiceContext()
			);

			UnicodeProperties typeSettingsProperties = parentPage.getTypeSettingsProperties();
			typeSettingsProperties.setProperty("layout-template-id", "1_column");
			_layoutLocalService.updateLayout(parentPage);

			_log.info("Página principal 'Actualidad' creada con diseño 1 columna y URL: " + parentPageFriendlyURL);
		}

		return parentPage;
	}

	private String generateFriendlyURL(String name) {
		String normalized = java.text.Normalizer.normalize(name, java.text.Normalizer.Form.NFD);
		String sanitized = normalized.replaceAll("[^\\p{ASCII}]", "");
		return sanitized.toLowerCase().replace(" ", "-");
	}
}