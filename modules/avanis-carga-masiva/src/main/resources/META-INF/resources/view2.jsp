<%@ include file="/init.jsp" %>

<portlet:resourceURL id="/guardar_contenidos" var="guardarContenidosURL" />

<div style="display: flex; justify-content: space-between; margin-bottom: 10px;" id="divBotonesCerrarMostrar">
	<button onclick="cerrarVistaPrevia()">Cerrar Vista Previa</button>
	<button onclick="mostrarMapeo()">Siguiente</button>
</div>

<div id="listaCSV">
	<table border="1" style="border-collapse: collapse; width: 100%;">
		<thead>
		<tr>
			<c:forEach var="columna" items="${cabeceras}">
				<th style="padding: 8px; text-align: left; border: 1px solid black;">${columna}</th>
			</c:forEach>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="fila" items="${csvData}">
			<tr>
				<c:forEach var="columna" items="${fila}">
					<td style="padding: 8px; text-align: left; border: 1px solid black;">
						<c:out value="${columna}" escapeXml="false" />
					</td>
				</c:forEach>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>

<div id="mapeoCampos" class="d-none">
	<h3>Mapear Campos</h3>
	<form id="formMapeo">
		<c:forEach var="entry" items="${estructuraCampos}">
			<label>${entry.value}</label>
			<select id="map-${entry.key}" onchange="guardarMapeo('${entry.key}', this.value)">
				<option value="">Seleccionar campo</option>
				<c:forEach var="columna" items="${cabeceras}">
					<option value="${entry.key}:${columna}">${columna}</option>
				</c:forEach>
			</select>
		</c:forEach>

		<br><br>
		<button type="button" onclick="procesarMapeo()">Confirmar Mapeo</button>
	</form>
</div>

<script>
	let mappings = {}; // Objeto global para almacenar los mapeos

	function guardarMapeo(fieldId, selectedValue) {
		// Validar que se seleccionó un valor válido
		if (!selectedValue) {
			return;
		}

		// Verificar si el campo ya estaba asignado antes
		if (Object.values(mappings).includes(selectedValue)) {
			alert("Este campo ya ha sido seleccionado en otro mapeo.");
			document.getElementById("map-" + fieldId).value = ""; // Reiniciar selección
			return;
		}

		// Guardar el mapeo correctamente en la variable global
		mappings[fieldId] = selectedValue;
		console.log("Mapeo actualizado:", mappings);
	}

	function cerrarVistaPrevia() {
		$("#vistaPrevia").addClass("d-none");
		$("#cargarArchivo").removeClass("d-none");
	}

	function mostrarMapeo() {
		$("#listaCSV").addClass("d-none");
		$("#divBotonesCerrarMostrar").addClass("d-none");
		$("#mapeoCampos").removeClass("d-none");
	}

	function procesarMapeo() {
		console.log("procesarMapeo")
		let formData = new FormData();
		let fileInput = $("#csvFile")[0].files[0];
		let estructuraId = $("#estructuraId").val();

		if (!fileInput) {
			alert("Error: No se encontró el archivo CSV.");
			return;
		}

		formData.append("csvFile", fileInput);
		formData.append("estructuraId", estructuraId);
		formData.append("mappings", JSON.stringify(mappings));

		$.ajax({
			url: "${guardarContenidosURL}",
			type: "POST",
			data: formData,
			processData: false,
			contentType: false,
			success: function(response) {
				alert("Carga completada exitosamente.");
				window.location.reload();
			},
			error: function() {
				alert("Carga en curso... en proceso...");
				window.location.reload();
			}
		});
	}
</script>