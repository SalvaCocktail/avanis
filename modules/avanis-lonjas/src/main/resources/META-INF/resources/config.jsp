<%@ include file="init.jsp" %>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationActionURL" />
<liferay-portlet:renderURL portletConfiguration="true" var="configurationRenderURL" />

<liferay-frontend:edit-form action="<%= configurationActionURL%>" >
    <aui:input name="<%=Constants.CMD%>" type="hidden" value="<%=Constants.UPDATE%>" />
    <aui:input name="redirect" type="hidden" value="<%=configurationRenderURL%>" />

    <liferay-frontend:edit-form-body>
        <liferay-frontend:fieldset>
            <aui:input  type="text" suffix="Formato (dd/MM/yyyy)" label="Fecha desde actualizaci&oacute;n hit&oacute;rico" name="<%=AvanisLonjasPortlet.HISTORIC_DATE_UPDATE%>" value="" />
        </liferay-frontend:fieldset>
    </liferay-frontend:edit-form-body>

    <liferay-frontend:edit-form-footer>
        <aui:button type="submit" />
        <aui:button type="cancel" />
    </liferay-frontend:edit-form-footer>
</liferay-frontend:edit-form>

