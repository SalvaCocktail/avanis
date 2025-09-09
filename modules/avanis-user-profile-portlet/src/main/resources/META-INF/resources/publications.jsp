<%@ taglib prefix="liferay-util" uri="http://liferay.com/tld/util" %>
<%@ include file="./init.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.liferay.asset.kernel.model.AssetEntry" %>
<%@ page import="com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil" %>
<%@ page import="com.liferay.asset.kernel.model.AssetCategory" %>
<%@ page import="java.util.List" %>
<%@ page import="com.liferay.message.boards.model.MBMessage" %>
<%@ page import="com.liferay.expando.kernel.model.ExpandoBridge" %>
<%@ page import="com.liferay.message.boards.service.MBMessageLocalServiceUtil" %>
<%@ page import="com.liferay.ratings.kernel.service.RatingsEntryLocalServiceUtil" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="java.text.Format" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<portlet:actionURL var="followURL" name="follow"/>
<portlet:actionURL var="unfollowURL" name="unfollow"/>
<%@ page import="com.liferay.portal.kernel.repository.model.FileEntry" %>
<%@ page import="com.liferay.portal.kernel.portletfilerepository.PortletFileRepositoryUtil" %>
<%@ page import="com.liferay.portal.kernel.workflow.WorkflowConstants" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="avanis.comunidad.model.Surveys" %>
<%@ page import="avanis.comunidad.model.AnswersUser" %>
<%@ page import="avanis.comunidad.model.Answers" %>
<%@ page import="avanis.comunidad.service.SurveysLocalServiceUtil" %>
<%@ page import="avanis.comunidad.service.AnswersLocalServiceUtil" %>
<%@ page import="avanis.comunidad.service.AnswersUserLocalServiceUtil" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.GregorianCalendar" %>
<%@ page import="avanis.comunidad.portlet.util.MBUtil" %>

<div class="mis-publicaciones">
<div class="profile__header">
    <h3> Publicaciones </h3>
</div>

