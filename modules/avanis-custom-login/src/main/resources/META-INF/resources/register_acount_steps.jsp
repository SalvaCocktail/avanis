<%@ include file="./init.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!-- Librerías Select2 -->
<%--<link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.13/css/select2.min.css" rel="stylesheet" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.13/js/select2.min.js"></script>--%>


<portlet:actionURL var="savePreferencesURL" name="savePreferences" />
<c:set var = "tokenvalid" scope = "request" value = "${tokenvalid}"/>


<c:choose>
	<c:when test = "${tokenvalid}">

		<!-- Form -->
		<aui:form method="post" cssClass="av-form-my-account" action="${savePreferencesURL}" name="fma" enctype="multipart/form-data">
			<aui:input name="token" type="hidden" value="${token}"></aui:input>
			<div class="av-step-columns">
				<!-- Left menu region -->
				<div class="av-content-left">
					<div>
						<h2 class="av-txt-title">Es hora de hacer Avanis a tu medida</h2>
						<p>Contesta unas preguntas, elige tus intereses y personaliza tu experiencia. ¡Son solo dos
							pasos!</p>
						<div>
							<div class="av-percentage-bar">
								<p>60% perfil completado</p>
								<div>
									<div style="width: 60%;"></div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- Right content region -->
				<div class="av-content-form">
					<!-- Paso 1/2 -->
					<div id="step1" class="step">

						<div class="av-content-right"><%--
							<h3 class="av-step-title">Paso 1/2</h3>
							<p class="av-step-subtitle">Tu negocio o actividad</p>
							<p class="av-step-question">¿Cuál es tu rol en el sector agroalimentario? *</p>
							<div class="mb-3 av-radio-buttons">
								<div class="mr-4">
									<aui:input label="Profesional" type="radio" name="dedicationLevel" value="professional"
										checked='${dedication_level == "professional"}' />
								</div>
							<div>
									<aui:input label="Aficionado" type="radio" name="dedicationLevel" value="amateur"
										checked='${dedication_level == "amateur"}' />
								</div>
							</div>
							<div class="mb-5">
								<div class="mb-3">
									<p class="av-step-question">¿A qué te dedicas?</p>
									<aui:select label="" cssClass="av-form-select" id="multiple-select-field1"
										name="selectedDedications" data-placeholder="Seleccionar" multiple="true">
										<c:forEach var="dedication" items="${dedications}">
											<aui:option value="${dedication.name}"
												selected='${fn:contains(userCategories,dedication.categoryId)}'>
												${dedication.name}</aui:option>
										</c:forEach>
									</aui:select>
								</div>
								<div class="mb-3">
									<p class="av-step-question">¿Cuál es tu actividad en la agricultura?</p>
									<aui:select label="" cssClass="av-form-select" id="multiple-select-field2"
										name="selectedAgricultureCategories" data-placeholder="Seleccionar" multiple="true">
										<c:forEach var="agricultureCategory" items="${agricultureCategories}">
											<aui:option value="${agricultureCategory.name}"
												selected='${fn:contains(userCategories,agricultureCategory.categoryId)}'>
												${agricultureCategory.name}</aui:option>
										</c:forEach>
									</aui:select>
								</div>
								<div>
									<p class="av-step-question">¿Cuál es tu actividad en la ganadería?</p>
									<aui:select label="" cssClass="av-form-select" id="multiple-select-field3"
										name="selectedStockbreadingCategories" data-placeholder="Seleccionar" multiple="true">
										<c:forEach var="stockbreadingCategory" items="${stockbreadingCategories}">
											<aui:option value="${stockbreadingCategory.name}"
												selected='${fn:contains(userCategories,stockbreadingCategory.categoryId)}'>
												${stockbreadingCategory.name}
											</aui:option>
										</c:forEach>
									</aui:select>
								</div>
							</div>
							<div class="av-stepone-form-control-buttons">
								<aui:button type="button" value="Saltar" cssClass="av-stepone-btn-secondary mr-3" href="/comunidad" />
								<aui:button type="button" value="Continuar" cssClass="av-stepone-btn-primary" onClick="showStep2()" />
							</div>
						--%>




							<%-- Mi código --%>
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

                                    <div id="selectorAmateur"> </div>

									<div class="select-wrapper">
										<aui:select
												label=""
												cssClass="av-form-select av-select2__form-select"
												id="multiple-select-amateur"
												name="selectedDedications"
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
												<aui:option value="${dedication.name}" >
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
											<c:forEach var="agricultureCategory" items="${agricultureCategories}" >
												<aui:option value="${agricultureCategory.name}" >
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
											<c:forEach var="stockbreadingCategory" items="${stockbreadingCategories}" >
												<aui:option value="${stockbreadingCategory.name}" >
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
							<div class="av-stepone-form-control-buttons">
								<aui:button type="button" value="Saltar" cssClass="av-stepone-btn-secondary mr-3" href="/comunidad" />
								<aui:button type="button" value="Continuar" cssClass="av-stepone-btn-primary" onClick="showStep2()" />
							</div>
						</div>
							<%-- Final mi código--%>
					</div>

					<!-- Paso 2/2 -->

				</div>
					<div id="step2" class="step" style="display:none;">
						<div class="av-content-right">
							<h3 class="av-step-title">Paso 2/2</h3>
							<h4>¿Qué temas te interesan?</h4>
							<aui:input type="hidden" value="preferences" name="focusedTab" />
							<!-- Agricultura -->
							<div id="agricultureCategories" class="mb-3 div-agricultura av-ma-mb-3 div-agricultura">
								<p class="av-step-question">Agricultura (<span id="countAgriculture">0</span>/13)</p>
								<div class="av-preferences-select-container" data-select-id="selectContainer1">
									<c:forEach var="agricultureCategory" items="${agricultureCategories}">
										<c:choose>
											<c:when test="${userInterests.contains(agricultureCategory.name.toLowerCase())}">
												<div class="av-preferences-option selected" data-value="${agricultureCategory.name}"
													 onclick="toggleIcon(this)">
														${agricultureCategory.name}</div>
											</c:when>
											<c:otherwise>
												<div class="av-preferences-option" data-value="${agricultureCategory.name}"
													 onclick="toggleIcon(this)">
														${agricultureCategory.name}</div>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</div>
							</div>
							<input type="hidden" name="<portlet:namespace/>otherAgricultureCategory" id="hiddenSelectContainer1">

							<!-- Ganadería -->
							<div id="stockbreadingCategories" class="mb-3">
								<p class="av-step-question">Ganadería (<span id="countStockbreading">0</span>/10)</p>
								<div class="av-preferences-select-container" data-select-id="selectContainer2">
									<c:forEach var="stockbreadingCategory" items="${stockbreadingCategories}">
										<c:choose>
											<c:when test="${userInterests.contains(stockbreadingCategory.name.toLowerCase())}">
												<div class="av-preferences-option selected" data-value="${stockbreadingCategory.name}"
													 onclick="toggleIcon(this)">
														${stockbreadingCategory.name}</div>
											</c:when>
											<c:otherwise>
												<div class="av-preferences-option" data-value="${stockbreadingCategory.name}"
													 onclick="toggleIcon(this)">
														${stockbreadingCategory.name}</div>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</div>
							</div>
							<input type="hidden" name="<portlet:namespace/>otherStockbreadingCategory"
								   id="hiddenSelectContainer2">
							<!-- Otros -->
							<div id="otherCategories" class="mb-3">
								<p class="av-step-question">Otros (<span id="countOther">0</span>/9)</p>
								<div class="av-preferences-select-container" data-select-id="selectContainer3">
									<c:forEach var="otherCategory" items="${otherCategories}">
										<c:choose>
											<c:when test="${userInterests.contains(otherCategory.name.toLowerCase())}">
												<div class="av-preferences-option selected" data-value="${otherCategory.name}"
													 onclick="toggleIcon(this)">
														${otherCategory.name}</div>
											</c:when>
											<c:otherwise>
												<div class="av-preferences-option" data-value="${otherCategory.name}"
													 onclick="toggleIcon(this)">
														${otherCategory.name}</div>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</div>
							</div>
							<input type="hidden" name="<portlet:namespace/>otherCategory" id="hiddenSelectContainer3">

							<div class="av-stepone-form-control-buttons">
								<aui:button type="button" value="Saltar" cssClass="av-stepone-btn-secondary mr-3" />
								<aui:button type="submit" value="Guardar" cssClass="av-stepone-btn-primary" />

							</div>
						</div>
					</div>
			</div>
			<input type="hidden" name="customInterests" id="customInterests" value="" />
		</aui:form>

	</c:when>
	<c:otherwise>
		<div class="av-content-form">
			<div class="av-content-right">
				<h2>Solicitud caducada</h2>
			</div>
		</div>
	</c:otherwise>
