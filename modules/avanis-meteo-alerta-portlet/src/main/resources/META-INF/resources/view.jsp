<%@ include file="/init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="java.util.List" %>
<%@ page import="model.MeteoredWarning" %>
<%@ page import="model.MeteoredWarningType" %>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portletMeteoAlert" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme" %>

<%--
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
--%>

<jsp:directive.page
  contentType="text/html"
  pageEncoding="UTF-8"
/>

<portlet:defineObjects />

<c:set var="actualUserId" value="${requestScope.actualUserId}" />
<c:set var="plots" value="${requestScope.plots}" />
<c:set var="meteoredWarningsToday" value="${requestScope.meteoredWarningsToday}" />
<c:set var="warningsByExplotacion" value="${requestScope.warningsByExplotacion}" />

<portlet:resourceURL var="getReaded" id="resource_cmd_command" />
<portlet:resourceURL var="getReadedAlert" id="resource_cmd_command_alert" />

<style>
  .av-ma__display-none {
    display: none;
  }
  .hidden {
    display: none;
  }
  .av-ma.av-ma__card-main-container {
    display: flex;
    flex-direction: column-reverse;
  }
  #alertModal {
    display: none;
  }
</style>

<!-- #region Meteo Alert -->
<div class="av-ma av-ma__card-main-container">
  <c:if test="${not empty warningsByExplotacion}">
		<c:forEach var="entry" items="${warningsByExplotacion}">
			<c:set var="contador" value="0"/>
			<c:set var="plotId" value="${entry.key}" />
			<c:set var="warnings" value="${entry.value}" />
			<c:forEach var="warning" items="${warnings}" varStatus="status">
				<c:set var="contador" value="${contador+1}"/>
				<c:set var="warningId" value="${status.index}" />
				<div class="av-ma__card av-ma__card--${warning.risk}" data-explotacion-id="${plotId}" id="${warningId}">
					<div class="av-ma__card-icon-alert av-ma__card-icon-alert--${warning.symbol != null ? warning.symbol : '0'}"></div>
          <div class="av-ma__card-text alerta">
            <h5 class="h5">¡Atención!</h5>
            <span class="body-m">${warning.phenomenon}</span>
            <span class="body-m">en tu explotación de ${warning.scope}</span>
						<a href="#" class="view-alert" data-warning="phenomenon=${warning.phenomenon};scope=${warning.scope};start=${warning.start.time};end=${warning.end.time};probability=${warning.probability};description=${warning.description};risk=${warning.risk};symbol=${warning.symbol}">
              Ver alerta
            </a>
          </div>
          <div class="av-ma__card-icon-close">
						<svg class="close-alert" data-warning-id="${warningId}" data-explotacion-id="${plotId}" data-warning="phenomenon=${warning.phenomenon};scope=${warning.scope};start=${warning.start};end=${warning.end};probability=${warning.probability};description=${warning.description};risk=${warning.risk};symbol=${warning.symbol}" width="18" height="18" viewBox="0 0 18 18" fill="none" xmlns="http://www.w3.org/2000/svg">
							<path d="M1 1L17 17M17 1L1 17" stroke="#101717" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
            </svg>
          </div>
        </div>
      </c:forEach>
    </c:forEach>
  </c:if>
</div>
<!-- #endregion Meteo Alert -->

<!-- #region Meteo Alert modal -->
<div id="alertModal" class="av-te-ma-modal">
  <div class="av-te-ma-modal__panel">
		<div id="modal-risk" class="av-te-ma-modal__header">
      <div>
				<span id="modal-symbol" class="av-icon-alert" style="height: 24px; width: 24px;"></span>
        <p class="av-te-ma-modal__heading">
					<span class="body-m" id="modal-header"></span>
        </p>
      </div>
      <span class="av-icon-close av-te-ma__icon-close">&times;</span>
    </div>

    <div class="av-te-ma-modal__content">
      <h4 class="av-te-ma-modal__title">
				<span class="body-m" id="modal-title"></span>
      </h4>
      <div class="av-te-ma-modal__text">
        <h5>Ámbito</h5>
				<span class="body-m" id="modal-scope"></span>
      </div>
      <div class="av-te-ma-modal__text">
        <h5>Inicio</h5>
				<span class="body-m" id="modal-start"></span>
      </div>
      <div class="av-te-ma-modal__text">
        <h5>Fin</h5>
				<span class="body-m" id="modal-end"></span>
      </div>
      <div class="av-te-ma-modal__text">
        <h5>Probabilidad</h5>
				<span class="body-m" id="modal-probability"></span>
      </div>
      <div class="av-te-ma-modal__text">
        <h5>Descripción</h5>
				<span class="body-m" id="modal-description"></span>
      </div>
    </div>

    <div class="av-te-ma-modal__footer">
			<button class="av-te-ma__btn av-te-ma__btn--primary">
				Aceptar
			</button>
    </div>
  </div>
