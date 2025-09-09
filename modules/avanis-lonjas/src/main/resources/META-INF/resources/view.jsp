<%@ include file="/init.jsp" %>
<jsp:directive.page
  contentType="text/html"
  pageEncoding="UTF-8"
/>

<portlet:resourceURL var="obtenerLonjasProductos" id="/obtenerLonjasProductos"/>

<div class="av-lmw">
  <div class="av-lmw__container">
    <div class="av-lmw__header">
      <div class="av-lmw__header-title">Últimas lonjas y mercados</div>
      <div class="av-lmw__header-dots-icon js-av-lmw__dots d-none">
        <svg
          width="16"
          height="4"
          viewBox="0 0 16 4"
          fill="none"
          xmlns="http://www.w3.org/2000/svg"
        >
          <path
            fill-rule="evenodd"
            clip-rule="evenodd"
            d="M0 2C0 0.89543 0.89543 0 2 0C3.10457 0 4 0.89543 4 2C4 3.10457 3.10457 4 2 4C0.89543 4 0 3.10457 0 2ZM6 2C6 0.89543 6.89543 0 8 0C9.10457 0 10 0.89543 10 2C10 3.10457 9.10457 4 8 4C6.89543 4 6 3.10457 6 2ZM12 2C12 0.89543 12.8954 0 14 0C15.1046 0 16 0.89543 16 2C16 3.10457 15.1046 4 14 4C12.8954 4 12 3.10457 12 2Z"
            fill="#646B6B"
          />
        </svg>
      </div>
    </div>

    <div class="av-lmw__separador"></div>

    <div class="av-lmw__body">
      <div
        class="av-lmw__cards-gradient av-lmw__cards-gradient--left av-theme__hidden"
      ></div>
      <div class="av-lmw__cards-gradient av-lmw__cards-gradient--right"></div>
      <div class="av-lmw__cards js-av-lmw__cards av-theme__slider-draggable">
        <!-- Cards del Widget -->
        <c:set
          var="counter"
          value="0"
        />
        <c:forEach
          var="producto"
          items="${listaProductos}"
        >
          <c:if test="${counter < 10}">
            <%@ include file="/card-widget.jsp" %>
            <c:set
              var="counter"
              value="${counter + 1}"
            />
          </c:if>
        </c:forEach>
      </div>
    </div>

    <span class="av-lmw__footer js-av-lmw__footer"> Ver todas las lonjas </span>
  </div>

  <!-- MODAL -->
  <%@ include file="/modal.jsp" %>
</div>

