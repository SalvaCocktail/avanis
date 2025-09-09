<%@ include file="init.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    MBMessageDisplay messageDisplay = (MBMessageDisplay) request.getAttribute(WebKeys.MESSAGE_BOARDS_MESSAGE_DISPLAY);

    MBMessage message = messageDisplay.getMessage();

    MBThread thread = messageDisplay.getThread();

    AssetEntry layoutAssetEntry = AssetEntryLocalServiceUtil.getEntry(MBMessage.class.getName(), message.getMessageId());

    request.setAttribute(WebKeys.LAYOUT_ASSET_ENTRY, layoutAssetEntry);

    LinkedAssetEntryIdsUtil.addLinkedAssetEntryId(request, layoutAssetEntry.getEntryId());

    AssetEntryServiceUtil.incrementViewCounter(layoutAssetEntry);

    boolean portletTitleBasedNavigation = GetterUtil.getBoolean(portletConfig.getInitParameter("portlet-title-based-navigation"));
    if (Validator.isNotNull(renderResponse)) {
        MBBreadcrumbUtil.addPortletBreadcrumbEntries(message, request, renderResponse);
    }
%>

<liferay-editor:resources
        editorName="<%= MBUtil.getEditorName(messageFormat) %>"
/>
<%-- Modal Logeate/registrate--%>
<%
    boolean isLoggedInb = themeDisplay.isSignedIn();
%>

<div class="modal-seguidores">
    <div id="modal-compartir-not-logged" class="av-te-ma-modal alertModal">
        <div class="av-te-ma-modal__panel<%= isLoggedInb ? " modal-logado" : "" %>">
            <div class="av-te-ma-modal__header">
                <h5 class="modal-title" id="exampleModalLabel">Compartir esta publicacion</h5>
                <span class="av-icon-close">&times;</span>
            </div>
            <div class="av-te-ma-modal__content">
                <div class="av-te-ma-modal__text">
                    <span class="av-te-ma-modal__text-title"><strong>Crea tu cuenta gratis o inicia sesión para compartir esta publicación</strong></span>
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
<diV id="thread-container-<%= thread.getThreadId()%>">
    <div <%= portletTitleBasedNavigation ? "class=\"container-fluid container-fluid-max-xl\"" : StringPool.BLANK %>>

        <div <%= !portletTitleBasedNavigation ? "class=\"main-content-body mt-4\"" : StringPool.BLANK %>>
            <liferay-util:include page="/view_message_content.jsp" servletContext="<%= application %>"/>
        </div>
    </div>
</diV>

<aui:script require="frontend-js-web/index as frontendJsWeb">
    var { runScriptsInElement } = frontendJsWeb;

    window['<portlet:namespace/>addReplyToMessage'] = function (messageId, quote) {
    // Primera ocurrencia
    var addQuickReplyContainer = document.querySelector(
    '#<portlet:namespace/>addReplyToMessage' + messageId + ' .panel'
    );

    var addQuickReplyLoadingMask = addQuickReplyContainer
    ? addQuickReplyContainer.closest('.message-container').querySelector('.loading-animation')
    : null;

    // Segunda ocurrencia
    var addQuickReplyContainer2 = document.querySelectorAll(
    '#<portlet:namespace/>addReplyToMessage' + messageId + ' .panel'
    )[1];

    var addQuickReplyLoadingMask2 = addQuickReplyContainer2
    ? addQuickReplyContainer2.closest('.message-container').querySelector('.loading-animation')
    : null;

    // Render URL
    <portlet:renderURL var="editMessageReplyURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
        <portlet:param name="<%= Constants.CMD %>" value="edit_message_reply" />
        <portlet:param name="redirect" value="<%= currentURL %>" />
    </portlet:renderURL>

    var editMessageReplyURL = Liferay.Util.addParams(
    '<portlet:namespace/>messageId=' + messageId,
    '<%= editMessageReplyURL.toString() %>'
    );

    // Aplicar cambios a la primera ocurrencia
    if (addQuickReplyContainer && addQuickReplyLoadingMask) {
    manejarQuickReply(
    addQuickReplyContainer,
    addQuickReplyLoadingMask,
    editMessageReplyURL,
    messageId
    );
    }

    // Aplicar cambios a la segunda ocurrencia
    if (addQuickReplyContainer2 && addQuickReplyLoadingMask2) {
    manejarQuickReply(
    addQuickReplyContainer2,
    addQuickReplyLoadingMask2,
    editMessageReplyURL,
    messageId
    );
    }
    };

    function manejarQuickReply(container, loadingMask, editMessageReplyURL, messageId) {
    // Ocultar el contenedor y mostrar la animación de carga
    container.classList.add('hide');
    loadingMask.classList.remove('hide');

    // Realizar la solicitud
    Liferay.Util.fetch(editMessageReplyURL)
    .then((response) => response.text())
    .then((response) => {
    // Insertar el contenido de la respuesta
    container.innerHTML = response;

    // Ejecutar scripts en el contenido cargado
    runScriptsInElement(container);

    // Actualizar la visibilidad
    container.classList.remove('hide');
    loadingMask.classList.add('hide');

    // Configurar el ID del mensaje principal
    var parentMessageIdInput = container.querySelector('#<portlet:namespace/>parentMessageId');
    if (parentMessageIdInput) {
    parentMessageIdInput.value = messageId;
    }

    // Preparar y enfocar el editor
    var editorName = '<portlet:namespace/>replyMessageBody' + messageId;
    Liferay.componentReady(editorName).then((editor) => {
    editor.focus();
    });

    // Deshabilitar el botón de respuesta
    Liferay.Util.toggleDisabled('#<portlet:namespace/>replyMessageButton' + messageId, true);
    })
    .catch((error) => {
    console.error('Error al procesar la solicitud para messageId:', messageId, error);

    // Restaurar visibilidad en caso de error
    container.classList.remove('hide');
    loadingMask.classList.add('hide');
    });
    }
</aui:script>




<aui:script>
    function <portlet:namespace/>hideReplyMessage(messageId) {
    var addQuickReplyContainer = document.querySelector('#<portlet:namespace/>addReplyToMessage' + messageId + ' .panel');

    if (addQuickReplyContainer) {
    addQuickReplyContainer.classList.add('hide');
    }

    Liferay.Util.toggleDisabled('#<portlet:namespace/>replyMessageButton' + messageId,false);
    }

    <c:if test="<%= thread.getRootMessageId() != message.getMessageId() %>">
        var message = document.getElementById('<portlet:namespace/>message_' + <%= message.getMessageId() %>);

        if (message) {
        message.scrollIntoView(true);
        }
    </c:if>
</aui:script>

<%
    MBThreadFlagLocalServiceUtil.addThreadFlag(themeDisplay.getUserId(), thread, new ServiceContext());

//PortalUtil.setPageSubtitle(message.getSubject(), request);
//PortalUtil.setPageDescription(message.getSubject(), request);

    List<AssetTag> assetTags = AssetTagLocalServiceUtil.getTags(MBMessage.class.getName(), message.getMessageId());

    PortalUtil.setPageKeywords(ListUtil.toString(assetTags, AssetTag.NAME_ACCESSOR), request);
%>
