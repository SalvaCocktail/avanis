<%@ page import="avanis.social.follow.sb.service.SocialFollowLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.model.User" %>
<%@ page import="avanis.social.follow.sb.model.SocialFollow" %>
<%@ include file="./init.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<portlet:resourceURL var="followersURL">
    <portlet:param name="mvc.command.name" value="getTab"/>
</portlet:resourceURL>

<portlet:actionURL var="acceptFollowReqURL" name="acceptFollowReq"/>
<portlet:actionURL var="cancelFollowReqURL" name="cancelFollowReq"/>
<portlet:actionURL var="followURL" name="follow"/>
<portlet:actionURL var="unfollowURL" name="unfollow"/>

<!--
Mostrando  ${shownFollowers} de ${followersCount} para la busuqeda ${filterName} <br>
-->


<c:set var="userId" value="${userId}"/>
<c:set var="principalId" value="${principalId}"/>

<%--<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/2.0.8/js/dataTables.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/2.0.8/js/dataTables.bootstrap5.js"></script>
<script type="text/javascript"
        src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>--%>
<%@ page import="avanis.social.follow.sb.service.SocialFollowLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.model.User" %>
<%@ page import="avanis.social.follow.sb.model.SocialFollow" %>
<%@ page import="com.liferay.portal.kernel.util.PortalUtil" %>
<%@ page import="com.liferay.portal.kernel.model.Image" %>
<%@ page import="com.liferay.portal.kernel.webserver.WebServerServletTokenUtil" %>
<%@ page import="com.liferay.portal.kernel.service.ImageLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.util.DigesterUtil" %>
<%@ page import="com.liferay.portal.kernel.util.HttpUtil" %>
<%@ page import="com.liferay.portal.kernel.service.UserLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.theme.ThemeDisplay" %>
<%@ include file="./init.jsp" %>

<portlet:resourceURL var="followersURL">
    <portlet:param name="mvc.command.name" value="getTab"/>
</portlet:resourceURL>

<portlet:actionURL var="acceptFollowReqURL" name="acceptFollowReq"/>
<portlet:actionURL var="cancelFollowReqURL" name="cancelFollowReq"/>
<portlet:actionURL var="followURL" name="follow"/>
<portlet:actionURL var="unfollowURL" name="unfollow"/>

<!--
Mostrando  ${shownFollowers} de ${followersCount} para la busqueda ${filterName} <br>
-->


<c:set var="userId" value="${userId}"/>

<%--<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/2.0.8/js/dataTables.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/2.0.8/js/dataTables.bootstrap5.js"></script>
<script type="text/javascript"
        src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>--%>

