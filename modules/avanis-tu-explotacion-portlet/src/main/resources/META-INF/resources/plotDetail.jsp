<%@ include file="./init.jsp" %>
<%@ page import="java.util.List" %>
<%@ page import="avanis.tu.explotacion.sb.model.Explotacion" %>
<%@ page import="com.liferay.asset.kernel.model.AssetEntry" %>
<%@ page import="com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil" %>
<%@ page import="com.liferay.asset.kernel.model.AssetCategory" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<jsp:directive.page contentType="text/html" pageEncoding="UTF-8" />

<portlet:defineObjects />

<portlet:actionURL var="deleteURL" name="delete"/>
<portlet:actionURL var="setIsMainURL" name="setIsMain"/>
<portlet:actionURL var="setFocusURL" name="setFocus"/>

<c:set var="plotName" value="${focusedPlot.name}"/>
<c:set var="plotProvince" value="${focusedPlot.provincia}"/>
<c:set var="plotLocation" value="${focusedPlot.location}"/>
<c:set var="focusedPlotId" value="${focusedPlot.explotacionId}"/>
<c:set var="currentFocusedForecast" value="${hourlyForecasts.meteoredForecasts.get(hour)}"/>
<c:set var="meteoredWarnings" value="${requestScope.plots}" />
<c:set var="actualUserId" value="${requestScope.actualUserId}" />

<portlet:resourceURL var="getAlert" id="resource_cmd_command_alert" />

