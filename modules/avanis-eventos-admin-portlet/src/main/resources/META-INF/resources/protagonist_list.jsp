<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="protagonist-container">
    <div id="protagonist-list">
        <c:forEach items="${protagonists}" var="protagonist">
            <%@ include file="/protagonist_resource.jsp" %>
        </c:forEach>
    </div>

    <c:if test="${protagonistCount != null && protagonistCount >8}">
        <aui:button type="button" value="Ver todos los protagonistas" onClick="getAllProtagonist(${calendarBookingId});"/>
    </c:if>
</div>


