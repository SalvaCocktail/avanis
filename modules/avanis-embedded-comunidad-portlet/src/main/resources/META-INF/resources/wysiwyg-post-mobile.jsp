<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>

<div class="modal-respuestaposts2">
    <div id="respuestawysiwig2" class="av-te-ma-modal alertModal" style="display: none;">
        <div class="av-te-ma-modal__panel">
            <div class="av-te-ma-modal__header">
                <h5 class="modal-title" id="exampleModalLabel">Nuevo comentario</h5>
                <span id="closeModal2" class="av-icon-close">&times;</span>
            </div>
            <div class="av-te-ma-modal__content">
                <div class="input-container">
                    <div id="editable2<portlet:namespace />" contenteditable="true" placeholder="Escribe algo"></div>
                    <div class="toolbar2">
                        <span class="icon2 smiley2" data-target="#emote-menu2">
                            <!-- SVG ICON -->
                        </span>
                        <span class="icon2 user d-none" data-target="#user-menu2">👤</span>
                        <span class="icon2 hashtag d-none" data-target="#hashtag-menu2">#️⃣</span>
                        <span class="icon2 format" data-target="#format-menu2">
                            <!-- SVG ICON -->
                        </span>
                    </div>
                    <div class="menu" id="emote-menu2" style="display:none;">Emotes</div>
                    <div class="menu" id="user-menu2" style="display:none;">Usuarios</div>
                    <div class="menu" id="hashtag-menu2" style="display:none;">Hashtags</div>
                    <div class="menu" id="format-menu2" style="display:none;">
                        <button data-cmd="bold"><b>B</b></button>
                        <button data-cmd="italic"><i>I</i></button>
                        <button data-cmd="underline"><u>U</u></button>
                        <button data-cmd="strikeThrough"><s>S</s></button>
                    </div>
                </div>
                <button id="sendButton2" class="send-button2">
                    <!-- SVG ICON -->
                </button>
                <div id="botones-nuevo-comentario2">
                    <button type="submit" id="cancelar2" class="av-theme__btn av-theme__btn--secondary">Cancelar</button>
                    <button type="submit" id="messageUpdateButton2" class="av-theme__btn av-theme__btn--primary">Publicar</button>
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
        });

        $('#closeModal2').click(function() {
            $('#respuestawysiwig2').hide();
        });

        $('#sendButton2').click(function() {
            if (activeTextareaId2) {
                const content = $('#editable2').html();
                $('#' + activeTextareaId2).val(content);

                const parentMessageId = activeTextareaId2.match(/\d+$/)[0];
                const quickReplyButtonId = '_avanisComunidadPortlet_AvanisComunidadPortlet_INSTANCE_202092_quickReplyButton' + parentMessageId;

                if ($('#' + quickReplyButtonId).length > 0) {
                    $('#' + quickReplyButtonId).click();
                } else {
                    console.error('Botón de enviar no encontrado.');
                }
            }

            $('#respuestawysiwig2').hide();
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
            $('#editable2<portlet:namespace />').focus();
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
    });
</script>