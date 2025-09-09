<%@ include file="/init.jsp" %>
<jsp:directive.page
  contentType="text/html"
  pageEncoding="UTF-8"
/>

<!-- Modal-menu -->
<!-- Modal pequeño de selección de opciones -->
<div class="av-theme-modal-menu av-theme-modal-menu__menu js-av-theme-modal-menu--lmw${themeDisplay.portletDisplay.instanceId} av-theme__hidden">
  <!-- Contenido del modal de menu -->
  <label onclick="openProductosParcelaEdit();" class="av-theme-modal-menu__menu-text">
    Editar productos de parcela
  </label>
</div>

<div class="av-lmw av-">
  <div class="av-lmw__container">
    <div class="av-lmw__header">
      <div class="av-lmw__header-title">Últimas lonjas y mercados</div>
      <div class="av-lmw__header-dots-icon js-av-lmw__dots${themeDisplay.portletDisplay.instanceId} <c:if test="${empty productosPacela}"> d-none </c:if>">
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
        <!-- Cards del Widget -->
        <div class="av-lm__plot-list">
          <c:if test="${empty productosPacela}">
            <div class="av-lm-cl__favorites-empty-state">
              <div class="av-theme-icon-box-24">
                <svg width="25" height="25" viewBox="0 0 25 25" fill="none" xmlns="http://www.w3.org/2000/svg">
                  <path fill-rule="evenodd" clip-rule="evenodd" d="M3.75 2.5C4.30229 2.5 4.75 2.94772 4.75 3.5V16.7C4.75 17.5566 4.75078 18.1389 4.78755 18.589C4.82337 19.0274 4.8883 19.2516 4.96799 19.408C5.15973 19.7843 5.4657 20.0903 5.84202 20.282C5.99842 20.3617 6.22262 20.4266 6.66104 20.4624C7.11113 20.4992 7.69342 20.5 8.55 20.5H21.75C22.3023 20.5 22.75 20.9477 22.75 21.5C22.75 22.0523 22.3023 22.5 21.75 22.5H8.50868C7.70372 22.5 7.03936 22.5 6.49817 22.4558C5.93608 22.4099 5.41937 22.3113 4.93404 22.064C4.18139 21.6805 3.56947 21.0686 3.18598 20.316C2.93868 19.8306 2.84012 19.3139 2.79419 18.7518C2.74998 18.2106 2.74999 17.5463 2.75 16.7413L2.75 3.5C2.75 2.94772 3.19772 2.5 3.75 2.5ZM16.75 10.5C16.1977 10.5 15.75 10.0523 15.75 9.5C15.75 8.94772 16.1977 8.5 16.75 8.5H20.75C21.3023 8.5 21.75 8.94772 21.75 9.5V13.5C21.75 14.0523 21.3023 14.5 20.75 14.5C20.1977 14.5 19.75 14.0523 19.75 13.5V11.9142L15.4571 16.2071C15.0666 16.5976 14.4334 16.5976 14.0429 16.2071L10.75 12.9142L7.45711 16.2071C7.06658 16.5976 6.43342 16.5976 6.04289 16.2071C5.65237 15.8166 5.65237 15.1834 6.04289 14.7929L10.0429 10.7929C10.4334 10.4024 11.0666 10.4024 11.4571 10.7929L14.75 14.0858L18.3358 10.5H16.75Z" fill="#101717"/>
                </svg>
              </div>
              <div class="text-center">
                <liferay-ui:message key="avanis.lonjas.producto.sin.producto.en.parcela" />
              </div>
            </div>
          </c:if>
          <c:if test="${not empty productosPacela}">
            <c:forEach
                    var="producto"
                    items="${productosPacela}"
            >
              <%@ include file="/card-widget.jsp" %>
            </c:forEach>
          </c:if>
        </div>
      </div>
    </div>
  </div>
</div>

