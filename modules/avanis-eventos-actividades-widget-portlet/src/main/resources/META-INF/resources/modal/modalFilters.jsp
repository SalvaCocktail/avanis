<%@ include file="/init.jsp" %>

<portlet:resourceURL var="eventsURLFilter"
                     id="<%= AvanisEventosWidgetEventosActividadesPortletKeys.AVANISEVENTOSWIDGETEVENTOSACTIVIDADES_RESOURCE_FILTER %>">
</portlet:resourceURL>

<!-- modal filter preferences -->
<div class="av-modal-preferences-filter-container" >
  <div id="<portlet:namespace />modal-event-preferences" class="av-modal-preferences-filter modal-s micromodal-slide av-te-ma-modal" data-micromodal-close>
    <div class="av-te-ma-modal__panel">
      <div class="av-te-ma-modal__header">
        <h5 class="modal-title" ><liferay-ui:message	key="event.widget.filter.modal.title"/></h5>
        <button class="modal__close" aria-label="Close modal" data-micromodal-close="" id="boton-cerrar-modal-filtros-eventos">
          <svg width="20" height="20" viewBox="0 0 20 20" fill="none" xmlns="http://www.w3.org/2000/svg">
            <path fill-rule="evenodd" clip-rule="evenodd" d="M1.05752 1.05752C1.57822 0.536817 2.42244 0.536817 2.94313 1.05752L10.0003 8.11471L17.0575 1.05752C17.5782 0.536817 18.4224 0.536817 18.9431 1.05752C19.4638 1.57822 19.4638 2.42244 18.9431 2.94313L11.8859 10.0003L18.9431 17.0575C19.4638 17.5782 19.4638 18.4224 18.9431 18.9431C18.4224 19.4638 17.5782 19.4638 17.0575 18.9431L10.0003 11.8859L2.94313 18.9431C2.42244 19.4638 1.57822 19.4638 1.05752 18.9431C0.536817 18.4224 0.536817 17.5782 1.05752 17.0575L8.11471 10.0003L1.05752 2.94313C0.536817 2.42244 0.536817 1.57822 1.05752 1.05752Z" fill="#101717"/>
          </svg>

        </button>
      </div>
      <div class="av-te-ma-modal__content" id="modal-1-content">
        <h2 class="modal__description av-widget--title">
          <liferay-ui:message	key="event.widget.filter.modal.description"/>
        </h2>
        <aui:form method="post" cssClass="av-form-my-account" action="#" name="fma"  enctype="multipart/form-data" id="myForm">
          <aui:input type="hidden" value="event-preferences" name="focusedTab"/>

          <div class="desplegable-modal">
            <p class="mis-preferencias-contadores c-agricultura">Agricultura</p>
            <a class="nav-link-toggle" href="#submenu1"  data-target="#submenu1" aria-expanded="false">
					<span class="select-arrow">
						<svg width="14" height="8" viewBox="0 0 14 8" fill="none" xmlns="http://www.w3.org/2000/svg">
							<path fill-rule="evenodd"
                                  clip-rule="evenodd"
                                  d="M7 8C7.26522 8 7.51957 7.89464 7.70711 7.70711L13.7071 1.70711C14.0976 1.31658 14.0976 0.683417 13.7071 0.292893C13.3166 -0.0976315 12.6834 -0.0976315 12.2929 0.292893L7 5.58579L1.70711 0.292893C1.31658 -0.0976315 0.683418 -0.0976315 0.292893 0.292893C-0.0976311 0.683417 -0.0976311 1.31658 0.292893 1.70711L6.29289 7.70711C6.48043 7.89464 6.73478 8 7 8Z"
                                  fill="#101717">

							</path>
					 </svg>
					</span>
            </a>
          </div>
          <div id="submenu1" class="mb-3 collapse show" >
            <div class="preferences-select-container opciones-agricultura" data-select-id="selectContainer1">
              <c:forEach var="agricultureCategory" items="${agricultureCategories}">
                <c:choose>
                  <c:when test="${userInterests.contains(agricultureCategory.name.toLowerCase())}">
                    <div class="option selected"
                         data-value="${agricultureCategory.name}" onclick="toggleIcon(this)">
                        ${agricultureCategory.name}
                    </div>
                  </c:when>
                  <c:otherwise>
                    <div class="option" data-value="${agricultureCategory.name}"
                         onclick="toggleIcon(this)">${agricultureCategory.name}</div>
                  </c:otherwise>
                </c:choose>
              </c:forEach>
            </div>
          </div>
          <input type="hidden" name="<portlet:namespace/>selectedAgricultureCategories" id="hiddenSelectContainer1">
          <div class="desplegable-modal">
            <p class="mis-preferencias-contadores c-ganaderia">Ganaderia</p>
            <a class="nav-link-toggle" href="#submenu1"  data-target="#submenu2" aria-expanded="false">
					<span class="select-arrow">
						<svg width="14" height="8" viewBox="0 0 14 8" fill="none" xmlns="http://www.w3.org/2000/svg">
							<path fill-rule="evenodd"
                                  clip-rule="evenodd"
                                  d="M7 8C7.26522 8 7.51957 7.89464 7.70711 7.70711L13.7071 1.70711C14.0976 1.31658 14.0976 0.683417 13.7071 0.292893C13.3166 -0.0976315 12.6834 -0.0976315 12.2929 0.292893L7 5.58579L1.70711 0.292893C1.31658 -0.0976315 0.683418 -0.0976315 0.292893 0.292893C-0.0976311 0.683417 -0.0976311 1.31658 0.292893 1.70711L6.29289 7.70711C6.48043 7.89464 6.73478 8 7 8Z"
                                  fill="#101717">

							</path>
					 </svg>
					</span>
            </a>
          </div>
          <div id="submenu2" class="mb-3 collapse">

            <div class="preferences-select-container opciones-ganaderia" data-select-id="selectContainer2">
              <c:forEach var="stockbreadingCategory" items="${stockbreadingCategories}">
                <c:choose>
                  <c:when test="${userInterests.contains(stockbreadingCategory.name.toLowerCase())}">
                    <div class="option selected"
                         data-value="${stockbreadingCategory.name}"
                         onclick="toggleIcon(this)">${stockbreadingCategory.name}</div>
                  </c:when>
                  <c:otherwise>
                    <div class="option"
                         data-value="${stockbreadingCategory.name}"
                         onclick="toggleIcon(this)">${stockbreadingCategory.name}</div>
                  </c:otherwise>
                </c:choose>
              </c:forEach>
            </div>
          </div>
          <input type="hidden" name="<portlet:namespace/>selectedStockbreadingCategories" id="hiddenSelectContainer2">
          <div class="desplegable-modal">
            <p class="mis-preferencias-contadores c-otros">Otros</p>
            <a class="nav-link-toggle" href="#submenu1"  data-target="#submenu3" aria-expanded="false">
									<span class="select-arrow">
										<svg width="14" height="8" viewBox="0 0 14 8" fill="none" xmlns="http://www.w3.org/2000/svg">
											<path fill-rule="evenodd"
                                                  clip-rule="evenodd"
                                                  d="M7 8C7.26522 8 7.51957 7.89464 7.70711 7.70711L13.7071 1.70711C14.0976 1.31658 14.0976 0.683417 13.7071 0.292893C13.3166 -0.0976315 12.6834 -0.0976315 12.2929 0.292893L7 5.58579L1.70711 0.292893C1.31658 -0.0976315 0.683418 -0.0976315 0.292893 0.292893C-0.0976311 0.683417 -0.0976311 1.31658 0.292893 1.70711L6.29289 7.70711C6.48043 7.89464 6.73478 8 7 8Z"
                                                  fill="#101717">
											</path>
										</svg>
									</span>
            </a>
          </div>
          <div id="submenu3" class="mb-3 collapse" >
            <div class="preferences-select-container opciones-otros" data-select-id="selectContainer3">
              <c:forEach var="otherCategory" items="${otherCategories}">
                <c:choose>
                  <c:when test="${userInterests.contains(otherCategory.name.toLowerCase())}">
                    <div class="option selected" data-value="${otherCategory.name}"
                         onclick="toggleIcon(this)">${otherCategory.name}</div>
                  </c:when>
                  <c:otherwise>
                    <div class="option" data-value="${otherCategory.name}"
                         onclick="toggleIcon(this)">${otherCategory.name}</div>
                  </c:otherwise>
                </c:choose>
              </c:forEach>
            </div>
          </div>
          <input type="hidden" name="<portlet:namespace/>selectedOtherCategories" id="hiddenSelectContainer3">
        </aui:form>
        <!--<div class="mb-3">
          <p class="filter-empty-state"><liferay-ui:message	key="event.widget.filter.modal.empty"/></p>

        </div>-->

        <div class="av-te-ma-modal__text">

        </div>

        <button type="button" class="cancel__button btn-declinar" data-micromodal-close="">
          <p class="profile__button--text"><liferay-ui:message	key="event.widget.button.cancel"/></p>
        </button>
        <button type="submit" class="apply__button" id="btn-apply" data-micromodal-close="">
          <p class="profile__button--text"> <liferay-ui:message	key="event.widget.button.apply"/></p>
        </button>
      </div>
    </div>
  </div>
