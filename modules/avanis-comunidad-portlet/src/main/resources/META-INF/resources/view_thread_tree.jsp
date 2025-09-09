<%@ include file="init.jsp" %>

<%
    MBTreeWalker treeWalker = (MBTreeWalker) request.getAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER);
    MBMessage selMessage = (MBMessage) request.getAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER_SEL_MESSAGE);
    MBMessage message = (MBMessage) request.getAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER_CUR_MESSAGE);
    MBCategory category = (MBCategory) request.getAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER_CATEGORY);
    MBThread thread = (MBThread) request.getAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER_THREAD);
    int depth = (Integer) request.getAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER_DEPTH);

    int index = GetterUtil.getInteger(request.getAttribute(WebKeys.MESSAGE_BOARDS_TREE_INDEX));

    index++;

    request.setAttribute(WebKeys.MESSAGE_BOARDS_TREE_INDEX, Integer.valueOf(index));
    //System.out.println("MB2 - Message processing: " + message.getMessageId());
    //System.out.println("MB2 - Selected Message ID: " + selMessage.getMessageId());

    if (message.getMessageId() == selMessage.getMessageId()) {
        request.setAttribute("view_thread_tree.jsp-messageFound", true);
        //System.out.println("MB2 - Message found in thread tree");
    }
    //System.out.println("__________________Traigo mensajes 4____________");
    List<MBMessage> messages = treeWalker.getMessages();
    int[] range = treeWalker.getChildrenRange(message);

    MBMessageIterator mbMessageIterator = new MBMessageIterator(messages, range[0], range[1]);

    MBMessage rootMessage = treeWalker.getRoot();
    String p_auth = (String) request.getAttribute("pAuth");
    //System.out.println("MB3 - Root message ID: " + rootMessage.getMessageId());
%>

<c:choose>
    <c:when test="<%= !MBUtil.isViewableMessage(themeDisplay, message) %>">
        <c:if test="<%= (message.getParentMessageId() == MBMessageConstants.DEFAULT_PARENT_MESSAGE_ID) || mbMessageIterator.hasNext() %>">
            <div class="alert alert-danger">
                <liferay-ui:message key="you-do-not-have-permission-to-access-the-requested-resource"/>
            </div>
        </c:if>
    </c:when>
    <c:otherwise>

        <%
            request.setAttribute("edit-message.jsp-showPermanentLink", Boolean.TRUE);
            request.setAttribute("edit-message.jsp-showRecentPosts", Boolean.TRUE);
            request.setAttribute("edit_message.jsp-category", category);
            request.setAttribute("edit_message.jsp-editable", Boolean.FALSE);
            request.setAttribute("edit_message.jsp-message", message);
            request.setAttribute("edit_message.jsp-thread", thread);
            //System.out.println("MB4 - Setting message attributes for view");
        %>

        <liferay-util:include page="/view_message_detail.jsp" servletContext="<%= application %>"/>

		<c:if test="<%= !thread.isLocked() && !message.isDraft() %>">

            <%
                long replyToMessageId = message.getMessageId();
                //System.out.println("MB5 - Replying to message ID: " + replyToMessageId);
            %>

            <%@ include file="edit_message_quick.jspf" %>
        </c:if>

    </c:otherwise>
</c:choose>

<c:if test="<%= message.getMessageId() != rootMessage.getMessageId() %>">
    <%
        depth++;
        //System.out.println("MB6 - Processing child messages at depth " + depth);
        while (mbMessageIterator.hasNext()) {
            MBMessage curMessage = mbMessageIterator.next();
            //System.out.println("MB6 - Processing child message ID: " + curMessage.getMessageId());
            boolean lastChildNode = !mbMessageIterator.hasNext();

            request.setAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER, treeWalker);
            request.setAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER_CATEGORY, category);
            request.setAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER_CUR_MESSAGE, curMessage);
            request.setAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER_DEPTH, Integer.valueOf(depth));
            request.setAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER_LAST_NODE, Boolean.valueOf(lastChildNode));
            request.setAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER_SEL_MESSAGE, selMessage);
            request.setAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER_THREAD, thread);
    %>
    <div class="card-tab message-container">
        <liferay-util:include page="/view_thread_tree.jsp" servletContext="<%= application %>"/>
    </div>
    <%
        }
        //System.out.println("MB7 - Finished processing children of message ID: " + message.getMessageId());
    %>
