<%@ taglib prefix="aui" uri="http://liferay.com/tld/aui" %>

<div id="protagonist-resource-${protagonist.protagonistId}">
    nombre: ${protagonist.name}
    apellidos: ${protagonist.lastName}
    rol: ${protagonist.profession}
    bio: ${protagonist.bio}
    <aui:button type="button" value="Eliminar Protagonista" onClick="removeProtagonist(${protagonist.protagonistId});"/>
</div>

