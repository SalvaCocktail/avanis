<%@ include file="/init.jsp" %>
<jsp:directive.page
  contentType="text/html"
  pageEncoding="UTF-8"
/>

<div class="av-lm">
  <div class="av-lm__container">
    <div class="av-lm__columns">
      <div
        class="av-lm__column av-lm_column--left av-lm-cl js-av-lm-cl av-theme__hidden-mobile"
      >
        <div class="av-lm-cl__row av-lm-cl__row--001">
          <div
            class="av-theme__icon-box-32 av-theme__hidden-desktop js-av-lm-cl-back-icon"
          >
            <!-- #region svg -->
            <svg
              width="22"
              height="20"
              viewBox="0 0 22 20"
              fill="none"
              xmlns="http://www.w3.org/2000/svg"
            >
              <path
                fill-rule="evenodd"
                clip-rule="evenodd"
                d="M10.6094 1.05727C11.1301 1.57797 11.1301 2.42219 10.6094 2.94289L4.88554 8.66675H20.3333C21.0696 8.66675 21.6666 9.2637 21.6666 10.0001C21.6666 10.7365 21.0696 11.3334 20.3333 11.3334H4.88554L10.6094 17.0573C11.1301 17.578 11.1301 18.4222 10.6094 18.9429C10.0887 19.4636 9.24448 19.4636 8.72378 18.9429L0.723776 10.9429C0.203077 10.4222 0.203077 9.57797 0.723776 9.05727L8.72378 1.05727C9.24448 0.536573 10.0887 0.536573 10.6094 1.05727Z"
                fill="#101717"
              />
            </svg>
            <!-- #endregion svg -->
          </div>
          <h5 class="js-av-lm__title av-theme__hidden-desktop">
            Lonjas y mercados
          </h5>
          <h2 class="js-av-lm__title av-theme__hidden-mobile">
            Lonjas y mercados
          </h2>
        </div>
        <% if(themeDisplay.isSignedIn()) { %>
        <div class="av-lm-cl__row av-lm-cl__row--002">
          <h4>Mis favoritos</h4>
          <div class="av-lm-cl__edit-btn <c:if test="${fn:length(favoritosUser) == 0}"> d-none </c:if>">
            <span>Editar</span>
            <div class="av-theme__icon-box-16">
              <svg
                width="16"
                height="16"
                viewBox="0 0 16 16"
                fill="none"
                xmlns="http://www.w3.org/2000/svg"
              >
                <path
                  fill-rule="evenodd"
                  clip-rule="evenodd"
                  d="M13.0215 2.86404C12.7612 2.6037 12.3391 2.6037 12.0787 2.86405L11.2761 3.66663L12.219 4.60944L13.0215 3.80685C13.2819 3.5465 13.2819 3.12439 13.0215 2.86404ZM13.9644 4.74966C14.7454 3.96861 14.7454 2.70228 13.9644 1.92124C13.1833 1.14019 11.917 1.14019 11.1359 1.92124L9.86208 3.19508L3.37059 9.68657C3.35416 9.703 3.33792 9.71923 3.32187 9.73529C2.80855 10.2485 2.48581 10.5712 2.23312 10.9466C2.00927 11.2793 1.82921 11.6394 1.69741 12.0181C1.54864 12.4455 1.48415 12.8973 1.38158 13.6159C1.37837 13.6383 1.37512 13.6611 1.37184 13.6841L1.3402 13.9055C1.30958 14.1199 1.38499 14.3358 1.54244 14.4845C1.69988 14.6332 1.91974 14.6961 2.13202 14.6533L2.51838 14.5753C3.1641 14.4451 3.57016 14.3632 3.95366 14.2123C4.29351 14.0785 4.61648 13.9053 4.91595 13.6962C5.25387 13.4603 5.54672 13.1674 6.01245 12.7016C6.02697 12.687 6.04167 12.6723 6.05653 12.6575L13.9644 4.74966ZM11.2761 5.55225L10.3333 4.60944L4.3134 10.6294C3.73579 11.207 3.51118 11.4356 3.3393 11.691C3.1794 11.9287 3.05079 12.1859 2.95665 12.4564C2.89271 12.64 2.84995 12.8342 2.798 13.1561C3.11078 13.0885 3.29318 13.0394 3.46532 12.9716C3.70806 12.8761 3.93876 12.7523 4.15266 12.603C4.38256 12.4425 4.58979 12.2386 5.11373 11.7147L11.2761 5.55225Z"
                  fill="#107E3E"
                />
              </svg>
            </div>
          </div>
        </div>
        <div
          class="av-lm-cl__row av-lm-cl__row--003 js-av-lm-cl__favorites-tabs"
        >
          <div
            class="av-lm-cl__tab js-av-lm-cl__tab av-lm-cl__tab--selected av-lm-cl__tab--all"
            variacion-porcentaje-type="all"
          >
            <span>Todos</span>
          </div>
          <div
            class="av-lm-cl__tab js-av-lm-cl__tab av-lm-cl__tab--up"
            variacion-porcentaje-type="up"
          >
            <div class="av-thme__icon-box-24">
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
                  d="M11.2929 5.29289C11.6834 4.90237 12.3166 4.90237 12.7071 5.29289L17.7071 10.2929C18.0976 10.6834 18.0976 11.3166 17.7071 11.7071C17.3166 12.0976 16.6834 12.0976 16.2929 11.7071L13 8.41421V18C13 18.5523 12.5523 19 12 19C11.4477 19 11 18.5523 11 18V8.41421L7.70711 11.7071C7.31658 12.0976 6.68342 12.0976 6.29289 11.7071C5.90237 11.3166 5.90237 10.6834 6.29289 10.2929L11.2929 5.29289Z"
                  fill="#101717"
                />
              </svg>
            </div>
            <span>Sube</span>
          </div>
          <div
            class="av-lm-cl__tab js-av-lm-cl__tab av-lm-cl__tab--down"
            variacion-porcentaje-type="down"
          >
            <div class="av-thme__icon-box-24">
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
                  d="M12 5C12.5523 5 13 5.44772 13 6V15.5858L16.2929 12.2929C16.6834 11.9024 17.3166 11.9024 17.7071 12.2929C18.0976 12.6834 18.0976 13.3166 17.7071 13.7071L12.7071 18.7071C12.3166 19.0976 11.6834 19.0976 11.2929 18.7071L6.29289 13.7071C5.90237 13.3166 5.90237 12.6834 6.29289 12.2929C6.68342 11.9024 7.31658 11.9024 7.70711 12.2929L11 15.5858V6C11 5.44772 11.4477 5 12 5Z"
                  fill="#101717"
                />
              </svg>
            </div>
            <span>Baja</span>
          </div>
          <div
            class="av-lm-cl__tab js-av-lm-cl__tab av-lm-cl__tab--stable"
            variacion-porcentaje-type="stable"
          >
            <div class="av-thme__icon-box-24">
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
                  d="M2 12C2 11.4477 2.44772 11 3 11L21 11C21.5523 11 22 11.4477 22 12C22 12.5523 21.5523 13 21 13L3 13C2.44772 13 2 12.5523 2 12Z"
                  fill="#101717"
                />
              </svg>
            </div>
            <span>Estable</span>
          </div>
        </div>
        <div class="av-lm-cl__row av-lm-cl__row--004">
          <div
            class="js-av-lm-cl__favorites-empty-state av-lm-cl__favorites-empty-state av-lm-cl__favorites-empty-state--all <c:if test="${fn:length(favoritosUser) > 0}"> d-none </c:if> "
          >
            <div class="av-theme-icon-box-24">
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
                  d="M6.9146 2.99972C6.94048 2.99982 6.96573 2.99991 6.99029 2.99991H17.0126C17.0371 2.99991 17.0624 2.99982 17.0883 2.99972C17.3643 2.99867 17.7112 2.99736 18.0355 3.10922C18.3158 3.20589 18.571 3.36364 18.7828 3.57108C19.0279 3.81113 19.1819 4.12202 19.3044 4.36936C19.3159 4.39255 19.3271 4.41519 19.3381 4.43716L21.3311 8.42321C21.4144 8.58975 21.5047 8.77007 21.5668 8.92907C21.6319 9.09577 21.7263 9.38083 21.6763 9.71915C21.616 10.1273 21.3902 10.4926 21.0521 10.7291C20.7719 10.9251 20.4747 10.9682 20.2965 10.9845C20.2049 10.9929 20.1041 10.9967 20.0014 10.9985V19.9999C20.0014 20.5522 19.5537 20.9999 19.0014 20.9999C18.4491 20.9999 18.0014 20.5522 18.0014 19.9999V10.9999H6.00143V14.9999H14.0014V13.9999C14.0014 13.4476 14.4491 12.9999 15.0014 12.9999C15.5537 12.9999 16.0014 13.4476 16.0014 13.9999L16.0014 17.636C16.0015 18.0251 16.0015 18.3752 15.9777 18.6665C15.9522 18.9785 15.8945 19.31 15.7289 19.6349C15.4893 20.1053 15.1068 20.4877 14.6364 20.7274C14.3115 20.893 13.98 20.9507 13.6681 20.9762C13.3767 21 13.0266 20.9999 12.6375 20.9999H7.36533C6.97624 20.9999 6.62612 21 6.3348 20.9762C6.02283 20.9507 5.69136 20.893 5.36646 20.7274C4.89605 20.4877 4.5136 20.1053 4.27392 19.6349C4.10837 19.31 4.05068 18.9785 4.02519 18.6665C4.00139 18.3752 4.00141 18.0251 4.00143 17.636L4.00143 10.9985C3.89881 10.9967 3.798 10.9929 3.7064 10.9845C3.52818 10.9682 3.23099 10.9251 2.95074 10.7291C2.61263 10.4926 2.38686 10.1273 2.32656 9.71915C2.27657 9.38083 2.37098 9.09577 2.43609 8.92907C2.49819 8.77007 2.58842 8.58974 2.67175 8.4232C2.67649 8.41373 2.6812 8.4043 2.68589 8.39493L4.66478 4.43716C4.67576 4.4152 4.68697 4.39256 4.69845 4.36937C4.82096 4.12202 4.97493 3.81114 5.22003 3.57108C5.43182 3.36365 5.68708 3.20589 5.96732 3.10922C6.29165 2.99736 6.63857 2.99867 6.9146 2.99972ZM19.3834 8.99991L17.5492 5.33159C17.4636 5.16023 17.4191 5.07232 17.3832 5.01054C17.3822 5.00868 17.3811 5.0069 17.3801 5.00521C17.3782 5.00508 17.3761 5.00494 17.374 5.00481C17.3027 5.00036 17.2042 4.99991 17.0126 4.99991H6.99029C6.7987 4.99991 6.70019 5.00036 6.6289 5.00481C6.62675 5.00494 6.6247 5.00508 6.62274 5.00521C6.62174 5.0069 6.62071 5.00868 6.61963 5.01054C6.58377 5.07231 6.53931 5.16023 6.45363 5.33159L4.61947 8.99991H19.3834ZM6.00143 16.9999V17.5999C6.00143 18.0365 6.00221 18.3037 6.01855 18.5037C6.02616 18.5968 6.03572 18.6532 6.04378 18.6874C6.04761 18.7037 6.05083 18.7137 6.05276 18.7191C6.05461 18.7243 6.05572 18.7265 6.05593 18.7269C6.10387 18.821 6.18036 18.8975 6.27444 18.9454C6.27484 18.9456 6.27702 18.9467 6.28222 18.9486C6.28764 18.9505 6.29765 18.9537 6.31393 18.9576C6.34816 18.9656 6.40452 18.9752 6.49767 18.9828C6.69763 18.9991 6.96489 18.9999 7.40143 18.9999H12.6014C13.038 18.9999 13.3052 18.9991 13.5052 18.9828C13.5983 18.9752 13.6547 18.9656 13.6889 18.9576C13.7052 18.9537 13.7152 18.9505 13.7206 18.9486C13.7258 18.9467 13.728 18.9456 13.7284 18.9454C13.8225 18.8975 13.899 18.821 13.9469 18.7269C13.9471 18.7265 13.9483 18.7243 13.9501 18.7191C13.952 18.7137 13.9553 18.7037 13.9591 18.6874C13.9671 18.6532 13.9767 18.5968 13.9843 18.5037C14.0007 18.3037 14.0014 18.0365 14.0014 17.5999V16.9999H6.00143Z"
                  fill="#101717"
                />
              </svg>
            </div>
          </div>
          <c:forEach
            var="favorito"
            items="${favoritosUser}"
          >
            <%@ include file="/card-favorites.jsp" %>
          </c:forEach>
        </div>
        <div class="av-lm__bottom-gradient"></div>
        <% } %>
      </div>
      <div class="av-lm__column av-lm_column--right av-lm-cr js-av-lm-cr">
        <div class="av-lm-cr__row av-lm-cr__row--001">
          <a
            href="/"
            class="av-lm-cr__logo av-theme__hidden-desktop"
          >
            <img
              src="/documents/d/guest/logo139"
              alt="Logo"
            />
          </a>
          <div
            class="av-lm-cr__icon-close js-av-theme-modal-page__close-modal av-theme__icon-box-24"
          >
            <svg
              width="18"
              height="18"
              viewBox="0 0 18 18"
              fill="none"
              xmlns="http://www.w3.org/2000/svg"
            >
              <path
                d="M1 1L17 17M17 1L1 17"
                stroke="#101717"
                stroke-width="2"
                stroke-linecap="round"
                stroke-linejoin="round"
              />
            </svg>
          </div>
        </div>
        <div class="av-lm-cr__row av-lm-cr__row--002">
          <div class="av-lm-cr__title js-av-lm__title">Lonjas y mercados</div>

          <div class="av-lm-cr__cta js-av-lm-cr-view-favorites">
            <div class="av-theme__icon-box-24">
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
                  d="M11.3321 2.65632C11.7522 2.44789 12.2455 2.44789 12.6656 2.65632C13.0361 2.84019 13.2294 3.16329 13.3222 3.3296C13.4226 3.50949 13.5254 3.74021 13.6281 3.97078C13.633 3.98186 13.638 3.99294 13.6429 4.00402L15.44 8.03559L19.8658 8.5027C20.1168 8.52915 20.368 8.55562 20.5701 8.59548C20.7569 8.63235 21.1239 8.71631 21.4133 9.01193C21.7413 9.34701 21.8938 9.81621 21.8254 10.2801C21.765 10.6894 21.5174 10.973 21.3879 11.1127C21.2479 11.2637 21.0602 11.4327 20.8727 11.6017L17.5667 14.581L18.4901 18.9346C18.5425 19.1815 18.595 19.4285 18.6195 19.633C18.6422 19.8221 18.6757 20.1971 18.484 20.5637C18.2667 20.9792 17.8676 21.2692 17.4052 21.3475C16.9974 21.4165 16.6511 21.2687 16.4783 21.1887C16.2914 21.1022 16.0726 20.976 15.854 20.8498L11.9988 18.6263L8.1437 20.8498C7.92508 20.976 7.70633 21.1022 7.51941 21.1887C7.34658 21.2687 7.00031 21.4165 6.59243 21.3475C6.13011 21.2692 5.73098 20.9792 5.51366 20.5637C5.32194 20.1971 5.35549 19.8221 5.37818 19.633C5.40271 19.4285 5.45516 19.1814 5.50757 18.9345L6.43097 14.581L3.15204 11.6261C3.14303 11.618 3.13401 11.6098 3.125 11.6017C2.93746 11.4328 2.7498 11.2637 2.60974 11.1127C2.48024 10.973 2.23268 10.6894 2.17232 10.2801C2.1039 9.81621 2.25635 9.34701 2.58437 9.01193C2.87376 8.71631 3.24077 8.63235 3.42762 8.59548C3.62971 8.55562 3.88089 8.52915 4.13192 8.5027C4.14399 8.50143 4.15606 8.50015 4.16813 8.49888L8.5577 8.03559L10.3548 4.00401C10.3597 3.99294 10.3647 3.98185 10.3696 3.97076C10.4723 3.7402 10.5751 3.50948 10.6755 3.3296C10.7683 3.16329 10.9616 2.84019 11.3321 2.65632ZM11.9988 5.2281L10.3375 8.95521C10.3336 8.96385 10.3292 8.97393 10.3243 8.98526C10.2768 9.09464 10.1783 9.32134 10.0115 9.50644C9.87095 9.6625 9.69918 9.78731 9.50732 9.87277C9.27975 9.97414 9.0337 9.99779 8.91499 10.0092C8.90268 10.0104 8.89175 10.0114 8.88234 10.0124L4.82425 10.4407L7.85556 13.1725C7.86259 13.1789 7.87082 13.1861 7.88007 13.1943C7.9694 13.2733 8.15456 13.4371 8.27909 13.6529C8.38407 13.8348 8.44969 14.0367 8.47168 14.2456C8.49776 14.4934 8.44422 14.7347 8.41839 14.8511C8.41572 14.8632 8.41334 14.8739 8.41138 14.8831L7.5647 18.875L11.0995 16.8362C11.1077 16.8315 11.1172 16.8259 11.1278 16.8196C11.2306 16.7591 11.4435 16.6336 11.6872 16.5818C11.8927 16.5382 12.105 16.5382 12.3105 16.5818C12.5541 16.6336 12.7671 16.7591 12.8699 16.8196C12.8805 16.8259 12.89 16.8315 12.8982 16.8362L16.433 18.875L15.5863 14.8831C15.5843 14.8739 15.582 14.8632 15.5793 14.8511C15.5535 14.7347 15.4999 14.4934 15.526 14.2456C15.548 14.0367 15.6136 13.8348 15.7186 13.6529C15.8431 13.4371 16.0283 13.2733 16.1176 13.1943C16.1269 13.1861 16.1351 13.1789 16.1421 13.1725L19.1734 10.4407L15.1153 10.0124C15.1059 10.0114 15.095 10.0104 15.0827 10.0092C14.964 9.99779 14.7179 9.97414 14.4904 9.87277C14.2985 9.78731 14.1267 9.66251 13.9862 9.50644C13.8194 9.32134 13.7209 9.09464 13.6734 8.98526C13.6684 8.97393 13.6641 8.96385 13.6602 8.95521L11.9988 5.2281Z"
                  fill="#107E3E"
                />
              </svg>
            </div>
            <span>Ver favoritos</span>
          </div>
        </div>
        <div class="av-lm-cr__row-3-to-8-container">
          <div class="av-lm-cr__row av-lm-cr__row--003">
            <p>
              Descubre más de ${totalPrecioLonja} precios de diferentes lonjas y
              mercados sobre ${totalAreas} productos agroalimentarios distintos.
              Unos precios que actualizamos continuamente para que estés al día.
            </p>
          </div>
          <div class="av-lm-cr__row av-lm-cr__row--004">
            <div class="av-lm-cr__dropdown js-av-lm-cr__dropdown">
              <div
                class="av-lm-cr__dropdown-backdrop js-av-lm-cr__dropdown-backdrop av-theme__hidden"
              ></div>
              <div class="av-lm-cr__dropdown-btn js-av-lm-cr__dropdown-btn">
                <span id="texto-seleccion-lonjas">Seleccionar Lonjas</span>
                <!-- Aquí se actualizará el texto -->
                <!-- <div> -->
                  <span
                    id="contador-lonjas"
                    class="circulo-contador-verde"
                  ></span>
                  <!-- Aquí irá el número en un estilo circular -->
                  <svg
                    width="24"
                    height="24"
                    viewBox="0 0 24 24"
                    fill="none"
                    xmlns="http://www.w3.org/2000/svg"
                    class="js-av-lm-cr__dropdown-svg"
                  >
                    <path
                      fill-rule="evenodd"
                      clip-rule="evenodd"
                      d="M12 16C12.2652 16 12.5196 15.8946 12.7071 15.7071L18.7071 9.70711C19.0976 9.31658 19.0976 8.68342 18.7071 8.29289C18.3166 7.90237 17.6834 7.90237 17.2929 8.29289L12 13.5858L6.70711 8.29289C6.31658 7.90237 5.68342 7.90237 5.29289 8.29289C4.90237 8.68342 4.90237 9.31658 5.29289 9.70711L11.2929 15.7071C11.4804 15.8946 11.7348 16 12 16Z"
                      fill="#101717"
                    />
                  </svg>
                <!-- </div> -->
              </div>
              <div
                class="av-lm-cr__dropdown-menu js-av-lm-cr__dropdown-menu av-theme__hidden"
              >
                <!-- Agregar la opción "Todas las lonjas" -->
                <label
                  class="js-av-lm-cr__dropdown-item"
                  href="#"
                >
                  <input
                    type="checkbox"
                    value="all"
                    checked
                  />
                  <span class="av-theme__capitalize-first">
                    Todas las lonjas
                  </span>
                </label>

                <!-- Aquí iteramos sobre la lista de lonjas dinámicamente -->
                <c:forEach
                  var="lonja"
                  items="${lonjasTodas}"
                >
                  <label
                    class="js-av-lm-cr__dropdown-item"
                    href="#"
                  >
                    <input
                      type="checkbox"
                      value="${lonja.lonjaId}"
                    />
                    <span class="av-theme__capitalize-first">
                      ${lonja.nombre}
                    </span>
                  </label>
                </c:forEach>
              </div>
            </div>
            <div class="av-lm-cr__search-input-box">
              <input
                type="search"
                name=""
                id="buscar-productos"
                placeholder="Buscar"
                class="av-lm-cr__search-input"
              />
              <div class="av-theme__icon-box-24 av-lm-cr__search-icon">
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
                    d="M11 4C7.13401 4 4 7.13401 4 11C4 14.866 7.13401 18 11 18C14.866 18 18 14.866 18 11C18 7.13401 14.866 4 11 4ZM2 11C2 6.02944 6.02944 2 11 2C15.9706 2 20 6.02944 20 11C20 13.1242 19.2641 15.0765 18.0334 16.6159L21.7074 20.2932C22.0978 20.6839 22.0975 21.3171 21.7068 21.7074C21.3161 22.0978 20.6829 22.0975 20.2926 21.7068L16.6195 18.0304C15.0796 19.2629 13.1259 20 11 20C6.02944 20 2 15.9706 2 11ZM10 6C10 5.44772 10.4477 5 11 5C14.3137 5 17 7.68629 17 11C17 11.5523 16.5523 12 16 12C15.4477 12 15 11.5523 15 11C15 8.79086 13.2091 7 11 7C10.4477 7 10 6.55228 10 6Z"
                    fill="#101717"
                  />
                </svg>
              </div>
            </div>
          </div>
          <div class="av-lm-cr__row av-lm-cr__row--005">
            <div
              class="av-lm-cr__tabs-gradient av-lm-cr__tabs-gradient--left av-theme__hidden"
            ></div>
            <div
              class="av-lm-cr__tabs-gradient av-lm-cr__tabs-gradient--right"
            ></div>
            <div
              class="av-lm-cr__tabs js-av-lm-cr__tabs av-theme__slider-draggable"
            >
              <!-- Tab para mostrar todos los productos -->
              <div
                class="av-lm-cr__tab js-av-lm-cr__tab av-lm-cr__tab-selected"
                data-group-id="all"
                data-total="${totalPrecioLonja}"
              >
                <span>Todos</span>
              </div>

              <!-- Iterar sobre los grupos -->
              <c:forEach
                var="entry"
                items="${listasPorGrupo}"
              >
                <c:set
                  var="productos"
                  value="${entry.value}"
                />

                <!-- Obtener el nombre del grupo del primer producto de la lista -->
                <c:set
                  var="grupoNombre"
                  value="${productos[0].nombreGrupo}"
                />

                <c:if test="${fn:length(productos) > 0}">
                  <div
                    class="av-lm-cr__tab js-av-lm-cr__tab"
                    data-group-id="${entry.key}"
                    data-total="${fn:length(productos)}"
                  >
                    <!-- <span>${grupoNombre} (${fn:length(productos)})</span> -->
                    <span class="av-theme__capitalize-first"
                      >${grupoNombre}</span
                    >
                  </div>
                </c:if>
              </c:forEach>
            </div>
          </div>
          <div class="av-lm-cr__row av-lm-cr__row--006">
            <div class="av-lm-cr__results">
              <span> Mostrando </span>
              <span
                class="av-lm-cr__results-wrong"
                id="total-resultados"
                >&nbsp; ${totalPrecioLonja} &nbsp;</span
              >
              <span> resultados </span>
            </div>
            <form action="av-lm-cr__dropdown-order-form">
              <div class="av-lm-cr__dropdown-order js-av-lm-cr__dropdown-order">
                <div
                  class="av-lm-cr__dropdown-order-backdrop js-av-lm-cr__dropdown-order-backdrop av-theme__hidden"
                ></div>
                <div
                  class="av-lm-cr__dropdown-order-btn js-av-lm-cr__dropdown-order-btn"
                >
                  <span>Ordenado alfabéticamente</span>
                  <svg
                    width="24"
                    height="24"
                    viewBox="0 0 24 24"
                    fill="none"
                    xmlns="http://www.w3.org/2000/svg"
                    class="js-av-lm-cr__dropdown-order-svg"
                  >
                    <path
                      fill-rule="evenodd"
                      clip-rule="evenodd"
                      d="M12 16C12.2652 16 12.5196 15.8946 12.7071 15.7071L18.7071 9.70711C19.0976 9.31658 19.0976 8.68342 18.7071 8.29289C18.3166 7.90237 17.6834 7.90237 17.2929 8.29289L12 13.5858L6.70711 8.29289C6.31658 7.90237 5.68342 7.90237 5.29289 8.29289C4.90237 8.68342 4.90237 9.31658 5.29289 9.70711L11.2929 15.7071C11.4804 15.8946 11.7348 16 12 16Z"
                      fill="#101717"
                    />
                  </svg>
                </div>
                <div
                  class="av-lm-cr__dropdown-order-menu js-av-lm-cr__dropdown-order-menu av-theme__hidden"
                >
                  <label
                    class="js-av-lm-cr__dropdown-order-item"
                    href="#"
                  >
                    <input
                      type="radio"
                      name="opcionOrder"
                      value="label-alphabetical"
                      checked
                    />
                    Ordenado alfabéticamente
                  </label>
                  <label
                    class="js-av-lm-cr__dropdown-order-item"
                    href="#"
                  >
                    <input
                      type="radio"
                      name="opcionOrder"
                      value="label-date"
                    />
                    Ordenado por fecha
                  </label>
                  <label
                    class="js-av-lm-cr__dropdown-order-item"
                    href="#"
                  >
                    <input
                      type="radio"
                      name="opcionOrder"
                      value="label-variation"
                    />
                    Ordenado por variación porcentual
                  </label>
                </div>
              </div>
            </form>
          </div>
          <div class="av-lm-cr__row av-lm-cr__row--007" id="div_listaProductos">
            <!-- Iterar sobre la lista de InfoProductos directamente -->
            <c:set var="contador" value="0" />
            <fmt:parseNumber var="productosMostradosNumero" value="${productosMostrados}" integerOnly="true" />

            <c:forEach var="producto" items="${listaProductos}">
                <c:if test="${contador < productosMostradosNumero}">
                    <%@ include file="/card-list.jsp" %>
                    <c:set var="contador" value="${contador + 1}" />
                </c:if>
            </c:forEach>
          </div>
          <div class="av-lm__bottom-gradient"></div>
          <div class="av-lm-cr__row av-lm-cr__row--008">
            <div
              id="cargar-mas"
              class="av-theme__btn av-theme__btn--primary patata"
            >
              <span>Cargar más</span>
              <div class="av-theme__icon-box--24">
                <svg
                  width="25"
                  height="24"
                  viewBox="0 0 25 24"
                  fill="none"
                  xmlns="http://www.w3.org/2000/svg"
                >
                  <path
                    fill-rule="evenodd"
                    clip-rule="evenodd"
                    d="M12.5 4C13.0523 4 13.5 4.44772 13.5 5V16.5858L17.7929 12.2929C18.1834 11.9024 18.8166 11.9024 19.2071 12.2929C19.5976 12.6834 19.5976 13.3166 19.2071 13.7071L13.2071 19.7071C12.8166 20.0976 12.1834 20.0976 11.7929 19.7071L5.79289 13.7071C5.40237 13.3166 5.40237 12.6834 5.79289 12.2929C6.18342 11.9024 6.81658 11.9024 7.20711 12.2929L11.5 16.5858V5C11.5 4.44772 11.9477 4 12.5 4Z"
                    fill="white"
                  />
                </svg>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>

