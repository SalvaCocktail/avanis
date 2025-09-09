<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib prefix="liferay-frontend" uri="http://liferay.com/tld/frontend" %>
<%@ taglib prefix="liferay-security" uri="http://liferay.com/tld/security" %>
<%@ taglib prefix="clay" uri="http://liferay.com/tld/clay" %>
<%@ taglib uri="http://liferay.com/tld/expando" prefix="liferay-expando" %>
<%@	page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="com.liferay.asset.kernel.model.AssetEntry"%>
<%@ page import="com.liferay.asset.kernel.model.AssetVocabularyConstants"%>
<%@ page import="com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil"%>
<%@ page import="com.liferay.calendar.configuration.CalendarServiceConfigurationValues"%>
<%@ page import="com.liferay.calendar.constants.CalendarActionKeys"%>
<%@ page import="com.liferay.calendar.constants.CalendarConstants"%>
<%@ page import="com.liferay.calendar.constants.CalendarNotificationTemplateConstants"%>
<%@ page import="com.liferay.calendar.exception.CalendarBookingDurationException"%>
<%@ page import="com.liferay.calendar.exception.CalendarBookingRecurrenceException"%>
<%@ page import="com.liferay.calendar.exception.CalendarNameException"%>
<%@ page import="com.liferay.calendar.exception.CalendarResourceCodeException"%>
<%@ page import="com.liferay.calendar.exception.CalendarResourceNameException"%>
<%@ page import="com.liferay.calendar.exception.DuplicateCalendarResourceException"%>
<%@ page import="com.liferay.calendar.exception.NoSuchResourceException"%>
<%@ page import="com.liferay.calendar.model.Calendar"%>
<%@ page import="com.liferay.calendar.model.CalendarBooking"%>
<%@ page import="com.liferay.calendar.model.CalendarNotificationTemplate"%>
<%@ page import="com.liferay.calendar.model.CalendarResource"%>
<%@ page import="com.liferay.calendar.notification.NotificationField"%>
<%@ page import="com.liferay.calendar.notification.NotificationTemplateType"%>
<%@ page import="com.liferay.calendar.notification.NotificationType"%>
<%@ page import="com.liferay.calendar.notification.NotificationUtil"%>
<%@ page import="com.liferay.calendar.recurrence.Frequency"%>
<%@ page import="com.liferay.calendar.recurrence.PositionalWeekday"%>
<%@ page import="com.liferay.calendar.recurrence.Recurrence"%>
<%@ page import="com.liferay.calendar.recurrence.Weekday"%>
<%@ page import="com.liferay.calendar.service.CalendarBookingLocalServiceUtil"%>
<%@ page import="com.liferay.calendar.service.CalendarBookingServiceUtil"%>
<%@ page import="com.liferay.calendar.service.CalendarNotificationTemplateLocalServiceUtil"%>
<%@ page import="com.liferay.calendar.service.CalendarServiceUtil"%>
<%@ page import="com.liferay.calendar.util.JCalendarUtil"%>
<%@ page import="com.liferay.calendar.util.RecurrenceUtil"%>
<%@ page import="com.liferay.calendar.util.comparator.CalendarNameComparator"%>
<%@ page import="com.liferay.calendar.workflow.constants.CalendarBookingWorkflowConstants"%>
<%@ page import="com.liferay.frontend.taglib.clay.servlet.taglib.util.JSPNavigationItemList"%>
<%@ page import="com.liferay.petra.string.StringBundler"%>
<%@ page import="com.liferay.petra.string.StringPool"%>
<%@ page import="com.liferay.portal.kernel.bean.BeanParamUtil"%>
<%@ page import="com.liferay.portal.kernel.bean.BeanPropertiesUtil"%>
<%@ page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@ page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@ page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@ page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@ page import="com.liferay.portal.kernel.json.JSONSerializer"%>
<%@ page import="com.liferay.portal.kernel.model.Group"%>
<%@ page import="com.liferay.portal.kernel.model.User"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ page import="com.liferay.portal.kernel.portlet.PortletURLFactoryUtil"%>
<%@ page import="com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder"%>
<%@ page import="com.liferay.portal.kernel.security.permission.ActionKeys"%>
<%@ page import="com.liferay.portal.kernel.security.permission.ResourceActionsUtil"%>
<%@ page import="com.liferay.portal.kernel.service.ClassNameLocalServiceUtil"%>
<%@ page import="com.liferay.portal.kernel.service.GroupLocalServiceUtil"%>
<%@ page import="com.liferay.portal.kernel.service.WorkflowDefinitionLinkLocalServiceUtil"%>
<%@ page import="com.liferay.portal.kernel.service.WorkflowInstanceLinkLocalServiceUtil"%>
<%@ page import="com.liferay.portal.kernel.workflow.WorkflowConstants"%>
<%@ page import="com.liferay.rss.util.RSSUtil"%>
<%@ page import="com.liferay.taglib.search.ResultRow"%>
<%@ page import="com.liferay.expando.kernel.model.ExpandoBridge" %>
<%@ page import="java.text.Format"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="javax.portlet.PortletRequest"%>
<%@ page import="javax.portlet.PortletURL"%>
<%@ page import="avanis.eventos.widget.eventos.actividades.resource.BookingsHandlerResource"%>
<%@ page import="avanis.eventos.widget.eventos.actividades.constants.AvanisEventosWidgetEventosActividadesPortletKeys"%>
<%@ page import="com.liferay.calendar.util.CalendarResourceUtil" %>
<%@ page import="com.liferay.portal.kernel.util.*" %>
<%@ page import="javax.portlet.PortletResponse" %>
<%@ page import="com.liferay.taglib.aui.AUIUtil" %>
<%@ page import="org.jsoup.Jsoup" %>
<%@ page import="java.util.*" %>
<jsp:directive.page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />


