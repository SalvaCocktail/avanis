package avanis.hilo.actualidad.portlet.portlet;

import avanis.hilo.actualidad.portlet.constants.AvanisHiloActualidadPortletKeys;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.asset.link.model.AssetLink;
import com.liferay.asset.link.service.AssetLinkLocalServiceUtil;
import com.liferay.blogs.model.BlogsEntry;
import com.liferay.blogs.service.BlogsEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jesusblasco
 */
@Component(
	property = {
		"com.liferay.portlet.display-category=avanis",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=AvanisHiloActualidad",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + AvanisHiloActualidadPortletKeys.AVANISHILOACTUALIDAD,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AvanisHiloActualidadPortlet extends MVCPortlet {

	private static Log _log = LogFactoryUtil.getLog(AvanisHiloActualidadPortlet.class);

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		// Obtener la entrada de blog
		BlogsEntry blogEntry = null;
		try {
			blogEntry = BlogsEntryLocalServiceUtil.getEntry(themeDisplay.getScopeGroupId(),
					getTitleByUrl(themeDisplay.getURLCurrent()));

			// Obtén la entrada de activo correspondiente a la entrada de blog
			AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(
					BlogsEntry.class.getName(), blogEntry.getEntryId());

			if (assetEntry != null) {
				// Obtén los enlaces de activos asociados
				List<AssetEntry> associatedAssetEntries =  new ArrayList<>();
				List<AssetLink> assetLinks = AssetLinkLocalServiceUtil.getLinks(assetEntry.getEntryId());
				if (assetLinks != null && !assetLinks.isEmpty()) {
					for (AssetLink assetLink : assetLinks) {
						AssetEntry tempAssetEntry = AssetEntryLocalServiceUtil.getAssetEntry(assetLink.getEntryId2());
						if (tempAssetEntry.getClassName().equals("com.liferay.message.boards.model.MBMessage") ||
								themeDisplay.getLayout().getName(themeDisplay.getLocale()).equals("actualidad")){
							associatedAssetEntries.add(AssetEntryLocalServiceUtil.getAssetEntry(assetLink.getEntryId2()));
						} else if (tempAssetEntry.getClassName().equals("com.liferay.blogs.model.BlogsEntry") ||
								themeDisplay.getLayout().getName(themeDisplay.getLocale()).equals("comunidad")) {
							associatedAssetEntries.add(AssetEntryLocalServiceUtil.getAssetEntry(assetLink.getEntryId2()));
						}
					}
				// Pasa la lista de enlaces a la solicitud
				renderRequest.setAttribute("assetLinks", assetLinks);
				}

				//TODO: FALTA OBTENER LA URL Y ENVIARLA AL JSP
				//for (AssetEntry assetEntryassociado : associatedAssetEntries) {
				//	MBMessageLocalServiceUtil.getMessage(assetEntryassociado.getClassPK());
					//MBMessageLocalServiceUtil.getMessage(assetEntryassociado.getClassPK())
					//_log.info(MBMessageLocalServiceUtil.getMessage(assetEntryassociado.getClassPK()));
				//}
			}

		} catch (PortalException e) {
			throw new RuntimeException(e);
		}

		super.doView(renderRequest, renderResponse);

	}

	public static String getTitleByUrl(String url) {
		if (url == null || url.isEmpty()) {
			return null;
		}
		String[] parts = url.split("/");
		// Devolver la última parte de la cadena
		return parts[parts.length - 1];
	}
}

