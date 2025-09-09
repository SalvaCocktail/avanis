<%@ page import="com.liferay.portal.kernel.servlet.SessionErrors" %>
<%@ include file="./init.jsp" %>

<portlet:renderURL var="view2recuperarPass">
    <portlet:param name="mvcPath" value="/request-reset-password.jsp"/>
</portlet:renderURL>

<portlet:renderURL var="newRegistro">
    <portlet:param name="mvcPath" value="/register_acount.jsp"/>
</portlet:renderURL>

<%
    if(!SessionErrors.isEmpty(renderRequest)){
%>
<style>
    .alert-danger {
        display: none;
    }
    .custom-error .alert-danger {
        display: inherit;
    }
</style>
<%   } %>
<div class="custom-error">
    <liferay-ui:error
            key="error.credenciales"
            message="avanis.login.mensaje.error.credenciales"
    />
</div>

<c:if test="${fn:contains(URL, 'login')}">

<portlet:actionURL name="/login/login" var="loginURL"/>

<div id="loginCount">
    <h2><liferay-ui:message key="avanis.titulo.login"/></h2>
    <aui:form action="${loginURL}" autocomplete='on' cssClass="sign-in-form" method="post" name="loginForm">
        <div class="av-form-content">
            <aui:input name="saveLastPath" type="hidden" value="<%= false %>" />

            <aui:input  cssClass="clearable" label="E-mail *" name="login" showRequiredLabel="<%= false %>" type="email" value="${login}">
                <aui:validator name="required" />
            </aui:input>

            <div class="av-pass-visibility__container">
                <aui:input label="Contrase&#241;a *" name="password" showRequiredLabel="<%= false %>" type="password" value="${password}">
                    <aui:validator name="required" />
                </aui:input>
                <div class="av-pass-visibility__toggle-icon"></div>
            </div>
        </div>
        <div class="av-info-message">
            <a href="<%=view2recuperarPass%>"><liferay-ui:message key="avanis.olvidar.pass"/></a>
        </div>
        <div class="checkbox-keep-connected">
            <div class="av-checkbox">
                <label for="keep-connected"><liferay-ui:message key="avanis.mantener.sesion"/></label>
                <input id="keep-connected" type="checkbox" name="<portlet:namespace />rememberMe">
                <span></span>
            </div>
        </div>
        <aui:button-row>
            <aui:button cssClass="btn-lg" type="submit" value="sign-in" />
        </aui:button-row>
        <div class="my-3">
            <p class="mb-1">
                <strong>
                    <liferay-ui:message key="avanis.siloprefieres"/>
                </strong>
            </p>
            <div class="av-social-login">
                <div>
                    <div class="av-social-login-google"><a href="${urlsessionGoogle}">
                        <button type="button" class="google mb-2 undefined" style="background-color: rgb(255, 255, 255); display: inline-flex; align-items: center; color: rgba(0, 0, 0, 0.54); box-shadow: rgba(0, 0, 0, 0.24) 0px 2px 2px 0px, rgba(0, 0, 0, 0.24) 0px 0px 1px 0px; padding: 0px; border-radius: 2px; border: 1px solid transparent; font-size: 14px; font-weight: 500; font-family: Roboto, sans-serif;">
                            <div style="margin-right: 10px; background: rgb(255, 255, 255); padding: 10px; border-radius: 2px;">
                                <svg width="18" height="18" xmlns="http://www.w3.org/2000/svg">
                                    <g fill="#000" fill-rule="evenodd">
                                        <path d="M9 3.48c1.69 0 2.83.73 3.48 1.34l2.54-2.48C13.46.89 11.43 0 9 0 5.48 0 2.44 2.02.96 4.96l2.91 2.26C4.6 5.05 6.62 3.48 9 3.48z" fill="#EA4335"></path>
                                        <path d="M17.64 9.2c0-.74-.06-1.28-.19-1.84H9v3.34h4.96c-.1.83-.64 2.08-1.84 2.92l2.84 2.2c1.7-1.57 2.68-3.88 2.68-6.62z" fill="#4285F4"></path>
                                        <path d="M3.88 10.78A5.54 5.54 0 0 1 3.58 9c0-.62.11-1.22.29-1.78L.96 4.96A9.008 9.008 0 0 0 0 9c0 1.45.35 2.82.96 4.04l2.92-2.26z" fill="#FBBC05"></path>
                                        <path d="M9 18c2.43 0 4.47-.8 5.96-2.18l-2.84-2.2c-.76.53-1.78.9-3.12.9-2.38 0-4.4-1.57-5.12-3.74L.97 13.04C2.45 15.98 5.48 18 9 18z" fill="#34A853"></path>
                                        <path fill="none" d="M0 0h18v18H0z"></path>
                                    </g>
                                </svg>
                            </div>
                            <span style="padding: 10px 10px 10px 0px; font-weight: 500;"><liferay-ui:message key="avanis.acceder.google"/></span>
                        </button></a>
                    </div>
                </div>
            </div>
        </div>
        <p class="mb-1">
            <strong>
                <liferay-ui:message key="avanis.preguntar.cuenta"/>
            </strong>
        </p>
        <a href="/tipo-registro" id="createCount"><liferay-ui:message key="avanis.crear.cuenta"/></a>
    </aui:form>
