<%@ include file="../init.jsp" %>

<%--<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>--%>

<%
    String portalURL = PortalUtil.getPortalURL(request);
    long messageId = ParamUtil.getLong(request, "messageId");
%>


    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="form-group">
                    <!--TODO: Hay que encapsular el siguiente código en un modal que debe abrir el icóno de share -->
                    <liferay-portlet:runtime portletName="avanis_compartir_rrss_portlet_AvanisCompartirRrssPortlet"
                                             queryString='<%="url=" + portalURL + "/comunidad/-/publicaciones/"+ messageId %>'
                                             instanceId="<%= String.valueOf(messageId) %>"/>

                    <liferay-portlet:runtime portletName="avanis_compartir_email_portlet_AvanisCompartirEmailPortlet"
                                             queryString='<%="resourceName=MBMessage&resourceId=" + messageId %>'
                                             instanceId="<%= String.valueOf(messageId) %>"/>
                </div>
            </div>
        </div>
    </div>

<script type="text/javascript" language="javascript">
    $(document).ready(function () {
        $(".av-ac-mp__cancel").on("click", function (e) {
            e.preventDefault();
            closeShareForm();
        })
    });
    function closeShareForm() {
        <c:choose>
        <c:when test="${isFromDetail}">
        window.parent.closeShareMessageModalFromDetail();
        </c:when>
        <c:otherwise>
        window.parent.closeShareMessageModal();
        </c:otherwise>
        </c:choose>
    }

</script>
