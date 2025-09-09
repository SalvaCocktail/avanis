<%@ include file="/META-INF/resources/init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ page import="com.liferay.portal.kernel.theme.ThemeDisplay" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>

<%
    // Obtengo el nombre del usuario
    String userName = themeDisplay.getUser().getFirstName();

    // Formateo fecha
    Date currentDate = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("EEEE d 'de' MMMM 'de' yyyy", themeDisplay.getLocale());
    String formattedDate = sdf.format(currentDate);
%>

<div class="div-modal-left-title-desktop">
    <h5 class="modal-title modal-left-title">
        <liferay-ui:message key="all.events.calendar.title" />
    </h5>
</div>

<div class="div-modal-left-title-mobile">
    <h5 id="modal-left-title" class="modal-title"><%= userName %>, esta es tu agenda de eventos</h5>
    <p class="modal-left-date"><%= formattedDate %></p>
    <div class="div-left-link-to-calendar">
        <img class="candado" src="<%=request.getContextPath()%>/images/calendar.svg" alt="calendar" />
        <p class="modal-left-link-to-calendar">Ver calendario</p>
    </div>
</div>

<div class="next-events-mobile-title">
    <img class="candado back-to-allevents" src="<%=request.getContextPath()%>/images/arrow-back.svg" alt="arrow-back" />
    <p>Próximos eventos cerca de tí</p>
</div>
<liferay-portlet:runtime portletName="avanis_eventos_minicalendar_AvanisEventosMiniCalendar" />

<script>
    Liferay.on('portletReady', function(event) {
        // Verifica si el portlet cargado es el que te interesa
        if (event.portletId === 'avanis_eventos_minicalendar_AvanisEventosMiniCalendar') {
            // Ejecuta cualquier otro código que necesites
            //actualizarPuntitos();
        }
    });
</script>
