<%@ page import="com.liferay.expando.kernel.model.ExpandoBridge" %>
<%@ page import="java.util.regex.Matcher" %>
<%@ page import="java.util.regex.Pattern" %>

<%@ include file="init.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<liferay-util:dynamic-include key="avanisComunidadPortlet#view_thread_message.jsp#pre"/>

<%
    MBMessage message = (MBMessage) request.getAttribute("edit_message.jsp-message");
    request.setAttribute("messageId", message.getMessageId());
    MBThread thread = (MBThread)request.getAttribute("edit_message.jsp-thread");

    // Recuperar categorías del hilo si es el mensaje raíz
    List<AssetCategory> categoriesThread = ActionUtil.getThreadCategories(message.getMessageId(), thread.getRootMessageId());

    // Información del usuario y fecha del mensaje
    String messageUserName = ActionUtil.getMessageUserName(message);
    String messageUserPerfilPublicoURL = ActionUtil.getMessageUserProfileURL(message.getUserId());
    Date displayDate = message.getCreateDate();

    String rootDateDisplayText = "";
    String dayDescription = dayFormat.format(displayDate);
    String monthDescription = monthFormat.format(displayDate);
    String timeDescription = timeFormat.format(displayDate);
    if (message.getMessageId() == message.getRootMessageId()) {
        rootDateDisplayText = dayDescription + " de " + monthDescription + " a las " + timeDescription;
    }

    String displayDateDescription = LanguageUtil.getTimeDescription(request, System.currentTimeMillis() - displayDate.getTime(), true);
    String agoDisplayText = LanguageUtil.format(request, "x-ago", new Object[]{displayDateDescription});

    // Contadores usando ActionUtil
    int posts = ActionUtil.getChildMessagesCount(message.getMessageId());
    int countLikes = ActionUtil.getLikesCount(message.getMessageId());
    boolean userLiked = ActionUtil.hasUserLiked(message.getMessageId(), user.getUserId());

    // Atributos personalizados usando ExpandoBridge
    ExpandoBridge expandoBridge = message.getExpandoBridge();
    Integer shareds = (Integer) expandoBridge.getAttribute("shared");
    String[] visibilities = (String[]) expandoBridge.getAttribute("visibility");
    String messageVisibility = "registered";

    if (visibilities != null && visibilities.length > 0) {
        messageVisibility = visibilities[0];
    }

    // Funciones JavaScript generadas dinámicamente
    String functionShareThread = "javascript:functionShareThreadURL" + thread.getRootMessageId() + "(" + message.getMessageId() + ");";
    String functionUpdateThread = "javascript:functionUpdateThreadURL" + thread.getRootMessageId() + "(" + message.getMessageId() + ");";
    String functionLike = "javascript:submitLike" + thread.getRootMessageId() + "(" + message.getMessageId() + ");";
    String functionLikeDelete = "javascript:deleteLike" + thread.getRootMessageId() + "(" + message.getMessageId() + ");";
    String iLikeId = "ilike_" + message.getMessageId();
    String iLikeDeleteId = "idelete_" + message.getMessageId();

    // Procesar el cuerpo del mensaje usando ActionUtil
    String msgBody = ActionUtil.processMessageBody(message.getBody(), themeDisplay.getPathThemeImages());

    StringBuilder userNameList = ActionUtil.getUserNameList(message.getMessageId());
    request.setAttribute("userNameList", userNameList);

    String taglibReplyToMessageURL = "javascript:" + liferayPortletResponse.getNamespace() +
            "addReplyToMessage('" + message.getMessageId() + "', '');";

    if (message.getMessageId() == message.getRootMessageId()) {
        taglibReplyToMessageURL = "javascript:document.getElementById('" +
                liferayPortletResponse.getNamespace() + "body" + message.getMessageId() + "').click()";
    }

    request.setAttribute("taglibReplyToMessageURL", taglibReplyToMessageURL);
%>

<a id="<portlet:namespace />message_<%= message.getMessageId() %>"></a>

<c:if test="<%= message.getMessageId() == message.getRootMessageId() %>">
    <%@ include file="view_message_detail_thread.jspf" %>
</c:if>
<c:if test="<%= message.getMessageId() != message.getRootMessageId() %>">
    <%@ include file="view_message_detail_reply.jspf" %>
</c:if>

<liferay-util:dynamic-include key="avanisComunidadPortlet#view_thread_message.jsp#post"/>

<script type="text/javascript" language="javascript">

    $(document).ready(function () {
        $('#<portlet:namespace />encuesta_<%= message.getMessageId() %>').on('click', '.progress-group.progress-info', function () {
            // Verifica si el usuario está logado
            var isLoggedIn = <%= themeDisplay.isSignedIn() ? "true" : "false" %>;

            // Si el usuario no está logado, mostrar un mensaje y salir
            if (!isLoggedIn) {
                Liferay.Util.openToast({
                    message: 'Debes iniciar sesión para votar.',
                    type: 'danger'
                });
                return; // Sale de la función sin continuar
            }

            // Busco el span.survey-end-date dentro del contenedor de la encuesta
            var surveyEndDateText = $(this).closest('.encuesta').find('.survey-end-date').text().trim();

            if (surveyEndDateText !== "Encuesta Finalizada") {
                // Muestro notificación de éxito con Liferay.Util.openToast()
                Liferay.Util.openToast({
                    message: '¡Votación realizada con éxito!',
                    type: 'success'
                });

                updateSurvey<%= message.getMessageId() %>($(this).attr('data-value'));
            } else {
                // Notificación encuesta está finalizada
                Liferay.Util.openToast({
                    message: 'La encuesta ya está finalizada. No puedes votar.',
                    type: 'danger'
                });
            }
        });

        <% if(userLiked){ %>
        $('#<portlet:namespace />ilike_<%= message.getMessageId() %>').parent().hide();
        $('#<portlet:namespace />idelete_<%= message.getMessageId() %>').parent().removeClass('hide');
        $('#<portlet:namespace />idelete_<%= message.getMessageId() %>').parent().show();
        <% } else { %>
        $('#<portlet:namespace />idelete_<%= message.getMessageId() %>').parent().hide();
        $('#<portlet:namespace />ilike_<%= message.getMessageId() %>').parent().removeClass('hide');
        $('#<portlet:namespace />ilike_<%= message.getMessageId() %>').parent().show();
        <% } %>

        $('.social-interaction').removeClass('hide');
    });

</script>