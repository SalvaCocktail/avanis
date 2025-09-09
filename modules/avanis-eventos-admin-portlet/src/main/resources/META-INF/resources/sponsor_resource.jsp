<%@ taglib prefix="aui" uri="http://liferay.com/tld/aui" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
    <c:when test="${addSponsorError != null}">
        ${addSponsorError}
    </c:when>
    <c:otherwise>
        <div id="sponsor-resource-${sponsor.sponsorId}">
            nombre: ${sponsor.name}
            photo: ${sponsor.iconUrl}
            <aui:button type="button" value="Eliminar Patrocinador" onClick="removeSponsor(${sponsor.sponsorId});"/>
        </div>
    </c:otherwise>
</c:choose>