<c:choose>
    <c:when test="${not empty publications}">
        <c:forEach var="publication" items="${publications}">
            <%-- Mi código--%>
            <c:set var="messageId" value="${publication.messageId}"/>
            <%--
            <div>
                <strong>ID: </strong>${publication.messageId} <br>
                <strong>Subject: </strong>${publication.subject} <br>
            </div>
            --%>
            <%

                long id = (Long) pageContext.getAttribute("messageId");
                AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(MBMessage.class.getName(), id);
                if (assetEntry != null) {
                    List<AssetCategory> categories = assetEntry.getCategories();

                    pageContext.setAttribute("categories", categories);
                } else {
                    pageContext.setAttribute("categories", null);
                }
                MBMessage mbMessage = (MBMessage) pageContext.getAttribute("publication");
                ExpandoBridge expandoBridge = mbMessage.getExpandoBridge();

                String msgBody = mbMessage.getBody();
                if (mbMessage.isFormatBBCode()) {
                    msgBody = MBUtil.getBBCodeHTML(msgBody, themeDisplay.getPathThemeImages());
                    msgBody = msgBody.replaceAll("(?i)(\\[img\\])", "<br>$1");
                    msgBody = msgBody.replaceAll("(?i)(<img)", "<br>$1");
                }

                Date displayDate = mbMessage.getCreateDate();

                Format dayFormat = new SimpleDateFormat("d", locale);
                Format monthFormat = new SimpleDateFormat("MMMMM", locale);
                Format timeFormat = new SimpleDateFormat("HH:mm", locale);

                String dayDescription = dayFormat.format(displayDate);
                String monthDescription = monthFormat.format(displayDate);
                String timeDescription = timeFormat.format(displayDate);
                String rootDateDisplayText = "";

                if (mbMessage.getMessageId() == mbMessage.getRootMessageId()) {
                    rootDateDisplayText = dayDescription + " de " + monthDescription + " a las " + timeDescription;
                }

                pageContext.setAttribute("shared", (Integer) expandoBridge.getAttribute("shared"));
                pageContext.setAttribute("replies", MBMessageLocalServiceUtil.getThreadMessagesCount(mbMessage.getThreadId(), 0));
                pageContext.setAttribute("likes",  RatingsEntryLocalServiceUtil.getEntriesCount(MBMessage.class.getName(), id, 1d));



            %>


            <div class="profile__data publicacion-contenedor">
                <div class="publicacion-cabecera">
                    <%-- INICIALES--%>
                            <%-- Iniciales si no hay foto--%>
                        <c:set var="firstName" value="${fn:trim(fn:substringBefore(name, ' '))}" />
                        <c:set var="secondName" value="${fn:trim(fn:substring(lastName,0,1))}" />
                        <c:set var="initials" value="${fn:toUpperCase(fn:substring(firstName, 0, 1))}${fn:toUpperCase(fn:substring(secondName, 0, 1))}" />
                        <c:set var="portraitURL" value="${profileImage}" />
                        <c:choose>
                            <c:when test="${fn:contains(portraitURL, '/image/user_portrait?img_id=0')}">
                                <%-- Si existe imagen por defecto pongo iniciales--%>
                                <span class="iconFollowerPicture" alt="profilePhoto" style="background-color: #122C1F;background-image: unset;color:white; display: flex; justify-content: center; align-items: center; font-size: 24px; ">${initials}</span>
                            </c:when>
                            <c:otherwise>
                                <%-- Si no , muestro la imagen de perfil--%>
                                <span class="iconFollowerPicture" alt="profilePhoto" style="background-image: url('${profileImage}');"></span>
                            </c:otherwise>
                        </c:choose>

                    <%-- FIN INICIALES--%>


                    <div class="publicacion-cabecera-datos">
                        <!-- TODO: @Jaime hay que editar los estilos de los formularios del c:choose de abajo, para que aparezca como antes <p class="link-avanis">Seguir</p>  -->
                        <h5 class="label-sobre-mi">${name}</h5>
                        <c:choose>
                            <c:when test='${me}'>

                            </c:when>
                            <c:when test='${follow == "followed"}'>
                                <form action="${unfollowURL}" method="post">
                                    <aui:input type="hidden" value="publications" name="focusedTab"
                                               id="focused-tab-visibility-form"/>
                                    <aui:input name="userId" value="${userId}" type="hidden"/>
                                    <div class="div-boton-seguir">
                                        <button type="submit" class="profile__button">Dejar de seguir</button>
                                    </div>
                                </form>
                            </c:when>
                            <c:when test='${signedIn and follow!="requested"}'>
                                <form action="${followURL}" method="post">
                                    <aui:input type="hidden" value="publications" name="focusedTab"
                                               id="focused-tab-visibility-form"/>
                                    <aui:input name="userId" value="${userId}" type="hidden"/>
                                    <div class="div-boton-seguir">
                                        <button type="submit" class="profile__button">Seguir</button>
                                    </div>
                                </form>
                            </c:when>
                            <c:when test='${signedIn and follow=="requested"}'>
                                <p class="profile__button solicitado">Solicitado </p>
                            </c:when>
                        </c:choose>


                        <p class="publicacion-cabecera-datos-fecha" style="flex-basis:100% "> <%= HtmlUtil.escape(rootDateDisplayText) %></p>
                    </div>
                </div>

                <div class="publicacion-cuerpo">
                    <p><%--${publication.body} --%> <%=msgBody%></p>

                    <%-- Si hay imagen--%>
                            <div class="image-attachment-container">
                                <%
                                    int imageCount = 0;
                                    for (FileEntry fileEntry : mbMessage.getAttachmentsFileEntries()) {
                                        if (fileEntry.getMimeType().contains("image")) {
                                            String urlFile = PortletFileRepositoryUtil.getDownloadPortletFileEntryURL(themeDisplay, fileEntry, "status=" + WorkflowConstants.STATUS_APPROVED);
                                            imageCount++;
                                            if(imageCount <= 3){
                                %>

                                <img
                                        class="image-attachment image-attachment<%=imageCount%>"
                                        style="background-image: url('<%=urlFile%>');"
                                        ><%}
                                            else{
                                                %>
                                <img class="image-attachment image-attachment<%=imageCount%> img-extra"
                                    style="background-image: url('<%=urlFile%>');"
                            >
                                <%
                            }
                                        }
                                    }
                                %>
                            </div>
                    <%-- Si existe encuesta--%>

                    <%

                        Surveys survey = null;
                        List<Answers> answersList = null;
                        List<AnswersUser> answersUserList = null;
                        if(assetEntry != null) {
                            List<Surveys> surveys = SurveysLocalServiceUtil.getSurveysByAssetId(assetEntry.getEntryId());
                            if (!surveys.isEmpty()) {
                                survey = surveys.get(0);
                                answersList = AnswersLocalServiceUtil.getAnswersBySurveyId(survey.getSurveyId());
                                answersUserList = AnswersUserLocalServiceUtil.getAnswersUserBySurveyId(survey.getSurveyId());
                            }
                        }
                        if ( survey != null) {

                            int countAllAnswers = answersUserList.size();
                            float[] results = new float[answersList.size()];
                            float sumResults = 0;
                            for (int iAnswer = 0; iAnswer < answersList.size(); iAnswer++) {
                                int countAnswers = 0;
                                for (AnswersUser answerUser : answersUserList) {
                                    if(answerUser.getAnswerId() == answersList.get(iAnswer).getAnswerId()){
                                        countAnswers++;
                                    }
                                }
                                if (countAllAnswers > 0) {
                                    results[iAnswer] = (float) countAnswers / countAllAnswers;
                                    results[iAnswer] = (float) Math.round(results[iAnswer] * 10000) / 100;
                                    sumResults += results[iAnswer];
                                } else {
                                    results[iAnswer]=0;
                                }
                            }
                            if (countAllAnswers > 0) {
                                results[results.length - 1] = results[results.length - 1] - (sumResults - 100);
                            }
                    %>

                        <div class="encuesta">

                            <span class="survey-title"> <%=survey.getQuestion()%> </span>
                            <%      for (int iResult = 0; iResult < results.length; iResult++) {
                                float resultPercentage = results[iResult];
                            %>
                            <div class="progress-group progress-info" data-value="<%=answersList.get(iResult).getAnswerId()%>" >
                                <div class="progress">
                                    <div class="progress-bar" aria-valuemax="100" aria-valuemin="0" aria-valuenow="<%=resultPercentage%>" role="progressbar" style="width: <%=resultPercentage%>%"></div>
                                    <div class="content-text"><%= answersList.get(iResult).getAnswer() %></div>
                                </div>
                                <div class="percentage"><%=resultPercentage%>%</div>
                            </div>
                            <%       }
                                Format timeSurveyExpiateDateFormat = new SimpleDateFormat("HH:mm:ss");
                                String timeSurveyExpiateDate = "";
                                if(Validator.isNotNull(survey.getExpireDate())){
                                    long timeSurveyExpiateMilliseconds = survey.getExpireDate().getTime() - new Date().getTime();
                                    if(timeSurveyExpiateMilliseconds >= 0){
                                        // por finalizar
                                        Calendar expireDate = GregorianCalendar.getInstance();
                                        expireDate.setTimeInMillis(timeSurveyExpiateMilliseconds);
                                        timeSurveyExpiateDate = timeSurveyExpiateDateFormat.format(expireDate.getTime());
                            %>

                            <span class="survey-end-date">
                        Finaliza en <%= timeSurveyExpiateDate %>
                    </span>

                    <%
                    } else {
                        // finalizada
                    %>
                    <span class="survey-end-date">
                    Finalizada
                </span>
                    <%              }
                    }

                                %>

                        </div>
                    <%
                        }
                    %>


                </div>

                <div class="publicacion-categorias">
                    <c:forEach var="category" items="${categories}">
                        <div class="option" data-value="Cereales" >${category.name}</div>
                    </c:forEach>


                </div>
                <div class="publicacion-numero-interactuaciones">
                    <img class="candado" src="<%=request.getContextPath()%>/images/heart.png" alt="icono-likes" /> ${likes}
                    <img class="candado" src="<%=request.getContextPath()%>/images/message-square-lines-alt.png" alt="icono-comentarios" /> ${replies}
                    <img class="candado" src="<%=request.getContextPath()%>/images/Icon-share.png" alt="icono-share" /> ${shared}
                </div>


                <a href="/comunidad/-/publicaciones/${publication.messageId}">
                <div class="publicacion-interactuar">
                    <img class="candado" src="<%=request.getContextPath()%>/images/heart.png" alt="icono-likes" /> Me gusta
                    <img class="candado" src="<%=request.getContextPath()%>/images/message-square-lines-alt.png" alt="icono-comentarios" /> Comentar
                    <img class="candado" src="<%=request.getContextPath()%>/images/Icon-share.png" alt="icono-share" /> Compartir
                </div>
                </a>
            <%-- FIN Mi código--%>

            </div>
        </c:forEach>
    </c:when>
    <c:otherwise>
        <div>
            <div class="profile__non-data">
            <h3 class="profile-card-title "> No hay publicaciones </h3>
            <p> ${name} aún no ha realizado ninguna publicación. </p>
            </div>
        </div>
    </c:otherwise>