<div class="profile__data">
    <p class="resultado-busqueda-texto">${followersCount} resultados para tu búsqueda "${filterName}"</p>
    <div id="followingStyle">
        <table id="following" class="table table-striped" style="width:100%">
            <thead>
            <tr>
                <th>Profile</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="follower" items="${followers}">
                <c:set var="follower" value="${follower}"/>
                <tr><% User followerUser = (User) pageContext.getAttribute("follower");
                    String portraitURL=followerUser.getPortraitURL(themeDisplay);
                %>
                    <td>
                        <div class="follower-info">
                        <%-- Iniciales si no hay foto--%>
                            <c:set var="firstName" value="${fn:trim(fn:substringBefore(follower.fullName, ' '))}" />
                            <c:set var="secondName" value="${fn:trim(fn:substring(follower.lastName,0,1))}" />
                            <c:set var="initials" value="${fn:toUpperCase(fn:substring(firstName, 0, 1))}${fn:toUpperCase(fn:substring(secondName, 0, 1))}" />
                            <c:set var="portraitURL" value="<%=portraitURL%>" />
                            <c:choose>
                                <c:when test="${fn:contains(portraitURL, '/image/user_portrait?img_id=0')}">
                                    <%-- Si existe imagen por defecto pongo iniciales--%>
                                    <a href="${themeDisplay.getURLHome()}/mi-perfil-publico?id=${follower.getUserId()}"><span class="iconFollowerPicture" alt="profilePhoto" style="background-color: #122C1F;background-image: unset;color:white; display: flex; justify-content: center; align-items: center; font-size: 24px; ">${initials}</span></a>
                                </c:when>
                                <c:otherwise>
                                    <%-- Si no , muestro la imagen de perfil--%>
                                    <a href="${themeDisplay.getURLHome()}/mi-perfil-publico?id=${follower.getUserId()}"><span class="iconFollowerPicture" alt="profilePhoto" style="background-image: url('<%=portraitURL%>');"></span></a>

                                </c:otherwise>
                            </c:choose>

                            <a href="${themeDisplay.getURLHome()}/mi-perfil-publico?id=${follower.getUserId()}"><span class="follower-info-name">${follower.fullName}</span>
                                <span style="display: none" class="follower-info-lastName">${follower.lastName}</span>
                            </a>

                        </div>
                    </td>
                    <%-- Si no estoy logado que aparezcan botones de seguir con enlace a Login--%>
                    <c:if test="${!signedIn}">
                        <td>
                            <div class="table-container-button">
                                <a href="${themeDisplay.getURLHome()}/login"><button type="button" class="profile__button-follow">
                                    <p class="profile__button--text">Seguir</p>
                                </button></a>
                            </div>
                        </td>
                    </c:if>

                    <td>
                        <c:if test="${signedIn}">
                            <%
                                long principalId = (Long) pageContext.getAttribute("principalId");

                                SocialFollow socialFollow = SocialFollowLocalServiceUtil.getFollow(principalId, followerUser.getUserId());

                                if (socialFollow == null) {
                                    pageContext.setAttribute("socialFollowStatus", null);
                                } else if (socialFollow.getAccepted()) {
                                    pageContext.setAttribute("socialFollowStatus", "followed");
                                } else {
                                    pageContext.setAttribute("socialFollowStatus", "requested");
                                }
                            %>
                            <c:choose>
                                <c:when test="${follower.userId == principalId}">

                                </c:when>
                                <c:when test='${socialFollowStatus == "followed"}'>
                                    <%-- Modal para dejar de seguir--%>
                                    <div class="modal-seguidores">
                                        <div id="alertModal${follower.userId}" class="av-te-ma-modal alertModal">
                                            <div class="av-te-ma-modal__panel">
                                                <div class="av-te-ma-modal__header">
                                                    <img class="left-arrow" src="<%=request.getContextPath()%>/images/arrow-left.png" alt="left-arrow" />
                                                    <h5 class="modal-title" id="exampleModalLabel">Dejar de seguir</h5>
                                                    <span class="av-icon-close">&times;</span>
                                                </div>
                                                <div class="av-te-ma-modal__content">
                                                    <div style="justify-content: center;display: flex;">

                                                        <img id="modal-image" class="modal-image" src="" alt="Profile Image" style="width: 100px; height: 100px; border-radius: 50%;">

                                                    </div>
                                                    <div class="av-te-ma-modal__text">
                                                        <strong>¿Seguro que quieres dejar de seguir a <span id="modal-name" class="modal-name">Manuel Martín</span>?</strong>

                                                        <span id="modal-description">Si cambias de opinión tendrás que volver a enviar una solicitud de seguimiento.</span>
                                                        <input type="hidden" id="modal-user-id" class="modal-user-id">
                                                    </div>
                                                    <form action="${unfollowURL}" method="post" cssClass="form-modal-seguidores">
                                                        <aui:input type="hidden" value="${focusedTab}" name="focusedTab"/>
                                                        <aui:input type="hidden" name="userId" value="${follower.userId}"  cssClass="modalUserId-${follower.userId}"/>
                                                        <aui:input name="focusOnUser" value="${userId}" type="hidden"/>
                                                        <button type="button" class="profile__button-following btn-declinar">
                                                            <p class="profile__button--text">Cancelar</p>
                                                        </button>
                                                        <button type="submit" class="profile__button-follow btn-dejar-de-seguir-modal">
                                                            <p class="profile__button--text"> Dejar de seguir </p>
                                                        </button>
                                                    </form>
                                                </div>
                                            </div>

                                            <div class="av-te-ma-modal__footer">
                                                <button class="av-te-ma-modal__accept-btn">
                                                    Aceptar
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                        <div class="table-container-button">
                                                    <button type="button" class="profile__button-following btn-dejar-de-seguir" data-toggle="modal" data-target="#exampleModal">
                                                        <p class="profile__button--text"> Siguiendo </p>
                                                    </button>
                                        </div>
                                </c:when>
                                <c:when test='${socialFollowStatus == "requested"}'>
                                    <!--Modal para cancelar solicitud-->
                                    <div class="modal-cancelar-peticion">
                                        <div id="alertModalC" class="av-te-ma-modal">
                                            <div class="av-te-ma-modal__panel">
                                                <div class="av-te-ma-modal__header">
                                                    <img class="left-arrow" src="<%=request.getContextPath()%>/images/arrow-left.png" alt="left-arrow" />
                                                    <h5 class="modal-title" id="exampleModalLabelC">Cancelar solicitud</h5>
                                                    <span class="av-icon-close">&times;</span>
                                                </div>
                                                <div class="av-te-ma-modal__content">
                                                    <div style="justify-content: center;display: flex;">
                                                        <img id="modal-imageC" class="modal-image" src="" alt="Profile Image" style="width: 100px; height: 100px; border-radius: 50%;">
                                                    </div>
                                                    <div class="av-te-ma-modal__text">
                                                        <strong>¿Seguro que quieres cancelar la solicitud de seguimiento a <span id="modal-nameC" class="modal-nameC">Manuel Martín</span>?</strong>

                                                        <span id="modal-descriptionC">Si cambias de opinión tendrás que volver a enviar una solicitud de seguimiento.</span>
                                                        <input type="hidden" id="modal-user-idC" class="modal-user-idC">
                                                    </div>
                                                    <form action="${unfollowURL}" method="post">
                                                        <aui:input name="userId" value="${follower.userId}" type="hidden" cssClass="userId"/>
                                                        <aui:input type="hidden" value="${focusedTab}" name="focusedTab"/>
                                                        <aui:input name="focusOnUser" value="${userId}" type="hidden"/>
                                                        <button type="button" class="profile__button-following btn-declinar">
                                                            <p class="profile__button--text">Declinar</p>
                                                        </button>
                                                        <button type="submit" class="profile__button-follow">
                                                            <p class="profile__button--text"> Cancelar </p>
                                                        </button>


                                                    </form>
                                                </div>
                                            </div>

                                            <div class="av-te-ma-modal__footer">
                                                <button class="av-te-ma-modal__accept-btn">
                                                    Aceptar
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                            <div class="table-container-button">
                                            <button type="button" class="profile__button-follow btn-cancelar-solicitud" >
                                                <p class="profile__button--text"> Solicitado </p>
                                            </button>
                            </div>




                                </c:when>
                                <c:otherwise>
                                    <c:if test="${signedIn}">
                                    <div class="table-container-button"><form action="${followURL}" method="post">
                                        <aui:input name="userId" value="${follower.userId}" type="hidden"/>
                                        <aui:input type="hidden" value="${focusedTab}" name="focusedTab"/>
                                        <aui:input name="focusOnUser" value="${userId}" type="hidden"/>
                                        <button type="submit" class="profile__button-follow">
                                            <p class="profile__button--text">Seguir</p>
                                        </button>
                                    </form>
                                    </div>
                                    </c:if>
                                </c:otherwise>
                            </c:choose>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
            <tfoot>
            <tr>
                <th>Profile</th>
                <th>Action</th>
            </tr>
            </tfoot>
        </table>
    </div>
