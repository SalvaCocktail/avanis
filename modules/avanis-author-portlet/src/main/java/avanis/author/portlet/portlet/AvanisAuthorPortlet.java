package avanis.author.portlet.portlet;

import avanis.author.portlet.constants.AvanisAuthorPortletKeys;

import com.liferay.blogs.model.BlogsEntry;
import com.liferay.blogs.service.BlogsEntryLocalService;
import com.liferay.blogs.service.BlogsEntryLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author angelperez
 */
@Component(
	property = {
		"com.liferay.portlet.display-category=avanis",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=AvanisAuthor",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + AvanisAuthorPortletKeys.AVANISAUTHOR,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AvanisAuthorPortlet extends MVCPortlet {

	private static Log _log = LogFactoryUtil.getLog(AvanisAuthorPortlet.class);


	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		// Obtener el ID del usuario desde el ThemeDisplay
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();

		// Obtener las publicaciones de blog del usuario
		List<BlogsEntry> blogEntries = _blogsEntryLocalService.getBlogsEntries(QueryUtil.ALL_POS,QueryUtil.ALL_POS);
		List<BlogsEntry> userEntries = new ArrayList<>();
		for(BlogsEntry entry :blogEntries) {
			if (entry.getUserId() == userId)
			userEntries.add(entry);
		}
		// Añadir las publicaciones al request
		renderRequest.setAttribute("userEntries", userEntries);

		super.doView(renderRequest, renderResponse);
	}

	@Reference
	BlogsEntryLocalService _blogsEntryLocalService;
}