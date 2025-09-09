<%@ include file="./init.jsp" %>
<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>
<portlet:resourceURL var="tabUrl" id="getTab" />
<portlet:resourceURL var="uploadPortraitResourceURL" id="uploadNewPortraitResource" />
<portlet:actionURL var="uploadBannerURL" name="uploadBanner"/>

<%@ include file="/notifications-followers-following.jsp" %>
<!-- Banner -->
<div>
    <%@ include file="./profile-banner.jsp" %>
</div>

<!-- Profile card module -->
<div class="profile-card-container">
    <div>
        <jsp:include page="profileCard.jsp"/>
    </div>

    <!-- Profile tabs -->

    <div class="profile-container-tabs">
        <div class="profile-tabs">
            <ul class="navbar__menu-list">

                <li class="tab-item" id="tab-publicaciones">
                    <form onsubmit="submitForm(this);return false;">
                        <input type="hidden" name="tab" value="publications">
                        <input type="hidden" name="id" value="${userId}">
                        <button type="submit" value="Publications"> Publicaciones</button>
                    </form>
                </li>

                <li class="tab-item" id="tab-acerca-de">
                    <form onsubmit="submitForm(this);return false;">
                        <input type="hidden" name="tab" value="about">
                        <input type="hidden" name="id" value="${userId}">
                        <button type="submit" value="about"> Acerca de</button>
                    </form>
                </li>
                <li class="tab-item" id="tab-seguidores">
                    <form onsubmit="submitForm(this);return false;">
                        <input type="hidden" name="tab" value="followers">
                        <input type="hidden" name="id" value="${userId}">
                        <button type="submit" value="Followers"> Seguidores</button>
                    </form>
                </li>
                <li class="tab-item" id="tab-seguidos">
                    <form onsubmit="submitForm(this);return false;">
                        <input type="hidden" name="tab" value="following">
                        <input type="hidden" name="id" value="${userId}">
                        <button type="submit" value="about"> Seguidos</button>
                    </form>
                </li>
                <li class="tab-item" id="tab-eventos">
                    <form onsubmit="submitForm(this);return false;">
                        <input type="hidden" name="tab" value="events">
                        <input type="hidden" name="id" value="${userId}">
                        <button type="submit" value="about"> Eventos</button>
                    </form>
                </li>
            </ul>
        </div>
        <div class="tab-content" id="content-acerca-de">
            <c:choose>
                <c:when test='${!signedIn && (visibilityError == "registered" || visibilityError == "followers")}'>
                    <jsp:include page="mustLoginVisibilityError.jsp"/>
                </c:when>
                <c:when test='${visibilityError == "followers"}'>
                    <jsp:include page="mustFollowVisibilityError.jsp"/>
                </c:when>
                <c:when test='${focusedTab == "followers"}'>

                    <jsp:include page="followersTab.jsp"/>

                </c:when>
                <c:when test='${focusedTab == "following"}'>

                    <jsp:include page="followingTab.jsp"/>

                </c:when>
                <c:when test='${focusedTab == "publications"}'>

                    <jsp:include page="publications.jsp"/>

                </c:when>
                <c:otherwise>

                    <jsp:include page="aboutMe.jsp"/>


                </c:otherwise>
            </c:choose>
        </div>
    </div>

</div>

<!-- Logica view-->


<!-- FIXME: Tendría que estar en local jquery para no descargarlo cada vez que se acceda a la página-->
<%--<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>--%>
<script>
    function submitForm(form) {
        let formData = $(form).serialize(); // Serializar los datos del formulario
        let tab = form.querySelector('input[name="tab"]').value;

        $.ajax({
            url: '${tabUrl}',
            type: 'GET',
            data: formData,
            success: function (data) {
                $('.tab-content').html(data); // Actualizar el contenido con la respuesta AJAX
                $('#<portlet:namespace />focused-tab-visibility-form').val(tab)
                $('#<portlet:namespace />focused-tab-portrait-form').val(tab)
                $('#<portlet:namespace />focused-tab-banner-form').val(tab)
            },
            error: function (xhr, status, error) {
                console.error('Error en la petición AJAX:', error);
            }
        });
        return false; // Prevenir el envío estándar del formulario
    }
