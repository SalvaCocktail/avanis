<%@ include file="./init.jsp" %>


<div id="message-page-container">
    <aui:fieldset>
        <%
            List<MBThread> threads = (ArrayList<MBThread>) request.getAttribute("threads");

            for (MBThread mbThread : threads) {
                MBMessageDisplay messageDisplay = MBMessageServiceUtil.getMessageDisplay(
                        mbThread.getRootMessageId(), WorkflowConstants.STATUS_APPROVED);

                request.setAttribute(
                        WebKeys.MESSAGE_BOARDS_MESSAGE_DISPLAY, messageDisplay);

        %>

        <liferay-util:include page="/view_message.jsp" servletContext="<%= application %>"/>

        <%
            }
        %>
    </aui:fieldset>

    <div id="infinite-scroll-form-container">
        <form id="infinite-scroll-form">
            <input type="hidden" name="offset" value="${offset}">
            <input type="hidden" name="showSentinel" value="${showSentinel}">
        </form>
    </div>

</div>




