<%@ include file="./init.jsp" %>

<%--<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/2.0.8/js/dataTables.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/2.0.8/js/dataTables.bootstrap5.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%
    boolean signedIn = themeDisplay.isSignedIn();
    pageContext.setAttribute("signedIn", signedIn);
%>

<portlet:actionURL var="acceptFollowReqURL" name="acceptFollowReq"/>
<portlet:actionURL var="cancelFollowReqURL" name="cancelFollowReq"/>
<portlet:resourceURL var="followersURL">
    <portlet:param name="mvc.command.name" value="getTab"/>
</portlet:resourceURL>

<div class="profile__title">
    <h3 class="profile__header"> Seguidores (${followersCount})</h3>
</div>


<%-- Solicitudes de seguimiento --%>

<c:if test="${followRequests != null && followRequests.size() > 0 }">
    <div class="profile__data">
    <div>

        <h4>Solicitudes de seguimiento</h4>
    </div>
    <c:forEach var="followRequest" items="${followRequests}">
        <table class="table table-striped" style="width:100%">
            <tbody>
            <tr class="follower-info-container">
                <td>
                        <%-- TODO CSS --%><style>
                        .follower-info-container a:hover{
                            color:#212529;
                        }
                    </style>
                            <% User followerUser = (User) pageContext.getAttribute("followRequest");
                                String portraitURL=followerUser.getPortraitURL(themeDisplay);
                            %>

                    <div class="follower-info">

                        <c:set var="firstName" value="${fn:trim(fn:substringBefore(followRequest.fullName, ' '))}" />
                        <c:set var="secondName" value="${fn:trim(fn:substring(followRequest.lastName,0,1))}" />
                        <c:set var="initials" value="${fn:toUpperCase(fn:substring(firstName, 0, 1))}${fn:toUpperCase(fn:substring(secondName, 0, 1))}" />
                        <c:set var="portraitURL" value="<%=portraitURL%>" />
                        <c:choose>
                            <c:when test="${fn:contains(portraitURL, '/image/user_portrait?img_id=0')}">
                                <%-- Si existe imagen por defecto pongo iniciales--%>
                                <a href="${themeDisplay.getURLHome()}/mi-perfil-publico?id=${followRequest.getUserId()}"><span class="iconFollowerPicture" alt="profilePhoto" style="background-color: #122C1F;background-image: unset;color:white; display: flex; justify-content: center; align-items: center; font-size: 24px; ">${initials}</span></a>
                            </c:when>
                            <c:otherwise>
                                <%-- Si no , muestro la imagen de perfil--%>
                        <a href="${themeDisplay.getURLHome()}/mi-perfil-publico?id=${followRequest.getUserId()}"><span class="iconFollowerPicture" alt="profilePhoto"style="background-image: url('<%=portraitURL%>'); align-self: baseline;"></span></a>

                            </c:otherwise>
                        </c:choose>


                        <div class="follower-details">
                            <a href="${themeDisplay.getURLHome()}/mi-perfil-publico?id=${followRequest.getUserId()}">
                                <span class="follower-info-name">${followRequest.fullName}</span>
                            </a>
                            <p class="follower-info-request">Ha solicitado seguirte</p>
                        </div>
                    </div>

                </td>

                <td class="table-container-button">
                    <form action="${cancelFollowReqURL}" method="post">
                        <aui:input type="hidden" value="followers" name="focusedTab"/>
                        <input type="hidden" name="<portlet:namespace />userId" value="${followRequest.userId}">
                        <button type="submit" class="profile__button-following">
                            <p class="profile__button--text"> Ignorar </p>
                        </button>
                    </form>
                    <form action="${acceptFollowReqURL}" method="post">
                        <aui:input type="hidden" value="followers" name="focusedTab"/>
                        <input type="hidden" name="<portlet:namespace />userId" value="${followRequest.userId}">
                        <!--<input type="submit" value="Aceptar"> -->
                        <button type="submit" class="profile__button-follow">
                            <p class="profile__button--text"> Aceptar </p>
                        </button>
                    </form>
                </td>
            </tr>
            </tbody>
        </table>
    </c:forEach>
    </div>
</c:if>

<%-- Cuando no hay seguidores
<c:if test="${followRequests != null && followersCount == 0 }"> --%>
<c:if test="${followersCount == 0 }">
    <%-- Cuando no hay seguidores --%>
    <c:if test="${me}">
        <div>
            <div class="profile__non-data">
                <h3 class="profile-card-title "> Aún no tienes seguidores </h3>
                <p> Cuanto más publiques, más te darás a conocer y más seguidores tendrás.
                    </br>
                    ¿Publicamos algo?
                </p>

                <a  href="${themeDisplay.getURLHome()}/comunidad"> <button class="profile__button-publication">
                    Escribir una publicación
                </button></a>
            </div>
        </div>
    </c:if>
    <c:if test="${signedIn and !me}">
        <div>
            <div class="profile__non-data">
                <h3 class="profile-card-title "> Este usuario aún no tiene seguidores. </h3>
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
                <h3 class="profile-card-title "> Este usuario aún no tiene seguidores. </h3>
                <p>  ¡Create una nueva cuenta para poder seguir a este usuario!
                    </br>

                </p>

                <a  href="${themeDisplay.getURLHome()}/tipo-registro"><button class="profile__button btn-crear-cuenta-gratis">
                    Crear cuenta gratis
                </button></a>
            </div>
        </div>
    </c:if>
</c:if>

<%--<c:if test="${followRequests != null && followersCount > 0 }"> --%>
<%--TODO Poner a todos botones Seguir y que yeve a crear cuenta? --%>
<c:if test="${followersCount > 0 }">
<div class="profile__search" >
<form onsubmit="submitFilterForm(this);return false;">
    <input type="hidden" name="tab" value="filterFollowers">
    <input type="hidden" name="id" value="${userId}">
    <div class="search-container">
        <span class="iconSearch"></span>
        <input type="text" name="filterName" value="${filterName}" placeholder="Buscar..." >
    </div>
    <button class="buscar-btn" type="submit" value="Followers">Search</button>
</form>
</div>

<div id="followers-content">
    <%@ include file="./followersList.jsp" %>
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
<style>
    .follower-details {
        margin-top: 14px;
    }
</style>




