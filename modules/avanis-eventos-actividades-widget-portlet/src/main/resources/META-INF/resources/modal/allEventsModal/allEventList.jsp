<%@ page import="java.time.Duration" %>
<%@ include file="../../init.jsp"%>
<%
    String localeLanguage = request.getLocale().getLanguage();
    List<CalendarBooking> allEvents = (List<CalendarBooking>) renderRequest.getPortletSession().getAttribute(AvanisEventosWidgetEventosActividadesPortletKeys.ALL_EVENTS_LIST_FILTERED);

    if(Validator.isNull(allEvents)){
        allEvents = (	List<CalendarBooking>) renderRequest.getPortletSession().getAttribute(AvanisEventosWidgetEventosActividadesPortletKeys.ALL_EVENTS_LIST);

    }
%>
<%
    boolean isLoggedIn = themeDisplay.isSignedIn();
%>

<div class="modal-seguidores">
    <div id="alertModal" class="av-te-ma-modal alertModal">
        <div class="av-te-ma-modal__panel<%= isLoggedIn ? " modal-logado" : "" %>">
            <div class="av-te-ma-modal__header">
                <h5 class="modal-title" id="exampleModalLabel">Ver este evento</h5>
                <span class="av-icon-close">&times;</span>
            </div>
            <div class="av-te-ma-modal__content">
<div class="av-te-ma-modal__text">
    <span class="av-te-ma-modal__text-title"><strong>Crea tu cuenta gratis o inicia sesión para ver este evento</strong></span>
    <span id="modal-description">¿Ya eres miembro?
                        <a href="/login"><span id="iniciar-sesion-link">Inicia sesión</span></a>
                    </span>
</div>
<!-- Accede con google -->
<div class="my-3 av-form-content">
    <div class="av-social-login">
        <div>
            <div class="av-social-login-google">
                <a
                        href="${urlsessionGoogle}"
                        class="google mb-2 undefined btn-100x100 btn-social-google">
                    <svg width="18" height="18" xmlns="http://www.w3.org/2000/svg">
                        <g fill="#000" fill-rule="evenodd">
                            <path d="M9 3.48c1.69 0 2.83.73 3.48 1.34l2.54-2.48C13.46.89 11.43 0 9 0 5.48 0 2.44 2.02.96 4.96l2.91 2.26C4.6 5.05 6.62 3.48 9 3.48z"
                                  fill="#EA4335"></path>
                            <path d="M17.64 9.2c0-.74-.06-1.28-.19-1.84H9v3.34h4.96c-.1.83-.64 2.08-1.84 2.92l2.84 2.2c1.7-1.57 2.68-3.88 2.68-6.62z"
                                  fill="#4285F4"></path>
                            <path d="M3.88 10.78A5.54 5.54 0 0 1 3.58 9c0-.62.11-1.22.29-1.78L.96 4.96A9.008 9.008 0 0 0 0 9c0 1.45.35 2.82.96 4.04l2.92-2.26z"
                                  fill="#FBBC05"></path>
                            <path d="M9 18c2.43 0 4.47-.8 5.96-2.18l-2.84-2.2c-.76.53-1.78.9-3.12.9-2.38 0-4.4-1.57-5.12-3.74L.97 13.04C2.45 15.98 5.48 18 9 18z"
                                  fill="#34A853"></path>
                            <path fill="none" d="M0 0h18v18H0z"></path>
                        </g>
                    </svg>
                    <span style="padding: 10px 10px 10px 0px; font-weight: 500">Acceder con Google</span>
                </a>
            </div>
        </div>
    </div>
    <p class="mb-2">
        <strong>O si lo prefieres...</strong>
    </p>
    <div class="av-buttons-tipo-registro js-btn-register-email" style="margin-top: 8px; margin-bottom: 24px;">
    <a href="/tipo-registro?fromModal=true">
            <button class="btn av-theme__btn av-theme__btn--primary btn-100x100 btn-secondary"
                    id="_avanis_custom_login_AvanisCustomLoginPortlet_INSTANCE_mjei_umzz" type="button"
                    label="">
                <span class="lfr-btn-label">Regístrate con tu email</span>
            </button>
        </a>
    </div>
    <div class="seguir-politicas">Al hacer clic en Continuar con Google, aceptas las 
        <a href="condiciones-de-uso"><span
                class="politicas-link">condiciones de uso</span></a> y la <a
                href="/politica-de-privacidad"><span
                class="politicas-link">política de privacidad</span></a> de
        Avanis.
    </div>
