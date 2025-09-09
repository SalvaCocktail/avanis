<%@ page import="java.util.List" %> <%@ page
import="avanis.tu.explotacion.sb.model.Explotacion" %> <%@ page
import="com.liferay.asset.kernel.model.AssetEntry" %> <%@ page
import="com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil" %> <%@ page
import="com.liferay.asset.kernel.model.AssetCategory" %> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <%@ taglib
uri="http://liferay.com/tld/aui" prefix="aui" %> <%@ taglib
uri="http://liferay.com/tld/ui" prefix="liferay-ui" %> <%@ include
file="./init.jsp" %>

<portlet:resourceURL
  var="getAlert"
  id="resource_cmd_command_alert"
/>

<portlet:actionURL
  var="deleteURL"
  name="delete"
/>
<portlet:actionURL
  var="setIsMainURL"
  name="setIsMain"
/>
<portlet:actionURL
  var="setFocusURL"
  name="setFocus"
/>

<jsp:directive.page
  contentType="text/html"
  pageEncoding="UTF-8"
/>

<c:set
  var="isLoggedIn"
  scope="request"
  value="${isLoggedIn}"
/>

<div class="av-te">
  <div class="av-te-bg"></div>
  <div class="av-te__container">
    <c:choose>
      <c:when test="${isLoggedIn}">
        <jsp:include page="plotsList.jsp" />
        <jsp:include page="plotDetail.jsp" />
      </c:when>
      <c:otherwise>
        <jsp:include page="dummyPlotsList.jsp" />
        <jsp:include page="dummyPlot.jsp" />
      </c:otherwise>
    </c:choose>
  </div>
</div>

<style>
  .av-te-pdd-cta-absolute {
    position: fixed;
    left: 0;
    bottom: -100%;
    width: 100%;
    transition: bottom 2s;
  }

  .av-te-pdd-cta-absolute.show {
    bottom: 0;
    display: flex;
    justify-content: center;
    align-items: flex-end;
  }
</style>

