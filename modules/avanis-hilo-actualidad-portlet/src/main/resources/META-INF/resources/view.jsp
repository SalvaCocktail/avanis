<%@ page import="com.liferay.asset.link.model.AssetLink" %>
<%@ page import="java.util.List" %>
<%@ page import="com.liferay.asset.kernel.model.AssetEntry" %>
<%@ page import="com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil" %>
<%@ include file="/init.jsp" %>

<p>
	<b><liferay-ui:message key="avanishiloactualidad.caption"/></b>
</p>

<!--
	*****TODO: FALTA:
	MAQUETAR
	CONDICION EN CASO DE ESTAR LOQUEADO MOSTRAR URL
	CONDICION EN CASO DE NO ESTAR LOGUEADO LLEVE A REGISTRO

-->

<%
	List<AssetLink> assetLinks = (List<AssetLink>) request.getAttribute("assetLinks");

	if (assetLinks != null && !assetLinks.isEmpty()) {
%>
<h3>Asset Links:</h3>
<ul>
	<%
		for (AssetLink assetLink : assetLinks) {
			AssetEntry linkedAssetEntry = AssetEntryLocalServiceUtil.getAssetEntry(assetLink.getEntryId2());
	%>
	<li>
		<%= linkedAssetEntry.getTitle(themeDisplay.getLocale()) %>
		- <%= linkedAssetEntry.getClassName() %>
		- <%= linkedAssetEntry.getClassPK() %>
	</li>
	<%
		}
	%>
</ul>
<%
} else {
%>
<p>No asset links found for this blog entry.</p>
<%
	}
%>
