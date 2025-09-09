<%@ include file="/init.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div id="loadingSpinner" class="loading-spinner" style="display: none;">
    <div class="spinner"></div>
</div>


<%
    // Obtener el valor del parámetro 'view' desde la solicitud
    String view = request.getParameter("view");

// Si necesitas asegurarte de que no sea nulo
    if (view == null) {
        view = "default"; // Valor por defecto si no está presente
    }
%>
<jsp:include page="wysiwyg-post-css.jsp"/>

<script>
    var view = '<%= view %>';
</script>

<div id="embedded-comunidad-container">
    <c:choose>
        <c:when test="${isSignedIn && thread != null}">
            <jsp:include page="thread.jsp"/>
        </c:when>
        <c:when test="${isSignedIn && thread == null}">
            <jsp:include page="createThread.jsp"/>
        </c:when>
        <c:when test="${thread != null}">
            <jsp:include page="guestThread.jsp"/>
        </c:when>
        <c:otherwise>
            <jsp:include page="guestEmptyThread.jsp"/>
        </c:otherwise>
    </c:choose>
</div>



<!-- Incluye el script de EmojiMart -->
<!-- Cargar el script de EmojiMart solo si view es "desktop" -->

<c:if test="${vista == 'desktop'}">
    <div class="modal-respuestaposts">
        <div id="respuestawysiwig" class="av-te-ma-modal alertModal" style="display: none;">
            <div class="av-te-ma-modal__panel">
                <div class="av-te-ma-modal__header">
                    <h5 class="modal-title" id="exampleModalLabel">Nuevo comentario</h5>
                    <span id="closeModal" class="av-icon-close">&times;</span>
                </div>
                <div class="av-te-ma-modal__content">
                    <!-- Editor WYSIWYG -->
                    <div class="input-container">
                        <div id="editable" contenteditable="true" placeholder="Escribe algo"></div>
                        <div class="toolbar">
                            <span class="icon smiley" data-target="#emote-menu"><svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
<path fill-rule="evenodd" clip-rule="evenodd" d="M12 4C7.58172 4 4 7.58172 4 12C4 16.4183 7.58172 20 12 20C16.4183 20 20 16.4183 20 12C20 7.58172 16.4183 4 12 4ZM2 12C2 6.47715 6.47715 2 12 2C17.5228 2 22 6.47715 22 12C22 17.5228 17.5228 22 12 22C6.47715 22 2 17.5228 2 12ZM7.85 9.3C7.85 8.49919 8.49919 7.85 9.3 7.85C10.1008 7.85 10.75 8.49919 10.75 9.3C10.75 10.1008 10.1008 10.75 9.3 10.75C8.49919 10.75 7.85 10.1008 7.85 9.3ZM13.25 9.3C13.25 8.49919 13.8992 7.85 14.7 7.85C15.5008 7.85 16.15 8.49919 16.15 9.3C16.15 10.1008 15.5008 10.75 14.7 10.75C13.8992 10.75 13.25 10.1008 13.25 9.3ZM9.19955 13.1994C9.19954 13.1994 9.19955 13.1994 9.19955 13.1994L9.19836 13.1978L9.19718 13.1963L9.19621 13.195C9.1962 13.195 9.19634 13.1952 9.19665 13.1956C9.19718 13.1962 9.19801 13.1975 9.19955 13.1994C9.20434 13.2054 9.21413 13.2175 9.22838 13.2345C9.25694 13.2685 9.30383 13.3223 9.36808 13.3893C9.49741 13.5243 9.69219 13.7078 9.94442 13.8913C10.4527 14.2609 11.1505 14.6 12 14.6C12.8495 14.6 13.5473 14.2609 14.0556 13.8913C14.3078 13.7078 14.5026 13.5243 14.6319 13.3893C14.6962 13.3223 14.7431 13.2685 14.7716 13.2345C14.7859 13.2175 14.7955 13.2056 14.8002 13.1995C14.8018 13.1975 14.8029 13.1962 14.8034 13.1955C15.1356 12.7576 15.7597 12.6698 16.2 13C16.6418 13.3314 16.7314 13.9582 16.4 14.4L15.6411 13.8308C16.4 14.4 16.3998 14.4003 16.3995 14.4006L16.399 14.4013L16.3979 14.4028L16.3952 14.4063L16.3883 14.4153C16.383 14.4222 16.3764 14.4308 16.3683 14.4409C16.3523 14.4612 16.3306 14.488 16.3036 14.5202C16.2495 14.5846 16.1734 14.6715 16.0759 14.7732C15.8818 14.9757 15.5984 15.2422 15.2319 15.5087C14.5027 16.0391 13.4005 16.6 12 16.6C10.5995 16.6 9.49727 16.0391 8.76808 15.5087C8.40156 15.2422 8.11821 14.9757 7.92411 14.7732C7.82664 14.6715 7.75048 14.5846 7.69643 14.5202C7.66937 14.488 7.64775 14.4612 7.63166 14.4409C7.62362 14.4308 7.61695 14.4222 7.61167 14.4153L7.60479 14.4063L7.60214 14.4028L7.601 14.4013L7.60048 14.4006C7.60024 14.4003 7.60001 14.4 8.35214 13.8359L7.6 14.4C7.26863 13.9582 7.35817 13.3314 7.8 13C8.24034 12.6697 8.86441 12.7576 9.19665 13.1956M9.19955 13.1994C9.19954 13.1994 9.19955 13.1994 9.19955 13.1994V13.1994Z" fill="#101717"/>
</svg>
</span>
                            <span class="icon user d-none" data-target="#user-menu">👤</span>
                            <span class="icon hashtag d-none" data-target="#hashtag-menu">#️⃣</span>
                            <span class="icon format" data-target="#format-menu"><svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
