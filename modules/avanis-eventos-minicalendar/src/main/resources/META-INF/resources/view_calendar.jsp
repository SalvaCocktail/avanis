<%@ page import="java.util.stream.Collectors" %>
<%@ page import="com.liferay.portal.kernel.util.*" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.Instant" %>
<%@ page import="java.time.ZoneId" %>
<%@ page import="avanis.calendarbooking.sb.service.BookingAgendaLocalServiceUtil" %>
<%@ page import="avanis.calendarbooking.sb.model.BookingAgenda" %>
<%@ page import="static avanis.calendarbooking.sb.service.BookingAgendaLocalServiceUtil.getBookingAgendas" %>

<%@ include file="/init.jsp" %>
<jsp:directive.page contentType="text/html" pageEncoding="UTF-8" />
<portlet:resourceURL var="eventsURLFilter"
					 id="<%= AvanisEventosMiniCalendarKeys.AVANISEVENTOSMINICALENDAR %>">
</portlet:resourceURL>


<%
	String activeView = ParamUtil.getString(request, "activeView", sessionClicksDefaultView);
	long date = ParamUtil.getLong(request, "date", System.currentTimeMillis());

	JSONArray groupCalendarsJSONArray = CalendarUtil.toCalendarsJSONArray(themeDisplay, groupCalendars);
	JSONArray userCalendarsJSONArray = CalendarUtil.toCalendarsJSONArray(themeDisplay, userCalendars);
	JSONArray otherCalendarsJSONArray = CalendarUtil.toCalendarsJSONArray(themeDisplay, otherCalendars);

	boolean columnOptionsVisible = GetterUtil.getBoolean(SessionClicks.get(request, "com.liferay.calendar.web_columnOptionsVisible", "true"));
%>

<aui:script use="liferay-calendar-container,liferay-calendar-remote-services,liferay-component">
	Liferay.component('<portlet:namespace />calendarContainer', () => {
	var calendarContainer = new Liferay.CalendarContainer({
	groupCalendarResourceId:
	<%= groupCalendarResource.getCalendarResourceId() %>,

	<c:if test="<%= userCalendarResource != null %>">
		userCalendarResourceId:
		<%= userCalendarResource.getCalendarResourceId() %>,
	</c:if>

	namespace: '<portlet:namespace />',
	});

	var destroyInstance = function (event) {
	if (event.portletId === '<%= portletDisplay.getId() %>') {
	calendarContainer.destroy();

	Liferay.component('<portlet:namespace />calendarContainer', null);

	Liferay.detach('destroyPortlet', destroyInstance);
	}
	};

	Liferay.on('destroyPortlet', destroyInstance);

	return calendarContainer;
	});

	Liferay.component('<portlet:namespace />remoteServices', () => {
	var remoteServices = new Liferay.CalendarRemoteServices({
	baseActionURL:
	'<%= PortletURLFactoryUtil.create(request, portletDisplay.getId(), PortletRequest.ACTION_PHASE) %>',
	baseResourceURL:
	'<%= PortletURLFactoryUtil.create(request, portletDisplay.getId(), PortletRequest.RESOURCE_PHASE) %>',
	invokerURL: themeDisplay.getPathContext() + '/api/jsonws/invoke',
	namespace: '<portlet:namespace />',
	userId: themeDisplay.getUserId(),
	});

	var destroyInstance = function (event) {
	if (event.portletId === '<%= portletDisplay.getId() %>') {
	remoteServices.destroy();

	Liferay.component('<portlet:namespace />remoteServices', null);

	Liferay.detach('destroyPortlet', destroyInstance);
	}
	};

	Liferay.on('destroyPortlet', destroyInstance);

	return remoteServices;
	});
</aui:script>

