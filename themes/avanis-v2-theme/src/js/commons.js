// Variable de control para evitar ejecuciones concurrentes.
var isExecutingCommons = false;

// LLamada a la función de envoltorio.
function handleCommons() {
  if (isExecutingCommons) {
    console.log(
      'La función de envoltorio ya está en ejecución, se evita una nueva ejecución.'
    );
    return;
  }

  // Bloquear nuevas ejecuciones mientras la función de envoltorio esta en curso.
  isExecutingCommons = true;

  //
  // LÓGICA JS DENTRO DE LA FUNCIÓN DE ENVOLTORIO:
  //

  // Transformacion de texto, a minusculas con solo la primera letra en mayuscula.
  document
    .querySelectorAll('.av-theme__capitalize-first')
    .forEach(function (element) {
      let text = element.textContent.toLowerCase(); // Convertir todo a minúsculas
      element.textContent = text.charAt(0).toUpperCase() + text.slice(1);
    });
}

// Lanzar la función de envoltorio cuando toda la página (incluyendo imágenes y recursos) ha sido completamente cargada.
window.onload = function () {
  handleCommons();
};

// Lanzar la función de envoltorio cuando todos los portlets estén listos.
Liferay.on('allPortletsReady', function () {
  handleCommons();
});

// Lanzar la función de envoltorio cuando una nueva pantalla se ha cargado en la navegación SPA.
Liferay.on('screenLoad', function () {
  handleCommons();
});

// Lanzar la función de envoltorio cuando la navegación SPA ha terminado.
Liferay.on('endNavigate', function () {
  handleCommons();
});

// Lanzar la función de envoltorio cuando se produce navegación en el SPA.
Liferay.on('SPA_NAVIGATION', function (event) {
  handleCommons();
});

// Lanzar la función de envoltorio cuando hay cambios de ruta.
Liferay.on('routeChanged', function () {
  handleCommons();
});