<c:if test="${focusedPlotId != null}">
	<%
		long focusedId = (Long) pageContext.getAttribute("focusedPlotId");
		AssetEntry focusedAssetEntry = AssetEntryLocalServiceUtil.fetchEntry(Explotacion.class.getName(), focusedId);
		if (focusedAssetEntry != null) {
			List<AssetCategory> categories = focusedAssetEntry.getCategories();
			pageContext.setAttribute("focusedCategories", categories);
		} else {
			pageContext.setAttribute("focusedCategories", null);
		}
	%>

	<c:if test="${not empty dailyForecasts.meteoredForecasts}">
		<c:set var="firstForecast" value="${dailyForecasts.meteoredForecasts[0]}" />
		<!-- Extraer la hora de salida y la de puesta del sol y guardarlas como atributos data en el div -->
		<c:set var="sunInToday" value="${fn:substring(firstForecast.sunIn, 11, 13)}" />
		<c:set var="sunOutToday" value="${fn:substring(firstForecast.sunOut, 11, 13)}" />
		
		<fmt:formatDate value="${currentFocusedForecast.end}" pattern="dd" var="nowToday" />

		<div class="js-av-te__sun-hours av-theme__hidden" 
			data-today="${nowToday}" 
			data-sun-in="${sunInToday}" 
			data-sun-out="${sunOutToday}">
		</div>
	</c:if>

	<div id="loadingSpinner" class="loading-spinner loading-spinner-eliminar " style="display: none;">
		<div class="spinner"></div>
		<p>Eliminando</p>
	</div>

	<div class="av-te-plotDetail av-te-column-show av-te-pd">

		<a href="javascript:void(0);" class="av-te-pd__link-to-plots link-l">
			<span>Selecciona otra parcela</span>
			<svg width="16" height="14" viewBox="0 0 16 14" fill="none" xmlns="http://www.w3.org/2000/svg">
				<path fill-rule="evenodd" clip-rule="evenodd" d="M8.29289 0.292893C8.68342 -0.0976311 9.31658 -0.0976311 9.70711 0.292893L15.7071 6.29289C15.8946 6.48043 16 6.73478 16 7C16 7.26522 15.8946 7.51957 15.7071 7.70711L9.70711 13.7071C9.31658 14.0976 8.68342 14.0976 8.29289 13.7071C7.90237 13.3166 7.90237 12.6834 8.29289 12.2929L12.5858 8H1C0.447715 8 0 7.55228 0 7C0 6.44772 0.447715 6 1 6H12.5858L8.29289 1.70711C7.90237 1.31658 7.90237 0.683418 8.29289 0.292893Z" fill="#107E3E"/>
			</svg>
		</a>

		<div class="av-te-pd__container">
			<div class="av-te-pd__top">
				<div class="av-te-pd__top-row-001">
					<h2 class="h2-inverse">El tiempo en ${plotName}</h2>
					<div class="av-te-pd__icons-action">
						<div class="av-te-pd__icon av-te-pd__icon--edit">
							<a href="explotacion/edit?id=${focusedPlotId}" class="link-l-inverse">
								<svg width="20" height="20" viewBox="0 0 20 20" fill="none" xmlns="http://www.w3.org/2000/svg">
									<path fill-rule="evenodd" clip-rule="evenodd" d="M17.5321 2.29613C17.1415 1.9056 16.5084 1.9056 16.1179 2.29613L14.914 3.5L16.3282 4.91422L17.5321 3.71034C17.9226 3.31982 17.9226 2.68665 17.5321 2.29613ZM18.9463 5.12455C20.1179 3.95298 20.1179 2.05349 18.9463 0.881914C17.7747 -0.28966 15.8752 -0.289656 14.7036 0.881915L12.7929 2.79267L3.05565 12.5299C3.031 12.5546 3.00664 12.5789 2.98256 12.603C2.21258 13.3728 1.72847 13.8568 1.34944 14.42C1.01365 14.919 0.743574 15.4591 0.545872 16.0271C0.322711 16.6683 0.225977 17.346 0.0721227 18.4239C0.0673108 18.4576 0.062443 18.4917 0.0575137 18.5262L0.0100623 18.8583C-0.0358771 19.1799 0.0772434 19.5038 0.313413 19.7268C0.549583 19.9498 0.879371 20.0443 1.19779 19.98L1.77732 19.8631C2.7459 19.6678 3.35499 19.5449 3.93025 19.3185C4.44003 19.1178 4.92448 18.858 5.37367 18.5444C5.88056 18.1905 6.31984 17.7511 7.01843 17.0524C7.04022 17.0306 7.06226 17.0086 7.08456 16.9863L18.9463 5.12455ZM14.914 6.32843L13.4998 4.91422L4.46986 13.9441C3.60344 14.8105 3.26653 15.1535 3.0087 15.5366C2.76886 15.893 2.57594 16.2789 2.43473 16.6846C2.33882 16.9601 2.27468 17.2513 2.19675 17.7342C2.66592 17.6327 2.93953 17.5591 3.19773 17.4575C3.56185 17.3142 3.90789 17.1286 4.22875 16.9046C4.5736 16.6638 4.88444 16.358 5.67034 15.5721L14.914 6.32843Z" fill="#C6E75A"/>
								</svg>
								<span class="av-te-pd__icon-span">Editar</span>
							</a>
						</div>
						<div class="av-te-pd__icon av-te-pd__icon--open-dltplotmodal">
							<svg width="18" height="20" viewBox="0 0 18 20" fill="none" xmlns="http://www.w3.org/2000/svg">
								<path fill-rule="evenodd" clip-rule="evenodd" d="M8.16137 0.000140158C8.20931 0.000211803 8.25766 0.000284044 8.30643 0.000284044H9.69357C9.74234 0.000284044 9.79069 0.000211803 9.83864 0.000140158C10.5221 -0.000880393 11.122 -0.00177613 11.6565 0.208447C12.1239 0.392267 12.5376 0.690485 12.8598 1.07576C13.2283 1.51636 13.4171 2.08573 13.6323 2.73445C13.6474 2.77996 13.6626 2.82586 13.678 2.87213L13.7208 3.00028H17C17.5523 3.00028 18 3.448 18 4.00028C18 4.55257 17.5523 5.00028 17 5.00028H16V14.2416C16 15.0465 16 15.7109 15.9558 16.2521C15.9099 16.8142 15.8113 17.3309 15.564 17.8162C15.1805 18.5689 14.5686 19.1808 13.816 19.5643C13.3306 19.8116 12.8139 19.9102 12.2518 19.9561C11.7106 20.0003 11.0463 20.0003 10.2413 20.0003H7.75868C6.95372 20.0003 6.28936 20.0003 5.74817 19.9561C5.18608 19.9102 4.66937 19.8116 4.18404 19.5643C3.43139 19.1808 2.81947 18.5689 2.43597 17.8162C2.18868 17.3309 2.09012 16.8142 2.04419 16.2521C1.99998 15.7109 1.99999 15.0466 2 14.2416L2 5.00028H1C0.447715 5.00028 0 4.55257 0 4.00028C0 3.448 0.447715 3.00028 1 3.00028H4.27924L4.32196 2.87213C4.33738 2.82586 4.3526 2.77997 4.3677 2.73446C4.58286 2.08574 4.77171 1.51636 5.14017 1.07576C5.46236 0.690485 5.87612 0.392267 6.3435 0.208447C6.87802 -0.00177613 7.47789 -0.000880393 8.16137 0.000140158ZM4.97694 5.00028C4.99245 5.00065 5.00792 5.00065 5.02334 5.00028H12.9767C12.9921 5.00065 13.0076 5.00065 13.0231 5.00028H14V14.2003C14 15.0569 13.9992 15.6392 13.9624 16.0892C13.9266 16.5277 13.8617 16.7519 13.782 16.9083C13.5903 17.2846 13.2843 17.5906 12.908 17.7823C12.7516 17.862 12.5274 17.9269 12.089 17.9627C11.6389 17.9995 11.0566 18.0003 10.2 18.0003H7.8C6.94342 18.0003 6.36113 17.9995 5.91104 17.9627C5.47262 17.9269 5.24842 17.862 5.09202 17.7823C4.71569 17.5906 4.40973 17.2846 4.21799 16.9083C4.1383 16.7519 4.07337 16.5277 4.03755 16.0892C4.00078 15.6392 4 15.0569 4 14.2003V5.00028H4.97694ZM11.6094 3.00028H6.39062C6.54424 2.56109 6.60391 2.44307 6.6744 2.35877C6.7818 2.23035 6.91972 2.13095 7.07551 2.06967C7.20921 2.01709 7.39173 2.00028 8.30643 2.00028H9.69357C10.6083 2.00028 10.7908 2.01709 10.9245 2.06967C11.0803 2.13095 11.2182 2.23035 11.3256 2.35877C11.3961 2.44307 11.4558 2.56109 11.6094 3.00028ZM7 7.00028C7.55228 7.00028 8 7.448 8 8.00028V15.0003C8 15.5526 7.55228 16.0003 7 16.0003C6.44772 16.0003 6 15.5526 6 15.0003V8.00028C6 7.448 6.44772 7.00028 7 7.00028ZM11 7.00028C11.5523 7.00028 12 7.448 12 8.00028V15.0003C12 15.5526 11.5523 16.0003 11 16.0003C10.4477 16.0003 10 15.5526 10 15.0003V8.00028C10 7.448 10.4477 7.00028 11 7.00028Z" fill="#C6E75A"/>
							</svg>								
							<span class="av-te-pd__icon-span-delete">Eliminar</span>
							<!-- <aui:form action="${deleteURL}" method="post">
								<aui:input type="hidden" name="plotId" value="${focusedPlotId}"/>
								<aui:button type="submit" value="Eliminar" class="link-l-inverse"/>
							</aui:form> -->
						</div>
					</div>
				</div>
				<div class="av-te-pd__top-row-002">
					<div class="av-te-pd__plot-location">
						${plotLocation}, ${plotProvince}
					</div>
				</div>
				<div class="av-te-pd__top-row-003">
					<ul class="av-te-pd__plot-uses">
						<li class="av-te-pd__plot-uses-category body-m-inverse">
							<c:choose>
								<c:when test="${fn:length(focusedCategories) > 1}">
									Usos:
								</c:when>
								<c:otherwise>
									Uso:
								</c:otherwise>
							</c:choose>
						</li>
						<c:forEach var="focusCategory" items="${focusedCategories}" varStatus="status">
							<li class="av-te-pd__plot-uses-category body-m-inverse">
									${focusCategory.name}
								<c:if test="${!status.last}">, </c:if>
							</li>
						</c:forEach>
					</ul>
				</div>
				<!-- Compartir -->
				<!-- <a href="#" class="av-te-pd__top-row-004">
					<svg width="14" height="16" viewBox="0 0 14 16" fill="none" xmlns="http://www.w3.org/2000/svg">
						<path fill-rule="evenodd" clip-rule="evenodd" d="M11.0002 1.99984C10.2638 1.99984 9.66683 2.59679 9.66683 3.33317C9.66683 3.56471 9.72585 3.78246 9.82966 3.97221C9.83645 3.9825 9.843 3.99304 9.84929 4.00382C9.85553 4.01452 9.86145 4.02532 9.86703 4.03622C10.1023 4.4146 10.5218 4.6665 11.0002 4.6665C11.7365 4.6665 12.3335 4.06955 12.3335 3.33317C12.3335 2.59679 11.7365 1.99984 11.0002 1.99984ZM9.10554 5.20974C9.5888 5.69763 10.2592 5.99984 11.0002 5.99984C12.4729 5.99984 13.6668 4.80593 13.6668 3.33317C13.6668 1.86041 12.4729 0.666504 11.0002 0.666504C9.5274 0.666504 8.3335 1.86041 8.3335 3.33317C8.3335 3.58452 8.36827 3.82774 8.43327 4.05829L4.89479 6.12327C4.41152 5.63538 3.74113 5.33317 3.00016 5.33317C1.5274 5.33317 0.333496 6.52708 0.333496 7.99984C0.333496 9.4726 1.5274 10.6665 3.00016 10.6665C3.74127 10.6665 4.41177 10.3642 4.89506 9.87613L8.43411 11.9384C8.36857 12.1698 8.3335 12.4141 8.3335 12.6665C8.3335 14.1393 9.5274 15.3332 11.0002 15.3332C12.4729 15.3332 13.6668 14.1393 13.6668 12.6665C13.6668 11.1937 12.4729 9.99984 11.0002 9.99984C10.2603 9.99984 9.59081 10.3011 9.10771 10.7877L5.56716 8.72459C5.63209 8.49414 5.66683 8.25105 5.66683 7.99984C5.66683 7.74849 5.63206 7.50527 5.56706 7.27472L9.10554 5.20974ZM4.1333 7.29679C4.13888 7.30768 4.14479 7.31849 4.15104 7.32919C4.15733 7.33997 4.16388 7.35051 4.17067 7.3608C4.27448 7.55055 4.3335 7.7683 4.3335 7.99984C4.3335 8.23137 4.27448 8.44912 4.17067 8.63887C4.1638 8.64928 4.15718 8.65994 4.15082 8.67085C4.14466 8.68143 4.13882 8.69211 4.1333 8.70288C3.89803 9.08127 3.47851 9.33317 3.00016 9.33317C2.26378 9.33317 1.66683 8.73622 1.66683 7.99984C1.66683 7.26346 2.26378 6.6665 3.00016 6.6665C3.47851 6.6665 3.89803 6.9184 4.1333 7.29679ZM9.81034 12.0641C9.8268 12.0425 9.84212 12.0196 9.85617 11.9955C9.86963 11.9724 9.88155 11.9488 9.89196 11.9249C10.1312 11.568 10.5383 11.3332 11.0002 11.3332C11.7365 11.3332 12.3335 11.9301 12.3335 12.6665C12.3335 13.4029 11.7365 13.9998 11.0002 13.9998C10.2638 13.9998 9.66683 13.4029 9.66683 12.6665C9.66683 12.4497 9.71856 12.2451 9.81034 12.0641Z" fill="#C6E75A"/>
					</svg>
					<span class="link-s-inverse">Compartir</span>
					</a> -->
				<div class="av-te-pd__top-row-005">
					<h5 class="h5-inverse">
						${currentFocusedForecast.getWeatherDescription()}
					</h5>
				</div>
				<div class="av-te-pd__top-row-006">
					<div class="av-te-pd__focused-temperatute">
						<div class="av-te-pd__symbol av-te-pd__symbol--big symbol-icon symbol-icon--${currentFocusedForecast.symbol}"></div>
						<span class="weather-temperature-big-inverse">
							${Math.round(currentFocusedForecast.temperature)}º
							</span>
					</div>
					<div class="av-te-pd__focused-information">
						<div>
							<svg width="20" height="18" viewBox="0 0 20 18" fill="none" xmlns="http://www.w3.org/2000/svg">
								<path d="M19.469 1.79389L4.76559 0.326906C4.68334 0.318882 4.60031 0.328073 4.52183 0.353889C4.44335 0.379705 4.37115 0.421577 4.30985 0.476821C4.24855 0.532065 4.19951 0.599463 4.16587 0.674695C4.13223 0.749928 4.11473 0.831334 4.11449 0.913699V1.78489C4.11452 1.82952 4.10001 1.87295 4.07313 1.90866C4.04627 1.94437 4.00849 1.97041 3.96549 1.98289L2.62718 2.37528C2.59625 2.38436 2.56362 2.38614 2.53188 2.38048C2.50014 2.37482 2.47016 2.36187 2.44431 2.34266C2.41846 2.32345 2.39745 2.2985 2.38296 2.2698C2.36846 2.24109 2.36086 2.20942 2.36078 2.17728V0.614903C2.36078 0.307106 2.13501 0.0326097 1.82617 0.00291001C1.74386 -0.00527124 1.66074 0.00384473 1.58218 0.0296696C1.50363 0.0554944 1.43138 0.0974537 1.37011 0.152837C1.30883 0.208221 1.2599 0.275797 1.22646 0.351202C1.19302 0.426606 1.17582 0.508163 1.17598 0.590603V16.6131C1.17598 16.6679 1.15422 16.7204 1.11546 16.7592C1.07671 16.798 1.02411 16.8199 0.969181 16.8201H0.616992C0.307247 16.8201 0.0327203 17.0451 0.00291977 17.352C-0.00528158 17.434 0.0038412 17.5167 0.0297001 17.595C0.0555589 17.6732 0.0975799 17.7451 0.153054 17.8062C0.208528 17.8672 0.276224 17.916 0.351777 17.9494C0.427329 17.9828 0.509062 18 0.591707 18H2.91886C3.2286 18 3.50403 17.775 3.53293 17.4672C3.54113 17.3852 3.53201 17.3025 3.50615 17.2243C3.48029 17.146 3.43827 17.0741 3.3828 17.013C3.32732 16.952 3.25963 16.9032 3.18408 16.8698C3.10852 16.8364 3.02679 16.8192 2.94414 16.8192H2.56667C2.51174 16.8192 2.45905 16.7975 2.42012 16.7589C2.3812 16.7203 2.35921 16.6679 2.35897 16.6131V7.22892C2.35902 7.19669 2.36662 7.16491 2.38117 7.13611C2.39572 7.10732 2.41681 7.08231 2.44277 7.06308C2.46873 7.04385 2.49884 7.03093 2.5307 7.02535C2.56256 7.01977 2.59529 7.02168 2.62627 7.03093L3.96459 7.42332C4.05309 7.45032 4.11269 7.53042 4.11269 7.62132V8.50241C4.11317 8.65861 4.17564 8.80827 4.28646 8.91872C4.39728 9.02917 4.54746 9.09143 4.70418 9.0919C4.72405 9.0919 4.74482 9.0919 4.76379 9.0892L19.4672 7.62222C19.6131 7.60751 19.7484 7.53936 19.8469 7.43096C19.9453 7.32256 19.9998 7.18162 20 7.03543V2.37888C19.9998 2.23269 19.9453 2.09175 19.8469 1.98335C19.7484 1.87495 19.6131 1.8068 19.4672 1.79209L19.469 1.79389ZM12.9002 2.32488L15.3321 2.56698V6.85003L12.9002 7.09213V2.32488ZM11.8048 7.20283L9.37204 7.44402V1.97209L11.8048 2.21418V7.20192V7.20283ZM2.36078 5.72324V3.68387L4.11359 3.17087V6.23804L2.36168 5.72504L2.36078 5.72324ZM5.29839 1.56709L8.27664 1.86409V7.55202L5.29839 7.84902V1.56709ZM18.817 6.50263L16.4275 6.73933V2.67588L18.817 2.91348V6.50263Z" fill="white"/>
							</svg>
							<span class="body-s-inverse">Viento </span>
							<span class="body-s-strong-inverse">${currentFocusedForecast.windSpeed} m / s</span>
						</div>
						<div>
							<svg width="13" height="20" viewBox="0 0 13 20" fill="none" xmlns="http://www.w3.org/2000/svg">
								<path d="M5.40432 5.46854C5.43874 6.25297 5.42411 7.13341 5.26665 7.7587C5.26493 7.77254 5.26063 7.78724 5.25804 7.80195C5.2377 7.89591 5.20621 7.98709 5.16426 8.07351L5.15737 8.08821C5.06393 8.2807 4.91909 8.44328 4.73904 8.55782C4.55899 8.67237 4.35081 8.73435 4.13775 8.73686C3.90089 8.73629 3.67103 8.65613 3.48471 8.50913C3.2984 8.36214 3.16633 8.15674 3.10952 7.92562C3.0341 7.62964 3.07801 7.31571 3.2317 7.05211C3.23686 7.04346 3.24719 7.02443 3.27042 6.99157L3.28075 6.97773C3.33496 6.8973 3.39691 6.82551 3.4666 6.76324C3.47865 6.75286 3.48811 6.74249 3.49844 6.73211C3.95878 6.28238 4.70994 5.83005 5.40432 5.46854ZM6.41104 3.71546C6.41104 3.71546 3.89941 4.71351 2.68962 5.89492C2.55195 6.01859 2.42805 6.1613 2.31963 6.32216C2.28521 6.37146 2.25252 6.41989 2.22498 6.46919C1.58998 7.57449 1.94964 8.97989 3.02778 9.60519C3.37626 9.80757 3.75915 9.90443 4.13775 9.90443C4.57242 9.9026 4.99772 9.77733 5.36461 9.54305C5.73151 9.30878 6.02506 8.97504 6.21141 8.58032C6.29402 8.40649 6.35511 8.22659 6.39469 8.04411C6.80684 6.40086 6.4119 3.71546 6.4119 3.71546H6.41104ZM11.8215 9.3613C11.8559 10.1466 11.8413 11.027 11.6847 11.6515C11.6821 11.6662 11.6778 11.6809 11.6744 11.6947C11.6544 11.789 11.6232 11.8804 11.5814 11.9671L11.5746 11.981C11.4811 12.1735 11.3363 12.336 11.1562 12.4506C10.9762 12.5651 10.768 12.6271 10.5549 12.6296C10.3181 12.629 10.0882 12.5489 9.90189 12.4019C9.71558 12.2549 9.58351 12.0495 9.5267 11.8184C9.45128 11.5224 9.49519 11.2085 9.64888 10.9449C9.6549 10.9362 9.66437 10.9172 9.68846 10.8843L9.69793 10.8688C9.75214 10.7883 9.81409 10.7174 9.88378 10.6543L9.91648 10.624C10.3768 10.1743 11.1271 9.72194 11.8215 9.35957M12.8282 7.60649C12.8282 7.60649 10.3166 8.6054 9.1068 9.78594C8.96663 9.91301 8.84238 10.0568 8.73681 10.2141C8.70274 10.2614 8.67115 10.3104 8.64216 10.3611C8.00802 11.4664 8.36682 12.8718 9.44582 13.4962C9.7943 13.6995 10.1763 13.7955 10.5558 13.7955C10.9903 13.7936 11.4155 13.6684 11.7824 13.4343C12.1493 13.2002 12.4429 12.8667 12.6295 12.4722C12.7112 12.2984 12.7723 12.1185 12.8119 11.936C13.2249 10.2928 12.8282 7.60649 12.8282 7.60649ZM11.72 1.75135C11.7544 2.53665 11.7398 3.41535 11.5832 4.04238C11.5629 4.15204 11.5282 4.25849 11.4799 4.35892L11.4756 4.3693C11.3823 4.56308 11.237 4.72681 11.0561 4.84203C10.8752 4.95725 10.6658 5.01938 10.4517 5.02141C10.2148 5.02083 9.98496 4.94067 9.79864 4.79367C9.61233 4.64668 9.48026 4.44128 9.42345 4.21016C9.3835 4.05194 9.37726 3.88701 9.40514 3.7262C9.43302 3.56538 9.49438 3.4123 9.58521 3.27697C9.58779 3.27265 9.59209 3.26832 9.59467 3.26227C9.6506 3.18184 9.71255 3.10919 9.78053 3.04778L9.81495 3.01751C10.2744 2.56778 11.0256 2.11546 11.72 1.75308M12.7267 0C12.7267 0 10.2142 0.998919 9.00441 2.17946C8.82076 2.34509 8.66398 2.53856 8.53977 2.75286C7.90563 3.85816 8.26443 5.26357 9.34342 5.88973C9.69104 6.09297 10.0731 6.18897 10.4525 6.18897C10.8871 6.18712 11.3123 6.06193 11.6792 5.82783C12.046 5.59372 12.3396 5.26022 12.5262 4.86573C12.6088 4.69189 12.6699 4.512 12.7095 4.32951C13.1216 2.68627 12.7267 0.0017296 12.7267 0.0017296L12.725 0H12.7267ZM5.63062 12.6184C5.73043 13.8984 5.78464 15.7077 5.46541 16.979C5.42712 17.1756 5.36348 17.3663 5.27611 17.5464L5.27181 17.5576C5.24977 17.6055 5.22595 17.6525 5.2004 17.6986C5.00613 18.0403 4.72604 18.3248 4.38812 18.5236C4.05019 18.7224 3.66627 18.8286 3.27472 18.8316C2.80527 18.8315 2.34935 18.6735 1.97961 18.3828C1.60987 18.092 1.34761 17.6852 1.23461 17.2272C1.15626 16.918 1.14412 16.5956 1.199 16.2813C1.25389 15.967 1.37454 15.668 1.55298 15.4041L1.56244 15.3894C1.6657 15.2371 1.78674 15.0977 1.92297 14.9743L1.95653 14.9431C2.89269 14.029 4.47762 13.1736 5.63062 12.6184ZM6.61668 10.9008C6.61668 10.9008 2.92624 12.3684 1.14513 14.1059C0.939243 14.2926 0.756383 14.5034 0.600469 14.7338C0.549703 14.8048 0.503239 14.8783 0.461077 14.9509C-0.472503 16.5769 0.0566696 18.6413 1.6416 19.5606C2.13738 19.8491 2.70019 20.0006 3.273 20C4.4346 20 5.57297 19.3825 6.20453 18.2832C6.24755 18.2123 6.28455 18.1328 6.32241 18.0541C6.44459 17.7972 6.53408 17.5351 6.59087 17.2662C7.19834 14.8489 6.61582 10.9034 6.61582 10.9034V10.9016L6.61668 10.9008Z" fill="white"/>
							</svg>
							<span class="body-s-inverse">Lluvia </span>
							<span class="body-s-strong-inverse">
								${Math.round(currentFocusedForecast.rainProbability)} mm
								</span>
						</div>
						<div>
							<svg width="16" height="14" viewBox="0 0 16 14" fill="none" xmlns="http://www.w3.org/2000/svg">
								<path d="M5.28349 8.25428H0.676319C0.587421 8.25428 0.499395 8.27158 0.417277 8.30518C0.335158 8.33878 0.260558 8.38803 0.197743 8.45011C0.134929 8.51218 0.0851323 8.58587 0.0512017 8.66695C0.017271 8.74804 -0.000127759 8.83493 7.06229e-07 8.92266V8.95545C7.06229e-07 9.32387 0.302976 9.62286 0.676319 9.62286H5.28349C5.65683 9.62286 5.95981 9.32387 5.95981 8.95545V8.92266C5.95981 8.74565 5.88855 8.57589 5.76172 8.45073C5.63488 8.32557 5.46286 8.25428 5.28349 8.25428ZM15.3237 8.25428H8.67583C8.58693 8.25428 8.49891 8.27158 8.41679 8.30518C8.33467 8.33878 8.26007 8.38803 8.19726 8.45011C8.13444 8.51218 8.08464 8.58587 8.05071 8.66695C8.01678 8.74804 7.99938 8.83493 7.99951 8.92266V8.95545C7.99951 9.32387 8.30249 9.62286 8.67583 9.62286H15.3237C15.697 9.62286 16 9.32387 16 8.95545V8.92266C16 8.74565 15.9287 8.57589 15.8019 8.45073C15.6751 8.32557 15.5031 8.25428 15.3237 8.25428ZM3.24085 0.5H0.676319C0.496948 0.5 0.324924 0.570316 0.19809 0.69548C0.0712558 0.820643 7.06229e-07 0.990401 7.06229e-07 1.16741V1.2002C7.06229e-07 1.56863 0.302976 1.86761 0.676319 1.86761H3.24085C3.6142 1.86761 3.91717 1.56863 3.91717 1.2002V1.16741C3.91717 0.990401 3.84592 0.820643 3.71908 0.69548C3.59225 0.570316 3.42022 0.5 3.24085 0.5ZM15.3237 0.5H6.63515C6.45595 0.500256 6.28417 0.570684 6.15755 0.69582C6.03093 0.820956 5.95981 0.990568 5.95981 1.16741V1.2002C5.95981 1.56863 6.26278 1.86761 6.63613 1.86761H15.3247C15.697 1.86761 16 1.56863 16 1.2002V1.16741C16 0.990401 15.9287 0.820643 15.8019 0.69548C15.6751 0.570316 15.5031 0.5 15.3237 0.5ZM11.2413 4.44465H0.676319C0.496948 4.44465 0.324924 4.51497 0.19809 4.64013C0.0712558 4.7653 7.06229e-07 4.93506 7.06229e-07 5.11206V5.14389C7.06229e-07 5.51328 0.302976 5.8113 0.676319 5.8113H11.2413C11.6147 5.8113 11.9177 5.51232 11.9177 5.14389V5.11206C11.9177 4.93506 11.8464 4.7653 11.7196 4.64013C11.5927 4.51497 11.4207 4.44465 11.2413 4.44465ZM15.3237 4.44465H14.6356C14.4563 4.44465 14.2842 4.51497 14.1574 4.64013C14.0306 4.7653 13.9593 4.93506 13.9593 5.11206V5.14389C13.9593 5.51328 14.2623 5.8113 14.6356 5.8113H15.3237C15.697 5.8113 16 5.51232 16 5.14389V5.11206C16 4.93506 15.9287 4.7653 15.8019 4.64013C15.6751 4.51497 15.5031 4.44465 15.3237 4.44465ZM12.594 13.5H15.3237C15.697 13.5 16 13.201 16 12.8326V12.7998C16 12.6228 15.9287 12.453 15.8019 12.3279C15.6751 12.2027 15.5031 12.1324 15.3237 12.1324H12.594C12.4146 12.1324 12.2426 12.2027 12.1157 12.3279C11.9889 12.453 11.9177 12.6228 11.9177 12.7998V12.8326C11.9177 13.201 12.2206 13.5 12.594 13.5ZM0.676319 13.5H9.36485C9.73722 13.5 10.0402 13.201 10.0402 12.8326V12.7998C10.0402 12.6228 9.96894 12.453 9.8421 12.3279C9.71527 12.2027 9.54325 12.1324 9.36388 12.1324H0.675341C0.49614 12.1326 0.324367 12.2031 0.197744 12.3282C0.0711213 12.4533 5.19118e-07 12.623 7.06229e-07 12.7998V12.8326C7.06229e-07 13.201 0.302976 13.5 0.676319 13.5Z" fill="white"/>
							</svg>
							<span class="body-s-inverse">Humedad </span>
							<span class="body-s-strong-inverse">
								${currentFocusedForecast.humidity} %</span>
						</div>
					</div>
				</div>
				<div class="av-te-pd__top-row-007">
					<h5 class="h5-inverse">

						<fmt:formatDate value="${currentFocusedForecast.end}" pattern="d" var="dayOfMonth" />
						<fmt:formatDate value="${currentFocusedForecast.end}" pattern="MMMM" var="month" />
						<fmt:formatDate value="${currentFocusedForecast.end}" pattern="EEEE" var="dayOfWeek" />

							${dayOfMonth} de ${month}, ${dayOfWeek}
					</h5>
				</div>
				<div class="av-te-pd__top-row-008">
					<div class="av-te-pd__weather-by-hours js-av-te-pd__weather-by-hours">
						<c:forEach var="hourlyForecast" items="${hourlyForecasts.meteoredForecasts}" varStatus="statusHour">
							<c:set var="realNowHour" value="${hourlyForecast.end}"/>
							<% Date realHour = (Date)pageContext.getAttribute("realNowHour");
							Calendar calendario = Calendar.getInstance();
			
							calendario.setTime(realHour);
							calendario.add(Calendar.HOUR_OF_DAY, -1);
							Date realHourModified = calendario.getTime();
							%>

							<fmt:formatDate value="<%=realHourModified%>" pattern="HH:mm" var="labelHour24" />
							<fmt:formatDate value="<%=realHourModified%>" pattern="HH" var="labelHour" />

							<div class="av-te-pd__weather-by-hours-item av-te-pd__weather-by-hours-item--${labelHour}">
								<span class="text-label">
									${labelHour24}
								</span>
								<div class="av-te-pd__symbol av-te-pd__symbol--small symbol-icon symbol-icon--${hourlyForecast.symbol} js-av-te-pd__symbol js-av-te-pd__symbol--${labelHour24}"></div>
								<span class="body-s">
									${Math.round(hourlyForecast.temperature)}º
									</span>
							</div>
						</c:forEach>
					</div>
					<div class="av-te-pd__weather-by-hours-arrows">
						<svg width="32" height="32" viewBox="0 0 32 32" fill="none" xmlns="http://www.w3.org/2000/svg" class="av-te-pd__weather-by-hours-arrows--left">
							<circle cx="16" cy="16" r="15.5" transform="rotate(180 16 16)" fill="#122C1F" stroke="#122C1F"/>
							<rect width="16" height="16" transform="translate(24 24) rotate(180)" fill="#122C1F"/>
							<path fill-rule="evenodd" clip-rule="evenodd" d="M15.8054 20.4714C15.545 20.7318 15.1229 20.7318 14.8626 20.4714L10.8626 16.4714C10.7376 16.3464 10.6673 16.1768 10.6673 16C10.6673 15.8232 10.7376 15.6536 10.8626 15.5286L14.8626 11.5286C15.1229 11.2683 15.545 11.2683 15.8054 11.5286C16.0657 11.789 16.0657 12.2111 15.8054 12.4714L12.9435 15.3334L20.6673 15.3334C21.0355 15.3334 21.334 15.6318 21.334 16C21.334 16.3682 21.0355 16.6667 20.6673 16.6667L12.9435 16.6667L15.8054 19.5286C16.0657 19.789 16.0657 20.2111 15.8054 20.4714Z" fill="white"/>
						</svg>

						<svg width="32" height="32" viewBox="0 0 32 32" fill="none" xmlns="http://www.w3.org/2000/svg"
							class="av-te-pd__weather-by-hours-arrows--right">
							<circle cx="16" cy="16" r="15.5" fill="#122C1F" stroke="#122C1F"/>
							<rect width="16" height="16" transform="translate(8 8)" fill="#122C1F"/>
							<path fill-rule="evenodd" clip-rule="evenodd" d="M16.1946 11.5286C16.455 11.2682 16.8771 11.2682 17.1374 11.5286L21.1374 15.5286C21.2624 15.6536 21.3327 15.8232 21.3327 16C21.3327 16.1768 21.2624 16.3464 21.1374 16.4714L17.1374 20.4714C16.8771 20.7317 16.455 20.7317 16.1946 20.4714C15.9343 20.211 15.9343 19.7889 16.1946 19.5286L19.0565 16.6666H11.3327C10.9645 16.6666 10.666 16.3682 10.666 16C10.666 15.6318 10.9645 15.3333 11.3327 15.3333H19.0565L16.1946 12.4714C15.9343 12.211 15.9343 11.7889 16.1946 11.5286Z" fill="white"/>
						</svg>
					</div>
				</div>
			</div>
			<div class="av-te-pd__bottom">

				<h5 class="h5-inverse">
					Los próximos ${dailyForecasts.meteoredForecasts.size()} días
				</h5>

				<div class="av-te-pd__bottom-content">
					<div class="av-te-pd__bottom-content-items">
						<c:set var="day" value="0"/>
						<c:forEach var="dailyForecast" items="${dailyForecasts.meteoredForecasts}" varStatus="statusWeather">



							<c:set var="day" value="${day + 1}"/>
							<c:if test="${day == 1}" >
								<c:set var="firstDay" value="${dailyForecast.getStartDayOfMonth()}" />
							</c:if>

							<div class="av-te-pd__bottom-content-item">
								<fmt:formatDate value="${currentFocusedForecast.end}" pattern="d" var="dayActual" />
								<fmt:formatDate value="${dailyForecast.start}" pattern="d" var="daylInList" />
								<div class="av-te-pd__bci-top ${daylInList == dayActual ? 'av-te-pd__bci-top--selected' : ''}" data-idday="${statusWeather.index}">
									<span class="text-label text-capitalize av-te-pd__day-of-week-name">
										<fmt:formatDate value="${dailyForecast.start}" pattern="d" var="dayOfWeekNumber"/>
										<fmt:formatDate value="${dailyForecast.start}" pattern="EEEE" var="dayOfWeekText"/>
										${firstDay == dayOfWeekNumber ? 'Hoy' : dayOfWeekText}
									</span>
									<span class="h2">
										<fmt:formatDate value="${dailyForecast.start}" pattern="dd" />
										</span>

									<div class="av-te-pd__symbol av-te-pd__symbol--small symbol-icon symbol-icon--${dailyForecast.symbol} js-av-te-pd__symbol-day">
									</div>

									<span class="body-s-light">
										${Math.round(dailyForecast.minTemperature)}º / ${Math.round(dailyForecast.maxTemperature)}º
									</span>

									<aui:form id="form-${statusWeather.index}" action="${setFocusURL}" method="GET" style="display: none;">
										<input type="hidden" name="plotId" value="${focusedPlotId}"/>
										<input type="hidden" name="dayNumber" value="${day}"/>
										<aui:button type="submit" id="buttonWeather-${statusWeather.index}" data-buttonidday="buttonday-${statusWeather.index}" value="Select" />
									</aui:form>
								</div>
								<div class="av-te-pd__bci-bottom"></div>
							</div>
						</c:forEach>
					</div>
					<div class="av-te-pd__bci-bottom-alert-tags" >

					<c:forEach var="warning" items="${meteoredWanings}">

						<div class="av-te-pd__bci-bottom-alert-tag av-te-pd__bci-bottom-alert-tag--${warning.risk}" style="width: ${92 * ((warning.getEndDayOfMonth() + 1) - warning.getStartDayOfMonth())}px; transform: translate(${92 * (warning.getEndDayOfMonth() - firstDay)}px);" data-warning="phenomenon=${warning.phenomenon};scope=${warning.scope};start=${warning.start.time};end=${warning.end.time};probability=${warning.probability};description=${warning.description};
							risk=${warning.risk};
							symbol=${warning.symbol}">
							<div class="av-te-pd__bci-bottom-alert-tag-text">
								<span class="alert-tag">
									${warning.phenomenon}
								</span>
							</div>
							<div class="av-te-pd__bci-bottom-alert-tag-chebron">
								<svg width="6" height="10" viewBox="0 0 6 10" fill="none" xmlns="http://www.w3.org/2000/svg">
									<path fill-rule="evenodd" clip-rule="evenodd" d="M0.528758 0.528758C0.789108 0.268409 1.21122 0.268409 1.47157 0.528758L5.47157 4.52876C5.73192 4.78911 5.73192 5.21122 5.47157 5.47157L1.47157 9.47157C1.21122 9.73192 0.789108 9.73192 0.528758 9.47157C0.268409 9.21122 0.268409 8.78911 0.528758 8.52876L4.05735 5.00016L0.528758 1.47157C0.268409 1.21122 0.268409 0.789108 0.528758 0.528758Z" fill="#101717"/>
								</svg>
							</div>
						</div>
						</c:forEach>
					</div>
				</div>

				<div class="av-te-pd__bottom-content-alert-message">
					<svg width="15" height="14" viewBox="0 0 15 14" fill="none" xmlns="http://www.w3.org/2000/svg">
						<path fill-rule="evenodd" clip-rule="evenodd" d="M6.67179 0.613075C7.19821 0.373441 7.80259 0.373441 8.32901 0.613075C8.70287 0.783261 8.96525 1.09575 9.18605 1.42247C9.40596 1.74788 9.64672 2.18564 9.93793 2.71515L13.6947 9.5456C13.9676 10.0418 14.1946 10.4544 14.3436 10.796C14.4944 11.1417 14.6115 11.5123 14.5645 11.9046C14.4978 12.4616 14.2001 12.965 13.7442 13.292C13.4231 13.5222 13.042 13.5982 12.6664 13.6326C12.2952 13.6667 11.8244 13.6666 11.258 13.6666H3.74276C3.17641 13.6666 2.70555 13.6667 2.33445 13.6326C1.95884 13.5982 1.57771 13.5222 1.25662 13.292C0.800691 12.965 0.503043 12.4616 0.436299 11.9046C0.389295 11.5123 0.506391 11.1417 0.657223 10.796C0.80625 10.4544 1.03318 10.0418 1.30613 9.54559L5.06286 2.71517C5.35408 2.18565 5.59484 1.74788 5.81475 1.42247C6.03555 1.09575 6.29793 0.783261 6.67179 0.613075ZM7.77661 1.82659C7.60113 1.74671 7.39967 1.74671 7.2242 1.82659C7.19539 1.8397 7.10407 1.8959 6.91947 2.16904C6.73797 2.43762 6.52638 2.82094 6.21529 3.38656L2.49 10.1598C2.19748 10.6917 2.00091 11.0505 1.87931 11.3292C1.75668 11.6102 1.75617 11.7126 1.76016 11.7459C1.78241 11.9316 1.88163 12.0994 2.0336 12.2084C2.06086 12.228 2.15084 12.2769 2.45621 12.3049C2.75903 12.3326 3.16813 12.3333 3.77511 12.3333H11.2257C11.8327 12.3333 12.2418 12.3326 12.5446 12.3049C12.85 12.2769 12.9399 12.228 12.9672 12.2084C13.1192 12.0994 13.2184 11.9316 13.2406 11.7459C13.2446 11.7126 13.2441 11.6102 13.1215 11.3292C12.9999 11.0505 12.8033 10.6917 12.5108 10.1598L8.78552 3.38657C8.47442 2.82094 8.26283 2.43762 8.08133 2.16904C7.89674 1.8959 7.80541 1.8397 7.77661 1.82659ZM7.5004 4.99996C7.86859 4.99996 8.16707 5.29844 8.16707 5.66663V8.3333C8.16707 8.70149 7.86859 8.99997 7.5004 8.99997C7.13221 8.99997 6.83373 8.70149 6.83373 8.3333V5.66663C6.83373 5.29844 7.13221 4.99996 7.5004 4.99996ZM6.83373 10.3333C6.83373 9.96511 7.13221 9.66663 7.5004 9.66663H7.50707C7.87526 9.66663 8.17373 9.96511 8.17373 10.3333C8.17373 10.7015 7.87526 11 7.50707 11H7.5004C7.13221 11 6.83373 10.7015 6.83373 10.3333Z" fill="#101717"/>
					</svg>
					<span class="alert-title">Alertas</span>
				</div>

				<div class="av-te-pd__bci-bottom-alert-tags-empty">
					<svg width="20" height="20" viewBox="0 0 20 20" fill="none" xmlns="http://www.w3.org/2000/svg">
						<path d="M6.4 11.8C6.4 11.8 7.75 13.6 10 13.6C12.25 13.6 13.6 11.8 13.6 11.8M12.7 7.3H12.709M7.3 7.3H7.309M19 10C19 14.9706 14.9706 19 10 19C5.02944 19 1 14.9706 1 10C1 5.02944 5.02944 1 10 1C14.9706 1 19 5.02944 19 10ZM13.15 7.3C13.15 7.54853 12.9485 7.75 12.7 7.75C12.4515 7.75 12.25 7.54853 12.25 7.3C12.25 7.05147 12.4515 6.85 12.7 6.85C12.9485 6.85 13.15 7.05147 13.15 7.3ZM7.75 7.3C7.75 7.54853 7.54853 7.75 7.3 7.75C7.05147 7.75 6.85 7.54853 6.85 7.3C6.85 7.05147 7.05147 6.85 7.3 6.85C7.54853 6.85 7.75 7.05147 7.75 7.3Z" stroke="black" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
					</svg>
					<span class="body-s">
						No hay alertas meteorológicas a la vista
						</span>
				</div>

				<div class="av-te-pd__bottom-content-legend">
					<span class="alert-title bcl-text-risk">Riesgo:</span>
					<div class="av-te-pd__legend-circle av-te-pd__legend-circle--warnig"></div>
					<span class="alert-title">Bajo</span>

					<div class="av-te-pd__legend-circle av-te-pd__legend-circle--severe"></div>
					<span class="alert-title">Importante</span>

					<div class="av-te-pd__legend-circle av-te-pd__legend-circle--error"></div>
					<span class="alert-title">Extraordinario</span>
				</div>

			</div>
		</div>

		<!-- Botón para seleccionar la parcela actual como parcela por defecto para la visualización -->
		<!-- <aui:form action="${setIsMainURL}" method="post">
			<aui:input type="hidden" name="plotId" value="${focusedPlotId}"/>
			<aui:input type="hidden" name="isMain" value="${!focusedPlot.isMain}"/>
			<c:choose>
				<c:when test="${focusedPlot.isMain}">
					<aui:button type="submit" value="No Main Plot"/>
				</c:when>
				<c:otherwise>
					<aui:button type="submit" value="Main Plot"/>
				</c:otherwise>
			</c:choose>
			</aui:form> -->
	</div>
