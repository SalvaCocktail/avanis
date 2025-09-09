<%@ page import="com.liferay.portal.kernel.util.PortalUtil" %> <%@ page
        import="com.liferay.portal.kernel.model.User" %> <%@ page
        import="com.liferay.portal.kernel.service.UserLocalServiceUtil" %> <%@ include
        file="./init.jsp" %> <%@ page contentType="text/html; charset=UTF-8"
                                      pageEncoding="UTF-8" %> <%@ taglib uri="http://java.sun.com/jsp/jstl/functions"
                                                                         prefix="fn" %>
<portlet:resourceURL var="sendData"/>
<portlet:actionURL
        var="saveAboutMeURL"
        name="saveAboutMe"
/>


<div class="av-main__header">
  <img class="go-to-menu"
          onClick="displayMenu()"
          class="mr-2"
          src="<%=request.getContextPath()%>/images/arrow-left.png"
          alt="arrow left"
  />
  <h2 class="titulo-sobre-mi-principal">Sobre mí</h2>
</div>

<!-- Form -->
<aui:form
        method="post"
        cssClass="av-form-my-account"
        action="${saveAboutMeURL}"
        name="fma"
        id="fma"
        enctype="multipart/form-data"
>
  <aui:input
          type="hidden"
          value="about"
          name="focusedTab"
  />
  <h4 class="titulo-sobre-mi">Añadir descripción</h4>
  <div class="av-form-about-me">
    <aui:input
            name="about"
            type="textarea"
            value="${about}"
            placeholder="Escribir aquí..."
    />
  </div>

  <h4 class="titulo-sobre-mi">Nombre completo</h4>
  <div class="mb-5 no-yellow-required">
    <aui:input
            label="Nombre*"
            name="name"
            value="${user.firstName}"
            cssClass="label-sobre-mi"
            required="true"
    />

    <aui:input
            label="Apellidos*"
            name="lastName"
            value="${user.lastName}"
            cssClass="label-sobre-mi"
            required="true"
    />


    <aui:input
            label="Nombre de usuario*"
            name="username"
            value="${user.screenName}"
            cssClass="label-sobre-mi"
            required="true"
    />


    <p class="av-form__disclaimer">
      Te lo pedimos para que tu perfil sea único y exclusivamente tuyo. Es el
      nombre que verán el resto de usuarios cuando publiques.
    </p>
  </div>

  <h4 class="titulo-sobre-mi">Actividad en el sector</h4>
  <div class="mb-5">
    <p class="label-sobre-mi">
      ¿Cuál es tu rol en el sector agropecuario?
    </p>

    <div class="mb-3 av-radio-buttons">
      <div class="mr-4 av-ma-radio-profesional">
        <aui:input
                label="Profesional"
                type="radio"
                name="dedicationLevel"
                value="professional"
                checked='${dedication_level == "professional"}'
        />
      </div>
      <div class="av-ma-radio-amateur">
        <aui:input
                label="Aficionado"
                type="radio"
                name="dedicationLevel"
                value="amateur"
                checked='${dedication_level == "amateur"}'
        />
      </div>
    </div>

    <!-- Div Amateur -->

    <div class="mb-3 div-amateur av-ma-div-amateur">
      <div class="av-select2__form-row av-select2__form-row--002">

        <label class="av-select2__form-label label-sobre-mi">
          ¿Como aficionado qué actividad realizas en el mundo agropecuario?
        </label>

        <div class="select-wrapper">
          <aui:select
                  label=""
                  cssClass="av-form-select av-select2__form-select"
                  id="multiple-select-amateur"
                  name="multiple-select-amateur"
                  data-placeholder=""
                  multiple="true"
          >
            <aui:option value="Agricultura" selected="false">
              Agricultura
            </aui:option>
            <aui:option value="Ganadería" selected="false">
              Ganadería
            </aui:option>
          </aui:select>

          <span id="texto-contador-aficionado" class="texto-contador select-count">
            (1)
          </span>

          <span class="select-arrow">
            <svg width="14" height="8" viewBox="0 0 14 8" fill="none" xmlns="http://www.w3.org/2000/svg">
                <path fill-rule="evenodd" clip-rule="evenodd" d="M7 8C7.26522 8 7.51957 7.89464 7.70711 7.70711L13.7071 1.70711C14.0976 1.31658 14.0976 0.683417 13.7071 0.292893C13.3166 -0.0976315 12.6834 -0.0976315 12.2929 0.292893L7 5.58579L1.70711 0.292893C1.31658 -0.0976315 0.683418 -0.0976315 0.292893 0.292893C-0.0976311 0.683417 -0.0976311 1.31658 0.292893 1.70711L6.29289 7.70711C6.48043 7.89464 6.73478 8 7 8Z" fill="#101717" />
            </svg>
          </span>

        </div>
      </div>
    </div>

    <!-- Div Profesional -->

    <div class="mb-3 div-profesional av-ma-div-profesional">
      <div class="av-select2__form-row av-select2__form-row--002">

        <label class="av-select2__form-label label-sobre-mi">
          ¿A qué te dedicas?
        </label>

        <div class="select-wrapper">
          <aui:select
                  label=""
                  cssClass="av-form-select av-select2__form-select"
                  id="multiple-select-field1"
                  name="selectedDedications"
                  data-placeholder=""
                  multiple="true"
          >
            <c:forEach var="dedication" items="${dedications}">
              <aui:option value="${dedication.name}" selected="${userCategories.contains(dedication.getName().toLowerCase())}" >
                ${dedication.name}
              </aui:option>
            </c:forEach>
          </aui:select>

          <span id="texto-contador-profesional" class="texto-contador select-count">
            (1)
          </span>

          <span class="select-arrow">
            <svg width="14" height="8" viewBox="0 0 14 8" fill="none" xmlns="http://www.w3.org/2000/svg">
                <path fill-rule="evenodd" clip-rule="evenodd" d="M7 8C7.26522 8 7.51957 7.89464 7.70711 7.70711L13.7071 1.70711C14.0976 1.31658 14.0976 0.683417 13.7071 0.292893C13.3166 -0.0976315 12.6834 -0.0976315 12.2929 0.292893L7 5.58579L1.70711 0.292893C1.31658 -0.0976315 0.683418 -0.0976315 0.292893 0.292893C-0.0976311 0.683417 -0.0976311 1.31658 0.292893 1.70711L6.29289 7.70711C6.48043 7.89464 6.73478 8 7 8Z" fill="#101717" />
            </svg>
          </span>

        </div>
      </div>
    </div>

    <!-- Div Agricultura -->

    <div class="mb-3 div-agricultura av-ma-mb-3 div-agricultura">
      <div class="av-select2__form-row av-select2__form-row--002">

        <label class="av-select2__form-label label-sobre-mi">
          ¿Nos das más detalle de tu actividad como agricultor?
        </label>

        <div class="select-wrapper">

          <aui:select
                  label=""
                  cssClass="av-form-select av-select2__form-select"
                  id="multiple-select-field2"
                  name="selectedAgricultureCategories"
                  data-placeholder=""
                  multiple="true"
          >
            <c:forEach
                    var="agricultureCategory"
                    items="${agricultureCategories}"
            >
              <aui:option value="${agricultureCategory.name}" selected="${userCategories.contains(agricultureCategory.getName().toLowerCase())}" >
                ${agricultureCategory.name}
              </aui:option>
            </c:forEach>
          </aui:select>

          <span id="texto-contador-agricultura" class="texto-contador select-count">
            (1)
          </span>

          <span class="select-arrow">
            <svg width="14" height="8" viewBox="0 0 14 8" fill="none" xmlns="http://www.w3.org/2000/svg">
                <path fill-rule="evenodd" clip-rule="evenodd" d="M7 8C7.26522 8 7.51957 7.89464 7.70711 7.70711L13.7071 1.70711C14.0976 1.31658 14.0976 0.683417 13.7071 0.292893C13.3166 -0.0976315 12.6834 -0.0976315 12.2929 0.292893L7 5.58579L1.70711 0.292893C1.31658 -0.0976315 0.683418 -0.0976315 0.292893 0.292893C-0.0976311 0.683417 -0.0976311 1.31658 0.292893 1.70711L6.29289 7.70711C6.48043 7.89464 6.73478 8 7 8Z" fill="#101717" />
            </svg>
          </span>

        </div>
      </div>
    </div>


    <!-- Div Ganadería -->

    <div class="mb-3 div-ganaderia av-ma-mb-3 div-ganaderia">
      <div class="av-select2__form-row av-select2__form-row--002">

        <label class="av-select2__form-label label-sobre-mi">
          ¿Nos das más detalle de tu actividad como ganadero?
        </label>

        <div class="select-wrapper">

          <aui:select
                  label=""
                  cssClass="av-form-select av-select2__form-select"
                  id="multiple-select-field3"
                  name="selectedStockbreadingCategories"
                  data-placeholder=""
                  multiple="true"
          >
            <c:forEach
                    var="stockbreadingCategory"
                    items="${stockbreadingCategories}"
            >
              <aui:option value="${stockbreadingCategory.name}" selected="${userCategories.contains(stockbreadingCategory.getName().toLowerCase())}" >
                ${stockbreadingCategory.name}
              </aui:option>
            </c:forEach>
          </aui:select>

          <span id="texto-contador-ganaderia" class="texto-contador select-count">
            (1)
          </span>

          <span class="select-arrow">
            <svg width="14" height="8" viewBox="0 0 14 8" fill="none" xmlns="http://www.w3.org/2000/svg">
                <path fill-rule="evenodd" clip-rule="evenodd" d="M7 8C7.26522 8 7.51957 7.89464 7.70711 7.70711L13.7071 1.70711C14.0976 1.31658 14.0976 0.683417 13.7071 0.292893C13.3166 -0.0976315 12.6834 -0.0976315 12.2929 0.292893L7 5.58579L1.70711 0.292893C1.31658 -0.0976315 0.683418 -0.0976315 0.292893 0.292893C-0.0976311 0.683417 -0.0976311 1.31658 0.292893 1.70711L6.29289 7.70711C6.48043 7.89464 6.73478 8 7 8Z" fill="#101717" />
            </svg>
          </span>

        </div>
      </div>
    </div>

    <!--  -->

  </div>

  <h4 class="titulo-sobre-mi">Localización</h4>
  <div>
    <div>
      <p class="label-sobre-mi">Provincia</p>
      <aui:select
              label=""
              id="province"
              type="select"
              placeholder=""
              name="province"
      >
        <aui:option
                value=""
                disabled=""
        >Seleccionar</aui:option
        >
      </aui:select>
    </div>

    <div>
      <p class="label-sobre-mi">Población</p>
      <aui:select
              label=""
              name="location"
              placeholder="Seleccionar"
      >
        <aui:option>Seleccionar</aui:option>
      </aui:select>
    </div>
  </div>
  <!-- Campos ocultos para provincia y población -->

  <aui:input
          name="provinceName"
          id="provinceName"
          value="${province}"
          type="hidden"
  />

  <aui:input
          name="locationName"
          id="locationName"
          value="${location}"
          type="hidden"
  />

  <h4 class="titulo-sobre-mi">Datos de contacto</h4>
  <div class="mb-5">
    <p class="label-sobre-mi">Teléfono</p>
    <aui:input
            name="phone"
            type="text"
            label="Número de teléfono"
            value="${phone}"
            validator="pattern"
            pattern="^\d{9}$"
            title="Por favor el teléfono debe tener 9 números."
    />
  </div>



  <!--Cancel and save btns-->
  <div class="av-about-form-control-buttons">
    <button
            type="button"
            class="av-te__btn av-te__btn--secondary"
    >
      Cancelar
    </button>

    <aui:button
            type="submit"
            value="Guardar"
            cssClass="av-te__btn av-te__btn--primary"
            id="submitButton"

    >
    </aui:button>
  </div>
