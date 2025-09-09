<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="avanis.tu.explotacion.sb.model.Explotacion" %>
<%@ page import="com.liferay.asset.kernel.model.AssetEntry" %>
<%@ page import="com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil" %>
<%@ page import="com.liferay.asset.kernel.model.AssetCategory" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<jsp:directive.page contentType="text/html" pageEncoding="UTF-8" />

<div class="av-te-plotsList av-te-pl">

	<h3 class="h3">Mis parcelas</h3>

	<c:forEach var="plot" items="${plots}" varStatus="status">
		<c:set var="plotId" value="${plot.explotacionId}"/>

		<c:set var="currentForecast" value="${mapCurrentForecast.get(plotId)}"/>
		<c:set var="warningsNumber" value="${mapWarningsToday.get(plotId)}"/>
		<c:set var="todayDailyForecast" value="${mapTodayDailyForecast.get(plotId)}"/>
		<c:set var="plotName" value="${plot.name}"/>
		<c:set var="plotProvince" value="${plot.provincia}"/>
		<c:set var="plotLocation" value="${focusedPlot.location}"/>
		<c:set var="plotLocation" value="${plot.location}"/>
		<c:set var="plotLongitude" value="${plot.longitude}"/>
		<c:set var="plotLatitude" value="${plot.latitude}"/>

		<c:set var="temperature" value="${currentForecast.temperature}"/>
		<c:set var="minTemperature" value="${todayDailyForecast.minTemperature}"/>
		<c:set var="maxTemperature" value="${todayDailyForecast.maxTemperature}"/>

		<c:set var="plotHeight" value="${plot.height}"/>
		<c:set var="plotMeteoredID" value="${plot.meteoredid}"/>
		<c:set var="plotSize" value="${plot.size}"/>
		<c:set var="plotSizeUnit" value="${plot.sizeUnit}"/>
		<c:set var="plotMain" value="${plot.isMain}"/>
		<c:set var="plotFocusedId" value="${focusedPlot.explotacionId}"/>

		<!-- Código para conseguir las categorias (Usos en la vista) -->
	<%
	long id = (Long) pageContext.getAttribute("plotId");
	AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(Explotacion.class.getName(), id);
	if (assetEntry != null) {
		List<AssetCategory> categories = assetEntry.getCategories();
			pageContext.setAttribute("categories", categories);
		} else {
			pageContext.setAttribute("categories", null);
		}
	%>

	<!-- Selector de las distintas explotaciones -->
	<aui:form id="form-${status.index}" action="${setFocusURL}" method="GET" class="av-te-pl__form" style="display: none;" data-formid="form-${status.index}">
		<input type="hidden" name="plotId" value="${plot.explotacionId}"/>
		<input type="hidden" name="dayNumber" value="${dayNumber}"/>
		<aui:button id="buttonList-${status.index}" type="submit" value="Seleccionar explotación" class="av-te-pl__submit-button" data-buttonid="button-${status.index}"/>
	</aui:form> 

	<!-- Tarjetas de las distintas explotaciones -->
	<div class="av-te-pl__plot-card av-te-pl__plot-card-${status.index} ${plotId == plotFocusedId ? 'selected-card' : ''}" data-id="${status.index}">
		<div class="av-te-pl__row-001">
			<h5 class="av-te-pl__plot-name ${plotId == plotFocusedId ? 'h5-inverse' : 'h5'}">${plotName}</h5>
			<div class="av-te-pl__plot-warnings-number">
				<svg width="15" height="14" viewBox="0 0 15 14" fill="none" xmlns="http://www.w3.org/2000/svg">
					<path fill-rule="evenodd" clip-rule="evenodd" d="M6.67179 0.613075C7.19821 0.373441 7.80259 0.373441 8.32901 0.613075C8.70287 0.783261 8.96525 1.09575 9.18605 1.42247C9.40596 1.74788 9.64672 2.18564 9.93793 2.71515L13.6947 9.5456C13.9676 10.0418 14.1946 10.4544 14.3436 10.796C14.4944 11.1417 14.6115 11.5123 14.5645 11.9046C14.4978 12.4616 14.2001 12.965 13.7442 13.292C13.4231 13.5222 13.042 13.5982 12.6664 13.6326C12.2952 13.6667 11.8244 13.6666 11.258 13.6666H3.74276C3.17641 13.6666 2.70555 13.6667 2.33445 13.6326C1.95884 13.5982 1.57771 13.5222 1.25662 13.292C0.800691 12.965 0.503043 12.4616 0.436299 11.9046C0.389295 11.5123 0.506391 11.1417 0.657223 10.796C0.80625 10.4544 1.03318 10.0418 1.30613 9.54559L5.06286 2.71517C5.35408 2.18565 5.59484 1.74788 5.81475 1.42247C6.03555 1.09575 6.29793 0.783261 6.67179 0.613075ZM7.77661 1.82659C7.60113 1.74671 7.39967 1.74671 7.2242 1.82659C7.19539 1.8397 7.10407 1.8959 6.91947 2.16904C6.73797 2.43762 6.52638 2.82094 6.21529 3.38656L2.49 10.1598C2.19748 10.6917 2.00091 11.0505 1.87931 11.3292C1.75668 11.6102 1.75617 11.7126 1.76016 11.7459C1.78241 11.9316 1.88163 12.0994 2.0336 12.2084C2.06086 12.228 2.15084 12.2769 2.45621 12.3049C2.75903 12.3326 3.16813 12.3333 3.77511 12.3333H11.2257C11.8327 12.3333 12.2418 12.3326 12.5446 12.3049C12.85 12.2769 12.9399 12.228 12.9672 12.2084C13.1192 12.0994 13.2184 11.9316 13.2406 11.7459C13.2446 11.7126 13.2441 11.6102 13.1215 11.3292C12.9999 11.0505 12.8033 10.6917 12.5108 10.1598L8.78552 3.38657C8.47442 2.82094 8.26283 2.43762 8.08133 2.16904C7.89674 1.8959 7.80541 1.8397 7.77661 1.82659ZM7.5004 4.99996C7.86859 4.99996 8.16707 5.29844 8.16707 5.66663V8.3333C8.16707 8.70149 7.86859 8.99997 7.5004 8.99997C7.13221 8.99997 6.83373 8.70149 6.83373 8.3333V5.66663C6.83373 5.29844 7.13221 4.99996 7.5004 4.99996ZM6.83373 10.3333C6.83373 9.96511 7.13221 9.66663 7.5004 9.66663H7.50707C7.87526 9.66663 8.17373 9.96511 8.17373 10.3333C8.17373 10.7015 7.87526 11 7.50707 11H7.5004C7.13221 11 6.83373 10.7015 6.83373 10.3333Z" fill="#101717"/>
				</svg>

				<span class="body-s">
					${warningsNumber}
				</span>
			</div>
		</div>

		<div class="av-te-pl__plot-province ${plotId == plotFocusedId ? 'body-s-inverse' : 'body-s'}">
				${plotLocation}, ${plotProvince}
		</div>

		<div class="av-te-pl__plot-uses ${plotId == plotFocusedId ? 'body-s-inverse' : 'body-s'}">
			<c:choose>
				<c:when test="${fn:length(categories) > 1}">
					Usos:
				</c:when>
				<c:otherwise>
					Uso:
				</c:otherwise>
			</c:choose>
			<c:forEach var="category" items="${categories}" varStatus="status">
				<span>${category.name}</span>
				<c:if test="${!status.last}">, </c:if>
			</c:forEach>
		</div>

		<div class="av-te-pl__plot-current-forecast">
			<div class="av-te-pl__symbol symbol-icon symbol-icon--${currentForecast.symbol}"></div>
			<div class="av-te-pl__information">
				<div class="av-te-pl__temperature ${plotId == plotFocusedId ? 'h5-inverse' : 'h5'}">
					${Math.round(temperature)}ºC
				</div>
				<div class="av-te-pl__min-max ${plotId == plotFocusedId ? 'body-s-inverse' : 'body-s'}">
					${Math.round(minTemperature)}º
					- ${Math.round(maxTemperature)}º

				</div>
			</div>

		</div>
	</div>

	</c:forEach>

	<div class="av-te-pl__plot-list-empty av-te-hidden">
		<svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
			<path d="M8 20H5C4.73478 20 4.48043 19.8946 4.29289 19.7071C4.10536 19.5196 4 19.2652 4 19V16C4 15.7348 3.89464 15.4804 3.70711 15.2929C3.51957 15.1054 3.26522 15 3 15C2.73478 15 2.48043 15.1054 2.29289 15.2929C2.10536 15.4804 2 15.7348 2 16V19C2 19.7956 2.31607 20.5587 2.87868 21.1213C3.44129 21.6839 4.20435 22 5 22H8C8.26522 22 8.51957 21.8946 8.70711 21.7071C8.89464 21.5196 9 21.2652 9 21C9 20.7348 8.89464 20.4804 8.70711 20.2929C8.51957 20.1054 8.26522 20 8 20ZM3 9C3.26522 9 3.51957 8.89464 3.70711 8.70711C3.89464 8.51957 4 8.26522 4 8V5C4 4.73478 4.10536 4.48043 4.29289 4.29289C4.48043 4.10536 4.73478 4 5 4H8C8.26522 4 8.51957 3.89464 8.70711 3.70711C8.89464 3.51957 9 3.26522 9 3C9 2.73478 8.89464 2.48043 8.70711 2.29289C8.51957 2.10536 8.26522 2 8 2H5C4.20435 2 3.44129 2.31607 2.87868 2.87868C2.31607 3.44129 2 4.20435 2 5V8C2 8.26522 2.10536 8.51957 2.29289 8.70711C2.48043 8.89464 2.73478 9 3 9ZM19 2H16C15.7348 2 15.4804 2.10536 15.2929 2.29289C15.1054 2.48043 15 2.73478 15 3C15 3.26522 15.1054 3.51957 15.2929 3.70711C15.4804 3.89464 15.7348 4 16 4H19C19.2652 4 19.5196 4.10536 19.7071 4.29289C19.8946 4.48043 20 4.73478 20 5V8C20 8.26522 20.1054 8.51957 20.2929 8.70711C20.4804 8.89464 20.7348 9 21 9C21.2652 9 21.5196 8.89464 21.7071 8.70711C21.8946 8.51957 22 8.26522 22 8V5C22 4.20435 21.6839 3.44129 21.1213 2.87868C20.5587 2.31607 19.7956 2 19 2ZM16 12C16 11.7348 15.8946 11.4804 15.7071 11.2929C15.5196 11.1054 15.2652 11 15 11H13V9C13 8.73478 12.8946 8.48043 12.7071 8.29289C12.5196 8.10536 12.2652 8 12 8C11.7348 8 11.4804 8.10536 11.2929 8.29289C11.1054 8.48043 11 8.73478 11 9V11H9C8.73478 11 8.48043 11.1054 8.29289 11.2929C8.10536 11.4804 8 11.7348 8 12C8 12.2652 8.10536 12.5196 8.29289 12.7071C8.48043 12.8946 8.73478 13 9 13H11V15C11 15.2652 11.1054 15.5196 11.2929 15.7071C11.4804 15.8946 11.7348 16 12 16C12.2652 16 12.5196 15.8946 12.7071 15.7071C12.8946 15.5196 13 15.2652 13 15V13H15C15.2652 13 15.5196 12.8946 15.7071 12.7071C15.8946 12.5196 16 12.2652 16 12ZM21 15C20.7348 15 20.4804 15.1054 20.2929 15.2929C20.1054 15.4804 20 15.7348 20 16V19C20 19.2652 19.8946 19.5196 19.7071 19.7071C19.5196 19.8946 19.2652 20 19 20H16C15.7348 20 15.4804 20.1054 15.2929 20.2929C15.1054 20.4804 15 20.7348 15 21C15 21.2652 15.1054 21.5196 15.2929 21.7071C15.4804 21.8946 15.7348 22 16 22H19C19.7956 22 20.5587 21.6839 21.1213 21.1213C21.6839 20.5587 22 19.7956 22 19V16C22 15.7348 21.8946 15.4804 21.7071 15.2929C21.5196 15.1054 21.2652 15 21 15Z" fill="#122C1F"/>
		</svg>
		<span class="body-s text-center">Añade tus parcelas 
			<a href="explotacion/edit" class="link-l">aquí</a>, y mantente al día del tiempo en ellas</span> 
	</div>

	<a href="explotacion/edit" class="av-te__btn av-te__btn--primary">
		Añadir parcela
	</a>

</div>

