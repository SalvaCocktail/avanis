<%@ include file="./init.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/Notificaciones/titatoggle-dist.css">

<portlet:actionURL var="savePreferencesURL" name="savePreferences"/>

<div class="av-main__header">
    <img class="go-to-menu" onClick="displayMenu()" class="mr-2"
         src="<%=request.getContextPath()%>/images/arrow-left.png" alt="arrow left"/>
    <h2 class=".titulo-mis-preferencias-principal">Mis Preferencias</h2>
</div>
<h4 class="titulo-mis-preferencias">¿Qué temas te interesan?</h4>
<aui:form method="post" cssClass="av-form-my-account" action="${savePreferencesURL}" name="fma"
          enctype="multipart/form-data" id="myForm">
    <aui:input type="hidden" value="preferences" name="focusedTab"/>
    <div class="mb-3">
        <p class="mis-preferencias-contadores c-agricultura">Agricultura</p>
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


    <div class="mb-3">
        <p class="mis-preferencias-contadores c-ganaderia">Otros</p>
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


    <div class="mb-3">
        <p class="mis-preferencias-contadores c-otros">Otros</p>
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

    <div class="mb-3">
    <h4>Comunicaciones Avanis</h4>
    <p>¿Quieres recibir nuestra newsletter con novedades de tu interés?</p>


    <div class="form-check form-switch">
        <div class="preferencias-comunicaciones">
        <c:set var="allowNewsLetterValue"
               value="${lastUserInputAllowNewsLetter != null ?  lastUserInputAllowNewsLetter: allowNewsLetter}"/>
            <c:choose>
                <c:when test="${allowNewsLetterValue}">
                    <div class="form-check checkbox-slider--b-flat">
                        <label>
                        <input class="form-check-input" type="checkbox" id="flexSwitchCheckDefault"
                           name="<portlet:namespace/>allowNewsLetter" checked>
                            <span></span>
                        </label>

                </c:when>
                <c:otherwise>
                <div class="form-check checkbox-slider--b-flat">
                    <label>
                    <input class="form-check-input" type="checkbox" id="flexSwitchCheckDefault"
                           name="<portlet:namespace/>allowNewsLetter">
                        <span></span>
                    </label>
                </c:otherwise>
            </c:choose>
            <p>Permitir comunicaciones de Avanis</p>
        </div>
    </div>


    <div class="av-control-buttons">
        <button type="button" class="btn-cancelar-preferencias av-btn-secondary mr-3 ">Cancelar</button>
        <button type="submit" value="Guardar" class="btn-guardar-preferencias">Guardar</button>
    </div>
</aui:form>


<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>


<!-- Script para simular con divs el comportamiento de un select bonito-->
<script>
    $(document).ready(function () {
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

            // Obtener los valores seleccionados
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

            console.log('Selected values for ' + selectId + ':', selectedValues);


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
            //Si seleccionado 1 -> actualizo texto Agricultura
            //Si seleccionado 2 -> actualizo texto Agricultura
            //Si seleccionado 3 -> actualizo texto Agricultura
        });

        $('#_avanis_my_account_portlet_AvanisMyAccountPortlet_INSTANCE_ktts_fma').on('submit', function (event) {
            event.preventDefault(); // Prevenir el envío del formulario para depuración
            var formData = $(this).serializeArray();
            console.log('Datos del formulario:', formData);

            // Después de depurar, puedes enviar el formulario manualmente
            setTimeout(() => {
                this.submit();
            }, 15000); // Ajusta el retraso si es necesario
        });
    });


</script>
<script>
    // Cargar los estilos del selector múltiple.
    console.log("Comienzo selects");

    function loadMultiSelectorStyle() {

        var multiSelector1 = document.querySelector('#<portlet:namespace/>multiple-select-field1');
        var multiSelector2 = document.querySelector('#<portlet:namespace/>multiple-select-field2');
        var multiSelector3 = document.querySelector('#<portlet:namespace/>multiple-select-field3');

        if(!multiSelector1 || !multiSelector2 || !multiSelector3) {
            console.error('No se encontraron los selectores múltiples.');
            return;
        }

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


    }

    //Inicializo los contadoresasd
    $(document).ready(function() {

        var $container1 = $('.preferences-select-container[data-select-id="selectContainer1"]');
        var totalOptions1 = $container1.find('.option').length;
        var selectedOptions1 = $container1.find('.option.selected').length;
        var text1 = "Agricultura ("+selectedOptions1 + '/' + totalOptions1+")";
        $('.c-agricultura').text(text1);

        var $container2 = $('.preferences-select-container[data-select-id="selectContainer2"]');
        var totalOptions2 = $container2.find('.option').length;
        var selectedOptions2 = $container2.find('.option.selected').length;
        var text2 = "Ganadería ("+selectedOptions2 + '/' + totalOptions2+")";
        $('.c-ganaderia').text(text2);

        var $container3 = $('.preferences-select-container[data-select-id="selectContainer3"]');
        var totalOptions3 = $container3.find('.option').length;
        var selectedOptions3 = $container3.find('.option.selected').length;
        var text3 = "Otros ("+selectedOptions3 + '/' + totalOptions3+")";
        $('.c-otros').text(text3);
    });
    // Ocultar/mostrar el icono de cerrar en las casillas
    function toggleIcon(element) {
        element.classList.toggle('show-icon');
    }

    Liferay.on('SPA_NAVIGATION', function (event) {
        loadMultiSelectorStyle();
    });

    document.addEventListener('DOMContentLoaded', function () {
        loadMultiSelectorStyle();
    });

    Liferay.on('allPortletsReady', function () {
        loadMultiSelectorStyle();
    });
</script>