</aui:form>


<%--<script
        src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.13/js/select2.min.js"
        defer
></script>

<!-- Include jQuery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- Include Select2 CSS -->
<link href="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/css/select2.min.css" rel="stylesheet" />
<!-- Include Select2 JS -->
<script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/js/select2.min.js"></script>

<!-- Include Leaflet CSS -->
<link rel="stylesheet" href="https://unpkg.com/leaflet/dist/leaflet.css" />
<!-- Include Leaflet JS -->
<script src="https://unpkg.com/leaflet/dist/leaflet.js"></script>--%>

<script>
  // Cargar los estilos del selector múltiple.
  function loadMultiSelectorStyle() {

    var multiSelector = document.querySelector('#multiple-select-optgroup-field');

    $(multiSelector).select2({
      width: multiSelector.dataset.width ? multiSelector.dataset.width : multiSelector.classList.contains('w-100') ? '100%' : 'style',
      placeholder: multiSelector.dataset.placeholder,
      closeOnSelect: false
    }).on('change', updateCount);

    updateCount();
  }

  function updateCount() {
    var selectElement = document.querySelector('#multiple-select-optgroup-field');
    var countElement = document.getElementById('select-count');
    var selectedOptions = $(selectElement).select2('data');
    countElement.textContent = selectedOptions.length;
  }

  Liferay.on('SPA_NAVIGATION', function(event) {
    loadMultiSelectorStyle();
  });

  document.addEventListener('DOMContentLoaded', function() {
    loadMultiSelectorStyle();
  });
