<%@ page import="com.liferay.portal.kernel.exception.PortalException" %>
<%@ include file="init.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%-- <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>--%>
<script src="<%= request.getContextPath() %>/js/jquery-3.5.1.min.js"></script>
<script src="<%= request.getContextPath() %>/js/bootstrap.min.js"></script>

<%
    String redirect = ParamUtil.getString(request, "redirect");

    MBMessage message = (MBMessage)request.getAttribute("message");
    long categoryId = MBUtil.getCategoryId(request, message);
    MBMessage curParentMessage = null;
    MBThread thread = null;
    String subject = "";
    List<FileEntry> existingAttachmentsFileEntries = new ArrayList<FileEntry>();
    String body = GetterUtil.getString(renderRequest.getAttribute("body"));

    if(message != null){
        body = BeanParamUtil.getString(message, request, "body");
        long messageId = BeanParamUtil.getLong(message, request, "messageId");

        long threadId = BeanParamUtil.getLong(message, request, "threadId");
        long parentMessageId = BeanParamUtil.getLong(message, request, "parentMessageId", MBMessageConstants.DEFAULT_PARENT_MESSAGE_ID);

        subject = BeanParamUtil.getString(message, request, "subject");

        if (threadId > 0) {
            thread = MBThreadLocalServiceUtil.getThread(threadId);

            try {
                curParentMessage = MBMessageServiceUtil.getMessage(parentMessageId);

                if (Validator.isNull(subject)) {
                    String curParentMessageSubject = curParentMessage.getSubject();

                    if (curParentMessageSubject.startsWith(MBMessageConstants.MESSAGE_SUBJECT_PREFIX_RE)) {
                        subject = curParentMessageSubject;
                    }
                    else {
                        subject = MBMessageConstants.MESSAGE_SUBJECT_PREFIX_RE + curParentMessageSubject;
                    }
                }
            }
            catch (Exception e) {
            }
        }

        try {
            existingAttachmentsFileEntries = message.getAttachmentsFileEntries();
        } catch (PortalException e) {
        }

    }

    boolean quote = ParamUtil.getBoolean(request, "quote");
    boolean splitThread = ParamUtil.getBoolean(request, "splitThread");
    boolean allowPingbacks = PropsValues.MESSAGE_BOARDS_PINGBACK_ENABLED && BeanParamUtil.getBoolean(message, request, "allowPingbacks", true);

    String categoriesIds = (String) request.getAttribute("categoriesIds");
    List<AssetCategory> selectedCategories = (List<AssetCategory>) request.getAttribute("selectedCategories");
    String selectedCategoriesIds = (String) request.getAttribute("selectedCategoriesIds");

    //Long[] selectedCategoriesIds = (Long[]) request.getAttribute("selectedCategoriesIds");
    //List<AssetCategory> categories = (List<AssetCategory>) request.getAttribute("categories");
    //boolean isEdit = message != null;
    //String visibility = "all";
%>

<!-- PROCESACTION ELEMENTS -->
<portlet:actionURL name="<%= Constants.UPDATE %>" var="updateMessageURL" >
    <portlet:param name="redirect" value="<%= currentURL %>" />
</portlet:actionURL>

<!-- Modal respuesta posts-->
<%
    boolean isLoggedIn = themeDisplay.isSignedIn();
%>

