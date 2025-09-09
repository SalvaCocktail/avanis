<%@ include file="/init.jsp" %>
<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>

<!-- Modal-menu -->
<!-- Modal pequeño de selección de opciones -->
<div class="av-theme-modal-menu av-theme-modal-menu__menu js-av-theme-modal-menu--lmw av-theme__hidden d-none">
	<!-- Contenido del modal de menu -->
	<%@ include file="/modal-menu-content.jsp" %>
</div>

<!-- Modal -->
<div class="av-theme-modal-page js-av-theme-modal-page av-theme__hidden" style="z-index: 1000;">
	<!-- Backdrop -->
	<div class="av-theme-modal-page__backdrop js-av-theme-modal-page__close-modal"></div>
	<!-- Cuerpo del modal -->
	<%@ include file="/modal-page-content.jsp" %>
</div>

<script type="text/javascript">
	// Variable de control para evitar ejecuciones concurrentes.
	var isExecutingModals = false;

	// LLamada a la función de envoltorio.
	function handleModals() {
		if (isExecutingModals) {
			return;
		}

		// Bloquear nuevas ejecuciones mientras la función de envoltorio esta en curso.
		isExecutingModals = true;

		//
		// LÓGICA JS DENTRO DE LA FUNCIÓN DE ENVOLTORIO:
		//

		// VARIABLES Y CONSTANTES:
		const dotsIcon = document.querySelector('.js-av-lmw__dots');
		const checkOptions = document.querySelectorAll('.js-av-theme-modal-menu__menu-text');
		const modalMenu = document.querySelector('.js-av-theme-modal-menu--lmw');

		const ctaViewAll = document.querySelector('.js-av-lmw__footer');
		const closeModalElements = document.querySelectorAll('.js-av-theme-modal-page__close-modal');
		const modalPage = document.querySelector('.js-av-theme-modal-page');

		// FUNCIONES:

		// Tratamiento de los modales.
		// Modal menu - Cambiar visibilidad.
		dotsIcon.addEventListener('click', () => {
			modalMenu.classList.toggle('av-theme__hidden');
		});
		// Modal menu - Cerrar.
		checkOptions.forEach((item) => {
			item.addEventListener('click', () => {
				modalMenu.classList.add('av-theme__hidden');
			});
		});

		// Modal page - Abrir.
		ctaViewAll.addEventListener('click', () => {
            modalPage.classList.remove('av-theme__hidden');
		});
		// Modal page - Cerrar.
		function closeModalPage() {
			modalMenu.classList.add('av-theme__hidden');
			modalPage.classList.add('av-theme__hidden');
		}

		// EVENTOS:
		closeModalElements.forEach((item) => {
			item.addEventListener('click', closeModalPage);
		});
	}

	// Lanzar la función de envoltorio cuando toda la página (incluyendo imágenes y recursos) ha sido completamente cargada.
	window.onload = function () {
		handleModals();
	};

	// Lanzar la función de envoltorio cuando todos los portlets estén listos.
	Liferay.on('allPortletsReady', function () {
		handleModals();
	});

	// Lanzar la función de envoltorio cuando una nueva pantalla se ha cargado en la navegación SPA.
	Liferay.on('screenLoad', function () {
		handleModals();
	});

	// Lanzar la función de envoltorio cuando la navegación SPA ha terminado.
	Liferay.on('endNavigate', function () {
		handleModals();
	});

	// Lanzar la función de envoltorio cuando se produce navegación en el SPA.
	Liferay.on('SPA_NAVIGATION', function (event) {
		handleModals();
	});

	// Lanzar la función de envoltorio cuando hay cambios de ruta.
	Liferay.on('routeChanged', function () {
		handleModals();
	});
</script>
