package avanis.eventos.widget.eventos.actividades.resource;
        import avanis.eventos.widget.eventos.actividades.beans.EventBean;
        import avanis.calendarbooking.sb.model.BookingAgenda;
        import avanis.calendarbooking.sb.service.BookingAgendaLocalServiceUtil;



        import com.liferay.asset.kernel.model.AssetCategory;
        import com.liferay.asset.kernel.model.AssetEntry;
        import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;
        import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
        import com.liferay.calendar.exception.NoSuchResourceException;
        import com.liferay.calendar.model.Calendar;
        import com.liferay.calendar.model.CalendarBooking;
        import com.liferay.calendar.model.CalendarResource;
        import com.liferay.calendar.service.*;
        import com.liferay.calendar.util.comparator.CalendarBookingStartTimeComparator;
        import com.liferay.headless.commerce.admin.account.dto.v1_0.User;
        import com.liferay.petra.string.StringPool;
        import com.liferay.portal.kernel.dao.orm.QueryUtil;
        import com.liferay.portal.kernel.exception.PortalException;
        import com.liferay.portal.kernel.json.JSONArray;
        import com.liferay.portal.kernel.log.Log;
        import com.liferay.portal.kernel.log.LogFactoryUtil;
        import com.liferay.portal.kernel.model.Group;
        import com.liferay.portal.kernel.security.auth.PrincipalException;
        import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
        import com.liferay.portal.kernel.service.ServiceContext;
        import com.liferay.portal.kernel.service.ServiceContextFactory;
        import com.liferay.portal.kernel.servlet.SessionErrors;
        import com.liferay.portal.kernel.theme.ThemeDisplay;
        import com.liferay.portal.kernel.util.OrderByComparator;
        import com.liferay.portal.kernel.util.PortalUtil;
        import com.liferay.portal.kernel.util.TimeZoneUtil;
        import com.liferay.portal.kernel.util.WebKeys;
        import com.liferay.portal.kernel.workflow.WorkflowConstants;

        import java.text.DateFormat;
        import java.text.SimpleDateFormat;
        import java.util.*;


        import javax.portlet.PortletRequest;
        import javax.portlet.RenderRequest;
        import javax.portlet.RenderResponse;

public class BookingsHandlerResource extends com.liferay.calendar.util.CalendarResourceUtil {

    private static Log LOG = LogFactoryUtil.getLog(avanis.eventos.widget.eventos.actividades.resource.BookingsHandlerResource.class);

    public static List<CalendarBooking> getBookingList(RenderRequest renderRequest, RenderResponse renderResponse) {
        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        com.liferay.portal.kernel.model.User user = themeDisplay.getUser();
        //TODO REVISAR ESTO PARA LA LOCALIZACION
        TimeZone timeZone = TimeZoneUtil.getTimeZone(StringPool.UTC);
        List<CalendarBooking> calendarBookings = new ArrayList<CalendarBooking>();
        boolean showSiteCalendars = false;


        try {
            CalendarResource groupCalendarResource = getScopeGroupCalendarResource(renderRequest,
                    themeDisplay.getScopeGroupId());

            CalendarResource userCalendarResource = null;

            if (!themeDisplay.isSignedIn()) {
                userCalendarResource = getUserCalendarResource(renderRequest, themeDisplay.getUserId());
            }

            List<Calendar> groupCalendars = Collections.emptyList();

            if (groupCalendarResource != null) {
                showSiteCalendars = (userCalendarResource == null) || (groupCalendarResource
                        .getCalendarResourceId() != userCalendarResource.getCalendarResourceId());
            }

            //Calendarios por site
            if (showSiteCalendars) {
                groupCalendars = CalendarServiceUtil.search(themeDisplay.getCompanyId(), null,
                        new long[]{groupCalendarResource.getCalendarResourceId()}, null, true, QueryUtil.ALL_POS,
                        QueryUtil.ALL_POS, (OrderByComparator) null);
            }

            //Lista de calendarios de avanis en este caso 1
            long[] calendarIds = new long[1];
            calendarIds[0] = groupCalendars.get(0).getCalendarId();

            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            java.util.Calendar cal = java.util.Calendar.getInstance();
            long startTime = java.util.Calendar.getInstance().getTimeInMillis();

            //long endTime = startTime + AvanisEventUtil.day2Millisecode(cal.getInstance().add(cal.DATE, 7)));

            Date now = cal.getTime();
            cal.add(cal.DATE, 365);
            Date then = cal.getTime();
            long endTime = then.getTime();


            if (LOG.isDebugEnabled()) {
                LOG.debug("Fecha inicio calendar Widget: " + dateFormat.format(cal.getTime()));
                LOG.debug("Fecha fin calendar Widget: " + dateFormat.format(then));
            }

            //Listado de los estados de los eventos a mostrar en este caso solo aprobados
            int[] statuses = new int[1];
            statuses[0] = WorkflowConstants.STATUS_APPROVED;

            //Lista de eventos acotados a 3
            calendarBookings = CalendarBookingServiceUtil.search(
                    themeDisplay.getCompanyId(), new long[0], calendarIds,
                    new long[0], -1, null, startTime,
                    endTime, timeZone, true, statuses,
                    QueryUtil.ALL_POS, QueryUtil.ALL_POS,
                    new CalendarBookingStartTimeComparator(true));


     		/*for (CalendarBooking calendarBooking : calendarBookings) {
					bookingList = AvanisEventUtil.toCalendarBookingJSONObject(themeDisplay, calendarBooking, timeZone);

				}*/

        } catch (Exception exception) {
            if (exception instanceof NoSuchResourceException || exception instanceof PrincipalException) {

                SessionErrors.add(renderRequest, exception.getClass());

            }

        }
        return calendarBookings;
    }