<div class="modal-respuestaposts">
    <div id="respuestawysiwig" class="av-te-ma-modal alertModal">
        <div class="av-te-ma-modal__panel<%= isLoggedIn ? " modal-logado" : "" %>">
            <div class="av-te-ma-modal__header">
                <h5 class="modal-title" id="exampleModalLabel">Ver esta ayuda</h5>
                <span class="av-icon-close">&times;</span>
            </div>
            <div class="av-te-ma-modal__content">
                <div class="av-te-ma-modal__text">
                    <span class="av-te-ma-modal__text-title"><strong>Crea tu cuenta gratis o inicia sesión para ver esta ayuda</strong></span>
                    <span id="modal-description">¿Ya eres miembro?
                        <a href="/login"><span id="iniciar-sesion-link">Inicia sesión</span></a>
                    </span>
                </div>
                <!-- Accede con google -->
                <div class="my-3 av-form-content">
                    <div class="av-social-login">
                        <div>
                            <div class="av-social-login-google">
                                <a
                                        href="${urlsessionGoogle}"
                                        class="google mb-2 undefined btn-100x100 btn-social-google"
                                >
                                    <svg width="18" height="18" xmlns="http://www.w3.org/2000/svg">
                                        <g fill="#000" fill-rule="evenodd">
                                            <path d="M9 3.48c1.69 0 2.83.73 3.48 1.34l2.54-2.48C13.46.89 11.43 0 9 0 5.48 0 2.44 2.02.96 4.96l2.91 2.26C4.6 5.05 6.62 3.48 9 3.48z"
                                                  fill="#EA4335"></path>
                                            <path d="M17.64 9.2c0-.74-.06-1.28-.19-1.84H9v3.34h4.96c-.1.83-.64 2.08-1.84 2.92l2.84 2.2c1.7-1.57 2.68-3.88 2.68-6.62z"
                                                  fill="#4285F4"></path>
                                            <path d="M3.88 10.78A5.54 5.54 0 0 1 3.58 9c0-.62.11-1.22.29-1.78L.96 4.96A9.008 9.008 0 0 0 0 9c0 1.45.35 2.82.96 4.04l2.92-2.26z"
                                                  fill="#FBBC05"></path>
                                            <path d="M9 18c2.43 0 4.47-.8 5.96-2.18l-2.84-2.2c-.76.53-1.78.9-3.12.9-2.38 0-4.4-1.57-5.12-3.74L.97 13.04C2.45 15.98 5.48 18 9 18z"
                                                  fill="#34A853"></path>
                                            <path fill="none" d="M0 0h18v18H0z"></path>
                                        </g>
                                    </svg>
                                    <span style="padding: 10px 10px 10px 0px; font-weight: 500">Acceder con Google</span>
                                </a>
                            </div>
                        </div>
                    </div>
                    <p class="mb-2">
                        <strong>O si lo prefieres...</strong>
                    </p>
                    <div class="av-buttons-tipo-registro js-btn-register-email" style="margin-top: 8px; margin-bottom: 24px;">
                        <a href="/tipo-registro?fromModal=true">
                            <button class="btn av-theme__btn av-theme__btn--primary btn-100x100 btn-secondary"
                                    id="_avanis_custom_login_AvanisCustomLoginPortlet_INSTANCE_mjei_umzz" type="button"
                                    label="">
                                <span class="lfr-btn-label">Regístrate con tu email</span>
                            </button>
                        </a>
                    </div>
                    <div class="seguir-politicas">Al hacer clic en Continuar con Google, aceptas las 
                        <a href="condiciones-de-uso"><span
                                class="politicas-link">condiciones de uso</span></a> y la <a
                                href="/politica-de-privacidad"><span
                                class="politicas-link">política de privacidad</span></a> de
                        Avanis.
                    </div>
                </div>

            </div>
        </div>

    </div>
</div>




<div class="panel-heading">
    <clay:content-row cssClass="card-body" padded="<%= true %>">
        <clay:content-col>
            <div class="list-group-card-icon">
                <a href="<%="/mi-perfil-publico?id="+user.getUserId()%>">
                    <%
                        // Obtener el ID del usuario
                        long userId = user.getUserId();

                        // Inicializar valores para el nombre, apellido e iniciales
                        String firstName = "";
                        String lastName = "";
                        String initials = "NN"; // Por defecto "NN" si no se obtienen los datos del usuario

                        // Obtener el nombre y apellido del usuario
                        firstName = user.getFirstName();
                        lastName = user.getLastName();

                        // Calcular las iniciales si el nombre y apellido no son nulos
                        if (firstName != null && lastName != null) {
                            initials = (firstName.substring(0, 1) + lastName.substring(0, 1)).toUpperCase();
                        }

                        // Comprobar si el usuario tiene retrato
                        boolean hasPortrait = user.getPortraitId() > 0;
                    %>

                    <c:choose>
                        <c:when test="<%= hasPortrait %>">
                            <!-- Mostrar retrato si el usuario tiene uno -->
                            <liferay-user:user-portrait userId="<%= userId %>"/>
                        </c:when>
                        <c:otherwise>
                            <!-- Mostrar iniciales si el usuario no tiene retrato -->
                            <div class="user-initials-avatar">
                                <%= initials %>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </a>
            </div>
        </clay:content-col>

        <clay:content-col expand="<%= true %>">
            <span class="message-user-display text-default" title="<%= HtmlUtil.escapeAttribute(user.getFullName()) %>">
                <a href="<%="/mi-perfil-publico?id="+user.getUserId()%>"><%= HtmlUtil.escape(user.getFullName()) %></a>
            </span>
            <span class="message-user-display text-default text-date" title="<%= HtmlUtil.escapeAttribute(dayFormat.format(new Date()) + " de " + monthFormat.format(new Date())) %>">
                <%= HtmlUtil.escape(dayFormat.format(new Date()) + " de " + monthFormat.format(new Date())) %>
            </span>
        </clay:content-col>
    </clay:content-row>
