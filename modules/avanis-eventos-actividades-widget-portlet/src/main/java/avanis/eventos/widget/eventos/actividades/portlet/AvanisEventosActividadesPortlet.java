package avanis.eventos.widget.eventos.actividades.portlet;

import avanis.eventos.widget.eventos.actividades.constants.AvanisEventosWidgetEventosActividadesPortletKeys;
import avanis.eventos.widget.eventos.actividades.resource.BookingsHandlerResource;
import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetTag;
import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetTagLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetVocabularyLocalServiceUtil;
import com.liferay.calendar.model.Calendar;
import com.liferay.calendar.model.CalendarBooking;
import com.liferay.calendar.service.CalendarService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lahip
 */
@Component(
	property = {
		"com.liferay.portlet.display-category=category.avanis",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.footer-portlet-javascript=/js/functions.js",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=" + AvanisEventosWidgetEventosActividadesPortletKeys.AVANISEVENTOSACTIVIDADES,
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/viewGeneral.jsp",
		"javax.portlet.name=" + AvanisEventosWidgetEventosActividadesPortletKeys.AVANISEVENTOSACTIVIDADES,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.supported-public-render-parameter=tag",
		"javax.portlet.version=3.0"
	},
	service = Portlet.class)
public class AvanisEventosActividadesPortlet extends MVCPortlet {

	private static Log LOG = LogFactoryUtil.getLog(AvanisEventosActividadesPortlet.class);

	@Reference
	private CalendarService _calendarService;

	private static final String AGRICULTURE_CATEGORY_ERC = "430e1e1e-7616-44ad-a676-9ff31364353c";
	private static final String STOCKBREADING_CATEGORY_ERC = "942f8363-2b82-45ab-95c7-0a5d1a63c2e4";

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();

		try {
			// Lista de Calendarios
			List<CalendarBooking> calendarBookings = BookingsHandlerResource.getBookingList(renderRequest, renderResponse);

			//Todos los eventos se setean en la sesion del portlet
			renderRequest.getPortletSession().setAttribute(AvanisEventosWidgetEventosActividadesPortletKeys.ALL_EVENTS_LIST,  calendarBookings, PortletSession.PORTLET_SCOPE);

			//Eventos acotados
			if (calendarBookings.size() > 0 && calendarBookings.size() > 3) {
				calendarBookings = calendarBookings.subList(0, 3);
			}

			renderRequest.setAttribute(AvanisEventosWidgetEventosActividadesPortletKeys.CALENDAR_BOOKINGS, calendarBookings);


		} catch (Exception e) {
			//System.out.println("Exception:" + e);
		}

		String urlsessionGoogle = PropsUtil.get("google.login.url");
		renderRequest.setAttribute("urlsessionGoogle", urlsessionGoogle);

		loadPreferences(user, renderRequest);
		super.doView(renderRequest, renderResponse);

	}

	private Calendar _getCalendar(PortletRequest portletRequest) throws Exception {
		long calendarId = ParamUtil.getLong(portletRequest, "calendarId");

		if (calendarId <= 0) {
			return null;
		}

		return _calendarService.getCalendar(calendarId);
	}

	public void loadPreferences(User principal, PortletRequest portletRequest) {
		List<String> userAssetTags = AssetTagLocalServiceUtil.getTags(User.class.getName(), principal.getUserId()).stream().map(AssetTag::getName).map(String::toLowerCase).collect(Collectors.toList());
		List<AssetCategory> otherCategories = getGlobalCategory("avanis").stream().filter(assetCategory -> assetCategory.getParentCategoryId() == 0).collect(Collectors.toList());
		portletRequest.setAttribute("agricultureCategories", getGlobalSubcategories(AGRICULTURE_CATEGORY_ERC));
		portletRequest.setAttribute("stockbreadingCategories", getGlobalSubcategories(STOCKBREADING_CATEGORY_ERC));
		portletRequest.setAttribute("otherCategories", otherCategories);
		portletRequest.setAttribute("userInterests", userAssetTags);
	}

	private List<AssetCategory> getGlobalCategory(String vocabularyName) {
		long globalGroupId = 20119;
		AssetVocabulary vocabulary = null;
		try {
			vocabulary = AssetVocabularyLocalServiceUtil.getGroupVocabulary(globalGroupId, vocabularyName);
			return AssetCategoryLocalServiceUtil.getVocabularyCategories(
					vocabulary.getVocabularyId(), 0, Integer.MAX_VALUE, null
			);

		} catch (PortalException e) {
			return new ArrayList<>();
		}

	}

	private List<AssetCategory> getGlobalSubcategories(String externalReferenceCode) {

		try {
			long groupId = 20119; //Global group
			long parentCategoryId = AssetCategoryLocalServiceUtil.getAssetCategoryByExternalReferenceCode(externalReferenceCode, groupId).getCategoryId();

			return AssetCategoryLocalServiceUtil.getChildCategories(parentCategoryId);


		} catch (PortalException e) {
			return new ArrayList<>();
		}

	}
}