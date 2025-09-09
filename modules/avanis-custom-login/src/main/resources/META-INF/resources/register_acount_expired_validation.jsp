<%@ include file="./init.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div class="av-signup-columns">
    <!-- region Left menu -->
    <div class="av-content-left">
        <div>
            <h2 class="av-txt-title"><liferay-ui:message key="avanis.register.mensaje.enviado.seccion.izqda" /></h2>
        </div>
    </div>
    <!-- endregion Left menu -->
    <!-- region Form -->
    <div class="av-content-form">
        <div class="av-content-right">
            <div class="register-mensaje-enviado">
                <img class="mail_sent" src="<%=request.getContextPath()%>/images/Varification_illustration.svg" alt="Verification Illustration" />
                <h3><liferay-ui:message key="avanis.register.mensaje.enviado.validacion.caducada" /></h3>
                <label><liferay-ui:message key="avanis.register.mensaje.enviado.validacion.caducada.reenviar" /></label>
                <a href="" id="createCount"><liferay-ui:message key="avanis.register.mensaje.enviado.validacion.caducada.reenviar.link"/></a>
            </div>
        </div>
    </div>
</div>