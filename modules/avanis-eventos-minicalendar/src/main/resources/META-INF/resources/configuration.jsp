<%@ include file="/init.jsp" %>

<liferay-portlet:actionURL portletConfiguration="<%= true %>" var="configurationActionURL" />

<liferay-frontend:edit-form
	action="<%= configurationActionURL %>"
	method="post"
	name="fm"
>
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />

	<liferay-frontend:edit-form-body>
		<liferay-ui:tabs
			names="user-settings,display-settings,rss"
			param="tabs2"
			refresh="<%= false %>"
		>
			<liferay-ui:section>
				<%@ include file="/configuration/user_settings.jspf" %>
			</liferay-ui:section>

			<liferay-ui:section>
				<%@ include file="/configuration/display_settings.jspf" %>
			</liferay-ui:section>

			<liferay-ui:section>
				<%@ include file="/configuration/rss.jspf" %>
			</liferay-ui:section>
		</liferay-ui:tabs>
	</liferay-frontend:edit-form-body>

	<liferay-frontend:edit-form-footer>
		<liferay-frontend:edit-form-buttons />
	</liferay-frontend:edit-form-footer>
</liferay-frontend:edit-form>