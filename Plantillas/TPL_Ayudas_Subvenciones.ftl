<style>
* {
box-sizing: border-box;
margin: 0;
padding: 0;
font-family: Arial, sans-serif;
}

.container {
display: flex;
justify-content: space-between;
padding: 20px;
max-width: 1200px;
margin: 0 auto;
}

.left-section {
width: 65%;
}

.right-section {
width: 30%;
background-color: #f7f7f7;
padding: 20px;
border-radius: 8px;
}

h1 {
font-size: 24px;
margin-bottom: 10px;
}

.tags {
display: flex;
gap: 10px;
margin-bottom: 20px;
}

.tag {
background-color: #E6EDE4;
color: #555;
padding: 5px 10px;
border-radius: 12px;
font-size: 12px;
}

.compartir {
font-size: 14px;
color: #39943E;
margin-left: auto;
text-decoration: none;
}

h2 {
font-size: 20px;
margin-top: 20px;
margin-bottom: 10px;
}

p {
font-size: 14px;
color: #555;
margin-bottom: 10px;
}

.solicitud-container {
text-align: center;
}

.solicitud-button {
background-color: #122c1f;
color: white;
padding: 10px 20px;
border-radius: 8px;
text-decoration: none;
display: inline-block;
margin-top: 20px;
transition: all 0.5s ease-in-out;
}

.datos-ayuda h3,
.descargas-relacionadas h3,
.otras-ayudas h3 {
font-size: 18px;
margin-bottom: 10px;
}

.datos-ayuda p,
.descargas-relacionadas a,
.otras-ayudas .ayuda-relacionada p {
font-size: 14px;
margin-bottom: 10px;
}

.btn-accion {
display: inline-block;
background-color: #122c1f;
color: white;
padding: 8px 16px;
border-radius: 6px;
text-decoration: none;
margin-bottom: 10px;
margin-right: 10px;
white-space: nowrap;
transition: all 0.5s ease-in-out;
}

.inline-buttons {
white-space: nowrap; /* Evita que los botones rompan en diferentes líneas */
}

.btn-accion:hover,
.solicitud-button:hover {
color: #ffffff; /* Mantén el texto blanco */
background-color: #329c5e; /* Color de fondo en hover */
border: 1px solid #329c5e; /* Borde en hover */
}

.descargas-relacionadas a {
display: block;
color: #39943E;
text-decoration: none;
margin-bottom: 5px;
}

.otras-ayudas .ayuda-relacionada {
margin-bottom: 20px;
}

.status {
background-color: #E6F5D9;
color: #64A45A;
padding: 2px 6px;
border-radius: 12px;
font-size: 12px;
}
</style>

<div class="container">
    <div class="left-section">
        <h1><#if (titulo.getData())??> ${titulo.getData()} </#if></h1>
        <p><#if (descripcionCorta.getData())??> ${descripcionCorta.getData()} </#if></p>

        <div class="tags">
            <a href="#" class="compartir">Compartir</a>
        </div>

        <h2>Finalidad</h2>
        <p><#if (finalidad.getData())??> ${finalidad.getData()} </#if></p>

        <h2>Alcance</h2>
        <p><#if (alcance.getData())??> ${alcance.getData()} </#if></p>

        <div class="solicitud-container">
            <a href="#" class="solicitud-button">Ir a la solicitud</a>
        </div>
    </div>

    <div class="right-section">
        <div class="datos-ayuda">
            <h3>Datos de la ayuda</h3>
            <p><strong>Estado:</strong> Activa</p>
            <p><strong>Finca:</strong> <#if (entidad.getData())??> ${entidad.getData()} </#if></p>
            <p><strong>Apertura:</strong>
                <#assign fechaInicioSolicitud_Data = getterUtil.getString(fechaInicioSolicitud.getData())>
                <#if validator.isNotNull(fechaInicioSolicitud_Data)>
                    <#assign fechaInicioSolicitud_DateObj = dateUtil.parseDate("yyyy-MM-dd", fechaInicioSolicitud_Data, locale)>
                    ${dateUtil.getDate(fechaInicioSolicitud_DateObj, "dd MMM yyyy", locale)}
                </#if>
            </p>
            <p><strong>Cierre:</strong>
                <#assign fechaFinSolicitud_Data = getterUtil.getString(fechaFinSolicitud.getData())>
                <#if validator.isNotNull(fechaFinSolicitud_Data)>
                    <#assign fechaFinSolicitud_DateObj = dateUtil.parseDate("yyyy-MM-dd", fechaFinSolicitud_Data, locale)>
                    ${dateUtil.getDate(fechaFinSolicitud_DateObj, "dd MMM yyyy", locale)}
                </#if>
            </p>
            <p><strong>Importe:</strong> <#if (montos.getData())??> ${montos.getData()} </#if></p>
            <p><strong>Sector:</strong> <#if (beneficiario.getData())??> ${beneficiario.getData()} </#if></p>

            <div class="inline-buttons d-none">
                <a href="#" class="btn-accion">Ir a la solicitud</a>
                <a href="#" class="btn-accion">Añadir al calendario</a>
            </div>
        </div>

        <div class="descargas-relacionadas d-none">
            <h3>Descargas relacionadas</h3>

        </div>

        <div class="otras-ayudas d-none">
            <h3>Otras ayudas relacionadas</h3>

        </div>
    </div>