</div>

</div>
</div>

</div>
</div>

<div class="av-modal-all-events-container">
    <div class="av-modal-all-events__content">
        <div class="av-list-events-left">
            <jsp:include page="/META-INF/resources/modal/allEventsModal/calendar.jsp"></jsp:include>
        </div>
    <div class="av-list-events-right">
        <h4 class="modal-right-title"><liferay-ui:message	key="all.events.list.title"/></h4>
        <div class="all-event-list"	id="<portlet:namespace />AllBookingList">
                <c:if test="<%= !allEvents.isEmpty() %>">
                <div class="all-event-success">
                    <%  //date to separate events by day
                        Date startDayTimeTitle = new Date();
                        for (CalendarBooking calendarBooking : allEvents) {
                            int contador = 0; // Inicializa el contador
                            long calendarBookingId = calendarBooking.getCalendarBookingId();
                            Date startDayTime =  new Date(calendarBooking.getStartTime());
                            Date endDayTime = new Date(calendarBooking.getEndTime());
                            boolean isSameDay = dayFormatToCompare.format(startDayTimeTitle).equals(dayFormatToCompare.format(startDayTime));
                            startDayTimeTitle = isSameDay? startDayTimeTitle : startDayTime;
                            String eventOrganizer = StringPool.BLANK;
                            String eventWebsite = StringPool.BLANK;
                            String eventType = "all";
                            String eventModality = "event.modality.";
                            String eventValue = "undefined";
                            String eventImageURL = StringPool.BLANK;
                            String eventURL = StringPool.BLANK;
                            boolean isCancelado = false;
                            boolean fechasPorConfirmar = false;

                            ExpandoBridge expandoBridge = calendarBooking.getExpandoBridge();
                            eventOrganizer = (String) expandoBridge.getAttribute("event_organizer");
                            eventWebsite = (String) expandoBridge.getAttribute("event_website");
                            String[] eventTypes = (String[]) expandoBridge.getAttribute("event_type");
                            String[] eventModalities = (String[]) expandoBridge.getAttribute("event_modality");
                            String[] eventValues = (String[]) expandoBridge.getAttribute("event_value");
                            eventImageURL = (String) expandoBridge.getAttribute("event_image_url");
                            isCancelado = (boolean) expandoBridge.getAttribute("cancelado");
                            fechasPorConfirmar = (boolean) expandoBridge.getAttribute("fechas_por_confirmar");
                            eventURL = (String) expandoBridge.getAttribute("event_url");
                            String modalityAux = Validator.isNotNull(eventTypes) && eventTypes.length>0?eventModality+eventModalities[0]:eventModality+"all";
                            eventModality = LanguageUtil.get(themeDisplay.getLocale(), modalityAux);
                            String location = Validator.isNotNull(calendarBooking.getLocation().isEmpty()) && calendarBooking.getLocation().isEmpty() && calendarBooking.getLocation().isBlank()?HtmlUtil.escape(calendarBooking.getLocation()):"event.to.define";

                             %>
                    <script>
                        calendarBookingIdsArray.push(<%= calendarBookingId %>);
                    </script>
                    <% if(!isSameDay) {
                     String dayName= HtmlUtil.escape(nameDayNameformat.format(startDayTimeTitle));
                     String dayNameCamelCase = dayName.substring(0, 1).toUpperCase()+ dayName.substring(1).toLowerCase();
                    %>
                    <span class="all-booking-day"> <%= dayNameCamelCase+HtmlUtil.escape(nameDayMonthformat.format(startDayTimeTitle)) %></span>
                    <% } %>

                    <%
                        String titleToUrlRedirect = StringPool.BLANK;
                        if (!eventURL.isBlank()) {
                            String originalTitle = eventURL;

                            if (originalTitle.contains("-")) {
                                for (int index = originalTitle.indexOf("-");
                                     index >= 0;
                                     index = originalTitle.indexOf("-", index + 1)) {
                                    titleToUrlRedirect = originalTitle.replaceAll("\\s+", "-").replaceAll("---", "-").replaceAll("--", "-");
                                }
                            } else {
                                titleToUrlRedirect = originalTitle.replaceAll("\\s+", "-");
                            }
                            titleToUrlRedirect = titleToUrlRedirect.toLowerCase();
                        }
                    %>
                    <a href="<%= themeDisplay.getURLPortal() %>/detalle-del-evento?eventTitle=<%= titleToUrlRedirect %>" class="all-booking-link">
                        <div class="all-booking-detail">
                            <div class="all-booking-image">
                                <% if ((!(eventImageURL == null)) && (!eventImageURL.isBlank())) { %>
                                <img loading="lazy" class="image-detail-event" src="<%= eventImageURL.replace("imagePreview=1", "imageThumbnail=1") %>" alt="<%= eventImageURL.replace("imagePreview=1", "imageThumbnail=1") %>" />
                                <% } else { %>
                                <img loading="lazy" class="image-detail-event" src="<%= request.getContextPath() %>/images/vaca.png" alt="image-detail-event" />
                                <% } %>
                            </div>
                            <div class="all-booking-text">
                                <div class="all-booking-text-font" id="<portlet:namespace />all-booking-title">
                                    <p class="all-booking-title"><%= HtmlUtil.escape(calendarBooking.getTitle(locale)) %></p>
                                </div>

                                <div class="all-booking-text-font" id="<portlet:namespace />all-booking-duration">
                                    <svg width="16" height="16" viewBox="0 0 16 16" fill="none" xmlns="http://www.w3.org/2000/svg">
                                        <path fill-rule="evenodd" clip-rule="evenodd" d="M4.66659 1.33301C5.03478 1.33301 5.33325 1.63148 5.33325 1.99967V2.66634H10.6666V1.99967C10.6666 1.63148 10.9651 1.33301 11.3333 1.33301C11.7014 1.33301 11.9999 1.63148 11.9999 1.99967V2.66636C12.3059 2.66655 12.5728 2.66843 12.7966 2.68672C13.0602 2.70825 13.3223 2.7558 13.5746 2.88433C13.9509 3.07608 14.2569 3.38204 14.4486 3.75836C14.5771 4.01061 14.6247 4.27276 14.6462 4.53632C14.6666 4.78603 14.6666 5.0892 14.6666 5.44063V11.8921C14.6666 12.2435 14.6666 12.5466 14.6462 12.7964C14.6247 13.0599 14.5771 13.3221 14.4486 13.5743C14.2569 13.9506 13.9509 14.2566 13.5746 14.4484C13.3223 14.5769 13.0602 14.6244 12.7966 14.646C12.5469 14.6664 12.2437 14.6664 11.8923 14.6663H4.10754C3.75612 14.6664 3.45295 14.6664 3.20323 14.646C2.93967 14.6244 2.67753 14.5769 2.42527 14.4484C2.04895 14.2566 1.74299 13.9506 1.55124 13.5743C1.42271 13.3221 1.37517 13.0599 1.35363 12.7964C1.33323 12.5466 1.33324 12.2435 1.33325 11.892V5.44065C1.33324 5.08921 1.33323 4.78604 1.35363 4.53632C1.37517 4.27276 1.42271 4.01061 1.55124 3.75836C1.74299 3.38204 2.04895 3.07607 2.42527 2.88433C2.67753 2.7558 2.93967 2.70825 3.20323 2.68672C3.42709 2.66843 3.6939 2.66655 3.99992 2.66636V1.99967C3.99992 1.63148 4.2984 1.33301 4.66659 1.33301ZM4.13325 3.99967C3.74888 3.99967 3.5007 4.00019 3.31181 4.01563C3.1307 4.03042 3.06356 4.05554 3.03059 4.07234C2.90515 4.13625 2.80316 4.23824 2.73925 4.36368C2.72245 4.39664 2.69734 4.46379 2.68254 4.6449C2.6671 4.83379 2.66659 5.08197 2.66659 5.46634V5.99967H13.3333V5.46634C13.3333 5.08197 13.3327 4.83379 13.3173 4.6449C13.3025 4.46379 13.2774 4.39664 13.2606 4.36368C13.1967 4.23824 13.0947 4.13625 12.9692 4.07234C12.9363 4.05554 12.8691 4.03042 12.688 4.01563C12.4991 4.00019 12.251 3.99967 11.8666 3.99967H4.13325ZM13.3333 7.33301H2.66659V11.8663C2.66659 12.2507 2.6671 12.4989 2.68254 12.6878C2.69734 12.8689 2.72245 12.936 2.73925 12.969C2.80316 13.0944 2.90515 13.1964 3.03059 13.2603C3.06356 13.2771 3.1307 13.3023 3.31181 13.3171C3.5007 13.3325 3.74888 13.333 4.13325 13.333H11.8666C12.251 13.333 12.4991 13.3325 12.688 13.3171C12.8691 13.3023 12.9363 13.2771 12.9692 13.2603C13.0947 13.1964 13.1967 13.0944 13.2606 12.969C13.2774 12.936 13.3025 12.8689 13.3173 12.6878C13.3327 12.4989 13.3333 12.2507 13.3333 11.8663V7.33301Z" fill="#101717"/>
                                    </svg>
                                    &emsp;
                                    Del
                                    <%= HtmlUtil.escape(dayOfWeekFormat.format(startDayTime)) %>
                                    <%= HtmlUtil.escape(dayFormat.format(startDayTime)) %>
                                    de
                                    <%= HtmlUtil.escape(monthFormat.format(startDayTime)) %>
                                    <liferay-ui:message key="event.widget.to" />
                                    <%= HtmlUtil.escape(dayOfWeekFormat.format(endDayTime)) %>
                                    <%= HtmlUtil.escape(dayFormat.format(endDayTime)) %>
                                    <% if (!monthFormat.format(startDayTime).equals(monthFormat.format(endDayTime))) { %>
                                    de <%= HtmlUtil.escape(monthFormat.format(endDayTime)) %>
                                    <% } %>
                                    de
                                    <%= HtmlUtil.escape(yearFormat.format(endDayTime)) %>

                                    <% if (fechasPorConfirmar) { %>
                                    <span class="etiqueta etiqueta-vencida" style="
                     background-color: #e9ebeb !important;
                     color: #101717 !important;
                     padding: 6px;
                     text-align: center;
                     border-radius: 8px;
                     margin-left: 10px;
                     font-size: 14px;
                     font-weight: 600;
                     line-height: 16px;
                 ">Por Confirmar</span>
                                    <% } %>

                                    <% if (isCancelado) { %>
                                    <span class="etiqueta etiqueta-vencida" style="
                     background-color: #EE606F !important;
                     color: #101717 !important;
                     padding: 6px;
                     text-align: center;
                     border-radius: 8px;
                     margin-left: 10px;
                     font-size: 14px;
                     font-weight: 600;
                     line-height: 16px;
                 ">Cancelado</span>
                                    <% } %>
                                </div>

                                <div class="all-booking-text-font" id="<portlet:namespace />all-booking-location">
                                    <svg width="16" height="16" viewBox="0 0 16 16" fill="none" xmlns="http://www.w3.org/2000/svg">
                                        <path fill-rule="evenodd" clip-rule="evenodd" d="M8.00008 2.66634C5.80852 2.66634 4.00008 4.49907 4.00008 6.79967C4.00008 7.91963 4.49071 8.97942 5.3254 10.0942C6.03117 11.0368 6.93442 11.9584 7.90833 12.9521C7.93885 12.9832 7.96943 13.0144 8.00008 13.0457C8.03073 13.0144 8.06132 12.9832 8.09183 12.9521C9.06574 11.9584 9.969 11.0368 10.6748 10.0942C11.5095 8.97942 12.0001 7.91963 12.0001 6.79967C12.0001 4.49907 10.1916 2.66634 8.00008 2.66634ZM2.66675 6.79967C2.66675 3.79835 5.03698 1.33301 8.00008 1.33301C10.9632 1.33301 13.3334 3.79835 13.3334 6.79967C13.3334 8.33069 12.6574 9.6709 11.7421 10.8934C10.9781 11.9137 10.0003 12.9107 9.02749 13.9026C8.84368 14.09 8.66005 14.2772 8.47808 14.4644C8.35256 14.5935 8.18015 14.6663 8.00008 14.6663C7.82001 14.6663 7.64761 14.5935 7.52208 14.4644C7.34011 14.2772 7.15648 14.09 6.97267 13.9026C5.99991 12.9107 5.02203 11.9137 4.25809 10.8934C3.34279 9.6709 2.66675 8.33069 2.66675 6.79967ZM8.00008 5.99967C7.63189 5.99967 7.33341 6.29815 7.33341 6.66634C7.33341 7.03453 7.63189 7.33301 8.00008 7.33301C8.36827 7.33301 8.66675 7.03453 8.66675 6.66634C8.66675 6.29815 8.36827 5.99967 8.00008 5.99967ZM6.00008 6.66634C6.00008 5.56177 6.89551 4.66634 8.00008 4.66634C9.10465 4.66634 10.0001 5.56177 10.0001 6.66634C10.0001 7.77091 9.10465 8.66634 8.00008 8.66634C6.89551 8.66634 6.00008 7.77091 6.00008 6.66634Z" fill="#101717"/>
                                    </svg>
                                    &emsp;
                                    <%= (calendarBooking.getLocation() == null || calendarBooking.getLocation().trim().isEmpty())
                                            ? "Ubicación no disponible"
                                            : HtmlUtil.escape(calendarBooking.getLocation()) %>
                                </div>
                                <div class="all-booking-text-font" id="<portlet:namespace />all-booking-type">
                                    <svg width="16" height="16" viewBox="0 0 16 16" fill="none" xmlns="http://www.w3.org/2000/svg">
                                        <path fill-rule="evenodd" clip-rule="evenodd" d="M4.10772 2H11.8924C12.2439 1.99999 12.5471 1.99998 12.7968 2.02038C13.0603 2.04191 13.3225 2.08946 13.5747 2.21799C13.9511 2.40973 14.257 2.7157 14.4488 3.09202C14.5773 3.34427 14.6248 3.60642 14.6464 3.86998C14.6668 4.11969 14.6668 4.42286 14.6667 4.77429V10C15.0349 10 15.3334 10.2985 15.3334 10.6667V11.2257C15.3334 11.5771 15.3334 11.8803 15.313 12.13C15.2915 12.3936 15.244 12.6557 15.1154 12.908C14.9237 13.2843 14.6177 13.5903 14.2414 13.782C13.9891 13.9105 13.727 13.9581 13.4634 13.9796C13.2137 14 12.9106 14 12.5591 14H3.44104C3.08961 14 2.78644 14 2.53673 13.9796C2.27317 13.9581 2.01102 13.9105 1.75877 13.782C1.38244 13.5903 1.07648 13.2843 0.884736 12.908C0.756207 12.6557 0.708663 12.3936 0.687129 12.13C0.666726 11.8803 0.666737 11.5771 0.666749 11.2257L0.666749 10.6667C0.666749 10.2985 0.965226 10 1.33342 10V4.77431C1.3334 4.42287 1.33339 4.1197 1.3538 3.86998C1.37533 3.60642 1.42287 3.34427 1.5514 3.09202C1.74315 2.7157 2.04911 2.40973 2.42544 2.21799C2.67769 2.08946 2.93983 2.04191 3.2034 2.02038C3.45311 1.99998 3.75629 1.99999 4.10772 2ZM2.00013 11.3333H5.55826C5.64559 11.3333 5.68918 11.3335 5.72084 11.3349C5.72167 11.335 5.72246 11.335 5.72323 11.3351C5.72379 11.3356 5.72439 11.3361 5.725 11.3367C5.74841 11.358 5.77935 11.3887 5.8411 11.4505L5.88292 11.4923C5.89073 11.5001 5.89874 11.5082 5.90694 11.5164C5.99623 11.6062 6.10866 11.7192 6.24623 11.8035C6.36552 11.8766 6.49558 11.9305 6.63163 11.9632C6.78852 12.0008 6.94794 12.0004 7.07455 12.0001C7.08618 12 7.09753 12 7.10858 12H8.89159C8.90264 12 8.91399 12 8.92561 12.0001C9.05222 12.0004 9.21165 12.0008 9.36853 11.9632C9.50458 11.9305 9.63464 11.8766 9.75394 11.8035C9.89151 11.7192 10.0039 11.6062 10.0932 11.5164C10.1014 11.5082 10.1094 11.5001 10.1172 11.4923L10.1591 11.4505C10.2208 11.3887 10.2518 11.358 10.2752 11.3367C10.2758 11.3361 10.2764 11.3356 10.2769 11.3351C10.2777 11.335 10.2785 11.335 10.2793 11.3349C10.311 11.3335 10.3546 11.3333 10.4419 11.3333H14C13.9997 11.6434 13.9977 11.8553 13.9841 12.0214C13.9693 12.2026 13.9442 12.2697 13.9274 12.3027C13.8635 12.4281 13.7615 12.5301 13.6361 12.594C13.6031 12.6108 13.536 12.6359 13.3549 12.6507C13.166 12.6661 12.9178 12.6667 12.5334 12.6667H3.46675C3.08238 12.6667 2.8342 12.6661 2.64531 12.6507C2.4642 12.6359 2.39705 12.6108 2.36409 12.594C2.23865 12.5301 2.13666 12.4281 2.07274 12.3027C2.05595 12.2697 2.03083 12.2026 2.01603 12.0214C2.00246 11.8553 2.00043 11.6434 2.00013 11.3333ZM13.3334 10V4.8C13.3334 4.41563 13.3329 4.16745 13.3175 3.97856C13.3027 3.79745 13.2775 3.7303 13.2608 3.69734C13.1968 3.5719 13.0949 3.46991 12.9694 3.406C12.9364 3.3892 12.8693 3.36408 12.6882 3.34929C12.4993 3.33385 12.2511 3.33333 11.8667 3.33333H4.13342C3.74905 3.33333 3.50086 3.33385 3.31197 3.34929C3.13086 3.36408 3.06372 3.3892 3.03076 3.406C2.90531 3.46991 2.80333 3.5719 2.73941 3.69734C2.72262 3.7303 2.6975 3.79745 2.6827 3.97856C2.66727 4.16745 2.66675 4.41563 2.66675 4.8V10H5.55826C5.5693 10 5.58065 9.99997 5.59228 9.99994C5.71889 9.9996 5.87831 9.99918 6.0352 10.0368C6.17125 10.0695 6.30131 10.1234 6.4206 10.1965C6.55817 10.2808 6.67061 10.3938 6.75989 10.4836C6.76809 10.4918 6.7761 10.4999 6.78391 10.5077L6.82574 10.5495C6.88749 10.6113 6.91842 10.642 6.94183 10.6633C6.94245 10.6639 6.94304 10.6644 6.9436 10.6649C6.94437 10.665 6.94517 10.665 6.94599 10.6651C6.97765 10.6665 7.02124 10.6667 7.10858 10.6667H8.89159C8.97892 10.6667 9.02251 10.6665 9.05417 10.6651C9.055 10.665 9.0558 10.665 9.05656 10.6649C9.05713 10.6644 9.05772 10.6639 9.05833 10.6633C9.08174 10.642 9.11268 10.6113 9.17443 10.5495L9.21626 10.5077C9.22407 10.4999 9.23208 10.4918 9.24028 10.4836C9.32956 10.3938 9.44199 10.2808 9.57956 10.1965C9.69886 10.1234 9.82892 10.0695 9.96496 10.0368C10.1219 9.99918 10.2813 9.9996 10.4079 9.99994C10.4195 9.99997 10.4309 10 10.4419 10H13.3334Z" fill="#101717"/>
                                    </svg>
                                    &emsp;
                                    <liferay-ui:message key="<%= eventModality %>" />
                                </div>
                                <div class="all-booking-text-font" id="<portlet:namespace />all-booking-hour">
                                    <svg width="16" height="16" viewBox="0 0 16 16" fill="none" xmlns="http://www.w3.org/2000/svg">
                                        <path fill-rule="evenodd" clip-rule="evenodd" d="M6.99992 1.66634C4.0544 1.66634 1.66659 4.05416 1.66659 6.99967C1.66659 9.94519 4.0544 12.333 6.99992 12.333C9.94544 12.333 12.3333 9.94519 12.3333 6.99967C12.3333 4.05416 9.94544 1.66634 6.99992 1.66634ZM0.333252 6.99967C0.333252 3.31778 3.31802 0.333008 6.99992 0.333008C10.6818 0.333008 13.6666 3.31778 13.6666 6.99967C13.6666 10.6816 10.6818 13.6663 6.99992 13.6663C3.31802 13.6663 0.333252 10.6816 0.333252 6.99967ZM6.99992 2.99967C7.36811 2.99967 7.66659 3.29815 7.66659 3.66634V6.62221L9.00958 7.42801C9.3253 7.61744 9.42768 8.02695 9.23825 8.34267C9.04882 8.65839 8.63931 8.76077 8.32359 8.57134L6.65692 7.57134C6.45612 7.45085 6.33325 7.23385 6.33325 6.99967V3.66634C6.33325 3.29815 6.63173 2.99967 6.99992 2.99967Z" fill="#101717"/>
                                    </svg>
                                    &emsp;
                                    <%= HtmlUtil.escape(hourformat.format(calendarBooking.getStartTime())) %> - <%= HtmlUtil.escape(hourformat.format(calendarBooking.getEndTime())) %>
                                </div>
                            </div>
                        </div>
                    </a>
                    <br/>
                    <%
                            contador++;
                        }
                    %>
                    </c:if>
                </div>
                <!-- empty list html -->
                <div class="all-event-error" style="display:none">
                    <img class="candado" src="<%=request.getContextPath()%>/images/calendar.png" alt="calendar" />
                    <p><liferay-ui:message	key="all.events.list.empty.message.part.one"/></p>
                    <p><liferay-ui:message	key="all.events.list.empty.message.part.two"/></p>
                </div>
            </div><!-- fin  all-events-list-->
    </div> <!--fin av-list-events right -->
    </div> <!--av-modal-all-events__content -->
