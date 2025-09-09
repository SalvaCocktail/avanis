<%@ include file="./init.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<portlet:actionURL var="updatePasswordURL" name="updatePassword"/>
<portlet:actionURL var="createPasswordURL" name="createPassword"/>
<portlet:actionURL var="unlinkGoogleURL" name="unlinkGoogle"/>
<portlet:actionURL var="closeSessionsURL" name="closeSessions"/>

<liferay-ui:error key="wrongCurrentPassword" message="Contraseña incorrecta."/>
<liferay-ui:error key="wrongNewPassword" message="Contraseña invalida."/>
<liferay-ui:error key="hasAlreadyPassword" message="Ya tienes contraseña"/>
<liferay-ui:error key="googleUnlinkError" message="Error desvinculando google. Inténtelo de nuevo más tarde."/>

<div class="av-main__header">
    <img class="go-to-menu" onClick="displayMenu()" class="mr-2"
         src="<%=request.getContextPath()%>/images/arrow-left.png" alt="arrow left"/>
    <h2>Seguridad de mi cuenta</h2>
</div>
<div class="seguridad-cuenta">
    <div class="seguridad-cuenta-azul">
        <p><strong>Tu cuenta está protegida por seguridad avanzada</strong>
            Mantén actualizada esta información para proteger aún más tu cuenta
        </p>
        <img src="<%=request.getContextPath()%>/images/shield-alt-1.png">
    </div>
    <br>
    <div class="seguridad-seccion">
        <div class="title">
            <h4>
                Correo electrónico asociado a tu cuenta
            </h4>
        </div>

        <div class="content">
            <p>Es la dirección que tenemos de tu registro con tu correo electrónico y donde recibirás todas las
                comunicaciones de
                Avanis
            </p>
        </div>
        <div class="foot">
            <div class="content"><h5>${userEmail}</h5>
            </div>

        </div>
    </div>
    <hr>


    <%-- Cuando tiene pass editas--%>
    <c:choose>
        <c:when test="${hasPassword}">

            <div class="seguridad-seccion">
                <div class="title">
                    <h4>Contraseña de acceso</h4>
                </div>
                <div class="content">
                    <p>Edita tu contraseña de acceso a Avanis con tu correo
                    </p>
                </div>
                <div class="foot">
                    <div class="content"><h5>${userEmail}</h5>
                    </div>
                    <button class="profile__button--edit" id="seguridad-editar-password"><span
                            class="profile__icon profile__icon--edit"></span>
                        <p>Editar</p></button>

                </div>
            </div>
            <hr>

            <%-- MODAL EDITAR CONTRASEÑA--%>
            <%-- Modal para EDITAR COTRASEÑA FULL--%>
            <div class="modal-seguidores">
                <div id="alertModal" class="av-te-ma-modal">
                    <div class="av-te-ma-modal__panel">
                        <div class="av-te-ma-modal__header">
                            <h5 class="modal-title" id="exampleModalLabel">Editar contraseña</h5>
                            <span class="av-icon-close">&times;</span>
                        </div>
                        <div class="av-te-ma-modal__content">
                            <div>
                                <aui:form method="post" cssClass="av-form-my-account" action="${updatePasswordURL}"
                                          name="fma" id="registerForm">
                                <aui:input type="hidden" value="security" name="focusedTab"/>
                                <aui:input label="Contraseña actual" name="oldPass" type="password"
                                           cssClass="input-pass">
                                    <aui:validator name="required"/>
                                </aui:input>
                                <aui:input label="Contraseña nueva" name="newPass" type="password" id="nueva-pass"
                                           cssClass="input-pass">
                                    <aui:validator name="required"/>
                                </aui:input>
                                    <!-- Pass security -->
                                    <div class="av-security">
                                        <liferay-ui:message key="avanis.info.pass" />
                                    </div>


                                    <div class="av-about-form-control-buttons">
                                        <button class="av-btn-secondary mr-3 btn-editar-pass btn-modal btn-cancelar" type="button" >Cancelar</button>
                                        <aui:button type="submit" value="Guardar" cssClass="btn-editar-pass btn-modal" name="btneditarpass" id="btneditarpass"/>
                                        <%-- <aui:button label="" type="submit" name="btnenvioregistro" cssClass="btn-lg" value="avanis.crear.cuenta"> --%>
                                    </div>
                                </aui:form>
                            </div>
                            <div class="av-te-ma-modal__text">

                            </div>

                        </div>
                    </div>

                    <div class="av-te-ma-modal__footer">
                        <button class="av-te-ma-modal__accept-btn">
                            Aceptar
                        </button>
                    </div>
                </div>
            </div>


        </c:when>
        <c:otherwise>

            <%-- Cuando NO tiene pass creas --%>

            <div class="seguridad-seccion">
                <div class="title">
                    <h4>Contraseña de acceso</h4>
                </div>
                <div class="content">
                    <p>Crea una contraseña para proteger aún más tu cuenta y para poder acceder a Avanis con tu
                        correo </p>
                </div>
                <div class="foot">
                    <div class="content"><p>[${userEmail}]</p>
                    </div>
                    <div class="av-about-form-control-buttons">
                        <button class="btn  btn-primary btn-despliega-modal-crea-pass"
                                id="_avanis_my_account_portlet_AvanisMyAccountPortlet_INSTANCE_ktts_uzvm" type="submit">
                            <span class="lfr-btn-label">Crear</span>
                        </button>
                    </div>
                </div>
            </div>
            <hr>


            <!-- Modal para crear contraseña -->
            <div class="modal-seguidores">
                <div id="alertModalC" class="av-te-ma-modal">
                    <div class="av-te-ma-modal__panel">
                        <div class="av-te-ma-modal__header">
                            <h5 class="modal-title" id="exampleModalLabel">Crear contraseña</h5>
                            <span class="av-icon-close">&times;</span>
                        </div>
                        <div class="av-te-ma-modal__content">
                            <div>
                                <aui:form method="post" cssClass="av-form-my-account" id="crear-pass-form" action="${createPasswordURL}"
                                          name="fma"
                                          enctype="multipart/form-data">
                                    <aui:input type="hidden" value="security" name="focusedTab"/>
                                    <aui:input label="contraseña nueva" name="newPass" type="password"
                                               cssClass="input-pass" id="inputcrearpass">
                                        <aui:validator name="required"/>
                                    </aui:input>
                                    <div class="av-about-form-control-buttons">
                                        <button class="av-btn-secondary mr-3 btn-editar-pass btn-modal btn-cancelar" type="button">Cancelar</button>
                                        <aui:button type="submit" value="Guardar" cssClass="btn-editar-pass btn-modal" id="btn-enviar"/>
                                    </div>
                                    <!-- Pass security -->
                                    <div class="av-security">
                                        <liferay-ui:message key="avanis.info.pass" />
                                    </div>

                                </aui:form>
                            </div>
                            <div class="av-te-ma-modal__text">

                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </c:otherwise>
    </c:choose>

    <h4>Acceso con perfiles sociales</h4>


    <div class="seguridad-seccion">
        <div class="foot foot-perfiles-sociales">
            <c:choose>
                <c:when test="${isGoogleLinked}">
                    <div class="contenedor-google">
                        <img src="<%=request.getContextPath()%>/images/RRSS%20Google%20color.png">
                        <h5>Google</h5>
                    </div>
                    <div class="av-about-form-control-buttons">

                    </div>
                    <aui:form method="post" cssClass="av-form-my-account" action="${unlinkGoogleURL}" name="fma"
                              enctype="multipart/form-data">
                        <aui:input type="hidden" value="security" name="focusedTab"/>
                     <div class="av-about-form-control-buttons" style="width: 100%">
                        <button class="btn  btn-primary" type="submit">
                            <span class="lfr-btn-label">Desvincular</span>
                        </button>
                    </div>
                    </aui:form>

                </c:when>
                <c:otherwise>
                    <%-- Vincular con google--%>

                    <div class="contenedor-google">
                        <img src="<%=request.getContextPath()%>/images/RRSS%20Google%20color.png">
                        <h5>Google</h5>
                    </div>
                    <div class="av-about-form-control-buttons">
                        <button class="btn  btn-primary" id="linkGoogleButton" type="submit">
                            <span class="lfr-btn-label">Vincular</span>
                        </button>
                    </div>
                    <%--
                    Link donde nos tiene que yevar el boton
                    <div class="av-about-form-control-buttons">
                        <a href="${googleSignInURL}">Vincular</a>
                    </div>
                    --%>


                </c:otherwise>
            </c:choose>
        </div>
    </div>

    <br><br>
    <h4>Actividad e inicio de sesión</h4>
    <%--
    <div class="seguridad-seccion actividad-inicio-sesion">
        <div class="foot foot-perfiles-sociales">
            <div class="contenedor-google">
                <img src="<%=request.getContextPath()%>/images/chrome.png">
                <h5>Chrome on Mac OS X computer</h5>
            </div>

        </div>
        <div class="foot">Sesión iniciada desde: 7 feb 2024, 4:44 pm CET</div>
        <div class="foot foot-navegador">Dirección IP: 79.116.188.5 (Madrid, Comunidad de, Spain
            <div class="av-about-form-control-buttons">
                <h5>Esta sesión</h5>
            </div>
        </div>

    </div>
    --%>
    <div class="av-about-form-control-buttons">
        <aui:button type="button" value="Cerrar sesiones" cssClass="btn-cerrar-sesiones" href="c/portal/logout"/>
    </div>
<%--
<aui:form method="post" cssClass="av-form-my-account" action="${closeSessionsURL}" name="fma"
          enctype="multipart/form-data">
    <aui:input type="hidden" value="security" name="focusedTab"/>
    <div class="av-about-form-control-buttons">
        <aui:button type="submit" value="Cerrar sesiones" cssClass="btn-cerrar-sesiones"/>
    </div>
</aui:form>
--%>
</div>

<script>
$(document).ready(function () {
    console.log("ready!");

    $("#linkGoogleButton").click(function () {
        window.location.href = "${googleSignInURL}";
    })
});

</script>
<script>
    $(document).ready(function() {
        // Mostrar el modal
        $('#seguridad-editar-password').on('click', function() {
            // Mostrar el modal
            $('#alertModal').fadeIn();
        });

        $('.btn-despliega-modal-crea-pass').on('click', function() {
            // Mostrar el modal
            $('#alertModalC').fadeIn();
        });

// Ocultar el modal cuando se haga clic en la X
        $('.av-icon-close,.btn-cancelar').on('click', function() {
            $('#alertModal').fadeOut();
            $('#alertModalC').fadeOut();
        });

        // Opcional: Ocultar el modal si se hace clic fuera del modal
        $(window).on('click', function(event) {
            if ($(event.target).is('#alertModal')) {
                $('#alertModal').fadeOut();
            }
            if ($(event.target).is('#alertModalC')) {
                $('#alertModalC').fadeOut();
            }
        });


        <%-- lógica para el modal de editar pass--%>
        $('#<portlet:namespace />nueva-pass').on('input', function() {
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

<aui:script>

    AUI().use('aui-base', function(A) {
    var submitButton = A.one('#<portlet:namespace />btneditarpass');
    console.log("Boton "+ submitButton + "deshabilitado");
    submitButton.set('disabled', true);


    A.one('#<portlet:namespace />fma').on('keyup', function(event) {

    var passwordField = A.one('#<portlet:namespace />nueva-pass');
    console.log("PasswordField: "+passwordField);
    var passwordValue = passwordField.get('value');
    var passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*()_+={}:;'"\\|,.<>/?~`-])[A-Za-z\d!@#$%^&*()_+={}:;'"\\|,.<>/?~`-]{8,}$/;
    if (!passwordRegex.test(passwordValue)) {
    submitButton.set('disabled', true);
    }
    else{
    console.log("Boton "+ submitButton + "habilitado");
    submitButton.set('disabled', false);
    }
    });
    });
</aui:script>


<%--lógica para modal crear contraseña--%>
<script>
$('#<portlet:namespace />inputcrearpass').on('input', function() {
var password = $(this).val();
var strength = 0;
var tips = "";

// Check password length
if (password.length < 8) {
    tips += "Make the password longer. ";
    removerClase("caracteres");
}
else
    {
        agregarClase("caracteres");
        strength += 1;
        }

// Check for mixed case
if (password.match(/[a-z]/) && password.match(/[A-Z]/)) {
    agregarClase("mayusculas");
    }
else {
    tips += "Use both lowercase and uppercase letters. ";
    removerClase("mayusculas");
}

// Check for numbers
if (password.match(/\d/)) {
    agregarClase("numero");
}
else {
    tips += "Include at least one number. ";
    removerClase("numero");
}

// Check for special characters
if (password.match(/[-!"#$%&()*,./:;?@[\]^_`{|}~+<=>]/)) {
    agregarClase("caracteresEspeciales");
}
else {
    tips += "Include at least one special character. ";
    removerClase("caracteresEspeciales");
}

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
    var submitButton = A.one('#<portlet:namespace />btn-enviar');
    submitButton.set('disabled', true);


    A.one('#<portlet:namespace />fma').on('keyup', function(event) {

    var passwordField = A.one('#<portlet:namespace />inputcrearpass');
    var passwordValue = passwordField.get('value');
    var passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*()_+={}:;'"\\|,.<>/?~`-])[A-Za-z\d!@#$%^&*()_+={}:;'"\\|,.<>/?~`-]{8,}$/;
    if (!passwordRegex.test(passwordValue)) {
    submitButton.set('disabled', true);
    }else{
    submitButton.set('disabled', false);
    }
    });
    });
</aui:script>