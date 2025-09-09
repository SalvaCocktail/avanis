package avanis.compartir.widget.portlet;

import avanis.compartir.widget.constants.AvanisCompartirWidgetPortletKeys;
import com.liferay.calendar.model.CalendarBooking;
import com.liferay.calendar.service.CalendarBookingLocalServiceUtil;
import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.dynamic.data.mapping.model.DDMTemplate;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.model.JournalArticleDisplay;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.*;
import org.osgi.service.component.annotations.Component;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Antonio Ruiz Hervas
 */
@Component(
	property = {
        "com.liferay.portlet.css-class-wrapper=avanis-compartir-widget-portlet",
		"com.liferay.portlet.display-category=avanis",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"com.liferay.portlet.add-default-resource=true",
		"javax.portlet.display-name=AvanisCompartirWidget",
		"javax.portlet.expiration-cache=0",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + AvanisCompartirWidgetPortletKeys.AVANISCOMPARTIRWIDGET,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.supported-public-render-parameter=tag",
		"javax.portlet.security-role-ref=power-user,user",
        "javax.portlet.version=3.0"
	},
	service = Portlet.class
)
public class AvanisCompartirWidgetPortlet extends MVCPortlet {

	private static final String VIEW_TEMPLATE = "/view.jsp";
	private static final String VIEW_POPUP_TEMPLATE = "/view_popup.jsp";

	private static final String _BODY_TEMPLATE = "<div class=\"eventos-widget-popup\"><div class=\"div_left\"><img src=\"[$EVENT_IMAGE$]\"></div><div class=\"av-ac-nd__right\"><div class=\"av-ac-nd__text\">[$EVENT_NAME$]</div><div class=\"av-ac-nd__date\">[$EVENT_DATE$]</div><div class=\"av-ac-nd__date\">[$EVENT_LOCATION$]</div><div class=\"av-ac-nd__date\">[$EVENT_HOUR$]</div></div></div>";
	private static final String[] _BODY_REPLACEMENTS = new String[]{"[$EVENT_NAME$]", "[$EVENT_LOCATION$]", "[$EVENT_DATE$]", "[$EVENT_HOUR$]", "[$EVENT_IMAGE$]"};

	private static final Log _log = LogFactoryUtil.getLog(AvanisCompartirWidgetPortlet.class);

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String cmd = ParamUtil.getString(renderRequest, Constants.CMD);

		String resourceName = renderRequest.getRenderParameters().getValue("resourceName");
		String resourceId = renderRequest.getRenderParameters().getValue("resourceId");
		String journalTitle = renderRequest.getRenderParameters().getValue("journalTitle");
		renderRequest.setAttribute("resourceName", resourceName);
		renderRequest.setAttribute("resourceId", resourceId);
		renderRequest.setAttribute("journalTitle", journalTitle);

		String url = renderRequest.getRenderParameters().getValue("url");
		if (url != null && !url.isBlank()) {
			renderRequest.setAttribute("url", url);
		} else {
			renderRequest.setAttribute("url", themeDisplay.getPortalURL() + themeDisplay.getURLCurrent());
		}

		try {
			User user = UserLocalServiceUtil.getUser(themeDisplay.getUserId());
			renderRequest.setAttribute("usermail", user.getEmailAddress());
		} catch (PortalException e) {
			throw new RuntimeException(e);
		}

