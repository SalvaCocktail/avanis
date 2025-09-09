<%@ page import="javax.portlet.PortletURL" %>
<%@ page import="com.liferay.portal.kernel.portlet.PortletURLFactoryUtil" %>
<%@ page import="javax.portlet.PortletRequest" %>
<%@ include file="./init.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<portlet:resourceURL var="tabsURL">
	<portlet:param name="mvc.command.name" value="getTab"/>
</portlet:resourceURL>



<!-- Message text elements -->
<liferay-ui:success key="success" message="message.success"/>
<liferay-ui:error key="error" message="message.error"/>
<liferay-ui:error key="message.error.banner" message="true" />
<liferay-ui:success key="message.success.aboutme" message="Mi perfil guardado con éxito" />
<liferay-ui:success key="message.success.preferences" message="Mis preferencias guardadas con éxito" />
<liferay-ui:success key="message.success.notificaciones" message="Notificaciones guardadas con éxito" />
<liferay-ui:success key="message.imagenperfil" message="Has cambiado la imágen de perfil." />
<liferay-ui:success key="message.imagenbanner" message="Has cambiado la imágen de banner." />

<div class="modal-cancelar-peticion modal-cambiar-imagen-perfil">
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
				<img id="imageP" style="max-width: 100%;max-height: 300px; display: none;">
					<p class="parrafo-imagen-previa">Imagen previa:</p>
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


<%-- MODAL EDITAR BANNER --%>
<div class="modal-cancelar-peticion modal-banner">
	<div id="editProfileModal" class="av-te-ma-modal">
		<div class="av-te-ma-modal__panel">
			<div class="av-te-ma-modal__header">
				<img class="left-arrow" src="<%=request.getContextPath()%>/images/arrow-left.png" alt="left-arrow" />
				<h5 class="modal-title" id="exampleModalLabelC" style="text-align: center">Añadir foto de Banner</h5>
				<span class="av-icon-close">&times;</span>
			</div>
			<div class="av-te-ma-modal__content" style="height: 674px;">
				<div style="height: 300px;">
				<img id="cloudB" src="<%=request.getContextPath()%>/images/Vector.png" alt="cloud" style="cursor: pointer"/>
				<input type="file" id="inputImage" accept="image/*" style="display: none">
				<img id="image" style="max-width: 100%; display: none;">
				<p class="parrafo-imagen-previa">Imagen previa:</p>
				<img id="croppedImage" style="max-width: 100%; display: none;">
				<button class="profile__button--edit " id="anadir-fotoB">
					<span class="profile__icon profile__icon--edit" style="background-image: url('<%= request.getContextPath() %>/images/camera.png');"></span>
					<p>Añadir foto</p>
				</button>
				<div class="btn-recortar-guardar-foto">
					<button type="button" class="profile__button" id="cropButton" style="display: none;">Recortar</button>
					<button type="button" class="profile__button" id="saveButton" style="display: none;">Guardar</button>
				</div>
				</div>
			</div>

		</div>
	</div>
</div>

