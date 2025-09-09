function createMultiselectComponent(config) {
  return new Promise((resolve) => {
    let uniqueId;
    function fallbackRandomId() {
      const randomPart = Math.floor(Math.random() * 10000);
      return Date.now() + '-' + randomPart;
    }

    // Verificar si `crypto.randomUUID()` está soportado.
    const uuid =
      crypto && crypto.randomUUID ? crypto.randomUUID() : fallbackRandomId();
    // ID único para cada multiselect.
    if (config.tags === true) {
      uniqueId = 'multiselect-tags-' + uuid;
    } else {
      uniqueId = 'multiselect-' + uuid;
    }

    console.log('createMultiselectComponent');
    console.log('UniqueId', uniqueId);

    // Clonar la plantilla del multiselect.
    const multiselectComponetTemplate =
      document.querySelector('.js-av-theme__ms');
    if (!multiselectComponetTemplate) {
      console.log('No se encuentra la plantilla del multiselect en el DOM.');
      return;
    }
    const multiselectComponetClone =
      multiselectComponetTemplate.cloneNode(true);
    multiselectComponetClone.id = uniqueId;
    multiselectComponetClone.classList.remove('js-av-theme__ms');
    if (config.tags === true) {
      multiselectComponetClone.classList.add('av-theme__ms--tags');
    } else {
      multiselectComponetClone.classList.add('av-theme__ms--no-tags');
    }

    // Escopar los selectores al multiselect actual.
    let optionsStatus = {success: false};
    const labelText = multiselectComponetClone.querySelector(
      '.js-av-theme__ms-label-text'
    );
    const labelRequired = multiselectComponetClone.querySelector(
      '.js-av-theme__ms-label-required'
    );
    const input = multiselectComponetClone.querySelector(
      '.js-av-theme__ms-input'
    );
    const placeholder = multiselectComponetClone.querySelector(
      '.js-av-theme__ms-placeholder'
    );
    const optionsContainer = multiselectComponetClone.querySelector(
      '.js-av-theme__ms-options'
    );
    const optionsSelectedContainer = multiselectComponetClone.querySelector(
      '.js-av-theme__ms-options-selected'
    );
    const counter = multiselectComponetClone.querySelector(
      '.js-av-theme__ms-counter'
    );
    const helpText = multiselectComponetClone.querySelector(
      '.js-av-theme__ms-help-text--help'
    );
    const errorText = multiselectComponetClone.querySelector(
      '.js-av-theme__ms-help-text--error'
    );
    const hiddenInput = multiselectComponetClone.querySelector(
      '.js-av-theme__ms-hidden'
    );
    const deleteAll = multiselectComponetClone.querySelector(
      '.js-av-theme__ms-options-delete-all'
    );
    const backdrop = multiselectComponetClone.querySelector(
      '.js-av-theme__ms-backdrop'
    );
    const tabs = multiselectComponetClone.querySelector(
      '.js-av-theme__ms-options-tabs'
    );
    const tabsLeft = multiselectComponetClone.querySelector(
      '.js-av-theme__ms-options-tab--left'
    );
    const tabsRight = multiselectComponetClone.querySelector(
      '.js-av-theme__ms-options-tab--right'
    );
    let selectedIds;

    // Asignar propiedades según la configuración recibida.
    labelText.textContent = config.label || '';
    helpText.textContent = config['help-text'] || '';
    errorText.textContent = config['error-text'] || '';
    optionsContainer.classList.add(`av-theme__ms-options-${uniqueId}`);
    optionsSelectedContainer.classList.add(
      `av-theme__ms-options-selected-${uniqueId}`
    );
    backdrop.classList.add(`av-theme__ms-backdrop-${uniqueId}`);
    // TODO - Implementar lógica adecuada para que el input hidden sea required. Ahora no lo asigna.
    hiddenInput.required = config.required === true ? true : false;

    // Aplicar el tamaño y tema.
    multiselectComponetClone.classList.add(
      config.size,
      config.theme,
      config.type,
      config.name
    );

    // Aplicar estilo al label.
    if (!config.label) {
      labelText.classList.add('av-theme__hidden');
    }

    // Añadir texto al placeholder.
    placeholder.textContent = config['placeholder-unselected'];

    // Configurar asterisco de campo requerido.
    if (config.required === true) {
      labelRequired.classList.remove('av-theme__hidden');
    }

    // Llamada fetch para cargar las opciones desde la URL proporcionada.
    fetchOptions(config.url, function (data) {
      populateOptions(
        optionsContainer,
        data,
        uniqueId,
        config['limit-of-groups'],
        optionsStatus
      );

      // Verificamos el estado de optionsStatus después de poblar opciones.
      if (optionsStatus.success) {
        console.log('Options cargados correctamente.');
      } else {
        console.log('Error al cargar los options');
      }

      // Añadir la lógica para seleccionar opciones.
      optionsContainer
        .querySelectorAll(`.av-theme__ms-option-${uniqueId}`)
        .forEach((option) => {
          option.addEventListener('click', () =>
            handleOptionClick(
              config,
              uniqueId,
              data,
              counter,
              input,
              placeholder,
              optionsContainer,
              optionsSelectedContainer,
              option,
              tabs,
              tabsLeft,
              tabsRight,
              deleteAll,
              errorText,
              hiddenInput,
              selectedIds,
              config['limit-of-results']
            )
          );
        });

      // Resolver la promesa con el estado.
      resolve({
        name: config.name,
        success: optionsStatus.success,
        selectedIds: selectedIds,
      });
    });

    // LLamar a la logica para controlar la visibilidad del contenedor de options.
    changeVisibilityOptionsContainers(
      multiselectComponetClone,
      uniqueId,
      input,
      optionsContainer,
      optionsSelectedContainer,
      backdrop,
      config.tags,
      tabs,
      tabsLeft,
      tabsRight,
      deleteAll
    );

    // Insertar el multiselect clonado en el contenedor seleccionado.
    document.querySelector(config.container).classList.add('position-relative');
    document
      .querySelector(config.container)
      .appendChild(multiselectComponetClone);

    // Mostrar el multiselect.
    multiselectComponetClone.classList.remove('av-theme__hidden');
  });
}

