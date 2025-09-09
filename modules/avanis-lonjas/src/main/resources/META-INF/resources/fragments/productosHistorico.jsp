<%@ include file="../init.jsp" %>

<div class="productos-historico">
    <c:forEach
            var="producto"
            items="${listaProductos}"
    >
        <%@ include file="/card-list.jsp" %>
    </c:forEach>
</div>
