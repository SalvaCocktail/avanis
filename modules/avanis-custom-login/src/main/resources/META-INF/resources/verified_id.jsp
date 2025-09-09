<%@ include file="/init.jsp" %>
<portlet:actionURL name="repitePass" var="repitePassURL">
    <portlet:param name="redirect" value="<%= themeDisplay.getURLHome() %>" />
</portlet:actionURL>

<div id="loginCount">
    <h2><liferay-ui:message key="avanis.olvidaste.pass.identidad.verificada"/></h2>
    <h2><liferay-ui:message key="avanis.olvidaste.pass.nueva.pass"/></h2>


    <aui:form action="<%= repitePassURL  %>" autocomplete='on' cssClass="sign-in-form" method="post" name="resetForm">
        <label ><liferay-ui:message key="avanis.olvidaste.pass.nueva.pass.label"/></label>
        <aui:input  cssClass="clearable"   showRequiredLabel="<%= false %>" type="password" value="" name="">
            <aui:validator name="required" />
        </aui:input>

        <label ><liferay-ui:message key="avanis.olvidaste.pass.repite.nueva.pass.label"/></label>
        <aui:input  cssClass="clearable"   showRequiredLabel="<%= false %>" type="password" value="" name="">
            <aui:validator name="required" />
        </aui:input>

        <aui:button-row>
            <aui:button cssClass="btn-lg" type="submit" value="Enviar" />
        </aui:button-row>
    </aui:form>


</div>