<script type="text/javascript">
    console.log("Inicia script JS - TEV");

      function changeHourForNow(timeNowHour) {
        // Obtener el único elemento con las horas de salida y puesta del sol.
        const sunHourElement = document.querySelector('.js-av-te__sun-hours[data-today][data-sun-in][data-sun-out]');
        let today = parseInt(sunHourElement.getAttribute('data-today'), 10);
        const todayJs = new Date();
        const dayOfMonth = todayJs.getDate();

        console.log('timeNowHour: ', timeNowHour);
        timeNowHour = timeNowHour < 10 ? '0' + timeNowHour : timeNowHour.toString();
        const elementWeatherByHourNow = document.querySelector(".av-te-pd__weather-by-hours-item--" + timeNowHour + " .text-label");

        if (elementWeatherByHourNow && (today == dayOfMonth)) {
          elementWeatherByHourNow.textContent = "Ahora";
        }
      }

      function applyHourClassBasedOnTime(timeNowHour, classNames) {
        // Obtener el único elemento con las horas de salida y puesta del sol.
        const sunHourElement = document.querySelector('.js-av-te__sun-hours[data-today][data-sun-in][data-sun-out]');

        // Obtener la fecha y hora actual.
        const now = new Date();

        // Obtener la hora UTC actual.
        const utcHours = now.getUTCHours();

        // Obtener la hora local actual.
        const localHours = now.getHours();

        // Calcular la diferencia entre la hora local y la hora UTC.
        const timezoneOffset = localHours - utcHours;

        // Inicializar variables para sunIn y sunOut.
        // Obtener las horas de salida y puesta del sol desde el elemento.
        let sunIn = parseInt(sunHourElement.getAttribute('data-sun-in'), 10);
        let sunOut = parseInt(sunHourElement.getAttribute('data-sun-out'), 10);

        // Ajustar las horas de sunIn y sunOut según la diferencia entre UTC y la hora local.
        sunIn += timezoneOffset;
        sunOut += timezoneOffset;

        // Asegurarse de que las horas estén dentro del rango 0-23.
        sunIn = (sunIn + 24) % 24; // Asegurarse de que no sea negativo.
        sunOut = (sunOut + 24) % 24; // Asegurarse de que no sea negativo.

        // Iterar sobre cada clase pasada como argumento.
        classNames.forEach(className => {
          // Seleccionar todos los elementos que contienen la clase especificada
          const elements = document.querySelectorAll('.' + className);

          // Comprobar que sunIn y sunOut son válidos
          if (sunIn !== undefined && sunOut !== undefined) {
            // Iterar sobre cada elemento encontrado que contenga la clase
            elements.forEach(element => {
              // Obtener la clase "js-av-te-pd__symbol--X" si existe.
              const elementOfHour = Array.from(element.classList).find(cls => cls.startsWith('js-av-te-pd__symbol--'));

              // Obtener la clase "js-av-te-pd__symbol-day" si existe.
              const elementOfDay = Array.from(element.classList).find(cls => cls.startsWith('js-av-te-pd__symbol-day'));

              // Determinar hourValue basado en la clase "symbol-icon--X" o usar timeNowHour
              let hourValue;
              if (elementOfHour) {
                // Extraer el valor X de la clase.
                hourValue = parseInt(elementOfHour.split('--')[1], 10);
              } else if (elementOfDay) {
                hourValue = null;
              } else {
                // Si no hay clase "symbol-icon--X", usar timeNowHour.
                hourValue = timeNowHour;

              }

              // Comparar y agregar o quitar la clase "iconNight" usando la hora ajustada.
              if (hourValue !== null) {
                if (hourValue <= sunIn || hourValue > sunOut) {
                  element.classList.add("iconNight");
                } else {
                  element.classList.remove("iconNight");
                }
              }
            });
          }
        });
  }

      function handleWeatherByHours(){
        const timeNow = new Date();
        const timeNowHour = timeNow.getHours();

        changeHourForNow(timeNowHour);
        applyHourClassBasedOnTime(timeNowHour, ['av-te-pd__symbol', 'av-te-pl__symbol']);
      };

      document.addEventListener("DOMContentLoaded", function() {

      handleWeatherByHours();
  });


    // Variable de control para evitar ejecuciones concurrentes.
    var isExecuting = false;

    // LLamada a la función de envoltorio.
    function handleTEV() {
      if (isExecuting) {
        console.log('La función de envoltorio ya está en ejecución, se evita una nueva ejecución.');
        return; // Si la función de envoltorio ya se está ejecutando, salir.
      }

      // Bloquear nuevas ejecuciones mientras la función de envoltorio esta está en curso.
      isExecuting = true;

      //
      //
      //
      // LÓGICA JS DENTRO DE LA FUNCIÓN DE ENVOLTORIO:
      //
      //
      //

      console.log('>>>----->> Ejecutando la función  de envoltorio, handleTEV');

      // #region view.jsp
      console.log("Inicia view.jsp");

      // VARIABLES Y CONSTANTES:

      var linkToPlots = document.querySelector('.av-te-pd__link-to-plots');
      var plotsList = document.querySelector('.av-te-plotsList');
      var plotDetail = document.querySelector('.av-te-plotDetail');
      var isLoggedIn = ${isLoggedIn};

      // FUNCIONES:

      // General el CTA en Tu explotación (sin logar).
      function generateCTA() {
        // Crear el elemento fullscreen
        var fullscreenElement = document.createElement('div');
        fullscreenElement.className = 'av-te-pdd-cta-absolute';
        fullscreenElement.innerHTML =
          '<div class="av-te-pdd-cta">' +
          '<div class="av-te-pdd-cta__container">' +
          '<div class="av-te-pdd-cta__row av-te-pdd-cta__row001">' +
          '<h1 class="av-te-pdd-cta__h1">' +
          'Crea tu cuenta gratis o inicia sesión para monitorizar el clima en tu parcela' +
          '</h1>' +
          '</div>' +
          '<div class="av-te-pdd-cta__row av-te-pdd-cta__row002">' +
          '<p class="av-te-pdd-cta__text">' +
          'Con estas funcionalidad podrás ver, en tiempo real, el clima que se espera en las parcelas de tu explotación. ¡Adelántate y organiza tus semanas!' +
          '</p>' +
          '</div>' +
          '<div class="av-te-pdd-cta__row av-te-pdd-cta__row003">' +
          '<a href="/tipo-registro" class="av-theme__btn av-theme__btn--primary">' +
          'Crear cuenta gratis' +
          '</a>' +
          '</div>' +
          '<div class="av-te-pdd-cta__row av-te-pdd-cta__row004">' +
          '<p class="av-te-pdd-cta__text av-te-pdd-cta__text--strong">' +
          '¿Ya tienes cuenta en Avanis? ' +
          '<a href="/login" class="av-te-pdd-cta__text av-te-pdd-cta__text--highlighted">' +
          'Inicia sesión' +
          '</a>' +
          '</p>' +
          '</div>' +
          '</div>' +
          '</div>';

        // Obtener el wrapper
        var wrapper = document.getElementById('wrapper');

        // Añadir el elemento fullscreen al wrapper
        wrapper.appendChild(fullscreenElement);

        // Función para ajustar el tamaño del elemento fullscreen al tamaño del viewport
        function resizeFullscreenElement() {
          var viewportWidth = window.innerWidth;
          var viewportHeight = window.innerHeight;

          fullscreenElement.style.width = viewportWidth + 'px';
          fullscreenElement.style.minHeight = '470px';
        }

        // Escuchar el evento resize para ajustar el tamaño
        window.addEventListener('resize', resizeFullscreenElement);

        // Llamar a la función para establecer el tamaño inicial
        resizeFullscreenElement();

        // Añadir retardo de 3 segundos antes de mostrar el elemento con la animación
        setTimeout(function () {
          fullscreenElement.classList.add('show');
        }, 5000);
      }

      // Mobile - Abrir la lista de explotaciones para cambiar entre ellas.
      function viewChangePlotMobile() {
        plotsList.classList.toggle('av-te-column-show');
        plotDetail.classList.toggle('av-te-column-show');
      }

      // EVENTOS:

      if (!isLoggedIn) {
        generateCTA();
      }

      if (linkToPlots) {
        linkToPlots.addEventListener('click', viewChangePlotMobile);
      }

      console.log("Finaliza view.jsp");
      // #endregion view.jsp

      // #region plotList.jsp
      console.log("Inicia plotList.jsp");

      // VARIABLES Y CONSTANTES:

      const plotCards = document.querySelectorAll('.av-te-pl__plot-card');

      // FUNCIONES:

      // Ocultar el aviso para crear una explotación en la columna izquierda, cuando ya hay alguna explotación creada.
        function checkAndShowEmptyAlert() {
          console.log("Función: checkAndShowEmptyAlert");
          const plotCardsEmptyAlert = document.querySelectorAll('.av-te-pl__plot-card');
          const plotListCardsEmptyAlert = document.querySelectorAll('.av-te-pl__plot-list-empty');

          if (!plotCardsEmptyAlert.length > 0) {
            plotListCardsEmptyAlert.forEach(item => {
              item.classList.remove('av-te-hidden');
            });
          }
        }

      /**
       * Cambia la parcela seleccionada cuando se hace clic en una tarjeta.
       * @param {Event} event - El evento de clic.
       */

      // Cambiar la parcela seleccionada.
      function handlePlotCardClick(event) {
        console.log("Entramos en handlePlotCardClick");
        console.log("event: ", event);

        // La tarjeta que fue clickeada.
        const currentCard = event.currentTarget;
        console.log("currentCard: ", currentCard);

        // Extrae el índice del atributo data-id de la tarjeta.
        const index = currentCard.getAttribute('data-id');
        console.log("index: ", index);

        if (!index) {
          console.error('No se pudo obtener el índice de la tarjeta.');
          return;
        }

        // Construye el ID del formulario usando el índice.
        const formId = 'form-' + index;
        // Obtén el formulario usando el ID.
        const form = document.querySelector('[data-formid="' + formId + '"]');

        if (form) {
          // Construye el ID del botón usando el índice.
          const buttonId = 'button-' + index;
          // Obtén el botón usando el ID.
          const button = form.querySelector('[data-buttonid="' + buttonId + '"]');
          if (button) {
            // Simula el clic en el botón.
            button.click();
          } else {
            console.error('No se pudo encontrar el botón con el ID:', buttonId);
          }
        } else {
          console.error('No se pudo encontrar el formulario con el ID:', formId);
        }
      }

      // EVENTOS:

      // LANZAMIENTO AUTOMÁTICO:

      checkAndShowEmptyAlert();

      // ACCIONES DE LE USUARIE:

      plotCards.forEach(function(item) {
        console.log("Escuchamos plotCards");

        item.addEventListener('click', handlePlotCardClick);
      });

      console.log("Finaliza plotList.jsp");
      // #endregion plotList.jsp

      // #region plotDetail.jsp
      console.log("Inicia plotDetail.jsp");

      // VARIABLES Y CONSTANTES:

      var alerts = document.querySelectorAll('.av-te-pd__bci-bottom-alert-tag');
      var numberOfAlerts = alerts.length;
      var bciBottom = document.querySelectorAll('.av-te-pd__bci-bottom');
      var alertTagsContainer = document.querySelector(
        '.av-te-pd__bci-bottom-alert-tags'
      );
      var alertTagsContainerEmpty = document.querySelector(
        '.av-te-pd__bci-bottom-alert-tags-empty'
      );
      var legendContainer = document.querySelector(
        '.av-te-pd__bottom-content-legend'
      );
      var weatherByHours = document.querySelector('.av-te-pd__weather-by-hours');
      var arrowLeft = document.querySelector(
        '.av-te-pd__weather-by-hours-arrows--left'
      );
      var arrowRight = document.querySelector(
        '.av-te-pd__weather-by-hours-arrows--right'
      );
      var plotDetailsVar = document.querySelectorAll('.av-te-pd__container');
      var plotDetailsAlertVar = document.querySelectorAll(
        '.av-te-pd__plot-list-empty'
      );
      var alertTags = document.querySelectorAll('.av-te-pd__bci-bottom-alert-tag');
      var spanCloseIcons = document.querySelectorAll('.av-te-dltplot-modal__close');

      var bciTops = document.querySelectorAll('.av-te-pd__bci-top');
      //

      // FUNCIONES:

      // Calcular la altura de la parte "bottom" de los items.
      function calculateHeightItemBottom() {
        if (numberOfAlerts > 0) {
          var bottomHeight = numberOfAlerts * 68 + 8;
          bciBottom.forEach((item) => {
            item.style.minHeight = bottomHeight + 'px';
          });
        } else {
          bciBottom.forEach((item) => {
            item.style.minHeight = '';
          });
        }
      }

      // Mostrar u ocultar la leyenda en función de si hay o no alertas.
      function showHideLegend() {
        if (legendContainer) {
          if (numberOfAlerts > 0) {
            legendContainer.classList.add('av-te-pd__visible');
            alertTagsContainer.classList.add('av-te-pd__visible');
            alertTagsContainerEmpty.classList.add('av-te-pd__visible');
          } else {
            legendContainer.classList.remove('av-te-pd__visible');
            alertTagsContainer.classList.remove('av-te-pd__visible');
            alertTagsContainerEmpty.classList.remove('av-te-pd__visible');
          }
        }
      }

      // Desplazar a derecha o izquierda el tiempo por horas al hacer click en las flechitas.
      function scrollLeft() {
        weatherByHours.scrollBy({
          left: -60,
          behavior: 'smooth',
        });
      }
      function scrollRight() {
        weatherByHours.scrollBy({
          left: 60,
          behavior: 'smooth',
        });
      }

      // Limitar a 3 los caracteres del nombre del día de la semana, y añadir un punto.
      function limitTextToThreeChars() {
        var dayOfWeekNames = document.querySelectorAll(
          '.av-te-pd__day-of-week-name'
        );

        dayOfWeekNames.forEach((item) => {
          let dayOfWeekText = item.innerText || item.textContent;

          if (dayOfWeekText.length > 3) {
            dayOfWeekText = dayOfWeekText.substring(0, 3) + '.';
          }

          item.innerText = dayOfWeekText;
        });
      }

      // Ocultar el aviso para crear una explotación en la columna derecha, cuando ya hay alguna explotación creada.
      function checkAndShowEmptyDetailsAlert() {

        if (!plotDetailsVar.length > 0) {
          plotDetailsAlertVar.forEach((item) => {
            item.classList.remove('av-te-hidden');
          });
        }
      }

      // Abrir el modal con la información de Meteo Alertas.
      alertTags.forEach(function (item) {
        item.addEventListener('click', function (event) {
          event.preventDefault();
          var warning = item.getAttribute('data-warning');

          var modalRiskReset = document.getElementById('modal-risk');
          modalRiskReset.classList = 'av-te-ma-modal__header';

          var modalSymbolReset = document.getElementById('modal-symbol');
          modalSymbolReset.classList = 'av-icon-alert';

          var explotacionId = '${focusedPlotId}';
          var userId = '${themeDisplay.getUserId()}';
          var readed = true;
          var warningParts = warning.split(';');
          var phenomenon = warningParts[0].split('=')[1];
          var scope = warningParts[1].split('=')[1];
          var start = warningParts[2].split('=')[1];
          var end = warningParts[3].split('=')[1];
          var probability = warningParts[4].split('=')[1];
          var description = warningParts[5].split('=')[1];
          var risk = warningParts[6].split('=')[1];
          var riskModalTitle = 'av-ma__card--' + risk;
          var symbol = warningParts[7].split('=')[1];
          var symbolModalTitle = 'av-ma__card-icon-alert--' + symbol;

          let send = {
            userId: userId,
            explotacionId: explotacionId,
            readed: readed,
            phenomenon: phenomenon,
            probability: probability,
            description: description,
          };

          $.ajax({
            url: '${getAlert}',
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
        var modalRiskReset = document.getElementById('modal-risk');
        modalRiskReset.classList = 'av-te-ma-modal__header';

        var modalSymbolReset = document.getElementById('modal-symbol');
        modalSymbolReset.classList = 'av-icon-alert';

        var warningParts = warning.split(';');
        var phenomenon = warningParts[0].split('=')[1];
        var scope = warningParts[1].split('=')[1];
        var start = warningParts[2].split('=')[1];
        var end = warningParts[3].split('=')[1];
        var probability = warningParts[4].split('=')[1];
        var description = warningParts[5].split('=')[1];
        var risk = warningParts[6].split('=')[1];
        var riskModalTitle = 'av-ma__card--' + risk;
        var symbol = warningParts[7].split('=')[1];
        var symbolModalTitle = 'av-ma__card-icon-alert--' + symbol;
        let modalHeader = '';

        if (risk.includes('yellow')) {
          modalHeader = 'Alerta amarilla';
        } else if (risk.includes('orange')) {
          modalHeader = 'Alerta naranja';
        } else if (risk.includes('red')) {
          modalHeader = 'Alerta roja';
        }

        document.getElementById('modal-title').innerText = phenomenon;
        document.getElementById('modal-scope').innerText = scope;
        document.getElementById('modal-start').innerText = new Date(
          parseInt(start)
        ).toLocaleString();
        document.getElementById('modal-end').innerText = new Date(
          parseInt(end)
        ).toLocaleString();
        document.getElementById('modal-probability').innerText = probability;
        document.getElementById('modal-description').innerText = description;
        document.getElementById('modal-risk').classList.add(riskModalTitle);
        document.getElementById('modal-symbol').classList.add(symbolModalTitle);
        document.getElementById('alertModal').style.display = 'block';
        document.getElementById('modal-header').innerText = modalHeader;
      }

      // Cerrar el modal cuando le usuarie hace click en el icono de cerrar.
      spanCloseIcons.forEach(function (spanCloseIcon) {
        spanCloseIcon.addEventListener('click', function () {

          // Obtener y cerrar el modal correspondiente.
          let modal = document.getElementById('alertModal');
          modal.style.display = 'none';
        });
      });

      // Cerrar el modal cuando le usuarie hace click en cualquier área fuera del modal.
      window.addEventListener('click', function (event) {
        let modal = document.getElementById('alertModal');
        if (event.target === modal) {
          modal.style.display = 'none';
        }
      });

      // Abrir el modal de confirmación para borrar parcela (dltplotModal).
      var openDltPlotModal = document.querySelector(
        '.av-te-pd__icon--open-dltplotmodal'
      );
      if (openDltPlotModal) {
        openDltPlotModal.addEventListener('click', function (ev) {
          var dltplotModal = document.getElementById('dltplotModal');
          dltplotModal.style.display = 'block';
        });
      }

      // Cerrar el dltplotModal con la X, con el botón Cancelar o al hacer click fuera de él.
      window.addEventListener('click', function (event) {
        var dltplotModal = document.getElementById('dltplotModal');

        if (
          event.target === dltplotModal ||
          event.target.classList.contains('av-te-dltplot-modal__close')
        ) {
          dltplotModal.style.display = 'none';
        }
      });

      //

      // Hacer click en el botón de selección de un día concreto en la previsión de los próximos días.
      function submitFormWeather(event) {
        console.log("Función submitFormWeather");
        console.log("Event de submitFormWeather: ", event);

        // Extrae el índice del atributo data-idday de la tarjeta del día.
        const index = event.getAttribute('data-idday');
        console.log(">>>------>> index day: ", index);

        if (!index) {
          console.error('No se pudo obtener el índice de la tarjeta del día.');
          return;
        }

        // Construye el ID del botón usando el índice.
          const buttonday = 'buttonday-' + index;

        // Obtén el botón del formulario usando el index.
        const buttonWeather = document.querySelector('[data-buttonidday="' + buttonday + '"]');


        if (buttonWeather) {
          // Simula el clic en el botón.
          buttonWeather.click();
        } else {
          console.error('No se pudo encontrar el botón con el ID:', index);
        }
      }

      // Cambiar clase del día seleccionado.
      function handleClickDailyForecast(event) {
        console.log("Función handleClickDailyForecast");
        console.log("Event de handleClickDailyForecast: ", event);

        // Remover la clase 'av-te-pd__bci-top--selected' de todos los elementos
        bciTops.forEach((item) => item.classList.remove('av-te-pd__bci-top--selected'));

        // Agregar la clase al elemento clicado
        event.currentTarget.classList.add('av-te-pd__bci-top--selected');

        // Llamar a submitFormWeather con el elemento actual (currentTarget)
        submitFormWeather(event.currentTarget);
      }

      // EVENTOS:

      // LANZAMIENTO AUTOMÁTICO:
      checkAndShowEmptyDetailsAlert();
      limitTextToThreeChars();
      calculateHeightItemBottom();
      showHideLegend();

      // ACCIONES DE LE USUARIE:
      // Deslizar el tiempo por horas con las flechas de derecha e izquierda.
      if (arrowLeft) {
        arrowLeft.addEventListener('click', scrollLeft);
      }
      if (arrowRight) {
        arrowRight.addEventListener('click', scrollRight);
      }

      bciTops.forEach((element) => {
        // console.log("Evento de escucha: bciTops");
        // console.log("Element: ", element);

        element.addEventListener('click', handleClickDailyForecast);
      });

      console.log("Finaliza plotDetail.jsp");
      // #endregion plotDetail.jsp
    }

    // Lanzar la función de envoltorio cuando toda la página (incluyendo imágenes y recursos) ha sido completamente cargada.
    window.onload = function () {
      handleTEV();
    };

    // Lanzar la función de envoltorio cuando todos los portlets estén listos.
    Liferay.on('allPortletsReady', function () {
      handleTEV();
    });

    // Lanzar la función de envoltorio cuando una nueva pantalla se ha cargado en la navegación SPA.
    Liferay.on('screenLoad', function () {
      handleTEV();
    });

    // Lanzar la función de envoltorio cuando la navegación SPA ha terminado.
    Liferay.on('endNavigate', function () {
      handleTEV();
    });

    // Lanzar la función de envoltorio cuando se produce navegación en el SPA.
    Liferay.on('SPA_NAVIGATION', function (event) {
      handleTEV();
    });

    // Lanzar la función de envoltorio cuando hay cambios de ruta.
    Liferay.on('routeChanged', function () {
      handleTEV();
    });

    console.log("Finaliza script JS - TEV");
</script>