</div>

<script>

    var userLoggedIn = <%= isLoggedIn %>;


    $(document).ready(function() {
        $('.all-booking-title').on('click', function(event) {
            if (!userLoggedIn) {  // Si el usuario no está logado
                event.preventDefault();  // Evitar que el enlace funcione como un enlace
                $('#alertModal').show();  // Mostrar el modal

                // También puedes añadir lógica para cerrar el modal
                $('.av-icon-close, .modal-seguidores').on('click', function() {
                    $('.modal-seguidores .av-te-ma-modal').hide();
                });
            }
        });
        /*menú interactivo eventos mobile, que muestra minicalendario o todos los eventos*/
        $('.div-left-link-to-calendar').on('click', function () {
            // Muestra minicalendario
            $('#p_p_id_avanis_eventos_minicalendar_AvanisEventosMiniCalendar_').show();

            // Ocultar la lista de todos los eventos
            $('.av-list-events-right').hide();
            $('.div-modal-left-title-mobile').hide();

            $('.next-events-mobile-title').css('display', 'flex');

        });
        /*menú que vuelve a todos los eventos*/
        $('.back-to-allevents').on('click', function () {
            // Ocultar el minicalendario
            $('#p_p_id_avanis_eventos_minicalendar_AvanisEventosMiniCalendar_').hide();

            // Mostrar la lista de todos los eventos
            $('.av-list-events-right').show();

            // Mostrar el título de eventos móviles
            $('.div-modal-left-title-mobile').show();

            // Ocultar .next-events-mobile-title
            $('.next-events-mobile-title').css('display', 'none');
        });
    });

</script>
