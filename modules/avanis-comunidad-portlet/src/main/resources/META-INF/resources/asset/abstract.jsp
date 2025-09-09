<%@ include file="../init.jsp" %>

<%
int abstractLength = GetterUtil.getInteger(request.getAttribute(WebKeys.ASSET_ENTRY_ABSTRACT_LENGTH), AssetHelper.ASSET_ENTRY_ABSTRACT_LENGTH);

MBMessage message = (MBMessage)request.getAttribute(WebKeys.MESSAGE_BOARDS_MESSAGE);

String summary = message.getBody();

if (message.isFormatBBCode()) {
	summary = MBUtil.getBBCodeHTML(summary, themeDisplay.getPathThemeImages());
}
%>

<div class="asset-summary">
	<%= StringUtil.shorten(HtmlUtil.stripHtml(summary), abstractLength) %>
</div>
