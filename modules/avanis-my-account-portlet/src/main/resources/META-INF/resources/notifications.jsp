<%@ include file="./init.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<portlet:actionURL var="saveNotificationsURL" name="saveNotifications"/>

<div class="av-main__header">
    <img class="go-to-menu" onClick="displayMenu()" class="mr-2"
         src="<%=request.getContextPath()%>/images/arrow-left.png" alt="arrow left"/>
    <h2>Notificaciones</h2>
</div>


<div class="mi-perfil-notificaciones">
    <aui:form method="post" cssClass="av-form-my-account" action="${saveNotificationsURL}" name="fma"
              enctype="multipart/form-data">
        <aui:input type="hidden" value="notifications" name="focusedTab"/>
        <!-- Muestro parcela con checkbox de email y notificacion-->

        <c:if test="${!empty plots}">

            <h4>Notificaciones de alertas en mis parcelas</h4>
            <p>Con ellas, te mantendremos al día de alertas meteorológicas que puedan afectar a tus parcelas.
                Así podrás tomar las mejores decisiones para proteger tus cultivos o a tu ganado. ¡Actívalas o
                desactívalas
                cuando quieras!</p><br>

            <c:forEach var="plot" items="${plots}">
                <div class="mi-perfil-notificacion-parcela">
                    <p class="titulo-notificacion">${plot.name}</p>

                    <div class="conjunto-checkboxes">
                        <div class="checkbox-slider--b-flat"><label>
                            <input class="form-check-input" type="checkbox"
                                   name="<portlet:namespace/>plot_${plot.explotacionId}" ${plot.allowNotifications ? "checked" : ""} >
                            <span><p>Notificacion</p></span></label>
                        </div>
                    </div>
                </div>

            </c:forEach>


        </c:if>


        <h4>Notificaciones de mi comunidad</h4>
        <p>Te mantendremos al tanto de cualquier interacción que recibas en la comunidad:
            “me gusta” a tus publicaciones, comentarios de otros miembros... Decide si activarlas y mantente al
            día. </p><br>


        <div class="mi-perfil-notificacion-de-mi-comunidad">
            <p class="titulo-notificacion">'Me gusta' recibidos</p>

            <div class="conjunto-checkboxes">
                <div class="checkbox-slider--b-flat"><label>
                    <input class="form-check-input" type="checkbox"
                           name="<portlet:namespace/>likes_email" ${(likeNotification == "all" || likeNotification == "email") ? "checked" : ""}>
                    <span><p>Email</p></label></span>
                </div>

                <div class="checkbox-slider--b-flat">
                    <label>
                        <input class="form-check-input" type="checkbox"
                               name="<portlet:namespace/>likes_app" ${(likeNotification == "all" || likeNotification == "app") ? "checked" : ""}>
                        <span><p>Notificacion</p></span>
                        <label>
                </div>
            </div>
        </div>
        <hr>

        <div class="mi-perfil-notificacion-de-mi-comunidad">
            <p class="titulo-notificacion">Comentarios</p>


            <div class="conjunto-checkboxes">
                <div class="checkbox-slider--b-flat"><label>
                    <input class="form-check-input" type="checkbox"
                           name="<portlet:namespace/>comments_email" ${(commentNotification == "all" || commentNotification == "email") ? "checked" : ""}>
                    <span><p>Email</p></span>
                </label>
                </div>

                    <%-- likes --%>
                <div class="checkbox-slider--b-flat"><label>
                    <input class="form-check-input" type="checkbox"
                           name="<portlet:namespace/>comments_app" ${(commentNotification == "all" || commentNotification == "app") ? "checked" : ""}>
                    <span><p>Notificacion</p></span>
                </div>
                </label>
            </div>
        </div>
        <hr>

        <div class="mi-perfil-notificacion-de-mi-comunidad">
            <p class="titulo-notificacion">Menciones y etiquetas</p>

            <div class="conjunto-checkboxes">
                <div class="checkbox-slider--b-flat"><label>
                    <input class="form-check-input" type="checkbox"
                           name="<portlet:namespace/>mentions_email" ${(mentionsNotification == "all" || mentionsNotification == "email") ? "checked" : ""}>
                    <span><p>Email</p></label></span>
                </div>

                <div class="checkbox-slider--b-flat">
                    <label>
                        <input class="form-check-input" type="checkbox"
                               name="<portlet:namespace/>mentions_app" ${(mentionsNotification == "all" || mentionsNotification == "app") ? "checked" : ""}>
                        <span><p>Notificacion</p></span>
                        <label>
                </div>
            </div>
        </div>
        <hr>

        <div class="mi-perfil-notificacion-de-mi-comunidad">
            <p class="titulo-notificacion">Resultados de encuestas</p>

            <div class="conjunto-checkboxes">
                <div class="checkbox-slider--b-flat"><label>
                    <input class="form-check-input" type="checkbox"
                           name="<portlet:namespace/>surveys_results_email" ${(surveyResultsNotification == "all" || surveyResultsNotification == "email") ? "checked" : ""}>
                    <span><p>Email</p></label></span>
                </div>

                <div class="checkbox-slider--b-flat">
                    <label>
                        <input class="form-check-input" type="checkbox"
                               name="<portlet:namespace/>surveys_results_app" ${(surveyResultsNotification == "all" || surveyResultsNotification == "app") ? "checked" : ""}>
                        <span><p>Notificación</p></span>
                        <label>
                </div>
            </div>
        </div>
        <hr>

        <div class="mi-perfil-notificacion-de-mi-comunidad">
            <p class="titulo-notificacion">Nuevos seguidores</p>

            <div class="conjunto-checkboxes">
                <div class="checkbox-slider--b-flat"><label>
                    <input class="form-check-input" type="checkbox"
                           name="<portlet:namespace/>followers_email" ${(followersNotification == "all" || followersNotification == "email") ? "checked" : ""}>
                    <span><p>Email</p></label></span>
                </div>

                <div class="checkbox-slider--b-flat">
                    <label>
                        <input class="form-check-input" type="checkbox"
                               name="<portlet:namespace/>followers_app" ${(followersNotification == "all" || followersNotification == "app") ? "checked" : ""}>
                        <span><p>Notificación</p></span>
                        <label>
                </div>
            </div>
        </div>
        <hr>

        <div class="mi-perfil-notificacion-de-mi-comunidad">
            <p class="titulo-notificacion">Logros</p>

            <div class="conjunto-checkboxes">
                <div class="checkbox-slider--b-flat"><label>
                    <input class="form-check-input" type="checkbox"
                           name="<portlet:namespace/>achievements_email" ${(achievementsNotification == "all" || achievementsNotification == "email") ? "checked" : ""}>
                    <span><p>Email</p></label></span>
                </div>

                <div class="checkbox-slider--b-flat">
                    <label>
                        <input class="form-check-input" type="checkbox"
                               name="<portlet:namespace/>achievements_app" ${(achievementsNotification == "all" || achievementsNotification == "app") ? "checked" : ""}>
                        <span><p>Notificación</p></span>
                        <label>
                </div>
            </div>
        </div>


        <%--
        <h4>Notificaciones de Eventos </h4>
        <p>Te enviaremos un resumen mensual de eventos, así como recordatorios de próximos eventos que puedan ser de tu interés.  </p><br>
        <div class="mi-perfil-notificacion-de-mi-comunidad">
        <p class="titulo-notificacion">Resumen mensual</p>

        <div class="conjunto-checkboxes">
        <div class="checkbox-slider--b-flat"><label>
        <input class="form-check-input" type="checkbox"
        name="<portlet:namespace/>achievements_email" ${(achievementsNotification == "all" || achievementsNotification == "email") ? "checked" : ""}>
        <span><p>Email</p></label></span>
        </div>

        </div>
        </div>

        <hr>
        <div class="mi-perfil-notificacion-de-mi-comunidad">
        <p class="titulo-notificacion">Recordatorio próximos eventos</p>

        <div class="conjunto-checkboxes">
        <div class="checkbox-slider--b-flat"><label>
        <input class="form-check-input" type="checkbox"
        name="<portlet:namespace/>achievements_email" ${(achievementsNotification == "all" || achievementsNotification == "email") ? "checked" : ""}>
        <span><p>Email</p></label></span>
        </div>

        <div class="checkbox-slider--b-flat">
        <label>
        <input class="form-check-input" type="checkbox"
        name="<portlet:namespace/>achievements_app" ${(achievementsNotification == "all" || achievementsNotification == "app") ? "checked" : ""}>
        <span><p>Notificación</p></span>
        <label>
        </div>
        </div>
        </div>
        <hr>
        --%>

        <h4>Notificaciones de Ayudas y subvenciones</h4>
        <p>Te avisaremos del lanzamiento de nuevas ayudas y subvenciones relacionadas con tus parcelas, cuando estén a una semana de vencer o cuando se reactiven las ayudas anuales. </p><br>

        <div class="mi-perfil-notificacion-de-mi-comunidad">
            <p class="titulo-notificacion">Nuevas ayudas para tu explotación</p>

            <div class="conjunto-checkboxes">
                <div class="checkbox-slider--b-flat"><label>
                    <input class="form-check-input" type="checkbox"
                           name="<portlet:namespace/>ayudas_nuevas_email" ${(ayudas_nuevas == "all" || ayudas_nuevas == "email") ? "checked" : ""}>
                    <span><p>Email</p></label></span>
                </div>

                <div class="checkbox-slider--b-flat">
                    <label>
                        <input class="form-check-input" type="checkbox"
                               name="<portlet:namespace/>ayudas_nuevas_app" ${(ayudas_nuevas == "all" || ayudas_nuevas == "app") ? "checked" : ""}>
                        <span><p>Notificación</p></span>
                        <label>
                </div>
            </div>
        </div>
        <hr>

        <div class="mi-perfil-notificacion-de-mi-comunidad">
            <p class="titulo-notificacion">Ayudas a punto de vencer</p>

            <div class="conjunto-checkboxes">
                <div class="checkbox-slider--b-flat"><label>
                    <input class="form-check-input" type="checkbox"
                           name="<portlet:namespace/>ayudas_porvencer_email" ${(ayudas_porvencer == "all" || ayudas_porvencer == "email") ? "checked" : ""}>
                    <span><p>Email</p></label></span>
                </div>

                <div class="checkbox-slider--b-flat">
                    <label>
                        <input class="form-check-input" type="checkbox"
                               name="<portlet:namespace/>ayudas_porvencer_app" ${(ayudas_porvencer == "all" || ayudas_porvencer == "app") ? "checked" : ""}>
                        <span><p>Notificación</p></span>
                        <label>
                </div>
            </div>
        </div>
        <hr>
        <div class="mi-perfil-notificacion-de-mi-comunidad">
            <p class="titulo-notificacion">Reactivación de ayudas anuales</p>

            <div class="conjunto-checkboxes">
                <div class="checkbox-slider--b-flat"><label>
                    <input class="form-check-input" type="checkbox"
                           name="<portlet:namespace/>ayudas_reactivacion_email" ${(ayudas_reactivacion == "all" || ayudas_reactivacion == "email") ? "checked" : ""}>
                    <span><p>Email</p></label></span>
                </div>

                <div class="checkbox-slider--b-flat">
                    <label>
                        <input class="form-check-input" type="checkbox"
                               name="<portlet:namespace/>ayudas_reactivacion_app" ${(ayudas_reactivacion == "all" || ayudas_reactivacion == "app") ? "checked" : ""}>
                        <span><p>Notificación</p></span>
                        <label>
                </div>
            </div>
        </div>


        <hr>


        <h4>Comunicaciones comerciales</h4>
        <p>¿Nos das permiso para enviarte comunicaciones comerciales?</p>
        <div class="form-check checkbox-slider--b-flat">
            <label>
                <input class="form-check-input" type="checkbox"
                       name="<portlet:namespace/>allowNewsLetter" ${allowNewsLetter ? "checked": "" }>
                <span><p class="permitir-notificaciones-label">Permitir comunicaciones de Avanis</p></span>

            </label>
        </div>
        <div class="av-about-form-control-buttons">
            <button class="btn  btn-primary" id="_avanis_my_account_portlet_AvanisMyAccountPortlet_INSTANCE_ktts_kvrs"
                    type="submit">
                <span class="lfr-btn-label">Guardar</span>
            </button>
        </div>
    </aui:form>
</div>