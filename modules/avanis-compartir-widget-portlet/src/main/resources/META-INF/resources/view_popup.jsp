<%@ include file="/init.jsp" %>

<%--
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
--%>

<%
    String portalURL = PortalUtil.getPortalURL(request);

    byte[] array = new byte[4]; // length is bounded by 7
    new Random().nextBytes(array);
    String instanceId = new String(array, Charset.forName("UTF-8"));

    String url = ParamUtil.getString(request, "url");
    String resourceName = ParamUtil.getString(request, "resourceName");
    String template = ParamUtil.getString(request, "template");
    String resourceId = ParamUtil.getString(request, "resourceId");
    String content = (String) request.getAttribute("content");

%>

    <!--TODO: Hay que encapsular el siguiente código en un modal que debe abrir el icóno de share -->
    <div class="av-ac-modal-partial av-ac-mp">
    <% if(Validator.isNotNull(content)) { %>
        <%= content %>
        <div class="av-ac-mp__separador"></div>
    <% } %>
        <liferay-portlet:runtime portletName="avanis_compartir_rrss_portlet_AvanisCompartirRrssPortlet"
                                 queryString='<%="resourceName=" + resourceName + "&resourceId=" + resourceId + "&url=" + url %>'
                                 instanceId="<%= resourceId %>"/>
    </div>

    <liferay-portlet:runtime portletName="avanis_compartir_email_portlet_AvanisCompartirEmailPortlet"
                             queryString='<%="resourceName=" + resourceName + "&resourceId=" + resourceId + "&url=" + url %>'
                             instanceId="<%= resourceId %>"/>


<script type="text/javascript" language="javascript">
    $(document).ready(function () {
        $(".av-ac-mp__cancel").on("click", function (e) {
            e.preventDefault();
            closeShareForm();
        })
    });
    function closeShareForm() {
        window.parent.closeSharePopup("AvanisComunidad_dialogShare");
    }

</script>
