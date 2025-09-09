<%@ include file="/init.jsp" %>

<div id="loginCount">
    <h2><liferay-ui:message key="avanis.olvidaste.pass.preguntar"/></h2>
    <label ><liferay-ui:message key="avanis.olvidaste.pass.mail"/></label>

    <portlet:actionURL name="recoverPassword" var="recoverPassword">
        <portlet:param name="mvcPath" value="/mail_sent.jsp" />
    </portlet:actionURL>

    <aui:form action="<%= recoverPassword  %>" autocomplete='on' cssClass="sign-in-form" method="post" name="resetForm">
        <aui:input  cssClass="clearable" label="email-address" name="email-address" showRequiredLabel="false" type="email" value="">
            <aui:validator name="required" />
        </aui:input>

    <p><strong><liferay-ui:message key="avanis.preguntar.cuenta"/></strong></p>
    <a href="/tipo-registro" id="createCount"><liferay-ui:message key="avanis.crear.cuenta"/></a>

    <aui:button-row>
        <aui:button cssClass="btn-lg" type="submit" value="Enviar" />
    </aui:button-row>
    </aui:form>
</div>

