<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page import="java.util.List" %> 
<%@ page import="avanis.tu.explotacion.sb.model.Explotacion" %> 
<%@ page import="com.liferay.asset.kernel.model.AssetEntry" %> 
<%@ page import="com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil" %> 
<%@ page import="com.liferay.asset.kernel.model.AssetCategory" %> 
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %> 
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<%@ include file="./init.jsp" %> 

<jsp:directive.page
  contentType="text/html"
  pageEncoding="UTF-8"
/>

<c:set
  var="isLoggedIn"
  scope="request"
  value="${isLoggedIn}"
/>

<c:choose>
  <c:when test="${isLoggedIn && plots != null && plots.size() > 0}">
    <jsp:include page="widget.jsp" />
  </c:when>
  <c:when test="${isLoggedIn}">
    <jsp:include page="widgetEmptyState.jsp" />
  </c:when>
  <c:otherwise>
    <jsp:include page="widgetDummy.jsp" />
  </c:otherwise>
</c:choose>

<script type="text/javascript">
 // Variable de control para evitar ejecuciones concurrentes.
  var isExecutingWidgetTuExplotacion = false;
  
  // LLamada a la función de envoltorio.
  function handleWidgetTuExplotacion() {
    if (isExecutingWidgetTuExplotacion) {
      console.log('La función de envoltorio ya está en ejecución, se evita una nueva ejecución.');
      return; 
    }

    // Bloquear nuevas ejecuciones mientras la función de envoltorio esta está en curso.
    isExecutingWidgetTuExplotacion = true; 

    // 
    // 
    // 
    // LÓGICA JS DENTRO DE LA FUNCIÓN DE ENVOLTORIO:
    // 
    // 
    //     

    // #region Widget

    // VARIABLES Y CONSTANTES:

    const dotsIcon = document.querySelector('.av-te-wte__dots-icon');
    const modalMenu = document.querySelector('.av-te-wte__modal--menu');
    const closeModalElements = document.querySelectorAll(
      '.av-te-wte-mps__close-modal'
    );
    const modalPlotSelector = document.querySelector(
      '.av-te-wte__modal--plot-selector'
    );
    const formSaveBtn = document.querySelector('.av-te-wte__btn-save');
    const form = document.querySelector('#av-te-wte-mps__form');

    // FUNCIONES:

    // Ocultar el empty state.
    function checkAndShowEmptyAlert() {
      const widgetCardsEmptyAlert = document.querySelectorAll('.av-te-wte');
      const widgetListCardsEmptyAlert = document.querySelectorAll('.av-te-wte__widget-list-empty');

      if (!widgetCardsEmptyAlert.length > 0) {
        widgetListCardsEmptyAlert.forEach(item => {
          item.classList.remove('av-te-hidden');
        });
      }
    }

    // Tratamiento de los modales.
    // Modal menu - Cambiar visibilidad.
    if (dotsIcon ) {
      dotsIcon.addEventListener('click', () => {
        modalMenu.classList.toggle('av-te-hidden');
      });
    }
    // Modal plot-selection - Abrir.
    if (modalMenu && modalPlotSelector) {
      modalMenu.addEventListener('click', () => {
        modalPlotSelector.classList.remove('av-te-hidden');
      });
    } else {
      console.warn('Uno o ambos elementos no están presentes en el DOM.');
    }

    // Modal plot-selection - Cerrar.
    closeModalElements.forEach((item) => {
      item.addEventListener('click', () => {
        modalMenu.classList.add('av-te-hidden');
        modalPlotSelector.classList.add('av-te-hidden');
      });
    });

    // Enviar el formulario para cambiar la parcela con foco/principal.

    if (formSaveBtn ) {
        formSaveBtn.addEventListener('click', (ev) => {
          ev.preventDefault();
          form.submit();
        });
    }
    // EVENTOS:
    // LANZAMIENTO AUTOMÁTICO:
    
    checkAndShowEmptyAlert();
    
    // #endregion Widget  
  };

// Lanzar la función de envoltorio cuando toda la página (incluyendo imágenes y recursos) ha sido completamente cargada.
  window.onload = function () {
    handleWidgetTuExplotacion();
  };

  // Lanzar la función de envoltorio cuando todos los portlets estén listos.
  Liferay.on('allPortletsReady', function () {
    handleWidgetTuExplotacion();
  });

  // Lanzar la función de envoltorio cuando una nueva pantalla se ha cargado en la navegación SPA.
  Liferay.on('screenLoad', function () {
    handleWidgetTuExplotacion();
  });

  // Lanzar la función de envoltorio cuando la navegación SPA ha terminado.
  Liferay.on('endNavigate', function () {
    handleWidgetTuExplotacion();
  });

  // Lanzar la función de envoltorio cuando se produce navegación en el SPA.
  Liferay.on('SPA_NAVIGATION', function (event) {
    handleWidgetTuExplotacion();
  });

  // Lanzar la función de envoltorio cuando hay cambios de ruta.
  Liferay.on('routeChanged', function () {
    handleWidgetTuExplotacion();
  });
</script>