</c:choose>




<!-- Modal -->
<div class="modal fade" id="customInterestsModal" tabindex="-1" role="dialog"
	aria-labelledby="customInterestsModalLabel" aria-hidden="true">
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
						<input type="text" class="form-control" maxlength="30" />
						<small>*30 caracteres máximo</small>
					</div>
				</div>
				<button type="button" class="btn btn-link" id="addInterestButton">+ Añadir interés</button>
				<p>*Puedes añadir hasta 3 intereses extra</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
				<button type="button" class="btn btn-primary" onClick="saveCustomInterests()">Guardar y
					Continuar</button>
			</div>
		</div>
	</div>
</div>

<script>
	$(document).ready(function () {
		$('#<portlet:namespace/>dedicationLevel_3').click();
		// Inicializa Select2 para el Paso 1
		$('.av-form-select').select2({
			width: '100%'
		});

		$('.selected').on('change', function () {
			updateCounters();
		});

		$('#addInterestButton').on('click', function () {
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

	// Función para actualizar contadores
	function updateCountersStep2() {
		// Agricultura
		const agricultureCount = $('#agricultureCategories .av-preferences-option.selected').length;
		$('#countAgriculture').text(agricultureCount);
		// Ganadería
		const stockbreadingCount = $('#stockbreadingCategories .av-preferences-option.selected').length;
		$('#countStockbreading').text(stockbreadingCount);
		// Otros
		const otherCount = $('#otherCategories .av-preferences-option.selected').length;
		$('#countOther').text(otherCount);
	}

	function showStep2() {
		document.getElementById('step1').style.display = 'none';
		document.getElementById('step2').style.display = 'block';
	}

	function showCustomInterestsModal() {
		$('#customInterestsModal').modal('show');
	}

	function saveCustomInterests() {
		let interests = [];
		$('#customInterestsFields input').each(function () {
			if ($(this).val().trim().length > 0) {
				interests.push($(this).val().trim());
			}
		});
		$('#customInterests').val(interests.join(','));
		$('#customInterestsModal').modal('hide');
	}
</script>

<!-- Script para simular con divs el comportamiento del select -->
<script>
	$(document).ready(function () {
		// Actualizo los campos ocultos al inicio, así no se pierden aunque no interactuemos con ellos :)
		function updateHiddenFields() {
			$('.av-preferences-select-container').each(function () {
				var container = $(this);
				var selectId = container.data('select-id');
				var hiddenFieldId = 'hidden' + selectId.charAt(0).toUpperCase() + selectId.slice(1);
				var selectedValues = container.find('.av-preferences-option.selected').map(function () {
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

		$('.av-preferences-select-container').on('click', '.av-preferences-option', function () {
			$(this).toggleClass('selected'); // Alterna la clase 'selected'
			// Obtener el ID del contenedor
			var container = $(this).closest('.av-preferences-select-container');
			var selectId = container.data('select-id');

			if (!selectId) {
				console.error('No se pudo obtener el ID del contenedor.');
				return;
			}

			// Crear el ID del campo oculto
			var hiddenFieldId = 'hidden' + selectId.charAt(0).toUpperCase() + selectId.slice(1);
			var hiddenFieldName = '<portlet:namespace/>' + container.data('select-id').replace('selectContainer', 'selected') + 'Categories';

			// Obtener los valores seleccionados
			var selectedValues = container.find('.av-preferences-option.selected').map(function () {
				return $(this).attr('data-value');
			}).get();

			// Actualizar el campo oculto con los valores seleccionados
			var hiddenField = $('#' + hiddenFieldId);
			if (hiddenField.length) {
				hiddenField.val(selectedValues.join(','));
			} else {
				console.error('Elemento oculto con ID ' + hiddenFieldId + ' no encontrado');
			}

			updateCountersStep2();
			console.log('Selected values for ' + selectId + ':', selectedValues);
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

	// Cargar los estilos del selector múltiple
	function loadMultiSelectorStyle() {

		var multiSelector1 = document.querySelector('#<portlet:namespace/>multiple-select-field1');
		var multiSelector2 = document.querySelector('#<portlet:namespace/>multiple-select-field2');
		var multiSelector3 = document.querySelector('#<portlet:namespace/>multiple-select-field3');

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




	// Obtén los radio buttons por su ID
	 level1 = document.getElementById('<portlet:namespace/>dedicationLevel_1');
	 level3 = document.getElementById('<portlet:namespace/>dedicationLevel_3');

	// Función que se ejecuta cuando se hace clic en un radio button
	function handleRadioClick(event) {
		// Obtén el ID del radio button clickeado
		const id = event.target.id;

		// Imprime el ID del radio button clickeado
		console.log("ID seleccionado: " + id);



		<%-- profesional o amateur TODO deseleccionar todos los campos que se han ocultado, o los hago antes de guardar ya veré--%>
		if (id === '<portlet:namespace/>dedicationLevel_1') {
			// Seleccionado Profesional

			//limpio amateur
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
			$('.div-profesional').fadeIn();
			$('.div-amateur').fadeOut();
			$('.div-agricultura').fadeOut();
			$('.div-ganaderia').fadeOut();

			//Seleccionado aficionado
		} else if (id === '<portlet:namespace/>dedicationLevel_3') {
			// Seleccionado Aficionado

			$('#<portlet:namespace/>multiple-select-amateur option').prop('selected', false);
			$('#<portlet:namespace/>multiple-select-amateur').val(null).trigger('change');
			$('#<portlet:namespace/>multiple-select-field1 option').prop('selected', false);
			$('#<portlet:namespace/>multiple-select-field1').val(null).trigger('change');
			inicializar_datos();
			updateSelectionCount_amateur();
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
	$(document).ready(function() {

		// Captar eventos de selección y deselección para ver si selecciona Agricultura o Ganadería para mostrar estos datos y updateo el contador
		$('#<portlet:namespace/>multiple-select-amateur').on('select2:select', function(e) {
			var data = e.params.data;
			console.log("VALOR "+data.text);
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
	}



	//Se lo aplico a los selec múltiples de rol, Agricultura, ganadería y dedications
	//multiSelectWithoutCtrl('#selectedDedications');



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

	//Inicializo los datos
	function inicializar_datos() {
		if(${dedication_level == "amateur"}){
			console.log("es amateur");
			//si aficionado compruebo los campos de agricultura y ganadería si tienen datos
			/*if ($('#multiple-select-field2 option').length > 0) {
                $('#<portlet:namespace/>multiple-select-amateur').val(function(i, val) {
                      return $.isArray(val) ? val : [val];
                  }).val('Agricultura').trigger('change');
              }*/
			//Si hay campos seleccionados en agricultura actualizo campo amateur
			if($('#<portlet:namespace/>multiple-select-field2').find('option:selected').length >0){
				$('#<portlet:namespace/>multiple-select-amateur').val(['Agricultura']).trigger('change');
			}

			if($('#<portlet:namespace/>multiple-select-field3').find('option:selected').length >0){
				$('#<portlet:namespace/>multiple-select-amateur').val(['Ganadería']).trigger('change');
			}
			if($('#<portlet:namespace/>multiple-select-field2').find('option:selected').length >0 && $('#<portlet:namespace/>multiple-select-field3').find('option:selected').length >0){
				{
					$('#_avanis_my_account_portlet_AvanisMyAccountPortlet_INSTANCE_ktts_multiple-select-amateur').val(['Ganadería','Agricultura']).trigger('change');
				}
			}

			if($('#<portlet:namespace/>multiple-select-field2').find('option:selected').length ==0 && $('#<portlet:namespace/>multiple-select-field3').find('option:selected').length == 0){
				{
					$('#_avanis_my_account_portlet_AvanisMyAccountPortlet_INSTANCE_ktts_multiple-select-amateur').val('').trigger('change');
				}
			}

			/*if ($('#multiple-select-field3 option').length > 0) {
                $('#<portlet:namespace/>multiple-select-amateur').val(function(i, val) {
                      return $.isArray(val) ? val : [val];
                  }).val('Ganadería').trigger('change');
              }*/

			$('.div-amateur').fadeIn();
			//recorro el multiple de amateur y si esta selecionada agricultura o ganaderia se muestran
			var selectedValues = $('#<portlet:namespace/>multiple-select-amateur')
					.val() || [];  // Obtiene los valores seleccionados

			if (selectedValues.includes('Agricultura')) {
				$('.div-agricultura').fadeIn();
				console.log('Agricultura está seleccionado.');
			}

			if (selectedValues.includes('Ganadería')) {
				$('.div-ganaderia').fadeIn();
				console.log('Ganadería está seleccionado.');
			}
		}

		if(${dedication_level == "professional"}){
			$('.div-profesional').fadeIn();
			$('.div-amateur').fadeOut();
			console.log("es profesional");
			//recorro el multiple de amateur y si esta selecionada agricultura o ganaderia se muestran
			$('#<portlet:namespace/>multiple-select-field1 option:selected').each(function() {
				// Imprime el valor y el texto de cada opción seleccionada
				console.log("VALOR " + jQuery(this).text());
				let selectedValue = jQuery(this).text().trim().toLowerCase();
				if (selectedValue === 'agricultura') {
					$('.div-agricultura').fadeIn();
					console.log('Agricultura está seleccionado.');
				}

				if (selectedValue ==='ganadería') {
					$('.div-ganaderia').fadeIn();
					console.log('Ganadería está seleccionado.');
				}
			});
		}
	}

	// Inicializar el conteo al cargar la página
	inicializar_datos();
	updateSelectionCount_amateur();
	updateSelectionCount_profesional();
	updateSelectionCount_agricultura();
	updateSelectionCount_ganaderia();

	// Y los listeners
	document.getElementById('<portlet:namespace/>multiple-select-amateur').addEventListener('change', updateSelectionCount_amateur);
	document.getElementById('<portlet:namespace/>multiple-select-field1').addEventListener('change', updateSelectionCount_profesional);
	document.getElementById('<portlet:namespace/>multiple-select-field2').addEventListener('change', updateSelectionCount_agricultura);
	document.getElementById('<portlet:namespace/>multiple-select-field3').addEventListener('change', updateSelectionCount_ganaderia);

	Liferay.on('SPA_NAVIGATION', function (event) {
		loadMultiSelectorStyle();
	});

	document.addEventListener('DOMContentLoaded', function () {
		loadMultiSelectorStyle();
	});

	Liferay.on('allPortletsReady', function () {
		loadMultiSelectorStyle();
	});

	function initializeRadioButtons() {
		console.log("Entra a la función initializeRadioButtons");

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
	});

	// Lanzar una función cuando hay cambios de ruta.
	Liferay.on('routeChanged', function () {
		handleFunctionOnce();
	});

	// Lanzar una función cuando ha cargado completamente el DOM.
	document.addEventListener('DOMContentLoaded', function() {
		handleFunctionOnce();
	});
</script>
