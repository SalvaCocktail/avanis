<%@ include file="./init.jsp"%>
<script>
	var calendarBookingIdsArray=[];
</script>



<div class="av-pe">
	<div class="av-pe__container">
        <c:if test="<%=showSiteCalendars%>">
            <div class="av-pe__header">
                <h4 class="av-pe__header-title">
                    <liferay-ui:message	key="event.widget.header.title"/>
                </h4>
                <c:if test="false">
                    <div class="av-pe__header-cta-dots" id="<portlet:namespace />dots-icon">
                        <svg width="16" height="4" viewBox="0 0 16 4"  fill="none" xmlns="http://www.w3.org/2000/svg" >
                            <path	fill-rule="evenodd" clip-rule="evenodd" d="M0 2C0 0.89543 0.89543 0 2 0C3.10457 0 4 0.89543 4 2C4 3.10457 3.10457 4 2 4C0.89543 4 0 3.10457 0 2ZM6 2C6 0.89543 6.89543 0 8 0C9.10457 0 10 0.89543 10 2C10 3.10457 9.10457 4 8 4C6.89543 4 6 3.10457 6 2ZM12 2C12 0.89543 12.8954 0 14 0C15.1046 0 16 0.89543 16 2C16 3.10457 15.1046 4 14 4C12.8954 4 12 3.10457 12 2Z" fill="black">
                            </path>
                        </svg>
                    </div>
                </c:if>
            </div>

            <div class="av-pe__separador"></div>

            <c:if test="<%=showSiteCalendars%>">
                <c:if test="<%= !siteCalendarBookings.isEmpty() %>">

                            <div class="success">
                        <%
                            for (CalendarBooking calendarBooking : siteCalendarBookings) {
                                int contador = 0; // Inicializa el contador
                                //CalendarResource calendarResource = calendarBooking.getCalendarResource();
                                //Calendar calendar = calendarBooking.getCalendar();
                                long calendarBookingId = calendarBooking.getCalendarBookingId();
                                //System.out.println("ID DE CALENDARIO: "+ calendarBookingId);
                                Date startDayTime = new Date(calendarBooking.getStartTime());
                                Date endDayTime = new Date(calendarBooking.getEndTime());
                                ExpandoBridge expandoBridge = calendarBooking.getExpandoBridge();
                                String eventURL = StringPool.BLANK;
                                eventURL = (String) expandoBridge.getAttribute("event_url");
                                boolean isCancelado = false;
                                isCancelado = (boolean) expandoBridge.getAttribute("cancelado");
                                boolean fechasPorConfirmar = false;
                                fechasPorConfirmar = (boolean) expandoBridge.getAttribute("fechas_por_confirmar");
                        %>
                        <script>
                            calendarBookingIdsArray.push(<%= calendarBookingId %>);
                            //console.log("calendarBookingIdsArray" + calendarBookingIdsArray);
                        </script>
                    <div class="av-pe__content">
                        <div class="av-pe__event" id="<portlet:namespace />siteBookingList">

                                <div class="av-pe__event-calendar">
                                    <div class="av-pe__calendar-month" id="<portlet:namespace />booking-month">
                                        <%= HtmlUtil.escape(monthFormat2.format(startDayTime).substring(0, 3)) %>

                                    </div>
                                    <div class="av-pe__calendar-day" id="<portlet:namespace />booking-day">
                                        <b><%= HtmlUtil.escape(dayFormat.format(startDayTime)) %></b>
                                    </div>
                                </div>

                            <div class="av-pe__event-text">
                                <div class="av-pe__event-title" id="<portlet:namespace />siteBookingList">
                                    <% if(eventURL.isBlank()){ %>
                                    <%= HtmlUtil.escape(calendarBooking.getTitle(locale))%>
                                    <% } else {
                                        String titleToUrlRedirect = StringPool.BLANK;
                                        String originalTitle= eventURL;

                                        if(originalTitle.contains("-")) {
                                            for (int index = originalTitle.indexOf("-");
                                                 index >= 0;
                                                 index = originalTitle.indexOf("-", index + 1)) {
                                                titleToUrlRedirect = originalTitle.replaceAll("\\s+", "-").replaceAll("---", "-").replaceAll("--", "-");
                                            }
                                        } else {
                                            titleToUrlRedirect = originalTitle.replaceAll("\\s+", "-");

                                        }
                                        titleToUrlRedirect= titleToUrlRedirect.toLowerCase();
                                    %>
                                    <a class="all-booking-title"  href="<%= themeDisplay.getURLPortal()%>/detalle-del-evento?eventTitle=<%= titleToUrlRedirect %>"><%= HtmlUtil.escape(calendarBooking.getTitle(locale)) %></a>
                                    <% } %>
                                </div>
                                <div class="av-pe__event-date"	id="<portlet:namespace />booking-duration">
                                    <liferay-ui:message	key="event.widget.del"/><%= HtmlUtil.escape(dayFormat.format(startDayTime)) %> <liferay-ui:message	key="event.widget.to"/> <%= HtmlUtil.escape(dayFormat.format(endDayTime)) %>
                                    <liferay-ui:message	key="event.widget.of"/> <%= HtmlUtil.escape(monthFormat2.format(endDayTime))%>
                                    <liferay-ui:message	key="event.widget.of"/> <%= HtmlUtil.escape(yearFormat.format(endDayTime))%>

                                    <% if(fechasPorConfirmar){ %>
                                        <span class="etiqueta etiqueta-vencida" style="
                                            background-color: #e9ebeb !important;
                                            color: #101717 !important;
                                            padding: 6px;
                                            text-align: center;
                                            border-radius: 8px;
                                            margin-left: 10px;
                                            font-size: 10px;
                                            font-weight: 600;
                                            line-height: 16px;
                                        ">Por Confirmar</span>
                                    <% } %>

                                    <% if(isCancelado){ %>
                                        <span class="etiqueta etiqueta-vencida" style="
                                            background-color: #EE606F !important;
                                            color: #101717 !important;
                                            padding: 6px;
                                            text-align: center;
                                            border-radius: 8px;
                                            margin-left: 10px;
                                            font-size: 10px;
                                            font-weight: 600;
                                            line-height: 16px;
                                        ">Cancelado</span>
                                    <% } %>
                                </div>
                                <div class="av-pe__event-location"	id="<portlet:namespace />booking-location">
                                    <%= HtmlUtil.escape(calendarBooking.getLocation()) %>
                                </div>
                            </div>
                        </div>
                    </div>
                        <%
                        contador++;
                        }
                        %>
                        </c:if>
                    </div>
                    <div id="success">

                    </div>
                <!-- empty list html -->
                <div class="error" style="display:none">
                    <img class="candado" src="<%=request.getContextPath()%>/images/calendar.png" alt="calendar" />
                    <p><liferay-ui:message	key="event.not.events1"/></p>
                    <p><liferay-ui:message	key="event.not.events2"/></p>
                </div>


                <div class="av-pe__footer">
                    <a class="av-pe__footer-text" href="/es/eventos">
                        <liferay-ui:message key="event.widget.show.all.events"/>
                    </a>
                </div>

            </c:if>
        </c:if>
	</div>
</div>

<c:if test="false">
    <jsp:include page="/modal/modalMenuFilter.jsp"></jsp:include>
    <jsp:include page="/modal/modalFilters.jsp"></jsp:include>
</c:if>