		if ("view_popup".equals(cmd)) {
			//String isFromDetail = ParamUtil.getString(renderRequest, "isFromDetail");
			//renderRequest.setAttribute("isFromDetail", isFromDetail);
			if("AyudasSubvenciones".equals(resourceName)) {
				String template = ParamUtil.getString(renderRequest, "template");
				if (Validator.isNull(template)) {
					template = "STR_AYUDAS_SUBVENCIONES_POPUP";
				}
				JournalArticle ja_ = null;
				try {
					ja_ = JournalArticleLocalServiceUtil.getArticle(themeDisplay.getScopeGroupId(), resourceId);
				} catch (PortalException e) {
					_log.error("JournalArticle " + resourceId + " does not exist.");
				}
				if (ja_ != null) {
					JournalArticleDisplay jaDisplay = null;
					try {
						DDMStructure dDMStructure = ja_.getDDMStructure();
						List<DDMTemplate> templateList = dDMStructure.getTemplates();
						DDMTemplate dDMTemplate = ja_.getDDMTemplate();
						for (DDMTemplate dDMTemplateSearch : templateList) {
							if (template.equals(dDMTemplateSearch.getName(themeDisplay.getLocale()))) {
								dDMTemplate = dDMTemplateSearch;
							}
						}
						jaDisplay = JournalArticleLocalServiceUtil.getArticleDisplay(themeDisplay.getScopeGroupId(), ja_.getArticleId(), dDMTemplate.getTemplateKey(), "VIEW", themeDisplay.getLanguageId(), themeDisplay);
					} catch (PortalException e) {
						_log.error("JournalArticleDisplay " + resourceId + " and template " + template + " does not exist.");
					}
					if (Validator.isNotNull(jaDisplay)) {
						template = jaDisplay.getDDMTemplateKey();
						String content = jaDisplay.getContent();
						if (Validator.isNotNull(content)) {
							renderRequest.setAttribute("content", content);
						}
					}
				}
			} else if("Eventos".equals(resourceName)){
				CalendarBooking calendarBooking = CalendarBookingLocalServiceUtil.fetchCalendarBooking(Long.parseLong(resourceId));
				if(Validator.isNotNull(calendarBooking)){
					DateFormat textDateFormat = new SimpleDateFormat("EEEEE dd", themeDisplay.getLocale());
					DateFormat monthDateFormat = new SimpleDateFormat("MMMMM", themeDisplay.getLocale());
					DateFormat yearDateFormat = new SimpleDateFormat("yyyy", themeDisplay.getLocale());
					DateFormat timeFormat = new SimpleDateFormat("hh:mm a", themeDisplay.getLocale());

					String eventName = calendarBooking.getTitle(themeDisplay.getLocale());
					String eventLocation = calendarBooking.getLocation();
					if(Validator.isNull(eventLocation)){
						eventLocation = "Por definir";
					}
					String eventDate = "";
					String startTextDateEvent = textDateFormat.format(new Date(calendarBooking.getStartTime()));
					String endTextDateEvent = textDateFormat.format(new Date(calendarBooking.getEndTime()));
					String startMonthDateEvent = monthDateFormat.format(new Date(calendarBooking.getStartTime()));
					String endMonthDateEvent = monthDateFormat.format(new Date(calendarBooking.getEndTime()));
					String startYearDateEvent = yearDateFormat.format(new Date(calendarBooking.getStartTime()));
					String endYearDateEvent = yearDateFormat.format(new Date(calendarBooking.getEndTime()));

					if(!startYearDateEvent.equals(endYearDateEvent)){
						eventDate = "Del " + startTextDateEvent + " de " + startMonthDateEvent + " de " + startYearDateEvent + " al " + endTextDateEvent + " de " + startMonthDateEvent + " de " + startYearDateEvent;
					} else if(!startMonthDateEvent.equals(endMonthDateEvent)) {
						eventDate = "Del " + startTextDateEvent + " de " + startMonthDateEvent + " al " + endTextDateEvent + " de " + startMonthDateEvent + " de " + startYearDateEvent;
					} else if(!startTextDateEvent.equals(endTextDateEvent)) {
						eventDate = "Del " + startTextDateEvent + " al " + endTextDateEvent + " de " + startMonthDateEvent + " de " + startYearDateEvent;
					} else {
						eventDate = startTextDateEvent.substring(0, 1).toUpperCase() + startTextDateEvent.substring(1) + " de " + startMonthDateEvent + " de " + startYearDateEvent;
					}

					String eventHour = "";
					if(calendarBooking.isAllDay()){
						eventHour = "Todo el día";
					} else {

						String startHourEvent = timeFormat.format(new Date(calendarBooking.getStartTime()));
						String endHourEvent = timeFormat.format(new Date(calendarBooking.getEndTime()));
						eventHour = startHourEvent + " - " + endHourEvent;
						eventHour = eventHour.replace("a. m.", "am");
						eventHour = eventHour.replace("p. m.", "pm");
					}

					String eventImage = getEventImageURL(calendarBooking);

					renderRequest.setAttribute("eventName", eventName);
					renderRequest.setAttribute("eventLocation", eventLocation);
					renderRequest.setAttribute("eventDate", eventDate);
					renderRequest.setAttribute("eventHour", eventHour);
					renderRequest.setAttribute("eventImage", eventImage);

					String script = _BODY_TEMPLATE;
					if(Validator.isNotNull(journalTitle)){
						JournalArticle ja_ = null;
						try {
							ja_ = JournalArticleLocalServiceUtil.getArticleByUrlTitle(themeDisplay.getScopeGroupId(), journalTitle);
						} catch (PortalException e) {
							_log.error("JournalArticle " + resourceId + " does not exist.");
						}
						if(ja_ != null){
							DDMTemplate dDMtemplate = ja_.getDDMTemplate();
							script = dDMtemplate.getScript();
						}
					}

					String content = StringUtil.replace(script, _BODY_REPLACEMENTS, new String[]{eventName, eventLocation, eventDate, eventHour, eventImage});
					renderRequest.setAttribute("content", content);
				}
            }
			include(VIEW_POPUP_TEMPLATE, renderRequest, renderResponse);
		} else {
			include(VIEW_TEMPLATE, renderRequest, renderResponse);
		}
	}

	private static String getEventImageURL(CalendarBooking calendarBooking) {
		ExpandoBridge expandoBridge = calendarBooking.getExpandoBridge();
		String eventImage = "";
		String eventImageURL = (String) expandoBridge.getAttribute("event_image_url");

		if (eventImageURL != null) {
			eventImage = eventImageURL;
		}
		return eventImage;
	}
}
