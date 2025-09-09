<%@ include file="/init.jsp" %>
<portlet:actionURL name="crearPaginasPadre" var="crearPaginasPadreURL" />
<portlet:actionURL name="crearPaginasHijas" var="crearPaginasHijasURL" />

<div>
    <button onclick="location.href='<%= crearPaginasPadreURL %>'">Crear Paginas Padre</button>
    <button onclick="location.href='<%= crearPaginasHijasURL %>'">Crear Paginas Hijas</button>
</div>