<div class="av-account-view">
	<!-- Hero -->
	<div class="av-account-view__main-image">
    <div class="av-account-view__main-image-container">
		<c:if test="${not empty bannerImage}">
       <img class="av-account-view__main-image__img"
			src="${bannerImage}" alt="Profile Banner" >
		</c:if>
      <button class="av-profile-edit-button "id="openModalButton">
        <img src="<%=request.getContextPath()%>/images/camera-white.png" alt="Edit Icon"/>
        <p>Editar</p>
      </button>
    </div>
	</div>

	<!-- Profile -->
	<div class="av-account-view__profile-image">
		<div>
			<c:set var="firstName" value="${fn:trim(fn:substringBefore(user.fullName, ' '))}" />
			<c:set var="secondName" value="${fn:trim(fn:substring(user.lastName, 0, 1))}" />
			<c:set var="initials" value="${fn:toUpperCase(fn:substring(firstName, 0, 1))}${fn:toUpperCase(fn:substring(secondName, 0, 1))}" />
			<c:choose>
				<c:when test="${fn:contains(profileImage, '/image/user_portrait?img_id=0')}">
						<%-- Si existe imagen por defecto pongo iniciales--%>
							<p class="av-account-view__profile-image__main" style="
									text-align: center;
									top: 45px;
									font-size: 47px;
									left: 8px;
									font-weight: 700;
									color: white;
									padding-top: 0.8em;
									background-color: #122C1F;
									margin-bottom: 0px;
							">${initials}</p>
				</c:when>
				<c:otherwise>
							<%-- Si no , muestro la imagen de perfil--%>
						<img class="av-account-view__profile-image__main"
							src="${profileImage}"
							alt="My image"/>
				</c:otherwise>
			</c:choose>
			<img class="av-account-view__profile-image__camera" src="<%=request.getContextPath()%>/images/camera.png"
				alt="Edit Icon" id="btn-editar-foto-perfil">
		</div>
	</div>
	<div class="av-account-view__body">
		<div id="menu" class="av-menu">
			<div class="av-menu__profile">
				<div class="av-menu__profile__title">${user.fullName}</div>
				<!--TODO: Porcentaje del perfil -->
				<%--<div class="av-menu__profile__percentage">60 % del perfil completado</div> --%>

				<a class="link-avanis" href="${themeDisplay.getURLHome()}/mi-perfil-publico" class="av-menu__profile__link">Ver perfil público</a>
			</div>
			<!-- Menu -->
			<p class="av-menu__subtitle">Configuración</p>
			<div class="av-menu__section">
				<div class='av-menu__section-item ${(focusedTab == null || focusedTab == "" || focusedTab == "about") ? "active": ""}'
					onClick="goTo(this, 'about', '${tabsURL}' )">
					Sobre mí
					<img class="av-menu__section-item__chevron"
						src="<%=request.getContextPath()%>/images/chevron-right.png" alt="chevron right"/>
				</div>
				<div class='av-menu__section-item ${focusedTab == "preferences" ? "active": ""}'
					onClick="goTo(this, 'preferences', '${tabsURL}' )">
					Mis preferencias
					<img class="av-menu__section-item__chevron"
						src="<%=request.getContextPath()%>/images/chevron-right.png" alt="chevron right"/>
				</div>
				<div class='av-menu__section-item ${focusedTab == "plots" ? "active": ""}'
					onClick="goTo(this, 'plots', '${tabsURL}')">
					Gestión de mis parcelas
					<img class="av-menu__section-item__chevron"
						src="<%=request.getContextPath()%>/images/chevron-right.png" alt="chevron right"/>
				</div>
				<div class='av-menu__section-item ${focusedTab == "notifications" ? "active": ""}'
					onClick="goTo(this, 'notifications', '${tabsURL}')">
					Notificaciones
					<img class="av-menu__section-item__chevron"
						src="<%=request.getContextPath()%>/images/chevron-right.png" alt="chevron right"/>
				</div>
				<div class='av-menu__section-item ${focusedTab == "security" ? "active": ""}'
					onClick="goTo(this, 'security', '${tabsURL}')">
					Seguridad de mi cuenta
					<img class="av-menu__section-item__chevron"
						src="<%=request.getContextPath()%>/images/chevron-right.png" alt="chevron right"/>
				</div>
				<div class='av-menu__section-item ${focusedTab == "account" ? "active": ""}'
					onClick="goTo(this, 'account', '${tabsURL}')">
					Administrar mi cuenta
					<img class="av-menu__section-item__chevron"
						src="<%=request.getContextPath()%>/images/chevron-right.png" alt="chevron right"/>
				</div>
			</div>
			<p class="av-menu__subtitle">Ayuda</p>
			<div class="av-menu__section">
				<div class='av-menu__section-item ${focusedTab == "faq" ? "active": ""}'
					onClick="goTo(this, 'faq', '${tabsURL}')">Preguntas frecuentes
				</div>
			</div>
			<div class="av-menu__logout cerrar-sesion">
				<a class="link-avanis-red" href="/c/portal/logout">Cerrar sesión
					<img class="ml-2" src="<%=request.getContextPath()%>/images/go-out.png" alt="icon sign out"/>
				</a>
			</div>
		</div>
		<!-- Main -->
		<div id="main" class="av-main">

			<c:choose>
				<c:when test='${focusedTab == "preferences"}'>
					<jsp:include page="preferences.jsp"/>
				</c:when>
				<c:when test='${focusedTab == "plots"}'>
					<jsp:include page="plots.jsp"/>
				</c:when>
				<c:when test='${focusedTab == "security"}'>
					<jsp:include page="security.jsp"/>
				</c:when>
				<c:when test='${focusedTab == "account"}'>
					<jsp:include page="account.jsp"/>
				</c:when>
				<c:when test='${focusedTab == "faq"}'>
					<jsp:include page="faq.jsp"/>
				</c:when>
				<c:when test='${focusedTab == "notifications"}'>
					<jsp:include page="notifications.jsp"/>
				</c:when>
				<c:otherwise>
					<jsp:include page="aboutMe.jsp"/>

				</c:otherwise>
			</c:choose>


		</div>
	</div>
