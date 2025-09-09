<%@ include file="/init.jsp" %>

<jsp:directive.page contentType="text/html" pageEncoding="UTF-8" />
<%
    String resourceType = (String) request.getAttribute("resourceType");
    String resourceLabel = "";

    if ("evento".equalsIgnoreCase(resourceType)) {
        resourceLabel = "este evento";
    } else if ("noticia".equalsIgnoreCase(resourceType) || "ayuda".equalsIgnoreCase(resourceType)) {
        resourceLabel = "esta " + resourceType;
    }
%>
<div class="se-esta-hablando-not-logged">
    <h4>¿Quieres abrir un debate sobre <%= resourceLabel %> en la comunidad? ¡Coméntalo con otros profesionales!</h4>
    <div class="se-esta-hablando-not-logged-content">
        <btn class="crea-tu-cuenta" onclick="window.location.href='/tipo-registro'">Crea tu cuenta y participa</btn>
    </div>
</div>
