<%@ include file="/init.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<%
    boolean isLoggedIn = themeDisplay.isSignedIn();
%>

<div class="modal-seguidores">
    <div id="alertModal" class="av-te-ma-modal alertModal">
        <div class="av-te-ma-modal__panel<%= isLoggedIn ? " modal-logado" : "" %>">
            <div class="av-te-ma-modal__header">
                <h5 class="modal-title" id="exampleModalLabel">Ver esta ayuda</h5>
                <span class="av-icon-close">&times;</span>
            </div>
            <div class="av-te-ma-modal__content">
                <div class="av-te-ma-modal__text">
                    <span class="av-te-ma-modal__text-title"><strong>Crea tu cuenta gratis o inicia sesión para ver esta ayuda</strong></span>
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


<div class="portlet-de-ayudas">
    <div id="ayudasModal"  style="display: block;">
        <div class="modal-content" >
            <div id="ayudasList">
                    <div class="modal-container">
                        <div class="next-events-mobile-title">
                            <img class="candado back-to-allevents" src="<%=request.getContextPath()%>/images/arrow-back.svg" alt="arrow-back" />
                            <p>Ayudas y subvenciones</p>
                        </div>
                        <div class="contenedor-left">
                            <h5 class="ayudas-calendar-left-title">Ayudas y subvenciones</h5>
                            <div class="div-left-link-to-calendar">
                                <img class="candado" src="<%=request.getContextPath()%>/images/calendar.svg" alt="calendar" />
                                <p class="modal-left-link-to-calendar">Ver calendario</p>
                            </div>
                            <div class="calendar-container">
                                <div class="calendar-header">
                                    <h2></h2>
                                    <div class="calendar-controls">
                                        <span class="month-year"></span>
                                        <div class="container-flechas">
                                            <button class="prev-month">&lt;</button>
                                            <button class="next-month">&gt;</button>
                                        </div>
                                    </div>
                                </div>
                                <table class="calendar">
                                    <thead>
                                        <tr>
                                            <th class="dias-calendario">L</th>
                                            <th class="dias-calendario">M</th>
                                            <th class="dias-calendario">X</th>
                                            <th class="dias-calendario">J</th>
                                            <th class="dias-calendario">V</th>
                                            <th class="dias-calendario">S</th>
                                            <th class="dias-calendario">D</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <!-- Aquí se rellenará el calendario dinámicamente con JavaScript -->
                                    </tbody>
                                </table>

                                <div class="ayudas-container">
                                    <div id="spinner-minicalendar" class="spinner-minicalendar" style="display: none;">
                                        <p>Cargando ayudas del mes...</p>
                                    </div>
                                    <div id="ayudasRelacionadas"></div>
                                </div>
                            </div>
                        </div>

                        <div class="tabs-container">
                            <h5 class="ayudas-title">Ayudas y subvenciones</h5>
                            <!-- Pestañas para cambiar entre Mi Explotaci&oacute;n y Todas las Ayudas -->
                            <div class="tabs">
                                <button class="tab-button active" id="tab-miExplotacion" onclick="mostrarSeccion('misAyudasContainer')">Mi Explotaci&oacute;n</button>
                                <button class="tab-button" id="tab-todasLasAyudas" onclick="mostrarSeccion('allAyudasContainer')">Todas las Ayudas</button>
                            </div>

                            <div class="search-container">
                                <input type="text" id="searchInput" oninput="filterAyudas()" placeholder="Buscar">
                            </div>

                            <!-- Contenido de las ayudas -->
                            <div class="ayudas-container">
                                <!-- Contenido de Mi Explotación -->
                                <div id="misAyudasContainer" class="seccion-ayudas" style="display: block;">
                                    <c:choose>
                                        <c:when test="${empty misAyudas}">
                                            <!-- Mostrar el mensaje cuando no hay ayudas disponibles -->
                                            <div class="no-ayudas">
                                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-emoji-frown" viewBox="0 0 16 16">
                                                    <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14m0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16"/>
                                                    <path d="M4.285 12.433a.5.5 0 0 0 .683-.183A3.5 3.5 0 0 1 8 10.5c1.295 0 2.426.703 3.032 1.75a.5.5 0 0 0 .866-.5A4.5 4.5 0 0 0 8 9.5a4.5 4.5 0 0 0-3.898 2.25.5.5 0 0 0 .183.683M7 6.5C7 7.328 6.552 8 6 8s-1-.672-1-1.5S5.448 5 6 5s1 .672 1 1.5m4 0c0 .828-.448 1.5-1 1.5s-1-.672-1-1.5S9.448 5 10 5s1 .672 1 1.5"/>
                                                </svg>
                                                <p>Lo sentimos, pero a&uacute;n no hay ayudas que mostrarte.</p>
                                                <p>Mientras, &iquest;Quieres seguir explorando Avanis?</p>
                                            </div>
                                        </c:when>
                                        <c:otherwise>
                                            <!-- Ayudas Activas -->
                                            <h5>Ayudas activas</h5>
                                            <c:forEach var="article" items="${misAyudas}">
                                                <c:choose>
                                                    <c:when test="${article.estado == 'Activa' || article.estado == 'Proxima a vencer' || article.estado == 'Proxima'}">

                                        <a href="${article.url}" class="area-clicable">
                                            <div class="ayuda-card activa">
                                            <div class="ayuda-card-left">
                                                        <c:choose>
                                                            <c:when test="${article.estado == 'Activa'}">
                                                                <img class="div-puntito" src="<%=request.getContextPath()%>/images/punto-verde.png" alt="Greendot" />
                                                            </c:when>
                                                            <c:when test="${article.estado == 'Proxima a vencer' or article.estado == 'Proxima'}">
                                                                <img class="div-puntito" src="<%=request.getContextPath()%>/images/punto-naranja.png" alt="Orangedot" />
                                                            </c:when>
                                                        </c:choose>
                                            </div>
                                            <div class="ayuda-card-right">
                                                <h4>
                                                            ${article.titulo}
                                                </h4>

                                                            <p>${article.descripcionCorta}</p>
                                                <div class="entidad">
                                                    <img class="img-entidad" src="<%=request.getContextPath()%>/images/fence.svg" alt="finca" width="24" height="24" /> ${article.entidad}
                                                </div>


                                                <div class="fecha">
                                                    <span class="icon-calendar-h">
                                                        <img class="img-calendar" src="<%=request.getContextPath()%>/images/calendar.png" alt="Fecha" />
                                                    </span>
                                                    <fmt:parseDate value="${article.fechaInicioSolicitud}" pattern="yyyy-MM-dd" var="fechaInicio" />
                                                    <fmt:parseDate value="${article.fechaFinSolicitud}" pattern="yyyy-MM-dd" var="fechaFin" />
                                                    <fmt:formatDate value="${fechaInicio}" pattern="dd/MM/yyyy" /> -
                                                    <fmt:formatDate value="${fechaFin}" pattern="dd/MM/yyyy" />

                                                    <c:choose>
                                                        <c:when test="${article.estado == 'Proxima'}">
                                                            <span class="etiqueta etiqueta-vence">Próxima</span>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <span class="etiqueta ${article.estado == 'Activa' ? 'etiqueta-activa' : 'etiqueta-vence'}">
                                                                    ${article.estado == 'Proxima a vencer' ? 'Vence pronto' : article.estado}
                                                            </span>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </div>
                                                            <div class="monto">
                                                                <img class="img-monto" src="<%=request.getContextPath()%>/images/monto.svg" alt="Monto" width="24" height="24" /> ${article.monto}
                                                            </div>

                                                            <div class="tags">
                                                                <c:forEach var="category" items="${article.categories}">
                                                                    <span class="tag">${category}</span>
                                                                </c:forEach>
                                                            </div>
                                                        </div>
                                            </div>
                                        </a>
                                                    </c:when>
                                                </c:choose>
                                            </c:forEach>

                                            <!-- Separador para las Ayudas Vencidas -->
                                            <h5>Ayudas vencidas</h5>
                                            <c:forEach var="article" items="${misAyudas}">
                                                <c:choose>
                                                    <c:when test="${article.estado == 'Vencida'}">
                                        <a href="${article.url}" class="area-clicable">
                                                        <div class="ayuda-card vencida">
                                                            <div class="ayuda-card-left">
                                                                <img class="div-puntito" src="<%=request.getContextPath()%>/images/punto-gris.png" alt="Greendot" />

                                                            </div>
                                                            <div class="ayuda-card-right">
                                                                <h4>

                                                                            ${article.titulo}

                                                                </h4>

                                                                <p>${article.descripcionCorta}</p>
                                                                <div class="entidad">
                                                                    <img class="img-entidad" src="<%=request.getContextPath()%>/images/fence.svg" alt="finca" width="24" height="24" /> ${article.entidad}
                                                                </div>

                                                                <div class="fecha">
                                                                    <span class="icon-calendar-h"><img class="img-calendar" src="<%=request.getContextPath()%>/images/calendar.png" alt="Fecha" /></span>
                                                                    <fmt:parseDate value="${article.fechaInicioSolicitud}" pattern="yyyy-MM-dd" var="fechaInicio" />
                                                                    <fmt:parseDate value="${article.fechaFinSolicitud}" pattern="yyyy-MM-dd" var="fechaFin" />
                                                                    <fmt:formatDate value="${fechaInicio}" pattern="dd/MM/yyyy" /> -
                                                                    <fmt:formatDate value="${fechaFin}" pattern="dd/MM/yyyy" />
                                                                    <span class="etiqueta etiqueta-vencida">Vencida</span>
                                                                </div>
                                                                <div class="monto">
                                                                    <img class="img-monto" src="<%=request.getContextPath()%>/images/monto.svg" alt="Monto" width="24" height="24" /> ${article.monto}
                                                                </div>
                                                                <div class="tags">
                                                                    <c:forEach var="category" items="${article.categories}">
                                                                        <span class="tag">${category}</span>
                                                                    </c:forEach>
                                                                </div>
                                                            </div>
                                                        </div>
                                        </a>
                                                    </c:when>
                                                </c:choose>
                                            </c:forEach>
                                        </c:otherwise>
                                    </c:choose>
                                </div>

                                <!-- Contenido de Todas las Ayudas -->
                                <div id="allAyudasContainer" class="seccion-ayudas" style="display:none">
                                    <!-- Ayudas Activas (Incluye Activas y Proximas a Vencer) -->
                                    <h5>Ayudas activas</h5>
                                    <c:forEach var="article" items="${allAyudas}">
                                        <c:choose>
                                            <c:when test="${article.estado == 'Activa' || article.estado == 'Proxima a vencer' || article.estado == 'Proxima'}">
                                    <a href="${article.url}" class="area-clicable">
                                        <div class="ayuda-card activa">
                                                    <div class="ayuda-card-left">
                                                    <c:choose>
                                                        <c:when test="${article.estado == 'Activa'}">
                                                            <img class="div-puntito" src="<%=request.getContextPath()%>/images/punto-verde.png" alt="Greendot" />
                                                        </c:when>
                                                        <c:when test="${article.estado == 'Proxima a vencer' || article.estado == 'Proxima'}">
                                                            <img class="div-puntito" src="<%=request.getContextPath()%>/images/punto-naranja.png" alt="Orangedot" />
                                                        </c:when>
                                                    </c:choose>
                                                    </div>
                                                        <div class="ayuda-card-right">
                                                            <h4>
                                                                    ${article.titulo}

                                                            </h4>

                                                            <p>${article.descripcionCorta}</p>
                                                            <div class="entidad">
                                                                <img class="img-entidad" src="<%=request.getContextPath()%>/images/fence.svg" alt="finca" width="24" height="24" /> ${article.entidad}
                                                            </div>

                                                            <div class="fecha">
                                                                <span class="icon-calendar-h"><img class="img-calendar" src="<%=request.getContextPath()%>/images/calendar.png" alt="Fecha" /></span>
                                                                <fmt:parseDate value="${article.fechaInicioSolicitud}" pattern="yyyy-MM-dd" var="fechaInicio" />
                                                                <fmt:parseDate value="${article.fechaFinSolicitud}" pattern="yyyy-MM-dd" var="fechaFin" />
                                                                <fmt:formatDate value="${fechaInicio}" pattern="dd/MM/yyyy" /> -
                                                                <fmt:formatDate value="${fechaFin}" pattern="dd/MM/yyyy" />
                                                                <c:choose>
                                                                    <c:when test="${article.estado == 'Proxima'}">
                                                                        <span class="etiqueta etiqueta-vence">Próxima</span>
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        <span class="etiqueta ${article.estado == 'Activa' ? 'etiqueta-activa' : 'etiqueta-vence'}">
                                                                                ${article.estado == 'Proxima a vencer' ? 'Vence pronto' : article.estado}
                                                                        </span>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </div>
                                                            <div class="monto">
                                                                <img class="img-monto" src="<%=request.getContextPath()%>/images/monto.svg" alt="Monto" width="24" height="24" /> ${article.monto}
                                                            </div>
                                                            <div class="tags">
                                                                <c:forEach var="category" items="${article.categories}">
                                                                    <span class="tag">${category}</span>
                                                                </c:forEach>
                                                            </div>
                                                    </div>
                                                </div>
                                    </a>
                                            </c:when>
                                        </c:choose>
                                    </c:forEach>

                                    <!-- Separador para las Ayudas Vencidas -->
                                    <h5>Ayudas vencidas</h5>
                                    <c:forEach var="article" items="${allAyudas}">
                                        <c:choose>
                                            <c:when test="${article.estado == 'Vencida'}">
                                            <a href="${article.url}" class="area-clicable">
                                                <div class="ayuda-card vencida">
                                                    <div class="ayuda-card-left">
                                                                <img class="div-puntito" src="<%=request.getContextPath()%>/images/punto-gris.png" alt="Greendot" />

                                                    </div>
                                                    <div class="ayuda-card-right">
                                                        <h4>
                                                                ${article.titulo}
                                                        </h4>

                                                        <p>${article.descripcionCorta}</p>

                                                        <div class="entidad">
                                                            <img class="img-entidad" src="<%=request.getContextPath()%>/images/fence.svg" alt="finca" width="24" height="24" /> ${article.entidad}
                                                        </div>

                                                        <div class="fecha">
                                                            <span class="icon-calendar-h"><img class="img-calendar" src="<%=request.getContextPath()%>/images/calendar.png" alt="Fecha" /></span>
                                                            <fmt:parseDate value="${article.fechaInicioSolicitud}" pattern="yyyy-MM-dd" var="fechaInicio" />
                                                            <fmt:parseDate value="${article.fechaFinSolicitud}" pattern="yyyy-MM-dd" var="fechaFin" />
                                                            <fmt:formatDate value="${fechaInicio}" pattern="dd/MM/yyyy" /> -
                                                            <fmt:formatDate value="${fechaFin}" pattern="dd/MM/yyyy" />
                                                            <span class="etiqueta etiqueta-vencida">Vencida</span>
                                                        </div>
                                                        <div class="monto">
                                                            <img class="img-monto" src="<%=request.getContextPath()%>/images/monto.svg" alt="Monto" width="24" height="24" /> ${article.monto}
                                                        </div>
                                                        <div class="tags">
                                                            <c:forEach var="category" items="${article.categories}">
                                                                <span class="tag">${category}</span>
                                                            </c:forEach>
                                                        </div>
                                                    </div>
                                                </div>
                                    </a>
                                            </c:when>
                                        </c:choose>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
            </div>
        </div>
    </div><!--Fin ayudasModal-->