</div>

</c:if>

<script>
    Liferay.on('allPortletsReady', function () {
        // Función para el toggle de la visibilidad de la contraseña
        // Se usa <svg> para evitar un pestañeo en el clic si se usa <img src="/o/theme-avanis/images/icons/assets-icons/eye-icon.svg" alt="">
        function togglePasswordVisibility(inputField, eyeIcon) {
            if (inputField.type === "password") {
                inputField.type = "text";
                // Visible
                eyeIcon.innerHTML = `<svg width="22" height="20" viewBox="0 0 22 16" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <path fill-rule="evenodd" clip-rule="evenodd" d="M2.51203 7.99997C3.74775 11.4965 7.08286 14 11.0002 14C14.9175 14 18.2526 11.4966 19.4884 8.00003C18.2527 4.50345 14.9175 2 11.0002 2C7.08286 2 3.74776 4.50342 2.51203 7.99997ZM0.50396 7.70031C1.90538 3.23842 6.07329 0 11.0002 0C15.9271 0 20.0951 3.23846 21.4965 7.70039C21.5577 7.89546 21.5577 8.10462 21.4965 8.29969C20.095 12.7616 15.9271 16 11.0002 16C6.07329 16 1.90535 12.7615 0.503957 8.29961C0.442691 8.10454 0.442691 7.89538 0.50396 7.70031ZM10.9998 6C9.89519 6 8.99976 6.89543 8.99976 8C8.99976 9.10457 9.89519 10 10.9998 10C12.1043 10 12.9998 9.10457 12.9998 8C12.9998 6.89543 12.1043 6 10.9998 6ZM6.99976 8C6.99976 5.79086 8.79062 4 10.9998 4C13.2089 4 14.9998 5.79086 14.9998 8C14.9998 10.2091 13.2089 12 10.9998 12C8.79062 12 6.99976 10.2091 6.99976 8Z" fill="#101717"/>
                    </svg>`;
            } else {
                inputField.type = "password";
                // Oculta
                eyeIcon.innerHTML = `<svg width="22" height="20" viewBox="0 0 22 20" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <path fill-rule="evenodd" clip-rule="evenodd" d="M1.29289 0.292893C1.68342 -0.0976311 2.31658 -0.0976311 2.70711 0.292893L20.7071 18.2929C21.0976 18.6834 21.0976 19.3166 20.7071 19.7071C20.3166 20.0976 19.6834 20.0976 19.2929 19.7071L16.2528 16.667C14.6914 17.5171 12.901 18 11.0002 18C6.07329 18 1.90535 14.7615 0.503957 10.2996C0.442691 10.1045 0.442691 9.89538 0.50396 9.70031C1.15664 7.6223 2.4081 5.8117 4.05511 4.46932L1.29289 1.70711C0.902369 1.31658 0.902369 0.683417 1.29289 0.292893ZM5.47827 5.89249C4.13145 6.9405 3.0909 8.36224 2.51203 9.99998C3.74775 13.4966 7.08286 16 11.0002 16C12.345 16 13.6193 15.7056 14.7638 15.178L13.0318 13.446C12.4364 13.7977 11.7414 14 11 14C8.79086 14 7 12.2091 7 10C7 9.25869 7.20228 8.56365 7.55396 7.96818L5.47827 5.89249ZM9.06758 9.48179C9.02347 9.64697 9 9.82063 9 10C9 11.1046 9.89543 12 11 12C11.1794 12 11.353 11.9765 11.5182 11.9324L9.06758 9.48179ZM11.0002 4C10.6957 4 10.395 4.01509 10.0988 4.0445C9.54924 4.09908 9.05947 3.6978 9.0049 3.14821C8.95032 2.59863 9.3516 2.10887 9.90118 2.05429C10.2629 2.01836 10.6296 2 11.0002 2C15.9271 2 20.0951 5.23846 21.4965 9.70039C21.5577 9.89546 21.5577 10.1046 21.4965 10.2997C21.1873 11.2838 20.7439 12.208 20.1879 13.0507C19.8837 13.5117 19.2635 13.6388 18.8025 13.3347C18.3415 13.0305 18.2143 12.4103 18.5185 11.9493C18.9165 11.346 19.2437 10.6923 19.4884 10C18.2527 6.50345 14.9175 4 11.0002 4Z" fill="#101717"/>
                    </svg>`;
            }
        }

        const toggleIconPlaceholders = document.querySelectorAll('.av-pass-visibility__toggle-icon');
        toggleIconPlaceholders.forEach(function (placeholder) {
            // Estado inicial (oculta)
            placeholder.innerHTML = `<img src="/o/theme-avanis/images/icons/assets-icons/eye-icon-close.svg" alt="hide password">`;
            placeholder.addEventListener('click', function () {
                const inputField = this.previousElementSibling.querySelector('input[type=password], input[type=text]');
                togglePasswordVisibility(inputField, this);
            });
        });
    });
</script>