<path fill-rule="evenodd" clip-rule="evenodd" d="M3 21C3 20.4477 3.44772 20 4 20H20C20.5523 20 21 20.4477 21 21C21 21.5523 20.5523 22 20 22H4C3.44772 22 3 21.5523 3 21Z" fill="#101717"/>
<path fill-rule="evenodd" clip-rule="evenodd" d="M11.19 4.59741L9.4707 11.5999H14.5293L12.81 4.59741L12.8091 4.59413C12.8077 4.58876 12.8048 4.57835 12.8004 4.5636C12.7915 4.53396 12.7769 4.48783 12.7559 4.43087C12.713 4.31435 12.6485 4.16595 12.5614 4.02398C12.3731 3.71728 12.188 3.59998 12 3.59998C11.812 3.59998 11.6269 3.71728 11.4386 4.02398C11.3515 4.16595 11.287 4.31435 11.2441 4.43087C11.2231 4.48783 11.2085 4.53396 11.1996 4.5636C11.1952 4.57835 11.1923 4.58876 11.1909 4.59413L11.19 4.59741ZM14.9221 13.1999H9.07785L8.0481 17.3938C7.94286 17.8225 7.51628 18.0831 7.09532 17.9759C6.67435 17.8688 6.4184 17.4344 6.52364 17.0058L9.6664 4.20595L10.4285 4.39994C9.6664 4.20595 9.6664 4.20595 9.6664 4.20595L9.66668 4.2048L9.667 4.2035L9.66776 4.20045L9.66977 4.19256L9.67576 4.16988C9.68064 4.15181 9.68735 4.12785 9.696 4.09884C9.71325 4.04098 9.73849 3.96212 9.77276 3.86908C9.84033 3.6856 9.94772 3.43401 10.1061 3.17599C10.4089 2.68269 11.0095 2 12 2C12.9905 2 13.5911 2.68269 13.8939 3.17599C14.0523 3.43401 14.1597 3.6856 14.2272 3.86908C14.2615 3.96212 14.2868 4.04098 14.304 4.09884C14.3127 4.12785 14.3194 4.15181 14.3242 4.16988L14.3302 4.19256L14.3322 4.20045L14.333 4.2035L14.3333 4.2048C14.3333 4.2048 14.3336 4.20595 13.5714 4.39997L14.3336 4.20595L17.4764 17.0058C17.5816 17.4344 17.3257 17.8688 16.9047 17.9759C16.4837 18.0831 16.0571 17.8225 15.9519 17.3938L14.9221 13.1999Z" fill="#101717"/>
<path fill-rule="evenodd" clip-rule="evenodd" d="M9.95616 3.08439C10.2705 2.57228 10.9172 1.82495 11.9992 1.82495C13.0812 1.82495 13.7279 2.57228 14.0422 3.08439C14.2084 3.35505 14.3204 3.61784 14.3907 3.80855C14.4264 3.90549 14.4528 3.98789 14.4709 4.04879C14.48 4.07934 14.4871 4.10476 14.4924 4.1242L14.499 4.14935L14.501 4.15724L14.502 4.16099L14.5024 4.16272C14.5024 4.16266 14.5024 4.16279 14.5024 4.16272C14.5025 4.16314 14.5027 4.16375 14.5028 4.16417L17.6455 16.964C17.773 17.4834 17.4636 18.014 16.9471 18.1455C16.4293 18.2773 15.9089 17.956 15.7811 17.4355L14.7841 13.3748H9.21428L8.21726 17.4355C8.08947 17.956 7.56911 18.2773 7.05135 18.1455C6.53478 18.014 6.22536 17.4834 6.35289 16.964L9.49564 4.16417L9.56962 4.18233C9.56962 4.18235 9.56963 4.18231 9.56962 4.18233L9.49564 4.16417L9.49634 4.16137L9.49719 4.15796L9.49977 4.14782L9.50576 4.12515C9.51101 4.1057 9.51839 4.07934 9.52749 4.04879C9.54565 3.98789 9.57204 3.90549 9.60774 3.80855C9.67798 3.61784 9.79002 3.35505 9.95616 3.08439ZM9.79346 4.41903L6.6928 17.0475C6.60984 17.3853 6.81232 17.7235 7.13769 17.8063C7.46186 17.8888 7.79466 17.6889 7.87735 17.3521L8.9071 13.1581C8.92631 13.0798 8.99648 13.0248 9.07705 13.0248H14.9213C15.0019 13.0248 15.0721 13.0798 15.0913 13.1581L16.1211 17.3521C16.2037 17.6889 16.5365 17.8888 16.8607 17.8063C17.1861 17.7235 17.3886 17.3853 17.3056 17.0475L14.2049 4.41903L13.6137 4.56951C13.5201 4.59336 13.4248 4.53676 13.401 4.44309C13.3771 4.34943 13.4337 4.25417 13.5274 4.23033C13.823 4.15509 14.0038 4.10888 14.1143 4.08052C14.1003 4.03685 14.083 3.98595 14.0622 3.92951C13.9973 3.75326 13.8946 3.51287 13.744 3.26749C13.4527 2.793 12.8982 2.17495 11.9992 2.17495C11.1002 2.17495 10.5457 2.793 10.2544 3.26749C10.1038 3.51287 10.0011 3.75326 9.93618 3.92951C9.91533 3.98611 9.898 4.03715 9.88395 4.0809L10.4709 4.2303C10.5645 4.25414 10.6211 4.3494 10.5973 4.44306C10.5735 4.53672 10.4782 4.59332 10.3845 4.56948L9.79346 4.41903ZM14.2843 4.03654C14.2844 4.0365 14.2844 4.0365 14.2843 4.03654V4.03654ZM11.9992 3.77493C11.9 3.77493 11.7615 3.83118 11.587 4.11547C11.5076 4.2448 11.4478 4.382 11.4075 4.4913C11.388 4.54436 11.3745 4.58696 11.3665 4.61356C11.3627 4.62651 11.3602 4.63538 11.3591 4.63948C11.3591 4.63956 11.3591 4.63941 11.3591 4.63948L11.3588 4.64067L9.69306 11.4248H14.3053L12.6396 4.64067C12.6385 4.63668 12.6358 4.62676 12.6319 4.61356C12.624 4.58696 12.6104 4.54436 12.5909 4.4913C12.5506 4.382 12.4908 4.2448 12.4114 4.11547C12.2369 3.83118 12.0984 3.77493 11.9992 3.77493ZM11.2887 3.93238C11.4907 3.60329 11.7223 3.42493 11.9992 3.42493C12.2761 3.42493 12.5077 3.60329 12.7097 3.93238C12.8046 4.087 12.8738 4.24661 12.9193 4.37034C12.9417 4.4312 12.9575 4.48087 12.9673 4.51356C12.9721 4.52984 12.9754 4.54171 12.9773 4.54844L12.9792 4.55562L14.6985 11.5581C14.7113 11.6103 14.6994 11.6655 14.6662 11.7078C14.633 11.7501 14.5823 11.7748 14.5285 11.7748H9.4699C9.41614 11.7748 9.36536 11.7501 9.33219 11.7078C9.29901 11.6655 9.28713 11.6103 9.29994 11.5581L11.0201 4.55241L11.021 4.54914C11.0228 4.54241 11.0263 4.52984 11.0311 4.51356C11.0409 4.48087 11.0567 4.4312 11.0791 4.37034C11.1246 4.24661 11.1938 4.087 11.2887 3.93238Z" fill="#101717"/>
</svg>
</span>
                        </div>
                        <!-- Menús -->
                        <div class="menu" id="emote-menu" style="display:none;"></div>
                        <div class="menu" id="user-menu" style="display:none;">Usuarios</div>
                        <div class="menu" id="hashtag-menu" style="display:none;">Hashtags</div>
                        <div class="menu" id="format-menu" style="display:none;">
                            <button data-cmd="bold"><b>B</b></button>
                            <button data-cmd="italic"><i>I</i></button>
                            <button data-cmd="underline"><u>U</u></button>
                            <button data-cmd="strikeThrough"><s>S</s></button>
                        </div>
                    </div>
                    <!-- Botón de envío -->
                    <button id="sendButton" class="send-button">
                        <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                            <path d="M2 21L23 12L2 3V10L17 12L2 14V21Z" fill="currentColor"/>
                        </svg>
                    </button>
                    <div id="botones-nuevo-comentario">
                        <button type="submit" id="cancelar" class="av-theme__btn av-theme__btn--secondary">
                            Cancelar</button>
                        <button type="submit" id="messageUpdateButton" class="av-theme__btn av-theme__btn--primary">
                            Publicar</button>
                    </div>

                </div>
            </div>
        </div>
    </div>
    <script>
        $(document).ready(function () {
            let activeTextareaId = null;
            const editableDiv = document.getElementById('editable');
            let emojiPicker;
            let savedRange = null;

// Abrir el modal al hacer clic en un textarea
            $(document).on('click', 'textarea[id^="_avanisComunidadPortlet_AvanisComunidadPortlet_INSTANCE_"]', function() {
                activeTextareaId = $(this).attr('id');
                $('#respuestawysiwig').show();
                $('#respuestawysiwig #editable').each(function () {

                });
                $('#respuestawysiwig #editable').focus();
            });

            // Detectar clic en <input>
            $(document).on('click', 'input.field.form-control[id^="_avanis_embedded_comunidad_portlet_AvanisEmbeddedComunidadPortlet_INSTANCE_"]', function() {
                //console.log("CLICK CREAR NUEVO HILO");
                activeInputId = $(this).attr('id');
                $('#respuestawysiwig').show();
                $('#respuestawysiwig #editable').focus();
            });



// Cerrar el modal al hacer clic en la "X"
            $('#closeModal,#cancelar').click(function() {
                $('#respuestawysiwig').hide();
            });

// Transferir contenido y enviar al hacer clic en el botón de enviar
            $('#messageUpdateButton').click(function(event) {
                event.preventDefault();

                // Simular un clic en el botón "Enviar"
                $('#sendButton').click();
            });

            $('#sendButton').click(function() {
                if (activeTextareaId) {
                    const content = $('#editable').html();
                    $('#' + activeTextareaId).val(content);

                    // Simular clic en el botón de enviar asociado al textarea
                    var namespace = activeTextareaId.match(/^(_avanisComunidadPortlet_AvanisComunidadPortlet_INSTANCE_\d+)_body/)[1];
                    var parentMessageId = activeTextareaId.match(/\d+$/)[0]; // Extraer el número final del ID

                    // Mostrar el spinner de carga
                    if ($('#editable').html().trim() !== '') {
                        $('#loadingSpinner').show();
                    }

                    // Construir el ID del botón de publicar basado en el namespace y el parentMessageId
                    var quickReplyButtonId = namespace + '_quickReplyButton' + parentMessageId;

                    if ($('#' + quickReplyButtonId).length > 0) {
                        $('#' + quickReplyButtonId).click();
                    } else {
                        console.error('Botón de enviar no encontrado.');
                    }
                    $('#respuestawysiwig').hide(); // Cerrar el modal después de enviar
                }

                if (activeInputId) {
                    const content = $('#editable').html();

                    if (typeof content === 'string') {

                        $('#' + activeInputId).val(content);

                        var namespaceInput = activeInputId.match(/^(_avanis_embedded_comunidad_portlet_AvanisEmbeddedComunidadPortlet_INSTANCE_\w+)_body/)[1];

                        // Construir el ID del botón de guardar basado en el namespace
                        var createThreadButtonId = namespaceInput + '_createEmbeddedThreadButton';

                        // Verificar si el botón existe y simular un clic
                        if ($('#' + createThreadButtonId).length > 0) {
                            $('#' + createThreadButtonId).click();

                            if ($('#editable').html().trim() !== '') {
                                $('#loadingSpinner').show();
                            }
                        } else {
                            console.error('Botón de enviar no encontrado para el input.');
                        }
                    } else {
                        console.error('El contenido no es una cadena.');
                    }
                    $('#respuestawysiwig').hide(); // Cerrar el modal después de enviar
                }


            });

            $('.toolbar .icon').on('click', function () {

                let targetMenu = $(this).data('target');
                $('.menu').not(targetMenu).hide();
                $('.icon').not(this).removeClass('active');

                if ($(targetMenu).is(':visible')) {
                    $(targetMenu).hide();
                    $(this).removeClass('active');
                } else {
                    $(targetMenu).show();
                    $(this).addClass('active');

                    if (targetMenu === '#emote-menu') {
                        saveCursorPosition();
                        if('<%= view %>'=== 'desktop'){

                            showEmojiPicker();
                        }
                    }
                }
            });

            async function showEmojiPicker() {
                const emoteMenu = document.getElementById('emote-menu');
                if (!emojiPicker) {
                    const response = await fetch('/o/avanis-v2-theme/js/emoji-mart/es.json');
                    const i18n = await response.json();

                    emojiPicker = new EmojiMart.Picker({
                        set: 'google',
                        theme: 'light',
                        emojiSize: 24,
                        perLine: 8,
                        title: 'Selecciona un emoji',
                        i18n,
                        onEmojiSelect: (emoji) => {
                            restoreCursorPosition();
                            insertAtCursor(emoji.native);
                        }
                    });

                    emoteMenu.appendChild(emojiPicker);
                }
                setTimeout(() => {
                    const emojiPicker = document.querySelector('em-emoji-picker');
                    if (emojiPicker && emojiPicker.shadowRoot) {
                        const shadowRoot = emojiPicker.shadowRoot;
                        const previewElement = shadowRoot.querySelector('#preview');
                        if (previewElement) {
                            previewElement.style.display = 'none';
                        }
                    }
                }, 300);
            }

            function saveCursorPosition() {
                const selection = window.getSelection();
                if (selection.rangeCount > 0) {
                    const range = selection.getRangeAt(0);
                    if (editableDiv.contains(range.commonAncestorContainer)) {
                        savedRange = range;
                    }
                }
            }

            function restoreCursorPosition() {
                const selection = window.getSelection();
                if (savedRange) {
                    selection.removeAllRanges();
                    selection.addRange(savedRange);
                } else {
                    editableDiv.focus();
                }
            }

            function insertAtCursor(text) {
                restoreCursorPosition();
                const selection = window.getSelection();
                if (selection.rangeCount > 0) {
                    const range = selection.getRangeAt(0);
                    const textNode = document.createTextNode(text);
                    range.deleteContents();
                    range.insertNode(textNode);
                    range.setStartAfter(textNode);
                    range.setEndAfter(textNode);
                    selection.removeAllRanges();
                    selection.addRange(range);
                }
            }

            $('#format-menu button').on('click', function (e) {
                e.preventDefault();
                let cmd = $(this).data('cmd');
                document.execCommand(cmd, false, null);
                updateFormatMenuState();
                $('#editable').focus();
            });

            function updateFormatMenuState() {
                $('#format-menu button').each(function () {
                    let cmd = $(this).data('cmd');
                    if (document.queryCommandState(cmd)) {
                        $(this).addClass('active');
                    } else {
                        $(this).removeClass('active');
                    }
                });
            }

            $('#editable<portlet:namespace />').on('mouseup keyup', function () {
                updateFormatMenuState();
                saveCursorPosition();
            });
        });
    </script>
