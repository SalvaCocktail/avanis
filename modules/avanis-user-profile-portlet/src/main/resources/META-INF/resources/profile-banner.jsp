<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>
<portlet:actionURL var="uploadBannerURL" name="uploadBanner"/>
<portlet:resourceURL var="uploadBannerURL2" id="uploadBanner2"/>


<div class="profile-banner">
    <div class="profile-container">
        <span class="iconBanner" alt="Profile Banner" style="background-image: url(${bannerImage})"></span>
            <%-- <span class="iconBanner" alt="Profile Banner" style="background-image: url(<%=request.getContextPath()%>/images/profile-banner.jpeg)"></span>--%>
         <c:if test="${me}">
             <button class="profile-edit-button" id="openModalButton">
                 <span class="iconCamera"></span>
                 <p>Editar</p>
             </button>
         </c:if>
     </div>
 </div>

 <!-- Modal -->
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
                     <p class="parrafo-imagen-previa">Imagen previa</p>
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

 <!-- Incluir jQuery y CSS de Cropper.js -->


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
         // Muestra el párrafo "Imagen previa"
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
                 // Muestra el párrafo "Imagen previa"
                 $('.parrafo-imagen-previa').show();
                 // Actualiza la imagen del banner
                 document.querySelector('.iconBanner').style.backgroundImage = 'url(' + blobURLP + ')';

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

     saveButton.onclick = function () {
         $('#btn-actualizar-banner-pp').click();
    };

</script>

<style>
    .parrafo-imagen-previa {
        display: none;
        text-align: left;
        margin-top: 1em;
        margin-bottom: 5px;
    }
</style>