</div>

<!-- FIXME: Tendría que estar en local jquery para no descargarlo cada vez que se acceda a la página-->
<%--
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link href="https://cdnjs.cloudflare.com/ajax/libs/cropperjs/1.5.12/cropper.min.css" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/cropperjs/1.5.12/cropper.min.js"></script>
--%>
<!-- TODO: Estos formularios habrá que ponerlo en los modales y las urls de abajo como imagenes en los iconos y banner respectivamente -->
<portlet:actionURL var="uploadPortraitURL" name="uploadPortrait"/>
<portlet:actionURL var="uploadBannerURL" name="uploadBanner"/>


<div style="display: none;">
	<form action="${uploadPortraitURL}" method="post" enctype="multipart/form-data">
			<aui:input type="file" name="portrait">
				<aui:validator name="required"/>
			</aui:input>
			<aui:input type="hidden" value="${focusedTab}" name="focusedTab"
				id="focused-tab-portrait-form"/>

			<input type="submit" id="btn-actualizar-perfil-pp" value="Actualizar foto perfil">
	</form>


	<form action="${uploadBannerURL}" method="post" enctype="multipart/form-data">
	<aui:input type="file" name="banner">
				<aui:validator name="required"/>
			</aui:input>
			<aui:input type="hidden" value="${focusedTab}" name="focusedTab"
				id="focused-tab-banner-form"/>

			<input type="submit" value="Actualizar foto del banner" id="btn-actualizar-banner-pp">
		</form>

	</div>

<div style="display: none;">

	<div>
	<strong>URL profile image:</strong> ${profileImage} <br>
	<strong> URL banner image:</strong> ${bannerImage} <br>
	</div>

</div>



<script>

	$('.av-account-view__profile-image__camera').on('click', function() {
		$('#alertModalProfile').fadeIn();

	});

	$(document).ready(function() {
		// Función para ocultar el modal
		function hideModal() {
			$('#alertModalProfile').fadeOut();
			$('#editProfileModal').fadeOut();
			$('')
		}

		$('.left-arrow').on('click', function() {
			hideModal();
		});

		$('.av-icon-close').on('click', function() {
			hideModal();
		});

		$(window).on('click', function(event) {
			if ($(event.target).is('#alertModalProfile')) {
				hideModal();
			}
		});
	});
</script>
<script>
	// JavaScript para manejar el modal y Cropper.js
	var modal = document.getElementById("av-te-ma-modal__panel");
	var cropButton = document.getElementById("cropButtonP");
	var saveButton = document.getElementById("saveButtonP");
	var inputImage = document.getElementById("inputImageP");
	var image = document.getElementById("imageP");
	var croppedImage = document.getElementById("croppedImageP");
	var cropper;
	var blobURL;





	window.onclick = function (event) {
		if (event.target == modal) {
			modal.style.display = "none";
		}
	}

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
				aspectRatio: 1,  // Cambiar la proporción a 1256:300
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
	$('#cloud, #anadir-foto').on('click', function() {
		// Simula un clic en el input file con ID 'inputImageP'
		$('#inputImageP').click();
	});

	cropButton.onclick = function () {
		let canvas;
		if (cropper) {
			canvas = cropper.getCroppedCanvas({
				width: 300,  // Ancho del área de recorte
				height: 300,  // Altura del área de recorte
			});
			canvas.toBlob(function (blob) {
				blobURL = URL.createObjectURL(blob);
				croppedImage.src = blobURL;
				croppedImage.style.display = 'block';
				saveButton.style.display = 'block';
				$('.parrafo-imagen-previa').show();
				// Actualizar la imagen del banner
				//document.querySelector('.iconBanner').style.backgroundImage = 'url(' + blobURL + ')';

				// Crear un nuevo archivo a partir del blob
				var file = new File([blob], "cropped-image-profile.jpg", { type: blob.type });

				// Crear un DataTransfer y asignar el archivo
				var dataTransfer = new DataTransfer();
				dataTransfer.items.add(file);

				// Obtener el campo file y asignar el archivo
				var fileInput = document.getElementById('<portlet:namespace />portrait');
				fileInput.files = dataTransfer.files;

			});
		}
	};

	saveButton.onclick = function () {
		$('#btn-actualizar-perfil-pp').click();
	};

