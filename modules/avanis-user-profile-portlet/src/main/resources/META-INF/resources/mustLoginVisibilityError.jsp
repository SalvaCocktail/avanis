<%@ include file="./init.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<style>
    .profile-tabs{
        display: none;
    }
</style>
<div class="debes-estar-logeado">
    <div class="profile__non-data">
        <img class="candado" src="<%=request.getContextPath()%>/images/Icon-Stroke.png" alt="icono-candado" />
        <h3 class="profile-card-title "> Regístrate para ver el perfil </h3>
        <p> Crea tu cuenta gratis en Avanis y sigue el perfil para ver sus publicaciones.<br>
            ¡No te llevará ni 2 minutos!

        </p>
            <div class="div-boton-seguir">
                <a  href="${themeDisplay.getURLHome()}/tipo-registro"><button type="submit" class="profile__button">Crear mi cuenta</button></a>
            </div>
    </div>
</div>