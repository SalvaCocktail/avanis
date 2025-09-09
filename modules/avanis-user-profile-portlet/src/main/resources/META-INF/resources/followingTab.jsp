<%@ include file="./init.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<portlet:actionURL var="acceptFollowReqURL" name="acceptFollowReq"/>
<portlet:actionURL var="cancelFollowReqURL" name="cancelFollowReq"/>
<portlet:resourceURL var="followersURL">
    <portlet:param name="mvc.command.name" value="getTab"/>
</portlet:resourceURL>
<%
    boolean signedIn = themeDisplay.isSignedIn();
    pageContext.setAttribute("signedIn", signedIn);
%>

<div class="profile__title">
    <h3 class="profile__header"> Seguidos (${followersCount})</h3>
</div>
<c:if test="${ followersCount == 0 }">
    <c:if test="${me}">
        <div>
            <div class="profile__non-data">
                <h3 class="profile-card-title "> Todavía no sigues a nadie. </h3>
                <p>  Visita la comunidad y encuentra personas que comparten tus intereses.
                    </br>

                </p>

                <a  href="${themeDisplay.getURLHome()}/comunidad"><button class="profile__button-publication">
                    Visitar la comunidad
                </button></a>
            </div>
        </div>
    </c:if>
    <c:if test="${signedIn and !me}">
        <div>
            <div class="profile__non-data">
                <h3 class="profile-card-title "> Este usuario no sigue aún a nadie. </h3>
                <p>  ¡Únete para empezar a seguir a tus usuarios favoritos!
                    </br>

                </p>

                <a  href="${themeDisplay.getURLHome()}/comunidad"><button class="profile__button-publication">
                    Visitar la comunidad
                </button></a>
            </div>
        </div>
    </c:if>
    <c:if test="${!signedIn}">
        <div>
            <div class="profile__non-data">
                <h3 class="profile-card-title "> Este usuario no sigue aún a nadie. </h3>
                <p>  ¡Regístrate en Avanis para empezar a seguir a tus usuarios favoritos!
                    </br>

                </p>

                <a  href="${themeDisplay.getURLHome()}/tipo-registro"><button class="profile__button btn-crear-cuenta-gratis">
                    Crear cuenta gratis
                </button></a>
            </div>
        </div>
    </c:if>

</c:if>
<c:if test="${ followersCount > 0 }">
    <div class="profile__search" >
        <form onsubmit="submitFilterForm(this);return false;">
            <input type="hidden" name="tab" value="filterFollowings">
            <input type="hidden" name="id" value="${userId}">
            <div class="search-container">
                <span class="iconSearch"></span>
                <input type="text" name="filterName" value="${filterName}" placeholder="Buscar..." >
            </div>
            <button class="buscar-btn" type="submit" value="Followers">Search</button>
        </form>
    </div>

    <div id="followers-content">
        <jsp:include page="followersList.jsp"/>
    </div>
</c:if>

<script>

    function submitFilterForm(form) {
        let formData = $(form).serialize();

        $.ajax({
            url: '${followersURL}',
            type: 'GET',
            data: formData,
            success: function (data) {
                $('#followers-content').empty().append(data);

            },
            error: function (xhr, status, error) {
                console.error('Error en la petición AJAX:', error);
            }
        });
        return false;


    }
</script>