</c:choose>



</div>
<%-- Sin publicaciones --%>
<%-- con publicaciones - cuando se tenga toda la lógica de back y las posibles cards de publicaciones --%>



<%--  TODO CSS--%>
<style>
    .publicacion-contenedor{
        padding: 16px 24px 24px 24px;
        gap: 24px;
        border-radius: 8px 0px 0px 0px;
        background-color:#FFFFFF;
        .profile__button{
            background-color: white;
            color: #107E3E;
            width: auto;
            font-size: 14px;
            font-weight: 600;
            line-height: 16px;
            text-align: left;

        }
        .solicitado{
            cursor: unset;
        }
            .image-attachment{
                width: 100%;
            }
            .publicacion-cabecera{
                display: flex;
                .iconFollowerPicture{
                    margin-top: 0px;
                }
                .publicacion-cabecera-datos{
                    display: flex;
                    flex-wrap: wrap;
                    line-height: 0px;
                    align-items: baseline;
                    .link-avanis{
                        cursor: pointer;
                        font-family: Inter;
                        font-size: 14px;
                        font-weight: 600;
                        line-height: 16px;
                        text-align: left;
                        color:#107E3E;
                        margin-left: 0.5em;
                    }
                    .publicacion-cabecera-datos-fecha{
                        color:#646B6B;
                        font-size: 14px;
                        font-weight: 400;
                        text-align: left;


                    }
                }
            }

            .publicacion-cuerpo{
                color:black;
                a{
                    color:#107E3E;
                    font-weight: 600;
                }
                p{
                    margin-top: 1em;
                }
                .encuesta{
                     .survey-title {
                        display: block;
                        margin-bottom: 0.5rem;
                    }
                    .progress-info {
                        color: #9EBE71;
                        color: #A0A0A0;
                        color: #b2bc8f;
                        padding-bottom: 8px;
                        .progress {
                            background-color: #EFF0E8;
                            font-size: 1rem;
                            height: 40px;
                            border-radius: 8px;
                            cursor: pointer;
                            display: flex;
                            flex-grow: 1;
                            min-width: 6.25rem;
                            overflow: hidden;
                            cursor: auto;
                            .progress-bar {
                                background-color: #122C1F;
                                color: #fff;
                                display: flex;
                                flex-direction: column;
                                justify-content: center;
                                overflow: hidden;
                                text-align: center;
                                transition: width 0.6s ease;
                                white-space: nowrap;
                            }
                            .content-text {
                                padding-left: 20px;
                                position: absolute;
                                line-height: 16px;
                                padding-top: 12px;
                                padding-bottom: 12px;
                            }
                        }
                        .percentage {
                            position: absolute;
                            line-height: 16px;
                            padding-top: 12px;
                            padding-bottom: 12px;
                            padding-right: 30px;
                            right: 20px;
                        }

                    }

                }
            }

            .publicacion-categorias{
                color:black;
                .option{
                    background-color: #FFFFFF;
                    border-color: #BFC7C6;
                    border-radius: 8px;
                    border: 1px solid #CCCCCC;
                    font-size: 14px;
                    font-weight: 400;
                    line-height: 18px;
                    padding: 9px 16px;
                    position: relative;
                    display: inline-flex;
                    align-items: center;
                }
            }
        .publicacion-numero-interactuaciones{
            background: #EFF0E8;
            padding: 8px 12px 8px 12px;
            border-radius: 20px;
            margin: 1em 0 1em 0;
            width: max-content;
        }
        .publicacion-interactuar{
            font-family: Inter;
            font-size: 14px;
            font-weight: 600;
            line-height: 16px;
            text-align: left;
            color:#107E3E;
            margin-left: 0.5em;
        }
    }
    .mis-publicaciones{

    }

    .image-attachment-container{
        display: grid;
        grid-template-columns: 2fr 1fr;
        grid-template-rows: 1fr 1fr;
        grid-gap: 10px;
        width: 100%;
    }

    .image-attachment{
        background-size: cover;
        background-position: center;
    }

    .image-attachment1{
        grid-column: 1 / 2; /* Ocupa la primera columna */
        grid-row: 1 / 3; /* Ocupa desde la primera hasta la segunda fila */
        background-position: center;
        height: 283px;
    }
    .image-attachment2{
        grid-column: 2 / 3; /* Ocupa la segunda columna */
        grid-row: 1 / 2; /* Ocupa la primera fila */
        background-position: center;
        height: 136px;
    }
    .image-attachment3{
        grid-column: 2 / 3; /* Ocupa la segunda columna */
        grid-row: 2 / 3; /* Ocupa la segunda fila */
        background-position: center;
        height: 136px;
    }
.img-extra{
    height: 136px;
}
</style>