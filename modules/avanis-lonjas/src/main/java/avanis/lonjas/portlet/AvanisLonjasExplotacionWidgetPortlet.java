package avanis.lonjas.portlet;

import avanis.lonjas.constants.AvanisLonjasPortletKeys;
import avanis.lonjas.util.LonjasUtil;
import avanis.lonjas.vo.InfoProducto;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
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
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=Avanis Lonjas Explotacion Widget ",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/viewExplotacion.jsp",
		"javax.portlet.name=" + AvanisLonjasPortletKeys.AVANISLONJASEXPLOTACIONWIDGET,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AvanisLonjasExplotacionWidgetPortlet extends MVCPortlet {

	@Reference
	private LonjasUtil _lonjasUtil;

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));

		long plotId = ParamUtil.getLong(httpReq, "plotId");
		long userId = themeDisplay.getUserId();
		boolean isLoggedIn = themeDisplay.isSignedIn();

		renderRequest.setAttribute("isLoggedIn", isLoggedIn);

		if (isLoggedIn) {
			long plotValido = _lonjasUtil.plotValidoUser(plotId, userId);
			if (Validator.isNotNull(plotValido)){
				renderRequest.setAttribute("plotId", plotValido);
				List<InfoProducto> productosPacela = _lonjasUtil.productosParcela(plotValido, userId);
				renderRequest.setAttribute("productosPacela", productosPacela);
			}
		}

		super.doView(renderRequest, renderResponse);
	}

}