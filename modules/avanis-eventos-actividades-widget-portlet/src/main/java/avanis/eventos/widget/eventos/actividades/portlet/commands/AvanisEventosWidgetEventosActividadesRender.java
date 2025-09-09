package avanis.eventos.widget.eventos.actividades.portlet.commands;

import avanis.eventos.widget.eventos.actividades.resource.BookingsHandlerResource;
import com.liferay.calendar.exception.NoSuchResourceException;
import com.liferay.calendar.model.Calendar;
import com.liferay.calendar.model.CalendarResource;
import com.liferay.calendar.service.CalendarBookingService;
import com.liferay.calendar.service.CalendarLocalService;
import com.liferay.calendar.service.CalendarResourceService;
import com.liferay.calendar.service.CalendarService;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import avanis.eventos.widget.eventos.actividades.util.AvanisEventUtil;

import avanis.eventos.widget.eventos.actividades.constants.AvanisEventosWidgetEventosActividadesPortletKeys;

@Component(property = {
		"javax.portlet.name=" + AvanisEventosWidgetEventosActividadesPortletKeys.AVANISEVENTOSWIDGETEVENTOSACTIVIDADES,
		"mvc.command.name="	+ AvanisEventosWidgetEventosActividadesPortletKeys.AVANISEVENTOSWIDGETEVENTOSACTIVIDADES_RENDER },
		service = MVCRenderCommand.class)
public class AvanisEventosWidgetEventosActividadesRender implements MVCRenderCommand {

	@Reference
	private CalendarLocalService _calendarLocalService;

	@Reference
	private CalendarService _calendarService;

	@Reference
	private CalendarBookingService _calendarBookingService;

	@Reference
	private CalendarResourceService _calendarResourceService;

	@Reference
	private CalendarBookingService _calendarBookingLocalService;

	private Log log = LogFactoryUtil.getLog(AvanisEventosWidgetEventosActividadesRender.class);

	private static final String JSP = "/view.jsp";
	private static final String FORM_DATA = "formData";

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		Calendar calendar = null;
		CalendarResource calendarResource = null;
		try {
			calendar = _getCalendar(renderRequest);
			calendarResource = _getCalendarResource(renderRequest);

		} catch (Exception exception) {
			if (exception instanceof NoSuchResourceException || exception instanceof PrincipalException) {

				SessionErrors.add(renderRequest, exception.getClass());
			} else {
				throw new PortletException(exception);
			}
		}
		renderRequest.setAttribute(AvanisEventosWidgetEventosActividadesPortletKeys.CALENDAR, calendar);
		renderRequest.setAttribute(AvanisEventosWidgetEventosActividadesPortletKeys.CALENDAR_RESOURCE,
				calendarResource);
		return JSP;
	}

	private Calendar _getCalendar(PortletRequest portletRequest) throws Exception {
		long calendarId = ParamUtil.getLong(portletRequest, "calendarId");

		if (calendarId <= 0) {
			return null;
		}

		/*
		 * portletRequest.setAttribute(
		 * AvanisEventosWidgetEventosActividadesPortletKeys.CALENDAR,
		 * _calendarService.getCalendar(calendarId));
		 */

		return _calendarService.getCalendar(calendarId);
	}

	private CalendarResource _getCalendarResource(PortletRequest portletRequest) throws Exception {

		long calendarResourceId = ParamUtil.getLong(portletRequest, "calendarResourceId");

		long classNameId = ParamUtil.getLong(portletRequest, "classNameId");
		long classPK = ParamUtil.getLong(portletRequest, "classPK");

		CalendarResource calendarResource = null;

		if (calendarResourceId > 0) {
			calendarResource = _calendarResourceService.getCalendarResource(calendarResourceId);
		} else if ((classNameId > 0) && (classPK > 0)) {
			calendarResource = BookingsHandlerResource.getCalendarResource(portletRequest, classNameId, classPK);
		}

		return calendarResource;
	}

	// @Override
	public String renderWithFilter(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		JSONObject formData = null;
		String formDataStr = ParamUtil.get(renderRequest, FORM_DATA, StringPool.BLANK);

		if (!Validator.isBlank(formDataStr)) {

			try {
				formData = JSONFactoryUtil.createJSONObject(formDataStr);
			} catch (JSONException e) {
				log.error("cannot parse params to json ", e);
			}
		}

		// FilterEventParams filterEventParams = new FilterEventParams();

		try {
			// FilterEventParams = getBaleariaSearcherParams(renderRequest);
		} catch (Exception e1) {
			log.error("Cannot get baleariaSearcherParams ", e1);
		}

		if (formData != null) {

			renderRequest.getPortletSession(true).setAttribute("LIFERAY_SHARED_" + "baleariaSearcherParamsJSON",
					formData, PortletSession.APPLICATION_SCOPE);
		}

		// renderRequest.setAttribute("filterEventParams", baleariaSearcherParams);

		return JSP;
	}

	// @Reference
	// FilterEventRenderService filterEventRenderService;
}
