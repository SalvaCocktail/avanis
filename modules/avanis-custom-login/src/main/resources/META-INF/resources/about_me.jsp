<%@ include file="./init.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!-- Librerías Select2 -->
<%--<link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.13/css/select2.min.css" rel="stylesheet" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.13/js/select2.min.js"></script>--%>


<portlet:actionURL var="savePreferencesURL" name="savePreferences"/>

<!-- Form -->
<aui:form method="post" cssClass="av-form-my-account" action="${savePreferencesURL}" name="fma" enctype="multipart/form-data">
    <div class="av-signup-columns">
        <!-- Left menu region -->
        <div class="av-content-left">
            <div>
                <h2 class="av-txt-title">Es hora de hacer Avanis a tu medida</h2>
                <p>Contesta unas preguntas, elige tus intereses y personaliza tu experiencia. ¡Son solo 2 pasos!</p>
                <%--
                <div>
                    <span>60% Perfil completado</span>
                </div>
                --%>
            </div>
        </div>
        <!-- Right content region -->
        <div class="av-content-form">
            <div id="step1" class="step">
                <!-- Paso 1 -->
                <div class="av-content-right">
                    <h1>Paso 1/2</h1>
                    <h2>Tu negocio o actividad</h2>
                    <p>¿Cuál es tu rol en el sector agroalimentario?</p>
                    <div class="mb-3 av-radio-buttons">
                        <div class="mr-4">
                            <aui:input label="Profesional" type="radio" name="dedicationLevel" value="professional"
                                       checked='${dedication_level == "professional"}'/>
                        </div>
                        <div>
                            <aui:input label="Aficionado" type="radio" name="dedicationLevel" value="amateur"
                                       checked='${dedication_level == "amateur"}'/>
                        </div>
                    </div>
                    <div class="mb-5">
                        <div class="mb-3">
                            <p>¿A qué te dedicas?</p>
                            <aui:select label="" cssClass="av-form-select" id="multiple-select-field1"
                                        name="selectedDedications" data-placeholder="Choose anything" multiple="true">
                                <c:forEach var="dedication" items="${dedications}">
                                    <aui:option value="${dedication.name}"
                                                selected='${fn:contains(userCategories,dedication.categoryId)}'>${dedication.name}</aui:option>
                                </c:forEach>
                            </aui:select>
                        </div>
                        <div class="mb-3">
                            <p>¿Cuál es tu actividad en la agricultura?</p>
                            <aui:select label="" cssClass="av-form-select" id="multiple-select-field2"
                                        name="selectedAgricultureCategories" data-placeholder="Choose anything" multiple="true">
                                <c:forEach var="agricultureCategory" items="${agricultureCategories}">
                                    <aui:option value="${agricultureCategory.name}"
                                                selected='${fn:contains(userCategories,agricultureCategory.categoryId)}'>${agricultureCategory.name}</aui:option>
                                </c:forEach>
                            </aui:select>
                        </div>
                        <div>
                            <p>¿Cuál es tu actividad en la ganadería?</p>
                            <aui:select label="" cssClass="av-form-select" id="multiple-select-field3"
                                        name="selectedStockbreadingCategories" data-placeholder="Choose anything" multiple="true">
                                <c:forEach var="stockbreadingCategory" items="${stockbreadingCategories}">
                                    <aui:option value="${stockbreadingCategory.name}"
                                                selected='${fn:contains(userCategories,stockbreadingCategory.categoryId)}'>${stockbreadingCategory.name}
                                    </aui:option>
                                </c:forEach>
                            </aui:select>
                        </div>
                    </div>
                    <div class="av-about-form-control-buttons">
                        <aui:button type="button" value="Saltar" cssClass="av-btn-secondary mr-3" href="/comunidad"/>
                        <aui:button type="button" value="Continuar" cssClass="av-btn-primary" onClick="showStep2()"/>
                    </div>
                </div>
            </div>
            <div id="step2" class="step" style="display:none;">
                <!-- Paso 2 -->
                <div class="av-content-right">
                    <h1>Paso 2/2</h1>
                    <h2>¿Qué temas te interesan?</h2>
                    <div class="mb-5">
                        <!-- Agricultura -->
                        <div class="mb-3">
                            <p>Agricultura (<span id="countAgriculture">0</span>/13)</p>
                            <div id="agricultureCategories">
                                <c:forEach var="otherAgricultureCategory" items="${agricultureCategories}">
                                    <div class="checkbox-group">
                                        <input type="checkbox" class="category-checkbox" name="<portlet:namespace/>otherAgricultureCategory" value="${otherAgricultureCategory.name}" id="${otherAgricultureCategory.categoryId}" />
                                        <label for="${otherAgricultureCategory.categoryId}">${otherAgricultureCategory.name}</label>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>

                        <!-- Ganadería -->
                        <div class="mb-3">
                            <p>Ganadería (<span id="countStockbreading">0</span>/10)</p>
                            <div id="stockbreadingCategories">
                                <c:forEach var="otherStockbreadingCategory" items="${stockbreadingCategories}">
                                    <div class="checkbox-group">
                                        <input type="checkbox" class="category-checkbox" name="<portlet:namespace/>otherStockbreadingCategory" value="${otherStockbreadingCategory.name}" id="${otherStockbreadingCategory.categoryId}" />
                                        <label for="${otherStockbreadingCategory.categoryId}">${otherStockbreadingCategory.name}</label>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>

                        <!-- Otros -->
                        <div>
                            <p>Otros (<span id="countOther">0</span>/9)</p>
                            <div id="otherCategories">
                                <c:forEach var="otherCategory" items="${otherCategories}">
                                    <div class="checkbox-group">
                                        <input type="checkbox" class="category-checkbox" name="<portlet:namespace/>otherCategory" value="${otherCategory.name}" id="${otherCategory.name}" />
                                        <label for="${otherCategory.categoryId}">${otherCategory.name}</label>
                                    </div>
                                </c:forEach>
                                <div class="checkbox-group">
                                    <input type="checkbox" id="other_custom" value="custom" onClick="showCustomInterestsModal()" />
                                    <label for="other_custom">Otros</label>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="av-about-form-control-buttons">
                        <aui:button type="button" value="Saltar" cssClass="av-btn-secondary mr-3"/>
                        <aui:button type="submit" value="Guardar y Continuar" cssClass="av-btn-primary"/>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <input type="hidden" name="customInterests" id="customInterests" value=""/>