</script>
<script>
	// JavaScript para manejar el modal y Cropper.js
	var cropButtonP = document.getElementById("cropButton");
	var saveButtonP = document.getElementById("saveButton");
	var inputImageP = document.getElementById("inputImage");
	var imageP = document.getElementById("image");
	var croppedImageP = document.getElementById("croppedImage");
	var cropperP;
	var blobURLP;

	$('#openModalButton').click(function() {
		$('#editProfileModal').fadeIn();
	});
	$('#closeModalButton').click(function() {
		$('#editProfileModal').fadeOut();

	});
	$(window).click(function(event) {
		if ($(event.target).is('#editProfileModal')) {
			$('#editProfileModal').fadeOut();
		}
	});


	inputImageP.onchange = function (event) {
		var files = event.target.files;
		var done = function (url) {
			inputImageP.value = '';
			imageP.src = url;
			imageP.style.display = 'block';
			cropButtonP.style.display = 'block';
			croppedImageP.style.display = 'none';
			saveButtonP.style.display = 'none';
			if (cropperP) {
				cropperP.destroy();
			}
			cropperP = new Cropper(imageP, {
				aspectRatio: 1256 / 300,  // Cambiar la proporción a 1256:300
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
	$('#cloudB, #anadir-fotoB').on('click', function() {
		// Simula un clic en el input file con ID 'inputImageP'
		$('#inputImage').click();
	});
	cropButtonP.onclick = function () {
		let canvas;
		if (cropperP) {
			canvas = cropperP.getCroppedCanvas({
				width: 1256,  // Ancho del área de recorte
				height: 300,  // Altura del área de recorte
			});
			canvas.toBlob(function (blob) {
				blobURL = URL.createObjectURL(blob);
				croppedImageP.src = blobURL;
				croppedImageP.style.display = 'block';
				saveButtonP.style.display = 'block';
				$('.parrafo-imagen-previa').show();
				// Actualizar la imagen del banner
				//document.querySelector('.iconBanner').style.backgroundImage = 'url(' + blobURLP + ')';

				// Crear un nuevo archivo a partir del blob
				let file = new File([blob], "cropped-image-banner.jpg", { type: blob.type });

				// Crear un DataTransfer y asignar el archivo
				let dataTransfer = new DataTransfer();
				dataTransfer.items.add(file);

				// Obtener el campo file y asignar el archivo
				let fileInput = document.getElementById('<portlet:namespace />banner');
				fileInput.files = dataTransfer.files;

			});
		}
	};

	saveButtonP.onclick = function () {
		$('#btn-actualizar-banner-pp').click();
	};

</script>
<%-- TODO CSS--%>
<style>
	.modal-cancelar-peticion .av-te-ma-modal__panel{
		display: grid;
	}
	#cloud,#cloudB{
		margin-bottom: 1em;
	}

	.cropper-view-box{
		border-radius: 50%;
	}

	.modal-banner{
		.cropper-view-box{
			border-radius: 0%;
		}
	}


	.av-icon-close{
		font-weight: 500 !important;
		font-size: 36px !important;
	}
	#croppedImageP{
		border-radius: 50%;
		height: 100px;
		width: 100px;
		margin-top: 1em;

	}
	.btn-recortar-guardar-foto{
		display: flex;
		flex-direction: row;
		justify-content: center;
		gap: 1em;
	}
</style>

<%-- TODO CSS--%>
<style>
	.modal-cancelar-peticion .av-te-ma-modal__panel{
		display: grid;
	}
	#cloud,#cloudB{
		margin-bottom: 1em;
	}

	.cropper-view-box{
		border-radius: 50%;
	}

	.modal-banner{
		.cropper-view-box{
			border-radius: 0%;
		}
	}


	.av-icon-close{
		font-weight: 500 !important;
		font-size: 36px !important;
	}
	#croppedImageP{
		border-radius: 50%;
		height: 100px;
		width: 100px;
		margin-top: 1em;
	}
	.btn-recortar-guardar-foto{
		display: flex;
		flex-direction: row;
		justify-content: center;
		gap: 1em;
		margin-top: 1em;
	}
	.av-account-view__profile-image__camera{
		cursor: pointer;
	}


	.profile__button {
		background-color: #053c1c;
		color: white;
		border: none;
		padding: 8px 16px;
		border-radius: 8px;
		cursor: pointer;
		width: 156px;
	}
	.profile__button--edit {
		background: none;
		border: none;
		font-weight: 600;
		color: #107e3e;
		cursor: pointer;
		display: flex;
	}
</style>