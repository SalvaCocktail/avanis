<%@ include file="/init.jsp" %>

<div id="loginCount">
    <h2><liferay-ui:message key="avanis.olvidaste.pass.preguntar"/></h2>
    <label ><liferay-ui:message key="avanis.olvidaste.pass.mail"/></label>

    <portlet:actionURL name="recoverPassword" var="recoverPassword">
        <portlet:param name="mvcPath" value="/mail_sent.jsp" />
    </portlet:actionURL>

    <aui:form action="<%= recoverPassword  %>" autocomplete='on' cssClass="sign-in-form" method="post" name="resetForm">
        <aui:input cssClass="clearable" label="Introducir nueva contraseña" name="passwordNew" showRequiredLabel="false" type="password" value="">
            <aui:validator name="required" />
        </aui:input>
        <aui:input cssClass="clearable" label="Validar nueva contraseña" name="passwordValidate" showRequiredLabel="false" type="password" value="">
            <aui:validator name="required" />
        </aui:input>

    <p><strong><liferay-ui:message key="avanis.preguntar.cuenta"/></strong></p>
    <a href="/registro" id="createCount"><liferay-ui:message key="avanis.crear.cuenta"/></a>

    <aui:button-row>
        <aui:button cssClass="btn-lg" type="submit" value="Enviar" />
    </aui:button-row>
    </aui:form>
</div>

<script>
    $(document).ready(function() {
        $('#<portlet:namespace />password').on('input', function() {
            var password = $(this).val();
            var strength = 0;
            var tips = "";

            // Check password length
            if (password.length < 8) {
                tips += "Make the password longer. ";
                removerClase("caracteres");


            } else {
                agregarClase("caracteres");
                strength += 1;
            }

            // Check for mixed case
            if (password.match(/[a-z]/) && password.match(/[A-Z]/)) {
                agregarClase("mayusculas");
            } else {
                tips += "Use both lowercase and uppercase letters. ";
                removerClase("mayusculas");
            }

            // Check for numbers
            if (password.match(/\d/)) {
                agregarClase("numero");
            } else {
                tips += "Include at least one number. ";
                removerClase("numero");
            }

            // Check for special characters
            if (password.match(/[-!"#$%&()*,./:;?@[\]^_`{|}~+<=>]/)) {
                agregarClase("caracteresEspeciales");
            } else {
                tips += "Include at least one special character. ";
                removerClase("caracteresEspeciales");

            }
        });
    });

    function agregarClase(id) {
        $("#" + id).addClass("av-icon-check");
    }

    function removerClase(id) {
        $("#" + id).removeClass("av-icon-check");
    }

</script>