</div>


<script>
var contentTitle = "${.vars["reserved-article-title"].data}";

document.addEventListener('DOMContentLoaded', function () {
const url = '/o/headless-delivery/v1.0/content-structures/199118/structured-contents';
    const tokenUrl = '/o/oauth2/token';
    const clientId = 'id-1a66a366-969f-d934-266f-05196e19118';
    const clientSecret = 'secret-5da41fe6-f2df-8e5e-49c2-7df9b945e2';
    const contentTitle = "${.vars['reserved-article-title'].data}";

    // Paso 1: Obtener el access_token
    const tokenHeaders = new Headers({
'Content-Type': 'application/x-www-form-urlencoded'
});

    const tokenBody = new URLSearchParams({
'grant_type': 'client_credentials',
'client_id': clientId,
'client_secret': clientSecret
});

    fetch(tokenUrl, {
method: 'POST',
headers: tokenHeaders,
body: tokenBody
})
.then(response => {
if (!response.ok) {
throw new Error('Error al obtener el token: ' + response.statusText);
}
        return response.json();
    })
.then(tokenData => {
const accessToken = tokenData.access_token;

// Paso 2: Hacer la llamada a la API headless con el access_token
return fetch(url, {
method: 'GET',
headers: new Headers({
'Authorization': 'Bearer ' + accessToken,
'Content-Type': 'application/json'
})
        });
    })
.then(response => {
if (!response.ok) {
throw new Error('Network response was not ok ' + response.statusText);
}
        return response.json();
    })
.then(data => {
// Verifica que el objeto data y items existan
if (data && data.items) {
data.items.forEach(item => {
// Comparar el título del contenido
if (item.title === contentTitle) {
console.log('Contenido encontrado:', item.title);

// Obtener las categorías de taxonomía
if (item.taxonomyCategoryBriefs) {
const tagsContainer = document.querySelector('.tags');

item.taxonomyCategoryBriefs.forEach(category => {
const tagSpan = document.createElement('span');
tagSpan.className = 'tag';
tagSpan.textContent = category.taxonomyCategoryName;
tagsContainer.prepend(tagSpan);
});
                    } else {
console.log('No se encontraron categorías de taxonomía.');
}

                    // Obtener y agregar los adjuntos descargables
                    const downloadsContainer = document.querySelector('.descargas-relacionadas');

                    let hasDownloads = false; // Variable para verificar si hay adjuntos

                    item.contentFields.forEach(function(field) {
if (field.name === 'adjuntos' && field.nestedContentFields) {
field.nestedContentFields.forEach(function(nestedField) {
if (nestedField.contentFieldValue && nestedField.contentFieldValue.document) {
const documentData = nestedField.contentFieldValue.document;

const downloadLink = document.createElement('a');
downloadLink.href = documentData.contentUrl;
downloadLink.textContent = documentData.title;
downloadLink.target = '_blank'; // Abrir en una pestaña nueva
downloadsContainer.appendChild(downloadLink);

hasDownloads = true; // Hay al menos un adjunto
}
                            });
                        }
                    });

                    // Remover la clase d-none si hay adjuntos
                    if (hasDownloads) {
downloadsContainer.classList.remove('d-none');
}
                }
            });
        } else {
console.log('No se encontraron items en la respuesta.');
}
    })
.catch(error => {
console.error('Hubo un problema con la operación fetch:', error);
});
});

</script>