<%@ include file="/init.jsp" %>

<liferay-ui:error-header />

<liferay-ui:error exception="<%= NoSuchResourceException.class %>" message="the-resource-could-not-be-found" />

<liferay-ui:error-principal />