</div>
<!-- #endregion Meteo Alert modal -->

<script type="text/javascript">

  // Variable de control para evitar ejecuciones concurrentes.
  var isExecutingMeteoAlerta = false;
  
  // LLamada a la función de envoltorio.
  function handleMeteoAlertaPorlet() {
    if (isExecutingMeteoAlerta) {
      console.log('La función de envoltorio ya está en ejecución, se evita una nueva ejecución.');
      return; // Si la función de envoltorio ya se está ejecutando, salir.
    }

    // Bloquear nuevas ejecuciones mientras la función de envoltorio esta está en curso.
    isExecutingMeteoAlerta = true; 

    // 
    // 
    // 
    // LÓGICA JS DENTRO DE LA FUNCIÓN DE ENVOLTORIO:
    // 
    // 
    // 

    function closeWarning(warningId) {
			console.log("cierro este ", warningId);
			localStorage.setItem("closedWarning-" + warningId, "true");
      const warningElement = document.getElementById(warningId);
      if (warningElement) {
				warningElement.classList.add('av-ma__display-none');
        showNextWarning();
      } else {
				console.log("Element with ID not found:", warningId);
      }
    }
		
    function showNextWarning() {
      const hiddenAlerts = document.querySelectorAll('.av-ma__card.hidden');
      if (hiddenAlerts.length > 0) {
        hiddenAlerts[0].classList.remove('hidden');
      }
    }

		document.querySelectorAll('.close-alert').forEach(function(svg, index) {
			svg.addEventListener('click', function() {
        const warning = svg.getAttribute('data-warning');
        const warningId = svg.getAttribute('data-warning-id');

        const explotacionId = svg.getAttribute('data-explotacion-id');
				const userId = "${actualUserId}";
        const readed = true;
        const warningParts = warning.split(';');
        const phenomenon = warningParts[0].split('=')[1];
        const scope = warningParts[1].split('=')[1];
        const start = warningParts[2].split('=')[1];
        const end = warningParts[3].split('=')[1];
        const probability = warningParts[4].split('=')[1];
        const description = warningParts[5].split('=')[1];
        const risk = warningParts[6].split('=')[1];

        let send = {
          userId: userId,
          explotacionId: explotacionId,
          readed: readed,
          phenomenon: phenomenon,
          scope: scope,
          start: start,
          end: end,
          probability: probability,
          description: description,
          risk: risk,
        };

        $.ajax({
          url: '${getReaded}',
          type: 'POST',
          dataType: 'json',
          contentType: 'application/json',
          data: JSON.stringify(send),
          success: function (data) {
            closeWarning(warningId);
          },
          error: function (error) {
            console.error('Error en la petición AJAX:', error);
          },
        });
      });
    });

		document.querySelectorAll('.alerta a.view-alert').forEach(function(link) {
			link.addEventListener('click', function(event) {
        event.preventDefault();
        const warning = link.getAttribute('data-warning');
        const warningId = link.getAttribute('data-warning-id');

        const explotacionId = link.getAttribute('data-explotacion-id');
				const userId = "${actualUserId}";
        const readed = true;
        const warningParts = warning.split(';');
        const phenomenon = warningParts[0].split('=')[1];
        const scope = warningParts[1].split('=')[1];
        const start = warningParts[2].split('=')[1];
        const end = warningParts[3].split('=')[1];
        const probability = warningParts[4].split('=')[1];
        const description = warningParts[5].split('=')[1];
        const risk = warningParts[6].split('=')[1];

        let send = {
          userId: userId,
          explotacionId: explotacionId,
          readed: readed,
          phenomenon: phenomenon,
          probability: probability,
          description: description,
        };

        $.ajax({
          url: '${getReadedAlert}',
          type: 'POST',
          dataType: 'json',
          contentType: 'application/json',
          data: JSON.stringify(send),
          success: function (data) {
            openModal(warning);
          },
          error: function (error) {
            console.error('Error en la petición AJAX:', error);
          },
        });
      });
    });

    function openModal(warning) {
      const modalRiskReset = document.getElementById('modal-risk');
      modalRiskReset.classList = 'av-te-ma-modal__header';

      const modalSymbolReset = document.getElementById('modal-symbol');
      modalSymbolReset.classList = 'av-icon-alert';

      const warningParts = warning.split(';');
      const phenomenon = warningParts[0].split('=')[1];
      const scope = warningParts[1].split('=')[1];
      const start = warningParts[2].split('=')[1];
      const end = warningParts[3].split('=')[1];
      const probability = warningParts[4].split('=')[1];
      const description = warningParts[5].split('=')[1];
      const risk = warningParts[6].split('=')[1];
      const riskModalTitle = 'av-ma__card--' + risk;
      const symbol = warningParts[7].split('=')[1];
      const symbolModalTitle = 'av-ma__card-icon-alert--' + symbol;
			let modalHeader = "";

			if(risk.includes("yellow")){
				modalHeader = "Alerta amarilla";
			} else if(risk.includes("orange")){
				modalHeader = "Alerta naranja";
			} else if(risk.includes("red")){
				modalHeader = "Alerta roja";
      }

      document.getElementById('modal-title').innerText = phenomenon;
      document.getElementById('modal-scope').innerText = scope;
			document.getElementById('modal-start').innerText = new Date(parseInt(start)).toLocaleString();
			document.getElementById('modal-end').innerText = new Date(parseInt(end)).toLocaleString();
      document.getElementById('modal-probability').innerText = probability;
      document.getElementById('modal-description').innerText = description;
      document.getElementById('modal-risk').classList.add(riskModalTitle);
      document.getElementById('modal-symbol').classList.add(symbolModalTitle);
      document.getElementById('alertModal').style.display = 'block';
      document.getElementById('modal-header').innerText = modalHeader;
    }

    window.onclick = function (event) {
      const modal = document.getElementById('alertModal');
      if (event.target === modal) {
        modal.style.display = 'none';
      }
    };

    // Cerrar el modal cuando el usuario hace clic en el botón de cerrar.
    const closeModalButton = document.querySelector(
      '.av-te-ma__btn.av-te-ma__btn--primary'
    );
		
    closeModalButton.addEventListener('click', function () {
			console.log('Paso por aquí 001');
      const modal = document.getElementById('alertModal');
      modal.style.display = 'none';
    });

    // Cerrar el modal cuando el usuario hace clic en la X de cierre.
    const closeModalButtonX = document.querySelector(
      '.av-te-ma__icon-close'
    );
		
    closeModalButtonX.addEventListener('click', function () {
			console.log('Paso por aquí 002');
      const modal = document.getElementById('alertModal');
      modal.style.display = 'none';
    });

		function viewportSize() {
			var viewportWidth = window.innerWidth;
			return viewportWidth > 768 ? 4 : 2;
		}

		function changeNumberOfAlerts() {
			var maxMeteoAlerts = viewportSize();
		console.log("El valor de maxMeteoAlerts es: " + maxMeteoAlerts);

			// Buscar todos los elementos con el atributo `data-alert-id` y `data-contador`.
			var alerts = document.querySelectorAll('[data-alert-id]');

			alerts.forEach(function (alert) {
				var contador = parseInt(alert.getAttribute('data-contador'), 10);

				if (contador > maxMeteoAlerts) {
					alert.classList.add('hidden');
				} else {
					alert.classList.remove('hidden');
				}
			});

			return maxMeteoAlerts;
		}

		window.onload = changeNumberOfAlerts;
		window.onresize = changeNumberOfAlerts;
	};

  // Lanzar la función de envoltorio cuando toda la página (incluyendo imágenes y recursos) ha sido completamente cargada.
  window.onload = function () {
    handleMeteoAlertaPorlet();
  };

  // Lanzar la función de envoltorio cuando todos los portlets estén listos.
  Liferay.on('allPortletsReady', function () {
    handleMeteoAlertaPorlet();
  });

  // Lanzar la función de envoltorio cuando una nueva pantalla se ha cargado en la navegación SPA.
  Liferay.on('screenLoad', function () {
    handleMeteoAlertaPorlet();
  });

  // Lanzar la función de envoltorio cuando la navegación SPA ha terminado.
  Liferay.on('endNavigate', function () {
    handleMeteoAlertaPorlet();
  });

  // Lanzar la función de envoltorio cuando se produce navegación en el SPA.
  Liferay.on('SPA_NAVIGATION', function (event) {
    handleMeteoAlertaPorlet();
  });

  // Lanzar la función de envoltorio cuando hay cambios de ruta.
  Liferay.on('routeChanged', function () {
    handleMeteoAlertaPorlet();
  });
</script>