    public static List<CalendarBooking>  getBookingListFiltered(List<String> calendarBookingIdsList, JSONArray selectedValuesArray){

        // Convertir los JSONArrays a listas de strings
        List<String> selectedValuesList = new ArrayList<>();
        for (int i = 0; i < selectedValuesArray.length(); i++) {
            selectedValuesList.add(selectedValuesArray.getString(i));
        }
        // Array de eventos que coinciden
        List<CalendarBooking> matchingEvents = new ArrayList<CalendarBooking>(); // NUEVO: Array de eventos coincidentes

        // **Nuevo código para obtener las categorías de los eventos de calendario**
        for (String id : calendarBookingIdsList) {
            try {
                long calendarBookingId = Long.parseLong(id);

                // Recuperar el evento de calendario utilizando su ID
                CalendarBooking calendarBooking = CalendarBookingLocalServiceUtil.getCalendarBooking(calendarBookingId);

                // Obtener el AssetEntry asociado al evento de calendario
                long classPK = calendarBooking.getPrimaryKey();
                String className = CalendarBooking.class.getName();

                AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(className, classPK);

                if (assetEntry != null) {
                    // Obtener las categorías asociadas a este AssetEntry
                    long[] categoryIds = assetEntry.getCategoryIds();
                    List<AssetCategory> categories = new ArrayList<>();

                    for (long categoryId : categoryIds) {
                        AssetCategory category = AssetCategoryLocalServiceUtil.getAssetCategory(categoryId);
                        categories.add(category);
                    }

                    // Recorro lista de categorías de evento y comparo con selectedValuesList
                    for (AssetCategory category : categories) {
                        //System.out.println("Categoría para evento " + calendarBookingId + ": " + category.getName());

                        // Comprobar si la categoría del evento está en la lista de valores seleccionados
                        if (selectedValuesList.contains(category.getName())) {  // NUEVO: Comparación de categorías
                            // Añadir el evento al array de eventos coincidentes
                            matchingEvents.add(calendarBooking); // NUEVO: Añadir evento al array
                            break; // Salir del bucle si se encuentra una coincidencia
                        }
                    }
                } else {
                    //System.out.println("No se encontró AssetEntry para el evento de calendario con ID: " + calendarBookingId);
                }

            } catch (PortalException e) {
                throw new RuntimeException(e);
            }
        }

        return matchingEvents;
    }

    public static List<EventBean> bookingsToEventList(List<CalendarBooking> listBookings) {
        List<EventBean> eventList = new ArrayList<>();
        for (CalendarBooking calendarBooking : listBookings) {
            EventBean eventBean = new EventBean();
            eventBean.setCalendarBooking(calendarBooking);

            List<BookingAgenda> bookingAgenda = new ArrayList<>();
            bookingAgenda = BookingAgendaLocalServiceUtil.getBookingAgendasByCalendarBookingId(calendarBooking.getCalendarBookingId());
            eventBean.setBookingAgenda(bookingAgenda);
        }

        return eventList;
    }

    public static CalendarResource getCalendarResource(
            PortletRequest portletRequest, long classNameId, long classPK)
            throws PortalException {

        long groupClassNameId = PortalUtil.getClassNameId(Group.class);

        if (classNameId == groupClassNameId) {
            return getGroupCalendarResource(portletRequest, classPK);
        }

        long userClassNameId = PortalUtil.getClassNameId(User.class);

        if (classNameId == userClassNameId) {
            return getUserCalendarResource(portletRequest, classPK);
        }

        return CalendarResourceServiceUtil.fetchCalendarResource(
                classNameId, classPK);
    }

    public static CalendarResource getGroupCalendarResource(
            PortletRequest portletRequest, long groupId)
            throws PortalException {

        ServiceContext serviceContext = ServiceContextFactory.getInstance(
                portletRequest);

        return getGroupCalendarResource(groupId, serviceContext);
    }

    public static CalendarResource getUserCalendarResource(
            PortletRequest portletRequest, long userId)
            throws PortalException {

        ServiceContext serviceContext = ServiceContextFactory.getInstance(
                portletRequest);

        serviceContext.setUserId(userId);

        return getUserCalendarResource(userId, serviceContext);
    }


    public static CalendarResource getScopeGroupCalendarResource(
            long groupId, ServiceContext serviceContext)
            throws PortalException {

        Group group = GroupLocalServiceUtil.getGroup(groupId);

        if (group.isUser()) {
            return getUserCalendarResource(group.getClassPK(), serviceContext);
        }

        return getGroupCalendarResource(groupId, serviceContext);
    }


    public static CalendarResource getScopeGroupCalendarResource(
            PortletRequest portletRequest, long groupId)
            throws PortalException {

        ServiceContext serviceContext = ServiceContextFactory.getInstance(
                portletRequest);

        return getScopeGroupCalendarResource(groupId, serviceContext);
    }



}