</c:if>

<div class="av-te-pd__plot-list-empty av-te-hidden">
	<div class="av-te-pd__plot-list-empty--content">
		<svg width="20" height="20" viewBox="0 0 20 20" fill="none" xmlns="http://www.w3.org/2000/svg">
			<path d="M6.4 11.8C6.4 11.8 7.75 13.6 10 13.6C12.25 13.6 13.6 11.8 13.6 11.8M12.7 7.3H12.709M7.3 7.3H7.309M19 10C19 14.9706 14.9706 19 10 19C5.02944 19 1 14.9706 1 10C1 5.02944 5.02944 1 10 1C14.9706 1 19 5.02944 19 10ZM13.15 7.3C13.15 7.54853 12.9485 7.75 12.7 7.75C12.4515 7.75 12.25 7.54853 12.25 7.3C12.25 7.05147 12.4515 6.85 12.7 6.85C12.9485 6.85 13.15 7.05147 13.15 7.3ZM7.75 7.3C7.75 7.54853 7.54853 7.75 7.3 7.75C7.05147 7.75 6.85 7.54853 6.85 7.3C6.85 7.05147 7.05147 6.85 7.3 6.85C7.54853 6.85 7.75 7.05147 7.75 7.3Z" stroke="black" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
		</svg>

		<h3 class="h3 text-center">
			¿Quieres añadir una parcela?
		</h3>
		<p class="body-m text-center">
			Introduce la ubicación de las parcelas que conforman tu explotación y recibe las alertas meteorológicas que les afecten.
		</p>
		<a href="explotacion/edit" class="av-te__btn av-te__btn--primary">
			Añadir parcela
		</a>
	</div>
