<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.liferay.calendar.model.CalendarBooking" %>
<%@ page import="com.liferay.expando.kernel.model.ExpandoBridge" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.liferay.portal.kernel.util.DateUtil" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ include file="/init.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<portlet:resourceURL var="followEventURL" id="follow"/>
<portlet:resourceURL var="unfollowEventURL" id="unfollow"/>


<%
    boolean isLoggedIn = themeDisplay.isSignedIn();
%>

<div class="av-ac-mp__buttons">
    <c:choose>
        <c:when test="${followed}">
            <button class="btn navbar__btn navbar__btn--outline modal-btn av-ac-mp__send btn-primary"
                    id="btn_avanis_seguir_evento" type="button">
                <span class="lfr-btn-label">Dejar de seguir</span>
            </button>
        </c:when>
        <c:otherwise>
            <button class="btn navbar__btn navbar__btn--primary modal-btn av-ac-mp__send btn-primary"
                    id="btn_avanis_seguir_evento" type="button">
                <span class="lfr-btn-label">Seguir evento</span>
            </button>
        </c:otherwise>
    </c:choose>
</div>

<!-- Modal seguir evento -->
<div class="modal-seguidores">
    <div id="alertModal" class="av-te-ma-modal alertModal">
        <div class="av-te-ma-modal__panel<%= isLoggedIn ? " modal-logado" : "" %>">
            <div class="av-te-ma-modal__header">
                <h5 class="modal-title" id="exampleModalLabel">Seguir este evento</h5>
                <span class="av-icon-close">&times;</span>
            </div>
            <div class="av-te-ma-modal__content">
                <%
                    if (!isLoggedIn) {
                %>
                <div class="av-te-ma-modal__text">
                    <span class="av-te-ma-modal__text-title"><strong>Para seguir este evento tienes que ser usuario Avanis, ¿creamos tu cuenta gratuita?</strong></span>
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
                                        class="google mb-2 undefined btn-100x100 btn-social-google"
                                >
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
                    <div class="av-buttons-tipo-registro js-btn-register-email" style="margin-top: 8px">
                        <a href="/tipo-registro?fromModal=true">
                            <button class="btn av-theme__btn av-theme__btn--primary btn-100x100 btn-secondary"
                                    id="_avanis_custom_login_AvanisCustomLoginPortlet_INSTANCE_mjei_umzz" type="button"
                                    label="">
                                <span class="lfr-btn-label">Regístrate con tu email</span>
                            </button>
                        </a>
                    </div>
                    <div class="seguir-politicas">Al hacer clic en Continuar con Google, Facebook, aceptas las 
                        <a href="condiciones-de-uso"><span
                                class="politicas-link">condiciones de uso</span></a> y la <a
                                href="/politica-de-privacidad"><span
                                class="politicas-link">política de privacidad</span></a> de
                        Avanis.
                    </div>
                </div>
                <!-- FIN Accede con google -->
                <%
                } else {
                %>
                <div class="av-te-ma-modal__text">
                    <c:set var="event" value="${calendarBooking}"/>
                    <%
                        CalendarBooking calendarBooking = (CalendarBooking) pageContext.getAttribute("event");
                        DateFormat timeFormat = new SimpleDateFormat("hh:mm a", themeDisplay.getLocale());

                        ExpandoBridge expandoBridge = calendarBooking.getExpandoBridge();
                        String urlImage = (String) expandoBridge.getAttribute("event_image_url");
                        String[] eventType = (String[]) expandoBridge.getAttribute("event_modality");
                    %>

                    <!-- Aquí se muestra la imagen si existe -->

                    <span class="av-te-ma-modal__text-title"><strong>Agrega este evento a tu listado de eventos personal</strong></span>
                    <span class="separador">Podrás consultarlo en tu perfil siempre que lo necesites </span>

                    <div class="modal-datos-evento">
                        <div class="modal-left-img">
                            <% if (urlImage != null && !urlImage.isEmpty()) { %>
                            <img src="<%= urlImage %>" alt="Imagen del evento" class="event-image"/>
                            <% } %>
                        </div>

                        <div class="modal-right-dates">
                            <p class="av-te-ma-modal__text-event-title"><strong><%= calendarBooking.getTitle(locale)%>
                            </strong></p>
                            <div class="contenido-right-dates">
                                <img class="calendario" src="<%=request.getContextPath()%>/images/calendario.svg"
                                     alt="calendario"/>
                                <span class="av-te-ma-modal__text-dates">Del <%= DateUtil.getDate(new Date(calendarBooking.getStartTime()), "EEEE d ", locale)%>
                                al <%= DateUtil.getDate(new Date(calendarBooking.getEndTime()), "EEEE d 'de' MMMM", locale)%></span>
                            </div>
                            <div class="contenido-right-dates">
                                <img class="calendario" src="<%=request.getContextPath()%>/images/localizacion.svg"
                                     alt="localizacion"/>
                                <p><%= calendarBooking.getLocation()%>
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
                        </div>


                    </div>


                    <p></p>
                    <div class="av-ac-mp__buttons">
                        <button class="btn navbar__btn navbar__btn--outline modal-btn av-ac-mp__cancel btn-secondary cancelar-seguir-evento"
                                style="width: 198px">Cancelar
                        </button>

                        <c:choose>
                            <c:when test="${followed}">
                                <button class="btn navbar__btn navbar__btn--outline modal-btn av-ac-mp__send btn-primary"
                                        id="follow-event-button"
                                        onclick="unfollowEvent()">Dejar de seguir
                                    evento
                                </button>
                            </c:when>
                            <c:otherwise>
                                <button class="btn navbar__btn navbar__btn--primary modal-btn av-ac-mp__send btn-primary"
                                        id="follow-event-button"
                                        onclick="followEvent()">Añadir a mis eventos
                                </button>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
                <script>

                    function followEvent() {
                        $.ajax({
                            url: '${followEventURL}',
                            type: 'POST',
                            dataType: "json",
                            data: {
                                <portlet:namespace />calendarBookingId: <%= calendarBooking.getCalendarBookingId() %>
                            },
                            success: function (r) {
                                $("#follow-event-button").off('click').on('click', unfollowEvent).text("Dejar de seguir");
                                $("#btn_avanis_seguir_evento").text("Dejar de seguir");
                                $('#follow-event-button, #btn_avanis_seguir_evento')
                                    .removeClass('navbar__btn--primary')
                                    .addClass('navbar__btn--outline');
                                Liferay.Util.openToast({    message: "Has comenzado a seguir este evento.",
                                    type: 'success',
                                    closeable: true,
                                });
                            },
                            error: function (r) {
                                console.log('Cannot commit that operation', r);
                            }
                        });
                    }

                    function unfollowEvent() {
                        $.ajax({
                            url: '${unfollowEventURL}',
                            type: 'POST',
                            dataType: "json",
                            data: {
                                <portlet:namespace />calendarBookingId: <%= calendarBooking.getCalendarBookingId() %>
                            },
                            success: function (r) {
                                $("#follow-event-button").off('click').on('click', followEvent).text("Añadir a mis eventos");
                                $("#btn_avanis_seguir_evento").text("Seguir evento");
                                $('#follow-event-button, #btn_avanis_seguir_evento')
                                    .addClass('navbar__btn--primary')
                                    .removeClass('navbar__btn--outline');
                                Liferay.Util.openToast({    message: "Has dejado de seguir este evento.",
                                    type: 'success',
                                    closeable: true,
                                });
                            },
                            error: function (r) {
                                console.log('Cannot commit that operation', r);
                            }
                        });
                    }
                </script>

                <%
                    }
                %>
            </div>
        </div>

    </div>
</div>

<script>
    $(document).ready(function () {
        // Función para ocultar el modal
        function closeModal() {
            $('.modal-seguidores .av-te-ma-modal').hide();  // Oculta el modal
        }

        // Función para mostrar el modal
        function showModal() {
            $('#alertModal').show();
        }

        // Mostrar el modal al hacer clic en el botón "Seguir evento"
        $('#btn_avanis_seguir_evento').on('click', function () {
            console.log("Btn clicado");
            showModal();
            console.log($('.modal-seguidores .av-te-ma-modal')); // Para verificar si selecciona el modal
        });

        // Cerrar modal al hacer clic en la "X"
        $('.av-icon-close,.cancelar-seguir-evento').click(function () {
            closeModal();
        });

        // Cerrar modal al presionar la tecla Escape
        $(document).keydown(function (event) {
            if (event.key === "Escape") {
                closeModal();
            }
        });
    });


</script>
