<%@ include file="/init.jsp" %>
<div id="loginCount">
    <div class="pass_olvidado">

        <c:choose>
            <c:when test="${error}">
                <h2><liferay-ui:message key="avanis.olvidaste.pass.mensaje.enviado"/></h2>
                <a href="<%= themeDisplay.getURLHome() %>" id="createCount"><liferay-ui:message key="avanis.olvidaste.pass.link.volver.home"/></a>
                <img class="mail_sent" src="<%=request.getContextPath()%>/images/Varification_illustration.svg" alt="Verification Illustration" />
            </c:when>
            <c:otherwise>
                <h2><liferay-ui:message key="avanis.olvidaste.pass.mensaje.enviado"/></h2>
                <a href="<%= themeDisplay.getURLHome() %>" id="createCount"><liferay-ui:message key="avanis.olvidaste.pass.link.volver.home"/></a>
                <img class="mail_sent" src="<%=request.getContextPath()%>/images/Varification_illustration.svg" alt="Verification Illustration" />
            </c:otherwise>
        </c:choose>



        </div>
</div>