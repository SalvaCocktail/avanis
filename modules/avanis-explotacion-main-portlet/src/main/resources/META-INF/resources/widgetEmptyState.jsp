<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <%@ page
import="java.util.List" %> <%@ page
import="avanis.tu.explotacion.sb.model.Explotacion" %> <%@ page
import="com.liferay.asset.kernel.model.AssetEntry" %> <%@ page
import="com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil" %> <%@ page
import="com.liferay.asset.kernel.model.AssetCategory" %> <%@ taglib
uri="http://liferay.com/tld/aui" prefix="aui" %> <%@ taglib
uri="http://liferay.com/tld/ui" prefix="liferay-ui" %> <%@ taglib
uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> <%@ include
file="./init.jsp" %>

<jsp:directive.page
  contentType="text/html"
  pageEncoding="UTF-8"
/>

<portlet:actionURL
  var="setFocusURL"
  name="setFocus"
/>

<portlet:actionURL
  var="setIsMainURL"
  name="setIsMain"
/>

<c:set
  var="plotName"
  value="${focusedPlot.name}"
/>
<c:set
  var="currentFocusedForecast"
  value="${hourlyForecasts.meteoredForecasts.get(hour)}"
/>
<c:set
  var="plotProvince"
  value="${focusedPlot.provincia}"
/>
<c:set
  var="plotLocation"
  value="${focusedPlot.location}"
/>
<c:set
  var="dailyForecast"
  value="${dailyForecasts.meteoredForecasts.get(0)}"
/>
<c:set
  var="focusedPlotId"
  value="${focusedPlot.explotacionId}"
/>

<div class="av-te-wte__widget-empty-state av-te-wte__wes">
  <div class="av-te-wte__wes-top">
    <h3 class="av-te-wte__h4-dark h4 ">El tiempo hoy</h3>
  </div>
  <div class="av-te-wte__title-separator"></div>
  <div class="av-te-wte__wes-bottom">
  
    <svg
      width="24"
      height="24"
      viewBox="0 0 24 24"
      fill="none"
      xmlns="http://www.w3.org/2000/svg"
    >
      <path
        fill-rule="evenodd"
        clip-rule="evenodd"
        d="M7.45312 1C8.00541 1 8.45312 1.44772 8.45312 2V3C8.45312 3.55228 8.00541 4 7.45312 4C6.90084 4 6.45312 3.55228 6.45312 3V2C6.45312 1.44772 6.90084 1 7.45312 1ZM2.85735 2.90373C3.24787 2.51321 3.88104 2.51321 4.27156 2.90373L4.97867 3.61084C5.36919 4.00136 5.36919 4.63453 4.97867 5.02505C4.58814 5.41558 3.95498 5.41558 3.56445 5.02505L2.85735 4.31795C2.46682 3.92742 2.46682 3.29426 2.85735 2.90373ZM12.0489 2.90373C12.4394 3.29426 12.4394 3.92742 12.0489 4.31795L11.3418 5.02505C10.9513 5.41558 10.3181 5.41558 9.92758 5.02505C9.53706 4.63453 9.53706 4.00136 9.92758 3.61084L10.6347 2.90373C11.0252 2.51321 11.6584 2.51321 12.0489 2.90373ZM7.45312 6.45459C6.90084 6.45459 6.45312 6.90231 6.45312 7.45459C6.45312 7.76549 6.59382 8.04271 6.81877 8.22771C6.86787 8.26809 6.9207 8.30376 6.97652 8.33414C7.46163 8.59812 7.64089 9.20538 7.3769 9.69049C7.11292 10.1756 6.50566 10.3549 6.02055 10.0909C5.85263 9.9995 5.69462 9.89268 5.54838 9.77241C4.88131 9.2238 4.45312 8.38878 4.45312 7.45459C4.45312 5.79774 5.79627 4.45459 7.45312 4.45459C8.59283 4.45459 9.58255 5.09049 10.0895 6.02211C10.2164 6.25537 10.3135 6.50766 10.3753 6.77361C10.5003 7.31155 10.1656 7.849 9.62763 7.97404C9.08968 8.09907 8.55223 7.76434 8.4272 7.22639C8.40683 7.13875 8.37483 7.05545 8.33269 6.97801C8.16186 6.66405 7.83122 6.45459 7.45312 6.45459ZM0.953125 7.5C0.953125 6.94772 1.40084 6.5 1.95312 6.5H2.95312C3.50541 6.5 3.95312 6.94772 3.95312 7.5C3.95312 8.05228 3.50541 8.5 2.95312 8.5H1.95312C1.40084 8.5 0.953125 8.05228 0.953125 7.5ZM13.6107 10C11.9453 10 10.5145 11.0245 9.91465 12.3998C9.77789 12.7133 9.49038 12.9352 9.15242 12.988C7.2137 13.2909 5.99805 14.8324 5.99805 16.4137C5.99805 18.3519 7.65596 20 9.79805 20L16.998 20C18.6888 20 19.998 18.6863 19.998 17.1402C19.998 15.9599 19.252 14.8609 18.2096 14.4215C17.8588 14.2736 17.6225 13.9394 17.5998 13.5595C17.4838 11.6136 15.7795 10 13.6107 10ZM8.31964 11.1171C9.32771 9.29155 11.3175 8 13.6107 8C16.5607 8 19.0665 10.0697 19.5298 12.8502C21.0143 13.7158 21.998 15.3637 21.998 17.1402C21.998 19.8575 19.7255 22 16.998 22L9.79805 22C6.6382 22 3.99805 19.5413 3.99805 16.4137C3.99805 13.9593 5.74296 11.7512 8.31964 11.1171ZM3.56438 9.97502C3.9549 9.5845 4.58807 9.5845 4.97859 9.97502C5.36912 10.3655 5.36912 10.9987 4.97859 11.3892L4.27148 12.0963C3.88096 12.4869 3.24779 12.4869 2.85727 12.0963C2.46675 11.7058 2.46675 11.0727 2.85727 10.6821L3.56438 9.97502Z"
        fill="#101717"
      />
    </svg>

    <div class="av-te-wte__wes-texts">
      <h5 class="av-te-wte__wes-title">Tu explotación</h5>
      <p class="av-te-wte__wes-text">
        Añade tus parcelas y monitoriza el tiempo en ellas
      </p>
    </div>

    <a
      href="explotacion/edit"
      class="av-theme__btn av-theme__btn--primary"
      >Añadir parcela</a
    >
  </div>
</div>
