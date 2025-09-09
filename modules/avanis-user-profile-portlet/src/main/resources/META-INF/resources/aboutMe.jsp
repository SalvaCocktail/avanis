<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ include file="./init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>

<div class="profile">
    <div class="profile__title">
        <h3> Información personal </h3>

    </div>


    <%-- Si no hay ninguna informacion personal del usuario y lo está viendo otro usuario--%>
    <c:if test="${!me and empty aboutMe  and empty location and empty plotUsages and empty interests }">
        <div class="debes-estar-logeado">
            <div class="profile__non-data">
                <h3 class="profile-card-title "> No hay información personal. </h3>
                <p> ${nombre} aún no ha completado su información personal
                </p>

            </div>
        </div>
    </c:if>

    <div class="profile__data pp-div-sobre-mi">
        <div class="profile__header">
            <h4>Sobre mí</h4>
            <c:if test="${me}">
                <a class="btn-ppublico-editar-sobre-mi" href="${themeDisplay.getURLHome()}/mi-perfil-privado"><button class="profile__button--edit "><span class="profile__icon profile__icon--edit"></span>
                    <p>Editar</p></button></a>
                <!--TODO: Redireccionar a edición de perfil privado, necesitamos saber cual será la url definitiva de la página -->
            </c:if>
        </div>

        <div class="profile__body">
            <c:choose>
                <%-- Si todos los campos están vacíos --%>
                <c:when test="${empty aboutMe && empty location  }">
                <%--<c:when test="${empty aboutMe }">--%>
                    <c:if test="${me}">
                    <script>$(".btn-ppublico-editar-sobre-mi").hide();</script>
                    <div class="debes-estar-logeado">
                        <div class="profile__non-data">
                            <img class="candado" src="<%=request.getContextPath()%>/images/user-alt.svg" alt="icono-candado" />
                            <h3 class="profile-card-title "> ¿Nos cuentas más sobre ti? </h3>
                            <p> Cuantos más datos añadas, más fácil será que otros<br>
                                miembros de Avanis se pongan en contacto contigo.

                            </p>
                            <div class="div-boton-seguir ">
                                <a href="${themeDisplay.getURLHome()}/mi-perfil-privado"><button class="profile__button btn-envio-privado-editar-preferencias" type="submit" >Completar perfil</button></a>
                            </div>
                        </div>
                    </div>
                    </c:if>
                    <c:if test="${!me}">
                        <script>$(".pp-div-sobre-mi").hide();</script>
                    </c:if>
                </c:when>
                <c:otherwise>
                    <p>${aboutMe}</p>
                    <div class="profile__info">
                        <div class="profile__info-item"><span class="profile__icon profile__icon--location"></span>
                            <p>${location}</p>
                        </div>




                        <div class="profile__info-item"><span class="profile__icon profile__icon--phone"></span>
                            <p>${phone}</p>
                        </div>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </div>


    <div class="profile__data pp-div-mis-preferencias">
        <div class="profile__header">
            <h4>Mis preferencias</h4>
            <c:if test="${me}">
                <a class="btn-ppublico-editar-preferencias" href="${themeDisplay.getURLHome()}/mi-perfil-privado?focusedTab=preferences"><button class="profile__button--edit "><span class="profile__icon profile__icon--edit"></span>
                    <p>Editar</p></button></a>
                <!--TODO: Redireccionar a edición de perfil privado, necesitamos saber cual será la url definitiva de la página -->
            </c:if>
        </div>
        <div class="profile__body">
            <c:choose>
                <%-- Si no hay intereses--%>
                <c:when test="${empty interests}">
                    <c:if test="${me}">
                    <script>$(".btn-ppublico-editar-preferencias").hide();</script>
                    <div class="debes-estar-logeado">
                        <div class="profile__non-data">
                            <img class="candado" src="<%=request.getContextPath()%>/images/icon-star.svg" alt="icono-candado" />
                            <h3 class="profile-card-title "> ¿Qué temas te interesan? </h3>
                            <p> Añade tantas preferencias como quieras para que otros  <br>
                                 miembros de Avanis te conozcan mejor.

                            </p>
                            <div class="div-boton-seguir ">
                                <a href="${themeDisplay.getURLHome()}/mi-perfil-privado?focusedTab=preferences"><button class="profile__button btn-envio-privado-editar-preferencias" type="submit" >Añadir preferencias</button></a>
                            </div>
                        </div>
                    </div>
                    </c:if>
                    <c:if test="${!me}">
                        <script>$(".pp-div-mis-preferencias").hide();</script>
                    </c:if>
                </c:when>
                <c:otherwise>
                    <ul class="profile__list">
                        <c:forEach var="interest" items="${interests}">
                            <li class="profile__list-li">${interest.name}</li>
                        </c:forEach>
                    </ul>
                </c:otherwise>
            </c:choose>
        </div>
    </div>


    <div class="profile__data pp-div-mis-parcelas">
        <div class="profile__header">
            <h4>Uso de mis parcelas</h4>
            <c:if test="${me}">
                <a class="btn-ppublico-editar-parcelas" href="${themeDisplay.getURLHome()}/mi-perfil-privado?focusedTab=plots"> <button class="profile__button--edit"><span class="profile__icon profile__icon--edit"></span>
                    <p>Editar</p></button></a>
                <!--TODO: Redireccionar a edición de perfil privado, necesitamos saber cual será la url definitiva de la página -->
            </c:if>
        </div>
        <div class="profile__body">
            <c:choose>
                <%-- Si no hay usos de parcelas--%>
                <c:when test="${empty plotUsages}">
                    <c:if test="${me}">
                    <script>$(".btn-ppublico-editar-parcelas").hide();</script>
                    <div class="debes-estar-logeado">
                        <div class="profile__non-data">
                            <img class="candado" src="<%=request.getContextPath()%>/images/icon-location.svg" alt="icono-candado" />
                            <h3 class="profile-card-title "> ¿Aún no has añadido parcelas? </h3>
                            <p> Añade su ubicación y usos para que otros miembros de<br>
                                Avanis sepan a qué te dedicas

                            </p>
                            <div class="div-boton-seguir">
                                <a href="${themeDisplay.getURLHome()}/mi-perfil-privado?focusedTab=plots"><button type="submit" class="profile__button">Añadir parcelas</button></a>
                            </div>
                        </div>
                    </div>
                    </c:if>
                    <c:if test="${!me}">
                        <script>$(".pp-div-mis-parcelas").hide();</script>
                    </c:if>
                </c:when>
                <c:otherwise>
                    <ul class="profile__list">
                        <c:forEach var="plotUsage" items="${plotUsages}">
                            <li class="profile__list-li">${plotUsage.name}</li>
                        </c:forEach>
                    </ul>
                </c:otherwise>
            </c:choose>
        </div>
    </div>

</div>