// Controlar la visibilidad del contenedor de options.
function changeVisibilityOptionsContainers(
  multiselectComponetClone,
  uniqueId,
  input,
  optionsContainer,
  optionsSelectedContainer,
  backdrop,
  tags,
  tabs,
  tabsLeft,
  tabsRight,
  deleteAll
) {
  if (tags) {
    if (optionsContainer.classList.contains('av-theme__hidden')) {
      optionsSelectedContainer.classList.remove('av-theme__hidden');
    } else {
      optionsSelectedContainer.classList.add('av-theme__hidden');
    }

    input.addEventListener('click', () => {
      multiselectComponetClone.classList.add('zindex100');
      optionsContainer.classList.toggle('av-theme__hidden');
      optionsSelectedContainer.classList.toggle('av-theme__hidden');

      if (optionsContainer.classList.contains('av-theme__hidden')) {
        backdrop.classList.add('av-theme__hidden');
      } else {
        backdrop.classList.remove('av-theme__hidden');
      }

      changeStylesInputOptionsContainer(input, optionsContainer, 'focused');
    });
    backdrop.addEventListener('click', () => {
      multiselectComponetClone.classList.remove('zindex100');
      optionsContainer.classList.add('av-theme__hidden');
      optionsSelectedContainer.classList.remove('av-theme__hidden');
      backdrop.classList.add('av-theme__hidden');

      changeStylesInputOptionsContainer(input, optionsContainer, 'focused');
    });
  } else {
    input.addEventListener('click', () => {
      let listOfOptions = document.querySelectorAll(
        `.av-theme__ms-option-${uniqueId}`
      );
      multiselectComponetClone.classList.add('zindex100');
      if (
        !optionsContainer.classList.contains('av-theme__hidden') ||
        !optionsSelectedContainer.classList.contains('av-theme__hidden')
      ) {
        backdrop.classList.add('av-theme__hidden');
        tabs.classList.add('av-theme__hidden');
        tabsLeft.classList.add('av-theme__hidden');
        deleteAll.classList.add('av-theme__hidden');
      } else {
        backdrop.classList.remove('av-theme__hidden');
        tabsLeft.classList.add('active');
        if (listOfOptions.length > 5) {
          tabs.classList.remove('av-theme__hidden');
          tabsLeft.classList.remove('av-theme__hidden');
        }
      }
      if (!optionsSelectedContainer.classList.contains('av-theme__hidden')) {
        optionsSelectedContainer.classList.add('av-theme__hidden');
        optionsContainer.classList.add('av-theme__hidden');
      } else {
        optionsContainer.classList.toggle('av-theme__hidden');
      }
      if (tabsLeft.classList.contains('active')) {
        tabsRight.classList.remove('active');
        deleteAll.classList.add('av-theme__hidden');
      }

      changeStylesInputOptionsContainer(input, optionsContainer, 'focused');
    });
    backdrop.addEventListener('click', () => {
      multiselectComponetClone.classList.remove('zindex100');
      optionsContainer.classList.add('av-theme__hidden');
      optionsSelectedContainer.classList.add('av-theme__hidden');
      deleteAll.classList.add('av-theme__hidden');
      tabs.classList.add('av-theme__hidden');
      if (tabsLeft.classList.contains('active')) {
        tabsRight.classList.remove('active');
        deleteAll.classList.add('av-theme__hidden');
      }
      backdrop.classList.add('av-theme__hidden');

      changeStylesInputOptionsContainer(input, optionsContainer, 'focused');
    });
    tabsLeft.addEventListener('click', () => {
      optionsContainer.classList.remove('av-theme__hidden');
      optionsSelectedContainer.classList.add('av-theme__hidden');
      deleteAll.classList.add('av-theme__hidden');
      tabsLeft.classList.add('active');
      tabsRight.classList.remove('active');
    });
    tabsRight.addEventListener('click', () => {
      optionsContainer.classList.add('av-theme__hidden');
      optionsSelectedContainer.classList.remove('av-theme__hidden');
      deleteAll.classList.remove('av-theme__hidden');
      tabsLeft.classList.remove('active');
      tabsRight.classList.add('active');
    });
    deleteAll.addEventListener('click', () => {
      tabsLeft.classList.add('active');
      tabsRight.classList.remove('active');
      optionsSelectedContainer.classList.add('av-theme__hidden');
      optionsContainer.classList.remove('av-theme__hidden');
      deleteAll.classList.add('av-theme__hidden');
    });
  }
}

