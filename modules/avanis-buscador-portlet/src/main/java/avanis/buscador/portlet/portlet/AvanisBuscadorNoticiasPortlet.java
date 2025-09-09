package avanis.buscador.portlet.portlet;

import avanis.buscador.portlet.constants.AvanisBuscadorPortletKeys;
import avanis.buscador.portlet.utils.NoticiasUtils;
import avanis.buscador.portlet.vo.Noticia;
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
import java.util.List;

/**
 * @author VictorAntunez
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=avanis",
		"com.liferay.portlet.header-portlet-css=/css/noticias/noticias.css",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=Avanis Buscador Noticias",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/noticias/view.jsp",
		"javax.portlet.name=" + AvanisBuscadorPortletKeys.AVANISBUSCADORNOTICIAS,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AvanisBuscadorNoticiasPortlet extends MVCPortlet {
	private static final Log _log = LogFactoryUtil.getLog(AvanisBuscadorNoticiasPortlet.class);

	@Reference
	private NoticiasUtils _noticiasUtils;

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		int start = ParamUtil.getInteger(renderRequest, "start", 0);
		int end = ParamUtil.getInteger(renderRequest, "end", 6);

		List<Noticia> noticias = _noticiasUtils.getNoticiasPaginadas(themeDisplay, start, end);
		renderRequest.setAttribute("listaNoticias", noticias);
		renderRequest.setAttribute("totalBlogs", _noticiasUtils.getTotalBlogsCount());
		renderRequest.setAttribute("urlPortal", themeDisplay.getURLPortal());
		renderRequest.setAttribute("start", start);
		renderRequest.setAttribute("end", end);

		super.doView(renderRequest, renderResponse);
	}


}