</script>


<!-- TODO: Estos formularios habrá que ponerlo en los modales y las urls de abajo como imagenes en los iconos y banner respectivamente -->
<div>




    <form action="${uploadBannerURL}" method="post" id="form-actualizar-banner-pp" enctype="multipart/form-data">
        <aui:input type="file" name="banner">
            <aui:validator name="required"/>
        </aui:input>
        <aui:input type="hidden" value="${focusedTab}" name="focusedTab"
                   id="focused-tab-banner-form"/>

        <input type="submit" value="Actualizar foto del banner" id="btn-actualizar-banner-pp">
    </form>

</div>

<script>
    // Selecciono todos los elementos tab-item dentro del contenedor perfil
    const tabItems = document.querySelectorAll('.profile-container-tabs .tab-item');
    // Añade un event listener a cada elemento
    tabItems.forEach(item => {
        item.addEventListener('click', function() {
            // Eliminamos la clase 'active' de todos los elementos
            tabItems.forEach(li => li.classList.remove('active'));
            // Añadimos la clase 'active' al tab seleccionado
            this.classList.add('active');
        });
    });
</script>


<div id="cargar-imagen-perfil-oculta">
    <form id="<portlet:namespace />formulario-cargar-imagen" enctype="multipart/form-data">
        <aui:input type="file" name="portrait">
            <aui:validator name="required"/>
        </aui:input>
        <aui:input type="hidden" value="${focusedTab}" name="focusedTab"
                   id="focused-tab-portrait-form"/>

        <input type="submit" value="Actualizar foto perfil" id="btn-actualizar-perfil-pp">
    </form>

    <strong>URL profile image:</strong> ${profileImage} <br>
    <strong>URL banner image:</strong> ${bannerImage} <br>
</div>

<script>
    document.getElementById("<portlet:namespace />formulario-cargar-imagen").addEventListener("submit", function(event){
        event.preventDefault();
        var formData = new FormData(this);
        console.log("Enviando foto de perfil. Por favor, espera...");

        $.ajax({
            url: '<%= uploadPortraitResourceURL %>',
            type: 'POST',
            data: formData,
            processData: false,
            contentType: false,
            success: function(response) {
                console.log("Foto de perfil actualizada correctamente.");
                console.log(response);
                location.reload();
            },
            error: function(xhr, status, error) {
                console.error("Error al actualizar la foto de perfil:", error);
            }
        });
    });
</script>



<style>
    #cargar-imagen-perfil-oculta{
        display: none;
    }
</style>
<%--

 Banner
<div>
<%@ include file="./profile-banner.jsp" %>
</div>
--%>
<%--


        <!-- Contenido de Publicaciones -->
        <div class="tab-content" id="content-publicaciones" style="display: none;">
            <div class="">
                <%@ include file="./jsp/profile-publications.jsp" %>
            </div>
        </div>

        <!-- Contenido de acerca de mi -->
        <div class="tab-content" id="content-acerca-de" style="display: none;">
            <%@ include file="./aboutMe.jsp" %>
        </div>

        <!-- Contenido de acerca de seguidores -->
        <div class="tab-content" id="content-seguidores" style="display: none;">
            <%@ include file="./jsp/profile-followers.jsp" %>
        </div>

        <!-- Contenido de acerca de seguidos -->
        <div class="tab-content" id="content-seguidos" style="display: none;">
            <%@ include file="./jsp/profile-following.jsp" %>
        </div>

        <div class="tab-content" id="content-guardado" style="display: none;">
            <%@ include file="./jsp/profile-save.jsp" %>
        </div>

    </div>
</div>




<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link href="https://cdnjs.cloudflare.com/ajax/libs/cropperjs/1.5.12/cropper.min.css" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/cropperjs/1.5.12/cropper.min.js"></script>
--%>