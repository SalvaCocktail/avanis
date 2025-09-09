function openModal(content, title, buttons, type, executeFunction) {
  const uniqueId = 'modal-' + Date.now(); // ID único para cada modal.

  if (!type) {
    type = 'global';
  }

  const modalTemplate = document.querySelector('#js-modal'); // Selecciona el template del modal global.
  if (!modalTemplate) {
    console.log('No se ha encontrado el Modal en el DOM.');
    return;
  }

  // Clonar el template del modal global.
  const modal = modalTemplate.cloneNode(true);
  modal.id = uniqueId;

  // Escopar los selectores al modal actual.
  const modalTitle = modal.querySelector('#js-modal-title');
  const modalBody = modal.querySelector('#js-modal-body');
  const modalFooter = modal.querySelector('#js-modal-footer');
  const modalClose = modal.querySelectorAll('.js-close-modal');

  // Asignar el tipo de modal a la clase.
  modal.classList.add(`av-theme__modal--${type}`);

  // Asignar el título dinámico.
  modalTitle.innerText = title;

  // Comprobar si `content` es una URL o HTML.
  const isUrl =
    typeof content === 'string' &&
    (content.startsWith('http') || content.startsWith('/'));

  if (isUrl) {
    // Cargar el contenido desde la URL.
    fetch(content)
      .then((response) => {
        if (!response.ok) {
          throw new Error('Error al cargar el contenido del modal');
        }
        return response.text();
      })
      .then((htmlContent) => {
        modalBody.innerHTML = htmlContent; // Insertar el HTML cargado en el modal.

        // Configurar botones y mostrar el modal.
        configureModalButtonsAndShow(
          modal,
          buttons,
          modalFooter,
          modalClose,
          executeFunction
        );
      })
      .catch((error) => {
        console.error('Error:', error);
      });
  } else {
    // Asignar el contenido directamente si es HTML.
    modalBody.innerHTML = content;

    // Configurar botones y mostrar el modal.
    configureModalButtonsAndShow(
      modal,
      buttons,
      modalFooter,
      modalClose,
      executeFunction
    );
  }
}

function configureModalButtonsAndShow(
  modal,
  buttons,
  modalFooter,
  modalClose,
  executeFunction
) {
  // Asignar botones dinámicos.
  modalFooter.innerHTML = ''; // Limpiar botones previos.
  buttons.forEach((button) => {
    const btn = document.createElement('button');
    btn.innerText = button.text;
    btn.classList.add(...button.classes); // Añadir las clases CSS.

    btn.addEventListener('click', () => button.callback(modal));
    modalFooter.appendChild(btn);
  });

  // Añadir el modal al DOM.
  document.body.appendChild(modal);

  // Mostrar el modal.
  modal.classList.remove('av-theme__hidden');

  // Añadir evento para cerrar el modal.
  modalClose.forEach((item) => {
    item.addEventListener('click', () => closeModal(modal));
  });

  if (typeof executeFunction === 'function') {
    executeFunction();
  }
}

function closeModal(modal) {
  modal.classList.add('av-theme__hidden');
  modal.remove(); // Eliminar el modal del DOM después de cerrarlo.
}

// Evento para cerrar el modal al presionar "Escape".
document.addEventListener('keydown', (e) => {
  if (e.key === 'Escape') {
    const modals = document.querySelectorAll(
      '.js-modal-global:not(.av-theme__hidden)'
    );
    modals.forEach(closeModal); // Cerrar todos los modales abiertos con Escape.
  }
});