</script>

<script>

  // Función para actualizar el nombre de la provincia en el campo oculto
  function updateProvinceName() {

    const provinceSelect = document.getElementById('<portlet:namespace/>province');
    const selectedOption = provinceSelect.options[provinceSelect.selectedIndex];
    const provinceName = selectedOption.text;
    document.getElementById('<portlet:namespace/>provinceName').value = provinceName;
    //console.log("updateProvinceName "+ selectedOption);
    //console.log("provinceName "+ provinceName);
    $('#<portlet:namespace/>provinceName').val(provinceName);
  }

  // Función para actualizar el nombre de la población en el campo oculto
  function updateLocationName() {

    const locationSelect = document.querySelector('select[name="<portlet:namespace/>location"]');
    const selectedOption = locationSelect.options[locationSelect.selectedIndex];
    const locationName = selectedOption.text;
    document.getElementById('<portlet:namespace/>locationName').value = locationName;
    //console.log("updateLocationName "+ selectedOption);
    //console.log("locationName "+ locationName);
  }

  // Añadir listeners para actualizar los campos ocultos
  //document.getElementById('<portlet:namespace/>province').addEventListener('change', updateProvinceName);
  document.getElementById('<portlet:namespace/>province').addEventListener('change', function() {

    $('#<portlet:namespace/>locationName').val('Seleccionar');
    updateProvinceName();  // Llama a la función updateProvinceName

  });
  document.querySelector('select[name="<portlet:namespace/>location"]').addEventListener('change', updateLocationName);

  // Obtén los radio buttons por su ID
  level1 = document.getElementById('<portlet:namespace/>dedicationLevel_1');
  level3 = document.getElementById('<portlet:namespace/>dedicationLevel_3');

  //Inicializo los datos
  function inicializar_datos() {

    if(${dedication_level == "amateur"}) {
      //si aficionado compruebo los campos de agricultura y ganadería si tienen datos
      //Si hay campos seleccionados en agricultura actualizo campo amateur
      if ($('#<portlet:namespace/>multiple-select-field2').find('option:selected').length > 0) {
        $('#<portlet:namespace/>multiple-select-amateur').val(['Agricultura']).trigger('change');
      }

      if ($('#<portlet:namespace/>multiple-select-field3').find('option:selected').length > 0) {
        $('#<portlet:namespace/>multiple-select-amateur').val(['Ganadería']).trigger('change');
      }
      if ($('#<portlet:namespace/>multiple-select-field2').find('option:selected').length > 0 && $('#<portlet:namespace/>multiple-select-field3').find('option:selected').length > 0) {
        {
          $('#<portlet:namespace/>multiple-select-amateur').val(['Ganadería', 'Agricultura']).trigger('change');
        }
      }

      if ($('#<portlet:namespace/>multiple-select-field2').find('option:selected').length == 0 && $('#<portlet:namespace/>multiple-select-field3').find('option:selected').length == 0) {        {
          $('#<portlet:namespace/>multiple-select-amateur').val('').trigger('change');
        }
      }

      $('.div-amateur').fadeIn();
      //recorro el multiple de amateur y si esta selecionada agricultura o ganaderia se muestran
      var selectedValues = $('#<portlet:namespace/>multiple-select-amateur')
              .val() || [];  // Obtiene los valores seleccionados

      if (selectedValues.includes('Agricultura')) {
        $('.div-agricultura').fadeIn();
        <%-- CODIGO PARA RECARGA AMATEUR AGRICULTURA--%>
            var agricultureCategoryIds = [];
            <c:forEach var="agricultureCategory" items="${agricultureCategories}">
            var agricultureCategoryId = '${agricultureCategory.name}';
            var agricultureIsSelected = ${userCategories.contains(agricultureCategory.getName().toLowerCase())};
            if(agricultureIsSelected === true){
              agricultureCategoryIds.push(agricultureCategoryId);
            }
            </c:forEach>
            $('#<portlet:namespace/>multiple-select-field2').val(agricultureCategoryIds).trigger('change');
        <%-- FIN CODIGO PARA RECARGA AMATEUR AGRICULTURA--%>
      }

      if (selectedValues.includes('Ganadería')) {
        $('.div-ganaderia').fadeIn();
        <%-- CODIGO PARA RECARGA AMATEUR GANADERIA--%>
        var stockbreadingCategoryIds = [];
        <c:forEach var="stockbreadingCategory" items="${stockbreadingCategories}">
            var stockbreadingCategoryId = '${stockbreadingCategory.name}';
            var stockbreadingIsSelected = ${userCategories.contains(stockbreadingCategory.getName().toLowerCase())};
            if(stockbreadingIsSelected === true){
              stockbreadingCategoryIds.push(stockbreadingCategoryId);
            }
        </c:forEach>
        $('#<portlet:namespace/>multiple-select-field3').val(stockbreadingCategoryIds).trigger('change');
        <%-- FIN CODIGO PARA RECARGA AMATEUR GANADERIA--%>
      }
    }

    if (${dedication_level == "professional"}) {
      $('.div-profesional').fadeIn();
      $('.div-amateur').fadeOut();

      //recorro el multiple de amateur y si esta selecionada agricultura o ganaderia se muestran
      $('#<portlet:namespace/>multiple-select-field1 option:selected').each(function () {
        // Imprime el valor y el texto de cada opción seleccionada

        let selectedValue = jQuery(this).text().trim().toLowerCase();
        <%-- CODIGO PARA RECARGA PROFESIONAl --%>

            var proffesionalCategoryIds = [];
            <c:forEach var="dedication" items="${dedications}">
            // Obtener el categoryId y comprobar si está en userCategories
            var categoryId = '${dedication.name}';
            var isSelected = ${userCategories.contains(dedication.getName().toLowerCase())};
            if(isSelected === true){
              proffesionalCategoryIds.push(categoryId);
            }
            </c:forEach>
            $('#<portlet:namespace/>multiple-select-field1').val(proffesionalCategoryIds).trigger('change');
        <%-- FIN CODIGO PARA RECARGA PROFESIONAl --%>
        if (selectedValue === 'agricultura') {
          $('.div-agricultura').fadeIn();
          <%-- CODIGO PARA RECARGA AMATEUR AGRICULTURA--%>
          var agricultureCategoryIds = [];
          <c:forEach var="agricultureCategory" items="${agricultureCategories}">
          var agricultureCategoryId = '${agricultureCategory.name}';
          var agricultureIsSelected = ${userCategories.contains(agricultureCategory.getName().toLowerCase())};
          if(agricultureIsSelected === true){
            agricultureCategoryIds.push(agricultureCategoryId);
          }
          </c:forEach>
          $('#<portlet:namespace/>multiple-select-field2').val(agricultureCategoryIds).trigger('change');
          <%-- FIN CODIGO PARA RECARGA AMATEUR AGRICULTURA--%>
          //console.log('Agricultura está seleccionado.');
        }

        if (selectedValue ==='ganadería') {
          $('.div-ganaderia').fadeIn();
          <%-- CODIGO PARA RECARGA AMATEUR GANADERIA--%>
          var stockbreadingCategoryIds = [];
          <c:forEach var="stockbreadingCategory" items="${stockbreadingCategories}">
          var stockbreadingCategoryId = '${stockbreadingCategory.name}';
          var stockbreadingIsSelected = ${userCategories.contains(stockbreadingCategory.getName().toLowerCase())};
          if(stockbreadingIsSelected === true){
            stockbreadingCategoryIds.push(stockbreadingCategoryId);
          }
          </c:forEach>
          $('#<portlet:namespace/>multiple-select-field3').val(stockbreadingCategoryIds).trigger('change');
          <%-- FIN CODIGO PARA RECARGA AMATEUR GANADERIA--%>
          updateSelectionCount_ganaderia();
        }
      });
    }
  }
  // Inicializar el conteo al cargar la página
  inicializar_datos();

  //Contadores de los selects
  // Función para actualizar el texto con el número de opciones seleccionadas Aficionado
  function updateSelectionCount_amateur() {
    const selectElement_amateur = document.getElementById('<portlet:namespace/>multiple-select-amateur');
    const countText_amateur = document.getElementById('texto-contador-aficionado');

    // Contar el número de opciones seleccionadas
    const selectedOptions_amateur = Array.from(selectElement_amateur.selectedOptions).length;

    // Total de opciones disponibles
    const totalOptions_amateur = selectElement_amateur.options.length;

    // Actualizar el texto
    countText_amateur.textContent = selectedOptions_amateur;
  }

  // Función para actualizar el texto con el número de opciones seleccionadas Profesional
  function updateSelectionCount_profesional() {
    const selectElement_profesional = document.getElementById('<portlet:namespace/>multiple-select-field1');
    const countText_profesional = document.getElementById('texto-contador-profesional');

    // Contar el número de opciones seleccionadas
    const selectedOptions_profesional = Array.from(selectElement_profesional.selectedOptions).length;

    // Total de opciones disponibles
    const totalOptions_profesional = selectElement_profesional.options.length;

    // Actualizar el texto
    countText_profesional.textContent = selectedOptions_profesional;
  }

  // Función para actualizar el texto con el número de opciones seleccionadas Agricultura
  function updateSelectionCount_agricultura() {
    const selectElement_agricultura = document.getElementById('<portlet:namespace/>multiple-select-field2');
    const countText_agricultura = document.getElementById('texto-contador-agricultura');

    // Contar el número de opciones seleccionadas
    const selectedOptions_agricultura = Array.from(selectElement_agricultura.selectedOptions).length;

    // Total de opciones disponibles
    const totalOptions_agricultura = selectElement_agricultura.options.length;

    // Actualizar el texto
    countText_agricultura.textContent = selectedOptions_agricultura;
  }


  // Función para actualizar el texto con el número de opciones seleccionadas Aficionado
  function updateSelectionCount_ganaderia() {
    const selectElement_ganaderia = document.getElementById('<portlet:namespace/>multiple-select-field3');
    const countText_ganaderia = document.getElementById('texto-contador-ganaderia');

    // Contar el número de opciones seleccionadas
    const selectedOptions_ganaderia = Array.from(selectElement_ganaderia.selectedOptions).length;

    // Total de opciones disponibles
    const totalOptions_ganaderia = selectElement_ganaderia.options.length;

    // Actualizar el texto
    countText_ganaderia.textContent = selectedOptions_ganaderia;

  }

  updateSelectionCount_amateur();
  updateSelectionCount_profesional();
  updateSelectionCount_agricultura();
  updateSelectionCount_ganaderia();

  var provinces = {};
  var populations = {};

  // Función para cargar provincias desde el JSON
  async function loadProvinces() {
    const response = await fetch('<%=request.getContextPath()%>/json/provincias.json');
    const data = await response.json();

    const provinceSelect = document.getElementById('<portlet:namespace/>province');
    data.forEach(province => {
      provinces[province.code] = province.label;
      const option = document.createElement('option');
      option.value = province.code;
      option.textContent = province.label;
      provinceSelect.appendChild(option);
    });

    $('#<portlet:namespace/>province option').filter(function() {
      return $(this).text().trim() === '${province}';
    }).prop('selected', true).parent().change();

  }

  // Función para cargar poblaciones desde el JSON
  async function loadPopulations() {
    const response = await fetch('<%=request.getContextPath()%>/json/poblaciones.json');
    const data = await response.json();

    data.forEach(population => {
      if (!populations[population.parent_code]) {
        populations[population.parent_code] = [];
      }
      populations[population.parent_code].push({ code: population.code, label: population.label });
    });
    updateLocations();

  }
  $('#<portlet:namespace/>location option').filter(function() {
    return $(this).text().trim() === '${location}';
  }).prop('selected', true).parent().change();


  // Función para actualizar las poblaciones basadas en la provincia seleccionada
  function updateLocations() {
    const provinceSelect = document.getElementById('<portlet:namespace/>province');
    const locationSelect = document.querySelector('select[name="<portlet:namespace/>location"]');

    // Limpia las opciones actuales de localización
    locationSelect.innerHTML = '<option value=""  selected>Seleccionar</option>';
    //$('#<portlet:namespace/>provinceName').val('${province}');
    //$('#<portlet:namespace/>locationName').val('${location}');

    const selectedProvinceCode = provinceSelect.value;
    if (selectedProvinceCode && populations[selectedProvinceCode]) {
      populations[selectedProvinceCode].forEach(population => {
        const option = document.createElement('option');
        option.value = population.code;
        option.textContent = population.label;
        locationSelect.appendChild(option);
      });
    }
    //valor del inputname selecciono poblacion
    if('${location}'!=='' ){
      $('#<portlet:namespace/>location option').each(function() {
        if ($(this).text() === '${location}') {
          $(this).prop('selected', true);
        }
      });
    }
  }

  // Inicializa las listas de provincias y poblaciones
  document.addEventListener('DOMContentLoaded', async function () {
    await loadProvinces();
    await loadPopulations();

    $('#<portlet:namespace/>province option').filter(function() {
      return $(this).text().trim() === '${province}';
    }).prop('selected', true).parent().change();

    //pongo el valor a provincias y updateo localidades
    $('#<portlet:namespace/>locationName').val('${location}');
    updateLocations();

    if('${province}'){
      $('#<portlet:namespace/>provinceName').val('${province}');
    }

    $('#<portlet:namespace/>location option').filter(function() {
      return $(this).text().trim() === '${location}';
    }).prop('selected', true).parent().change();

  });

  // Añade un listener para el cambio en la provincia
  document.getElementById('<portlet:namespace/>province').addEventListener('change', updateLocations);

  loadProvinces();
  loadPopulations();
  updateLocations();


  $('#<portlet:namespace/>province option').filter(function() {
    return $(this).text().trim() === '${province}';
  }).prop('selected', true).parent().change();

  //FIN DATOS QUE FUNCIONAN DESPUES DE CARGARA

  // Función que se ejecuta cuando se hace clic en un radio button
  function handleRadioClick(event) {
    // Obtén el ID del radio button clickeado
    const id = event.target.id;

    <%-- profesional o amateur TODO deseleccionar todos los campos que se han ocultado, o los hago antes de guardar ya veré--%>
    if (id === '<portlet:namespace/>dedicationLevel_1') {
      // Seleccionado Profesional

      //limpio Profesional
      $('#<portlet:namespace/> option').prop('selected', false);
      $('#<portlet:namespace/>multiple-select-amateur').val(null).trigger('change');

      $('#<portlet:namespace/>multiple-select-amateur option').prop('selected', false);
      $('#<portlet:namespace/>multiple-select-amateur').val(null).trigger('change');

      $('#<portlet:namespace/>multiple-select-field1 option').prop('selected', false);
      $('#<portlet:namespace/>multiple-select-field1').val(null).trigger('change');

      $('#<portlet:namespace/>multiple-select-field2 option').prop('selected', false);
      $('#<portlet:namespace/>multiple-select-field2').val(null).trigger('change');

      $('#<portlet:namespace/>multiple-select-field3 option').prop('selected', false);
      $('#<portlet:namespace/>multiple-select-field3').val(null).trigger('change');
      inicializar_datos();
      updateSelectionCount_profesional();
      updateSelectionCount_ganaderia();
      updateSelectionCount_agricultura();
      $('.div-profesional').fadeIn();
      $('.div-amateur').fadeOut();
      $('.div-agricultura').fadeOut();
      $('.div-ganaderia').fadeOut();

      //Seleccionado aficionado
    } else if (id === '<portlet:namespace/>dedicationLevel_3') {
      // Si Seleccionado Aficionado - Limpio Aficionado

      $('#<portlet:namespace/>multiple-select-amateur option').prop('selected', false);
      $('#<portlet:namespace/>multiple-select-amateur').val(null).trigger('change');
      $('#<portlet:namespace/>multiple-select-field1 option').prop('selected', false);
      $('#<portlet:namespace/>multiple-select-field1').val(null).trigger('change');
      $('#<portlet:namespace/>multiple-select-field2 option').prop('selected', false);
      $('#<portlet:namespace/>multiple-select-field2').val(null).trigger('change');

      $('#<portlet:namespace/>multiple-select-field3 option').prop('selected', false);
      $('#<portlet:namespace/>multiple-select-field3').val(null).trigger('change');

      inicializar_datos();
      updateSelectionCount_amateur();
      updateSelectionCount_ganaderia();
      updateSelectionCount_agricultura();
      $('.div-amateur').fadeIn();
      $('.div-profesional').fadeOut();
      $('.div-agricultura').fadeOut();
      $('.div-ganaderia').fadeOut();
    }
  }


  // Añade el event listener a cada radio button
  level1.addEventListener('change', handleRadioClick);
  level3.addEventListener('change', handleRadioClick);

  // Función para manejar cambios en el select múltiple "multiple-select-amateur"
  Liferay.on('allPortletsReady', function () {

    // Captar eventos de selección y deselección para ver si selecciona Agricultura o Ganadería para mostrar estos datos y updateo el contador
    $('#<portlet:namespace/>multiple-select-amateur').on('select2:select', function(e) {
      var data = e.params.data;
      //console.log("VALOR "+data.text);
      if (data.text.trim() === "Agricultura") {
        $('.div-agricultura').fadeIn();
      }
      if (data.text.trim() === "Ganadería") {
        $('.div-ganaderia').fadeIn();            }


      var totalOptions = $('#<portlet:namespace/>multiple-select-amateur option').length;
      var selectedOptions = $('#<portlet:namespace/>multiple-select-amateur option:selected').length;
      $('#texto-contador-aficionado').text(selectedOptions);
    });

    //Si deseleccionamos o Agricultura o ganadería de aficionado
    $('#<portlet:namespace/>multiple-select-amateur').on('select2:unselect', function(e) {
      var data = e.params.data;
      if (data.text.trim() === "Agricultura") {
        $('.div-agricultura').fadeOut();
        $('#<portlet:namespace/>multiple-select-field2 option').prop('selected', false);

        $('#<portlet:namespace/>multiple-select-field2').val(null).trigger('change');
        updateSelectionCount_agricultura();
      }
      if (data.text.trim() === "Ganadería") {
        $('.div-ganaderia').fadeOut();
        $('#<portlet:namespace/>multiple-select-field3 option').prop('selected', false);

        $('#<portlet:namespace/>multiple-select-field3').val(null).trigger('change');
        updateSelectionCount_ganaderia();
      }
      updateSelectionCount_amateur();
    });

    //Si seleccionamos o Agricultura o ganadería de profesional
    $('#<portlet:namespace/>multiple-select-field1').on('select2:select', function(e) {
      var data = e.params.data;
      if (data.text.trim() === "Agricultura") {
        $('.div-agricultura').fadeIn();
      }
      if (data.text.trim() === "Ganadería") {
        $('.div-ganaderia').fadeIn();
      }
      updateSelectionCount_profesional();
    });

    //Si deseleccionamos o Agricultura o ganadería de profesional
    $('#<portlet:namespace/>multiple-select-field1').on('select2:unselect', function(e) {
      var data = e.params.data;
      if (data.text.trim() === "Agricultura") {
        $('.div-agricultura').fadeOut();
        $('#<portlet:namespace/>multiple-select-field2 option').prop('selected', false);
        $('#<portlet:namespace/>multiple-select-field2').val(null).trigger('change');
        updateSelectionCount_agricultura();
      }
      if (data.text.trim() === "Ganadería") {
        $('.div-ganaderia').fadeOut();
        $('#<portlet:namespace/>multiple-select-field3 option').prop('selected', false);
        $('#<portlet:namespace/>multiple-select-field3').val(null).trigger('change');
        updateSelectionCount_ganaderia();
      }
      let totalOptions = $('#<portlet:namespace/>multiple-select-field1 option').length;
      let selectedOptions = $('#<portlet:namespace/>multiple-select-field1 option:selected').length;
      $('#texto-contador-profesional').text(selectedOptions);
    });

    //Si seleccionamos algun elemento de Agricultura
    $('#<portlet:namespace/>multiple-select-field2').on('select2:select', function(e) {
      updateSelectionCount_agricultura();
    });
    //Si deseleccionamos algun elemento de Ganadería
    $('#<portlet:namespace/>multiple-select-field2').on('select2:unselect', function(e) {
      updateSelectionCount_agricultura();
    });
    //Si seleccionamos algun elemento de Ganaderia
    $('#<portlet:namespace/>multiple-select-field3').on('select2:select', function(e) {
      updateSelectionCount_ganaderia();
    });
    //Si deseleccionamos algun elemento de Ganadería
    $('#<portlet:namespace/>multiple-select-field3').on('select2:unselect', function(e) {
      updateSelectionCount_ganaderia();
    });
  });