<liferay-frontend:defineObjects />

<liferay-theme:defineObjects />

<portlet:defineObjects />


<%
int defaultDuration = GetterUtil.getInteger(portletPreferences.getValue("defaultDuration", null), 60);
String defaultView = portletPreferences.getValue("defaultView", "week");
String timeFormat = GetterUtil.getString(portletPreferences.getValue("timeFormat", "locale"));
String timeZoneId = portletPreferences.getValue("timeZoneId", user.getTimeZoneId());
boolean usePortalTimeZone = GetterUtil
		.getBoolean(portletPreferences.getValue("usePortalTimeZone", Boolean.TRUE.toString()));
int weekStartsOn = GetterUtil.getInteger(portletPreferences.getValue("weekStartsOn", null));


String sessionClicksDefaultView = SessionClicks.get(request, "com.liferay.calendar.web_defaultView", defaultView);

if (usePortalTimeZone) {
	timeZoneId = user.getTimeZoneId();
}

List<CalendarBooking> siteCalendarBookings = (List<CalendarBooking>) request.getAttribute(AvanisEventosWidgetEventosActividadesPortletKeys.CALENDAR_BOOKINGS);
JSONObject siteCalendarBookingsJson = (JSONObject) request.getAttribute(AvanisEventosWidgetEventosActividadesPortletKeys.CALENDAR_BOOKINGS_JSON);

	boolean showSiteCalendars = true;

	CalendarResource userCalendarResource = null;

	if (!themeDisplay.isSignedIn()) {
		userCalendarResource = BookingsHandlerResource.getUserCalendarResource(liferayPortletRequest,
				themeDisplay.getUserId());
	}

CalendarResource groupCalendarResource = BookingsHandlerResource.getScopeGroupCalendarResource(liferayPortletRequest,scopeGroupId);

Calendar userDefaultCalendar = null;

if (userCalendarResource != null) {
	long defaultCalendarId = userCalendarResource.getDefaultCalendarId();

	if (defaultCalendarId > 0) {
		userDefaultCalendar = CalendarServiceUtil.getCalendar(defaultCalendarId);
	}
}

List<Calendar> userCalendars = Collections.emptyList();