// Controlar la apariencia del input y del contenedor de options.
function changeStylesInputOptionsContainer(input, optionsContainer, styleType) {
  if (optionsContainer.classList.contains('av-theme__hidden')) {
    input.classList.remove(styleType);
  } else {
    input.classList.add(styleType);
  }
}

function updateSelectedOptionsDisplay(
  config,
  uniqueId,
  data,
  counter,
  input,
  placeholder,
  optionsContainer,
  optionsSelectedContainer,
  option,
  tabs,
  tabsLeft,
  tabsRight,
  deleteAll,
  errorText,
  hiddenInput,
  selectedIds,
  visibleLimit
) {
  // TODO - Revisar la lógica para que al hacer ckick en "Borrar todo " no se ejecute la función de forma recursiva varias veces.

  // Limpiar el contenedor de visualización.
  optionsSelectedContainer.innerHTML = '';

  // Botón "Borrar todo".
  deleteAll.addEventListener('click', () => {
    selectedIds.length = 0;
    hiddenInput.value = '';

    // Desmarcar todos los options en el selector.
    const allOptions = document.querySelectorAll(
      `.av-theme__ms-option-${uniqueId}`
    );
    allOptions.forEach((option) => {
      option.classList.remove('selected');
    });

    // Actualizar la vista y el contador inmediatamente.
    updateSelectedOptionsDisplay(
      config,
      uniqueId,
      data,
      counter,
      input,
      placeholder,
      optionsContainer,
      optionsSelectedContainer,
      option,
      tabs,
      tabsLeft,
      tabsRight,
      deleteAll,
      errorText,
      hiddenInput,
      selectedIds,
      visibleLimit
    );
  });

  let selectedCounter = 0;
  const selectedOptionElements = [];

  // Recorremos el array data.
  data.forEach((item) => {
    if (selectedIds.includes(item.id)) {
      const selectedOptionElement = document.createElement('div');

      // Usamos el 'name' del item.
      selectedOptionElement.textContent = item.name;
      selectedOptionElement.classList.add('av-theme__ms-selected-option-item');
      selectedOptionElement.classList.add(
        `av-theme__ms-selected-option-item-${uniqueId}`
      );

      // Añadir evento de click para desmarcar el option usando el ID.
      selectedOptionElement.addEventListener('click', () => {
        const optionInSelect = document.querySelector(
          `.av-theme__ms-option-${uniqueId}[data-id="${item.id}"]`
        );
        if (optionInSelect) {
          optionInSelect.classList.remove('selected');
        }

        // Actualizamos el input oculto con los IDs restantes.
        hiddenInput.value = hiddenInput.value
          .split(',')
          .filter((selectedId) => selectedId !== item.id)
          .join(',');

        // Modificar el array original de selectedIds.
        const indexToRemove = selectedIds.indexOf(item.id);
        if (indexToRemove !== -1) {
          selectedIds.splice(indexToRemove, 1); // Quitar el ID desmarcado.
        }

        // Actualizamos la lista visual y funcional con los elementos correctos.
        updateSelectedOptionsDisplay(
          config,
          uniqueId,
          data,
          counter,
          input,
          placeholder,
          optionsContainer,
          optionsSelectedContainer,
          option,
          tabs,
          tabsLeft,
          tabsRight,
          deleteAll,
          errorText,
          hiddenInput,
          selectedIds,
          visibleLimit
        );
      });

      // Guardar el elemento seleccionado en un array temporal.
      selectedOptionElements.push(selectedOptionElement);
      selectedCounter++;
    }
  });

  // Mostrar todas las opciones seleccionadas.
  selectedOptionElements.forEach((element, index) => {
    optionsSelectedContainer.appendChild(element);

    // Ocultar las opciones más allá del límite visible.
    if (index >= visibleLimit) {
      element.classList.add('av-theme__hidden');
    }
  });

  // Si hay más de 10 opciones seleccionadas, añadir el ellipsis.
  if (selectedCounter > visibleLimit) {
    const ellipsis = document.createElement('div');
    ellipsis.classList.add('av-theme__ms-option-ellipsis');
    ellipsis.textContent = '...';

    // Lógica para mostrar/ocultar opciones extras al hacer clic en el ellipsis.
    ellipsis.addEventListener('click', () => {
      selectedOptionElements.forEach((element, index) => {
        if (index >= visibleLimit) {
          element.classList.toggle('av-theme__hidden'); // Mostrar/ocultar opciones extras.
        }
      });

      // Cambiar el texto del ellipsis según el estado.
      ellipsis.textContent =
        ellipsis.textContent === '...' ? 'Mostrar menos' : '...';
    });

    // Añadir el ellipsis al final del contenedor.
    optionsSelectedContainer.appendChild(ellipsis);
  }

  // Mostrar u ocultar el contador de opciones seleccionadas.
  if (selectedIds.length === 0) {
    counter.classList.add('av-theme__hidden');
  } else {
    counter.classList.remove('av-theme__hidden');
    counter.textContent = selectedIds.length;
  }

  // Actualizar el texto del placeholder en función de las opciones seleccionadas.
  if (selectedIds.length === 0) {
    placeholder.textContent = config['placeholder-unselected'];
  } else {
    placeholder.textContent = config['placeholder-selected'];
  }

  // Mostrar u ocultar el botón deleteAll en función de las opciones seleccionadas.
  if (config.tags) {
    if (selectedIds.length === 0) {
      deleteAll.classList.add('av-theme__hidden');
    } else {
      deleteAll.classList.remove('av-theme__hidden');
    }
  } else {
    if (selectedIds.length > 0) {
      tabsRight.classList.remove('av-theme__hidden');
    } else {
      tabsRight.classList.add('av-theme__hidden');
      tabsRight.classList.remove('active');
      optionsContainer.classList.remove('av-theme__hidden');
      optionsSelectedContainer.classList.add('av-theme__hidden');
      deleteAll.classList.add('av-theme__hidden');
    }
    if (!optionsContainer.classList.contains('av-theme__hidden')) {
      tabsLeft.classList.add('active');
      tabsRight.classList.remove('active');
      optionsSelectedContainer.classList.add('av-theme__hidden');
    }
    if (!optionsSelectedContainer.classList.contains('av-theme__hidden')) {
      tabsLeft.classList.remove('active');
      tabsRight.classList.add('active');
      optionsContainer.classList.add('av-theme__hidden');
    }
  }
}

