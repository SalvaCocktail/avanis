<%@ include file="init.jsp" %>

<%
    String portalURL = PortalUtil.getPortalURL(request);

    String url = (String) request.getAttribute("url");
    String resourceName = ParamUtil.getString(request, "resourceName");
    String resourceId = ParamUtil.getString(request, "resourceId");
    String journalTitle = ParamUtil.getString(request, "journalTitle");
    String viewLink = ParamUtil.getString(request, "viewLink");

    String functionViewPopup =  "javascript:functionViewPopup" + resourceId+ "();";
%>

<% if("true".equals(viewLink)) { %>
<liferay-ui:icon
        icon="share"
        label="<%= true %>"
        markupView="lexicon"
        message="share"
        method="get"
        url="<%= functionViewPopup %>"
/>
<% } %>

<script type="text/javascript" language="javascript">

    function functionViewPopup<%=resourceId%>() {
        <portlet:renderURL var="viewPopupURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
        	<portlet:param name="<%= Constants.CMD %>" value="view_popup" />
        </portlet:renderURL>

        let width_ = 0;
        if (document.documentElement.clientWidth < 768) {
            width_ = 360;
        } else {
            width_ = 608;
        }

        Liferay.Util.openWindow({
            dialog: {
                //cssClass: 'aui-popup-example',
                destroyOnHide: true,
                height: 550,
                width: width_,
                close: true,

                centered: true,
                resizable: false,
                destroyOnClose: true
            },
            id: 'AvanisComunidad_dialogShare',
            dialogIframe: {
                bodyCssClass: 'share-widget-css'
            },
            title: '<liferay-ui:message key="custom-share-popup"/>',
            uri: '<%=viewPopupURL%>&<portlet:namespace/>resourceName=<%= resourceName %>&<portlet:namespace/>resourceId=<%= resourceId %>&<portlet:namespace/>journalTitle=<%= journalTitle %>&<portlet:namespace/>url=<%= url %>'
        });

        // Provide a function to close modal dialogs in the parent page
        Liferay.provide(
            window,
            'closeSharePopup',
            function (popupId) {
                let dialog = Liferay.Util.getWindow(popupId);
                dialog.destroy();
            },
            ['aui-base', 'aui-dialog', 'aui-dialog-iframe']
        );
    }

</script>