<script type="text/javascript">
  // Variable de control para evitar ejecuciones concurrentes.
  var isExecutingMarkets = false;
  let activeFavoritos = 'all'; // Variable para almacenar el tab activo
  let favoritos;
  let favoritosFiltrados; // Inicialmente, todos los productos están visibles

  function listarFavoritos(actualizarEstrellas) {
    <portlet:renderURL
      var='listarProductoFavoritosUserURL'
      windowState='<%= LiferayWindowState.EXCLUSIVE.toString() %>'
    >
      <portlet:param
        name='mvcRenderCommandName'
        value='render_cmd_command'
      />
      <portlet:param
        name='<%=Constants.CMD%>'
        value='lista_producto_favoritos'
      />
    </portlet:renderURL>;
    fetch('<%=listarProductoFavoritosUserURL%>')
      .then((response) => {
        return response.text();
      })
      .then(function (html) {
        document.querySelector('.av-lm-cl__row--004').innerHTML = html;
        favoritos = Array.from(document.querySelectorAll('.av-lm-cl__card'));
        document
          .querySelectorAll('.js-av-lm-cl__tab.av-lm-cl__tab--all')[0]
          .click();
        if (favoritos.length > 0) {
          document.querySelector('.av-lm-cl__edit-btn').classList.remove('d-none');
        } else  {
          document.querySelector('.av-lm-cl__edit-btn').classList.add('d-none');
        }
        if(actualizarEstrellas){
          document.querySelectorAll('.av-lm-cr__star-icon-checkbox').forEach((favoritoCheckBox) => {
            let checked = false;
            for (let i = 0; i < favoritos.length; i++) {
              if (  favoritoCheckBox.parentNode.getAttribute('data-lonja-id') === favoritos[i].getAttribute('data-lonja-id') &&
                    favoritoCheckBox.parentNode.getAttribute('data-producto-id') === favoritos[i].getAttribute('data-producto-id')){
                checked = true;
                break;
              }
            }
            favoritoCheckBox.checked = checked;
          });
        }
      })
      .catch((error) => {
        console.warn('Something went wrong.', error);
      });
  }

  // LLamada a la función de envoltorio.
  function handleMarkets() {
    if (isExecutingMarkets) {
      return;
    }

    // Bloquear nuevas ejecuciones mientras la función de envoltorio esta en curso.
    isExecutingMarkets = true;

    //
    // LÓGICA JS DENTRO DE LA FUNCIÓN DE ENVOLTORIO:
    //

    const disparadorTitle = document.querySelector('.av-lmw__header-title');
    const notificationText = '¡Seguimiento de precio añadido a favoritos!';
    const notificationType = 'succes';

    disparadorTitle.addEventListener('click', () => {
      openNotification(notificationText, notificationType);
    });

    // VARIABLES Y CONSTANTES:
    const listTabElements = document.querySelectorAll('.js-av-lm-cr__tab');
    activeFavoritos = 'all'; // Variable para almacenar el tab activo
    favoritos = Array.from(document.querySelectorAll('.av-lm-cl__card'));
    favoritosFiltrados = favoritos; // Inicialmente, todos los productos están visibles

    const dropdownElement = document.querySelector('.js-av-lm-cr__dropdown');
    const dropdownBtn = document.querySelector('.js-av-lm-cr__dropdown-btn');
    const dropdownSvg = document.querySelector('.js-av-lm-cr__dropdown-svg');
    const dropdownMenu = document.querySelector('.js-av-lm-cr__dropdown-menu');
    const dropdownItems = document.querySelectorAll(
      '.js-av-lm-cr__dropdown-item'
    );
    const dropdownBackdrop = document.querySelector(
      '.js-av-lm-cr__dropdown-backdrop'
    );

    const dropdownOrderElement = document.querySelector(
      '.js-av-lm-cr__dropdown-order'
    );
    const dropdownOrderBtn = document.querySelector(
      '.js-av-lm-cr__dropdown-order-btn'
    );
    const dropdownOrderSvg = document.querySelector(
      '.js-av-lm-cr__dropdown-order-svg'
    );
    const dropdownOrderMenu = document.querySelector(
      '.js-av-lm-cr__dropdown-order-menu'
    );
    const dropdownOrderItems = document.querySelectorAll(
      '.js-av-lm-cr__dropdown-order-item'
    );
    const dropdownOrderBackdrop = document.querySelector(
      '.js-av-lm-cr__dropdown-order-backdrop'
    );

    const viewFavoritesCR = document.querySelector(
      '.js-av-lm-cr-view-favorites'
    );
    const backIconColumnLeft = document.querySelector('.js-av-lm-cl-back-icon');
    const columnLeft = document.querySelector('.js-av-lm-cl');
    const columnRight = document.querySelector('.js-av-lm-cr');

    const listTabElementsColumnLeft =
      document.querySelectorAll('.js-av-lm-cl__tab');

    // FUNCIONES:
    function filtrarFavoritos() {
      // Función para filtrar favoritos por variation
      favoritosFiltrados = favoritos.filter((favorito) => {
        const variacionPorcentajeType = favorito.getAttribute(
          'variacion-porcentaje-type'
        );
        return (
          activeFavoritos === 'all' ||
          activeFavoritos === variacionPorcentajeType
        );
      });

      favoritos.forEach((favorito) => {
        favorito.style.display = 'none';
      }); // Ocultar todos los favoritos
      favoritosFiltrados.forEach((favorito) => {
        favorito.style.display = 'flex';
      }); // Mostrar todos los favoritos filtrados

      const favoritesEmptyState = document.querySelector(
              '.js-av-lm-cl__favorites-empty-state'
      );

      const classesToRemove = Array.from(favoritesEmptyState.classList).filter(
              (className) => className.startsWith('av-lm-cl__favorites-empty-state--')
      );
      classesToRemove.forEach((className) => {
        favoritesEmptyState.classList.remove(className);
      });

      if(favoritosFiltrados.length === 0){
        favoritesEmptyState.classList.remove('d-none');
        favoritesEmptyState.classList.add(
                'av-lm-cl__favorites-empty-state--' + activeFavoritos
        );
      } else {
        favoritesEmptyState.classList.add('d-none');
      }
    }

    function openCloseDropdown() {
      dropdownSvg.classList.toggle('av-theme__rotate-180');
      dropdownBtn.classList.toggle('av-lm-cr__dropdown-btn-selected');
      dropdownMenu.classList.toggle('av-theme__hidden');
      dropdownBackdrop.classList.toggle('av-theme__hidden');
    }

    function closeDropdown() {
      dropdownSvg.classList.toggle('av-theme__rotate-180');
      dropdownBtn.classList.remove('av-lm-cr__dropdown-btn-selected');
      dropdownMenu.classList.add('av-theme__hidden');
      dropdownBackdrop.classList.add('av-theme__hidden');
    }

    function openCloseDropdownOrder() {
      dropdownOrderSvg.classList.toggle('av-theme__rotate-180');
      dropdownOrderBtn.classList.toggle('av-lm-cr__dropdown-btn-selected');
      dropdownOrderMenu.classList.toggle('av-theme__hidden');
      dropdownOrderBackdrop.classList.toggle('av-theme__hidden');
    }

    function closeDropdownOrder() {
      dropdownOrderSvg.classList.toggle('av-theme__rotate-180');
      dropdownOrderBtn.classList.remove('av-lm-cr__dropdown-btn-selected');
      dropdownOrderMenu.classList.add('av-theme__hidden');
      dropdownOrderBackdrop.classList.add('av-theme__hidden');
    }

    function changeSelectedTab(ev) {
      listTabElements.forEach((item) => {
        item.classList.remove('av-lm-cr__tab-selected');
      });
      ev.currentTarget.classList.add('av-lm-cr__tab-selected');
    }

    function openColumnRight() {
      columnLeft.classList.remove('av-theme__hidden-mobile');
      columnRight.classList.add('av-theme__hidden-mobile');
    }

    function openColumnLeft() {
      columnRight.classList.remove('av-theme__hidden-mobile');
      columnLeft.classList.add('av-theme__hidden-mobile');
    }

    function changeSelectedTabColumnLeft(ev) {
      listTabElementsColumnLeft.forEach((item) => {
        item.classList.remove('av-lm-cl__tab--selected');
      });
      ev.currentTarget.classList.add('av-lm-cl__tab--selected');
        activeFavoritos = ev.currentTarget.getAttribute(
            'variacion-porcentaje-type'
        );

      filtrarFavoritos();
    }

    // EVENTOS:
    dropdownBtn.addEventListener('click', openCloseDropdown);
    dropdownBackdrop.addEventListener('click', closeDropdown);

    dropdownOrderBtn.addEventListener('click', openCloseDropdownOrder);
    dropdownOrderBackdrop.addEventListener('click', closeDropdownOrder);

    listTabElements.forEach((item) => {
      item.addEventListener('click', changeSelectedTab);
    });

    viewFavoritesCR.addEventListener('click', openColumnRight);
    backIconColumnLeft.addEventListener('click', openColumnLeft);

    listTabElementsColumnLeft.forEach((item) => {
      item.addEventListener('click', changeSelectedTabColumnLeft);
    });

    // Scroll horizontal con el raton en las Cards del Widget.
    makeSliderDraggable('.js-av-lmw__cards');
  }

  // Lanzar la función de envoltorio cuando toda la página (incluyendo imágenes y recursos) ha sido completamente cargada.
  window.onload = function () {
    handleMarkets();
  };

  // Lanzar la función de envoltorio cuando todos los portlets estén listos.
  Liferay.on('allPortletsReady', function () {
    handleMarkets();
  });

  // Lanzar la función de envoltorio cuando una nueva pantalla se ha cargado en la navegación SPA.
  Liferay.on('screenLoad', function () {
    handleMarkets();
  });

  // Lanzar la función de envoltorio cuando la navegación SPA ha terminado.
  Liferay.on('endNavigate', function () {
    handleMarkets();
  });

  // Lanzar la función de envoltorio cuando se produce navegación en el SPA.
  Liferay.on('SPA_NAVIGATION', function (event) {
    handleMarkets();
  });

  // Lanzar la función de envoltorio cuando hay cambios de ruta.
  Liferay.on('routeChanged', function () {
    handleMarkets();
  });
</script>
