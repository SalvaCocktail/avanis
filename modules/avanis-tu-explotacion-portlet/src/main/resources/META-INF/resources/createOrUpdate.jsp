<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://liferay.com/tld/map" prefix="liferay-map" %>

<%@ include file="./init.jsp" %>

<jsp:directive.page contentType="text/html" pageEncoding="UTF-8" />

<portlet:actionURL var="createOrUpdateURL" name="createOrUpdate" />
<portlet:resourceURL var="getLocationURL" id="resource_cmd_command" />

<liferay-ui:success key="success" message="message.success" />
<liferay-ui:error key="error" message="message.error" />

${error}

<div id="loadingSpinner" class="loading-spinner" style="display: none;">
	<div class="spinner"></div>
	<p>Guardando</p>
</div>
<!-- region form -->
<aui:form name="fm" action="${createOrUpdateURL}" method="post" cssClass="form-horizontal" onSubmit='<%= "$('#loadingSpinner').show(); " %>'>
	<aui:input type="hidden" name="explotacionId" value="${explotacion.explotacionId}" />
	<aui:input type="hidden" name="meteoredid" value="${explotacion.meteoredid}" />
	<aui:input type="hidden" name="latitude" value="${explotacion.latitude}" />
	<aui:input type="hidden" name="longitude" value="${explotacion.longitude}" />

	<div class="av-te">
		<div class="av-te-create-or-update av-te-cu">
			<div class="av-te-cu__container">
				<div class="av-te-cu__form">

					<!-- Datos de tu parcela -->
					<div class="av-te-cu__form-row av-te-cu__form-row--001">
						<h3 class="av-te-cu__title-h3 h3">Datos de tu parcela</h3>
						<aui:input type="text" name="name" value="${explotacion.name}" cssClass="av-te-cu__form-input" label="Nombre de la parcela" placeholder="Nombre de tu explotación">
							<aui:validator name="required" errorMessage="Por favor, pon un nombre a tu parcela" />
						</aui:input>
					</div>

					<!-- Uso -->
					<div class="av-te-cu__form-row av-te-cu__form-row--002">
						<label class="av-te-cu__form-label">Uso</label>
						<div class="select-wrapper">
							<select id="multiple-select-optgroup-field" name="<portlet:namespace />categoryIds" multiple class="av-te__form-select">
								<optgroup class="av-te-cu__form-optgroup" label="Agricultura">
									<c:forEach var="subcategory" items="${agricultureCategories}">
										<option value="${subcategory.categoryId}" <c:if test="${fn:contains(selectedCategories, subcategory.categoryId)}">selected</c:if>>
												${subcategory.name}
										</option>
									</c:forEach>
								</optgroup>
								<optgroup class="av-te-cu__form-optgroup" label="Ganadería">
									<c:forEach var="subcategory" items="${stockbreadingCategories}">
										<option value="${subcategory.categoryId}" <c:if test="${fn:contains(selectedCategories, subcategory.categoryId)}">selected</c:if>>
												${subcategory.name}
										</option>
									</c:forEach>
								</optgroup>
							</select>
							<span id="select-count" class="select-count">0</span>
							<span class="select-arrow">
              					<svg width="14" height="8" viewBox="0 0 14 8" fill="none" xmlns="http://www.w3.org/2000/svg">
                                    <path fill-rule="evenodd" clip-rule="evenodd" d="M7 8C7.26522 8 7.51957 7.89464 7.70711 7.70711L13.7071 1.70711C14.0976 1.31658 14.0976 0.683417 13.7071 0.292893C13.3166 -0.0976315 12.6834 -0.0976315 12.2929 0.292893L7 5.58579L1.70711 0.292893C1.31658 -0.0976315 0.683418 -0.0976315 0.292893 0.292893C-0.0976311 0.683417 -0.0976311 1.31658 0.292893 1.70711L6.29289 7.70711C6.48043 7.89464 6.73478 8 7 8Z" fill="#101717" />
                                </svg>
       				 		</span>
						</div>
						<div>
							<span id="agriculture-count">Agricultura: 0</span>
							<span id="livestock-count">Ganadería: 0</span>
						</div>
					</div>

					<!-- Tamaño -->
					<div class="av-te-cu__form-row av-te-cu__form-row--004">
						<aui:select name="size" label="Tamaño aproximado">
							<aui:option value="0" selected="${explotacion.size == 0}">No lo sé</aui:option>
							<aui:option value="1" selected="${explotacion.size == 1}">Menos de 1 hectárea (10.000 m2)</aui:option>
							<aui:option value="2" selected="${explotacion.size == 2}">Más de 1 hectárea (10.000 m2)</aui:option>
						</aui:select>
						<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
						<aui:input
								type="text"
								name="sizeUnit"
								value="${explotacion.sizeUnit}"
								cssClass="av-te-cu__form-input"
								label="Tamaño en hectáreas"
								pattern="[0-9]+([,\.][0-9]+)?"
								title="Por favor, introduzca un número válido"
								inputmode="decimal"
						/>
					</div>

					<!-- Localización -->
					<div class="av-te-cu__form-row av-te-cu__form-row--005">
						<h3 class="h3">Localización</h3>
						<p class="av-te_location-subtitle">
							Escribe la ubicación y haz clic en el punto en el que se encuentra tu parcela<span class="required-asterisk">*</span>
						</p>

						<div id="map" style="height: 400px;"></div>

						<!-- Campo oculto para latitud -->
						<aui:input name="latitude" id="<portlet:namespace />latitude" type="hidden" value="${explotacion.latitude}">
							<aui:validator name="required" errorMessage="Localización obligatoria." />
						</aui:input>
						<!-- Campo oculto para longitud -->
						<aui:input name="longitude" id="<portlet:namespace />longitude" type="hidden" value="${explotacion.longitude}">
							<aui:validator name="required" errorMessage="none" />
						</aui:input>

						<div id="location-display" class="location-display">
							<span id="location-name"></span>
						</div>

						<!-- Mensaje de error -->
						<c:if test="${not empty errorMessage}">
							<p class="error-message">${errorMessage}</p>
						</c:if>
					</div>

					<!-- Notificaciones -->
					<div class="av-te-cu__form-row av-te-cu__form-row--006">
						<label class="av-te_notifications-label">
							<aui:input type="checkbox" name="allowNotifications" value="${explotacion.allowNotifications}" cssClass="av-te-cu__form-checkbox" label="Quiero recibir notificaciones con el pronóstico del tiempo y las alertas meteorológicas que afecten a esta parcela." />
						</label>
					</div>
					<c:choose>
						<c:when test="${explotacion.explotacionId == 0}">
							<c:set var="buttonLabel" value="Crear" />
						</c:when>
						<c:otherwise>
							<c:set var="buttonLabel" value="Guardar" />
						</c:otherwise>
					</c:choose>
					<div class="av-te-cu__form-row av-te-cu__form-row--007">
						<aui:button type="button" value="Cancelar" cssClass="av-te__btn av-te__btn--secondary" onClick="handleCancelClick()" />
						<aui:button type="submit" value="${buttonLabel}" cssClass="av-te__btn av-te__btn--primary"  />
					</div>
				</div>
			</div>
		</div>
	</div>
