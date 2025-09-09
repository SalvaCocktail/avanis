<%@ include file="../init.jsp" %>

<%
MBMessage message = (MBMessage)request.getAttribute(WebKeys.MESSAGE_BOARDS_MESSAGE);

request.setAttribute("edit-message.jsp-showPermanentLink", Boolean.FALSE);
request.setAttribute("edit-message.jsp-showRecentPosts", Boolean.FALSE);
request.setAttribute("edit_message.jsp-category", message.getCategory());
request.setAttribute("edit_message.jsp-editable", Boolean.FALSE);
request.setAttribute("edit_message.jsp-message", message);
request.setAttribute("edit_message.jsp-thread", message.getThread());
%>

<liferay-util:include page="/view_message_detail.jsp" servletContext="<%= application %>" />
