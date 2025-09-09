<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %> <%@ taglib
uri="http://java.sun.com/portlet_2_0" prefix="portlet" %> <%@ taglib
uri="http://liferay.com/tld/theme" prefix="liferay-theme" %> <%@ page
import="com.liferay.portal.kernel.util.WebKeys" %>

<jsp:directive.page
  contentType="text/html"
  pageEncoding="UTF-8"
/>
<portlet:actionURL
  var="setFocusURL"
  name="setFocus"
/>

<div class="av-te-plotsList av-te-pl">

	<h3 class="h3">Mis parcelas</h3>

  <div
    class="av-te-pl__plot-card av-te-pl__plot-card-1 selected-card"
    onclick="submitFormAvPlotList(1)"
		style="pointer-events: none;"
  >
    <div class="av-te-pl__row-001">
      <h5 class="av-te-pl__plot-name h5-inverse">
        El tiempo en tu parcela
      </h5>
      <div class="av-te-pl__plot-warnings-number">
        <svg
          width="15"
          height="14"
          viewBox="0 0 15 14"
          fill="none"
          xmlns="http://www.w3.org/2000/svg"
        >
          <path
            fill-rule="evenodd"
            clip-rule="evenodd"
            d="M6.67179 0.613075C7.19821 0.373441 7.80259 0.373441 8.32901 0.613075C8.70287 0.783261 8.96525 1.09575 9.18605 1.42247C9.40596 1.74788 9.64672 2.18564 9.93793 2.71515L13.6947 9.5456C13.9676 10.0418 14.1946 10.4544 14.3436 10.796C14.4944 11.1417 14.6115 11.5123 14.5645 11.9046C14.4978 12.4616 14.2001 12.965 13.7442 13.292C13.4231 13.5222 13.042 13.5982 12.6664 13.6326C12.2952 13.6667 11.8244 13.6666 11.258 13.6666H3.74276C3.17641 13.6666 2.70555 13.6667 2.33445 13.6326C1.95884 13.5982 1.57771 13.5222 1.25662 13.292C0.800691 12.965 0.503043 12.4616 0.436299 11.9046C0.389295 11.5123 0.506391 11.1417 0.657223 10.796C0.80625 10.4544 1.03318 10.0418 1.30613 9.54559L5.06286 2.71517C5.35408 2.18565 5.59484 1.74788 5.81475 1.42247C6.03555 1.09575 6.29793 0.783261 6.67179 0.613075ZM7.77661 1.82659C7.60113 1.74671 7.39967 1.74671 7.2242 1.82659C7.19539 1.8397 7.10407 1.8959 6.91947 2.16904C6.73797 2.43762 6.52638 2.82094 6.21529 3.38656L2.49 10.1598C2.19748 10.6917 2.00091 11.0505 1.87931 11.3292C1.75668 11.6102 1.75617 11.7126 1.76016 11.7459C1.78241 11.9316 1.88163 12.0994 2.0336 12.2084C2.06086 12.228 2.15084 12.2769 2.45621 12.3049C2.75903 12.3326 3.16813 12.3333 3.77511 12.3333H11.2257C11.8327 12.3333 12.2418 12.3326 12.5446 12.3049C12.85 12.2769 12.9399 12.228 12.9672 12.2084C13.1192 12.0994 13.2184 11.9316 13.2406 11.7459C13.2446 11.7126 13.2441 11.6102 13.1215 11.3292C12.9999 11.0505 12.8033 10.6917 12.5108 10.1598L8.78552 3.38657C8.47442 2.82094 8.26283 2.43762 8.08133 2.16904C7.89674 1.8959 7.80541 1.8397 7.77661 1.82659ZM7.5004 4.99996C7.86859 4.99996 8.16707 5.29844 8.16707 5.66663V8.3333C8.16707 8.70149 7.86859 8.99997 7.5004 8.99997C7.13221 8.99997 6.83373 8.70149 6.83373 8.3333V5.66663C6.83373 5.29844 7.13221 4.99996 7.5004 4.99996ZM6.83373 10.3333C6.83373 9.96511 7.13221 9.66663 7.5004 9.66663H7.50707C7.87526 9.66663 8.17373 9.96511 8.17373 10.3333C8.17373 10.7015 7.87526 11 7.50707 11H7.5004C7.13221 11 6.83373 10.7015 6.83373 10.3333Z"
            fill="#101717"
          ></path>
        </svg>
        <span class="body-s"> 2 </span>
      </div>
    </div>
    <div class="av-te-pl__plot-province body-s-inverse">Tu ubicación</div>
    <div class="av-te-pl__plot-uses body-s-inverse">
      Usos: <span>Olivares</span> , <span>Cereales</span>
    </div>
    <div class="av-te-pl__plot-current-forecast">
      <div class="av-te-pl__symbol symbol-icon symbol-icon--1"></div>
      <div class="av-te-pl__information">
        <div class="av-te-pl__temperature h5-inverse">21ºC</div>
        <div class="av-te-pl__min-max body-s-inverse">21º - 26º</div>
      </div>
    </div>
  </div>
</div>