</c:if>

<c:if test="${vista == 'movil'}">
    <div class="modal-respuestaposts2">
        <div id="respuestawysiwig2" class="av-te-ma-modal alertModal" style="display: none;">
            <div class="av-te-ma-modal__panel">
                <div class="av-te-ma-modal__header">
                    <h5 class="modal-title" id="exampleModalLabel2">Nuevo comentario</h5>
                    <span id="closeModal2" class="av-icon-close">&times;</span>
                </div>
                <div class="av-te-ma-modal__content">
                    <!-- Editor WYSIWYG -->
                    <div class="input-container">
                        <div id="editable2" contenteditable="true" placeholder="Escribe algo"></div>
                        <div class="toolbar2">
                            <span class="icon smiley" data-target="#emote-menu2"><svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
<path fill-rule="evenodd" clip-rule="evenodd" d="M12 4C7.58172 4 4 7.58172 4 12C4 16.4183 7.58172 20 12 20C16.4183 20 20 16.4183 20 12C20 7.58172 16.4183 4 12 4ZM2 12C2 6.47715 6.47715 2 12 2C17.5228 2 22 6.47715 22 12C22 17.5228 17.5228 22 12 22C6.47715 22 2 17.5228 2 12ZM7.85 9.3C7.85 8.49919 8.49919 7.85 9.3 7.85C10.1008 7.85 10.75 8.49919 10.75 9.3C10.75 10.1008 10.1008 10.75 9.3 10.75C8.49919 10.75 7.85 10.1008 7.85 9.3ZM13.25 9.3C13.25 8.49919 13.8992 7.85 14.7 7.85C15.5008 7.85 16.15 8.49919 16.15 9.3C16.15 10.1008 15.5008 10.75 14.7 10.75C13.8992 10.75 13.25 10.1008 13.25 9.3ZM9.19955 13.1994C9.19954 13.1994 9.19955 13.1994 9.19955 13.1994L9.19836 13.1978L9.19718 13.1963L9.19621 13.195C9.1962 13.195 9.19634 13.1952 9.19665 13.1956C9.19718 13.1962 9.19801 13.1975 9.19955 13.1994C9.20434 13.2054 9.21413 13.2175 9.22838 13.2345C9.25694 13.2685 9.30383 13.3223 9.36808 13.3893C9.49741 13.5243 9.69219 13.7078 9.94442 13.8913C10.4527 14.2609 11.1505 14.6 12 14.6C12.8495 14.6 13.5473 14.2609 14.0556 13.8913C14.3078 13.7078 14.5026 13.5243 14.6319 13.3893C14.6962 13.3223 14.7431 13.2685 14.7716 13.2345C14.7859 13.2175 14.7955 13.2056 14.8002 13.1995C14.8018 13.1975 14.8029 13.1962 14.8034 13.1955C15.1356 12.7576 15.7597 12.6698 16.2 13C16.6418 13.3314 16.7314 13.9582 16.4 14.4L15.6411 13.8308C16.4 14.4 16.3998 14.4003 16.3995 14.4006L16.399 14.4013L16.3979 14.4028L16.3952 14.4063L16.3883 14.4153C16.383 14.4222 16.3764 14.4308 16.3683 14.4409C16.3523 14.4612 16.3306 14.488 16.3036 14.5202C16.2495 14.5846 16.1734 14.6715 16.0759 14.7732C15.8818 14.9757 15.5984 15.2422 15.2319 15.5087C14.5027 16.0391 13.4005 16.6 12 16.6C10.5995 16.6 9.49727 16.0391 8.76808 15.5087C8.40156 15.2422 8.11821 14.9757 7.92411 14.7732C7.82664 14.6715 7.75048 14.5846 7.69643 14.5202C7.66937 14.488 7.64775 14.4612 7.63166 14.4409C7.62362 14.4308 7.61695 14.4222 7.61167 14.4153L7.60479 14.4063L7.60214 14.4028L7.601 14.4013L7.60048 14.4006C7.60024 14.4003 7.60001 14.4 8.35214 13.8359L7.6 14.4C7.26863 13.9582 7.35817 13.3314 7.8 13C8.24034 12.6697 8.86441 12.7576 9.19665 13.1956M9.19955 13.1994C9.19954 13.1994 9.19955 13.1994 9.19955 13.1994V13.1994Z" fill="#101717"/>
</svg>
</span>
                            <span class="icon user d-none" data-target="#user-menu">👤</span>
                            <span class="icon hashtag d-none" data-target="#hashtag-menu">#️⃣</span>
                            <span class="icon format" data-target="#format-menu2"><svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
