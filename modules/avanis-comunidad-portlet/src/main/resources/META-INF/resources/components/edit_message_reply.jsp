<%@ include file="../init.jsp" %>
<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>
<%
    long messageId = ParamUtil.getLong(request, "messageId");
    if (Validator.isNull(messageId)) {
        messageId = (long) request.getAttribute("messageId");
    }

    MBMessage message = MBMessageLocalServiceUtil.fetchMBMessage(messageId);

    long categoryId = 0L; //message.getCategoryId();
    long threadId = message.getThreadId();
    long parentMessageId = message.getMessageId();

    String subject = ParamUtil.getString(request, "subject");
    double priority = message.getPriority();

    if (threadId > 0) {
        try {
            if (Validator.isNull(subject)) {
                String messageSubject = message.getSubject();

                if (messageSubject.startsWith(MBMessageConstants.MESSAGE_SUBJECT_PREFIX_RE)) {
                    subject = messageSubject;
                } else {
                    subject = MBMessageConstants.MESSAGE_SUBJECT_PREFIX_RE + messageSubject;
                }
            }
        } catch (Exception e) {
        }
    }

    String redirect = ParamUtil.getString(request, "redirect");
%>
<c:if test="<%= themeDisplay.isSignedIn() %>">
    <div class="panel-body">
        <div class="card-body message-content" id="<portlet:namespace />addQuickReply<%= parentMessageId %>">
            <portlet:actionURL name="<%= Constants.UPDATE %>" var="updateMessageURL"
                               windowState="<%=LiferayWindowState.NORMAL.toString() %>"/>
            <portlet:resourceURL var="quickReplyURL" id="resource_cmd_command">
                <portlet:param name="cmd" value="quickyReply"/>
            </portlet:resourceURL>

            <aui:form method="post" cssClass="replyFm"
                      name='<%= "addQuickReplyFm" + parentMessageId %>' id='<%= "addQuickReplyFm" + parentMessageId %>'>
                <input type="hidden" name="<portlet:namespace />inputPermissionsViewRolemessageId" value="Guest">
                <aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.ADD %>"/>
                <aui:input name="redirect" type="hidden" value="<%= redirect %>"/>
                <aui:input name="messageId" type="hidden" value="<%= 0 %>"/>
                <aui:input name="mbCategoryId" type="hidden" value="<%= categoryId %>"/>
                <aui:input name="threadId" type="hidden" value="<%= threadId %>"/>
                <aui:input name="parentMessageId" type="hidden" value="<%= parentMessageId %>"/>
                <aui:input name="subject" type="hidden" value="<%= subject %>"/>
                <aui:input name="priority" type="hidden" value="<%= priority %>"/>
                <aui:input name="propagatePermissions" type="hidden" value="<%= true %>"/>
                <aui:input name="isFromDetail" type="hidden" value="${isFromDetail}"/>
                <aui:input name="workflowAction" type="hidden"
                           value="<%= String.valueOf(WorkflowConstants.ACTION_PUBLISH) %>"/>

                <aui:model-context bean="<%= message %>" model="<%= MBMessage.class %>"/>

                <label for="<portlet:namespace />body<%= parentMessageId %>"></label>

                <div class="div-responder-post-hilo">
                    <clay:content-col>
                        <%
                            // Obtener el nombre y apellido del usuario
                            String firstName = user.getFirstName();
                            String lastName = user.getLastName();

                            // Obtener las iniciales
                            String initials = (firstName != null && lastName != null)
                                    ? (firstName.substring(0, 1) + lastName.substring(0, 1)).toUpperCase()
                                    : "NN";

                            // Comprobar si el usuario tiene una imagen de perfil
                            boolean hasPortrait = user.getPortraitId() > 0;
                        %>

                        <c:choose>
                            <c:when test="<%= hasPortrait %>">
                                <!-- Mostrar el retrato del usuario si tiene -->
                                <liferay-user:user-portrait userId="<%= user.getUserId() %>"/>
                            </c:when>
                            <c:otherwise>
                                <!-- Mostrar las iniciales si no tiene retrato -->
                                <div class="user-initials-avatar">
                                    <%= initials %>
                                </div>
                            </c:otherwise>
                        </c:choose>
                    </clay:content-col>

                    <!-- Textarea para responder -->
                    <textarea id="<portlet:namespace />body<%= parentMessageId %>" name="<portlet:namespace />body" required="required"
                            <c:if test="<%= message.getMessageId() == message.getRootMessageId() %>">
                                rows="1" placeholder="Escribe un comentario"
                            </c:if>
        <c:if test="<%= message.getMessageId() != message.getRootMessageId() %>">
            rows="3" placeholder="Responde al comentario"
        </c:if>
                    ></textarea>

                    <div class="sheet-footer">

                        <!-- Botón para publicar la respuesta -->
                        <aui:button id='<%= "quickReplyButton" + parentMessageId %>'
                                    name='<%= "quickReplyButton" + parentMessageId %>' type="button"
                                    onClick='<%="quickReply" + threadId + "(this)"%>' value="publish"/>

                        <%
                            // Botón para cancelar la respuesta
                            String taglibCancelReply = "javascript:" + liferayPortletResponse.getNamespace() + "hideReplyMessage('" + parentMessageId + "');";
                        %>
                        <aui:button onClick="<%= taglibCancelReply %>" type="cancel"/>
                    </div>
                </div>
                <div role="alert" class="post-required" >El comentario no puede estar vacío.</div>
            </aui:form>
        </div>
    </div>
