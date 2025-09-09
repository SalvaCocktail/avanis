<div class="modal-respuestaposts">
    <div id="respuestawysiwig" class="av-te-ma-modal alertModal" style="display: none;">
        <div class="av-te-ma-modal__panel">
            <div class="av-te-ma-modal__header">
                <span id="closeModal" class="av-icon-close">&times;</span>
            </div>
            <div class="av-te-ma-modal__content">
                <!-- Editor WYSIWYG -->
                <div class="input-container">
                    <div id="editable" contenteditable="true" placeholder="Escribe algo"></div>
                    <div class="toolbar">
                        <span class="icon smiley" data-target="#emote-menu">🙂</span>
                        <span class="icon user d-none" data-target="#user-menu">👤</span>
                        <span class="icon hashtag d-none" data-target="#hashtag-menu">#️⃣</span>
                        <span class="icon format" data-target="#format-menu">🅱️</span>
                    </div>
                    <!-- Menús -->
                    <div class="menu" id="emote-menu" style="display:none;">Emotes</div>
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
        });

// Cerrar el modal al hacer clic en la "X"
        $('#closeModal').click(function() {
            $('#respuestawysiwig').hide();
        });

// Transferir contenido y enviar al hacer clic en el botón de enviar
        $('#sendButton').click(function() {
            if (activeTextareaId) {
                const content = $('#editable').html();
                $('#' + activeTextareaId).val(content);

                // Simular clic en el botón de enviar asociado al textarea
                const parentMessageId = activeTextareaId.match(/\d+$/)[0];
                const quickReplyButtonId = '_avanisComunidadPortlet_AvanisComunidadPortlet_INSTANCE_202092_quickReplyButton' + parentMessageId;

                if ($('#' + quickReplyButtonId).length > 0) {
                    $('#' + quickReplyButtonId).click();
                } else {
                    console.error('Botón de enviar no encontrado.');
                }
            }

            $('#respuestawysiwig').hide();
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
            $('#editable<portlet:namespace />').focus();
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