<path fill-rule="evenodd" clip-rule="evenodd" d="M3 21C3 20.4477 3.44772 20 4 20H20C20.5523 20 21 20.4477 21 21C21 21.5523 20.5523 22 20 22H4C3.44772 22 3 21.5523 3 21Z" fill="#101717"/>
<path fill-rule="evenodd" clip-rule="evenodd" d="M11.19 4.59741L9.4707 11.5999H14.5293L12.81 4.59741L12.8091 4.59413C12.8077 4.58876 12.8048 4.57835 12.8004 4.5636C12.7915 4.53396 12.7769 4.48783 12.7559 4.43087C12.713 4.31435 12.6485 4.16595 12.5614 4.02398C12.3731 3.71728 12.188 3.59998 12 3.59998C11.812 3.59998 11.6269 3.71728 11.4386 4.02398C11.3515 4.16595 11.287 4.31435 11.2441 4.43087C11.2231 4.48783 11.2085 4.53396 11.1996 4.5636C11.1952 4.57835 11.1923 4.58876 11.1909 4.59413L11.19 4.59741ZM14.9221 13.1999H9.07785L8.0481 17.3938C7.94286 17.8225 7.51628 18.0831 7.09532 17.9759C6.67435 17.8688 6.4184 17.4344 6.52364 17.0058L9.6664 4.20595L10.4285 4.39994C9.6664 4.20595 9.6664 4.20595 9.6664 4.20595L9.66668 4.2048L9.667 4.2035L9.66776 4.20045L9.66977 4.19256L9.67576 4.16988C9.68064 4.15181 9.68735 4.12785 9.696 4.09884C9.71325 4.04098 9.73849 3.96212 9.77276 3.86908C9.84033 3.6856 9.94772 3.43401 10.1061 3.17599C10.4089 2.68269 11.0095 2 12 2C12.9905 2 13.5911 2.68269 13.8939 3.17599C14.0523 3.43401 14.1597 3.6856 14.2272 3.86908C14.2615 3.96212 14.2868 4.04098 14.304 4.09884C14.3127 4.12785 14.3194 4.15181 14.3242 4.16988L14.3302 4.19256L14.3322 4.20045L14.333 4.2035L14.3333 4.2048C14.3333 4.2048 14.3336 4.20595 13.5714 4.39997L14.3336 4.20595L17.4764 17.0058C17.5816 17.4344 17.3257 17.8688 16.9047 17.9759C16.4837 18.0831 16.0571 17.8225 15.9519 17.3938L14.9221 13.1999Z" fill="#101717"/>
<path fill-rule="evenodd" clip-rule="evenodd" d="M9.95616 3.08439C10.2705 2.57228 10.9172 1.82495 11.9992 1.82495C13.0812 1.82495 13.7279 2.57228 14.0422 3.08439C14.2084 3.35505 14.3204 3.61784 14.3907 3.80855C14.4264 3.90549 14.4528 3.98789 14.4709 4.04879C14.48 4.07934 14.4871 4.10476 14.4924 4.1242L14.499 4.14935L14.501 4.15724L14.502 4.16099L14.5024 4.16272C14.5024 4.16266 14.5024 4.16279 14.5024 4.16272C14.5025 4.16314 14.5027 4.16375 14.5028 4.16417L17.6455 16.964C17.773 17.4834 17.4636 18.014 16.9471 18.1455C16.4293 18.2773 15.9089 17.956 15.7811 17.4355L14.7841 13.3748H9.21428L8.21726 17.4355C8.08947 17.956 7.56911 18.2773 7.05135 18.1455C6.53478 18.014 6.22536 17.4834 6.35289 16.964L9.49564 4.16417L9.56962 4.18233C9.56962 4.18235 9.56963 4.18231 9.56962 4.18233L9.49564 4.16417L9.49634 4.16137L9.49719 4.15796L9.49977 4.14782L9.50576 4.12515C9.51101 4.1057 9.51839 4.07934 9.52749 4.04879C9.54565 3.98789 9.57204 3.90549 9.60774 3.80855C9.67798 3.61784 9.79002 3.35505 9.95616 3.08439ZM9.79346 4.41903L6.6928 17.0475C6.60984 17.3853 6.81232 17.7235 7.13769 17.8063C7.46186 17.8888 7.79466 17.6889 7.87735 17.3521L8.9071 13.1581C8.92631 13.0798 8.99648 13.0248 9.07705 13.0248H14.9213C15.0019 13.0248 15.0721 13.0798 15.0913 13.1581L16.1211 17.3521C16.2037 17.6889 16.5365 17.8888 16.8607 17.8063C17.1861 17.7235 17.3886 17.3853 17.3056 17.0475L14.2049 4.41903L13.6137 4.56951C13.5201 4.59336 13.4248 4.53676 13.401 4.44309C13.3771 4.34943 13.4337 4.25417 13.5274 4.23033C13.823 4.15509 14.0038 4.10888 14.1143 4.08052C14.1003 4.03685 14.083 3.98595 14.0622 3.92951C13.9973 3.75326 13.8946 3.51287 13.744 3.26749C13.4527 2.793 12.8982 2.17495 11.9992 2.17495C11.1002 2.17495 10.5457 2.793 10.2544 3.26749C10.1038 3.51287 10.0011 3.75326 9.93618 3.92951C9.91533 3.98611 9.898 4.03715 9.88395 4.0809L10.4709 4.2303C10.5645 4.25414 10.6211 4.3494 10.5973 4.44306C10.5735 4.53672 10.4782 4.59332 10.3845 4.56948L9.79346 4.41903ZM14.2843 4.03654C14.2844 4.0365 14.2844 4.0365 14.2843 4.03654V4.03654ZM11.9992 3.77493C11.9 3.77493 11.7615 3.83118 11.587 4.11547C11.5076 4.2448 11.4478 4.382 11.4075 4.4913C11.388 4.54436 11.3745 4.58696 11.3665 4.61356C11.3627 4.62651 11.3602 4.63538 11.3591 4.63948C11.3591 4.63956 11.3591 4.63941 11.3591 4.63948L11.3588 4.64067L9.69306 11.4248H14.3053L12.6396 4.64067C12.6385 4.63668 12.6358 4.62676 12.6319 4.61356C12.624 4.58696 12.6104 4.54436 12.5909 4.4913C12.5506 4.382 12.4908 4.2448 12.4114 4.11547C12.2369 3.83118 12.0984 3.77493 11.9992 3.77493ZM11.2887 3.93238C11.4907 3.60329 11.7223 3.42493 11.9992 3.42493C12.2761 3.42493 12.5077 3.60329 12.7097 3.93238C12.8046 4.087 12.8738 4.24661 12.9193 4.37034C12.9417 4.4312 12.9575 4.48087 12.9673 4.51356C12.9721 4.52984 12.9754 4.54171 12.9773 4.54844L12.9792 4.55562L14.6985 11.5581C14.7113 11.6103 14.6994 11.6655 14.6662 11.7078C14.633 11.7501 14.5823 11.7748 14.5285 11.7748H9.4699C9.41614 11.7748 9.36536 11.7501 9.33219 11.7078C9.29901 11.6655 9.28713 11.6103 9.29994 11.5581L11.0201 4.55241L11.021 4.54914C11.0228 4.54241 11.0263 4.52984 11.0311 4.51356C11.0409 4.48087 11.0567 4.4312 11.0791 4.37034C11.1246 4.24661 11.1938 4.087 11.2887 3.93238Z" fill="#101717"/>
</svg>
</span>
                        </div>
                        <!-- Menús -->
                        <div class="menu" id="emote-menu2" style="display:none;"></div>
                        <div class="menu" id="user-menu2" style="display:none;">Usuarios</div>
                        <div class="menu" id="hashtag-menu2" style="display:none;">Hashtags</div>
                        <div class="menu" id="format-menu2" style="display:none;">
                            <button data-cmd="bold"><b>B</b></button>
                            <button data-cmd="italic"><i>I</i></button>
                            <button data-cmd="underline"><u>U</u></button>
                            <button data-cmd="strikeThrough"><s>S</s></button>
                        </div>
                    </div>
                    <!-- Botón de envío -->
                    <button id="sendButton2" class="send-button">
                        <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                            <path d="M2 21L23 12L2 3V10L17 12L2 14V21Z" fill="currentColor"/>
                        </svg>
                    </button>
                    <div id="botones-nuevo-comentario">
                        <button type="submit" id="cancelar" class="av-theme__btn av-theme__btn--secondary">
                            Cancelar</button>
                        <button type="submit" id="messageUpdateButton2" class="av-theme__btn av-theme__btn--primary">
                            Publicar</button>
                    </div>

                </div>
            </div>
        </div>
    </div>
    <script>
        $(document).ready(function () {
            let activeTextareaId2 = null;
            const editableDiv2 = document.getElementById('editable2');
            let emojiPicker2;
            let savedRange2 = null;

            $(document).on('click', 'textarea[id^="_avanisComunidadPortlet_AvanisComunidadPortlet_INSTANCE_"]', function() {
                activeTextareaId2 = $(this).attr('id');
                $('#respuestawysiwig2').show();
                $('#respuestawysiwig2 #editable2').each(function () {
                });
                $('#respuestawysiwig2 #editable2').focus();
            });

            // Detectar clic en <input>
            $(document).on('click', 'input.field.form-control[id^="_avanis_embedded_comunidad_portlet_AvanisEmbeddedComunidadPortlet_INSTANCE_"]', function() {
                //console.log("CLICK CREAR NUEVO HILO VERSION MOVIL");
                activeInputId = $(this).attr('id');
                $('#respuestawysiwig2').show();
                $('#respuestawysiwig2 #editable2').focus();
            });


            $('#closeModal2,#cancelar2').click(function() {
                $('#respuestawysiwig2').hide();
            });

            $('#messageUpdateButton2').click(function(event) {
                event.preventDefault();

                // Simular un clic en el botón "Enviar"
                $('#sendButton2').click();
            });

            $('#sendButton2').click(function() {
                //console.log("clickado sendButton2");
                //console.log("activeTextareaId2 " + activeTextareaId2);


                if (activeTextareaId2) {
                    const content = $('#editable2').html();
                    $('#' + activeTextareaId2).val(content);

                    // Simular clic en el botón de enviar asociado al textarea
                    var namespace2 = activeTextareaId2.match(/^(_avanisComunidadPortlet_AvanisComunidadPortlet_INSTANCE_\d+)_body/)[1];
                    var parentMessageId2 = activeTextareaId2.match(/\d+$/)[0]; // Extraer el número final del ID

                    // Mostrar el spinner de carga

                    if ($('#editable2').html().trim() !== '') {
                        $('#loadingSpinner').show();
                    }
                    // Construir el ID del botón de publicar basado en el namespace y el parentMessageId
                    var quickReplyButtonId = namespace2 + '_quickReplyButton' + parentMessageId2;

                    if ($('#' + quickReplyButtonId).length > 0) {
                        $('#' + quickReplyButtonId).click();
                    } else {
                        console.error('Botón de enviar no encontrado.');
                    }
                    $('#respuestawysiwig2').hide();
                }
                if (activeInputId) {
                    const content = $('#editable2').html();

                    if (typeof content === 'string') {

                        $('#' + activeInputId).val(content);

                        var namespaceInput2 = activeInputId.match(/^(_avanis_embedded_comunidad_portlet_AvanisEmbeddedComunidadPortlet_INSTANCE_\w+)_body/)[1];

                        // Construir el ID del botón de guardar basado en el namespace
                        var createThreadButtonId = namespaceInput2 + '_createEmbeddedThreadButton';

                        // Verificar si el botón existe y simular un clic
                        if ($('#' + createThreadButtonId).length > 0) {
                            $('#' + createThreadButtonId).click();

                            if ($('#editable2').html().trim() !== '') {
                                $('#loadingSpinner').show();
                            }
                        } else {
                            console.error('Botón de enviar no encontrado para el input.');
                        }
                    } else {
                        console.error('El contenido no es una cadena.');
                    }
                    $('#respuestawysiwig2').hide(); // Cerrar el modal después de enviar
                }


            });

            $('.toolbar2 .icon').on('click', function () {
                let targetMenu = $(this).data('target');
                $('.menu').not(targetMenu).hide();
                $('.icon').not(this).removeClass('active');

                if ($(targetMenu).is(':visible')) {
                    $(targetMenu).hide();
                    $(this).removeClass('active');
                } else {
                    $(targetMenu).show();
                    $(this).addClass('active');

                    if (targetMenu === '#emote-menu2') {
                        saveCursorPosition2();
                        if('<%= view %>'=== 'movil'){
                            showEmojiPicker2();
                        }
                    }
                }
            });

            async function showEmojiPicker2() {
                const emoteMenu2 = document.getElementById('emote-menu2');
                if (!emojiPicker2) {
                    const response = await fetch('/o/avanis-v2-theme/js/emoji-mart/es.json');
                    const i18n = await response.json();

                    emojiPicker2 = new EmojiMart.Picker({
                        set: 'google',
                        theme: 'light',
                        emojiSize: 24,
                        perLine: 8,
                        title: 'Selecciona un emoji',
                        i18n,
                        onEmojiSelect: (emoji) => {
                            restoreCursorPosition2();
                            insertAtCursor2(emoji.native);
                        }
                    });

                    emoteMenu2.appendChild(emojiPicker2);
                }
                setTimeout(() => {
                    const emojiPicker = document.querySelector('em-emoji-picker');
                    if (emojiPicker && emojiPicker.shadowRoot) {
                        const shadowRoot = emojiPicker.shadowRoot;
                        const previewElement = shadowRoot.querySelector('#preview');
                        if (previewElement) {
                            previewElement.style.display = 'none';
                        }
                    }
                }, 300);
            }

            function saveCursorPosition2() {
                const selection = window.getSelection();
                if (selection.rangeCount > 0) {
                    const range = selection.getRangeAt(0);
                    if (editableDiv2.contains(range.commonAncestorContainer)) {
                        savedRange2 = range;
                    }
                }
            }

            function restoreCursorPosition2() {
                const selection = window.getSelection();
                if (savedRange2) {
                    selection.removeAllRanges();
                    selection.addRange(savedRange2);
                } else {
                    editableDiv2.focus();
                }
            }

            function insertAtCursor2(text) {
                restoreCursorPosition2();
                const selection = window.getSelection();
                if (selection.rangeCount > 0) {
                    const range = selection.getRangeAt(0);
                    const textNode = document.createTextNode(text);
                    range.deleteContents();
                    range.insertNode(textNode);
                    range.setStartAfter(textNode);
                    range.setEndAfter(textNode);
                    selection.removeAllRanges();
                    selection.addRange(range);
                }
            }

            $('#format-menu2 button').on('click', function (e) {
                e.preventDefault();
                let cmd = $(this).data('cmd');
                document.execCommand(cmd, false, null);
                updateFormatMenuState2();
                $('#editable2').focus();
            });

            function updateFormatMenuState2() {
                $('#format-menu2 button').each(function () {
                    let cmd = $(this).data('cmd');
                    if (document.queryCommandState(cmd)) {
                        $(this).addClass('active');
                    } else {
                        $(this).removeClass('active');
                    }
                });
            }

            $('#editable2<portlet:namespace />').on('mouseup keyup', function () {
                updateFormatMenuState2();
                saveCursorPosition2();
            });



                $(document).on('click', 'div[id^="menu-de-acciones-3-puntos_"]', function() {
                    //console.log("Click detected on:", this);

                    // Encuentra el siguiente elemento hermano con un id que comience con "menu-abierto_"
                    var $dropdownMenu = $(this).next('div[id^="menu-abierto_"]').find('.dropdown-menu');
                    //console.log("Dropdown Menu:", $dropdownMenu);

                    if ($dropdownMenu.length) {
                        if ($dropdownMenu.css('display') === 'none') {
                            $dropdownMenu.css('display', 'block');
                            //console.log("Dropdown menu shown.");
                        } else {
                            $dropdownMenu.css('display', 'none');
                            //console.log("Dropdown menu hidden.");
                        }
                    } else {
                        console.error("No se encontró el menú desplegable.");
                    }
                });


            //INICIO Btn EDITAR POST
            $(document).on('click', '.dropdown-item.lfr-icon-item.taglib-icon.eliminar', function(event) {
                event.preventDefault(); // Evita la acción por defecto del enlace
                //console.log("CLICK MODIFICAR");
                // Encuentra el contenido del mensaje más cercano
                let messageContent = $(this).closest('.panel-body').find('.message-content').text().trim();
                //console.log("Contenido del mensaje:", messageContent);

                // Coloca el contenido del mensaje en el editor WYSIWYG
                $('#editable3').text(messageContent);

                let $menuAbierto = $(this).closest('.open.lfr-icon-menu-open');
                let fullId = $menuAbierto.attr('id');
                activeMessageId = fullId.match(/\d+$/)[0]; // Extrae el número final del ID
                //console.log("ID del mensaje activo:", activeMessageId);
                // Muestra el modal
                $('#respuestawysiwig3').show();
                $('#respuestawysiwig3 #editable').focus();
            });
            $('#messageUpdateButton3').click(function(event) {
                event.preventDefault();

                // Simular un clic en el botón "Enviar"
                $('#sendButton3').click();
            });
            $('#sendButton3').click(function(event) {
                event.preventDefault();

                //console.log("EVENTO MODIFICADO");

                let newMessageHTML = $('#editable3').html().trim();
                let newMessageText = $('#editable3').text().trim(); // Obtener solo el texto, sin HTML

                if (!newMessageText) { // Validar con el texto, no con el HTML que podría estar vacío por las etiquetas
                    console.error("El mensaje no puede estar vacío.");
                    return;
                }

                if (activeMessageId) {
                    $('#loadingSpinner').show();
                    let userId = themeDisplay.getUserId();
                    let urlHost = window.location.origin;

                    // URL con encodeURIComponent (recomendado)
                    let urlEditEncoded = urlHost + "/o/avanis/actualizarMensaje?userId=" + userId + "&messageId=" + activeMessageId + "&newMessage=" + encodeURIComponent(newMessageHTML);

                    // URL sin encodeURIComponent (para probar si es el problema)
                    let urlEditNoEncoded = urlHost + "/o/avanis/actualizarMensaje?userId=" + userId + "&messageId=" + activeMessageId + "&newMessage=" + newMessageHTML;

                    //console.log("URL construida (codificada):", urlEditEncoded);
                    //console.log("URL construida (sin codificar - PRUEBA):", urlEditNoEncoded);

                    // Prueba primero con la URL codificada
                    var settingsEncoded = {
                        "url": urlEditNoEncoded,
                        "method": "GET",
                        "timeout": 0,
                    };

                    $.ajax(settingsEncoded).done(function(response) {

                        location.reload();
                        //console.log("Respuesta AJAX (codificada):", response);
                    }).fail(function(jqXHR, textStatus, errorThrown) {
                        console.error("Error en la solicitud AJAX (codificada): ", textStatus, errorThrown);
                    });


                } else {
                    console.log("No hay un mensaje activo seleccionado para actualizar.");
                }
            });
            // Manejar el cierre del modal
            $('#closeModal3, #cancelar').on('click', function() {
                $('#respuestawysiwig3').hide();
            });
            //FIN Btn EDIAR POST
            const editableDiv3 = document.getElementById('editable3');
            let emojiPicker3;
            let savedRange3 = null;

            $('.toolbar3 .icon').on('click', function () {
                let targetMenu = $(this).data('target');
                $('.menu').not(targetMenu).hide();
                $('.icon').not(this).removeClass('active');

                if ($(targetMenu).is(':visible')) {
                    $(targetMenu).hide();
                    $(this).removeClass('active');
                } else {
                    $(targetMenu).show();
                    $(this).addClass('active');

                    if (targetMenu === '#emote-menu3') {
                        saveCursorPosition3();

                        showEmojiPicker3();

                    }
                }
            });

            async function showEmojiPicker3() {
                const emoteMenu3 = document.getElementById('emote-menu3');
                if (!emojiPicker3) {
                    const response = await fetch('/o/avanis-v2-theme/js/emoji-mart/es.json');
                    const i18n = await response.json();

                    emojiPicker3 = new EmojiMart.Picker({
                        set: 'google',
                        theme: 'light',
                        emojiSize: 24,
                        perLine: 8,
                        title: 'Selecciona un emoji',
                        i18n,
                        onEmojiSelect: (emoji) => {
                            restoreCursorPosition3();
                            insertAtCursor3(emoji.native);
                        }
                    });

                    emoteMenu3.appendChild(emojiPicker3);
                }
                setTimeout(() => {
                    const emojiPicker = document.querySelector('em-emoji-picker');
                    if (emojiPicker && emojiPicker.shadowRoot) {
                        const shadowRoot = emojiPicker.shadowRoot;
                        const previewElement = shadowRoot.querySelector('#preview');
                        if (previewElement) {
                            previewElement.style.display = 'none';
                        }
                    }
                }, 300);
            }

            function saveCursorPosition3() {
                const selection = window.getSelection();
                if (selection.rangeCount > 0) {
                    const range = selection.getRangeAt(0);
                    if (editableDiv3.contains(range.commonAncestorContainer)) {
                        savedRange3 = range;
                    }
                }
            }

            function restoreCursorPosition3() {
                const selection = window.getSelection();
                if (savedRange3) {
                    selection.removeAllRanges();
                    selection.addRange(savedRange3);
                } else {
                    editableDiv3.focus();
                }
            }

            function insertAtCursor3(text) {
                restoreCursorPosition3();
                const selection = window.getSelection();
                if (selection.rangeCount > 0) {
                    const range = selection.getRangeAt(0);
                    const textNode = document.createTextNode(text);
                    range.deleteContents();
                    range.insertNode(textNode);
                    range.setStartAfter(textNode);
                    range.setEndAfter(textNode);
                    selection.removeAllRanges();
                    selection.addRange(range);
                }
            }

            $('#format-menu3 button').on('click', function (e) {
                e.preventDefault();
                let cmd = $(this).data('cmd');
                document.execCommand(cmd, false, null);
                updateFormatMenuState3();
                $('#editable3').focus();
            });

            function updateFormatMenuState3() {
                $('#format-menu3 button').each(function () {
                    let cmd = $(this).data('cmd');
                    if (document.queryCommandState(cmd)) {
                        $(this).addClass('active');
                    } else {
                        $(this).removeClass('active');
                    }
                });
            }

            $('#editable3<portlet:namespace />').on('mouseup keyup', function () {
                updateFormatMenuState3();
                saveCursorPosition3();
            });
        });








        //Btn ELIMINAR post
        if (typeof themeDisplay !== 'undefined') {
            //console.log("User ID from themeDisplay:", themeDisplay.getUserId());

            $(document).on('click', 'a[id^="btn-eliminar_"]', function(event) {
                event.preventDefault(); // Evita que el enlace realice su acción por defecto

                let $this = $(this);
                let userId = themeDisplay.getUserId();
                let fullId = $this.attr('id');
                //console.log("Full ID:", fullId);

                let idMessaje = fullId.split('_')[1];
                //console.log("Message ID:", idMessaje);

                if (!userId || !idMessaje) {
                    console.error("Error: User ID o Message ID no están definidos.");
                    return;
                }

                // Verificar si el menú correspondiente está visible
                let $menuAbierto = $('#menu-abierto_' + idMessaje);
                //console.log("Verificando visibilidad del menú:", $menuAbierto);

                if ($menuAbierto.length && $menuAbierto.css('display') === 'block') {
                    //console.log("El menú está visible, procediendo con la solicitud AJAX.");
                    $('#loadingSpinner').show();

                    let urlHost = window.location.origin;
                    let urlEdit = urlHost + "/o/avanis/eliminarMensaje?userId=" + userId + "&messageId=" + idMessaje;

                    //console.log("URL construida:", urlEdit);

                    var settings = {
                        "url": urlEdit,
                        "method": "GET",
                        "timeout": 0,
                    };

                    $.ajax(settings).done(function(response) {
                        //console.log("Respuesta AJAX:", response);
                        location.reload();
                    }).fail(function(jqXHR, textStatus, errorThrown) {
                        console.error("Error en la solicitud AJAX: ", textStatus, errorThrown);
                    });
                } else {
                    //console.log("El menú no está visible, no se realizará la solicitud AJAX.");
                }
            });

        } else {
            console.error("themeDisplay no está definido.");
        }

    </script>
</c:if>
<script>

</script>




