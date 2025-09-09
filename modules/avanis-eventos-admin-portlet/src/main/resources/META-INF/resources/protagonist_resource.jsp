<%@ taglib prefix="aui" uri="http://liferay.com/tld/aui" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
    <c:when test="${addProtagonistError != null}">
        ${addProtagonistError}
    </c:when>
    <c:otherwise>
        <div id="protagonist-resource-${protagonist.protagonistId}">
            nombre: ${protagonist.name}
            apellidos: ${protagonist.lastName}
            rol: ${protagonist.profession}
            bio: ${protagonist.bio}
            photo: ${protagonist.portraitUrl}
            <aui:button type="button" value="Eliminar Protagonista" onClick="removeProtagonist(${protagonist.protagonistId});"/>
        </div>
    </c:otherwise>
</c:choose>