</aui:form>

<!-- Modal -->
<div class="modal fade" id="customInterestsModal" tabindex="-1" role="dialog" aria-labelledby="customInterestsModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="customInterestsModalLabel">Añadir más intereses</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <h6>Escribe en el siguiente campo qué otras temáticas te interesan</h6>
                <div id="customInterestsFields">
                    <div class="form-group">
                        <input type="text" class="form-control" maxlength="30"/>
                        <small>*30 caracteres máximo</small>
                    </div>
                </div>
                <button type="button" class="btn btn-link" id="addInterestButton">+ Añadir interés</button>
                <p>*Puedes añadir hasta 3 intereses extra</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                <button type="button" class="btn btn-primary" onClick="saveCustomInterests()">Guardar y Continuar</button>
            </div>
        </div>
    </div>
</div>

<script>
    $(document).ready(function() {
        // Inicializa Select2 para el Paso 1
        $('.av-form-select').select2({
            width: '100%'
        });

        // Función para actualizar contadores
        function updateCounters() {
            // Agricultura
            const agricultureCount = $('#agricultureCategories .category-checkbox:checked').length;
            $('#countAgriculture').text(agricultureCount);

            // Ganadería
            const stockbreadingCount = $('#stockbreadingCategories .category-checkbox:checked').length;
            $('#countStockbreading').text(stockbreadingCount);

            // Otros
            const otherCount = $('#otherCategories .category-checkbox:checked').length;
            $('#countOther').text(otherCount);
        }

        $('.category-checkbox').on('change', function() {
            updateCounters();
        });

        $('#addInterestButton').on('click', function() {
            const fieldCount = $('#customInterestsFields .form-group').length;
            if (fieldCount < 3) {
                const newField = `
                    <div class="form-group">
                        <input type="text" class="form-control" maxlength="30"/>
                        <small>*30 caracteres máximo</small>
                    </div>`;
                $('#customInterestsFields').append(newField);
            }
        });
    });

    function showStep2() {
        document.getElementById('step1').style.display = 'none';
        document.getElementById('step2').style.display = 'block';
    }

    function showCustomInterestsModal() {
        $('#customInterestsModal').modal('show');
    }

    function saveCustomInterests() {
        let interests = [];
        $('#customInterestsFields input').each(function() {
            if ($(this).val().trim().length > 0) {
                interests.push($(this).val().trim());
            }
        });
        $('#customInterests').val(interests.join(','));
        $('#customInterestsModal').modal('hide');
    }
</script>

<%--TODO CSS--%><style>
    .checkbox-group {
        margin-bottom: 10px;
    }
    .checkbox-group input[type="checkbox"] {
        margin-right: 10px;
    }
</style>
