<%@ page import="avanis.comunidad.model.AnswerResults" %>
<%@ page import="avanis.comunidad.portlet.util.*" %>
<%@ include file="../init.jsp" %>

<%
    long messageId = (Long) request.getAttribute("messageId");
    if(Validator.isNotNull(messageId)){
        Surveys survey = null;
        List<Answers> answersList = null;
        List<AnswersUser> answersUserList = null;
        AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(MBMessage.class.getName(), messageId);
        if (assetEntry != null) {
            List<Surveys> surveys = SurveysLocalServiceUtil.getSurveysByAssetId(assetEntry.getEntryId());
            if (!surveys.isEmpty()) {
                survey = surveys.get(0);
                answersList = AnswersLocalServiceUtil.getAnswersBySurveyId(survey.getSurveyId());
                answersUserList = AnswersUserLocalServiceUtil.getAnswersUserBySurveyId(survey.getSurveyId());
            }
        }

        if (survey != null) {
            int countAllAnswers = answersUserList.size();

            // Aquí llamada al método que ejecuta la consulta SQL optimizada que devuelve answerId, answer, countAnswers y percentage.
            List<AnswerResults> resultsList = AvanisComunidadUtil.executeSurveyResultsQuery(survey.getSurveyId());

%>
<span class="survey-title"> <%=survey.getQuestion()%> </span>
<%      for (AnswerResults result : resultsList) {
    float resultPercentage = result.getPercentage();
%>

<div class="progress-group progress-info" data-value="<%= result.getAnswerId() %>" id="<portlet:namespace />encuesta_<%= messageId %>_<%= result.getAnswerId() %>">
    <div class="progress">
        <div class="progress-bar" aria-valuemax="100" aria-valuemin="0" aria-valuenow="<%= resultPercentage %>" role="progressbar" style="width: <%= resultPercentage %>%"></div>
        <div class="content-text"><%= result.getAnswer() %></div>
    </div>
    <div class="percentage"><%= resultPercentage %>%</div>
</div>
<%
    }

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
                        <liferay-ui:message key="finalize-survey-in"/> <%= timeSurveyExpiateDate %>
                    </span>
<%
} else {
    // finalizada
%>
<span class="survey-end-date">
                        <liferay-ui:message key="finalized-survey"/>
                    </span>
<%              }
}
}
}
%>