<clay:container-fluid cssClass="calendar-portlet-column-parent">
	<clay:row>
		<c:if test="<%= !displaySchedulerOnly %>">
			<clay:col
					cssClass='<%= "calendar-portlet-column-options " + (columnOptionsVisible ? StringPool.BLANK : "hide") %>'
					id='<%= liferayPortletResponse.getNamespace() + "columnOptions" %>'
					md="12"
			>

				<div class="calendar-portlet-mini-calendar" id="<portlet:namespace />miniCalendarContainer"></div>

				<div id="<portlet:namespace />calendarListContainer">
					<div class="calendar-portlet-list">
						<c:if test="<%= showSiteCalendars %>">
							<div class="calendar-portlet-list-header toggler-header-expanded">
								<span class="calendar-portlet-list-arrow"></span>
								<span class="calendar-portlet-list-text">
									<liferay-ui:message arguments="<%= HtmlUtil.escape(groupCalendarResource.getName(locale)) %>" key="x-calendars" />
								</span>
							</div>
							<c:if test="<%= CalendarResourcePermission.contains(permissionChecker, groupCalendarResource, CalendarActionKeys.ADD_CALENDAR) %>">
								<span aria-expanded="false" aria-label="<liferay-ui:message arguments="<%= HtmlUtil.escape(groupCalendarResource.getName(locale)) %>" key="manage-calendar-x" />" class="calendar-list-item-arrow calendar-resource-arrow" data-calendarResourceId="<%= groupCalendarResource.getCalendarResourceId() %>" role="button" tabindex="0">
									<clay:icon symbol="caret-bottom" />
								</span>
							</c:if>
							<div class="calendar-portlet-calendar-list" id="<portlet:namespace />siteCalendarList"></div>
						</c:if>
					</div>
					<div class="calendar-portlet-list">
						<c:if test="<%= themeDisplay.isSignedIn() %>">
							<div class="calendar-portlet-list-header toggler-header-expanded">
									<%--
                                    <span class="calendar-portlet-list-arrow"></span>
                                    <span class="calendar-portlet-list-text"><liferay-ui:message key="other-calendars" /></span>
                                    --%>
							</div>
							<div class="calendar-portlet-calendar-list" id="<portlet:namespace />otherCalendarList">
								<input class="calendar-portlet-add-calendars-input" id="<portlet:namespace />addOtherCalendar" placeholder="<liferay-ui:message key="add-other-calendars" />" type="text" />
							</div>
						</c:if>
					</div>
				</div>

				<!-- Mueve el scheduler debajo del minicalendario -->
				<div class="calendar-portlet-scheduler">
						<%--SCHEDULER--%>
					<liferay-util:include page="/scheduler.jsp" servletContext="<%= application %>">
						<liferay-util:param name="activeView" value="<%= activeView %>" />
						<liferay-util:param name="date" value="<%= String.valueOf(date) %>" />
						<portlet:renderURL var="editCalendarBookingURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
							<portlet:param name="mvcPath" value="/edit_calendar_booking.jsp" />
							<portlet:param name="activeView" value="{activeView}" />
							<portlet:param name="allDay" value="{allDay}" />
							<portlet:param name="calendarBookingId" value="{calendarBookingId}" />
							<portlet:param name="calendarId" value="{calendarId}" />
							<portlet:param name="date" value="{date}" />
							<portlet:param name="endTimeDay" value="{endTimeDay}" />
							<portlet:param name="endTimeHour" value="{endTimeHour}" />
							<portlet:param name="endTimeMinute" value="{endTimeMinute}" />
							<portlet:param name="endTimeMonth" value="{endTimeMonth}" />
							<portlet:param name="endTimeYear" value="{endTimeYear}" />
							<portlet:param name="instanceIndex" value="{instanceIndex}" />
							<portlet:param name="startTimeDay" value="{startTimeDay}" />
							<portlet:param name="startTimeHour" value="{startTimeHour}" />
							<portlet:param name="startTimeMinute" value="{startTimeMinute}" />
							<portlet:param name="startTimeMonth" value="{startTimeMonth}" />
							<portlet:param name="startTimeYear" value="{startTimeYear}" />
							<portlet:param name="titleCurrentValue" value="{titleCurrentValue}" />
						</portlet:renderURL>
						<liferay-util:param name="editCalendarBookingURL" value="<%= editCalendarBookingURL %>" />
						<liferay-util:param name="hideAgendaView" value="<%= String.valueOf(!showAgendaView) %>" />
						<liferay-util:param name="hideDayView" value="<%= String.valueOf(!showDayView) %>" />
						<liferay-util:param name="hideWeekView" value="<%= String.valueOf(!showWeekView) %>" />
						<liferay-util:param name="hideMonthView" value="<%= String.valueOf(!showMonthView) %>" />
						<liferay-util:param name="readOnly" value="<%= Boolean.FALSE.toString() %>" />
						<liferay-security:permissionsURL
								modelResource="<%= CalendarBooking.class.getName() %>"
								modelResourceDescription="{modelResourceDescription}"
								resourceGroupId="{resourceGroupId}"
								resourcePrimKey="{resourcePrimKey}"
								var="permissionsCalendarBookingURL"
								windowState="<%= LiferayWindowState.POP_UP.toString() %>"
						/>
						<liferay-util:param name="permissionsCalendarBookingURL" value="<%= permissionsCalendarBookingURL %>" />
						<liferay-util:param name="showAddEventBtn" value="<%= String.valueOf((defaultCalendar != null) && CalendarPermission.contains(permissionChecker, defaultCalendar, CalendarActionKeys.MANAGE_BOOKINGS)) %>" />
						<liferay-util:param name="showSchedulerHeader" value="<%= String.valueOf(displaySchedulerHeader) %>" />
						<portlet:renderURL var="viewCalendarBookingURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
							<portlet:param name="mvcPath" value="/view_calendar_booking.jsp" />
							<portlet:param name="calendarBookingId" value="{calendarBookingId}" />
							<portlet:param name="instanceIndex" value="{instanceIndex}" />
						</portlet:renderURL>
						<liferay-util:param name="viewCalendarBookingURL" value="<%= viewCalendarBookingURL %>" />
					</liferay-util:include>

				</div>
			</clay:col>
		</c:if>
	</clay:row>
