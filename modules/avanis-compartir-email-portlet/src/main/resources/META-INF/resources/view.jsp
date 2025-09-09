<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/init.jsp" %>
<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>

<portlet:actionURL var="compartirActualidadMail">
    <portlet:param
            name="javax.portlet.action"
            value="submitForm"
    />
</portlet:actionURL>

<div class="av-ac-modal-partial av-ac-mp">
    <aui:form
            action="${compartirActualidadMail}"
            method="post"
            name="myForm"
            cssClass="av-ac-mp__form"
    >
        <aui:input type="hidden" name="resourceName" value="${resourceName}"/>
        <aui:input type="hidden" name="resourceId" value="${resourceId}"/>
        <aui:input type="hidden" name="url" value="${url}"/>
        <div class="av-ac-mp__share">



              <span class="av-ac-mp__label">
                Escribe los emails separados por comas (,)
              </span>
            <div id="emailForm">
                <div
                        class="tags-input"
                        id="tagsInput"
                >
                    <aui:input
                            id="emailInput"
                            name="emails"
                            type="text"
                            label="Emails"
                            placeholder="Escribe los emails aquí... "
                            cssClass="av-ac-mp__share-input"
                            required="true"
                    >

                    </aui:input>
                </div>

                <div
                        id="error-message"
                        class="text-danger"
                ></div>
            </div>
        </div>

        <div class="av-ac-mp__email">
            <h5 class="av-ac-mp__title portlet-compartir-email">Tu email </h5>

            <c:if test="${usermail != null}">
                <aui:input
                        id="emailInputBottom"
                        name="tumail"
                        type="text"
                        label=""
                        max="20"
                        min="5"
                        value="${not themeDisplay.getUser().defaultUser ? usermail : ''}"
                        disabled="true"
                        placeholder="${not themeDisplay.getUser().defaultUser ? usermail : ''}"
                        cssClass="form-control av-ac-mp__input av-ac-mp__email-input"
                >
                    <aui:validator name="required"/>
                    <aui:validator
                            name="stringLength"
                            errorMessage="Debe tener entre 5 y 20 caracteres."
                    />
                </aui:input>
            </c:if>

            <div
                    id="error-message-email"
                    class="av-ac-mp__error-message"
            ></div>

            <span class="av-ac-mp__email-disclaimer av-ac-mp__email-disclaimer2">
        Solo lo compartiremos con la persona a la que lo envías
      </span>
        </div>

        <div class="av-ac-mp__message">
            <div class="av-ac-mp__message-link">
                <svg
                        width="14"
                        height="14"
                        viewBox="0 0 14 14"
                        fill="none"
                        xmlns="http://www.w3.org/2000/svg"
                        class="av-ac-mp__message-link-img"
                >
                    <path
                            fill-rule="evenodd"
                            clip-rule="evenodd"
                            d="M7 0C7.55228 0 8 0.447715 8 1V6H13C13.5523 6 14 6.44772 14 7C14 7.55228 13.5523 8 13 8H8V13C8 13.5523 7.55228 14 7 14C6.44772 14 6 13.5523 6 13V8H1C0.447715 8 0 7.55228 0 7C0 6.44772 0.447715 6 1 6H6V1C6 0.447715 6.44772 0 7 0Z"
                            fill="#107E3E"
                    />
                </svg>
                <span class="av-ac-mp__message-link-text"> Añadir un mensaje </span>
            </div>

            <div class="av-ac-mp__message-text">
                <aui:input
                        id="messageTextArea"
                        name="mensaje"
                        label="Escribe un mensaje"
                        type="textarea"
                        placeholder="Escribir aquí..."
                        cssClass="av-ac-mp__input av-ac-mp__message-text-textarea"
                >

                </aui:input>
            </div>
        </div>

        <div class="av-ac-mp__buttons">
            <aui:button
                    type="button"
                    value="Cancelar"
                    cssClass="navbar__btn navbar__btn--outline modal-btn av-ac-mp__cancel"
            />

            <aui:button
                    type="submit"
                    id="shareEmailSubmitButton"
                    value="Enviar"
                    cssClass="navbar__btn navbar__btn--primary modal-btn av-ac-mp__send"
            />
        </div>

    </aui:form>
