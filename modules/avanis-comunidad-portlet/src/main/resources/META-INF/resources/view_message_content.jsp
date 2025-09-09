<%@ include file="init.jsp" %>

<%
    MBMessageDisplay messageDisplay = (MBMessageDisplay) request.getAttribute(WebKeys.MESSAGE_BOARDS_MESSAGE_DISPLAY);

    MBTreeWalker mbTreeWalker = messageDisplay.getTreeWalker();
    MBMessage rootMessage = mbTreeWalker.getRoot();
    MBMessage message = messageDisplay.getMessage();
    MBCategory category = messageDisplay.getCategory();
    MBThread thread = messageDisplay.getThread();
    boolean portletTitleBasedNavigation = GetterUtil.getBoolean(portletConfig.getInitParameter("portlet-title-based-navigation"));

    if (portletTitleBasedNavigation) {
        portletDisplay.setShowBackIcon(true);
        portletDisplay.setURLBack(ParamUtil.getString(request, "redirect"));
        if (Validator.isNotNull(renderResponse)) {
            renderResponse.setTitle(message.getSubject());
        }
    }
%>

<div class="thread-container">

    <%

        assetHelper.addLayoutTags(request, AssetTagLocalServiceUtil.getTags(MBMessage.class.getName(), thread.getRootMessageId()));

    %>

    <div class="message-scroll" id="<portlet:namespace />message_0"></div>

    <div class="card-tab-group message-container" id="<portlet:namespace />messageContainer">

        <div class="card panel">
            <%
                request.setAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER, mbTreeWalker);
                request.setAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER_CATEGORY, category);
                request.setAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER_CUR_MESSAGE, rootMessage);
                request.setAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER_DEPTH, Integer.valueOf(0));
                request.setAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER_LAST_NODE, Boolean.valueOf(false));
                request.setAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER_SEL_MESSAGE, message);
                request.setAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER_THREAD, thread);
                request.setAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER_VIEWABLE_THREAD, Boolean.FALSE.toString());

            %>

            <liferay-util:include page="/view_thread_tree.jsp" servletContext="<%= application %>"/>

            <%

                int index = 0;
                int rootIndexPage = 0;
                boolean moreMessagesPagination = false;

                List<MBMessage> messages = mbTreeWalker.getMessages();

                int[] range = mbTreeWalker.getChildrenRange(rootMessage);

                MBMessageIterator mbMessageIterator = new MBMessageIterator(messages, range[0], range[1]);

                while (mbMessageIterator.hasNext()) {
                    boolean messageFound = GetterUtil.getBoolean(request.getAttribute("view_thread_tree.jsp-messageFound"));

                    index = GetterUtil.getInteger(request.getAttribute(WebKeys.MESSAGE_BOARDS_TREE_INDEX), 1);

                    rootIndexPage = mbMessageIterator.getIndexPage();

                    if (messageFound && ((index + 1) > PropsValues.DISCUSSION_COMMENTS_DELTA_VALUE)) {
                        moreMessagesPagination = true;

                        break;
                    }
                    moreMessagesPagination = false;

                    request.setAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER, mbTreeWalker);
                    request.setAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER_CATEGORY, category);
                    request.setAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER_CUR_MESSAGE, mbMessageIterator.next());
                    request.setAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER_DEPTH, Integer.valueOf(0));
                    request.setAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER_LAST_NODE, Boolean.valueOf(false));
                    request.setAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER_SEL_MESSAGE, message);
                    request.setAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER_THREAD, thread);
            %>

            <div class="card-tab message-container">
                <liferay-util:include page="/view_thread_tree.jsp" servletContext="<%= application %>"/>
            </div>

            <%
                }
            %>

            <c:if test="<%= thread.isApproved() && !thread.isLocked() && !thread.isDraft() %>">
                <%

                    long messageId = message.getRootMessageId();
                    if (Validator.isNull(messageId)) {
                        messageId = thread.getRootMessageId();
                    }
                    request.setAttribute("messageId", messageId);
                %>

                <liferay-util:include page="/components/edit_message_reply.jsp" servletContext="<%= application %>"/>
            </c:if>
        </div>
    </div>
</div>