</clay:container-fluid>


<div id="<portlet:namespace />message"></div>

<c:if test="<%= !displaySchedulerOnly %>">
	<%@ include file="/view_calendar_menus.jspf" %>
</c:if>

<aui:script use="liferay-calendar-list,liferay-calendar-util,liferay-scheduler">
	Liferay.CalendarUtil.USER_CLASS_NAME_ID =
	<%= PortalUtil.getClassNameId(User.class) %>;

	var calendarContainer = Liferay.component(
	'<portlet:namespace />calendarContainer'
	);

	var syncCalendarsMap = function () {
	var calendarLists = [];

	<c:if test="<%= themeDisplay.isSignedIn() || (groupCalendarResource != null) %>">
		calendarLists.push(window.<portlet:namespace />myCalendarList);
	</c:if>

	<c:if test="<%= themeDisplay.isSignedIn() %>">
		calendarLists.push(window.<portlet:namespace />otherCalendarList);
	</c:if>

	<c:if test="<%= showSiteCalendars %>">
		calendarLists.push(window.<portlet:namespace />siteCalendarList);
	</c:if>

	calendarContainer.syncCalendarsMap(calendarLists);
	};

	window.<portlet:namespace />syncCalendarsMap = syncCalendarsMap;

	window.<portlet:namespace />calendarLists = {};

	<c:if test="<%= themeDisplay.isSignedIn() || (groupCalendarResource != null) %>">
		window.<portlet:namespace />myCalendarList = new Liferay.CalendarList({
		after: {
		'calendarsChange': syncCalendarsMap,
		'scheduler-calendar:visibleChange': function (event) {
		syncCalendarsMap();

		<portlet:namespace />refreshVisibleCalendarRenderingRules();
		},
		},
		boundingBox: '#<portlet:namespace />myCalendarList',

		<%
			updateCalendarsJSONArray(userCalendarsJSONArray, enableRSS, request, false);
		%>

		calendars: <%= userCalendarsJSONArray %>,
		scheduler: <portlet:namespace />scheduler,
		showCalendarResourceName: false,
		simpleMenu: window.<portlet:namespace />calendarsMenu,
		visible: <%= !displaySchedulerOnly && themeDisplay.isSignedIn() %>,
		}).render();

		<c:if test="<%= userCalendarResource != null %>">
			window.<portlet:namespace />calendarLists[
			'<%= userCalendarResource.getCalendarResourceId() %>'
			] = window.<portlet:namespace />myCalendarList;
		</c:if>
	</c:if>

	<c:if test="<%= themeDisplay.isSignedIn() %>">
		window.<portlet:namespace />otherCalendarList = new Liferay.CalendarList({
		after: {
		'calendarsChange': function (event) {
		syncCalendarsMap();

		<portlet:namespace />scheduler.load();

		var calendarIds = A.Array.invoke(event.newVal, 'get', 'calendarId');

		Liferay.Util.Session.set(
		'com.liferay.calendar.web_otherCalendars',
		calendarIds.join()
		);
		},
		'scheduler-calendar:visibleChange': function (event) {
		syncCalendarsMap();

		<portlet:namespace />refreshVisibleCalendarRenderingRules();
		},
		},
		boundingBox: '#<portlet:namespace />otherCalendarList',

		<%
			updateCalendarsJSONArray(otherCalendarsJSONArray, enableRSS, request, true);
		%>

		calendars: <%= otherCalendarsJSONArray %>,
		scheduler: <portlet:namespace />scheduler,
		simpleMenu: window.<portlet:namespace />calendarsMenu,
		visible: <%= !displaySchedulerOnly %>,
		}).render();
	</c:if>

	<c:if test="<%= showSiteCalendars %>">
		window.<portlet:namespace />siteCalendarList = new Liferay.CalendarList({
		after: {
		'calendarsChange': syncCalendarsMap,
		'scheduler-calendar:visibleChange': function (event) {
		syncCalendarsMap();

		<portlet:namespace />refreshVisibleCalendarRenderingRules();
		},
		},
		boundingBox: '#<portlet:namespace />siteCalendarList',

		<%
			updateCalendarsJSONArray(groupCalendarsJSONArray, enableRSS, request, false);
		%>

		calendars: <%= groupCalendarsJSONArray %>,
		scheduler: <portlet:namespace />scheduler,
		showCalendarResourceName: false,
		simpleMenu: window.<portlet:namespace />calendarsMenu,
		visible: <%= !displaySchedulerOnly %>,
		}).render();

		window.<portlet:namespace />calendarLists[
		'<%= groupCalendarResource.getCalendarResourceId() %>'
		] = window.<portlet:namespace />siteCalendarList;
	</c:if>

	syncCalendarsMap();

	A.each(calendarContainer.get('availableCalendars'), (item, index) => {
	item.on({
	visibleChange: function (event) {
	var instance = this;

	var calendar = event.currentTarget;

	Liferay.Util.Session.set(
	'com.liferay.calendar.web_calendar' +
	calendar.get('calendarId') +
	'Visible',
	event.newVal
	);
	},
	});
	});