</script>

<script>
  // Función para cargar estilos de selects múltiples

  function loadMultiSelectorStyle() {
    var multiSelector1 = document.querySelector('#<portlet:namespace/>multiple-select-field1');
    var multiSelector2 = document.querySelector('#<portlet:namespace/>multiple-select-field2');
    var multiSelector3 = document.querySelector('#<portlet:namespace/>multiple-select-field3');
    var multiSelectoramateur =document.querySelector('#<portlet:namespace/>multiple-select-amateur');
    $(multiSelector1).select2({
      width: multiSelector1.dataset.width ? multiSelector1.dataset.width : multiSelector1.classList.contains('w-100') ? '100%' : 'style',
      placeholder: multiSelector1.dataset.placeholder,
      closeOnSelect: false
    });

    $(multiSelector2).select2({
      width: multiSelector2.dataset.width ? multiSelector2.dataset.width : multiSelector2.classList.contains('w-100') ? '100%' : 'style',
      placeholder: multiSelector2.dataset.placeholder,
      closeOnSelect: false
    });

    $(multiSelector3).select2({
      width: multiSelector3.dataset.width ? multiSelector3.dataset.width : multiSelector3.classList.contains('w-100') ? '100%' : 'style',
      placeholder: multiSelector3.dataset.placeholder,
      closeOnSelect: false
    });

    <%-- El de agricultura y gnadería nuevo--%>
    $(multiSelectoramateur).select2({
      width: multiSelectoramateur.dataset.width ? multiSelectoramateur.dataset.width : multiSelectoramateur.classList.contains('w-100') ? '100%' : 'style',
      placeholder: multiSelectoramateur.dataset.placeholder,
      closeOnSelect: false
    });
  }

  function showRequiredMessage() {
    var inputField = $('#<portlet:namespace />username');

    // Si el contenedor del mensaje no existe, lo creamos
    var errorContainer = inputField.next('.help-inline');
    if (errorContainer.length === 0) {
      errorContainer = $('<div class="error-message"></div>');
      inputField.after(errorContainer);
    }

    // Mostrar el mensaje de error
    errorContainer.text('Nombre de usuario ya en uso, seleccione otro.');
    inputField.addClass('has-error');
    Liferay.Util.openToast({
      message: 'Nombre de usuario ya en uso, seleccione otro.',
      type: 'danger'
    });
  }

  function hideRequiredMessage() {
    var inputField = $('#<portlet:namespace />username');
    inputField.removeClass("has-error");
    $('.error-message').fadeOut();

  }





  // Y los listeners
  document.getElementById('<portlet:namespace/>multiple-select-amateur').addEventListener('change', updateSelectionCount_amateur);
  document.getElementById('<portlet:namespace/>multiple-select-field1').addEventListener('change', updateSelectionCount_profesional);
  document.getElementById('<portlet:namespace/>multiple-select-field2').addEventListener('change', updateSelectionCount_agricultura);
  document.getElementById('<portlet:namespace/>multiple-select-field3').addEventListener('change', updateSelectionCount_ganaderia);

  Liferay.on('SPA_NAVIGATION', function (event) {
    loadMultiSelectorStyle();
  });

  document.addEventListener('DOMContentLoaded', function () {
    $('#<portlet:namespace/>province option').filter(function() {
      return $(this).text().trim() === '${province}';
    }).prop('selected', true).parent().change();
    loadMultiSelectorStyle();
  });

  Liferay.on('allPortletsReady', function () {
    loadMultiSelectorStyle();
  });

  function initializeRadioButtons() {
    //console.log("Entra a la función initializeRadioButtons");
    const radioAmateur001 = document.querySelector('.av-ma-radio-profesional input');
    const radioAmateur002 = document.querySelector('.av-ma-radio-amateur input');
    const divProfesional = document.querySelector('.av-ma-div-profesional');
    const divAmateur = document.querySelector('.av-ma-div-amateur');

    if (radioAmateur001 && radioAmateur002 && divProfesional && divAmateur) {
      // Hacer visible "div-amateur" si alguno de los radio buttons está selecionado.
      function handleRadioChange1() {
        divProfesional.classList.add('av-ma-visible');
        divAmateur.classList.remove('av-ma-visible');
      }

      function handleRadioChange2() {
        divAmateur.classList.add('av-ma-visible');
        divProfesional.classList.remove('av-ma-visible');
      }

      // Escuchar a los radio buttons de actividad.
      radioAmateur001.addEventListener('change', handleRadioChange1);
      radioAmateur002.addEventListener('change', handleRadioChange2);
    }
  }

  // Control para que la función no se lance más de una vez.
  var controlHandleFunction = false;
  function handleFunctionOnce() {
    if (!controlHandleFunction) {
      controlHandleFunction = true;
      initializeRadioButtons();
    }
  }

  // Lanzar una función cuando se produce navegación en el Spa sin cambio de URL.
  Liferay.on('SPA_NAVIGATION', function(event) {
    handleFunctionOnce();
  });

  // Lanzar una función cuando todos los portlets estén listos.
  Liferay.on('allPortletsReady', function () {
    handleFunctionOnce();
    inicializar_datos();

  });

  // Lanzar una función cuando hay cambios de ruta.
  Liferay.on('routeChanged', function () {
    handleFunctionOnce();
  });

  // Lanzar una función cuando ha cargado completamente el DOM.
  document.addEventListener('DOMContentLoaded', function() {
    handleFunctionOnce();
  });

  <%-- Función que comprueba que el nombre de usuario está libre para poder ser usado--%>
  function callServeResource(checkType) {
    $.ajax({
      type: "post",
      url: "<%=sendData%>&<portlet:namespace />check_type=" + checkType,
      dataType: "json",
      data: $('#<portlet:namespace />fma').serialize(),
      success: function(data) {
        //console.log('Respuesta del servidor:', data);
        let submitButton = $('#<portlet:namespace />submitButton');

        if (checkType === 'nombreUsuario') {
          if (data.outputMsg === 'nombre_usuario_OK') {
            hideRequiredMessage();
            submitButton.prop('disabled', false); // Habilita el botón de submit
          } else if (data.outputMsg === 'nombre_usuario_ERROR') {
            $('#<portlet:namespace />nombre_usuario_valido').val("");
            showRequiredMessage();
            submitButton.prop('disabled', true); // Deshabilita el botón de submit
          }
        }
      },
      error: function(xhr, status, error) {
        console.error("Error en la solicitud AJAX:", status, error);
        $('#<portlet:namespace />submitButton').prop('disabled', true); // Deshabilita el botón en caso de error
      }
    });
  }

  // Llama a la función callServeResource en el evento adecuado, por ejemplo, cuando cambie el campo de usuario
  $('#<portlet:namespace />username').on('change', function() {
    callServeResource('nombreUsuario');
  });



</script>
<style>
  .error-message{
    color: #dc3545;
    font-size: 80%;
    margin-top: 0.25rem;
    overflow-wrap: break-word;
    word-wrap: break-word;
  }
  .has-error{
    border-color: #dc3545!important;
  }
</style>
