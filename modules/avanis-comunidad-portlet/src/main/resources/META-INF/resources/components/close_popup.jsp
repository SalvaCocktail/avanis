<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    long messageId = ParamUtil.getLong(request, "messageId");
%>
<c:choose>
    <c:when test="${isFromDetail}">
        <script type="text/javascript" language="javascript">
            window.parent.closeEditMessageModalFromDetail();

        </script>
    </c:when>
    <c:otherwise>
        <script type="text/javascript" language="javascript">
            window.parent.closeEditMessageModal();

        </script>
    </c:otherwise>
</c:choose>

