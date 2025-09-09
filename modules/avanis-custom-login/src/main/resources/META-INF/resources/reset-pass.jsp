<%@ include file="./init.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<portlet:actionURL name="resetpassword" var="resetpassword">
    <portlet:param name="mvcPath" value="/login"/>
</portlet:actionURL>
<c:set var = "tokenvalid" scope = "request" value = "${tokenvalid}"/>
<c:choose>
    <c:when test = "${tokenvalid}">
        <div class="av-content-form">
            <div class="av-content-right">
                <h2>Restaurar contraseña</h2>
                <!-- Form -->
                <aui:form action="<%= resetpassword %>" autocomplete='on' cssClass="sign-in-form" method="post" name="resetpass">
                    <aui:input name="token" type="hidden" value="${token}"></aui:input>
                    <div class="av-form-content">
                        <div class="av-input-wrapper">
                            <div class="av-input-password">
                                <div class="av-input-wrapper">
                                    <aui:input id="password" type="password" placeholder="Contraseña" name="password" label="avanis.campo.pass" value="">
                                        <aui:validator name="required" />
                                    </aui:input>
                                </div>
                                <span class="av-icon-eye"></span>
                            </div>
                        </div>
                    </div>

                    <div class="av-form-content">
                        <div class="av-input-wrapper">
                            <div class="av-input-password">
                                <div class="av-input-wrapper">
                                    <aui:input id="re-password" type="password" placeholder="Repite tu contraseña" name="re-password" label="" value="">
                                        <aui:validator name="required" />
                                    </aui:input>
                                </div>
                                <span class="av-icon-eye"></span>
                            </div>
                        </div>
                    </div>
                    <div class="av-about-form-control-buttons">
                        <aui:button label="" type="submit" name="btnenvioregistro" cssClass="btn btn-reset-pass btn-primary" value="Guardar">
                        </aui:button>
                    </div>
                    <!-- Pass security -->
                    <div class="av-security">
                        <liferay-ui:message key="avanis.info.pass" />
                    </div>
                    <p class="av-mandatory-legend">
                        <liferay-ui:message key="avanis.info.marcados" />
                    </p>

                </aui:form>
            </div>
        </div>
    </c:when>
    <c:otherwise>
        <div class="av-content-form">
            <div class="av-content-right">
                <h2>Solicitud caducada</h2>
            </div>
        </div>
    </c:otherwise>
</c:choose>


<%--<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>--%>
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

        $('#<portlet:namespace />re-password').on('input', function() {
            var password = $('#<portlet:namespace />password').val();
            var rePassword = $(this).val();

            if (password !== rePassword) {
                $(this).addClass('input-error');
                $('#<portlet:namespace />btnenvioregistro').attr('disabled', true);
            } else {
                $(this).removeClass('input-error');
                $('#<portlet:namespace />btnenvioregistro').attr('disabled', false);
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

<aui:script>
    AUI().use('aui-base', function(A) {
    var submitButton = A.one('#<portlet:namespace />btnenvioregistro');
    submitButton.set('disabled', true);

    A.one('#<portlet:namespace />registerForm').on('keyup', function(event) {
    var passwordField = A.one('#<portlet:namespace />password');
    var passwordValue = passwordField.get('value');
    var rePasswordField = A.one('#<portlet:namespace />re-password');
    var rePasswordValue = rePasswordField.get('value');
    var passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*()_+={}:;'"\\|,.<>/?~`-])[A-Za-z\d!@#$%^&*()_+={}:;'"\\|,.<>/?~`-]{8,}$/;

    if (passwordRegex.test(passwordValue) && passwordValue === rePasswordValue) {
    submitButton.set('disabled', false);
    } else {
    submitButton.set('disabled', true);
    }
    });
    });
</aui:script>
