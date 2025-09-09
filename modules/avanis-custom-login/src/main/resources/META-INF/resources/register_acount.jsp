<%@ page import="com.liferay.portal.kernel.servlet.SessionErrors" %> <%@ page
import="javax.portlet.PortletRequest" %> <%@ include file="./init.jsp" %> <%@
page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<style>
  .alert-danger {
    display: none;
  }
  .custom-error .alert-danger {
    display: inherit;
  }
</style>
<% PortletRequest portletRequest =
(PortletRequest)request.getAttribute("javax.portlet.request"); boolean
tieneErrores = SessionErrors.contains(portletRequest, "alias.existe"); %>
<portlet:renderURL var="mailSent">
  <portlet:param
    name="mvcPath"
    value="/register_acount_mail_sent.jsp"
  />
</portlet:renderURL>
<portlet:actionURL
  name="/register"
  var="registerURL"
>
  <portlet:param
    name="mvcPath"
    value="/register_acount_mail_sent.jsp"
  />
</portlet:actionURL>

<div class="custom-error">
  <liferay-ui:error
    key="alias.existe"
    message="avanis.register.mensaje.usuario.alias.existe"
  />
</div>

<div class="av-signup-columns">
  <!-- region Left menu -->
  <div class="av-content-left">
    <div>
      <h2 class="av-txt-title">
        Únete al punto de encuentro del sector agroalimentario, gratis y en dos
        pasos
      </h2>
      <ul class="av-txt-list">
        <li>
          <span class="av-icon-post">
            <svg
              width="20"
              height="16"
              viewBox="0 0 20 16"
              fill="none"
              xmlns="http://www.w3.org/2000/svg"
            >
              <path
                fill-rule="evenodd"
                clip-rule="evenodd"
                d="M2.56811 2.50544e-06C2.57873 3.81674e-06 2.58936 5.12804e-06 2.60001 5.12804e-06H5.40001C5.41065 5.12804e-06 5.42128 3.81674e-06 5.4319 2.50544e-06C5.68429 -2.74161e-05 5.93008 -5.6861e-05 6.13824 0.0169504C6.36683 0.0356272 6.63656 0.0796948 6.90799 0.217992C7.28431 0.409739 7.59027 0.7157 7.78202 1.09202C7.92032 1.36345 7.96438 1.63318 7.98306 1.86178C8.00007 2.06993 8.00004 2.31572 8.00001 2.56811C8.00001 2.57873 8 2.58936 8 2.60001V5.40001C8 5.41065 8.00001 5.42128 8.00001 5.4319C8.00004 5.68429 8.00007 5.93008 7.98306 6.13824C7.96438 6.36683 7.92032 6.63656 7.78202 6.90799C7.59027 7.28431 7.28431 7.59027 6.90799 7.78202C6.63656 7.92032 6.36683 7.96438 6.13824 7.98306C5.93008 8.00007 5.68429 8.00004 5.4319 8.00001C5.42128 8.00001 5.41065 8 5.40001 8H2.60001C2.58936 8 2.57873 8.00001 2.56811 8.00001C2.31572 8.00004 2.06993 8.00007 1.86178 7.98306C1.63318 7.96438 1.36345 7.92032 1.09202 7.78202C0.7157 7.59027 0.409739 7.28431 0.217992 6.90799C0.0796948 6.63656 0.0356272 6.36683 0.0169504 6.13824C-5.6861e-05 5.93008 -2.74161e-05 5.68429 2.50544e-06 5.4319C3.81674e-06 5.42128 5.12804e-06 5.41065 5.12804e-06 5.40001V2.60001C5.12804e-06 2.58936 3.81674e-06 2.57873 2.50544e-06 2.56811C-2.74161e-05 2.31572 -5.6861e-05 2.06993 0.0169504 1.86178C0.0356272 1.63318 0.0796947 1.36345 0.217992 1.09202C0.409739 0.7157 0.7157 0.409739 1.09202 0.217992C1.36345 0.0796947 1.63318 0.0356272 1.86178 0.0169504C2.06993 -5.6861e-05 2.31572 -2.74161e-05 2.56811 2.50544e-06ZM2.01145 2.01145C2.01107 2.0156 2.01069 2.02 2.01031 2.02464C2.00078 2.14122 2.00001 2.30348 2.00001 2.60001V5.40001C2.00001 5.69653 2.00078 5.85879 2.01031 5.97537C2.01069 5.98001 2.01107 5.98441 2.01145 5.98856C2.0156 5.98894 2.02 5.98932 2.02464 5.9897C2.14122 5.99923 2.30348 6.00001 2.60001 6.00001H5.40001C5.69653 6.00001 5.85879 5.99923 5.97537 5.9897C5.98001 5.98932 5.98441 5.98894 5.98856 5.98856C5.98894 5.98441 5.98932 5.98001 5.9897 5.97537C5.99923 5.85879 6.00001 5.69653 6.00001 5.40001V2.60001C6.00001 2.30348 5.99923 2.14122 5.9897 2.02464C5.98932 2.02 5.98894 2.0156 5.98856 2.01145C5.98441 2.01107 5.98001 2.01069 5.97537 2.01031C5.85879 2.00078 5.69653 2.00001 5.40001 2.00001H2.60001C2.30348 2.00001 2.14122 2.00078 2.02464 2.01031C2.02 2.01069 2.0156 2.01107 2.01145 2.01145ZM10 3.00001C10 2.44772 10.4477 2.00001 11 2.00001H19C19.5523 2.00001 20 2.44772 20 3.00001C20 3.55229 19.5523 4.00001 19 4.00001H11C10.4477 4.00001 10 3.55229 10 3.00001ZM10 7.00001C10 6.44772 10.4477 6.00001 11 6.00001H19C19.5523 6.00001 20 6.44772 20 7.00001C20 7.55229 19.5523 8 19 8H11C10.4477 8 10 7.55229 10 7.00001ZM5.12804e-06 11C5.12804e-06 10.4477 0.44772 10 1.00001 10H19C19.5523 10 20 10.4477 20 11C20 11.5523 19.5523 12 19 12H1.00001C0.44772 12 5.12804e-06 11.5523 5.12804e-06 11ZM5.12804e-06 15C5.12804e-06 14.4477 0.44772 14 1.00001 14H11C11.5523 14 12 14.4477 12 15C12 15.5523 11.5523 16 11 16H1.00001C0.44772 16 5.12804e-06 15.5523 5.12804e-06 15Z"
                fill="#101717"
              />
            </svg>
          </span>
          <div>
            Visualiza, sin límites, todos los vídeos y noticias del sector.
          </div>
        </li>
        <li>
          <span class="av-icon-message-square-chat">
            <svg
              width="18"
              height="18"
              viewBox="0 0 18 18"
              fill="none"
              xmlns="http://www.w3.org/2000/svg"
            >
              <path
                fill-rule="evenodd"
                clip-rule="evenodd"
                d="M4.16146 8.6011e-07H11.8385C12.3657 -1.70213e-05 12.8205 -3.25181e-05 13.195 0.0305713C13.5904 0.0628723 13.9836 0.134188 14.362 0.326982C14.9265 0.614602 15.3854 1.07354 15.673 1.63803C15.8658 2.01641 15.9371 2.40963 15.9694 2.80497C16 3.17955 16 3.63432 16 4.16148V5.17825C16.1219 5.21747 16.2427 5.26619 16.362 5.32698C16.9265 5.6146 17.3854 6.07354 17.673 6.63803C17.8658 7.01641 17.9371 7.40963 17.9694 7.80497C18 8.17954 18 8.6343 18 9.16144V17C18 17.3688 17.797 17.7077 17.4719 17.8817C17.1467 18.0557 16.7522 18.0366 16.4453 17.8321L14.2515 16.3695C13.9232 16.1506 13.8569 16.1108 13.7945 16.0835C13.7226 16.0521 13.6472 16.0293 13.5699 16.0155C13.5029 16.0036 13.4257 16 13.0311 16H8.16148C7.63432 16 7.17955 16 6.80497 15.9694C6.40963 15.9371 6.01641 15.8658 5.63803 15.673C5.09817 15.3979 4.65484 14.9662 4.3656 14.4352L1.44722 15.8944C1.13723 16.0494 0.769087 16.0329 0.474271 15.8507C0.179454 15.6684 1.81378e-06 15.3466 1.81378e-06 15L8.60109e-07 4.16146C-1.70213e-05 3.63431 -3.25181e-05 3.17955 0.0305713 2.80497C0.0628723 2.40963 0.134188 2.01641 0.326982 1.63803C0.614602 1.07354 1.07354 0.614602 1.63803 0.326982C2.01641 0.134188 2.40963 0.0628723 2.80497 0.0305712C3.17955 -3.25181e-05 3.63431 -1.70213e-05 4.16146 8.6011e-07ZM4.00143 12.3813C3.99999 12.21 3.99999 12.029 4 11.8385V9.16146C3.99998 8.63431 3.99997 8.17955 4.03057 7.80497C4.06287 7.40963 4.13419 7.01641 4.32698 6.63803C4.6146 6.07354 5.07354 5.6146 5.63803 5.32698C6.01641 5.13419 6.40963 5.06287 6.80497 5.03057C7.17955 4.99997 7.63431 4.99998 8.16146 5H13.8385C13.8931 5 13.947 5 14 5.00003V4.2C14 3.62345 13.9992 3.25118 13.9761 2.96784C13.9539 2.69617 13.9162 2.59546 13.891 2.54601C13.7951 2.35785 13.6422 2.20487 13.454 2.109C13.4045 2.0838 13.3038 2.04612 13.0322 2.02393C12.7488 2.00078 12.3766 2 11.8 2H4.2C3.62345 2 3.25117 2.00078 2.96784 2.02393C2.69617 2.04612 2.59546 2.0838 2.54601 2.109C2.35785 2.20487 2.20487 2.35785 2.109 2.54601C2.0838 2.59546 2.04612 2.69617 2.02393 2.96784C2.00078 3.25118 2 3.62345 2 4.2V13.382L4.00143 12.3813ZM6.96784 7.02393C6.69617 7.04612 6.59546 7.0838 6.54601 7.109C6.35785 7.20487 6.20487 7.35785 6.109 7.54601C6.0838 7.59546 6.04612 7.69617 6.02393 7.96784C6.00078 8.25117 6 8.62345 6 9.2V11.8C6 12.3766 6.00078 12.7488 6.02393 13.0322C6.04612 13.3038 6.0838 13.4045 6.109 13.454C6.20487 13.6422 6.35785 13.7951 6.54601 13.891C6.59546 13.9162 6.69617 13.9539 6.96784 13.9761C7.25117 13.9992 7.62345 14 8.2 14H13.0311C13.0516 14 13.0719 14 13.092 14C13.3924 13.9998 13.6574 13.9996 13.9209 14.0466C14.1527 14.0879 14.3789 14.1564 14.5947 14.2506C14.84 14.3577 15.0604 14.5048 15.3102 14.6716C15.327 14.6828 15.3438 14.694 15.3609 14.7054L16 15.1315V9.2C16 8.62345 15.9992 8.25117 15.9761 7.96784C15.9539 7.69617 15.9162 7.59546 15.891 7.54601C15.7951 7.35785 15.6422 7.20487 15.454 7.109C15.4045 7.0838 15.3038 7.04612 15.0322 7.02393C14.7488 7.00078 14.3766 7 13.8 7H8.2C7.62345 7 7.25118 7.00078 6.96784 7.02393Z"
                fill="#101717"
              />
            </svg>
          </span>
          <div>
            Accede a la comunidad, comenta y conecta con otras personas.
          </div>
        </li>
        <li>
          <span class="av-icon-map-point">
            <svg
              width="16"
              height="20"
              viewBox="0 0 16 20"
              fill="none"
              xmlns="http://www.w3.org/2000/svg"
            >
              <path
                fill-rule="evenodd"
                clip-rule="evenodd"
                d="M8 2C4.71266 2 2 4.74909 2 8.2C2 9.87993 2.73594 11.4696 3.98798 13.1418C5.04663 14.5557 6.40151 15.9381 7.86237 17.4286C7.90815 17.4753 7.95402 17.5221 8 17.569C8.04598 17.5221 8.09185 17.4753 8.13763 17.4286C9.59849 15.9381 10.9534 14.5557 12.012 13.1418C13.2641 11.4696 14 9.87993 14 8.2C14 4.74909 11.2873 2 8 2ZM0 8.2C0 3.69801 3.55535 0 8 0C12.4446 0 16 3.69801 16 8.2C16 10.4965 14.9859 12.5068 13.613 14.3405C12.4671 15.871 11.0003 17.3666 9.54112 18.8543C9.2654 19.1355 8.98995 19.4163 8.717 19.6971C8.52871 19.8907 8.2701 20 8 20C7.7299 20 7.47129 19.8907 7.28301 19.6971C7.01005 19.4163 6.7346 19.1355 6.45888 18.8543C4.99974 17.3666 3.53292 15.871 2.38702 14.3405C1.01406 12.5068 0 10.4965 0 8.2ZM8 6C6.89543 6 6 6.89543 6 8C6 9.10457 6.89543 10 8 10C9.10457 10 10 9.10457 10 8C10 6.89543 9.10457 6 8 6ZM4 8C4 5.79086 5.79086 4 8 4C10.2091 4 12 5.79086 12 8C12 10.2091 10.2091 12 8 12C5.79086 12 4 10.2091 4 8Z"
                fill="#101717"
              />
            </svg>
          </span>
          <div>Recibe alertas meteorológicas y cuida tu explotación.</div>
        </li>
      </ul>
    </div>
  </div>
  <!-- endregion Left menu -->

  <!-- #region Form Login con Google -->
  <div class="av-content-form js-av-content-form--social-google">
    <div class="av-content-right">
      <!-- Form -->
      <div id="loginCount">
        <h2 class="js-prueba-multiselect">Crear mi cuenta</h2>
        <div class="js-prueba-container"></div>

        <div class="my-3 av-form-content">
          <div class="av-social-login">
            <div>
              <div class="av-social-login-google">
                <a
                  href="${urlsessionGoogle}"
                  class="google mb-2 undefined btn-100x100 btn-social-google"
                >
                  <svg
                    width="18"
                    height="18"
                    xmlns="http://www.w3.org/2000/svg"
                  >
                    <g
                      fill="#000"
                      fill-rule="evenodd"
                    >
                      <path
                        d="M9 3.48c1.69 0 2.83.73 3.48 1.34l2.54-2.48C13.46.89 11.43 0 9 0 5.48 0 2.44 2.02.96 4.96l2.91 2.26C4.6 5.05 6.62 3.48 9 3.48z"
                        fill="#EA4335"
                      ></path>
                      <path
                        d="M17.64 9.2c0-.74-.06-1.28-.19-1.84H9v3.34h4.96c-.1.83-.64 2.08-1.84 2.92l2.84 2.2c1.7-1.57 2.68-3.88 2.68-6.62z"
                        fill="#4285F4"
                      ></path>
                      <path
                        d="M3.88 10.78A5.54 5.54 0 0 1 3.58 9c0-.62.11-1.22.29-1.78L.96 4.96A9.008 9.008 0 0 0 0 9c0 1.45.35 2.82.96 4.04l2.92-2.26z"
                        fill="#FBBC05"
                      ></path>
                      <path
                        d="M9 18c2.43 0 4.47-.8 5.96-2.18l-2.84-2.2c-.76.53-1.78.9-3.12.9-2.38 0-4.4-1.57-5.12-3.74L.97 13.04C2.45 15.98 5.48 18 9 18z"
                        fill="#34A853"
                      ></path>
                      <path
                        fill="none"
                        d="M0 0h18v18H0z"
                      ></path>
                    </g>
                  </svg>
                  <span style="padding: 10px 10px 10px 0px; font-weight: 500">
                    <liferay-ui:message key="avanis.acceder.google" />
                  </span>
                </a>
              </div>
            </div>
          </div>
          <p class="mb-2">
            <strong>
              <liferay-ui:message key="avanis.siloprefieres" />
            </strong>
          </p>

          <div class="av-buttons-tipo-registro js-btn-register-email">
            <aui:button
              label=""
              href="javascript:void(0);"
              type="button"
              name=""
              cssClass="av-theme__btn av-theme__btn--primary btn-100x100"
              value="Regístrate con tu email"
            >
            </aui:button>
          </div>
        </div>
        <p class="av-info-txt">
          <liferay-ui:message key="avanis.politica.privacidad.tipo.registro" />
        </p>
      </div>
    </div>
  </div>
  <!-- #endregion Form Login con Google -->

  <!-- #region Form Login con Email -->
  <div class="av-content-form js-av-content-form--email av-cl-hidden">
    <div class="av-content-right">
      <h2>Crear mi cuenta</h2>
      <!-- Form -->
      <aui:form
        action="<%= registerURL %>"
        autocomplete="on"
        cssClass="sign-in-form"
        method="post"
        name="registerForm"
      >
        <div class="av-form-content">
          <div class="av-columns">
            <div class="av-input-wrapper">
              <div class="av-input-wrapper">
                <aui:input
                  id="email"
                  type="email"
                  placeholder="Email"
                  name="email"
                  label="avanis.campo.mail"
                  value=""
                >
                  <aui:validator name="email" />
                  <aui:validator name="required" />
                </aui:input>
              </div>
            </div>
            <div class="av-input-wrapper">
              <div class="av-input-wrapper">
                <aui:input
                  id="phone"
                  label="avanis.campo.telefono"
                  type="text"
                  placeholder="Tel&#233;fono"
                  name="phone"
                  value=""
                >
                  <aui:validator name="number" />
                </aui:input>
              </div>
            </div>
          </div>
          <div class="av-input-wrapper">
            <div class="av-input-wrapper">
              <aui:input
                id="alias"
                type="text"
                label="avanis.campo.usuario"
                placeholder="Escribe tu nombre de usuario"
                name="alias"
                value=""
              >
                <aui:validator name="required" />
                <aui:validator
                  name="max"
                  errorMessage="El nombre de usuario no puede exceder los 75 caracteres"
                  >75</aui:validator
                >
                <aui:validator
                  name="custom"
                  errorMessage="El nombre de usuario debe contener unicamente texto y/o n&uacute;meros, ningun otro car&aacute;cter"
                >
                  function (val, fieldNode, ruleValue) { let pattern =
                  /^[a-zA-Z0-9^-]{0,75}?$/; let result = pattern.test(val);
                  return result; }
                </aui:validator>
              </aui:input>
            </div>
            <p class="av-input-disclaimer">
              <liferay-ui:message key="avanis.info.usuario" />
            </p>
          </div>
          <div class="av-columns">
            <div class="av-input-wrapper">
              <div class="av-input-wrapper">
                <aui:input
                  id="name"
                  type="text"
                  placeholder="Nombre"
                  name="name"
                  label="avanis.campo.nombre"
                  value=""
                >
                  <aui:validator name="required" />

                  <aui:validator
                          name="custom"
                          errorMessage="El nombre no puede contener etiquetas HTML ni caracteres especiales"
                  >
                            function(val, fieldNode, ruleValue) {
                              // No permite los caracteres < o > ni ninguna etiqueta HTML
                              return !(/[]/.test(val) || /<\/?[\w\s="/.':;#-\/\?]+>/.test(val));
                            }
                  </aui:validator>


                </aui:input>
              </div>
            </div>
            <div class="av-input-wrapper">
              <div class="av-input-wrapper">
                <aui:input
                  id="apellidos"
                  type="text"
                  placeholder="Apellidos"
                  name="apellidos"
                  label="avanis.campo.apellidos"
                  value=""
                >
                  <aui:validator name="required" />
                </aui:input>
              </div>
            </div>
          </div>
          <!-- Password input + visibility icon -->
          <div class="av-pass-visibility__container">
            <aui:input
              id="password"
              type="password"
              placeholder="Contraseña"
              name="password"
              label="avanis.campo.pass"
              value=""
            >
              <aui:validator name="required" />
            </aui:input>
            <div
              class="av-pass-visibility__toggle-icon av-pass-visibility__toggle-icon__register"
            ></div>
          </div>
        </div>
        <!-- Pass security -->
        <div class="av-security">
          <liferay-ui:message key="avanis.info.pass" />
        </div>
        <p class="av-mandatory-legend">
          <liferay-ui:message key="avanis.info.marcados" />
        </p>

        <!-- Newsletter -->
        <div class="av-input-wrapper">
          <div class="av-checkbox av-checkbox-toggle">
            <aui:input
              name="allowNewsLetter"
              type="checkbox"
              label="avanis.campo.recibir.correos"
              id="allowNewsLetter"
            >
            </aui:input>
            <span class="av-checkbox-span">
              <svg
                width="12"
                height="9"
                viewBox="0 0 12 9"
                fill="none"
                xmlns="http://www.w3.org/2000/svg"
              >
                <path
                  fill-rule="evenodd"
                  clip-rule="evenodd"
                  d="M11.7032 0.288997C12.0959 0.677358 12.0994 1.31051 11.711 1.70319L4.78793 8.70319C4.60008 8.89312 4.34406 9 4.07692 9C3.80979 9 3.55376 8.89312 3.36592 8.70319L0.288998 5.59208C-0.0993633 5.1994 -0.0958652 4.56625 0.296811 4.17789C0.689487 3.78953 1.32264 3.79302 1.711 4.1857L4.07692 6.57791L10.289 0.296811C10.6774 -0.0958652 11.3105 -0.0993633 11.7032 0.288997Z"
                  fill="white"
                />
              </svg>
            </span>
          </div>
        </div>

        <!-- Consentimiento -->
        <div class="av-input-wrapper">
          <div class="av-checkbox av-checkbox-toggle">
            <aui:input
                    name="allowNotifications"
                    type="checkbox"
                    label="avanis.campo.recibir.notificaciones"
                    id="allowNotifications"
            >
            </aui:input>
            <span class="av-checkbox-span">
              <svg
                      width="12"
                      height="9"
                      viewBox="0 0 12 9"
                      fill="none"
                      xmlns="http://www.w3.org/2000/svg"
              >
                <path
                        fill-rule="evenodd"
                        clip-rule="evenodd"
                        d="M11.7032 0.288997C12.0959 0.677358 12.0994 1.31051 11.711 1.70319L4.78793 8.70319C4.60008 8.89312 4.34406 9 4.07692 9C3.80979 9 3.55376 8.89312 3.36592 8.70319L0.288998 5.59208C-0.0993633 5.1994 -0.0958652 4.56625 0.296811 4.17789C0.689487 3.78953 1.32264 3.79302 1.711 4.1857L4.07692 6.57791L10.289 0.296811C10.6774 -0.0958652 11.3105 -0.0993633 11.7032 0.288997Z"
                        fill="white"
                />
              </svg>
            </span>
            <!-- <label class="av-label-newsletter" for="allowNewsLetter">
                            <%-- <liferay-ui:message key="avanis.campo.recibir.correos" /> --%>
                        </label> -->
          </div>
        </div>
        <!-- Buttons -->
        <div class="av-buttons av-buttons-fixed">
          <aui:button
            label=""
            type="submit"
            name="btnenvioregistro"
            cssClass="av-theme__btn av-theme__btn--primary btn-100x100"
            value="avanis.crear.cuenta"
          >
            <a href="<%= mailSent %>"></a
          ></aui:button>
        </div>
        <div class="av-gotologin">
          <p><liferay-ui:message key="avanis.preguntar.tienes.cuenta" /></p>
          <a
            href="/login"
            id="backLoginCount"
            ><liferay-ui:message key="avanis.iniciar.sesion"
          /></a>
        </div>
      </aui:form>

      <!-- Private policy -->
      <p class="av-info-txt">
        <liferay-ui:message key="avanis.politica.privacidad" />
      </p>
    </div>
  </div>
  <!-- #endregion Form Login con Email -->

  <!-- Creo el modal -->
  <div class="modal-privacity">
    <div
      class="modal fade"
      id="cookiePolicyModal"
      tabindex="-1"
      aria-labelledby="cookiePolicyModalLabel"
      aria-hidden="true"
    >
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button
              type="button"
              class="close"
              data-dismiss="modal"
              aria-label="Cerrar"
            >
              <span
                class="avanis-mdoal-span"
                aria-hidden="true"
                >&times;</span
              >
            </button>
          </div>
          <div class="modal-body">
            <liferay-ui:message key="avanis.politica.privacidad.modal" />
          </div>
          <div class="modal-footer">
            <button
              type="button"
              class="btn btn-secondary"
              data-dismiss="modal"
            >
              Aceptar y cerrar
            </button>
          </div>
        </div>
      </div>
    </div>
  </div>

  <div class="modal-use-cases">
    <div
      class="modal fade"
      id="conditionCasesModal"
      tabindex="-1"
      aria-labelledby="conditionCasesLabel"
      aria-hidden="true"
    >
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button
              type="button"
              class="close"
              data-dismiss="modal"
              aria-label="Cerrar"
            >
              <span
                class="avanis-mdoal-span"
                aria-hidden="true"
                >×</span
              >
            </button>
          </div>
          <div class="modal-body">
            <div class="av-content">
              <h1>CONDICIONES DE USO</h1>
              <p>
                Las presentes Condiciones Generales de Contratación (en
                adelante, las Condiciones de Uso) regulan las relaciones entre
                los Usuarios de Internet (en adelante, el Usuario o los
                Usuarios) y
                <strong>SANTANDER NEW BUSINESS, S.A.</strong>, con email de
                contacto legal@avanis.es, con domicilio social en Calle Juan
                Ignacio Luca de Tena 11, 28027 - Madrid y con NIF A56392350 (en
                adelante, <strong>AVANIS</strong>) en lo que se refiere al
                acceso y la utilización de la Plataforma Avanis (en adelante,
                <strong>PLATAFORMA</strong>).
              </p>
              <p>
                Las Condiciones de Uso que aquí se recogen son aplicables a
                todas las formas de acceso que se hagan a LA PLATAFORMA,
                incluyendo Internet, vía móvil o cualquier otro dispositivo y
                serán de aplicación de forma conjunta con el Aviso Legal, la
                Política de Privacidad y la Política de Cookies y cualquier otro
                documento que regule aspectos de LA PLATAFORMA.
              </p>
              <p>
                LA PLATAFORMA es una comunidad dirigida a los profesionales del
                sector agropecuario en la que estos pueden acceder a contenidos
                de interés del sector, interactuar con otros Usuarios y subir
                contenidos.
              </p>
              <h2>Formalización</h2>
              <p>
                El registro y la creación de un Perfil de Usuario en LA
                PLATAFORMA constituye la formalización de un contrato con AVANIS
                para el uso de LA PLATAFORMA. El registro por parte de los
                Usuarios en LA PLATAFORMA es gratuito y está sujeto a la previa
                aceptación de forma expresa de todas las Condiciones de Uso
                vigentes en cada momento.
              </p>
              <p>
                Si algún Usuario no estuviese de acuerdo con el contenido o
                parte del contenido de las presentes Condiciones de Uso no podrá
                registrarse en LA PLATAFORMA, no pudiendo acceder ni disponer de
                los servicios que en esta se ofrecen. Se recomienda que el
                Usuario lea atentamente las presentes Condiciones de Uso cada
                vez que acceda o utilice algún servicio a través de LA
                PLATAFORMA, ya que podrían sufrir modificaciones.
              </p>
              <p>
                Cuando los Usuarios realizan el registro en LA PLATAFORMA
                recibirán un e-mail de confirmación.
              </p>
              <p>
                El Usuario declara y garantiza ser mayor de edad y disponer de
                la capacidad jurídica suficiente para vincularse por las
                Condiciones de Uso y que toda la información proporcionada es
                verdadera, precisa, actual y completa. Igualmente, acepta de
                forma expresa y sin excepciones que el acceso y la utilización
                de LA PLATAFORMA y de los contenidos tiene lugar bajo su única y
                exclusiva responsabilidad.
              </p>
              <p>
                AVANIS se reserva el derecho de efectuar los cambios y las
                modificaciones que considere oportunas en LA PLATAFORMA y en las
                presentes Condiciones de Uso. Las modificaciones de las
                Condiciones de Uso se notificarán a los Usuarios en un soporte
                duradero con un plazo de antelación mínimo de quince (15) días.
                Por ello, AVANIS avisará a los Usuarios sobre cambios
                sustanciales en estas Condiciones de Uso, ya sea enviando un
                aviso a la dirección de correo electrónico que los Usuarios
                hayan facilitado o colocando un aviso en LA PLATAFORMA.
              </p>
              <h2>Perfil de Usuario</h2>
              <p>
                Para crear un Perfil de Usuario, el Usuario debe proporcionar
                información relativa a su email, nombre, apellidos, teléfono,
                país, localidad y provincia, así como crear una contraseña.
                Opcionalmente, podrá subir una imagen a su Perfil de Usuario.
              </p>
              <p>
                Los datos solicitados son necesarios para poder finalizar el
                proceso de registro con éxito, por lo que, si no se cumplimentan
                todos los apartados obligatorios, el Usuario no podrá
                registrarse. Los Usuarios también podrán seleccionar los
                sectores de interés a los que se dedican para que AVANIS pueda
                ofrecerles contenido personalizado.
              </p>
              <p>
                Cuando el Usuario se registra cumplimentando el Formulario de
                Registro reconoce haber tenido conocimiento del contenido de las
                presentes Condiciones de Uso y declara expresamente que las
                acepta.
              </p>
              <p>
                Cada Usuario solo podrá tener un Perfil de Usuario en LA
                PLATAFORMA y no podrá ser compartida con terceros, alquilada,
                cedida o transmitida ni de forma gratuita ni de forma onerosa.
              </p>
              <p>
                Los Usuarios serán responsables de la adecuada custodia y
                confidencialidad de cualquier contraseña y se comprometen a no
                ceder su uso a terceros, ni a permitir su acceso a personas
                ajenas. Será responsabilidad de los Usuarios la utilización
                ilícita de LA PLATAFORMA por cualquier tercero ilegítimo que
                emplee una contraseña a causa de una utilización no diligente o
                de la pérdida de la misma por el Usuario.
              </p>
              <p>
                El Usuario tiene la obligación de notificar de forma inmediata a
                AVANIS cualquier hecho que conlleve el uso indebido de las
                contraseñas, tales como el extravío o el acceso no autorizado
                con el fin de proceder a su inmediata cancelación.
              </p>
              <h2>Contenido de Usuario</h2>
              <p>
                Los Usuarios son los únicos responsables sobre los contenidos,
                información, comentarios y/o mensajes (en adelante, el
                Contenido) que puedan realizar, compartir y/o subir en su
                Perfil, en el Perfil de otros Usuarios y/o al interactuar a
                través de los servicios de LA PLATAFORMA, así como en los
                mensajes que pudieran intercambiar con otros Usuarios. Por lo
                tanto, los Usuarios garantizan a AVANIS que ostentan los
                permisos, títulos y las autorizaciones de todos los derechos
                sobre dicho Contenido, así como la autorización de los titulares
                de los datos de carácter personal y/o de las imágenes que puedan
                incluirse en dicho Contenido, manteniendo por lo tanto indemne a
                AVANIS por cualquier reclamación. Los Usuarios tendrán la
                posibilidad de establecer la configuración en su Perfil de
                Usuario para decidir quien puede ver su Contenido y la
                información de su Perfil.
              </p>
              <p>
                Los Usuarios se comprometen a que el Contenido subido,
                compartido y/o publicado en LA PLATAFORMA no será
                discriminatorio y no incluirá terminología sobre drogas o de
                carácter sexual; ni atentará contra la dignidad de cualquier
                persona por razón de raza, religión, etnia, país de origen,
                sexo, identidad sexual, orientación sexual, enfermedad y/o
                discapacidad. Tampoco podrán justificar, enaltecer y/o negar
                delitos de terrorismo, genocidio, de lesa humanidad o
                relacionados con conflictos armados y, en general, garantizan
                que el Contenido no vulnerará los derechos al honor, intimidad e
                imagen, de Propiedad Intelectual o Industrial de AVANIS, ni de
                los Usuarios de LA PLATAFORMA y/o cualquier tercero.
              </p>
              <p>
                Los Usuarios serán propietarios de todo el Contenido que suban a
                LA PLATAFORMA y de los datos personales que faciliten a AVANIS,
                pero conceden una cesión y/o licencia no exclusiva, gratuita,
                perpetua (es decir, hasta el paso al dominio público),
                transferible, irrevocable y totalmente sublicenciable a AVANIS,
                para que pueda usar, reproducir, modificar, adaptar, traducir,
                distribuir, transformar, difundir y comunicar públicamente dicho
                Contenido en todo el mundo, en cualquier medio, modalidad y
                formato, ahora conocido o inventado en el futuro, para cualquier
                propósito relacionado con las actividades de AVANIS y LA
                PLATAFORMA, incluyendo fines publicitarios y para uso comercial,
                por lo que no será necesario consentimiento adicional,
                notificación o compensación para el Usuario y/o ningún tercero.
                Dicha cesión y/o licencia sobre el Contenido de los Usuarios
                finalizará cuando el Usuario eliminase el Contenido o cuando
                eliminase su Perfil de Usuario de LA PLATAFORMA.
              </p>
              <p>
                Los Usuarios quedan informados de que AVANIS recopila los datos
                personales que proporcione al realizar publicaciones, generar
                contenido, comentarios e interactuar en LA PLATAFORMA. AVANIS
                también podrá recopilar las interacciones de los Usuarios cuando
                pulsen el botón “Me gusta” en cualquier publicación. Por ello,
                las publicaciones, comentarios e interacciones en LA PLATAFORMA,
                así como los datos incluidos en el Perfil de Usuario estarán
                accesibles y podrán ser vistos por el resto de los Usuarios de
                LA PLATAFORMA y/o de forma anonimizada en el Área Pública, según
                AVANIS decida en cada momento respetando las preferencias sobre
                el Contenido del Perfil de Usuario.
              </p>
              <h2>Uso de Inteligencia Artificial (IA)</h2>
              <p>
                Los Usuarios quedan informados de que AVANIS emplea tecnologías
                de Inteligencia Artificial (IA) para generar contenido
                especializado. La IA puede crear perfiles de Usuarios
                especialistas y contenidos con los que los Usuarios podrían
                interactuar. LA PLATAFORMA se compromete a identificar
                claramente cuando se trate de un perfil de Usuario generado por
                IA o de contenido creado mediante esta tecnología. Esta
                identificación se realizará de manera transparente y accesible
                para los Usuarios. La finalidad de esta práctica es mejorar la
                experiencia del Usuario y brindar un servicio más eficiente.
                AVANIS se compromete a cumplir con la normativa europea de IA
                vigente y a respetar los derechos y la privacidad de los
                Usuarios en todo momento.
              </p>
              <h2>Derecho de Desistimiento</h2>
              <p>
                Sin perjuicio de la posibilidad de dar de baja el Perfil de
                Usuario en cualquier momento, una vez aceptadas las presentes
                Condiciones de Uso, los Usuarios entienden y aceptan que no
                existirá derecho de desistimiento en virtud de lo establecido en
                el artículo 103, letra m), del Real Decreto Legislativo 1/2007,
                de 16 de noviembre, por el que se aprueba el texto refundido de
                la Ley General para la Defensa de los Consumidores y Usuarios.
              </p>
              <h2>Promociones, eventos y ofertas</h2>
              <p>
                En su caso, AVANIS podrá realizar promociones, eventos y/u
                ofertas a los que se les aplicarán sus propias bases,
                condiciones y términos adicionales, que AVANIS pondrá a
                disposición de los Usuarios antes de dicha contratación. En caso
                de que un Usuario quiera participar en una promoción, un evento
                y/u oferta, deberá leer y estar conforme con sus bases,
                condiciones y términos. Las ofertas, eventos y promociones
                disponibles para los Usuarios serán válidos hasta la fecha
                indicada en LA PLATAFORMA en cada momento y, en su caso, de
                forma individualizada sobre los servicios o productos indicados,
                sin que sean aplicables a otros productos o servicios ofrecidos
                en LA PLATAFORMA.
              </p>
              <h2>Garantías y obligaciones de los Usuarios</h2>
              <p>
                Los Usuarios garantizan y quedan obligados a que toda la
                información de su Perfil de Usuario es veraz, cierta y completa,
                por lo que serán responsables frente a terceros de la
                información que proporcionen. Asimismo, los Usuarios no podrá
                registrarse con información falsa, utilizando nombres o incluir
                términos en su Perfil de Usuario que pretendan suplantar la
                identidad de un tercero, incluyan identidades falsas, injurien,
                vejen, amenacen o vulnerar los derechos al honor, intimidad e
                imagen de cualquier tercero.
              </p>
              <p>
                Los Usuarios entienden y aceptan que AVANIS es titular o
                cesionario de todos los derechos de Propiedad Intelectual e
                Industrial sobre los elementos y el contenido de LA PLATAFORMA.
                Por ello, todos los contenidos, imágenes, fotografías vídeos,
                diseños, marcas, rótulos, signos distintivos, nombres
                comerciales y/o logos de AVANIS y/o de LA PLATAFORMA, así como
                los banners, el software y sus distintos códigos, fuente y
                objeto, algoritmos, medidas tecnológicas y/o cualesquiera otros
                elementos de naturaleza análoga y/o propios de LA PLATAFORMA son
                titularidad de AVANIS o AVANIS es cesionario de los mismos.
              </p>
              <p>
                Los Usuarios garantizan que no cometerán actos y/o que no
                realizarán acciones dirigidas a romper las medidas tecnológicas
                de protección y antipiratería que hubiesen sido implantadas en
                LA PLATAFORMA, entendiéndose por tales aquellos procedimientos,
                técnicas, dispositivos, componentes, o la combinación de éstos,
                cuya función es controlar, impedir o restringir el acceso o la
                utilización de los elementos y/o el contenido de LA PLATAFORMA.
                De lo contrario, AVANIS procederá a resolver de inmediato la
                relación con el Usuario infractor, así como que podrá tomar las
                medidas legales pertinentes.
              </p>
              <p>
                Asimismo, todos los Usuarios garantizan expresamente que no
                infringirán derechos de Propiedad Intelectual o Industrial de
                terceros, los derechos de terceros de ninguna naturaleza, ni
                infringirán el derecho al honor, la intimidad o la propia imagen
                de AVANIS, así como de cualquier otra persona o de terceros y
                que son los únicos responsables, con completa indemnidad a
                AVANIS, de cualquier reclamación (judicial o extrajudicial) que
                surja o pudiera surgir en tal supuesto.
              </p>
              <p>
                Los Usuarios garantizan y quedan obligados a cumplir estas
                Condiciones de Uso, el Aviso Legal y la Política de Privacidad y
                de Cookies de LA PLATAFORMA, respetando el interés público, la
                legalidad vigente y las exigencias de la buena fe.
              </p>
              <h2>Responsabilidad de AVANIS</h2>
              <p>
                AVANIS es considerado como un proveedor de un servicio de
                intermediación, en los términos de la Ley 34/2002, de 11 de
                julio, de servicios de la sociedad de la información y de
                comercio electrónico (LSSI). Por ello, AVANIS no tiene
                obligación y no controla la utilización que los Usuarios hacen
                de LA PLATAFORMA y/o de los contenidos disponibles en LA
                PLATAFORMA. AVANIS no garantiza que los Usuarios utilicen LA
                PLATAFORMA, los contenidos y los servicios ofrecidos de
                conformidad con estas Condiciones de Uso, ni que lo hagan de
                forma diligente y prudente o cumpliendo la legalidad.
              </p>
              <p>
                AVANIS tiene el derecho de oponerse y/o eliminar cualquier
                contenido o actividad que infrinja estas Condiciones de Uso y
                cualquiera de sus Políticas, desde el momento en el que tenga
                conocimiento efectivo, así como de denegar o cancelar el acceso
                a LA PLATAFORMA a cualquier persona o entidad según lo
                establecido en estas Condiciones de Uso y la normativa
                aplicable. Por ello, AVANIS pone a disposición de los Usuarios y
                de terceros un sistema de denuncia unilateral, por el que estos
                podrán notificar cualquier infracción de las presentes
                Condiciones de Uso, de sus Políticas y/o de la legislación en la
                siguiente dirección: datos@avanis.es
              </p>
              <p>
                AVANIS se reserva el derecho a denegar en cualquier momento, sin
                necesidad de aviso previo y sin derecho a indemnización, el
                acceso a LA PLATAFORMA en caso de que&nbsp;AVANIS considere que
                algún Usuario está utilizando o ha utilizado LA PLATAFORMA
                incumpliendo las presentes Condiciones de Uso o la legislación y
                normativa aplicables. AVANIS notificará tal supuesto mediante el
                envío de un correo electrónico a la dirección que figure en su
                Perfil de Usuario. No obstante, AVANIS no tendrá que realizar
                esta notificación al Usuario infractor cuando esté sujeta a una
                obligación legal o reglamentaria relativa a no indicar los
                hechos o circunstancias específicos.
              </p>
              <p>
                Por lo tanto, AVANIS podrá cancelar el Perfil de Usuario por
                causas justificadas, como son, a título meramente enunciativo,
                cuando (i) AVANIS considere razonablemente que un Usuario está
                incumpliendo las Condiciones de Uso o la legislación; (ii) se
                han vulnerado los derechos de AVANIS, de otros Usuarios y/o de
                terceros, como el derecho al honor, a la intimidad o a la propia
                imagen; (iii) se infrinjan los derechos de propiedad intelectual
                e industrial de AVANIS, de terceros y/o de cualquier Usuario;
                (iv) un Perfil de Usuario se crease de forma fraudulenta o se
                utilizase para cometer fraude; (v) se vulneren las medidas
                técnicas de protección, medidas de seguridad y/o se incluyan
                virus u otros archivos maliciosos en LA PLATAFORMA.
              </p>
              <p>
                AVANIS no será responsable de aquellas obligaciones asumidas y/o
                derechos que hubiesen adquirido por la relación establecida y/o
                cualquier contratación realizada entre los Usuarios de LA
                PLATAFORMA por su cuenta, pues como intermediario, serán los
                propios Usuarios los responsables del cumplimiento de los
                compromisos asumidos y adquiridos a estos efectos en cada
                momento. Asimismo, AVANIS no se responsabiliza del
                incumplimiento, ni total ni parcial, de cualquier cuestión
                relativa a los posibles acuerdos alcanzados entre los Usuarios,
                sus condiciones y/o cualesquiera otros extremos en los que no
                interviene.
              </p>
              <p>
                AVANIS tiene el derecho de suspender temporalmente y sin
                preaviso la accesibilidad a LA PLATAFORMA, como por ejemplo en
                el caso de necesidad urgente para el mantenimiento de LA
                PLATAFORMA, actualizaciones de la misma o por razones de
                seguridad de LA PLATAFORMA, así como a reservarse el derecho de
                prestación o cancelación de los servicios, contenidos o de LA
                PLATAFORMA de forma permanente, intentando ponerlo previamente
                en conocimiento de los Usuarios, siempre que las circunstancias
                así se lo permitan.
              </p>
              <p>
                AVANIS no será responsable por los daños y perjuicios que puedan
                producirse por el uso, la imposibilidad de uso y/o de posibles
                fallos en LA PLATAFORMA debidos a la configuración errónea o
                insuficiente del sistema informático de los Usuarios, ni será
                responsable por daños provocados por virus como troyanos o
                programas similares, ni por programas o códigos que provoquen un
                daño, destrucción o inactividad similar del sistema informático
                de los Usuarios. Por ello, cada Usuario deberá adoptar por su
                cuenta las medidas necesarias para protegerse de virus y de
                otros programas maliciosos, instalando por ejemplo un antivirus
                y/o cualesquiera otras medidas que considere para su protección.
              </p>
              <h2>Disposiciones Generales</h2>
              <p>
                Las presentes Condiciones de Uso constituyen el acuerdo total
                entre los Usuarios y AVANIS. Estas Condiciones de Uso solo se
                podrán modificar mediante una corrección escrita firmada por una
                persona autorizada de AVANIS o a través de la publicación de una
                versión revisada de estas.
              </p>
              <p>
                Si cualquier cláusula de las presentes Condiciones de Uso fuese
                declarada total o parcialmente nula o ineficaz afectará tan solo
                a esa disposición o parte de la misma que resulte nula o
                ineficaz, subsistiendo en todo lo demás el resto de las
                Condiciones de Uso y teniéndose tal disposición o la parte de la
                misma que resulte afectada por no puesta salvo que, por resultar
                esencial a las presentes Condiciones de Uso, hubiese de
                afectarlas de manera integral.
              </p>
              <p>
                Los Usuarios podrán dar de baja el Perfil de Usuario de LA
                PLATAFORMA en cualquier momento, sin perjuicio de aquellas
                obligaciones que hubiesen adquirido y/o que pudiesen continuar
                vigentes en su caso, mediante el envío de una comunicación a la
                dirección de correo electrónico soporte@avanis.es, o a través de
                la sección
                <a
                  href="/profile"
                  target="_blank"
                  >“Mi perfil”.</a
                >
              </p>
              <p>
                La baja del Perfil de Usuario conllevará el cierre del Perfil y
                no da derecho al Usuario a indemnización alguna.
              </p>
              <p>
                LA PLATAFORMA y sus contenidos se ofrecen en lengua española,
                aunque podrán estar disponibles en otros idiomas, por lo que,
                ante cualquier conflicto en la aplicación o interpretación de
                estas Condiciones de Uso, el Aviso Legal, las Políticas de
                Privacidad y/o la Política de Cookies de AVANIS, siempre
                prevalecerá la versión en lengua española sobre cualquier otra.
              </p>
              <p>
                Las Condiciones de Uso tendrán vigencia a partir del momento en
                que el Usuario cree su Perfil de Usuario por tiempo indefinido
                en lo que se refiere al uso de LA PLATAFORMA de AVANIS, hasta
                que el Usuario diese de baja su Perfil de Usuario o, por
                cualquier circunstancia, LA PLATAFORMA se cerrase.
              </p>
              <p>
                Ni AVANIS ni los Usuarios serán responsables o incumplidores de
                las presentes Condiciones de Uso en caso de retraso o
                incumplimiento por causas de fuerza mayor, en los supuestos
                contemplados en la legislación.
              </p>
              <p>
                Los Usuarios no podrán ceder total o parcialmente, ni onerosa ni
                gratuitamente, los derechos u obligaciones adquiridos en las
                presentes Condiciones de Uso. Si se incumple esta prohibición,
                se podrá cancelar el Perfil del Usuario, sin perjuicio del
                derecho de AVANIS a ejercitar las acciones judiciales que en su
                caso procedan, así como las correspondientes por daños y
                perjuicios que pudieran producirse por esa causa.
              </p>
              <h2>Ley aplicable y Jurisdicción</h2>
              <p>
                Estas Condiciones de Uso, las Políticas de Privacidad y Cookies
                y el Aviso Legal de LA PLATAFORMA, así como cualquier relación
                entre los Usuarios y AVANIS, se regirán por la legislación
                española. En caso de conflicto en la aplicación o interpretación
                de dichos documentos, las partes se someten a los Juzgados y
                Tribunales de Madrid.
              </p>
              <p>
                Sin perjuicio de lo anterior, cuando el Usuario sea considerado
                como Consumidor podrá reclamar sus derechos como tal en relación
                con las Condiciones de Uso, el Aviso Legal y las Políticas de
                Privacidad y Cookies tanto ante los órganos jurisdiccionales en
                España en que esté domiciliado el Consumidor como ante los
                órganos jurisdiccionales en su Estado Miembro de residencia en
                la Unión Europea. Asimismo, en cumplimiento de lo establecido en
                el artículo 14.1 del Reglamento (UE) 524/2013 del Parlamento
                Europeo y del Consejo de 21 de mayo de 2013, el Usuario queda
                informado de la existencia de una plataforma de resolución
                extrajudicial de litigios online puesta a disposición por la
                Comisión Europea, disponible en:
                <a
                  href="http://ec.europa.eu/consumers/odr/"
                  target="_blank"
                  >http://ec.europa.eu/consumers/odr/</a
                >y a través de la cual los Consumidores podrán someter sus
                reclamaciones.
              </p>
            </div>
          </div>
          <div class="modal-footer">
            <button
              type="button"
              class="btn btn-secondary"
              data-dismiss="modal"
            >
              Aceptar y cerrar
            </button>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>

<%--<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>--%>

<script>
    $(document).ready(function () {

      $('#<portlet:namespace />password').on('input', function () {
        var password = $(this).val();
        var strength = 0;
        var tips = '';

        // Check password length
        if (password.length < 8) {
          tips += 'Make the password longer. ';
          removerClase('caracteres');
        } else {
          agregarClase('caracteres');
          strength += 1;
        }

        // Check for mixed case
        if (password.match(/[a-z]/) && password.match(/[A-Z]/)) {
          agregarClase('mayusculas');
        } else {
          tips += 'Use both lowercase and uppercase letters. ';
          removerClase('mayusculas');
        }

        // Check for numbers
        if (password.match(/\d/)) {
          agregarClase('numero');
        } else {
          tips += 'Include at least one number. ';
          removerClase('numero');
        }

        // Check for special characters
        if (password.match(/[-!"#$%&()*,./:;?@[\]^_`{|}~+<=>]/)) {
          agregarClase('caracteresEspeciales');
        } else {
          tips += 'Include at least one special character. ';
          removerClase('caracteresEspeciales');
        }
      });
      <% if(tieneErrores){ %>
        document.querySelector('.js-av-content-form--social-google').classList.toggle('av-cl-hidden');
        document.querySelector('.js-av-content-form--email').classList.toggle('av-cl-hidden');
      <% } %>
    });

    function agregarClase(id) {
      $('#' + id).addClass('av-icon-check');
    }

    function removerClase(id) {
      $('#' + id).removeClass('av-icon-check');
    }

    // Variable de control para evitar ejecuciones concurrentes.
    var isExecutingRegisterAcount = false;

    // LLamada a la función de envoltorio.
    function handleRegisterAcount() {
      if (isExecutingRegisterAcount) {
        return; // Si la función de envoltorio ya se está ejecutando, salir.
      }

      // Bloquear nuevas ejecuciones mientras la función de envoltorio esta está en curso.
      isExecutingRegisterAcount = true;

      // VARIABLES Y CONSTANTES:
      const jsBtnRegisterMail = document.querySelector('.js-btn-register-email');
      const jsFormRegisterGoogle = document.querySelector('.js-av-content-form--social-google');
      const jsFormRegisterMail = document.querySelector('.js-av-content-form--email');

      // FUNCIONES:
      function changeFormsVisibility () {
        jsFormRegisterGoogle.classList.toggle('av-cl-hidden');
        jsFormRegisterMail.classList.toggle('av-cl-hidden');
        $('.av-content-form.js-av-content-form--email').css('display', 'block');
      }

      // EVENTOS:
      // ACCIONES DE LE USUARIE:
      jsBtnRegisterMail.addEventListener('click', changeFormsVisibility);
    }

    // Lanzar la función de envoltorio cuando toda la página (incluyendo imágenes y recursos) ha sido completamente cargada.
    window.onload = function () {
      handleRegisterAcount();
    };

    // Lanzar la función de envoltorio cuando todos los portlets estén listos.
    Liferay.on('allPortletsReady', function () {
      handleRegisterAcount();
    });

    // Lanzar la función de envoltorio cuando una nueva pantalla se ha cargado en la navegación SPA.
    Liferay.on('screenLoad', function () {
      handleRegisterAcount();
    });

    // Lanzar la función de envoltorio cuando la navegación SPA ha terminado.
    Liferay.on('endNavigate', function () {
      handleRegisterAcount();
    });

    // Lanzar la función de envoltorio cuando se produce navegación en el SPA.
    Liferay.on('SPA_NAVIGATION', function (event) {
      handleRegisterAcount();
    });

    // Lanzar la función de envoltorio cuando hay cambios de ruta.
    Liferay.on('routeChanged', function () {
      handleRegisterAcount();
    });
</script>

<aui:script>
  AUI().use('aui-base', function(A) { var submitButton =
  A.one('#<portlet:namespace />btnenvioregistro'); submitButton.set('disabled',
  true); A.one('#<portlet:namespace />registerForm').on('keyup', function(event)
  { var passwordField = A.one('#<portlet:namespace />password'); var
  passwordValue = passwordField.get('value'); var passwordRegex =
  /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*()_+={}:;'"\\|,.<>/?~`-])[A-Za-z\d!@#$%^&*()_+={}:;'"\\|,.<>/?~`-]{8,}$/;
  if (!passwordRegex.test(passwordValue)) { submitButton.set('disabled', true);
  }else{ submitButton.set('disabled', false); } }); });
</aui:script>

<script>

  const modalButtonsModal = [
    {
      text: 'Aceptar y cerrar',
      classes: ['av-theme__btn', 'av-theme__btn--secondary'],
      callback: (modal) => {
        closeModal(modal);
      },
    },
  ];

  function openPrivacidadModal() {
    <portlet:renderURL
      var='privacidadModalURL'
      windowState='<%= LiferayWindowState.EXCLUSIVE.toString() %>'
    >
      <portlet:param
        name='mvcRenderCommandName'
        value='render_cmd_command'
      />
      <portlet:param
        name='<%=Constants.CMD%>'
        value='modal-politica-privacidad'
      />
    </portlet:renderURL>;

    fetch('<%=privacidadModalURL%>')
      .then((response) => {
        return response.text();
      })
      .then(function (html) {
        openModal(html, '', modalButtonsModal, 'global');
      })
      .catch((error) => {
        console.warn('Something went wrong.', error);
      });
  }

  function openModalUseCase() {
    <portlet:renderURL
      var='modalUseCaseURL'
      windowState='<%= LiferayWindowState.EXCLUSIVE.toString() %>'
    >
      <portlet:param
        name='mvcRenderCommandName'
        value='render_cmd_command'
      />
      <portlet:param
        name='<%=Constants.CMD%>'
        value='modal-use-cases'
      />
    </portlet:renderURL>;

    fetch('<%=modalUseCaseURL%>')
      .then((response) => {
        return response.text();
      })
      .then(function (html) {
        openModal(html, '', modalButtonsModal, 'global');
      })
      .catch((error) => {
        console.warn('Something went wrong.', error);
      });
  }


</script>
<script>
  $(document).ready(function() {
    // Comprobar si el parámetro "fromModal" está presente en la URL
    const urlParams = new URLSearchParams(window.location.search);
    const fromModal = urlParams.get('fromModal');

    if (fromModal === 'true') {
      // Si viene del modal, mostrar email con efecto y ocultar Google
      $(".av-content-form.js-av-content-form--email")
              .removeClass("av-cl-hidden") // Quitar la clase para hacer visible el contenido
              .hide()
              .fadeIn(); // Mostrar con efecto fade
    } else {
      // Sin el parámetro, mostrar la sección de Google por defecto
      $(".av-content-form.js-av-content-form--social-google")
              .removeClass("av-cl-hidden") // Quitar la clase
              .hide()
              .fadeIn();
    }
  });
</script>