</div>

<!-- #region Delete plot (dltplot) modal -->
<div id="dltplotModal" class="av-te-dltplot-modal">
	<div class="av-te-dltplot-modal__panel">
		<div class="av-te-dltplot-modal__header">
			<div>
				<p class="av-te-dltplot-modal__heading">
					Borrar parcela
				</p>
			</div>
			<span class="av-icon-close av-te-dltplot-modal__close">&times;</span>
		</div>

		<div class="av-te-dltplot-modal__content">
			<p class="av-te-dltplot-modal__title">
				¿Seguro que quieres borrar esta parcela?
			</p>
			<p class="av-te-dltplot-modal__text">
				Al borrarla, ya no podrás ver su información meteorológica ni recibir alertas sobre la misma.
			</p>
		</div>
		<div class="av-te-dltplot-modal__footer">
			<button class="av-te-dltplot-modal__cancel av-te-dltplot-modal__close">
				Cancelar
			</button>
			<div class="av-te-dltplot-modal__delete">
				<aui:form action="${deleteURL}" method="post"  >
					<aui:input type="hidden" name="plotId" value="${focusedPlotId}"/>
					<aui:button type="submit" cssClass="btn-eliminar-parcela" value="Sí, borrar" class="link-l-inverse"/>
				</aui:form>
			</div>
		</div>
	</div>
</div>
<!-- #endregion Delete plot (dltplot) modal -->
<script>
	$(document).ready(function() {
		$('.btn-eliminar-parcela').on('click', function() {
			$('.loading-spinner-eliminar').show();
		});
	});
</script>
<style>
	.av-ma__display-none {
		display: none;
	}
	.hidden {
		display: none;
	}
	.av-ma.av-ma__card-main-container {
		display: flex;
		flex-direction: column-reverse;
	}
	#alertModal {
		display: none;
	}
	#dltplotModal {
		display: none;
	}

	.loading-spinner {
		position: fixed;
		top: 0;
		left: 0;
		width: 100%;
		height: 100%;
		background-color: rgba(255, 255, 255, 0.8);
		display: flex;
		justify-content: center;
		align-items: center;
		z-index: 9999; /* Asegúrate de que esté encima de otros elementos */
		flex-direction: column;
		p{
			color: gray;
		}
	}

	.spinner {
		border: 4px solid rgba(0, 0, 0, 0.1);
		border-left-color: #000;
		border-radius: 50%;
		width: 40px;
		height: 40px;
		animation: spin 1s linear infinite;
	}

</style>
