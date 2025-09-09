<%@ taglib prefix="liferay-ui" uri="http://liferay.com/tld/ui" %>

<%@ include file="init.jsp" %>

<portlet:actionURL name="createSurvey" var="createSurveyURL" />

<div class="container">
	<b><liferay-ui:message key="avaniscomunidadencuesta.caption" /></b>

	<aui:form action="${createSurveyURL}" name="form">
		<aui:input name="<%= Constants.SURVEY_ID%>" type="hidden" />
		<aui:input name="<%= Constants.QUESTION%>" />
		<aui:fieldset label="<%= Constants.ANSWERS%>">

			<aui:input name="<%= Constants.ANSWERS%>" label="" />
			<aui:input name="<%= Constants.ANSWERS%>" label="" />

		</aui:fieldset>
		<aui:fieldset label='<%= "EXPIRE HOURS" %>'>
			<aui:select name="<%= Constants.EXPIRE_HOURS%>" required="true" label="">
				<aui:option value="-1" >Selecciona:</aui:option>
				<aui:option value="12" >12h</aui:option>
				<aui:option value="24" >24h</aui:option>
				<aui:option value="48" >48h</aui:option>
			</aui:select>
		</aui:fieldset>

		<aui:button type="submit" value="save" />
	</aui:form>

</div>

