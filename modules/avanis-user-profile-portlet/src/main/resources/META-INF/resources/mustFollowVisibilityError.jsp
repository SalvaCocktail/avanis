<%@ include file="./init.jsp" %>
<portlet:actionURL var="followURL" name="follow"/>
<%@ page contentType="text/html; charset=UTF-8" %>
<style>
    .profile-tabs{
        display: none;
    }
</style>

<c:choose>
    <c:when test='${follow == "requested"}'>
<%-- TODO CSS--%>
        <style>
        .profile__button:disabled {
        opacity: 0.5;

        }
        </style>
        <div class="debes-ser-seguidor">
            <div class="profile__non-data">
                <img class="candado" src="<%=request.getContextPath()%>/images/Icon-Stroke.png" alt="icono-candado" />
                <h3 class="profile-card-title "> Este perfil es privado </h3>
                <p> Síguelo para ver sus publicaciones y su información profesional.

                </p>
                <div class="div-boton-seguir">
                    <button type="submit" class="profile__button" style="width: auto;" disabled>Solicitud enviada</button>

                </div>
            </div>
        </div>
    </c:when>
    <c:when test='${signedIn}'>
        <style>
            .div-boton-seguir{
                display: none;
            }
        </style>
        <div class="debes-ser-seguidor">
            <div class="profile__non-data">
                <img class="candado" src="<%=request.getContextPath()%>/images/Icon-Stroke.png" alt="icono-candado" />
                <h3 class="profile-card-title "> Este perfil es privado </h3>
                <p> Síguelo para ver sus publicaciones y su información profesional.

                </p>

                <form action="${followURL}" method="post">
                    <aui:input name="userId" value="${userId}" type="hidden"/>
                    <div class="div-boton-seguir2">
                        <button type="submit" class="profile__button">Seguir</button>
                    </div>
                </form>
            </div>
        </div>

    </c:when>
</c:choose>
