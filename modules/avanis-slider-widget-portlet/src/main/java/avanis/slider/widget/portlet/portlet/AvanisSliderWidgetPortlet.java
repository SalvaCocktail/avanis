package avanis.slider.widget.portlet.portlet;

import avanis.slider.widget.portlet.constants.AvanisSliderWidgetPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author Jaime Garcia
 */
@Component(
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=AvanisSliderWidget",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + AvanisSliderWidgetPortletKeys.AVANISSLIDERWIDGET,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AvanisSliderWidgetPortlet extends MVCPortlet {
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		String urlsessionGoogle = PropsUtil.get("google.login.url");
		renderRequest.setAttribute("urlsessionGoogle", urlsessionGoogle);
		super.doView(renderRequest, renderResponse);
	}
}