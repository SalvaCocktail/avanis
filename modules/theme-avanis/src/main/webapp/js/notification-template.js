function openNotification(text, type) {
  const uniqueId = 'notification-' + Date.now(); // ID único para cada notificación.

  if (!type) {
    type = 'succes';
  }

  const notificationTemplate = document.querySelector('#js-notification'); // Selecciona el template de la notificación.
  if (!notificationTemplate) {
    console.log('No se ha encontrado la notificación en el DOM.');
  }

  // Clonar el template de l notificación.
  const notification = notificationTemplate.cloneNode(true);
  notification.id = uniqueId;

  // Escopar los selectores a la notificación actual.
  const notificationContainer = notification.querySelector(
    '#js-notification-container'
  );
  const notificationText = notification.querySelector('#js-notification-text');
  const notificationClose = notification.querySelectorAll(
    '#js-notification-icon-close'
  );

  // Asignar el tipo de modal a la clase.
  notificationContainer.classList.add(
    `av-theme__notification-container--${type}`
  );

  // Asignar el texto dinámico.
  notificationText.innerText = text;

  // Añadir la notificación al DOM
  document.body.appendChild(notification);

  // Mostrar la notificación
  notification.classList.remove('av-theme__hidden');

  // Añadir evento para cerrar la notificación
  notificationClose.forEach((item) => {
    item.addEventListener('click', () => closeNotification(notification));
  });

  if (typeof executeFunction === 'function') {
    executeFunction();
  }
}

function closeNotification(notification) {
  notification.classList.add('av-theme__hidden');
  notification.remove(); // Eliminar la notificación del DOM después de cerrarlo.
}

document.addEventListener('keydown', (e) => {
  if (e.key === 'Escape') {
    const notifications = document.querySelectorAll(
      '.js-notification:not(.av-theme__hidden)'
    );
    notifications.forEach(closeNotification); // Cerrar todas las notificaciones abiertas con Escape.
  }
});