</div>

<!-- INIT FORM -->
<aui:form method="post" action="${updateMessageURL}" name="fmEdit" enctype="multipart/form-data" >
    <input type="hidden" name="<portlet:namespace />messageId" value="${message.messageId}" >
    <input type="hidden" name="<portlet:namespace />inputPermissionsViewRolemessageId" value="Guest">
    <aui:input name="messageFormat" type="hidden" value="<%= messageFormat %>" />
    <aui:input name="redirect" type="hidden" value="<%= redirect %>" />
    <input type="hidden" name="<portlet:namespace/>agricultureCategory" value="${agricultureCategoriesSelected}" id="<portlet:namespace />agricultureCategory">
    <input type="hidden" name="<portlet:namespace/>stockbreadingCategory" value="${stockbreadingCategoriesSelected}" id="<portlet:namespace />stockbreadingCategory">
    <input type="hidden" name="<portlet:namespace/>otherCategory" value="${otherCategoriesSelected}" id="<portlet:namespace />otherCategory">
    <aui:input name="isFromDetail" type="hidden" value="${isFromDetail}"/>

    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="form-group">
                    <div id="<portlet:namespace />input-permissions" class="input-permissions">
                        <label for="<portlet:namespace />visibilityOptions"><liferay-ui:message key="audiencia"/></label>
                        <select name="<portlet:namespace />visibilityOptions" id="<portlet:namespace />visibilityOptions"
                                class="dropdown profile-dropdown-button w-100">
                            <option value="public" ${visibility=="public" ? 'selected="selected"' : '' }>
                                <liferay-ui:message key="audiencia-publico-select"/>
                            </option>
                            <option value="registered" ${visibility=="registered" ? 'selected="selected"' : '' }>
                                <liferay-ui:message key="audiencia-privado-select"/>
                            </option>
                            <option value="followers" ${visibility=="followers" ? 'selected="selected"' : '' }>
                                <liferay-ui:message key="audiencia-privado-plus-select"/>
                            </option>
                        </select>
                    </div>
                </div>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-md-12">
                <div class="form-group">
                    <%--<aui:field-wrapper cssClass="message-content">
                        <c:choose>
                            <c:when test='<%= ((message != null) && !message.isFormatBBCode()) || ((message == null) && !messageFormat.equals("bbcode")) %>'>
                                <%@ include file="components/html_editor.jspf" %>
                            </c:when>
                            <c:otherwise>
                                <%@ include file="components/bbcode_editor.jspf" %>

                            </c:otherwise>
                        </c:choose>
                        <aui:input name="body" type="hidden" />
                    </aui:field-wrapper>--%>

                    <aui:field-wrapper cssClass="message-content input-new-message-v2-container">
                        <%@ include file="components/input-new-message-v2.jsp" %>
                    </aui:field-wrapper>

                    <aui:input name="body" type="hidden" />
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">


                <%@ include file="components/edit_message_category.jspf" %>
                <%@ include file="components/edit_message_attachment.jspf" %>

                <%@ include file="components/edit_message_survey.jspf" %>
                <div class="add-to-thread pt-2">
                    <liferay-ui:message key="add-to-thread"/>:
                    <liferay-ui:icon icon="picture" label="<%= true %>" markupView="glyphicon"
                                     message="multimedia"  method="get" url="javascript:clickAttachmentFiles();"
                                     cssClass="iconos-publicacion" id="multimedia"
                    />
                    <liferay-ui:icon icon="categories" label="<%= true %>" markupView="lexicon"
                                     message="categories"  method="get" url="javascript:showCategoryListModal();"
                                     cssClass="iconos-publicacion" id="category-icon"
                    />
                    <liferay-ui:icon icon="list" label="<%= true %>" markupView="lexicon"
                                     message="survey" method="get" url="javascript:openSurvey();"
                                     cssClass="iconos-publicacion" id="survey-icon"
                    />
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="form-group">
                    <div class="av-te-wte-mps__modal-bottom d-flex flex-column flex-sm-row justify-content-center">
                        <button type="button" class="av-theme__btn av-theme__btn--secondary" onclick="closeFmEdit()">
                            <liferay-ui:message key="cancel"/></button>
                        <button type="submit" id="messageUpdateButton" class="av-theme__btn av-theme__btn--primary submitPublicar">
                            <liferay-ui:message key="publish"/></button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</aui:form>