</div>

<!-- TODO: Para comrpobar funcionalidad del cargar más poner la condición del if a true -->
<div id="loadMore" class="follower__load">
    <c:if test="${shownFollowers < followersCount}">
        <form onsubmit="loadMoreForm(this);return false;">
            <input type="hidden" name="tab" value="${loadMoreResourceName}">
            <input type="hidden" name="shownFollowers" value="${shownFollowers}">
            <input type="hidden" name="id" value="${userId}">
            <input type="hidden" name="filterName" value="${filterName}">
            <button class="follower__button--load" type="submit">
                <p class="profile__button--text">Cargar más</p>
                <span class="iconArrowDown"></span>
            </button>
        </form>
    </c:if>
</div>








</div>

<script>
    //initializeDataTable('#following', dataTableParams);
    //initializeSearchFunctionality('#following', '#followingStyle .dt-search', '#followingStyle .dt-search input[type="search"]', 'search-close-button-following');
</script>

<script>
    function loadMoreForm(form) {
        let formData = $(form).serialize();

        $.ajax({
            url: '${followersURL}',
            type: 'GET',
            data: formData,
            success: function (data) {
                $('#loadMore').remove();
                $('#followers-content').append(data);
            },
            error: function (xhr, status, error) {
                console.error('Error en la petición AJAX:', error);
            }
        });
        return false;
    }

    /*script manejo del modal*/
    $(document).ready(function() {
        // Mostrar el modal cuando se haga clic en un botón con la clase 'profile__button-following'
        $('.btn-dejar-de-seguir').on('click', function() {
            // Obtener el ID del usuario desde el formulario relacionado y poder acceder a su Modal
            var userId = $(this).closest('tr').find('input[name="<portlet:namespace/>userId"]').val();
            //console.log("Valor: "+userId);
            var modalId = '#alertModal' + userId;
            // Obtener el nombre del usuario desde el elemento .follower-info-name en la misma fila
            var userName = $(this).closest('tr').find('.follower-info-name').text().trim();
            var userLastName = $(this).closest('tr').find('.follower-info-lastName').text().trim();
            //console.log("Nombre: "+userName);
            // Obtener la URL de la imagen (ajusta según cómo almacenes la URL)
            var userImage = $(this).closest('tr').find('.iconFollowerPicture').css('background-image').replace(/^url\(["']?/, '').replace(/["']?\)$/, '');
            //console.log("Imagen: "+userImage);

            // Actualizar el contenido del modal
            $(modalId+' .modal-name').text(userName || 'Usuario');

            //$('.user-id').val(userId);
            //$(".modalUserId'+'userId'").val(userId);

            if(userImage === "none"){
                let initials = userName.charAt(0).toUpperCase() + userLastName.charAt(0).toUpperCase();
                $(modalId + ' .modal-image-init').remove();

                $(modalId + ' .modal-image').after('<span class="modal-image-init">' + initials + '</span>');

                $(modalId + ' .modal-image').css('display', 'none');
            }
            else{
                $(modalId+' .modal-image').attr('src', userImage || 'default-image.jpg'); // Cambia 'default-image.jpg' por una imagen por defecto si no hay imagen
            }


            // Campo oculto con id del seguido a dejar de seguir
            var className = 'modalUserId-' + userId; // Construye el nombre de la clase dinámicamente
            $('.' + className).val(userId);
            // Mostrar el modal
            //$('#alertModal').fadeIn();
            //console.log("modalID "+modalId);
            $(modalId).fadeIn();
        });

        // Ocultar el modal cuando se haga clic en la X
        $('.av-icon-close,.btn-declinar,#followingStyle .left-arrow').on('click', function() {
            $('.alertModal').fadeOut(); // Ocultar el modal con un efecto de desvanecimiento
            $('#alertModalC').fadeOut(); // Ocultar el modal con un efecto de desvanecimiento
        });

        // Opcional: Ocultar el modal si se hace clic fuera del modal
        $(window).on('click', function(event) {
            if ($(event.target).is('.alertModal')) {
                $('.alertModal').fadeOut(); // Ocultar el modal si se hace clic fuera del panel del modal
            }
            if ($(event.target).is('#alertModalC')) {
                $('#alertModalC').fadeOut(); // Ocultar el modal si se hace clic fuera del panel del modal
            }
        });


        $('.btn-cancelar-solicitud').on('click', function() {
            // Obtener el ID del usuario desde el formulario relacionado
            var userId = $(this).closest('form').find('input[name="<portlet:namespace/>userId"]').val();
            //console.log("userId "+userId);

            // Obtener el nombre del usuario desde el elemento .follower-info-name en la misma fila
            var userName = $(this).closest('tr').find('.follower-info-name').text().trim();
            var userLastName = $(this).closest('tr').find('.follower-info-lastName').text().trim();
            //console.log("userName "+userName);
            //console.log("userLastName "+userLastName);

            // Obtener la URL de la imagen (ajusta según cómo almacenes la URL)
            var userImage = $(this).closest('tr').find('.iconFollowerPicture').css('background-image').replace(/^url\(["']?/, '').replace(/["']?\)$/, '');
            //console.log("userImage "+userImage);

            // Actualizar el contenido del modal
            $('.modal-nameC').text(userName || 'Usuario');
            //$('#modal-imageC').attr('src', userImage || 'default-image.jpg'); // Cambia 'default-image.jpg' por una imagen por defecto si no hay imagen
            $('.modal-user-idC').val(userId);
            //console.log($(this));

            if(userImage === "none"){
                let initials = userName.charAt(0).toUpperCase() + userLastName.charAt(0).toUpperCase();
                $('.modal-image-init').remove();
                $('.modal-image').after('<span class="modal-image-init">' + initials + '</span>');
                $('.modal-image').css('display', 'none');
            }
            else{
                $('.modal-image').attr('src', userImage || 'default-image.jpg');
            }
            // Mostrar el modal
            $('#alertModalC').fadeIn();
        });

    });
</script>
<%-- TODO CSS--%>
<style>
    .modal-seguidores .av-te-ma-modal__footer{
        display: none;
    }
    .modal-image-init{
        color: white;
        width: 100px;
        height: 100px;
        border-radius: 50%;
        background-color: #122C1F;
        display: flex;
        justify-content: center;
        align-items: center;
        font-size: 42px;
        font-weight: 700;
    }

</style>