</aui:script>



<aui:script>
	var destroyMenus = function (event) {
	if (window.<portlet:namespace />calendarListsMenu) {
	window.<portlet:namespace />calendarListsMenu.destroy();
	}

	if (window.<portlet:namespace />colorPicker) {
	window.<portlet:namespace />colorPicker.destroy();
	}

	var myCalendarList = window.<portlet:namespace />myCalendarList;
	//console.log("")
	var otherCalendarList = window.<portlet:namespace />otherCalendarList;
	var siteCalendarList = window.<portlet:namespace />siteCalendarList;

	if (myCalendarList && myCalendarList.simpleMenu) {
	myCalendarList.simpleMenu.destroy();
	myCalendarList.destroy();
	}

	if (otherCalendarList && otherCalendarList.simpleMenu) {
	otherCalendarList.simpleMenu.destroy();
	otherCalendarList.destroy();
	}

	if (siteCalendarList && siteCalendarList.simpleMenu) {
	siteCalendarList.simpleMenu.destroy();
	siteCalendarList.destroy();
	}

	Liferay.detach(
	'<%= portletDisplay.getId() %>:portletRefreshed',
	destroyMenus
	);
	Liferay.detach('destroyPortlet', destroyMenus);
	};
	Liferay.on('<%= portletDisplay.getId() %>:portletRefreshed', destroyMenus);
	Liferay.on('destroyPortlet', destroyMenus);
