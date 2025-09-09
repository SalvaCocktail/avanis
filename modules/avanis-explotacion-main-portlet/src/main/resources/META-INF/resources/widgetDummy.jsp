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

<div class="portlet-content-container">
  <div class="portlet-body">
    <div class="av-te-widget-tu-explotacion av-te-wte">
      <div class="av-te-wte__row av-te-wte__row--001">
        <h3 class="av-te-wte__h4 h4">El tiempo hoy</h3>

        <div
          class="av-te-wte__dots-icon"
          style="pointer-events: none"
        >
          <svg
            width="16"
            height="4"
            viewBox="0 0 16 4"
            fill="none"
            xmlns="http://www.w3.org/2000/svg"
          >
            <path
              fill-rule="evenodd"
              clip-rule="evenodd"
              d="M0 2C0 0.89543 0.89543 0 2 0C3.10457 0 4 0.89543 4 2C4 3.10457 3.10457 4 2 4C0.89543 4 0 3.10457 0 2ZM6 2C6 0.89543 6.89543 0 8 0C9.10457 0 10 0.89543 10 2C10 3.10457 9.10457 4 8 4C6.89543 4 6 3.10457 6 2ZM12 2C12 0.89543 12.8954 0 14 0C15.1046 0 16 0.89543 16 2C16 3.10457 15.1046 4 14 4C12.8954 4 12 3.10457 12 2Z"
              fill="white"
            ></path>
          </svg>
        </div>
      </div>

      <div class="av-te-wte__title-separator"></div>

      <div class="av-te-wte__row av-te-wte__row--002">
        <h5 class="av-te-wte__h5">Tu parcela</h5>
        <div class="av-te-wte__alert-counter">
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
          <span class="av-te-wte__alert-counter-text"> 5 </span>
        </div>
      </div>
      <div class="av-te-wte__row av-te-wte__row--003">
        <span class="av-te-wte__location">Tu ubicación</span>
      </div>
      <div class="av-te-wte__row av-te-wte__row--004">
        <div
          class="av-te-wte__symbol-icon av-te-wte__symbol-icon--big av-te-wte__symbol-icon--1"
        ></div>
        <div class="av-te-wte__temperature av-te-wte__temperature--max">
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
              d="M11.2929 4.29289C11.6834 3.90237 12.3166 3.90237 12.7071 4.29289L18.7071 10.2929C19.0976 10.6834 19.0976 11.3166 18.7071 11.7071C18.3166 12.0976 17.6834 12.0976 17.2929 11.7071L13 7.41421V19C13 19.5523 12.5523 20 12 20C11.4477 20 11 19.5523 11 19V7.41421L6.70711 11.7071C6.31658 12.0976 5.68342 12.0976 5.29289 11.7071C4.90237 11.3166 4.90237 10.6834 5.29289 10.2929L11.2929 4.29289Z"
              fill="white"
            ></path>
          </svg>
          <span class="av-te-wte__max-min-temperature">26º</span>
        </div>
        <div class="av-te-wte__temperature av-te-wte__temperature--min">
          <svg
            width="14"
            height="16"
            viewBox="0 0 14 16"
            fill="none"
            xmlns="http://www.w3.org/2000/svg"
          >
            <path
              fill-rule="evenodd"
              clip-rule="evenodd"
              d="M7 0C7.55228 0 8 0.447715 8 1V12.5858L12.2929 8.29289C12.6834 7.90237 13.3166 7.90237 13.7071 8.29289C14.0976 8.68342 14.0976 9.31658 13.7071 9.70711L7.70711 15.7071C7.31658 16.0976 6.68342 16.0976 6.29289 15.7071L0.292893 9.70711C-0.0976311 9.31658 -0.0976311 8.68342 0.292893 8.29289C0.683417 7.90237 1.31658 7.90237 1.70711 8.29289L6 12.5858V1C6 0.447715 6.44772 0 7 0Z"
              fill="white"
            ></path>
          </svg>
          <span class="av-te-wte__max-min-temperature">21º</span>
        </div>
      </div>
      <div class="av-te-wte__row av-te-wte__row--005">
        <div class="av-te-wte__weather-by-hours">
          <div class="av-te-wte__weather-by-hours-item">
            <span class="av-te-wte__item-text-top"> 01:00 </span>

            <div
              class="av-te-wte__symbol-icon av-te-wte__symbol-icon--small av-te-wte__symbol-icon--1"
            ></div>

            <span class="av-te-wte__item-text-bottom"> 21º </span>
          </div>

          <div class="av-te-wte__weather-by-hours-item">
            <span class="av-te-wte__item-text-top"> 02:00 </span>

            <div
              class="av-te-wte__symbol-icon av-te-wte__symbol-icon--small av-te-wte__symbol-icon--1"
            ></div>

            <span class="av-te-wte__item-text-bottom"> 21º </span>
          </div>

          <div class="av-te-wte__weather-by-hours-item">
            <span class="av-te-wte__item-text-top"> 03:00 </span>

            <div
              class="av-te-wte__symbol-icon av-te-wte__symbol-icon--small av-te-wte__symbol-icon--1"
            ></div>

            <span class="av-te-wte__item-text-bottom"> 21º </span>
          </div>

          <div class="av-te-wte__weather-by-hours-item">
            <span class="av-te-wte__item-text-top"> 04:00 </span>

            <div
              class="av-te-wte__symbol-icon av-te-wte__symbol-icon--small av-te-wte__symbol-icon--1"
            ></div>

            <span class="av-te-wte__item-text-bottom"> 22º </span>
          </div>

          <div class="av-te-wte__weather-by-hours-item">
            <span class="av-te-wte__item-text-top"> 05:00 </span>

            <div
              class="av-te-wte__symbol-icon av-te-wte__symbol-icon--small av-te-wte__symbol-icon--1"
            ></div>

            <span class="av-te-wte__item-text-bottom"> 22º </span>
          </div>

          <div class="av-te-wte__weather-by-hours-item">
            <span class="av-te-wte__item-text-top"> 06:00 </span>

            <div
              class="av-te-wte__symbol-icon av-te-wte__symbol-icon--small av-te-wte__symbol-icon--1"
            ></div>

            <span class="av-te-wte__item-text-bottom"> 22º </span>
          </div>

          <div class="av-te-wte__weather-by-hours-item">
            <span class="av-te-wte__item-text-top"> 07:00 </span>

            <div
              class="av-te-wte__symbol-icon av-te-wte__symbol-icon--small av-te-wte__symbol-icon--1"
            ></div>

            <span class="av-te-wte__item-text-bottom"> 22º </span>
          </div>

          <div class="av-te-wte__weather-by-hours-item">
            <span class="av-te-wte__item-text-top"> 08:00 </span>

            <div
              class="av-te-wte__symbol-icon av-te-wte__symbol-icon--small av-te-wte__symbol-icon--1"
            ></div>

            <span class="av-te-wte__item-text-bottom"> 22º </span>
          </div>

          <div class="av-te-wte__weather-by-hours-item">
            <span class="av-te-wte__item-text-top"> 09:00 </span>

            <div
              class="av-te-wte__symbol-icon av-te-wte__symbol-icon--small av-te-wte__symbol-icon--1"
            ></div>

            <span class="av-te-wte__item-text-bottom"> 22º </span>
          </div>

          <div class="av-te-wte__weather-by-hours-item">
            <span class="av-te-wte__item-text-top"> 10:00 </span>

            <div
              class="av-te-wte__symbol-icon av-te-wte__symbol-icon--small av-te-wte__symbol-icon--1"
            ></div>

            <span class="av-te-wte__item-text-bottom"> 22º </span>
          </div>

          <div class="av-te-wte__weather-by-hours-item">
            <span class="av-te-wte__item-text-top"> 11:00 </span>

            <div
              class="av-te-wte__symbol-icon av-te-wte__symbol-icon--small av-te-wte__symbol-icon--1"
            ></div>

            <span class="av-te-wte__item-text-bottom"> 23º </span>
          </div>

          <div class="av-te-wte__weather-by-hours-item">
            <span class="av-te-wte__item-text-top"> 12:00 </span>

            <div
              class="av-te-wte__symbol-icon av-te-wte__symbol-icon--small av-te-wte__symbol-icon--1"
            ></div>

            <span class="av-te-wte__item-text-bottom"> 23º </span>
          </div>

          <div class="av-te-wte__weather-by-hours-item">
            <span class="av-te-wte__item-text-top"> 13:00 </span>

            <div
              class="av-te-wte__symbol-icon av-te-wte__symbol-icon--small av-te-wte__symbol-icon--1"
            ></div>

            <span class="av-te-wte__item-text-bottom"> 23º </span>
          </div>

          <div class="av-te-wte__weather-by-hours-item">
            <span class="av-te-wte__item-text-top"> 14:00 </span>

            <div
              class="av-te-wte__symbol-icon av-te-wte__symbol-icon--small av-te-wte__symbol-icon--1"
            ></div>

            <span class="av-te-wte__item-text-bottom"> 24º </span>
          </div>

          <div class="av-te-wte__weather-by-hours-item">
            <span class="av-te-wte__item-text-top"> 15:00 </span>

            <div
              class="av-te-wte__symbol-icon av-te-wte__symbol-icon--small av-te-wte__symbol-icon--1"
            ></div>

            <span class="av-te-wte__item-text-bottom"> 24º </span>
          </div>

          <div class="av-te-wte__weather-by-hours-item">
            <span class="av-te-wte__item-text-top"> 16:00 </span>

            <div
              class="av-te-wte__symbol-icon av-te-wte__symbol-icon--small av-te-wte__symbol-icon--1"
            ></div>

            <span class="av-te-wte__item-text-bottom"> 25º </span>
          </div>

          <div class="av-te-wte__weather-by-hours-item">
            <span class="av-te-wte__item-text-top"> 17:00 </span>

            <div
              class="av-te-wte__symbol-icon av-te-wte__symbol-icon--small av-te-wte__symbol-icon--1"
            ></div>

            <span class="av-te-wte__item-text-bottom"> 25º </span>
          </div>

          <div class="av-te-wte__weather-by-hours-item">
            <span class="av-te-wte__item-text-top"> 18:00 </span>

            <div
              class="av-te-wte__symbol-icon av-te-wte__symbol-icon--small av-te-wte__symbol-icon--1"
            ></div>

            <span class="av-te-wte__item-text-bottom"> 26º </span>
          </div>

          <div class="av-te-wte__weather-by-hours-item">
            <span class="av-te-wte__item-text-top"> 19:00 </span>

            <div
              class="av-te-wte__symbol-icon av-te-wte__symbol-icon--small av-te-wte__symbol-icon--1"
            ></div>

            <span class="av-te-wte__item-text-bottom"> 26º </span>
          </div>

          <div class="av-te-wte__weather-by-hours-item">
            <span class="av-te-wte__item-text-top"> 20:00 </span>

            <div
              class="av-te-wte__symbol-icon av-te-wte__symbol-icon--small av-te-wte__symbol-icon--1"
            ></div>

            <span class="av-te-wte__item-text-bottom"> 26º </span>
          </div>

          <div class="av-te-wte__weather-by-hours-item">
            <span class="av-te-wte__item-text-top"> 21:00 </span>

            <div
              class="av-te-wte__symbol-icon av-te-wte__symbol-icon--small av-te-wte__symbol-icon--1"
            ></div>

            <span class="av-te-wte__item-text-bottom"> 25º </span>
          </div>

          <div class="av-te-wte__weather-by-hours-item">
            <span class="av-te-wte__item-text-top"> 22:00 </span>

            <div
              class="av-te-wte__symbol-icon av-te-wte__symbol-icon--small av-te-wte__symbol-icon--1"
            ></div>

            <span class="av-te-wte__item-text-bottom"> 23º </span>
          </div>

          <div class="av-te-wte__weather-by-hours-item">
            <span class="av-te-wte__item-text-top"> 23:00 </span>

            <div
              class="av-te-wte__symbol-icon av-te-wte__symbol-icon--small av-te-wte__symbol-icon--1"
            ></div>

            <span class="av-te-wte__item-text-bottom"> 22º </span>
          </div>

          <div class="av-te-wte__weather-by-hours-item">
            <span class="av-te-wte__item-text-top"> 00:00 </span>

            <div
              class="av-te-wte__symbol-icon av-te-wte__symbol-icon--small av-te-wte__symbol-icon--1"
            ></div>

            <span class="av-te-wte__item-text-bottom"> 22º </span>
          </div>
        </div>
      </div>
      <div class="av-te-wte__row av-te-wte__row--006">
        <a
          href="/explotacion"
          class="av-te-wte__view-more"
        >
          Ver más
          <!-- Ir a Tu explotación - A la parcela seleccioanda en el Widget -->
        </a>
      </div>
    </div>
  </div>
</div>
