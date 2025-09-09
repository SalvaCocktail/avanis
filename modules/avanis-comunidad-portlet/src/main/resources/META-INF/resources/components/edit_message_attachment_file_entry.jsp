<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.document.library.kernel.model.DLFileEntry" %>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry" %>
<%@page import="com.liferay.portal.kernel.repository.model.FileShortcut" %>
<%@page import="com.liferay.portal.kernel.repository.model.Folder" %>
<%@page import="com.liferay.document.library.kernel.service.DLAppLocalServiceUtil" %>


<%@ include file="../init.jsp" %>

<%
    ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
    Object object = row.getObject();

    Folder curFolder = null;
    FileEntry fileEntry = null;
    FileShortcut fileShortcut = null;

    if (object instanceof FileEntry) {
        fileEntry = (FileEntry)object;

        fileEntry = fileEntry.toEscapedModel();
    }
    else if (object instanceof FileShortcut) {
        fileShortcut = (FileShortcut)object;

        fileShortcut = fileShortcut.toEscapedModel();

        fileEntry = DLAppLocalServiceUtil.getFileEntry(fileShortcut.getToFileEntryId());

        fileEntry = fileEntry.toEscapedModel();
    }
    else if (object instanceof Folder) {
        curFolder = (Folder)object;

        curFolder = curFolder.toEscapedModel();
    }


    if(Validator.isNotNull(fileEntry)){
%>

    <%
        String urlFile = PortletFileRepositoryUtil.getDownloadPortletFileEntryURL(themeDisplay, fileEntry, "status=" + WorkflowConstants.STATUS_APPROVED);
        String fileExtension = fileEntry.getExtension();
        if("jpg".equals(fileExtension) || "jpeg".equals(fileExtension) || "gif".equals(fileExtension) || "png".equals(fileExtension)){
    %>
        <img src="<%=urlFile%>" alt="<%=fileEntry.getTitle() %>">
    <%
        } else {
    %>
        <liferay-ui:icon
                icon="documents-and-media"
                label="<%= true %>"
                markupView="lexicon"
                message='<%= fileEntry.getTitle() %>'
                method="get"
                cssClass="lfr-icon-item taglib-icon"
                url="<%= urlFile %>"
        />
<%      }
    } %>