if (userCalendarResource != null) {
	userCalendars = CalendarServiceUtil.search(themeDisplay.getCompanyId(), null,
	new long[] { userCalendarResource.getCalendarResourceId() }, null, true, QueryUtil.ALL_POS,
	QueryUtil.ALL_POS, (OrderByComparator) null);

}
	List<Calendar> groupCalendars = Collections.emptyList();

	if (groupCalendarResource != null) {
		showSiteCalendars = (userCalendarResource == null)
				|| (groupCalendarResource.getCalendarResourceId() != userCalendarResource.getCalendarResourceId());
	}

	if (showSiteCalendars) {
		groupCalendars = CalendarServiceUtil.search(themeDisplay.getCompanyId(), null,
				new long[] { groupCalendarResource.getCalendarResourceId() }, null, true, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, (OrderByComparator) null);
	}

	List<Calendar> otherCalendars = new ArrayList<Calendar>();

	long[] calendarIds = StringUtil
			.split(SessionClicks.get(request, "com.liferay.calendar.web_otherCalendars", StringPool.BLANK), 0L);

	Calendar defaultCalendar = null;

	TimeZone userTimeZone = TimeZone.getTimeZone(timeZoneId);

	SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
	SimpleDateFormat dayOfWeekFormat = new SimpleDateFormat("EEEE", request.getLocale());

	SimpleDateFormat dayFormatToCompare = new SimpleDateFormat("dd/MM/YYYY");
	SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM", new Locale("es", "ES"));

	SimpleDateFormat monthFormat2 = new SimpleDateFormat("MMM", locale);
	Format month2Format = new SimpleDateFormat("MMMMM", locale);
	Format yearFormat = new SimpleDateFormat("YYYY", locale);
	SimpleDateFormat nameDayNameformat = new SimpleDateFormat("EEEE", locale);
	SimpleDateFormat nameDayMonthformat = new SimpleDateFormat(" d 'de' MMMM 'del' yyyy ", locale);
	SimpleDateFormat hourformat = new SimpleDateFormat("HH:mm'h'");

	PortletRequest portletRequest = (PortletRequest)request.getAttribute(JavaConstants.JAVAX_PORTLET_REQUEST);

	PortletResponse portletResponse = (PortletResponse)request.getAttribute(JavaConstants.JAVAX_PORTLET_RESPONSE);

	String namespace = AUIUtil.getNamespace(portletRequest, portletResponse);

	if (Validator.isNull(namespace)) {
		namespace = AUIUtil.getNamespace(request);
	}

	 defaultDuration = GetterUtil.getInteger(portletPreferences.getValue("defaultDuration", null), 60);
	 defaultView = portletPreferences.getValue("defaultView", "week");
	 timeFormat = GetterUtil.getString(portletPreferences.getValue("timeFormat", "locale"));
	 timeZoneId = portletPreferences.getValue("timeZoneId", user.getTimeZoneId());
	 usePortalTimeZone = GetterUtil.getBoolean(portletPreferences.getValue("usePortalTimeZone", Boolean.TRUE.toString()));
	 weekStartsOn = GetterUtil.getInteger(portletPreferences.getValue("weekStartsOn", null));

	 sessionClicksDefaultView = SessionClicks.get(request, "com.liferay.calendar.web_defaultView", defaultView);

	if (usePortalTimeZone) {
		timeZoneId = user.getTimeZoneId();
	}

	boolean displaySchedulerHeader = GetterUtil.getBoolean(portletPreferences.getValue("displaySchedulerHeader", null), true);
	boolean displaySchedulerOnly = GetterUtil.getBoolean(portletPreferences.getValue("displaySchedulerOnly", null));
	boolean showUserEvents = GetterUtil.getBoolean(portletPreferences.getValue("showUserEvents", null), true);

	boolean showAgendaView = GetterUtil.getBoolean(portletPreferences.getValue("showAgendaView", null), true);
	boolean showDayView = GetterUtil.getBoolean(portletPreferences.getValue("showDayView", null), true);
	boolean showMonthView = GetterUtil.getBoolean(portletPreferences.getValue("showMonthView", null), true);
	boolean showWeekView = GetterUtil.getBoolean(portletPreferences.getValue("showWeekView", null), true);

	int eventsPerPage = GetterUtil.getInteger(portletPreferences.getValue("eventsPerPage", null), 10);
	int maxDaysDisplayed = GetterUtil.getInteger(portletPreferences.getValue("maxDaysDisplayed", null), 1);

	boolean enableRSS = !PortalUtil.isRSSFeedsEnabled() ? false : GetterUtil.getBoolean(portletPreferences.getValue("enableRss", null), true);
	int rssDelta = GetterUtil.getInteger(portletPreferences.getValue("rssDelta", StringPool.BLANK), SearchContainer.DEFAULT_DELTA);
	String rssDisplayStyle = portletPreferences.getValue("rssDisplayStyle", RSSUtil.DISPLAY_STYLE_DEFAULT);
	String rssFeedType = portletPreferences.getValue("rssFeedType", RSSUtil.FEED_TYPE_DEFAULT);
	long rssTimeInterval = GetterUtil.getLong(portletPreferences.getValue("rssTimeInterval", StringPool.BLANK), Time.WEEK);

	userTimeZone = TimeZone.getTimeZone(timeZoneId);

	Format longDateJFormat = FastDateFormatFactoryUtil.getDate(FastDateFormatConstants.LONG, locale, userTimeZone);

	Format utcLongDateJFormat = FastDateFormatFactoryUtil.getDate(FastDateFormatConstants.LONG, locale, TimeZone.getTimeZone(StringPool.UTC));

	boolean useIsoTimeFormat = timeFormat.equals("24-hour") || (timeFormat.equals("locale") && !DateUtil.isFormatAmPm(locale));

	Format utcTimeJFormat = FastDateFormatFactoryUtil.getSimpleDateFormat(useIsoTimeFormat ? "HH:mm" : "hh:mm a", locale, TimeZone.getTimeZone(StringPool.UTC));

	CalendarBooking calendarBookingC = (CalendarBooking)request.getAttribute(AvanisEventosWidgetEventosActividadesPortletKeys.CALENDAR_BOOKING);

	Format timeJFormat = FastDateFormatFactoryUtil.getSimpleDateFormat(useIsoTimeFormat ? "HH:mm" : "hh:mm a", locale, userTimeZone);


%>

