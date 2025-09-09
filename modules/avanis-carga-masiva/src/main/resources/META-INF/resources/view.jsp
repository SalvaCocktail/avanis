<%@ include file="/init.jsp" %>

<portlet:resourceURL id="/procesar_csv" var="procesarCSVURL" />

<div id="cargarArchivo">
	<h2>Seleccionar Estructura</h2>
	<div id="mensajeError" style="color: red; font-weight: bold; display: none;"></div>

	<form id="formCargaArchivo">
		<label for="estructuraId">Seleccionar Estructura:</label>
		<select id="estructuraId" name="estructuraId" required>
			<c:forEach var="estructura" items="${estructurasDisponibles}">
				<option value="${estructura.structureId}">${estructura.nameCurrentValue}</option>
			</c:forEach>
		</select>

		<br><br>
		<label for="csvFile">Subir Archivo CSV:</label>
		<input type="file" id="csvFile" name="csvFile" required />

		<br><br>
		<button type="button" id="btnSubirCSV">Cargar Archivo</button>
	</form>
</div>

<br><br>
<div id="vistaPrevia" class="d-none"></div>

<!-- Indicador de carga (inicialmente oculto) -->
<div id="loadingIndicator" style="display: none; text-align: center; font-weight: bold;">
	<p>Cargando... Por favor, espere</p>
</div>

<script>
	$(document).ready(function() {
		$("#csvFile").change(function() {
			$("#mensajeError").hide();
		});

		$("#btnSubirCSV").click(function () {
			let estructuraId = $("#estructuraId").val();
			let fileInput = $("#csvFile")[0].files[0];

			// Validar que se haya seleccionado un archivo CSV
			if (!fileInput || !fileInput.name.endsWith(".csv")) {
				$("#mensajeError").text("Debe seleccionar un archivo CSV.").css("color", "red").show();
				return;
			}

			$("#cargarArchivo").addClass("d-none");
			$("#loadingIndicator").show();

			let formData = new FormData();
			formData.append("estructuraId", estructuraId);
			formData.append("csvFile", fileInput);

			$.ajax({
				url: "${procesarCSVURL}",
				type: "POST",
				data: formData,
				processData: false,
				contentType: false,
				success: function (response) {
					$("#vistaPrevia").html(response);
					$("#vistaPrevia").removeClass("d-none");
					$("#loadingIndicator").hide();
				},
				error: function () {
					$("#mensajeError").text("Error al procesar el archivo.").css("color", "red").show();
					$("#cargarArchivo").removeClass("d-none");
				}
			});
		});
	});
</script>