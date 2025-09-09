<%@ include file="/init.jsp" %>

<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>
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
    <h4>Se está hablando de <%= resourceLabel %> en la comunidad, ¿te unes al debate?</h4>
    <div class="se-esta-hablando-not-logged-content">
        <div class="profile-images">
            <c:forEach var="interactingUser" items="${users}">
                <img class="profile" src="${interactingUser.getPortraitURL(themeDisplay)}" alt="profile"/>
            </c:forEach>
        </div>
        <div class="likes-comments">
            <div class="likes">
                <img class="se-esta-hablando-not-logged-img" src="<%=request.getContextPath()%>/images/heart.svg"
                     alt="likes"/>
                ${likes}
            </div>
            <div class="comments">
                <img class="se-esta-hablando-not-logged-img"
                     src="<%=request.getContextPath()%>/images/message-square-lines-alt.svg" alt="comments"/>
                ${comments}
            </div>
        </div>
        <btn class="crea-tu-cuenta" onclick="window.location.href='/tipo-registro'">Crea tu cuenta y participa</btn>
    </div>
</div>