</aui:script>

<%!
	protected boolean hasMenuItems(JSONObject calendarJSONObject, boolean enableRSS, boolean otherCalendar) {
		if (enableRSS || otherCalendar) {
			return true;
		}

		JSONObject permissionsJSONObject = calendarJSONObject.getJSONObject("permissions");

		if ((permissionsJSONObject.getBoolean(ActionKeys.DELETE) && !calendarJSONObject.getBoolean("defaultCalendar")) ||
				permissionsJSONObject.getBoolean(CalendarActionKeys.MANAGE_BOOKINGS) ||
				permissionsJSONObject.getBoolean(ActionKeys.PERMISSIONS) ||
				permissionsJSONObject.getBoolean(ActionKeys.UPDATE)) {

			return true;
		}

		return false;
	}

	protected void updateCalendarsJSONArray(JSONArray calendarsJSONArray, boolean enableRSS, HttpServletRequest request, boolean otherCalendar) {
		for (int i = 0; i < calendarsJSONArray.length(); i++) {
			JSONObject jsonObject = calendarsJSONArray.getJSONObject(i);

			long calendarId = jsonObject.getLong("calendarId");

			jsonObject.put("color", GetterUtil.getString(SessionClicks.get(request, "com.liferay.calendar.web_calendar" + calendarId + "Color", jsonObject.getString("color"))));
			jsonObject.put("hasMenuItems", hasMenuItems(jsonObject, enableRSS, otherCalendar));
			jsonObject.put("visible", GetterUtil.getBoolean(SessionClicks.get(request, "com.liferay.calendar.web_calendar" + calendarId + "Visible", "true")));
		}
	}




// Establecer el atributo en la solicitud

%>


