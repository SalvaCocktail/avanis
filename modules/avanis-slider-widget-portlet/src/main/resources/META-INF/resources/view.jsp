<%@ include file="/init.jsp" %>
<jsp:directive.page contentType="text/html" pageEncoding="UTF-8" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/slick/slick.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/slick/slick-theme.css">
<%
	boolean isLoggedIn = themeDisplay.isSignedIn();
%>
<div class="modal-seguidores">
	<div id="alertModalAyudas" class="av-te-ma-modal alertModalAyudas">
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
<div class="slider-comunidad">
	<div class="portlet-de-meteoalertas"><liferay-portlet:runtime portletName="avanis_explotacion_main_portlet_AvanisExplotacionMainPortlet_INSTANCE_minstance" /></div>
	<div class="portlet-de-eventos"><liferay-portlet:runtime portletName="Avanis Eventos y Actividades Widget Portlet_INSTANCE_1234" /></div>
	<div class="portlet-de-ayudas"><liferay-portlet:runtime portletName="avanis_ayudas_subvenciones_AvanisAyudasSubvencionesPortlet" /></div>
	<div class="portlet-de-ayudas"><liferay-portlet:runtime portletName="avanis_lonjas_AvanisLonjasWidgetPortlet" /></div>

</div>

<!--<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>-->
<script type="text/javascript" src="<%=request.getContextPath()%>/slick/slick.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		// Añado la clase 'is-open' cuando se haga clic en el texto de eventos
		$('.av-pe__footer-text').on('click', function() {
			if ($(window).width() < 1000) {
				$('.slider-comunidad').slick('unslick');
				$('#_AvanisEventosyActividadesWidgetPortlet_INSTANCE_1234_modal-allEvents').addClass('is-open');
			}
		});

		// Quito la clase 'is-open' al hacer clic en el botón de cerrar modal
		$('.modal__close').on('click', function() {
			if ($(window).width() < 1000) {
				$('#_AvanisEventosyActividadesWidgetPortlet_INSTANCE_1234_modal-allEvents').removeClass('is-open');
				$('.slider-comunidad').slick({
					dots: true,
					infinite: true,
					speed: 300,
					slidesToShow: 1,
					adaptiveHeight: true
				});
			}
		});

		$('#verTodasBtn').on('click', function(event) {
			if ($(window).width() < 1000) {
				$('.slider-comunidad').slick('unslick');
			}
		});

		// Usar event delegation para la clase .close-ayudas-modal
		$(document).on('click', '.close-ayudas-modal', function() {
			if ($(window).width() < 1000) {
				$('.slider-comunidad').slick({
					dots: true,
					infinite: true,
					speed: 300,
					slidesToShow: 1,
					adaptiveHeight: true
				});
			}
		});

		// Mostrar el modal al hacer clic en "Ver todas las lonjas"
		$('.js-av-lmw__footer').on('click', function() {
			if ($(window).width() < 1000) {
				$('.slider-comunidad').slick('unslick');
			}
			$('.js-av-theme-modal-page').removeClass('av-theme__hidden');
		});

		// Cerrar el modal al hacer clic en el botón de cerrar
		$('.js-av-theme-modal-page__close-modal').on('click', function() {
			if ($(window).width() < 1000) {
				$('.slider-comunidad').slick({
					dots: true,
					infinite: true,
					speed: 300,
					slidesToShow: 1,
					adaptiveHeight: true
				});
			}
			$('.js-av-theme-modal-page').addClass('av-theme__hidden');
		});
	});


	//Funcion que a menos de 768 se convierta en slick y a más se repliegue

	$(document).ready(function() {
		function checkWidth() {
			if ($(window).width() < 1000) {
				// Inicializo el slider si la ventana es menor a 1000px
				if (!$('.slider-comunidad').hasClass('slick-initialized')) {
					$('.slider-comunidad').slick({
						dots: true,
						infinite: true,
						speed: 300,
						slidesToShow: 1,
						adaptiveHeight: true
					});
				}
			} else {
				// Desactivar el slider si la ventana es mayor o igual a 1000px
				if ($('.slider-comunidad').hasClass('slick-initialized')) {
					$('.slider-comunidad').slick('unslick');
				}
			}
		}

		// Llamar a la función al cargar la página
		checkWidth();

		// Llamar a la función cuando la ventana se redimensione
		$(window).resize(function() {
			checkWidth();
		});
	});
</script>
<script>
	var userLoggedIn = <%= isLoggedIn %>;

	$(document).ready(function () {
		$('.all-booking-title').on('click', function (event) {
			if (!userLoggedIn) { // Si el usuario no está logado
				event.preventDefault(); // Evitar que el enlace funcione como un enlace
				$('#alertModal').show(); // Mostrar el modal


				$('.av-icon-close, .modal-seguidores').on('click', function () {
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

	$('.ayuda-card a').on('click', function(event) {
		if (!userLoggedIn) {  // Si el usuario no está logado
			event.preventDefault();  // Evitar que el enlace funcione como un enlace
			$('#alertModalAyudas').show();  // Mostrar el modal

			// También puedes añadir lógica para cerrar el modal
			$('.av-icon-close, .modal-seguidores').on('click', function() {
				$('.modal-seguidores .av-te-ma-modal').hide();
			});
		}
	});
</script>
