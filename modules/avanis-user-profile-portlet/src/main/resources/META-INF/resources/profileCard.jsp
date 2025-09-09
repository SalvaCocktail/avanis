<%@ include file="./init.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<portlet:actionURL var="setUserVisibilityURL" name="setUserVisibility"/>
<portlet:actionURL var="followURL" name="follow"/>
<portlet:actionURL var="unfollowURL" name="unfollow"/>
<script src="<%=request.getContextPath()%>/js/jquery-3.7.1.min.js"></script>


<div class="modal-cancelar-peticion">
    <div id="alertModalProfile" class="av-te-ma-modal">
        <div class="av-te-ma-modal__panel">
            <div class="av-te-ma-modal__header">
                <img class="left-arrow" src="<%=request.getContextPath()%>/images/arrow-left.png" alt="left-arrow" />
                <h5 class="modal-title" id="exampleModalLabelC" style="text-align: center">Añadir foto</h5>
                <span class="av-icon-close">&times;</span>
            </div>
            <div class="av-te-ma-modal__content" style="height: 674px;">
                <div style="height: 300px;">
                <img id="cloud" src="<%=request.getContextPath()%>/images/Vector.png" alt="cloud" style="cursor: pointer"/>
                <input type="file" id="inputImageP" accept="image/*" style="display: none">
                <img id="imageP" style="max-width: 100%; display: none;">
                    <p class="parrafo-imagen-previa">Imagen previa</p>
                <img id="croppedImageP" style="max-width: 100%; display: none;">
                <button class="profile__button--edit " id="anadir-foto">
                    <span class="profile__icon profile__icon--edit" style="background-image: url('<%= request.getContextPath() %>/images/camera.png');"></span>
                        <p>Añadir foto</p>
                </button>
                <div class="btn-recortar-guardar-foto">
                    <button type="button" class="profile__button" id="cropButtonP" style="display: none;">Recortar</button>
                    <button type="button" class="profile__button" id="saveButtonP" style="display: none;">Guardar</button>
                </div>
                </div>
            </div>
        </div>

    </div>
</div>


<div class="profile-card">
    <div class="profile-photo-container">
        <%-- TODO: FALTA Lógica de actualizar imagen de perfil --%>
        <div class="profile-upload-photo">
        <c:if test="${me}">
        <span class="iconBadge" id="openCameraButton" alt="Upload icon">
				
		</span>
        </c:if>
    </div>
    <div class="av-user-photo">

        <c:set var="firstName" value="${fn:trim(fn:substringBefore(name, ' '))}" />
        <c:set var="secondName" value="${fn:trim(fn:substring(apellidos, 0, 1))}" />
        <c:set var="initials" value="${fn:toUpperCase(fn:substring(firstName, 0, 1))}${fn:toUpperCase(fn:substring(secondName, 0, 1))}" />

        <c:choose>
            <c:when test="${fn:contains(profileImage, '/image/user_portrait?img_id=0')}">
                <style>
                    .iconProfilePicture{
                        background-color: #122C1F;
                    }
                </style>
                <span class="iconProfilePicture" alt="profilePhoto">
                    <p style="
                        text-align: center;
                        top: 45px;
                        font-size: 47px;
                        left: 8px;
                        font-weight: 700;
                        color: white;
                        padding-top: 1em;
                    ">${initials}</p>
                </span>
            </c:when>
            <c:otherwise>
                <span class="iconProfilePicture" alt="profilePhoto" style="background-image: url(${profileImage};);">
                </span>
            </c:otherwise>
        </c:choose>
        <%--
        <div class="av-donut">
            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 100 100">
                <circle class="background" cx="50" cy="50" r="45"></circle>
                <circle class="progress" cx="50" cy="50" r="48"></circle>
            </svg>
        </div>
        --%>
    </div>