</c:if>

<script type="text/javascript" language="javascript">
	<portlet:resourceURL var="likeMessageURL" id="resource_cmd_command">
		<portlet:param name="<%= Constants.CMD %>" value="likeMessage" />
	</portlet:resourceURL>

	function submitLike<%=thread.getRootMessageId()%>(submitLikeMessageId) {
		//$('#submitLikeForm<%=thread.getRootMessageId()%> input[name="messageId"]').val(submitLikeMessageId);
		//let data = new FormData($("#submitLikeForm<%=thread.getRootMessageId()%>")[0]);
		Liferay.Util.toggleDisabled('#<portlet:namespace />ilike_' + submitLikeMessageId, true);

		$.ajax({
			url: '${likeMessageURL}',
			type: 'POST',
			dataType: "json",
			data: {
				<portlet:namespace />messageId : submitLikeMessageId,
				<portlet:namespace />score : 1
			},
			success: function (r) {
				console.log('success', r);
				Liferay.Util.toggleDisabled('#<portlet:namespace />idelete_' + submitLikeMessageId, false);
				$('#<portlet:namespace />ilike_' + submitLikeMessageId).parent().hide();
				$('#<portlet:namespace />idelete_' + submitLikeMessageId).parent().removeClass('hide');
				$('#<portlet:namespace />idelete_' + submitLikeMessageId).parent().show();
				updateLikeCounter<%=thread.getRootMessageId()%>(submitLikeMessageId);
			},
			error: function (r) {
				console.log('error', r);
				Liferay.Util.toggleDisabled('#<portlet:namespace />ilike_' + submitLikeMessageId, false);
			}
		});
	}

	function deleteLike<%=thread.getRootMessageId()%>(submitLikeMessageId) {
		//$('#deleteLikeForm<%=thread.getRootMessageId()%> input[name="messageId"]').val(submitLikeMessageId);
		//let data = new FormData($("#deleteLikeForm<%=thread.getRootMessageId()%>")[0]);
		Liferay.Util.toggleDisabled('#<portlet:namespace />idelete_' + submitLikeMessageId, true);

		$.ajax({
			url: '${likeMessageURL}',
			type: 'POST',
			dataType: "json",
			data: {
				<portlet:namespace />messageId : submitLikeMessageId,
				<portlet:namespace />score : -1
			},
			success: function (r) {
				console.log('success', r);
				$('#<portlet:namespace />idelete_' + submitLikeMessageId).parent().hide();
				$('#<portlet:namespace />ilike_' + submitLikeMessageId).parent().removeClass('hide');
				$('#<portlet:namespace />ilike_' + submitLikeMessageId).parent().show();
				updateLikeCounter<%=thread.getRootMessageId()%>(submitLikeMessageId);
			},
			error: function (r) {
				console.log('error', r);
				Liferay.Util.toggleDisabled('#<portlet:namespace />idelete_' + submitLikeMessageId, false);
			}
		});
	}

	function updateLikeCounter<%=thread.getRootMessageId()%>(likeCounterMessageId) {
		<portlet:resourceURL var="likeCounterMessageIdURL" id="resource_cmd_command">
		<portlet:param name="<%= Constants.CMD %>" value="likeCounterMessage" />
		</portlet:resourceURL>

		$.ajax({
			url: '${likeCounterMessageIdURL}',
			type: 'POST',
			dataType: "json",
			data: {'<portlet:namespace />messageId': likeCounterMessageId},
			success: function (data) {
				console.log(data.usernamelist);
				$('.like-counter_' + likeCounterMessageId + ' .taglib-text').html(data.likecountervalue);
				$('.like-counter_' + likeCounterMessageId).attr('title', data.usernamelist);
			},
			error: function () {
				console.log('Error al recuperar like Counter con messageId ' + likeCounterMessageId);
			}
		});
	}

    function updateShareCounter<%=thread.getRootMessageId()%>(shareCounterMessageId) {
        <portlet:resourceURL var="shareCounterMessageIdURL" id="resource_cmd_command">
        <portlet:param name="<%= Constants.CMD %>" value="shareCounterMessage" />
        </portlet:resourceURL>

        $.ajax({
            url: '${shareCounterMessageIdURL}',
            type: 'POST',
            dataType: "json",
            data: {'<portlet:namespace />messageId': shareCounterMessageId},
            success: function (data) {
                console.log(data.sharecountervalue);
                $('.share-counter_' + shareCounterMessageId + ' .taglib-text').html(data.sharecountervalue);
                $('.share-counter_' + shareCounterMessageId).attr('title', data.sharecountervalue);
            },
            error: function () {
                console.log('Error al recuperar share Counter con messageId ' + likeCounterMessageId);
            }
        });
    }

    function functionShareThreadURL<%=thread.getRootMessageId()%>(messageId) {
        //console.log("functionShareThreadURL VIEW_THREAD_TREE");
        <portlet:renderURL var="viewShareMessageURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
        <portlet:param name="<%= Constants.CMD %>" value="share_message" />
        <portlet:param name="isFromDetail" value="<%= "true" %>" />
        </portlet:renderURL>

        updateShareCounter<%=thread.getRootMessageId()%>(messageId);
        let width_ = 0;
        if ($(document).width() < 768) {
            width_ = 360;
        } else {
            width_ = 608;
        }

        Liferay.Util.openWindow({
            dialog: {
                //cssClass: 'aui-popup-example',
                destroyOnHide: true,
                height: 550,
                width: width_,
                close: true,

                centered: true,
                resizable: true,
                destroyOnClose: true
            },
            id: 'AvanisComunidad_dialogShare',
            dialogIframe: {
                bodyCssClass: 'share-thread-css'
            },
            title: '<liferay-ui:message key="custom-share-popup"/>',
            uri: '<%=viewShareMessageURL%>&<portlet:namespace/>messageId=' + messageId
        });

        // Provide a function to close modal dialogs in the parent page
        Liferay.provide(
            window,
            'closeSharePopup',
            function (popupId) {
                let dialog = Liferay.Util.getWindow(popupId);
                dialog.destroy();
            },
            ['aui-base', 'aui-dialog', 'aui-dialog-iframe']
        );
    }

    function functionUpdateThreadURL<%=thread.getRootMessageId()%>(threadMessageId) {
        <portlet:renderURL var="editThreadURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
        <portlet:param name="<%= Constants.CMD %>" value="<%= Constants.UPDATE %>" />
        <portlet:param name="redirect" value="<%= currentURL %>" />
        <portlet:param name="isFromDetail" value="<%= "true" %>" />
        </portlet:renderURL>

        let width_ = 0;
        if ($(document).width() < 768) {
            width_ = 360;
        } else {
            width_ = 608;
        }
        Liferay.Util.openWindow({
            dialog: {
                //cssClass: 'aui-popup-example',
                destroyOnHide: true,
                height: 700,
                width: width_,
                close: true
            },
            id: '<portlet:namespace/>dialog',
            dialogIframe: {
                //bodyCssClass: 'custom-css-class'
            },
            title: '<liferay-ui:message key="update-publication"/>',
            uri: '<%=editThreadURL%>&<portlet:namespace />messageId=' + threadMessageId
        });

        // Provide a function to close modal dialogs in the parent page
        Liferay.provide(
            window,
            'closePopup',
            function (popupId) {
                let dialog = Liferay.Util.getWindow(popupId);
                dialog.destroy();
            },
            ['aui-base', 'aui-dialog', 'aui-dialog-iframe']
        );

    }

    function closeEditMessageModalFromDetail() {
        closePopup("<portlet:namespace/>dialog");
        window.location.href = '<%= currentURL%>';
    }

    function closeShareMessageModalFromDetail() {
        closeSharePopup("AvanisComunidad_dialogShare");
    }

</script>
