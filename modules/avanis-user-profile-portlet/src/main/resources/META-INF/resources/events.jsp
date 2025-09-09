<%@ page import="com.liferay.calendar.model.CalendarBooking" %>
<%@ page import="com.liferay.expando.kernel.model.ExpandoBridge" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.liferay.portal.kernel.util.DateUtil" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.liferay.asset.kernel.model.AssetEntry" %>
<%@ page import="com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil" %>
<%@ page import="com.liferay.asset.kernel.model.AssetCategory" %>
<%@ page import="java.util.List" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="com.liferay.petra.string.StringPool" %>
<%@ include file="./init.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


    <c:choose>
        <c:when test="${not empty events}">
            <div class="tab-mis-eventos">
            <c:forEach var="event" items="${events}">
                <c:set var="calendarBooking" value="${event}"/>
                <%
                    CalendarBooking calendarBooking = (CalendarBooking) pageContext.getAttribute("calendarBooking");
                    AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(
                            CalendarBooking.class.getName(), calendarBooking.getCalendarBookingId());
                    String eventURL = StringPool.BLANK;
                    List<AssetCategory> assetCategories = assetEntry.getCategories();
                    ExpandoBridge expandoBridge = calendarBooking.getExpandoBridge();
                    String urlImage = (String) expandoBridge.getAttribute("event_image_url");
                    String[] eventType = (String[]) expandoBridge.getAttribute("event_modality");
                    eventURL = (String) expandoBridge.getAttribute("event_url");
                    DateFormat timeFormat = new SimpleDateFormat("hh:mm a", themeDisplay.getLocale());
                %>

                <div class="av-te-ma-modal__text">
                    <div class="modal-datos-evento">
                        <div class="modal-left-img">
                            <% if (urlImage != null && !urlImage.isEmpty()) { %>
                            <img src="<%= urlImage %>" alt="Imagen del evento" class="event-image"/>
                            <% } else { %>
                            <img loading="lazy" src="<%=request.getContextPath()%>/images/vaca.png" alt="Imagen del evento" class="event-image"/>
                            <% } %>
                        </div>

                        <div class="modal-right-dates">

                            <a class="av-te-ma-modal__text-event-title" href="<%= themeDisplay.getURLPortal() %>/detalle-del-evento?eventTitle=<%= eventURL %>">
                                    ${event.getTitle(locale)}
                            </a>

                            <div class="contenido-right-dates">
                                <img class="calendario" src="<%=request.getContextPath()%>/images/calendario.svg"
                                     alt="calendario"/>
                                <span class="av-te-ma-modal__text-dates">Del <%= DateUtil.getDate(new Date(calendarBooking.getStartTime()), "EEEE d ", locale)%>
                                                al <%= DateUtil.getDate(new Date(calendarBooking.getEndTime()), "EEEE d 'de' MMMM", locale)%></span>
                            </div>
                            <div class="contenido-right-dates">
                                <img class="calendario" src="<%=request.getContextPath()%>/images/localizacion.svg"
                                     alt="localizacion"/>
                                <p>${event.getLocation()}
                                </p>
                            </div>

                            <div class="contenido-right-dates">
                                <img class="calendario" src="<%=request.getContextPath()%>/images/event-type.svg"
                                     alt="calendario"/>
                                <p><%= eventType.length > 0 ? eventType[0] : "" %>
                                </p>
                            </div>

                            <div class="contenido-right-dates">
                                <img class="calendario" src="<%=request.getContextPath()%>/images/clock.svg"
                                     alt="calendario"/>
                                <p><%= timeFormat.format(new Date(calendarBooking.getStartTime())) %>
                                    al <%=  timeFormat.format(new Date(calendarBooking.getEndTime())) %>
                                </p>
                            </div>
                            <div class="av-ed__mod001-categories">
                                <%
                                    if (assetCategories != null && !assetCategories.isEmpty()) {
                                        for (AssetCategory category : assetCategories) {
                                %>
                                <span class="av-ed__mod001-category"><%= category.getTitle(locale) %></span>
                                <%
                                        }
                                    }
                                %>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
            </div>
        </c:when>
        <c:otherwise>
            <%-- Empty State --%>
            <c:if test="${!signedIn or (signedIn and !me)}">
            <div>
                <div class="profile__non-data">
                    <h3 class="profile-card-title "> Este usuario no sigue aún ningún evento. </h3>
                    <p>  ¡Únete para empezar a seguir a tus eventos favoritos!
                        </br>

                    </p>

                    <a  href="${themeDisplay.getURLHome()}/tipo-registro"><button class="profile__button btn-crear-cuenta-gratis">
                        Crear cuenta gratis
                    </button></a>
                </div>
            </div>
        </c:if>
            <c:if test="${me}">
                <div>
                    <div class="profile__non-data">
                        <h3 class="profile-card-title "> Todavía no sigues ningún evento. </h3>
                        <p>  Visita la comunidad y encuentra tus eventos favoritos.
                            </br>

                        </p>

                        <a  href="${themeDisplay.getURLHome()}/comunidad"><button class="profile__button-publication">
                            Visitar la comunidad
                        </button></a>
                    </div>
                </div>
            </c:if>
        </c:otherwise>
    </c:choose>

