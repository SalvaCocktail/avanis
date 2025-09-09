package avanis.eventos.widget.eventos.actividades.util;

import com.liferay.calendar.constants.CalendarActionKeys;
import com.liferay.calendar.model.CalendarBooking;
import com.liferay.calendar.model.CalendarResource;
import com.liferay.calendar.service.CalendarBookingService;
import com.liferay.calendar.service.CalendarResourceLocalService;
import com.liferay.calendar.service.CalendarService;
import com.liferay.calendar.util.JCalendarUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.service.WorkflowDefinitionLinkLocalService;
import com.liferay.portal.kernel.service.WorkflowInstanceLinkLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.TimeZoneUtil;

import java.util.*;

public class AvanisEventUtil extends com.liferay.calendar.util.CalendarResourceUtil {

	private static Log LOG = LogFactoryUtil.getLog(AvanisEventUtil.class);

	private static JSONObject _getPermissionsJSONObject(
			PermissionChecker permissionChecker, com.liferay.calendar.model.Calendar calendar)
			throws PortalException {

		ModelResourcePermission<com.liferay.calendar.model.Calendar> calendarModelResourcePermission =
				_calendarModelResourcePermissionSnapshot.get();

		return JSONUtil.put(
				ActionKeys.DELETE,
				calendarModelResourcePermission.contains(
						permissionChecker, calendar, ActionKeys.DELETE)
		).put(
				ActionKeys.PERMISSIONS,
				calendarModelResourcePermission.contains(
						permissionChecker, calendar, ActionKeys.PERMISSIONS)
		).put(
				ActionKeys.UPDATE,
				calendarModelResourcePermission.contains(
						permissionChecker, calendar, ActionKeys.UPDATE)
		).put(
				ActionKeys.VIEW,
				calendarModelResourcePermission.contains(
						permissionChecker, calendar, ActionKeys.VIEW)
		).put(
				CalendarActionKeys.MANAGE_BOOKINGS,
				calendarModelResourcePermission.contains(
						permissionChecker, calendar, CalendarActionKeys.MANAGE_BOOKINGS)
		).put(
				CalendarActionKeys.VIEW_BOOKING_DETAILS,
				calendarModelResourcePermission.contains(
						permissionChecker, calendar,
						CalendarActionKeys.VIEW_BOOKING_DETAILS)
		);
	}


	public static JSONArray toCalendarBookingsJSONArray(ThemeDisplay themeDisplay, List<CalendarBooking> calendarBookings)
			throws PortalException {
		TimeZone timeZone = TimeZoneUtil.getTimeZone(StringPool.UTC);
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		if (calendarBookings == null) {
			return jsonArray;
		}

		for (CalendarBooking calendarBooking : calendarBookings) {
			JSONObject jsonObject = toCalendarBookingJSONObject(
					themeDisplay, calendarBooking, timeZone);

			jsonArray.put(jsonObject);
		}

		return jsonArray;
	}


	public static JSONObject toCalendarBookingJSONObject(
			ThemeDisplay themeDisplay, CalendarBooking calendarBooking,
			TimeZone timeZone)
		throws PortalException {

		JSONObject jsonObject = JSONUtil.put(
			"allDay", calendarBooking.isAllDay()
		).put(
			"calendarBookingId", calendarBooking.getCalendarBookingId()
		).put(
			"calendarId", calendarBooking.getCalendarId()
		).put(
			"description",
			calendarBooking.getDescription(themeDisplay.getLocale())
		);

		java.util.Calendar endTimeJCalendar = JCalendarUtil.getJCalendar(
			calendarBooking.getEndTime(), timeZone);

		_addTimeProperties(jsonObject, "endTime", endTimeJCalendar);

		jsonObject.put(
			"firstReminder", calendarBooking.getFirstReminder()
		).put(
			"firstReminderType", calendarBooking.getFirstReminderType()
		).put(
			"hasChildCalendarBookings",
			() -> {
				List<CalendarBooking> childCalendarBookings =
					calendarBooking.getChildCalendarBookings();

				return childCalendarBookings.size() > 1;
			}
		).put(
			"instanceIndex", calendarBooking.getInstanceIndex()
		).put(
			"location", calendarBooking.getLocation()
		).put(
			"parentCalendarBookingId",
			calendarBooking.getParentCalendarBookingId()
		);

		java.util.Calendar startTimeJCalendar = JCalendarUtil.getJCalendar(
			calendarBooking.getStartTime(), timeZone);

		jsonObject.put(
			"recurringCalendarBookingId",
			calendarBooking.getRecurringCalendarBookingId()
		).put(
			"secondReminder", calendarBooking.getSecondReminder()
		).put(
			"secondReminderType", calendarBooking.getSecondReminder()
		);

		_addTimeProperties(jsonObject, "startTime", startTimeJCalendar);

		jsonObject.put(
			"status", calendarBooking.getStatus()
		).put(
			"title", calendarBooking.getTitle(themeDisplay.getLocale())
		);

		return jsonObject;
	}
	
	private static void _addTimeProperties(
			JSONObject jsonObject, String prefix, java.util.Calendar jCalendar) {

			jsonObject.put(
				prefix, jCalendar.getTimeInMillis()
			).put(
				prefix + "Day", jCalendar.get(java.util.Calendar.DAY_OF_MONTH)
			).put(
				prefix + "Hour", jCalendar.get(java.util.Calendar.HOUR_OF_DAY)
			).put(
				prefix + "Minute", jCalendar.get(java.util.Calendar.MINUTE)
			).put(
				prefix + "Month", jCalendar.get(java.util.Calendar.MONTH)
			).put(
				prefix + "Year", jCalendar.get(java.util.Calendar.YEAR)
			);
		}
	
	private static final Snapshot<CalendarBookingService>
			_calendarBookingServiceSnapshot = new Snapshot<>(
			CalendarUtil.class, CalendarBookingService.class);
	private static final Snapshot<ModelResourcePermission<com.liferay.calendar.model.Calendar>>
			_calendarModelResourcePermissionSnapshot = new Snapshot<>(
			CalendarUtil.class, Snapshot.cast(ModelResourcePermission.class),
			"(model.class.name=com.liferay.calendar.model.Calendar)");
	private static final Snapshot<CalendarResourceLocalService>
			_calendarResourceLocalServiceSnapshot = new Snapshot<>(
			CalendarUtil.class, CalendarResourceLocalService.class);
	private static final Snapshot<CalendarService> _calendarServiceSnapshot =
			new Snapshot<>(CalendarUtil.class, CalendarService.class);
	private static final Snapshot<WorkflowDefinitionLinkLocalService>
			_workflowDefinitionLinkLocalServiceSnapshot = new Snapshot<>(
			CalendarUtil.class, WorkflowDefinitionLinkLocalService.class);
	private static final Snapshot<WorkflowInstanceLinkLocalService>
			_workflowInstanceLinkLocalServiceSnapshot = new Snapshot<>(
			CalendarUtil.class, WorkflowInstanceLinkLocalService.class);

	public static long day2Millisecode(int days) {
		return days * 24 * 60 * 60 * 1000;
	}


}