<script>

	$(document).ready(function() {

		var targetNode = document.querySelector('.calendar-portlet-mini-calendar');

		// Configura el observador para observar cambios en el DOM
		var observer = new MutationObserver(function(mutationsList, observer) {
			// Cuando detecte un cambio, ejecuta la función actualizarPuntitos
			//console.log("ACTUALIZO PUNTITOS")
			actualizarPuntitos();
			//actualizaDiasSemana();

		});
		// Opciones de configuración del observador: observar los hijos y cambios en el contenido
		var config = { childList: true, subtree: true };


		// Comienza a observar el nodo con la configuración especificada
		if (targetNode) {
			observer.observe(targetNode, config);
		}


		function actualizaDiasSemana(){
			$('th.yui3-calendar-weekday').each(function() {
				// Obtener el texto actual de cada <th>
				var dayText = $(this).text().trim();

				// Verifica si el texto es un día válido y toma solo la primera letra
				var initial = dayText.substring(0, 1);

				// Reemplaza el texto actual con la nueva inicial
				$(this).text(initial);
			});
		}

		// Mapeo los dias


		$('.yui3-calendar-weekdayrow .yui3-calendar-weekday').each(function() {
			// Obtener el aria-label del elemento
			var ariaLabel = $(this).attr('aria-label');
			// Convertir el aria-label a su inicial correspondiente
			var initial = dayInitials[ariaLabel.toLowerCase()];
			// Actualizar el contenido de la celda con la inicial
			if (initial) {
				$(this).text(initial);
			}
		});

		// clase 'yui3-calendar-day'
		$(document).on('click', '.yui3-calendar-day', function() {
			// y no están escondidos
			if (!$(this).hasClass('yui3-calendar-column-hidden')) {
				//console.log("Ha cambiado de DIA");

				function getMonthNumber(monthName) {
					const months = [
						'enero', 'febrero', 'marzo', 'abril', 'mayo', 'junio',
						'julio', 'agosto', 'septiembre', 'octubre', 'noviembre', 'diciembre'
					];
					return months.indexOf(monthName.toLowerCase());
				}

				<%-- TRAIGO CALENDARIOS ID--%>
				var calendars = [];
				<% for (Calendar calendar : groupCalendars) { %>
				// Añadir cada calendarId al array de JavaScript
				calendars.push(<%= calendar.getCalendarId() %>);
				<% } %>

				/*
				// Ejemplo: Imprimir cada calendarId en la consola de JavaScript
				calendars.forEach(function(calendarId) {
					console.log("Calendar ID: " + calendarId);
				});
				*/
				<%-- FIN TRAIGO CALENDARIOS--%>

				<%-- TRAIGO FECHA--%>
				var headerText = $('.yui3-calendar-header-label').text().trim();
				var monthYear = headerText.split(' '); // Se divide el texto en dos partes: mes y año

				var month = monthYear[0]; // Nombre del mes
				var year = monthYear[1]; // Año

				var monthNumber = getMonthNumber(month);

				// Obtener el día seleccionado
				var selectedDay = $('.yui3-calendar-day-selected').text().trim();

				//console.log('Día:', selectedDay);
				//console.log('Mes:', month);
				//console.log('Año:', year);
				<%-- FIN TRAIGO FECHA--%>


				var calendarIdsString = calendars.join(',');
				//console.log("calendarIdsString:", calendarIdsString);

				// Me traigo el jsonArray de Eventos
				var fullURL = window.location.origin + window.location.pathname + '?p_p_id=avanis_eventos_minicalendar_AvanisEventosMiniCalendar&p_p_lifecycle=2&p_p_cacheability=cacheLevelPage&p_p_resource_id=calendarBookings2';
				$.ajax({
					url: fullURL,
					type: 'POST',
					data: {
						'p_p_resource_id': 'calendarBookings',
						'_avanis_eventos_minicalendar_AvanisEventosMiniCalendar_calendarIds': calendarIdsString,
						'_avanis_eventos_minicalendar_AvanisEventosMiniCalendar_startTimeDay': selectedDay, /*DIA*/
						'_avanis_eventos_minicalendar_AvanisEventosMiniCalendar_startTimeMonth': monthNumber,
						'_avanis_eventos_minicalendar_AvanisEventosMiniCalendar_startTimeYear': year,
						'_avanis_eventos_minicalendar_AvanisEventosMiniCalendar_startTimeHour': 0,
						'_avanis_eventos_minicalendar_AvanisEventosMiniCalendar_startTimeMinute': 0,
						'_avanis_eventos_minicalendar_AvanisEventosMiniCalendar_endTimeDay': selectedDay,   /*DIA*/
						'_avanis_eventos_minicalendar_AvanisEventosMiniCalendar_endTimeMonth': monthNumber, /*MES*/
						'_avanis_eventos_minicalendar_AvanisEventosMiniCalendar_endTimeYear': year,  /*AÑO*/
						'_avanis_eventos_minicalendar_AvanisEventosMiniCalendar_endTimeHour': 23,
						'_avanis_eventos_minicalendar_AvanisEventosMiniCalendar_endTimeMinute': 59,
						'_avanis_eventos_minicalendar_AvanisEventosMiniCalendar_eventsPerPage': 0,
						'_avanis_eventos_minicalendar_AvanisEventosMiniCalendar_statuses': '0,4,2,9,1'
					},
					success: function(response) {
						$('.container-eventos').empty();
						$('.error-cero-eventos').hide();

						if (Array.isArray(response) && response.length > 0) {
							$.each(response, function(index, event) {
								var hiddenClass = index >= 3 ? 'hidden-event' : '';  // Ocultar si es mayor a 3
								var eventHTML = '<div class="container-eventos-usuario ' + hiddenClass + '">' +
										'<div class="container-eventos-usuario-punto-verde">' +
										'<img class="icon-punto-verde" src="/o/avanis.eventos.minicalendar/images/Ellipse%201754.png" alt="icon-punto-verde">' +
										'</div>' +
										'<div class="container-eventos-usuario-texto">' +
										'<h5>' + event.title + '</h5>' +
										'<p>Del ' + event.startTimeDay + ' de ' + getMonthName(event.startTimeMonth) + ' al ' + event.endTimeDay + ' de ' + getMonthName(event.endTimeMonth) + ' ' + event.startTimeYear + '</p>' +
										'<p>' + (event.location || 'Ubicación no disponible') + '</p>' +
										'</div>' +
										'</div>';

								$('.container-eventos').append(eventHTML);
							});

							// Agregar el botón "Mostrar todos los eventos" si hay más de 3
							if (response.length > 3) {
								var showMoreHTML = '<span class="av-pe__footer-text" id="show-more-events" style="cursor: pointer;"><liferay-ui:message key="event.widget.show.all.events"/></span>';
								$('.container-eventos').append(showMoreHTML);

								// Manejar el clic en "Mostrar todos los eventos"
								$('#show-more-events').on('click', function() {
									$('.hidden-event').slideDown();  // Mostrar los eventos ocultos con animación
									$(this).hide();  // Ocultar el enlace de "Mostrar todos los eventos"
								});
							}

							// Ocultar eventos extras al inicio
							$('.hidden-event').hide();
						} else {
							$('.error-cero-eventos').show();
						}
					},
					error: function(xhr, status, error) {
						console.error("Error al obtener los datos de eventos:", status, error);
					}
				});




				function getMonthName(monthNumber) {
					const months = [
						'enero', 'febrero', 'marzo', 'abril', 'mayo', 'junio',
						'julio', 'agosto', 'septiembre', 'octubre', 'noviembre', 'diciembre'
					];
					return months[monthNumber] || 'Mes desconocido';
				}
			}
		});










		//FUNCION PARA LOS PUNTITOS
		// clase 'yui3-calendar-day'


		// Obtener el texto actual del encabezado del calendario
		var currentMonthLabel = $('.yui3-calendar-header-label').text().trim();

		// Función para obtener el número del mes a partir del nombre del mes
		function getMonthNumber(monthName) {
			const months = [
				'enero', 'febrero', 'marzo', 'abril', 'mayo', 'junio',
				'julio', 'agosto', 'septiembre', 'octubre', 'noviembre', 'diciembre'
			];
			return months.indexOf(monthName.toLowerCase());
		}

		// Función para registrar el cambio de mes en la consola
		function logMonthChange(newMonthLabel) {
			//console.log('Mes cambiado a:', newMonthLabel);
		}

	});

	function actualizarPuntitos(){
		var headerText = $('.yui3-calendar-header-label').text().trim();
		var monthYear = headerText.split(' '); // Se divide el texto en dos partes: mes y año
		var month = monthYear[0]; // Nombre del mes
		var year = monthYear[1]; // Año

		function getMonthNumber(monthName) {
			const months = [
				'enero', 'febrero', 'marzo', 'abril', 'mayo', 'junio',
				'julio', 'agosto', 'septiembre', 'octubre', 'noviembre', 'diciembre'
			];
			return months.indexOf(monthName.toLowerCase()) + 1; // +1 para obtener el número de mes real (enero = 1)
		}
		function getDaysInMonth(month, year) {
			return new Date(year, month, 0).getDate(); // Día 0 del mes siguiente es el último día del mes actual
		}

		var monthNumber = getMonthNumber(month); // Obtener el número de mes
		var daysInMonth = getDaysInMonth(monthNumber, year); // Obtener el número de días del mes
		// Solo muestra el log si el mes realmente ha cambiado
		// Me traigo el jsonArray de Eventos
		var fullURL = window.location.origin + window.location.pathname + '?p_p_id=avanis_eventos_minicalendar_AvanisEventosMiniCalendar&p_p_lifecycle=2&p_p_cacheability=cacheLevelPage&p_p_resource_id=mesAnio';

		//Controlo que no lleguen fechas Null and undefined

		if (typeof year === "undefined" || monthNumber === 0 || isNaN(daysInMonth)) {

			year = new Date().getFullYear();
			monthNumber = new Date().getMonth() + 1;
			daysInMonth = new Date(year, monthNumber, 0).getDate();
		}

		$.ajax({
			url: fullURL,
			type: 'POST',
			data: {
				'p_p_resource_id': 'mesAnio',
				'_avanis_eventos_minicalendar_AvanisEventosMiniCalendar_year': year,
				'_avanis_eventos_minicalendar_AvanisEventosMiniCalendar_month': monthNumber,
				'_avanis_eventos_minicalendar_AvanisEventosMiniCalendar_daysInMonth': daysInMonth
				/*DIA*/

			},
			success: function(response) {
				// Maneja la respuesta del servidor aquí
				//console.log("Datos de eventos recibidos:", response);

				if (response && typeof response === 'object') {
					//console.log(response);
					var eventosPorDia = response;

					setTimeout(function() {
						// Recorre cada celda de día en el calendario
						$('.yui3-calendar-day').each(function() {
							// Obtiene el texto del día
							var dia = $(this).text().trim();

							// Verifica si el texto es un número válido
							if (dia && !isNaN(dia)) {
								dia = parseInt(dia);

								// Obtiene la cantidad de eventos para este día
								var cantidadEventos = eventosPorDia[dia] || 0;

								// Elimina las clases de eventos previas
								$(this).removeClass('evento-1 evento-2 evento-3 evento-mas lfr-busy-day');

								// Añade la clase correspondiente según la cantidad de eventos
								if (cantidadEventos > 3) {
									$(this).addClass('evento-3 lfr-busy-day');
								} else if (cantidadEventos === 3) {
									$(this).addClass('evento-3 lfr-busy-day');
								} else if (cantidadEventos === 2) {
									$(this).addClass('evento-2 lfr-busy-day');
								} else if (cantidadEventos === 1) {
									$(this).addClass('evento-1 lfr-busy-day');
								}
							}
						});
					}, 100);

				} else {
					console.error("La respuesta no es un objeto JSON:", response);
				}
			},
			error: function(xhr, status, error) {
				console.error("Error al obtener los datos de eventos:", status, error);
			}
		});
		//consigo el dia actual y lo clico para inicializar el evento dia actual
		var today = new Date();
		var currentDay = today.getDate(); // Día del mes (1-31)

		//console.log("Recorro los dias");
		// Paso 2: Buscar la celda correspondiente
		$('.yui3-calendar-day').each(function() {
			var cellText = $(this).text().trim();
			var cellDay = parseInt(cellText, 10);

			// Comparar el texto de la celda con el día actual
			if (cellDay === currentDay) {
				// Paso 3: Simular el clic en la celda correspondiente
				$(this).click();
				$(this).click();// Ejecuta el clic

			}
		});

	}