<script type="text/javascript" language="javascript">
    $(document).ready(function () {
        $('.delete-attachment').on('click', function(){
            var url = $(this).attr('data-url');
            $("#<portlet:namespace />fmEdit").attr('action', url);
            $("#<portlet:namespace />fmEdit").submit();
        });

        let bodyEdit = `<%= body %>`;
        //console.log('bodyEdit original:', bodyEdit);
        if (bodyEdit !== null && bodyEdit.trim() !== '') {
            bodyEdit = $('<div>').html(bodyEdit).text();
            //console.log('bodyEdit decodificado:', bodyEdit);

            bodyEdit = bodyEdit.replace(/<(?!b|i|u|strike|\/b|\/i|\/u|\/strike)[^>]*>/g, ' ');

            //BBCode con HTML
            bodyEdit = bodyEdit.replace(/\[b\](.*?)\[\/b\]/g, '<b>$1</b>')
                .replace(/\[i\](.*?)\[\/i\]/g, '<i>$1</i>')
                .replace(/\[u\](.*?)\[\/u\]/g, '<u>$1</u>')
                .replace(/\[s\](.*?)\[\/s\]/g, '<strike>$1</strike>');

            $('#editable<portlet:namespace />').html(bodyEdit);
        } else {
            //console.log('bodyEdit is null or empty');
        }


        $("#messageUpdateButton").on("click", function (event) {
            event.preventDefault();

            // Verifico si la encuesta está visible
            const surveyDiv = document.getElementById('_avanisComunidadPortlet_AvanisComunidadPortlet_survey');
            const isSurveyHidden = window.getComputedStyle(surveyDiv).display === "none";

            // Si está visible
            if (!isSurveyHidden) {
                // Obtener el campo <select> de horas de expiración
                const expireHoursSelect = document.getElementById('_avanisComunidadPortlet_AvanisComunidadPortlet_expireHours');

                // Verificar si el valor seleccionado es "0"
                if (expireHoursSelect.value === "0") {
                    Liferay.Util.openToast({
                        message: 'Por favor, selecciona una duración válida para las horas de expiración.',
                        type: 'danger'
                    });
                    return; // Salir de la función
                }
            }

            //HTML a BBCode
            const bodyInput = $('#<portlet:namespace />body');
            const htmlContent = $('#editable<portlet:namespace />').html();
            //console.log('Contenido HTML antes de convertir:', htmlContent);
            const bbcodeContent = htmlContent
                .replace(/<(?!b|i|u|strike|\/b|\/i|\/u|\/strike)[^>]*>/g, ' ')
                .replace(/<b>(.*?)<\/b>/g, '[b]$1[/b]')
                .replace(/<i>(.*?)<\/i>/g, '[i]$1[/i]')
                .replace(/<u>(.*?)<\/u>/g, '[u]$1[/u]')
                .replace(/<strike>(.*?)<\/strike>/g, '[s]$1[/s]')
                .replace(/<br\s*\/?>/g, '');
            //console.log('Contenido BBCode convertido:', bbcodeContent);
            bodyInput.val(bbcodeContent);

            if (bodyInput.val() !== undefined && bodyInput.val() != null && bodyInput.val().trim() !== '') {
                const userAgent = navigator.userAgent || navigator.vendor || window.opera;
                const isIOS = /iPad|iPhone|iPod/.test(userAgent) && !window.MSStream;

                $("#<portlet:namespace />fmEdit").on("submit", function(event) {
                    event.preventDefault();
                    window.submitPublicar();
                    const formData = new FormData(this);
                    fetch('<%= updateMessageURL %>', {
                        method: 'POST',
                        body: formData,
                    })
                        .then(response => {
                            if (response.ok) {
                                if (isIOS) {
                                    setTimeout(() => {
                                        window.top.location.href = "<%= redirect %>";
                                    }, 500);
                                } else {
                                    window.top.location.href = "<%= redirect %>";
                                }
                            } else {
                                console.error('Error al procesar el formulario:', response.statusText);
                            }
                        })
                        .catch(error => {
                            console.error('Error en la solicitud:', error);
                        });
                });
                parent.$('#loadingSpinner').show();
                $("#<portlet:namespace />fmEdit").submit();
            }



        });


    });

    function closeFmEdit() {
        <c:choose>
        <c:when test="${isFromDetail}">
        window.parent.closeEditMessageModalFromDetail();
        </c:when>
        <c:otherwise>
        window.parent.closeEditMessageModal();
        </c:otherwise>
        </c:choose>
    }

</script>

<style>

    .portal-popup .avanis-comunidad-portlet .form .container {
        background: none;
    }

    .portal-popup .avanis-comunidad-portlet .form .lfr-tooltip-scope label {
        display: none;
    }
</style>