</c:if>
<aui:script>
    window[
    '<portlet:namespace/>replyMessageOnChange<%= parentMessageId %>'
    ] = function (html) {
    Liferay.Util.toggleDisabled(
    '#<portlet:namespace/>quickReplyButton<%= parentMessageId %>',
    html === ''
    );
    };
</aui:script>

<script type="text/javascript" language="javascript">

    function quickReply<%= threadId %>(submitButton) {
        let form = $(submitButton).closest("form");

        // Selecciona el textarea asociado al formulario
        let commentField = form.find('textarea[id*="_avanisComunidadPortlet_AvanisComunidadPortlet_"][id*="_body"]');
        let errorMessage = form.find('div.post-required'); // Mensaje de error específico del formulario

        // Verifica si se encontró el textarea
        if (commentField.length === 0) {
            console.error("No se encontró el textarea asociado al formulario.");
            return false;
        }

        // Verifica si el campo de comentario está vacío
        if (commentField.val().trim() === "") {
            commentField.css("border", "2px solid red");
            errorMessage.css("display", "block");
            return false; // Detiene el envío
        }

        // Si el campo tiene contenido, limpio css error
        commentField.css("border", "");
        errorMessage.css("display", "none");

        let formData = form.serialize();

        // Envío AJAX
        $.ajax({
            url: '${quickReplyURL}',
            type: 'POST',
            data: formData,
            success: function (data) {
                window.location.reload();
            },
            error: function (xhr, status, error) {
                console.error("Error en la petición AJAX:", error);
            }
        });
        return false;
    }

    // Manejo para revertir errores en tiempo real
    $(document).ready(function() {
        // Aplico a todos los textareas que coincidan con el nombre y longitud esperados
        $('textarea[id*="_avanisComunidadPortlet_AvanisComunidadPortlet_"][id*="_body"]').each(function () {
            let commentField = $(this); // Cada textarea individual
            let errorMessage = commentField.closest('form').find('div.post-required'); // Mensaje de error relacionado

            // Detecto cuando el usuario escribe
            commentField.on("input", function () {
                if (commentField.val().trim() !== "") {
                    commentField.css("border", "");
                    errorMessage.css("display", "none");
                }
            });
        });
    });


</script>

