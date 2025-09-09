<%@ include file="../init.jsp" %>
<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>

<div class="av-lmw">
	<div class="av-lmw__container">
		<div class="av-lmw__header">
			<div class="av-lmw__header-title">
				Últimas lonjas y mercados
			</div>
			<div class="av-lmw__header-dots-icon js-av-lmw__dots d-none">
				<svg width="16" height="4" viewBox="0 0 16 4" fill="none" xmlns="http://www.w3.org/2000/svg" >
					<path fill-rule="evenodd" clip-rule="evenodd" fill="#646B6B"
						d="M0 2C0 0.89543 0.89543 0 2 0C3.10457 0 4 0.89543 4 2C4 3.10457 3.10457 4 2 4C0.89543 4 0 3.10457 0 2ZM6 2C6 0.89543 6.89543 0 8 0C9.10457 0 10 0.89543 10 2C10 3.10457 9.10457 4 8 4C6.89543 4 6 3.10457 6 2ZM12 2C12 0.89543 12.8954 0 14 0C15.1046 0 16 0.89543 16 2C16 3.10457 15.1046 4 14 4C12.8954 4 12 3.10457 12 2Z"/>
				</svg>
			</div>
		</div>

		<div class="av-lmw__separador"></div>

		<div class="av-lmw__body">
			<div class="av-lmw__cards-gradient av-lmw__cards-gradient--left av-theme__hidden"> </div>
			<div class="av-lmw__cards-gradient av-lmw__cards-gradient--right"> </div>
			<div class="av-lmw__cards js-av-lmw__cards av-theme__slider-draggable">

				<c:set var="counter" value="0" />
				<c:forEach var="producto" items="${listaProductos}" >
					<c:if test="${counter < 10}">
						<%@ include file="/card-widget.jsp" %>
						<c:set var="counter" value="${counter + 1}" />
					</c:if>
				</c:forEach>
			</div>
		</div>

		<a href="/es/lonjas" class="av-lmw__footer js-av-lmw__footer">Ver todas las lonjas</a>
	</div>
</div>

<script>
    $( document ).ready(function() {
        makeSliderDraggable('.js-av-lmw__cards');
    });
</script>