</script>
<script>

		Liferay.on('portletReady', function(event) {
			// Establecer visibilidad de .yui3-g.yui3-calendar-pane en 'hidden'
			$('.yui3-g.yui3-calendar-pane').css('visibility', 'hidden');

			// Simular clic en el enlace de mes anterior
			$('.yui3-calendarnav-prevmonth .sr-only').click();

			// Simular clic en el enlace de mes siguiente
			$('.yui3-calendarnav-nextmonth .sr-only').click();

			// Establecer visibilidad de .yui3-g.yui3-calendar-pane en 'hidden' nuevamente
			$('.yui3-g.yui3-calendar-pane').css('visibility', 'visible');
	});


</script>
<script>
	window.onerror = function(message, source, lineno, colno, error) {
		return true;
	};
</script>
<style>
	a.yui3-u.yui3-calendarnav-prevmonth::before {
		content: "";
		display: inline-block;
		width: 8px;
		height: 14px;
		background-image: url('<%= request.getContextPath() %>/images/prev-month.png');  /* Ruta a la imagen de "<" */
		background-size: contain;
		background-repeat: no-repeat;
	}

	/* Reemplazar la flecha derecha con una imagen */
	a.yui3-u.yui3-calendarnav-nextmonth::before {
		content: "";
		display: inline-block;
		width: 8px;
		height: 14px;
		background-image: url('<%= request.getContextPath() %>/images/next-month.png');  /* Ruta a la imagen de "<" */
		background-size: contain;
		background-repeat: no-repeat;
	}

</style>