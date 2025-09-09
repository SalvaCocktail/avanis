<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="sponsor-container">
    <div id="sponsor-list">
        <c:forEach items="${sponsors}" var="sponsor">
            <%@ include file="/sponsor_resource.jsp" %>
        </c:forEach>
    </div>

    <c:if test="${sponsorCount != null && sponsorCount >15}">
        <aui:button type="button" value="Ver todos los patrocinadores" onClick="getAllSponsor(${calendarBookingId});"/>
    </c:if>
</div>