<script>

  let manageDraggable = function() {
    const draggableItems = document.querySelectorAll(
            '.av-lm-modal__ef-draggable-item'
    );
    let draggedItem = null;

    draggableItems.forEach((item) => {
      item.addEventListener('dragstart', () => {

        draggedItem = item;
        setTimeout(() => item.classList.add('av-lm-modal__ef-dragging'), 0);
      });

      item.addEventListener('dragend', () => {
        setTimeout(() => {
          draggedItem = null;
          item.classList.remove('av-lm-modal__ef-dragging');
        }, 0);
      });

      item.addEventListener('dragover', (e) => {
        e.preventDefault();
        const currentItem = getDragAfterElement(item, e.clientY);
        const draggableList = item.parentNode;
        if (currentItem == null) {
          draggableList.appendChild(draggedItem);
        } else {
          draggableList.insertBefore(draggedItem, currentItem);
        }
      });
    });

    function getDragAfterElement(container, y) {
      const draggableItems = [
        ...container.parentElement.querySelectorAll(
                '.av-lm-modal__ef-draggable-item:not(.av-lm-modal__ef-dragging)'
        ),
      ];

      return draggableItems.reduce(
              (closest, child) => {
                const box = child.getBoundingClientRect();
                const offset = y - box.top - box.height / 2;
                if (offset < 0 && offset > closest.offset) {
                  return {offset: offset, element: child};
                } else {
                  return closest;
                }
              },
              {offset: Number.NEGATIVE_INFINITY}
      ).element;
    }
  }

  //
  //
  //
  //
  //
  //
  //

  let activeGroupId = 'all'; // Guardar el grupo activo globalmente
  let inicio = Number('${productosMostrados}'); // Número inicial de productos mostrados
  let limite = Number('${incrementoProductos}');


    document.addEventListener('DOMContentLoaded', function() {
        inicializarComportamiento();
    });

    const cargarMasBtn = document.getElementById('cargar-mas');

  function inicializarComportamiento() {
    const tabs = document.querySelectorAll('.js-av-lm-cr__tab');
    const productos = Array.from(document.querySelectorAll('.av-lm-cr__card'));
    const totalElement = document.getElementById('total-resultados');
    const searchInput = document.querySelector('.av-lm-cr__search-input');
    const dropdownOrderBtn = document.querySelector(
      '.js-av-lm-cr__dropdown-order-btn span'
    );
    const dropdownOrderMenu = document.querySelector(
      '.js-av-lm-cr__dropdown-order-menu'
    );
    const dropdownOrderBackdrop = document.querySelector(
      '.js-av-lm-cr__dropdown-order-backdrop'
    );
    const dropdownOrderSvg = document.querySelector(
      '.js-av-lm-cr__dropdown-order-svg'
    );

    let criterioOrden = 'label-alphabetical'; // Criterio de ordenación por defecto
    let activeGroupId = 'all'; // Variable para almacenar el tab activo
    let productosMostrados = Number('${productosMostrados}'); // Número de productos a mostrar inicialmente
    const incrementoProductos = Number('${incrementoProductos}'); // Número de productos a cargar al hacer clic en "Cargar más"
    let productosFiltrados = productos; // Inicialmente, todos los productos están visibles

    const selectAllCheckbox = document.querySelector('input[value="all"]');
    const individualCheckboxes = document.querySelectorAll(
      '.js-av-lm-cr__dropdown-item input:not([value="all"])'
    );

    // Función para ocultar productos adicionales y controlar el botón "Cargar más"
    function ocultarProductosExtra() {
      productosFiltrados.forEach((producto, index) => {
        if (index < productosMostrados) {
          producto.style.display = 'flex';
        } else {
          producto.style.display = 'none';
        }
      });

      //if (productosFiltrados.length > productosMostrados) {
      //  cargarMasBtn.style.display = 'flex';
      //} else {
      //  cargarMasBtn.style.display = 'none';
      //}
    }

    // Función para mostrar más productos
    function mostrarMasProductos() {
      let mostrar = Math.min(
        productosFiltrados.length - productosMostrados,
        incrementoProductos
      );

      for (let i = productosMostrados; i < productosMostrados + mostrar; i++) {
        if (productosFiltrados[i]) {
          productosFiltrados[i].style.display = 'flex'; // Mostrar el producto
        }
      }

      productosMostrados += mostrar;

      // Ocultar el botón si no quedan más productos por mostrar
      //if (productosMostrados >= productosFiltrados.length) {
      //  cargarMasBtn.style.display = 'none';
      //}else{
      //  cargarMasBtn.style.display = 'flex';
      //}
    }

    // Inicializar la vista con productos limitados
    ocultarProductosExtra();

    // Manejar el botón "Cargar más" para obtener más productos del grupo activo
    cargarMasBtn.addEventListener('click', function () {
        var formData = new FormData();
        formData.append('<portlet:namespace/>groupId', activeGroupId); // Usar el grupo activo
        formData.append('<portlet:namespace/>inicio', inicio); // Enviar el inicio actual
        formData.append('<portlet:namespace/>limite', limite); // Enviar el límite
        formData.append('<portlet:namespace/>criterioOrden', criterioOrden); // Enviar el criterio de orden actual

        // Añadir lonjas seleccionadas si están presentes
        const lonjasSeleccionadas = Array.from(document.querySelectorAll('.js-av-lm-cr__dropdown-item input:checked'))
            .map((checkbox) => checkbox.value);
        formData.append('<portlet:namespace/>lonjasSeleccionadas', lonjasSeleccionadas.join(',')); // Enviar lonjas seleccionadas

        // Añadir término de búsqueda si está presente
        const searchTerm = searchInput.value.toLowerCase().trim();
        formData.append('<portlet:namespace/>searchTerm', searchTerm); // Enviar el término de búsqueda

        $.ajax({
            url: '${obtenerLonjasProductos}', // URL del recurso
            type: 'POST',
            data: formData,
            datatype: 'json',
            cache: false,
            contentType: false,
            processData: false,
            error: function (xhr, status, error) {
                console.warn("ERROR al cargar más productos");
            },
            success: function (data, textStatus, jqXHR) {
                $('#div_listaProductos').append(data);
                inicio += limite; // Actualizar el contador de inicio

                manejarRespuestaAjax(data, jqXHR); // Usar la función para manejar la respuesta
            }
        });
    });

    // Función para filtrar productos por lonjas, búsqueda y tab seleccionado
    function filtrarProductos() {
        productosMostrados = Number('${productosMostrados}'); // Reiniciar el conteo de productos mostrados
        const lonjasSeleccionadas = Array.from(
            document.querySelectorAll('.js-av-lm-cr__dropdown-item input:checked')
        ).map((checkbox) => checkbox.value);
        const searchTerm = searchInput.value.toLowerCase().trim();

        // Aplicar siempre los filtros de lonjas y tabs
        productosFiltrados = productos.filter((producto) => {
            const lonjaIdProducto = producto
                .querySelector('.av-lm-cr__card-market')
                .getAttribute('data-lonja-id');
            const productoGroupId = producto.getAttribute('data-group-id');

            const coincideLonja =
                lonjasSeleccionadas.length === 0 ||
                lonjasSeleccionadas.includes(lonjaIdProducto) ||
                selectAllCheckbox.checked;

            const coincideTab =
                activeGroupId === 'all' || productoGroupId === activeGroupId;

            // Retornar los productos que coinciden con lonjas y tab seleccionado
            return coincideLonja && coincideTab;
        });

        // Aplicar la búsqueda si el término tiene 3 o más caracteres
        if (searchTerm.length >= 3) {
            const searchWords = searchTerm.split(/\s+/); // Separa por espacios

            productosFiltrados = productosFiltrados.filter((producto) => {
                const nombreProducto = producto
                    .querySelector('.av-lm-cr__card-column--002 span')
                    .innerText.toLowerCase();

                // Comprobar si todas las palabras del término de búsqueda están presentes en el nombre del producto
                return searchWords.every(word => nombreProducto.includes(word));
            });
        }

        // Mostrar todos los productos si el campo de búsqueda está vacío
        if (searchTerm === '') {
            productosFiltrados = productos.filter((producto) => {
                const lonjaIdProducto = producto
                    .querySelector('.av-lm-cr__card-market')
                    .getAttribute('data-lonja-id');
                const productoGroupId = producto.getAttribute('data-group-id');

                const coincideLonja =
                    lonjasSeleccionadas.length === 0 ||
                    lonjasSeleccionadas.includes(lonjaIdProducto) ||
                    selectAllCheckbox.checked;

                const coincideTab =
                    activeGroupId === 'all' || productoGroupId === activeGroupId;

                return coincideLonja && coincideTab;
            });
        }

        productos.forEach((producto) => (producto.style.display = 'none')); // Ocultar todos los productos
        productosFiltrados.forEach((producto) => (producto.style.display = 'flex')); // Mostrar los productos filtrados

        const totalProductosVisibles = productosFiltrados.length;
        totalElement.innerHTML = '&nbsp;' + totalProductosVisibles + '&nbsp;';

        // Verificar si hay menos productos después del filtro para ocultar el botón de cargar más
        if (totalProductosVisibles <= productosMostrados) {
            cargarMasBtn.style.display = 'none';
        } else {
            cargarMasBtn.style.display = 'flex';
        }
    }


    // Función para ordenar productos visibles
    function ordenarProductos() {
      switch (criterioOrden) {
        case 'label-alphabetical':
          productosFiltrados.sort((a, b) => {
            const nombreA = a
                    .querySelector('.av-lm-cr__card-column--002 span')
                    .innerText.trim();
            const nombreB = b
                    .querySelector('.av-lm-cr__card-column--002 span')
                    .innerText.trim();
            return nombreA.localeCompare(nombreB);
          });
          break;
        case 'label-date':
          productosFiltrados.sort((a, b) => {
            const fechaA = new Date(
                    a.querySelector('.av-lm-cr__card-date-hidden').value
            );
            const fechaB = new Date(
                    b.querySelector('.av-lm-cr__card-date-hidden').value
            );
            return fechaB - fechaA; // Orden descendente por fecha
          });
          break;
        case 'label-variation':
          productosFiltrados.sort((a, b) => {
            const variacionA = parseFloat(
                    a.querySelector('.av-lm-cr__card-variation span').innerText.replace(/[^0-9.-]+/g, '') // Remover cualquier caracter no numérico
            );
            const variacionB = parseFloat(
                    b.querySelector('.av-lm-cr__card-variation span').innerText.replace(/[^0-9.-]+/g, '')
            );
            return variacionB - variacionA; // Orden descendente por variación porcentual
          });
          break;
      }

      // Reordenar los productos en el DOM según el array ordenado
      const container = document.querySelector('.av-lm-cr__row--007');
      container.innerHTML = '';
      productosFiltrados.forEach(producto => container.appendChild(producto));

      ocultarProductosExtra(); // Ocultar productos adicionales después de ordenar
    }

    // Función para aplicar los filtros y ordenar productos cuando se carga la página por primera vez
    function inicializarProductos() {
      productosFiltrados = productos; // Todos los productos están visibles al inicio
      ordenarProductos(); // Aplicar el orden por defecto
      ocultarProductosExtra(); // Mostrar solo los primeros productos
    }

    // Manejar el checkbox "Todas las lonjas"
    selectAllCheckbox.addEventListener('change', function () {
      if (this.checked) {
        // Desmarcar todas las lonjas individuales
        individualCheckboxes.forEach((checkbox) => {
          checkbox.checked = false;
        });
      }
      filtrarProductos();
      ordenarProductos();
      actualizarTextoLonjas(); // Actualizar el texto del botón
    });

    // Manejar cambio en los checkboxes de lonjas individuales
    individualCheckboxes.forEach((checkbox) => {
        checkbox.addEventListener('change', function () {
            // Si se selecciona una lonja individual, desmarcar "Todas las lonjas"
            if (this.checked) {
                selectAllCheckbox.checked = false;
            }

            // Obtener las lonjas seleccionadas
            const lonjasSeleccionadas = Array.from(
                document.querySelectorAll('.js-av-lm-cr__dropdown-item input:checked')
            ).map((checkbox) => checkbox.value);

            const searchTerm = searchInput.value.toLowerCase().trim();

            // Realizar la petición AJAX para obtener los productos filtrados por lonjas seleccionadas
            var formData = new FormData();
            formData.append('<portlet:namespace/>groupId', activeGroupId); // Mantener el grupo activo
            formData.append('<portlet:namespace/>lonjasSeleccionadas', lonjasSeleccionadas.join(',')); // Enviar lonjas seleccionadas
            formData.append('<portlet:namespace/>criterioOrden', criterioOrden); // Mantener el criterio de orden actual
            formData.append('<portlet:namespace/>inicio', inicio); // Agregar inicio
            formData.append('<portlet:namespace/>limite', limite); // Agregar limite
            formData.append('<portlet:namespace/>searchTerm', searchTerm); // Enviar el término de búsqueda

            $.ajax({
                url: '${obtenerLonjasProductos}', // URL del recurso para obtener productos filtrados
                type: 'POST',
                data: formData,
                datatype: 'json',
                cache: false,
                contentType: false,
                processData: false,
                error: function (xhr, status, error) {
                    console.warn("ERROR al filtrar productos por lonjas");
                },
                success: function (data, textStatus, jqXHR) {
                    // Reemplazar el contenido actual de los productos con los nuevos productos obtenidos
                    $('#div_listaProductos').html(data);
                    inicio = limite; // Reiniciar el contador para el botón "Cargar más";

                    var totalResultados = jqXHR.getResponseHeader('X-Total-Resultados');
                    totalResultados = totalResultados ? totalResultados.trim() : totalResultados;
                    if (totalResultados) {
                        $('#total-resultados').html('&nbsp;' + totalResultados + '&nbsp;');
                    }

                    manejarRespuestaAjax(data, jqXHR);
                }
            });

            actualizarTextoLonjas();
        });
    });


    // Manejar clic en los tabs
    tabs.forEach((tab) => {
        tab.addEventListener('click', function () {
            activeGroupId = tab.getAttribute('data-group-id'); // Guardar el grupo seleccionado

            // Obtener las lonjas seleccionadas
            const lonjasSeleccionadas = Array.from(
                document.querySelectorAll('.js-av-lm-cr__dropdown-item input:checked')
            ).map((checkbox) => checkbox.value);

            // Obtener el término de búsqueda
            const searchTerm = searchInput.value.toLowerCase().trim();

            // Realizar la petición AJAX para obtener los productos filtrados por grupo
            var formData = new FormData();
            formData.append('<portlet:namespace/>groupId', activeGroupId); // Mantener el grupo seleccionado
            formData.append('<portlet:namespace/>lonjasSeleccionadas', lonjasSeleccionadas.join(',')); // Enviar lonjas seleccionadas
            formData.append('<portlet:namespace/>inicio', 0); // Reiniciar desde 0
            formData.append('<portlet:namespace/>limite', limite); // Cargar inicialmente el límite
            formData.append('<portlet:namespace/>searchTerm', searchTerm); // Enviar el término de búsqueda
            formData.append('<portlet:namespace/>criterioOrden', criterioOrden); // Enviar el criterio de orden actual

            $.ajax({
                url: '${obtenerLonjasProductos}', // URL del recurso
                type: 'POST',
                data: formData,
                datatype: 'json',
                cache: false,
                contentType: false,
                processData: false,
                error: function (xhr, status, error) {
                    console.warn("ERROR al obtener los productos");
                },
                success: function (data, textStatus, jqXHR) {
                    $('#div_listaProductos').html(data);
                    inicio = limite;

                    var totalResultados = jqXHR.getResponseHeader('X-Total-Resultados');
                    totalResultados = totalResultados ? totalResultados.trim() : totalResultados;
                    if (totalResultados) {
                        $('#total-resultados').html('&nbsp;' + totalResultados + '&nbsp;');
                    }

                    manejarRespuestaAjax(data, jqXHR);
                }
            });

            // Cambiar la clase del tab seleccionado
            tabs.forEach((tab) => tab.classList.remove('av-lm-cr__tab-selected'));
            this.classList.add('av-lm-cr__tab-selected');
        });
    });


    //const searchInput = document.getElementById('buscar-productos');

    // Manejar búsqueda en el input
    // Manejar búsqueda en el input
    searchInput.addEventListener('input', function () {
        const searchTerm = searchInput.value.toLowerCase().trim();

        var formData = new FormData();
        formData.append('<portlet:namespace/>groupId', activeGroupId); // Mantener el grupo activo
        formData.append('<portlet:namespace/>inicio', 0); // Reiniciar desde 0
        formData.append('<portlet:namespace/>limite', limite); // Enviar el límite actual
        formData.append('<portlet:namespace/>criterioOrden', criterioOrden); // Enviar el criterio de orden actual
        formData.append('<portlet:namespace/>searchTerm', searchTerm); // Enviar el término de búsqueda

        // Si hay lonjas seleccionadas, enviar esas también
        const lonjasSeleccionadas = Array.from(
            document.querySelectorAll('.js-av-lm-cr__dropdown-item input:checked')
        ).map((checkbox) => checkbox.value);

        formData.append('<portlet:namespace/>lonjasSeleccionadas', lonjasSeleccionadas.join(','));

        // Realizar la petición AJAX para filtrar productos por el término de búsqueda y otros filtros
        $.ajax({
            url: '${obtenerLonjasProductos}', // URL del recurso para obtener productos filtrados
            type: 'POST',
            data: formData,
            datatype: 'json',
            cache: false,
            contentType: false,
            processData: false,
            error: function (xhr, status, error) {
                console.warn("ERROR al filtrar productos por búsqueda");
            },
            success: function (data, textStatus, jqXHR) {
                $('#div_listaProductos').html(data);
                inicio = limite;

                var totalResultados = jqXHR.getResponseHeader('X-Total-Resultados');
                totalResultados = totalResultados ? totalResultados.trim() : totalResultados;
                if (totalResultados) {
                    $('#total-resultados').html('&nbsp;' + totalResultados + '&nbsp;');
                }

                manejarRespuestaAjax(data, jqXHR);
            }
        });
    });


    // Manejar cambio en el criterio de ordenación y actualizar el texto del dropdown
    document.querySelectorAll('input[name="opcionOrder"]').forEach((radio) => {
        radio.addEventListener('change', function () {
            criterioOrden = this.value;

            // Actualizar el texto del botón del dropdown
            const selectedLabel = this.closest('label').textContent.trim();
            dropdownOrderBtn.textContent = selectedLabel;

            const searchTerm = searchInput.value.toLowerCase().trim();

            // Realizar la petición AJAX para obtener los productos ordenados
            var formData = new FormData();
            formData.append('<portlet:namespace/>groupId', activeGroupId); // Mantener el grupo seleccionado
            formData.append('<portlet:namespace/>inicio', 0); // Reiniciar desde 0
            formData.append('<portlet:namespace/>limite', limite); // Cargar inicialmente el límite
            formData.append('<portlet:namespace/>criterioOrden', criterioOrden); // Enviar el criterio de ordenación seleccionado
            formData.append('<portlet:namespace/>searchTerm', searchTerm); // Enviar el término de búsqueda

            $.ajax({
                url: '${obtenerLonjasProductos}', // URL del recurso
                type: 'POST',
                data: formData,
                datatype: 'json',
                cache: false,
                contentType: false,
                processData: false,
                error: function (xhr, status, error) {
                    console.warn("ERROR al obtener los productos ordenados");
                },
                success: function (data, textStatus, jqXHR) {
                    $('#div_listaProductos').html(data);
                    inicio = limite;

                    var totalResultados = jqXHR.getResponseHeader('X-Total-Resultados');
                    totalResultados = totalResultados ? totalResultados.trim() : totalResultados;
                    if (totalResultados) {
                        $('#total-resultados').html('&nbsp;' + totalResultados + '&nbsp;');
                    }

                    manejarRespuestaAjax(data, jqXHR);
                }
            });

            dropdownOrderMenu.classList.add('av-theme__hidden');
            dropdownOrderBackdrop.classList.add('av-theme__hidden');
            dropdownOrderSvg.classList.remove('av-theme__rotate-180');
        });
    });

    // Función para manejar la respuesta AJAX y verificar si ocultar el botón "Cargar más"
    function manejarRespuestaAjax(data, jqXHR) {
        // Obtener el total de resultados desde el encabezado de la respuesta
        var totalResultados = jqXHR.getResponseHeader('X-Total-Resultados');
        totalResultados = totalResultados ? parseInt(totalResultados.trim()) : 0;

        // Verificar si no hay más productos que mostrar
        if (inicio >= totalResultados) {
            // Ocultar el botón "Cargar más" si no hay más productos
            cargarMasBtn.style.display = 'none';
        } else {
            // Mostrar el botón si hay más productos para cargar
            cargarMasBtn.style.display = 'flex';
        }
    }


    // Función para actualizar el texto del botón de selección de lonjas y el contador
    function actualizarTextoLonjas() {
      const lonjasSeleccionadas = document.querySelectorAll(
        '.js-av-lm-cr__dropdown-item input:checked:not([value="all"])'
      );
      const textoSeleccionLonjas = document.getElementById(
        'texto-seleccion-lonjas'
      );
      const contadorLonjas = document.getElementById('contador-lonjas');

      // Si no hay lonjas seleccionadas, mostrar el texto por defecto
      if (lonjasSeleccionadas.length === 0) {
        textoSeleccionLonjas.textContent = 'Seleccionar Lonjas';
        contadorLonjas.textContent = ''; // Vaciar el contador si no hay lonjas seleccionadas
        contadorLonjas.style.display = 'none'; // Ocultar el contador
      } else {
        textoSeleccionLonjas.textContent = 'Lonjas Seleccionadas';
        contadorLonjas.textContent = lonjasSeleccionadas.length; // Mostrar el número de lonjas seleccionadas
        contadorLonjas.style.display = 'flex'; // Mostrar el contador
      }
    }

    // Función para actualizar el texto del botón de selección de lonjas y el contador
    function actualizarTextoLonjas() {
        const lonjasSeleccionadas = document.querySelectorAll('.js-av-lm-cr__dropdown-item input:checked:not([value="all"])');
        const textoSeleccionLonjas = document.getElementById('texto-seleccion-lonjas');
        const contadorLonjas = document.getElementById('contador-lonjas');

        // Si no hay lonjas seleccionadas, mostrar el texto por defecto
        if (lonjasSeleccionadas.length === 0) {
            textoSeleccionLonjas.textContent = "Seleccionar Lonjas";
            contadorLonjas.textContent = ''; // Vaciar el contador si no hay lonjas seleccionadas
            contadorLonjas.style.display = 'none'; // Ocultar el contador
        } else {
            textoSeleccionLonjas.textContent = "Lonjas Seleccionadas";
            contadorLonjas.textContent = lonjasSeleccionadas.length; // Mostrar el número de lonjas seleccionadas
            contadorLonjas.style.display = 'flex'; // Mostrar el contador
        }
    }

    // Inicializar los productos cuando la página se carga por primera vez
    inicializarProductos();

    // Scroll horizontal con el raton en las Tabs de la columna derecha (productos).
    makeSliderDraggable('.js-av-lm-cr__tabs');
    // Scroll horizontal con el raton en las Tabs de la columna izquierda (favoritos).
    makeSliderDraggable('.js-av-lm-cl__favorites-tabs');

    const editFavorites = document.querySelector('.av-lm-cl__edit-btn');
    const modalButtonsFavorites = [
      {
        text: 'Cancelar',
        classes: ['av-theme__btn', 'av-theme__btn--secondary'],
        callback: (modal) => { closeModal(modal); },
      },
      {
        text: 'Guardar',
        classes: ['av-theme__btn', 'av-theme__btn--primary'],
        callback: (modal) => {
          const form = document.getElementById('<portlet:namespace/>formFavorites');
          const formData = new FormData(form);
          fetch(form.action, { method: form.method, body: formData,
          }).then(response => { listarFavoritos(true); closeModal(modal); openNotification('<liferay-ui:message key="avanis.lonjas.producto.seguimiento.de.precio.actualizado" />', 'succes');
          }).catch(error => { closeModal(modal);
          });
        },
      },
    ];

    if(editFavorites){
        editFavorites.addEventListener('click', () => {
          <portlet:renderURL var="editarProductoFavoritosUserURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
          <portlet:param name="mvcRenderCommandName" value="render_cmd_command" />
          <portlet:param name="<%=Constants.CMD%>" value="editar_producto_favoritos" />
          </portlet:renderURL>

          fetch('<%=editarProductoFavoritosUserURL%>').then(response => {
            return response.text();
          }).then(function (html) {
            openModal(html, '<liferay-ui:message key="avanis.lonjas.producto.editar.favoritos" />', modalButtonsFavorites, 'global', manageDraggable);
          }).catch(error => {
            console.warn('Something went wrong.', error);
          });
        });
    }
  };

  function addToFavorite(element, idLonja, productoId){
    <portlet:resourceURL var="addProductoUserURL" id="resource_cmd_command">
      <portlet:param name="<%=Constants.CMD%>" value="addProductoUser"/>
    </portlet:resourceURL>
    <portlet:resourceURL var="deleteProductoUserURL" id="resource_cmd_command">
      <portlet:param name="<%=Constants.CMD%>" value="deleteProductoUser"/>
    </portlet:resourceURL>

    let urlToSend = '<%=addProductoUserURL%>';
    if (!element.checked) {
      urlToSend = '<%=deleteProductoUserURL%>';
    }
    urlToSend = urlToSend + '&<portlet:namespace/>idLonja='+idLonja+'&<portlet:namespace/>productoId='+productoId;

    fetch(urlToSend, {method: 'post'
    }).then(response => {
      listarFavoritos(false);
      if (element.checked) {
        openNotification('<liferay-ui:message key="avanis.lonjas.producto.seguimiento.de.precio.anadido" />', 'succes');
      } else {
        openNotification('<liferay-ui:message key="avanis.lonjas.producto.seguimiento.de.precio.quitado" />', 'succes');
      }
    }).catch(error => {
      console.warn('Something went wrong.', error);
    });
  }

  function deleteProductoUserModal(entityId) {
    document.querySelector('.producto-modal-' + entityId).remove();
  }
</script>
