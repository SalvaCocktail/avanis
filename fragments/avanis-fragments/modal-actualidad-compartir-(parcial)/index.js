Liferay.on('allPortletsReady', function () {
// Obtener URL y pegarla en el placehloder.
  (function () {
    var url = window.location.href;
    var inputElement = document.getElementById('urlInput');
    if (inputElement) {
      inputElement.placeholder = url;
    }
    console.log('URL: ' + url);
  })();

// Pegar la URL en el portapapeles.
  const urlToClipboard = document.querySelector('.av-ac-mp__copy-link-btn');
  urlToClipboard.addEventListener('click', function () {
    var url = window.location.href;
    navigator.clipboard.writeText(url);
    console.log('URL al portapeles' + url);
  });




  function validateEmail(email) {
    const regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return regex.test(email);
  }

  document
      .getElementById('emailForm')
      .addEventListener('submit', function (event) {
        event.preventDefault();
        const tags = tagsInput.querySelectorAll('.tag');
        const emails = [];
        tags.forEach((tag) => {
          emails.push(tag.textContent.slice(0, -1));
        });
        alert('Correos electrónicos: ' + emails.join(', '));
      });




  // Abrir y cerrar el modal.
  const shareBtn = document.querySelector('.av-ac-share-btn');
  const modalContainer = document.querySelector('.av-ac-modal-container');
  const closeIcon = document.querySelector('.av-ac-modal-x-close-icon');
  const closeBtn = document.querySelector('.av-ac-mp__cancel');
  const closeBackdrop = document.querySelector('.av-ac-backdrop');

  if (Liferay.ThemeDisplay.isSignedIn()) {
    shareBtn.addEventListener('click', function () {
      console.log("Disparador");
      modalContainer.classList.add('av-modal-visible');
    });
  } else {
    shareBtn.addEventListener('click', function () {
      openLoginModal();
    });
  }

  function closeModalFun() {
    modalContainer.classList.remove('av-modal-visible');
  }

  closeIcon.addEventListener('click', closeModalFun);
  closeBtn.addEventListener('click', closeModalFun);
  closeBackdrop.addEventListener('click', closeModalFun);
});




// URL que deseas compartir
var urlToShare = window.location.href;
var textToShare = encodeURIComponent('¡Mira este increíble sitio web!');

// Compartir en LinkedIn
document.getElementById('linkedin-share').onclick = function () {
  window.open(
      'https://www.linkedin.com/shareArticle?mini=true&url=' + urlToShare,
      '_blank',
      'width=600,height=400'
  );
  return false;
};

// Compartir en Facebook
document.getElementById('facebook-share').onclick = function () {
  window.open(
      'https://www.facebook.com/sharer/sharer.php?u=' + urlToShare,
      '_blank',
      'width=600,height=400'
  );
  return false;
};
function openLoginModal() {
  console.log("MUESTRO MODAL DE LOGARSE");
  $('#modal-compartir-not-logged').show();  // Mostrar el modal
}
$('.av-icon-close').on('click', function() {
  $('.modal-seguidores .av-te-ma-modal').hide();

});
// Compartir en WhatsApp
document.getElementById("whatsapp-share").onclick = function() {
  var whatsappUrl = "https://api.whatsapp.com/send?text=" + encodeURIComponent(textToShare + " " + urlToShare);
  window.open(whatsappUrl, '_blank');
  return false;
};