</div>
<!-- Personal data -->
<div class="profile-info">
    <div class="profile-details">
        <h2 class="profile-name">${name}</h2>
        <%
            try {
                String dedicationLevel = (String) request.getAttribute("dedication_level");
                String capitalizedDedicationLevel = "";

                if (dedicationLevel != null && !dedicationLevel.isEmpty()) {
                    capitalizedDedicationLevel = dedicationLevel.substring(0, 1).toUpperCase() + dedicationLevel.substring(1);
                    if ("amateur".equalsIgnoreCase(dedicationLevel)) {
                        capitalizedDedicationLevel = "Aficionado";
                    }
                    if ("professional".equalsIgnoreCase(dedicationLevel)) {
                        capitalizedDedicationLevel = "Profesional";
                    }
                }

                // Asegúrate de que la variable esté disponible para JSTL
                pageContext.setAttribute("capitalizedDedicationLevel", capitalizedDedicationLevel);
        %>

        <p>
            <%= capitalizedDedicationLevel %>
            <c:choose>
                <c:when test="${capitalizedDedicationLevel eq 'Profesional' and not empty professions}">
                    en
                </c:when>
                <c:when test="${capitalizedDedicationLevel eq 'Aficionado' and not empty professions}">
                    a
                </c:when>
                <c:otherwise>

                </c:otherwise>
            </c:choose>

            <c:choose>
                <c:when test="${not empty professions}">
                    <!-- Crear la lista de profesiones -->
                    <c:set var="professionList" value="" />
                    <c:forEach var="profession" items="${professions}" varStatus="status">
                        <c:if test="${status.index > 0}">
                            <c:choose>
                                <c:when test="${status.index == fn:length(professions) - 1}">
                                    <c:choose>
                                        <c:when test="${fn:length(professions) > 1}">
                                            <c:set var="professionList" value="${professionList} y ${profession.name.toLowerCase()}" />
                                        </c:when>
                                        <c:otherwise>
                                            <c:set var="professionList" value="${profession.name.toLowerCase()}" />
                                        </c:otherwise>
                                    </c:choose>
                                </c:when>
                                <c:otherwise>
                                    <c:set var="professionList" value="${professionList}, ${profession.name.toLowerCase()}" />
                                </c:otherwise>
                            </c:choose>
                        </c:if>
                        <c:if test="${status.index == 0}">
                            <c:set var="professionList" value="${profession.name.toLowerCase()}" />
                        </c:if>
                    </c:forEach>
                    ${professionList}
                </c:when>
                <c:otherwise>

                </c:otherwise>
            </c:choose>
        </p>

        <%
        } catch (Exception e) {
            e.printStackTrace();
        %>
        <p>Error</p>
        <%
            }
        %>


        <%-- CHIP PROFESIONAL AMATEUR --%>
            <%
                try {
                    String dedicationLevel = (String) request.getAttribute("dedication_level");

                    if (dedicationLevel != null && !dedicationLevel.isEmpty()) {
                        String capitalizedDedicationLevel = dedicationLevel.substring(0, 1).toUpperCase() + dedicationLevel.substring(1);
                        if ("amateur".equalsIgnoreCase(dedicationLevel)) {
                            capitalizedDedicationLevel = "Aficionado";
                        }
                        if ("professional".equalsIgnoreCase(dedicationLevel)) {
                            capitalizedDedicationLevel = "Profesional";
                        }


            %>

        <div class="profile-tag">
        <svg width="11" height="14" viewBox="0 0 11 14" fill="none" xmlns="http://www.w3.org/2000/svg">
            <path fill-rule="evenodd" clip-rule="evenodd"
                  d="M5.50011 1.66668C4.39554 1.66668 3.50011 2.56211 3.50011 3.66668C3.50011 4.77125 4.39554 5.66668 5.50011 5.66668C6.60468 5.66668 7.50011 4.77125 7.50011 3.66668C7.50011 2.56211 6.60468 1.66668 5.50011 1.66668ZM2.16678 3.66668C2.16678 1.82573 3.65916 0.333344 5.50011 0.333344C7.34106 0.333344 8.83344 1.82573 8.83344 3.66668C8.83344 5.50763 7.34106 7.00001 5.50011 7.00001C3.65916 7.00001 2.16678 5.50763 2.16678 3.66668ZM2.91966 8.99992C2.8779 8.99681 2.85305 8.99745 2.69461 9.00952C2.65108 9.01284 2.62023 9.01694 2.59592 9.02134C2.04874 9.12039 1.6205 9.54864 1.52144 10.0958C1.5028 10.1988 1.50011 10.3365 1.50011 10.7894V11.9333C1.50011 12.131 1.50063 12.2392 1.50698 12.3169C1.50723 12.32 1.50749 12.3229 1.50774 12.3257C1.51051 12.326 1.51344 12.3262 1.51653 12.3265C1.59426 12.3328 1.70243 12.3333 1.90011 12.3333H9.10011C9.29779 12.3333 9.40596 12.3328 9.48369 12.3265C9.48678 12.3262 9.48971 12.326 9.49248 12.3257C9.49273 12.3229 9.49299 12.32 9.49324 12.3169C9.49959 12.2392 9.50011 12.131 9.50011 11.9333V10.7858C9.50011 10.3365 9.49746 10.1998 9.47912 10.0977C9.38058 9.549 8.95112 9.11953 8.40245 9.021C8.37897 9.01678 8.34867 9.01278 8.30572 9.00952C8.14709 8.99746 8.12219 8.99682 8.08046 8.99994C8.04105 9.00288 8.0244 9.00527 8.01398 9.00711C8.00356 9.00895 7.98709 9.0124 7.94906 9.02313C7.953 9.02202 7.94556 9.02394 7.92028 9.03374C7.89609 9.04311 7.86303 9.05675 7.81732 9.0765C7.72478 9.1165 7.60048 9.17278 7.42399 9.25273C6.83654 9.51884 6.18469 9.66667 5.50011 9.66667C4.81553 9.66667 4.16368 9.51884 3.57623 9.25273C3.39972 9.17277 3.27542 9.11649 3.18287 9.07649C3.13715 9.05673 3.10409 9.04309 3.07989 9.03372C3.05983 9.02595 3.05101 9.02313 3.05018 9.02286C3.04997 9.02278 3.0503 9.02288 3.05111 9.02311C3.0131 9.01239 2.99661 9.00894 2.98616 9.00709C2.97571 9.00525 2.95903 9.00285 2.91966 8.99992ZM2.61348 7.6785C2.74693 7.66827 2.86766 7.65902 3.01871 7.67027C3.16734 7.68134 3.26963 7.69939 3.41307 7.73985C3.56009 7.78132 3.7756 7.87908 4.05442 8.00556C4.07797 8.01624 4.10197 8.02713 4.12641 8.0382C4.54444 8.22757 5.00902 8.33334 5.50011 8.33334C5.9912 8.33334 6.45578 8.22757 6.87381 8.0382C6.89826 8.02713 6.92225 8.01624 6.9458 8.00556C7.22459 7.87909 7.44006 7.78135 7.58702 7.73989C7.73045 7.69943 7.83263 7.68139 7.98125 7.6703C8.13224 7.65903 8.25303 7.66827 8.38656 7.67848C8.39327 7.67899 8.40002 7.67951 8.4068 7.68002C8.48468 7.68594 8.56105 7.69482 8.63812 7.70866C9.73547 7.90573 10.5944 8.76465 10.7915 9.86199C10.8337 10.0972 10.8336 10.3639 10.8335 10.7236C10.8334 10.744 10.8334 10.7648 10.8334 10.7858L10.8334 11.9546C10.8335 12.1229 10.8335 12.2867 10.8221 12.4255C10.8097 12.5779 10.7803 12.7577 10.6881 12.9387C10.5603 13.1895 10.3563 13.3935 10.1054 13.5213C9.92448 13.6135 9.74466 13.6429 9.59226 13.6554C9.45349 13.6667 9.28964 13.6667 9.12138 13.6667H1.87883C1.71058 13.6667 1.54673 13.6667 1.40796 13.6554C1.25556 13.6429 1.07574 13.6135 0.894791 13.5213C0.643909 13.3935 0.439934 13.1895 0.312103 12.9387C0.219905 12.7577 0.190526 12.5779 0.178075 12.4255C0.166737 12.2867 0.166757 12.1229 0.166777 11.9546L0.166778 10.7894C0.166778 10.7682 0.16677 10.7473 0.166763 10.7267C0.166628 10.3641 0.166528 10.0953 0.209431 9.8583C0.40755 8.76394 1.26404 7.90745 2.3584 7.70933C2.43665 7.69516 2.51407 7.68608 2.59328 7.68004C2.60005 7.67953 2.60678 7.67901 2.61348 7.6785Z"
                  fill="#101717"/>
        </svg>
            <p><%= capitalizedDedicationLevel %></p></div>
            <%
            } else {
            %>
            <%-- <p>Ninguno</p> --%>
            <%
                }
            } catch (Exception e) {

            %>
            <p>Error</p>
            <%
                }
            %>


    </div>


    <!-- Dropdown -->
    <div class="dropdown">
        <c:choose>
            <c:when test="${me}">
                <div>
                    <p class="profile-title">Audiencia de mi perfil</p>
                </div>

                <div class="av-pc__fake-input-profile-visibility av-pc__fipv js-av-pc__fake-input-profile-visibility ${visibility}">
                  <div class="av-theme__icon-box-24 av-pc__fake-input-variable-icon"></div>
                  <div class="js-av-pc__fipv-text av-pc__fipv-text av-pc__fipv-text--${visibility == 'public' ? 'public' : 'hidden'}">
                    Público - Visible en toda la red
                  </div>
                  <div class="js-av-pc__fipv-text av-pc__fipv-text av-pc__fipv-text--${visibility == 'registered' ? 'registered' : 'hidden'}">
                    Privado - Sólo miembros de Avanis
                  </div>
                  <div class="js-av-pc__fipv-text av-pc__fipv-text av-pc__fipv-text--${visibility == 'followers' ? 'followers' : 'hidden'}">
                    Privado Plus - Sólo visible para mis seguidores
                  </div>

                  <div class="av-theme__icon-box-24 av-pc__fake-input-chevron-icon">
                    <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                      <path fill-rule="evenodd" clip-rule="evenodd" d="M12 16C12.2652 16 12.5196 15.8946 12.7071 15.7071L18.7071 9.70711C19.0976 9.31658 19.0976 8.68342 18.7071 8.29289C18.3166 7.90237 17.6834 7.90237 17.2929 8.29289L12 13.5858L6.70711 8.29289C6.31658 7.90237 5.68342 7.90237 5.29289 8.29289C4.90237 8.68342 4.90237 9.31658 5.29289 9.70711L11.2929 15.7071C11.4804 15.8946 11.7348 16 12 16Z" fill="#101717"/>
                    </svg>
                  </div>
                </div>
                
                <div class="js-av-pc__modal-content av-theme__hidden">
                  <h4 class="av-pc__modal-body-title">¿Quién puede ver tu perfil?</h4>
                  <p class="av-pc__modal-body-subtitle">La audiencia predeterminada está configurada como 
                    <span class="av-pc__public-profile-audience js-av-pc__public-profile-audience">
                      pública.
                    </span>
                  </p>
                  <form action="${setUserVisibilityURL}" method="post" class="av-pc__modal-user-visibility-form">
                    <aui:input type="hidden" value="${focusedTab}" name="focusedTab" id="focused-tab-visibility-form"/>

                    <label class="av-pc__modal-user-visibility-label">
                      <input type="radio" name="<portlet:namespace />visibilityOptions" value="public" ${visibility=="public" ? 'checked="checked"' : '' } class="av-pc__modal-user-visibility-radio">
                      <div class="av-pc__modal-user-visibility-texts">
                        <span class="av-pc__modal-user-visibility-text-option">
                          Público
                        </span>
                        <span class="av-pc__modal-user-visibility-text-explanation">
                          Cualquiera dentro y fuera de Avanis puede ver tu publicación
                        </span>
                      </div>
                      <div class="av-pc__modal-user-visibility-icon av-pc__modal-user-visibility-icon--public">
                        <div class="av-theme__icon-box-24"></div>
                      </div>
                    </label>
                    <label class="av-pc__modal-user-visibility-label">
                      <input type="radio" name="<portlet:namespace />visibilityOptions" value="registered" ${visibility=="registered" ? 'checked="checked"' : '' } class="av-pc__modal-user-visibility-radio">
                      <div class="av-pc__modal-user-visibility-texts">
                        <span class="av-pc__modal-user-visibility-text-option">
                          Usuarios de Avanis
                        </span>
                        <span class="av-pc__modal-user-visibility-text-explanation">
                          Usuarios de Avanis
                        </span>
                      </div>
                      <div class="av-pc__modal-user-visibility-icon av-pc__modal-user-visibility-icon--registered">
                        <div class="av-theme__icon-box-24"></div>
                      </div>
                    </label>
                    <label class="av-pc__modal-user-visibility-label">
                      <input type="radio" name="<portlet:namespace />visibilityOptions" value="followers" ${visibility=="followers" ? 'checked="checked"' : '' } class="av-pc__modal-user-visibility-radio">
                      <div class="av-pc__modal-user-visibility-texts">
                        <span class="av-pc__modal-user-visibility-text-option">
                          Mis seguidores
                        </span>
                        <span class="av-pc__modal-user-visibility-text-explanation">
                        </span>
                      </div>
                      <div class="av-pc__modal-user-visibility-icon av-pc__modal-user-visibility-icon--followers">
                        <div class="av-theme__icon-box-24"></div>
                      </div>
                    </label>                  
                  </form>
                </div>
            </c:when>
            <c:when test='${follow == "followed"}'>
                <form action="${unfollowURL}" method="post">
                    <aui:input name="userId" value="${userId}" type="hidden"/>
                    <div class="div-boton-seguir">
                        <button type="submit" class="profile__button">Dejar de seguir</button>
                    </div>
                </form>
            </c:when>
            <%--
            <c:when test='${follow == "requested"}'>Solicitado</c:when>
            --%>
            <c:when test='${signedIn and follow!="requested"}'>
                <form action="${followURL}" method="post">
                    <aui:input name="userId" value="${userId}" type="hidden"/>
                    <div class="div-boton-seguir">
                        <button type="submit" class="profile__button">Seguir</button>
                    </div>
                </form>
            </c:when>

            <c:when test='${signedIn and follow=="requested"}'>
                    <div class="div-boton-seguir">
                        <button class="profile__button solicitud-enviada">Solicitud enviada</button>
                    </div>
            </c:when>
        </c:choose>
    </div>

    <!-- Profile content -->
    <div class="profile-content">
        <div>
            <p class="profile-content-title">Publicaciones</p>
        </div>
        <div>
            <p class="profile-content-data">${publicationsNumber}</p>
        </div>
    </div>
    <div class="profile-content">
        <div>
            <p class="profile-content-title">“Me gusta” recibidos</p>
        </div>
        <div>
            <p class="profile-content-data">${likes}</p>
        </div>
    </div>
    <div class="profile-content">
        <div>
            <p class="profile-content-title">Mi explotación</p>
        </div>
        <div>
            <p class="profile-content-data">${plots} parcelas</p>
        </div>
    </div>
    <div class="profile-content">
        <div>
            <p class="profile-content-title">Intereses</p>
        </div>
        <div>
            <p class="profile-content-data">${interestSize}</p>
        </div>
    </div>
    <div class="profile-content">
        <div>
            <p class="profile-content-title">Seguidores</p>
        </div>
        <div>
            <p class="profile-content-data">${countFollowersProfile}</p>
        </div>
    </div>
    <div class="profile-content">
        <div>
            <p class="profile-content-title">Seguidos</p>
        </div>
        <div>
            <p class="profile-content-data">${countFollowingsProfile}</p>
        </div>
    </div>