function handleOptionClick(
  config,
  uniqueId,
  data,
  counter,
  input,
  placeholder,
  optionsContainer,
  optionsSelectedContainer,
  option,
  tabs,
  tabsLeft,
  tabsRight,
  deleteAll,
  errorText,
  hiddenInput,
  selectedIds,
  visibleLimit
) {
  if (config.multi === true) {
    if (option.classList.contains('selected')) {
      option.classList.remove('selected');
      hiddenInput.value = hiddenInput.value
        .split(',')
        .filter((id) => id !== option.getAttribute('data-id'))
        .join(',');
    } else {
      option.classList.add('selected');
      hiddenInput.value += `${option.getAttribute('data-id')},`;
    }

    selectedIds = hiddenInput.value.split(',').filter(Boolean);

    updateSelectedOptionsDisplay(
      config,
      uniqueId,
      data,
      counter,
      input,
      placeholder,
      optionsContainer,
      optionsSelectedContainer,
      option,
      tabs,
      tabsLeft,
      tabsRight,
      deleteAll,
      errorText,
      hiddenInput,
      selectedIds,
      visibleLimit
    );
  } else {
    option.parentElement
      .querySelectorAll('.av-theme__ms-option')
      .forEach((opt) => opt.classList.remove('selected'));
    option.classList.add('selected');
    hiddenInput.value = option.getAttribute('data-id');

    optionsSelectedContainer.textContent = option.textContent;
  }
}

