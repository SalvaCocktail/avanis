<%@ taglib prefix="clay" uri="http://liferay.com/tld/clay" %>
<%@ taglib prefix="liferay-user" uri="http://liferay.com/tld/user" %>
<%@ include file="./init.jsp" %>

<portlet:resourceURL var="createThreadURL" id="createThread"/>
<div class="av-co-header__share-container">
    <div class="av-co-header__card-body">

        <clay:content-row padded="<%= true %>">
            <clay:content-col>
                <%
                    // Obtener las iniciales del usuario para mostrar en caso de no tener foto de perfil
                    String userFullName = user.getFullName();
                    String[] nameParts = userFullName.split(" ");
                    String initials = "";

                    if (nameParts.length > 0) {
                        initials += nameParts[0].substring(0, 1); // Primera letra del primer nombre
                        if (nameParts.length > 1) {
                            initials += nameParts[1].substring(0, 1); // Primera letra del apellido si existe
                        }
                    } else {
                        initials = userFullName.substring(0, 1); // Si solo tiene un nombre
                    }

                    boolean hasPortrait = user.getPortraitId() > 0;
                %>

                <c:choose>
                    <c:when test="<%= hasPortrait %>">
                        <liferay-user:user-portrait userId="<%= user.getUserId() %>" />
                    </c:when>
                    <c:otherwise>
                        <div class="user-initials-avatar">
                            <%= initials %>
                        </div>
                    </c:otherwise>
                </c:choose>
            </clay:content-col>

            <clay:content-col>
                <!-- Formulario para crear el hilo -->
                <aui:form method="post" cssClass="av-form-my-account formulario-hilo-comunidad" action="${createThreadURL}" name="createEmbeddedThread${vista}"
                          enctype="multipart/form-data">
                    <!-- Campos ocultos necesarios -->
                    <aui:input name="resourceId" value="${resourceId}" type="hidden"/>
                    <aui:input name="resourceName" value="${resourceName}" type="hidden"/>
                    <aui:input name="lonjaId" value="" type="hidden" id="lonjaIdField"/>

                    <!-- Campo para el cuerpo del comentario -->
                    <aui:input name="body" type="text" label="" placeholder="Escribe un comentario" required="true" cssClass="body-nuevo-hilo"/>

                    <!-- Botón para enviar el formulario -->
                    <aui:button type="submit" id="createEmbeddedThreadButton" value="Guardar" cssClass="btn-enviar-comentario-hilo-de-comunidad"/>
                </aui:form>
            </clay:content-col>
        </clay:content-row>
    </div>
</div>

<script>
    // Obtener los parámetros de la URL
    if (window.location.href.includes("detalle-lonja")) {
        let urlParams = new URLSearchParams(window.location.search);
        const lonjaId = urlParams.get('lonjaId'); // Extraer el valor de lonjaId de la URL
        //console.log("Lonja ID:", lonjaId);

        if (lonjaId) {
            // Asignar lonjaId al campo oculto del formulario
            document.getElementById('<portlet:namespace />lonjaIdField').value = lonjaId;
        }
    }
</script>