</div>

<script>
    let currentDate = new Date();
    const prevMonthButton = document.querySelector(".prev-month");
    const nextMonthButton = document.querySelector(".next-month");
    prevMonthButton.addEventListener("click", function () {

        const newDate = new Date(currentDate.getFullYear(), currentDate.getMonth() - 1, 1);
        currentDate = newDate;


        renderCalendarPlaceholder(currentDate);
        // Llamo a obtenerFechasAyudas con el nuevo mes y año
        const mes = currentDate.getMonth() + 1;
        const anio = currentDate.getFullYear();
        obtenerFechasAyudas(mes, anio);
    });

    nextMonthButton.addEventListener("click", function () {
        const newDate = new Date(currentDate.getFullYear(), currentDate.getMonth() + 1, 1);
        currentDate = newDate;
        renderCalendarPlaceholder(currentDate);

        const mes = currentDate.getMonth() + 1;
        const anio = currentDate.getFullYear();
        obtenerFechasAyudas(mes, anio);
    });
    $( document ).ready(function() {
        verificarBuscador();

        renderCalendarPlaceholder(currentDate);
        obtenerFechasAyudas(currentDate.getMonth() + 1, currentDate.getFullYear());
    });

    function obtenerFechasAyudas(mes, anio) {
        document.getElementById("spinner-minicalendar").style.display = "flex";
        document.getElementById("ayudasRelacionadas").innerHTML = "";

        $.ajax({
            url: '${obtenerAyudasCalendario}',
            type: 'POST',
            data: JSON.stringify({ mes: mes, anio: anio }),
            dataType: 'json',
                contentType: 'application/json; charset=UTF-8',
            success: function(response) {
                let ayudas = response.allAyudas;
                listadoAyudas = ayudas; // Actualiza las ayudas globalmente
                inicializarCalendario(ayudas); // Llama a inicializarCalendario con las ayudas cargadas
            },
            error: function(xhr, status, error) {
                console.error("Error al obtener las fechas de las ayudas:", error);
            },
            complete: function() {
                // Ocultar el spinner después de completar la solicitud
                $("#spinner-minicalendar").fadeOut(500);
            }
        });
    }

    function verificarBuscador() {
        const misAyudasContainer = document.getElementById('misAyudasContainer');
        const ayudaCards = misAyudasContainer.querySelectorAll('.ayuda-card');
        const searchInput = document.getElementById("searchInput");

        if (ayudaCards.length === 0) {
            searchInput.disabled = true;
            searchInput.placeholder = "No hay ayudas para buscar";
        } else {
            searchInput.disabled = false;
            searchInput.placeholder = "Buscar";
        }
    }

    //CODIGO OPTIMIZAR CALENDARIO
    function renderCalendarPlaceholder(date) {

        const meses = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"];
        const calendarBody = document.querySelector(".calendar tbody");
        const monthYearLabel = document.querySelector(".month-year");

        // Mostrar mes y año en el encabezado
        const month = date.getMonth();
        const year = date.getFullYear();
        monthYearLabel.textContent = meses[month] + " " + year;

        calendarBody.innerHTML = ""; // Limpia el calendario

        const firstDayOfMonth = new Date(year, month, 1).getDay();
        const adjustedFirstDay = (firstDayOfMonth === 0) ? 6 : firstDayOfMonth - 1; // Ajuste: Lunes = 0, Domingo = 6
        const daysInMonth = new Date(year, month + 1, 0).getDate();

        let dayCounter = 1;

        // Crear filas del calendario
        for (let i = 0; i < 6; i++) {
            const row = document.createElement("tr");

            for (let j = 0; j < 7; j++) {
                const cell = document.createElement("td");

                if (i === 0 && j < adjustedFirstDay || dayCounter > daysInMonth) {
                    row.appendChild(cell);
                    continue;
                }

                cell.textContent = dayCounter;
                cell.classList.add("dia-placeholder"); // Clase base para cada día vacío

                row.appendChild(cell);
                dayCounter++;
            }

            calendarBody.appendChild(row);
        }
        document.querySelector(".calendar").style.visibility = "visible";
    }


    function inicializarCalendario(ayudas) {

        const meses = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"];
        const calendarBody = document.querySelector(".calendar tbody");
        const monthYearLabel = document.querySelector(".month-year");

        const ayudasRelacionadasContainer = document.getElementById('ayudasRelacionadas');

        //let currentDate = new Date(); // Fecha actual del sistema

        function getAdjustedDay(day) {
            return (day === 0) ? 6 : day - 1;
        }

        // Normaliza las fechas para eliminar las horas y trabajar en UTC
        function normalizeDateToUTC(date) {
            const utcDate = new Date(date.getUTCFullYear(), date.getUTCMonth(), date.getUTCDate());
            return utcDate;
        }

        // Función para mostrar las ayudas asociadas a una fecha
        function mostrarAyudasParaFecha(fecha) {
            ayudasRelacionadasContainer.innerHTML = "";
            const ayudasDeFecha = listadoAyudas.filter(function(ayuda) {
                let fechaInicio = normalizeDateToUTC(new Date(ayuda.fechaInicioSolicitud));
                let fechaFin = normalizeDateToUTC(new Date(ayuda.fechaFinSolicitud));

                // Comprobamos si la fecha seleccionada es igual a la fecha de inicio o de fin
                return fecha.getTime() === fechaInicio.getTime() || fecha.getTime() === fechaFin.getTime();
            });

            // Si encontramos ayudas para esa fecha, las mostramos
            if (ayudasDeFecha.length > 0) {
                ayudasDeFecha.forEach(function(ayuda) {
                    // Asegurarse de que los valores existen
                    let titulo = ayuda.titulo || 'Sin título disponible';
                    let entidad = ayuda.entidad || 'Sin entidad disponible';
                    let descripcionCorta = ayuda.descripcionCorta || 'Sin descripción disponible';
                    let fechaFinSolicitud = ayuda.fechaFinSolicitud || 'Sin fecha disponible';
                    let estado = ayuda.estado || 'Sin estado disponible';
                    let monto = ayuda.monto || 'Sin monto disponible';
                    //let categories = (ayuda.categories && ayuda.categories.length > 0) ? ayuda.categories.join(", ") : 'Sin categorías disponibles';

                    // Crear un div para la ayuda
                    let divAyuda = document.createElement("div");
                    divAyuda.classList.add("ayuda-item");
                    let divAyudaLeft = document.createElement("div");
                    divAyudaLeft.classList.add("ayuda-item-left");

                    let divAyudaRight = document.createElement("div");
                    divAyudaRight.classList.add("ayuda-item-right");

                    // Crear el elemento para el puntito según el estado
                    let puntitoElemento = document.createElement("img");
                    puntitoElemento.classList.add("img-puntito");

                    if (estado === "Activa") {
                        puntitoElemento.src = "<%=request.getContextPath()%>/images/punto-verde.png";
                        puntitoElemento.alt = "Greendot";
                    } else if (estado === "Proxima") {
                        puntitoElemento.src = "<%=request.getContextPath()%>/images/punto-naranja.png";
                        puntitoElemento.alt = "Orangedot";
                    } else if (estado === "Proxima a vencer") {
                        puntitoElemento.src = "<%=request.getContextPath()%>/images/punto-naranja.png";
                        puntitoElemento.alt = "Orangedot";
                    } else if (estado === "Vencida") {
                        puntitoElemento.src = "<%=request.getContextPath()%>/images/punto-gris.png";
                        puntitoElemento.alt = "Greydot";
                    }

                    divAyudaLeft.appendChild(puntitoElemento);

                    // Crear los elementos para los datos
                    let tituloElemento = document.createElement("h4");
                    tituloElemento.textContent = titulo;

                    let entidadElemento = document.createElement("p");
                    entidadElemento.innerHTML = entidad;
                    entidadElemento.classList.add("p-entidad");


                    let descripcionElemento = document.createElement("p");
                    descripcionElemento.innerHTML = descripcionCorta;
                    descripcionElemento.classList.add("p-descripcion");

                    let montoElemento = document.createElement("p");
                    montoElemento.innerHTML = monto;

                    let fechaFinElemento = document.createElement("p");
                    fechaFinElemento.innerHTML = fechaFinSolicitud + "("+estado+")";

                    // Crear el contenedor de categorías
                    let categoriasElemento = document.createElement("div");
                    categoriasElemento.classList.add("tags");

                    if (ayuda.categories && ayuda.categories.length > 0) {
                        ayuda.categories.forEach(category => {
                            let span = document.createElement("span");
                            span.classList.add("tag");
                            span.textContent = category; // Asignar el texto de la categoría
                            categoriasElemento.appendChild(span);
                        });
                    }

                    // Añadir los datos al divAyudaRight
                    divAyudaRight.appendChild(tituloElemento);
                    //divAyudaRight.appendChild(entidadElemento);
                    divAyudaRight.appendChild(descripcionElemento);
                    //divAyudaRight.appendChild(montoElemento);
                    //divAyudaRight.appendChild(fechaFinElemento);
                    divAyudaRight.appendChild(categoriasElemento);

                    // Añadir ambos divs (left y right) al divAyuda
                    divAyuda.appendChild(divAyudaLeft);
                    divAyuda.appendChild(divAyudaRight);

                    // Añadir la ayuda al contenedor de ayudas
                    ayudasRelacionadasContainer.appendChild(entidadElemento);
                    ayudasRelacionadasContainer.appendChild(divAyuda);
                });
            } else {
                ayudasRelacionadasContainer.innerHTML = `<p>No hay ayudas asociadas a esta fecha.</p>`;
            }
        }

        function renderCalendar(date) {
            calendarBody.innerHTML = "";
            const month = date.getMonth(); // Obtener el mes actual
            const year = date.getFullYear(); // Obtener el año actual

            // Mostrar mes y año en el encabezado
            monthYearLabel.textContent = meses[month] + " " + year;

            const firstDayOfMonth = new Date(year, month, 1);
            const lastDayOfMonth = new Date(year, month + 1, 0);
            const firstDayIndex = getAdjustedDay(firstDayOfMonth.getDay());
            const daysInMonth = lastDayOfMonth.getDate();

            let today = normalizeDateToUTC(new Date());
            let dayCounter = 1;

            // Crear las filas del calendario
            for (let i = 0; i < 6; i++) {
                const row = document.createElement("tr");

                for (let j = 0; j < 7; j++) {
                    const cell = document.createElement("td");

                    if (i === 0 && j < firstDayIndex || dayCounter > daysInMonth) {
                        row.appendChild(cell);
                        continue;
                    }

                    cell.textContent = dayCounter;

                    // Normalizar la fecha actual del calendario
                    let currentDateInCalendar = normalizeDateToUTC(new Date(year, month, dayCounter +1));

                    // Marcar el día actual
                    if (currentDateInCalendar.getTime() === today.getTime()) {

                        cell.classList.add("current-day"); // Clase para el día actual
                    }

                    // Contenedor de puntos
                    let dotContainer = document.createElement("div");
                    dotContainer.classList.add("dot-container");

                    // Comparar si es la fecha de inicio o de fin de las ayudas
                    ayudas.forEach(function(ayuda) {
                        let fechaInicio = normalizeDateToUTC(new Date(ayuda.fechaInicioSolicitud));
                        let fechaFin = normalizeDateToUTC(new Date(ayuda.fechaFinSolicitud));

                        // Si coincide con la fecha de inicio o fin
                        if (currentDateInCalendar.getTime() === fechaInicio.getTime() || currentDateInCalendar.getTime() === fechaFin.getTime()) {

                            // Solo añadir un máximo de 3 puntos
                            if (dotContainer.childElementCount < 3) {

                                // Determinar el estado de la ayuda y mostrar el punto correspondiente
                                if (ayuda.estado === 'Activa') {
                                    let greenDot = document.createElement("span");
                                    greenDot.classList.add("dot", "dot-green"); // Punto verde para fecha activa
                                    dotContainer.appendChild(greenDot);
                                }

                                if (ayuda.estado === 'Proxima') {
                                    let orangeDot = document.createElement("span");
                                    orangeDot.classList.add("dot", "dot-orange"); // Punto naranja para proxima a vencer
                                    dotContainer.appendChild(orangeDot);
                                }

                                if (ayuda.estado === 'Proxima a vencer') {
                                    let orangeDot = document.createElement("span");
                                    orangeDot.classList.add("dot", "dot-orange"); // Punto naranja para proxima a vencer
                                    dotContainer.appendChild(orangeDot);
                                }

                                if (ayuda.estado === 'Vencida' && currentDateInCalendar.getTime() === fechaFin.getTime()) {
                                    let redDot = document.createElement("span");
                                    redDot.classList.add("dot", "dot-red"); // Punto rojo para vencida
                                    dotContainer.appendChild(redDot);
                                }
                            }
                        }
                    });

                    // Si hay puntos en el contenedor, lo añadimos a la celda
                    if (dotContainer.childElementCount > 0) {
                        cell.appendChild(dotContainer);
                    }

                    // Aplicar clase de días pasados (grises)
                    if (currentDateInCalendar.getTime() < today.getTime()) {
                        cell.classList.add("past-day", "dia"); // Clase para días pasados
                        let dots = cell.querySelectorAll('.dot');
                        dots.forEach(function(dot) {
                            dot.classList.add('dot-gray'); // Convertir puntos a grises si están en días pasados
                        });
                    }

                    // Añadir el event listener para mostrar las ayudas asociadas al hacer clic en el día
                    cell.addEventListener('click', function() {
                        mostrarAyudasParaFecha(currentDateInCalendar);
                    });

                    row.appendChild(cell);
                    dayCounter++;
                }

                calendarBody.appendChild(row);
            }
        }



        // Renderizar el calendario al cargar
        renderCalendar(currentDate);
        $('table.calendar tbody td').addClass('dia');
    }

    function mostrarSeccion(seccionId) {
        document.querySelectorAll('.seccion-ayudas').forEach(function(seccion) {
            seccion.style.display = 'none';
        });

        var activeSection = document.getElementById(seccionId);
        if (activeSection) {
            activeSection.style.display = 'block';
        }

        document.querySelectorAll('.tab-button').forEach(function(tab) {
            tab.classList.remove('active');
        });

        var activeButton = document.getElementById('tab-' + seccionId);
        if (activeButton) {
            activeButton.classList.add('active');
        }

        verificarBuscador(); // Verifica el estado del buscador cada vez que cambies de pestaña
    }

    // Función para mostrar la sección correspondiente
    function mostrarSeccion(seccionId) {
        // Oculta todas las secciones
        document.querySelectorAll('.seccion-ayudas').forEach(function(seccion) {
            seccion.style.display = 'none';
        });

        // Muestra la sección seleccionada
        var activeSection = document.getElementById(seccionId);
        if (activeSection) {
            activeSection.style.display = 'block';
        }

        // Cambia la clase activa del botón
        document.querySelectorAll('.tab-button').forEach(function(tab) {
            tab.classList.remove('active');
        });

        // Aquí cambia el botón activo basándote en el seccionId
        var activeButton = null;
        if (seccionId === 'misAyudasContainer') {
            activeButton = document.getElementById('tab-miExplotacion');
        } else if (seccionId === 'allAyudasContainer') {
            activeButton = document.getElementById('tab-todasLasAyudas');
        }

        if (activeButton) {
            activeButton.classList.add('active');
        }

        // Habilitar/deshabilitar el campo de búsqueda según la sección activa
        var searchInput = document.getElementById("searchInput");
        var ayudaCards = activeSection ? activeSection.querySelectorAll('.ayuda-card') : [];

        if (ayudaCards.length === 0) {
            searchInput.disabled = true;
            searchInput.placeholder = "No hay ayudas para buscar";
        } else {
            searchInput.disabled = false;
            searchInput.placeholder = "Buscar";
        }
    }


    // Muestra por defecto la sección "Mi Explotación"
    document.addEventListener("DOMContentLoaded", function() {
        mostrarSeccion('misAyudasContainer');
    });

    function filterAyudas() {
        var input = document.getElementById("searchInput");
        var filter = input.value.toLowerCase();
        var activeSection = document.querySelector('.seccion-ayudas[style="display: block;"]');
        var ayudaCards = activeSection.querySelectorAll('.ayuda-card');

        ayudaCards.forEach(function(card) {
            var title = card.querySelector('h4').textContent.toLowerCase();
            var entidad = card.querySelector('.entidad').textContent.toLowerCase();
            var descripcion = card.querySelector('p').textContent.toLowerCase();

            if (title.includes(filter) || entidad.includes(filter) || descripcion.includes(filter)) {
                card.style.display = "";
            } else {
                card.style.display = "none";
            }
        });
    }

    var userLoggedIn = <%= isLoggedIn %>;
    //Calendario AYUDAS
    $(document).ready(function() {
        $('.ayuda-card-right a').on('click', function(event) {
            if (!userLoggedIn) {
                event.preventDefault();
                $('#alertModal').show();

                $('.av-icon-close, .modal-seguidores').on('click', function() {
                    $('.modal-seguidores .av-te-ma-modal').hide();
                });
            }
        });


        $('.close-ayudas-modal').on('click', function() {
            $('#ayudasModal').hide();
        });
        // Selecciona todos los <td> dentro del <tbody> de la tabla con clase "calendar"
        // Escuchamos el evento click en los días del calendario
        $(document).on('click', '.calendar td', function() {

            // Removemos la clase 'selected-day' de cualquier otro día
            $('.calendar td').removeClass('selected-day');

            // Añadimos la clase 'selected-day' al día clicado
            $(this).addClass('selected-day');
        });
    });

    // Escondo el enlace al calendario y las pestañas
    $('.div-left-link-to-calendar').on('click', function () {
        // Escondo el enlace al calendario y el contenedor de pestañas
        $('.div-left-link-to-calendar').hide();
        $('.tabs-container').hide();

        // Muestro el contenedor del calendario y el título de los próximos eventos
        $('.calendar-container').show();
        $('.next-events-mobile-title').css('display', 'flex');
    });

    $('.next-events-mobile-title').on('click', function () {
        // Escondo el contenedor del calendario y el título de los próximos eventos
        $('.calendar-container').hide();
        $('.next-events-mobile-title').hide();

        // Muestro el enlace al calendario y el contenedor de pestañas
        $('.div-left-link-to-calendar').show();
        $('.tabs-container').show();
    });



</script>
