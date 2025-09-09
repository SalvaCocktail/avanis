<%--
  Created by IntelliJ IDEA.
  User: jesusblasco
  Date: 18/7/24
  Time: 01:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String body = "";
    boolean quote = false;
    boolean splitThread = false;
    MBMessage curParentMessage = null;
    long categoryId = MBCategoryConstants.DEFAULT_PARENT_CATEGORY_ID;
%>

<aui:form method="post" action="${addMessageURL}" name="fmEdit" enctype="multipart/form-data">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="form-group">
                    <label for="<portlet:namespace />bodyEditor">Body:</label>
                    <%@ include file="components/bbcode_editor.jspf" %>
                    <aui:input name="body" type="hidden" />
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <div class="form-group">
                    <label for="<portlet:namespace />categoryId">Category:</label>
                    <select id="<portlet:namespace />categoryId" name="mbCategoryId" multiple>
                        <option value="0">Select Category</option>
                        <c:forEach var="category" items="${categories}">
                            <option value="${category.categoryId}" ${isEdit && category.categoryId == editMessage.categoryId ? 'selected' : ''}>${category.name}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <label for="<portlet:namespace />priority">Priority:</label>
                    <select id="<portlet:namespace />priority" name="priority">
                        <option value="0" ${isEdit && editMessage.priority == 0 ? 'selected' : ''}>Normal</option>
                        <option value="1" ${isEdit && editMessage.priority == 1 ? 'selected' : ''}>Low</option>
                        <option value="2" ${isEdit && editMessage.priority == 2 ? 'selected' : ''}>High</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <div class="form-group">
                    <label for="<portlet:namespace />attachments">Attachments:</label>
                    <aui:input type="file" id="attachments" name="attachments" multiple="false" />
                </div>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <label for="<portlet:namespace />anonymous">Anonymous:</label>
                    <aui:input type="checkbox" id="anonymous" name="anonymous" value="true" checked="${isEdit && editMessage.anonymous}" />
                </div>
                <div class="form-group">
                    <label for="<portlet:namespace />subscribe">Subscribe:</label>
                    <aui:input type="checkbox" id="subscribe" name="subscribe" value="true" checked="${isEdit && editMessage.subscribed}" />
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="form-group">
                    <aui:button id="insertMessageButton" type="submit" value="${isEdit ? 'Update Message' : 'Add Message'}" />
                </div>
            </div>
        </div>
    </div>
</aui:form>

<script type="text/javascript" language="javascript">
    $(document).ready(function() {
        $("#<portlet:namespace />insertMessageButton").on("click", function (event) {
            event.preventDefault();
            const bodyInput = document.getElementById('<portlet:namespace />body');
            bodyInput.value = <portlet:namespace />getHTML();
            $("#<portlet:namespace />fmEdit").submit();
        });
    });
</script>