</div>
</div>

<script>
  // const htmlModalProfileVisibility = '<h1>Patata</h1>';
  const titleModalProfileVisibility = 'Audiencia de mi perfil';
  const buttonsModalProfileVisibility = [
    {
      text: 'Volver',
      classes: ['av-theme__btn', 'av-theme__btn--secondary'],
      callback: (modal) => closeModal(modal),
    },
    {
      text: 'Aplicar',
      classes: ['av-theme__btn', 'av-theme__btn--primary'],
      callback: (modal) => {
        const formModalProfileVisibility = modal.querySelector('form');
        const selectedRadio = formModalProfileVisibility.querySelector(
          'input[type="radio"]:checked'
        );

        if (!selectedRadio) {
          alert('Por favor, selecciona una opción antes de aplicar.');
          return;
        }

        formModalProfileVisibility.submit();
        closeModal(modal);
      },
    },
  ];

  // Mostrar el contenido del modal.
  // Se clona el contenedor original, se le quita la clase que lo oculta, y después se pasa su HTML (con las variables y elementos JSP ya renderizados), como parámetros a la función que genera el modal.
  const fakeIinputProfileVisibility = document.querySelector('.js-av-pc__fake-input-profile-visibility');
  fakeIinputProfileVisibility.addEventListener('click', () => {
    const modalContentNode = document.querySelector('.js-av-pc__modal-content');
    const clonedNode = modalContentNode.cloneNode(true);
    clonedNode.classList.remove('av-theme__hidden');
    const htmlModalProfileVisibility = clonedNode.outerHTML;

    openModal(
      htmlModalProfileVisibility,
      titleModalProfileVisibility,
      buttonsModalProfileVisibility,
      'global'
    );
  });

  var openCameraButton = document.getElementById('openCameraButton');
  $(openCameraButton).on('click', function () {
    $('#alertModalProfile').fadeIn();
  });