function fetchOptions(url, callback) {
  const simulatedDataWithSeparators = [
    {type: 'separator', name: 'Sector Primario'},
    {type: 'option', id: '001', name: 'Agricultura'},
    {type: 'option', id: '002', name: 'Ganadería'},
    {type: 'option', id: '003', name: 'Silvicultura'},
    {type: 'option', id: '004', name: 'Pesca'},
    {type: 'separator', name: 'Industria'},
    {type: 'option', id: '101', name: 'Manufactura'},
    {type: 'option', id: '102', name: 'Construcción'},
    {type: 'option', id: '103', name: 'Energía'},
    {type: 'separator', name: 'Servicios'},
    {type: 'option', id: '201', name: 'Transporte'},
    {type: 'option', id: '202', name: 'Educación'},
    {type: 'option', id: '203', name: 'Sanidad'},
    {type: 'option', id: '204', name: 'Turismo'},
  ];
  const simulatedDataWithoutSeparators = [
    {type: 'option', id: '001', name: 'Agricultura'},
    {type: 'option', id: '002', name: 'Ganadería'},
    {type: 'option', id: '003', name: 'Silvicultura'},
    {type: 'option', id: '004', name: 'Pesca'},
    {type: 'option', id: '101', name: 'Manufactura'},
    {type: 'option', id: '102', name: 'Construcción'},
    {type: 'option', id: '103', name: 'Energía'},
    {type: 'option', id: '201', name: 'Transporte'},
    {type: 'option', id: '202', name: 'Educación'},
    {type: 'option', id: '203', name: 'Sanidad'},
    {type: 'option', id: '204', name: 'Turismo'},
  ];

  if (url) {
    fetch(url)
      .then((response) => response.json())
      .then(callback)
      .catch((error) => console.error('Error al cargar los datos:', error));
  } else {
    callback(simulatedDataWithSeparators);
  }
}