</aui:form>

<!-- endregion form -->

<!-- Include jQuery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- Include Select2 CSS -->
<link href="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/css/select2.min.css" rel="stylesheet" />
<!-- Include Select2 JS -->
<script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/js/select2.min.js"></script>

<!-- Include Leaflet CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/leaflet/dist/leaflet.css" />
<!-- Include Leaflet JS -->
<script src="https://cdn.jsdelivr.net/npm/leaflet/dist/leaflet.js"></script>

<!-- Include Leaflet Geosearch CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/leaflet-geosearch/dist/geosearch.css" />
<!-- Include Leaflet Geosearch JS -->
<script src="https://cdn.jsdelivr.net/npm/leaflet-geosearch/dist/bundle.min.js"></script>

<script type="text/javascript">

	// Variable de control para evitar ejecuciones concurrentes.
	var isExecutingCreateOrUpdate = false;

	// Llamada a la función de envoltorio.
	function handleFunctionCreateOrUpdate() {
		if (isExecutingCreateOrUpdate) {
			console.log('La función de envoltorio ya está en ejecución, se evita una nueva ejecución.');
			return;
		}

		// Bloquear nuevas ejecuciones mientras la función de envoltorio esta está en curso.
		isExecutingCreateOrUpdate = true;

		function loadMultiSelectorStyle() {
			var multiSelector = document.querySelector('#multiple-select-optgroup-field');
			var countElement = document.getElementById('select-count');
			var agricultureCountElement = document.getElementById('agriculture-count');
			var livestockCountElement = document.getElementById('livestock-count');

			if (!multiSelector || !countElement || !agricultureCountElement || !livestockCountElement) {
				console.error('One or more count elements not found');
				return;
			}

			// Inicializa Select2
			$(multiSelector).select2({
				width: multiSelector.dataset.width ? multiSelector.dataset.width : multiSelector.classList.contains('w-100') ? '100%' : 'style',
				placeholder: multiSelector.dataset.placeholder,
				closeOnSelect: false
			}).on('change', updateCount);

			updateCount(); // Llama a la función al cargar
		}

		function updateCount() {
			var selectElement = document.querySelector('#multiple-select-optgroup-field');
			var countElement = document.getElementById('select-count');
			var agricultureCountElement = document.getElementById('agriculture-count');
			var livestockCountElement = document.getElementById('livestock-count');

			if (!selectElement || !countElement || !agricultureCountElement || !livestockCountElement) {
				console.error('One or more count elements not found');
				return;
			}

			var selectedOptions = $(selectElement).val() || [];
			var totalCount = selectedOptions.length;

			// Calculate counts for each optgroup
			var agricultureCount = selectedOptions.filter(function(value) {
				return $(selectElement).find('option[value="' + value + '"]').parent().attr('label') === 'Agricultura';
			}).length;

			var livestockCount = selectedOptions.filter(function(value) {
				return $(selectElement).find('option[value="' + value + '"]').parent().attr('label') === 'Ganadería';
			}).length;

			countElement.textContent = totalCount;
			agricultureCountElement.textContent = 'Agricultura: ' + agricultureCount;
			livestockCountElement.textContent = 'Ganadería: ' + livestockCount;
		}

		function handleCancelClick() {
			const refererURLElement = '${themeDisplay.getURLCurrent()}';
			if (refererURLElement) {
				if (refererURLElement.includes('mi-perfil-privado')) {
					window.location.href = '/mi-perfil-privado';
				} else if (refererURLElement.includes('explotacion')) {
					window.location.href = '/explotacion';
				}
			}
		}

		function initializeMap() {
			// Obtener los valores de latitud y longitud desde los campos ocultos
			var latitude = parseFloat(document.getElementById('<portlet:namespace />latitude').value) || 40.416775;
			var longitude = parseFloat(document.getElementById('<portlet:namespace />longitude').value) || -3.703790;

			var map = L.map('map', { attributionControl: false }).setView([latitude, longitude], 15);

			L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
				maxZoom: 18
			}).addTo(map);

			var customIcon = L.icon({
				iconUrl: '/o/theme-avanis/images/icons/assets-icons/av-icon-location-map.svg',
				iconSize: [42, 66],
				iconAnchor: [19, 38],
				popupAnchor: [0, -38]
			});

			// Añadir un marcador en la ubicación inicial
			var marker = L.marker([latitude, longitude], { icon: customIcon }).addTo(map);

			// Función para actualizar la visualización de la ubicación
			function updateLocationDisplay(latitude, longitude) {
				let send = {
					"<portlet:namespace />latitude": latitude,
					"<portlet:namespace />longitude": longitude
				};

				$.ajax({
					url: '${getLocationURL}',
					type: 'POST',
					dataType: 'json',
					data: send,
					success: function(data) {
						$('#location-name').html(data.location);
					},
					error: function (error) {
						console.error('Error en la petición AJAX:', error);
					}
				});
			}

			// Actualizar la ubicación al hacer clic en el mapa
			map.on('click', function(event) {
				let latitude = event.latlng.lat;
				let longitude = event.latlng.lng;

				// Mover el marcador a la nueva ubicación
				marker.setLatLng(event.latlng);
				document.getElementById('<portlet:namespace />latitude').value = latitude;
				document.getElementById('<portlet:namespace />longitude').value = longitude;

				// Actualizar la visualización de la ubicación
				updateLocationDisplay(latitude, longitude);
			});

			// Añadir el control de búsqueda al mapa
			const search = new GeoSearch.GeoSearchControl({
				provider: new GeoSearch.OpenStreetMapProvider(),
				style: 'bar',
				autoComplete: true,
				autoCompleteDelay: 250,
				showMarker: false,
				keepResult: true,
			});

			map.addControl(search);

			// Actualizar la visualización de la ubicación inicial
			updateLocationDisplay(latitude, longitude);
		}

		// Función para ajustar el mobileBox
		function adjustMobileBox(offset) {
			var mobileBox = document.querySelector(".select2-dropdown.select2-dropdown--below");
			if (mobileBox) {
				var currentTop = parseInt(window.getComputedStyle(mobileBox).top, 10);
				mobileBox.style.top = (currentTop + offset) + "px";
			}
		}

		// Función principal encapsulada para inicializar el comportamiento
		function initializeBehavior() {
			var selectTrigger = document.querySelector(".av-te-cu__form-row--002");
			var previousHeight = null;
			var initialAdjustmentDone = false;

			if (selectTrigger) {
				selectTrigger.addEventListener("click", function() {
					if (!initialAdjustmentDone) {
						var heightReference = document.querySelector("ul#select2-multiple-select-optgroup-field-container");
						if (heightReference) {
							previousHeight = heightReference.offsetHeight;
							adjustMobileBox(-previousHeight);
							initialAdjustmentDone = true;
						}
					}

					var tagsTriggers = document.querySelectorAll(".select2-results__options.select2-results__options--nested li");

					function getHeightReference() {
						var heightReference = document.querySelector("ul#select2-multiple-select-optgroup-field-container");
						return heightReference ? heightReference.offsetHeight : null;
					}

					function adjustMobileBox(offset) {
						var mobileBox = document.querySelector(".select2-dropdown.select2-dropdown--below");
						if (mobileBox) {
							var currentTop = parseInt(window.getComputedStyle(mobileBox).top, 10);
							mobileBox.style.top = (currentTop + offset) + "px";
						}
					}

					tagsTriggers.forEach(function(tagsTrigger) {
						tagsTrigger.addEventListener("click", function() {
							var currentHeight = getHeightReference();
							if (currentHeight !== null) {
								if (previousHeight !== null && previousHeight !== currentHeight) {
									adjustMobileBox(previousHeight - currentHeight);
									previousHeight = currentHeight;
								} else if (previousHeight === null) {
									adjustMobileBox(-currentHeight);
									previousHeight = currentHeight;
								}
							}
						});
					});
				});
			}
		}
		initializeMap();
		loadMultiSelectorStyle();
	};

	// Lanzar la función de envoltorio cuando toda la página (incluyendo imágenes y recursos) ha sido completamente cargada.
	window.onload = function () {
		handleFunctionCreateOrUpdate();
	};

	// Lanzar la función de envoltorio cuando todos los portlets estén listos.
	Liferay.on('allPortletsReady', function () {
		handleFunctionCreateOrUpdate();
	});

	// Lanzar la función de envoltorio cuando una nueva pantalla se ha cargado en la navegación SPA.
	Liferay.on('screenLoad', function () {
		handleFunctionCreateOrUpdate();
	});

	// Lanzar la función de envoltorio cuando la navegación SPA ha terminado.
	Liferay.on('endNavigate', function () {
		handleFunctionCreateOrUpdate();
	});

	// Lanzar la función de envoltorio cuando se produce navegación en el SPA.
	Liferay.on('SPA_NAVIGATION', function (event) {
		handleFunctionCreateOrUpdate();
	});

	// Lanzar la función de envoltorio cuando hay cambios de ruta.
	Liferay.on('routeChanged', function () {
		handleFunctionCreateOrUpdate();
	});

</script>
<style>
	.loading-spinner {
		position: fixed;
		top: 0;
		left: 0;
		width: 100%;
		height: 100%;
		background-color: rgba(255, 255, 255, 0.8);
		display: flex;
		justify-content: center;
		align-items: center;
		z-index: 9999; /* Asegúrate de que esté encima de otros elementos */
		flex-direction: column;
		p{
			color: gray;
		}
	}

	.spinner {
		border: 4px solid rgba(0, 0, 0, 0.1);
		border-left-color: #000;
		border-radius: 50%;
		width: 40px;
		height: 40px;
		animation: spin 1s linear infinite;
	}

</style>