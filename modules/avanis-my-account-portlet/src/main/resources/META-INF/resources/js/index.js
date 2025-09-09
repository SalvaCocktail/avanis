function displayMenu() {
    document.getElementById("menu").style.display = "block";
    $('.av-account-view__main-image').show();
    $('.av-account-view__main-image-container').show();
    $('.av-account-view__profile-image').show();
    document.getElementById("main").style.display = "none";
}

function goTo(div, screen, url) {
  console.log('goto');

  // Realizamos la llamada AJAX
  $.ajax({
    url: url,
    type: 'GET',
    data: {tab: screen},
    success: function (data) {
      // Inserta el contenido en el div con id 'main'
      $('#main').empty().append(data);

      // Lógica que debe ejecutarse tras la llamada AJAX
      document.getElementById('menu').style.display = 'none';

      // Verificamos si estamos en un dispositivo móvil (viewport menor de 769px)
      if (window.innerWidth < 769) {
        $('.av-account-view__main-image').hide();
        $('.av-account-view__main-image-container').hide();
        $('.av-account-view__profile-image').hide();
      }

      document.getElementById('main').style.display = 'block';

      // Gestionamos la clase 'active'
      $('div.av-menu__section-item.active').removeClass('active');
      div.classList.add('active');
    },
    error: function (xhr, status, error) {
      console.error('Error en la petición AJAX:', error);
    },
  });

  // Cancelamos el comportamiento predeterminado del evento que invoque a goTo (como un clic en un enlace)
  return false;
}

Liferay.on('allPortletsReady', () => {
  // Función para mostrar u ocultar elementos según el tamaño del viewport.
  function toggleVisibilityOnResize() {
    if (window.innerWidth < 769) {
      $('.av-account-view__main-image').hide();
      $('.av-account-view__main-image-container').hide();
      $('.av-account-view__profile-image').hide();
    } else {
      $('.av-account-view__main-image').show();
      $('.av-account-view__main-image-container').show();
      $('.av-account-view__profile-image').show();
    }
  }

  // Ejecutar la función al cargar la página para aplicar el estado inicial.
  toggleVisibilityOnResize();

  // Agregar un event listener para que la función se ejecute cada vez que se cambie el tamaño de la ventana.
  window.addEventListener('resize', toggleVisibilityOnResize);
});