</div>

<c:choose>
    <c:when test='${"MBMessage".equals(resourceName) || "AyudasSubvenciones".equals(resourceName) || "Eventos".equals(resourceName)}'>
        <script>
            $("#<portlet:namespace/>shareEmailSubmitButton").on("click", function (e) {
                e.preventDefault();

                const form = document.getElementById('<portlet:namespace/>myForm');
                const formData = new FormData(form);

                fetch(form.action, {
                    method: form.method,
                    body: formData,
                }).then(response => {
                    window.parent.closeSharePopup("AvanisComunidad_dialogShare");
                }).catch(error => {
                    window.parent.closeSharePopup("AvanisComunidad_dialogShare");
                })


            })
        </script>
    </c:when>
</c:choose>

<style>
    .tags-input {
        display: flex;
        align-items: center;
        flex-wrap: wrap;
        border: 1px solid #ccc;
        padding: 8px;
        border-radius: 4px;
        gap: 5px;
    }
    #tagsInput .input-text-wrapper label {
        display: none;
    }

    .tag-email {
        background-color: #e0e0e0;
        border-radius: 4px;
        padding: 5px 10px;
        display: flex;
        align-items: center;
        font-size: 14px;
    }

    .tag-close {
        margin-left: 5px;
        cursor: pointer;
        font-weight: bold;
        color: #555;
    }

</style>

<!--<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>-->
<script>
    $(document).ready(function () {
        const emailInput = $("#<portlet:namespace/>emailInput");
        const tagsInputContainer = $("#tagsInput");
        const messageLink = $(".av-ac-mp__message-link");
        const messageText = $(".av-ac-mp__message-text");
        let emails = [];

        // Valido formato de email
        function isValidEmail(email) {
            const regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
            return regex.test(email);
        }

        // Añado un tag visual y almaceno el email en el input
        function addTag(email) {
            if (isValidEmail(email) && !emails.includes(email)) {
                // Crear el tag visual
                const tag = $('<span class="tag"></span>').text(email);
                const closeBtn = $('<span class="tag-close">x</span>').click(function () {
                    tag.remove();
                    emails = emails.filter(e => e !== email); // Quitar el email de la lista
                    emailInput.val(emails.join(", ")); // Actualizar el input
                });
                tag.append(closeBtn);
                tagsInputContainer.append(tag); // Agregar el tag al contenedor

                // Actualizar lista de emails y el valor del input
                emails.push(email);
                emailInput.val(emails.join(", "));
            }
        }

        // Muestro el input al hacer clic en cualquier parte de #emailForm
        $("#emailForm").on("click", function () {
            emailInput.show().focus(); // Mostrar el input y darle foco
        });

        // Detecto cuando se pierde el foco del input
        emailInput.on("blur", function () {
            const rawText = emailInput.val();
            const potentialEmails = rawText.split(",").map(e => e.trim());

            // Limpo los tags existentes
            tagsInputContainer.find('.tag').remove();

            // Limpo la lista de emails y re-llenarla
            emails = [];
            potentialEmails.forEach(email => addTag(email)); // Añadir tags para los emails válidos

            // Oculto el input si contiene algún correo
            if (emails.length > 0) {
                emailInput.hide();
            }
        });

        // Muestro/oculto .av-ac-mp__message-link según el contenido del input
        emailInput.on("input", function () {
            if (emailInput.val().trim() === "") {
                messageLink.hide(); // Ocultar el enlace si el input está vacío
            } else {
                messageLink.show(); // Mostrar el enlace si el input contiene texto
            }
        });

        // Muestro .av-ac-mp__message-text con fadeIn al hacer clic en .av-ac-mp__message-link
        messageLink.on("click", function () {
            messageText.fadeIn();
        });

        // Oculto inicialmente .av-ac-mp__message-link si el input está vacío
        if (emailInput.val().trim() === "") {
            messageLink.fadeOut();
            messageText.fadeOut();
        }
    });


</script>