</script>
<%--
<script>
  $(document).ready(function () {
    // Cambiar la URL de la imagen de fondo
    $('.iconProfilePicture').css('background-image', 'url(${profileImage})');
  });
</script>
--%>
<script>
  $(document).ready(function () {
    // Función para ocultar el modal
    function hideModal() {
      $('#alertModalProfile').fadeOut();
      $('#editProfileModal').fadeOut();
    }

    $('.left-arrow').on('click', function () {
      hideModal();
    });

    $('.av-icon-close').on('click', function () {
      hideModal();
    });

    $(window).on('click', function (event) {
      if ($(event.target).is('#alertModalProfile')) {
        hideModal();
      }
    });
  });
</script>
<script>
  // JavaScript para manejar el modal y Cropper.js
  var modal = document.getElementById('av-te-ma-modal__panel');
  var cropButton = document.getElementById('cropButtonP');
  var saveButton = document.getElementById('saveButtonP');
  var inputImage = document.getElementById('inputImageP');
  var image = document.getElementById('imageP');
  var croppedImage = document.getElementById('croppedImageP');
  var cropper;
  var blobURL;

  openModalButton.onclick = function () {
    modal.style.display = 'block';
  };

  window.onclick = function (event) {
    if (event.target == modal) {
      modal.style.display = 'none';
    }
  };

  inputImage.onchange = function (event) {
    var files = event.target.files;
    var done = function (url) {
      inputImage.value = '';
      image.src = url;
      image.style.display = 'block';
      cropButton.style.display = 'block';
      croppedImage.style.display = 'none';
      saveButton.style.display = 'none';
      if (cropper) {
        cropper.destroy();
      }
      cropper = new Cropper(image, {
        aspectRatio: 1, // Cambiar la proporción a 1256:300
        viewMode: 1,
        autoCropArea: 1,
      });
    };
    let reader;
    let file;
    if (files && files.length > 0) {
      file = files[0];
      if (URL) {
        done(URL.createObjectURL(file));
      } else if (FileReader) {
        reader = new FileReader();
        reader.onload = function (e) {
          done(reader.result);
        };
        reader.readAsDataURL(file);
      }
    }
      $('.parrafo-imagen-previa').hide();
  };
  $('#cloud, #anadir-foto').on('click', function () {
    // Simula un clic en el input file con ID 'inputImageP'
    $('#inputImageP').click();
  });

  cropButton.onclick = function () {
    let canvas;
    if (cropper) {
      canvas = cropper.getCroppedCanvas({
        width: 300, // Ancho del área de recorte
        height: 300, // Altura del área de recorte
      });
      canvas.toBlob(function (blob) {
        blobURL = URL.createObjectURL(blob);
        croppedImage.src = blobURL;
        croppedImage.style.display = 'block';
        saveButton.style.display = 'block';
        console.log("IMAGEN CARGADA");
          $('.parrafo-imagen-previa').show();
        // Actualizar la imagen del banner
        //document.querySelector('.iconBanner').style.backgroundImage = 'url(' + blobURL + ')';

        // Crear un nuevo archivo a partir del blob
        var file = new File([blob], 'cropped-image-profile.jpg', {
          type: blob.type,
        });

        // Crear un DataTransfer y asignar el archivo
        var dataTransfer = new DataTransfer();
        dataTransfer.items.add(file);

        // Obtener el campo file y asignar el archivo
        var fileInput = document.getElementById(
          '<portlet:namespace />portrait'
        );
        fileInput.files = dataTransfer.files;
      });
    }
  };

  saveButton.onclick = function () {
    $('#btn-actualizar-perfil-pp').click();
  };
</script>
<%-- TODO CSS--%>
<style>
  .modal-cancelar-peticion .av-te-ma-modal__panel {
    display: grid;
  }
  #cloud,
  #cloudB {
    margin-bottom: 1em;
  }

  .cropper-view-box {
    border-radius: 50%;
  }

  .modal-banner {
    .cropper-view-box {
      border-radius: 0%;
    }
  }

  .av-icon-close {
    font-weight: 500 !important;
    font-size: 36px !important;
  }
  #croppedImageP{
      border-radius: 50%;
      height: 100px;
      width: 100px;

  }
  .btn-recortar-guardar-foto {
    display: flex;
    flex-direction: row;
    justify-content: center;
    gap: 1em;
  }

  .parrafo-imagen-previa {
      display: none;
      text-align: left;
      margin-top: 1em;
      margin-bottom: 5px;
  }
</style>