</div>

<script>
  // Actualizo los campos ocultos al inicio, así no se pierden aunque no interactuemos con ellos :)
  function updateHiddenFields() {
    $('.preferences-select-container').each(function () {
      var container = $(this);
      var selectId = container.data('select-id');
      var hiddenFieldId = 'hidden' + selectId.charAt(0).toUpperCase() + selectId.slice(1);
      var selectedValues = container.find('.option.selected').map(function () {
        return $(this).attr('data-value');
      }).get();
      var hiddenField = $('#' + hiddenFieldId);
      if (hiddenField.length) {
        hiddenField.val(selectedValues.join(','));
      } else {
        console.error('Elemento oculto con ID ' + hiddenFieldId + ' no encontrado');
      }
    });
  }

  // Inicializo los campos ocultos
  updateHiddenFields();

  // Inicializo los divs seleccionados con la clase show-icon para mostrar la x
  function initializeIcons() {
    $('.option.selected').each(function () {
      $(this).addClass('show-icon');
    });
  }
  initializeIcons();



  // Evento de click para las opciones.
  $('.preferences-select-container').on('click', '.option', function () {
    $(this).toggleClass('selected'); // Alterna la clase 'selected'

    // Obtener el ID del contenedor
    var container = $(this).closest('.preferences-select-container');
    var selectId = container.data('select-id');

    if (!selectId) {
      console.error('No se pudo obtener el ID del contenedor.');
      return;
    }

    // Crear el ID del campo oculto
    var hiddenFieldId = 'hidden' + selectId.charAt(0).toUpperCase() + selectId.slice(1);
    var hiddenFieldName = '<portlet:namespace/>' + container.data('select-id').replace('selectContainer', 'selected') + 'Categories';

    // Obtener el valor del elemento actual
    var currentValue = $(this).attr('data-value');

    // Agregar o quitar el valor del array global
    if ($(this).hasClass('selected')) {
      // Agregar si está seleccionado y no está ya en el array
      if (!selectedValuesGlobal.includes(currentValue)) {
        selectedValuesGlobal.push(currentValue);
      }
    } else {
      // Quitar si no está seleccionado
      var index = selectedValuesGlobal.indexOf(currentValue);
      if (index !== -1) {
        selectedValuesGlobal.splice(index, 1);
      }
    }

    // Obtener los valores seleccionados del contenedor actual
    var selectedValues = container.find('.option.selected').map(function () {
      return $(this).attr('data-value');
    }).get();

    // Actualizar el campo oculto con los valores seleccionados
    var hiddenField = $('#' + hiddenFieldId);
    if (hiddenField.length) {
      hiddenField.val(selectedValues.join(','));
    } else {
      console.error('Elemento oculto con ID ' + hiddenFieldId + ' no encontrado');
    }

    //console.log('Selected values for ' + selectId + ':', selectedValues);
    //console.log('Selected values global:', selectedValuesGlobal); // Muestra los valores globales seleccionados

    switch(selectId) {
      case "selectContainer1":
        $('.c-agricultura').text("Agricultura ("+selectedValues.length+"/"+$(".opciones-agricultura .option").toArray().length+")");
        break;
      case "selectContainer2":
        $('.c-ganaderia').text("Ganadería ("+selectedValues.length+"/"+$(".opciones-ganaderia .option").toArray().length+")");
        break;
      case "selectContainer3":
        $('.c-otros').text("Otros ("+selectedValues.length+"/"+$(".opciones-otros .option").toArray().length+")");
        break;
      default:
            // code block
    }
  });

  $('.nav-link-toggle').on('click', function() {
    const target = $(this).data('target'); // Obtener el ID del submenú desde el atributo data-target
    $(target).slideToggle(); // Alternar la visibilidad del submenú correspondiente
  });

  $('#btn-apply').on('click', function (event) {
    //console.log('Selected values global:', selectedValuesGlobal);
    ajaxFilterEvents('<portlet:namespace/>','${eventsURLFilter}', selectedValuesGlobal);
    //console.log(selectedValuesGlobal);
    //console.log(JSON.stringify(selectedValuesGlobal));
  });
  // Ocultar/mostrar el icono de cerrar en las casillas
  function toggleIcon(element) {
    element.classList.toggle('show-icon');
  }



</script>
<%-- FIN MI MODAL--%>