// Generar los options.
function populateOptions(
  container,
  data,
  uniqueId,
  visibleLimit,
  optionsStatus
) {
  container.innerHTML = ''; // Limpiar opciones previas.
  let groupCounter = 0;
  let hasSeparator = false; // Variable para verificar si existen separators.
  let totalOptionsCount = 0; // Contador de opciones reales.

  data.forEach((item) => {
    if (item.type === 'separator') {
      hasSeparator = true; // Si hay separadores, marcamos como true.

      // Crear un nuevo div para el separator y añadirlo al contenedor.
      const separator = document.createElement('div');
      separator.classList.add('av-theme__ms-option-separator');
      separator.textContent = item.name;

      // Generar un identificador único para el grupo.
      const groupId = `option-group-${uniqueId}-${groupCounter}`;
      separator.setAttribute('data-group-id', groupId);

      // Añadir evento de click para colapsar el grupo.
      separator.addEventListener('click', () => {
        const group = document.getElementById(groupId);
        separator.classList.toggle('av-theme__ms-option-separator--collapsed');
        group.classList.toggle('av-theme__hidden');
      });

      container.appendChild(separator);

      // Crear el contenedor del grupo de opciones y añadirlo al contenedor.
      const optionGroup = document.createElement('div');
      optionGroup.classList.add('av-theme__ms-option-group');
      optionGroup.id = groupId;

      container.appendChild(optionGroup);

      groupCounter++;
    } else {
      // Buscar el último grupo añadido o el contenedor principal si no hay separadores.
      let optionGroup = container.lastElementChild;

      // Si no hay separadores, crear un grupo por defecto.
      if (!hasSeparator && !optionGroup) {
        optionGroup = document.createElement('div');
        optionGroup.classList.add('av-theme__ms-option-group');
        optionGroup.id = `default-group-${uniqueId}-${groupCounter}`;
        container.appendChild(optionGroup);
      }

      // Crear la opción y añadirla al grupo actual.
      const option = document.createElement('div');
      option.classList.add('av-theme__ms-option');
      option.classList.add(`av-theme__ms-option-${uniqueId}`);
      option.setAttribute('data-id', item.id);
      option.textContent = item.name;

      optionGroup.appendChild(option);

      // Incrementar el contador de opciones.
      totalOptionsCount++;
    }
  });

  // Verificar el éxito basándonos en el número de opciones reales (no grupos ni separadores).
  optionsStatus.success = totalOptionsCount > 0;

  // Verificamos los grupos de opciones para agregar el ellipsis si es necesario.
  const optionGroups = container.querySelectorAll('.av-theme__ms-option-group');

  optionGroups.forEach((group) => {
    const optionsInGroup = group.querySelectorAll(
      `.av-theme__ms-option.av-theme__ms-option-${uniqueId}`
    );

    // Si hay más de visibleLimit opciones, ocultar a partir de la opción visibleLimit.
    if (optionsInGroup.length > visibleLimit) {
      optionsInGroup.forEach((option, index) => {
        if (index >= visibleLimit) {
          option.classList.add('av-theme__hidden');
        }
      });

      // Crear el ellipsis y añadirlo al final del grupo.
      const ellipsis = document.createElement('div');
      ellipsis.classList.add('av-theme__ms-option-ellipsis');
      ellipsis.textContent = '...';

      // Añadir evento de click para mostrar/ocultar las opciones extra.
      ellipsis.addEventListener('click', () => {
        optionsInGroup.forEach((option, index) => {
          if (index >= visibleLimit) {
            option.classList.toggle('av-theme__hidden');
          }
        });

        // Cambiar el texto del ellipsis según el estado.
        ellipsis.textContent =
          ellipsis.textContent === '...' ? 'Mostrar menos' : '...';
      });

      group.appendChild(ellipsis);
    }
  });
}
