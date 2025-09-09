<%@ page import="com.liferay.message.boards.model.MBThread" %>
<%@ include file="/init.jsp" %>

<div class="crear-nuevo-hilo">
<liferay-portlet:runtime portletName="avanisComunidadPortlet_AvanisComunidadPortlet"
                         instanceId='${thread.threadId}'
                         queryString="mvcRenderCommandName=render_cmd_command&messageId=${thread.rootMessageId}&isEmbedded=true"
/>
</div>