<script type="text/javascript">
  // Variable de control para evitar ejecuciones concurrentes.
  var isExecutingProductosExplotacion = false;

  let manageDraggableProductosParcela = function() {
    const draggableItems = document.querySelectorAll(
            '.av-lm-modal__ef-draggable-item'
    );
    let draggedItem = null;

    draggableItems.forEach((item) => {
      item.addEventListener('dragstart', () => {

        draggedItem = item;
        setTimeout(() => item.classList.add('av-lm-modal__ef-dragging'), 0);
      });

      item.addEventListener('dragend', () => {
        setTimeout(() => {
          draggedItem = null;
          item.classList.remove('av-lm-modal__ef-dragging');
        }, 0);
      });

      item.addEventListener('dragover', (e) => {
        e.preventDefault();
        const currentItem = getDragAfterElement(item, e.clientY);
        const draggableList = item.parentNode;
        if (currentItem == null) {
          draggableList.appendChild(draggedItem);
        } else {
          draggableList.insertBefore(draggedItem, currentItem);
        }
      });
    });

    function getDragAfterElement(container, y) {
      const draggableItems = [
        ...container.parentElement.querySelectorAll(
                '.av-lm-modal__ef-draggable-item:not(.av-lm-modal__ef-dragging)'
        ),
      ];

      return draggableItems.reduce(
              (closest, child) => {
                const box = child.getBoundingClientRect();
                const offset = y - box.top - box.height / 2;
                if (offset < 0 && offset > closest.offset) {
                  return {offset: offset, element: child};
                } else {
                  return closest;
                }
              },
              {offset: Number.NEGATIVE_INFINITY}
      ).element;
    }
  }

  function listarProductosParcela() {
    <portlet:renderURL var='listarProductsParcelaUserURL' windowState='<%= LiferayWindowState.EXCLUSIVE.toString() %>' >
    <portlet:param name='mvcRenderCommandName' value='render_cmd_command' />
    <portlet:param name='<%=Constants.CMD%>' value='lista_productos_parcela' />
    <portlet:param name="plotId" value="${plotId}" />
    </portlet:renderURL>
    fetch('<%=listarProductsParcelaUserURL%>')
            .then((response) => {
              return response.text();
            })
            .then(function (html) {
              document.querySelector('.av-lm__plot-list').innerHTML = html;
              productosParcela = Array.from(document.querySelectorAll('.av-lmw__card'));
              if (productosParcela.length > 0) {
                document.querySelector('.js-av-lmw__dots${themeDisplay.portletDisplay.instanceId}').classList.remove('d-none');
              } else  {
                document.querySelector('.js-av-lmw__dots${themeDisplay.portletDisplay.instanceId}').classList.add('d-none');
              }
            })
            .catch((error) => {
              console.warn('Something went wrong.', error);
            });
  }

  function openProductosParcelaEdit() {
    const modalButtonsProductosParcela = [
      {
        text: 'Cancelar',
        classes: ['av-theme__btn', 'av-theme__btn--secondary'],
        callback: (modal) => { closeModal(modal); },
      },
      {
        text: 'Guardar',
        classes: ['av-theme__btn', 'av-theme__btn--primary'],
        callback: (modal) => {
          const form = document.getElementById('<portlet:namespace/>formProductosParcela');
          const formData = new FormData(form);
          fetch(form.action, { method: form.method, body: formData,
          }).then(response => { listarProductosParcela(); closeModal(modal); openNotification('<liferay-ui:message key="avanis.lonjas.producto.en.parcela.actualizado" />', 'succes');
          }).catch(error => { closeModal(modal);
          });
        },
      },
    ];

    document.querySelector('.js-av-theme-modal-menu--lmw${themeDisplay.portletDisplay.instanceId}').classList.add('av-theme__hidden');

    <portlet:renderURL var="editarProductsParcelaUserURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
    <portlet:param name="mvcRenderCommandName" value="render_cmd_command" />
    <portlet:param name="<%=Constants.CMD%>" value="editar_productos_parcela" />
    <portlet:param name="plotId" value="${plotId}" />
    </portlet:renderURL>

    fetch('<%=editarProductsParcelaUserURL%>').then(response => {
      return response.text();
    }).then(function (html) {
      openModal(html, '<liferay-ui:message key="avanis.lonjas.producto.editar.en.parcelas" />', modalButtonsProductosParcela, 'global', manageDraggableProductosParcela);
    }).catch(error => {
      console.warn('Something went wrong.', error);
    });
  }

  function deleteProductoParcelaModal(entityId) {
    document.querySelector('.producto-modal-' + entityId).remove();
  }

  // LLamada a la función de envoltorio.
  function handleProductosExplotacion() {
    if (isExecutingProductosExplotacion) {
      return;
    }

    // Bloquear nuevas ejecuciones mientras la función de envoltorio esta en curso.
    isExecutingProductosExplotacion = true;
    
    //
    // LÓGICA JS DENTRO DE LA FUNCIÓN DE ENVOLTORIO:
    //

    // VARIABLES Y CONSTANTES: ${themeDisplay.portletDisplay.instanceId}
    const dotsIcon = document.querySelector('.js-av-lmw__dots${themeDisplay.portletDisplay.instanceId}');
    const modalMenu = document.querySelector('.js-av-theme-modal-menu--lmw${themeDisplay.portletDisplay.instanceId}');

    // Tratamiento de los modales.
    // Modal menu - Cambiar visibilidad.
    dotsIcon.addEventListener('click', () => {
      modalMenu.classList.toggle('av-theme__hidden');
    });

    // Scroll horizontal con el raton en las Cards del Widget.
    makeSliderDraggable('.js-av-lmw__cards');
  }

  // Lanzar la función de envoltorio cuando toda la página (incluyendo imágenes y recursos) ha sido completamente cargada.
  window.onload = function () {
    handleProductosExplotacion();
  };

  // Lanzar la función de envoltorio cuando todos los portlets estén listos.
  Liferay.on('allPortletsReady', function () {
    handleProductosExplotacion();
  });

  // Lanzar la función de envoltorio cuando una nueva pantalla se ha cargado en la navegación SPA.
  Liferay.on('screenLoad', function () {
    handleProductosExplotacion();
  });

  // Lanzar la función de envoltorio cuando la navegación SPA ha terminado.
  Liferay.on('endNavigate', function () {
    handleProductosExplotacion();
  });

  // Lanzar la función de envoltorio cuando se produce navegación en el SPA.
  Liferay.on('SPA_NAVIGATION', function (event) {
    handleProductosExplotacion();
  });

  // Lanzar la función de envoltorio cuando hay cambios de ruta.
  Liferay.on('routeChanged', function () {
    handleProductosExplotacion();
  });
</script>
