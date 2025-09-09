Liferay.on('allPortletsReady', function () {

    // Dropdown
    var dropdown = document.querySelector(".profile-dropdown-button");
    dropdown.addEventListener('click', function () {
    var dropdownContent = document.getElementById("dropdown-content");
    dropdownContent.style.display = (dropdownContent.style.display === "block") ? "none" : "block";
});

    var dropdownButton = document.querySelector(".profile-dropdown-button");
    var dropdownContent = document.getElementById("dropdown-content");

    dropdownButton.addEventListener('click', function () {
    dropdownContent.classList.toggle("active");

    var iconArrow = dropdownButton.querySelector(".icon-arrow");

    if (dropdownContent.classList.contains("active")) {
    iconArrow.style.transform = "rotate(-135deg)";
    iconArrow.style.borderColor = "#107e3e";
} else {
    iconArrow.style.transform = "rotate(45deg)";
    iconArrow.style.borderColor = "black";
}
});

    document.addEventListener('DOMContentLoaded', function () {
    var dropdownButton = document.querySelector('.profile-dropdown-button');

    dropdownButton.addEventListener('click', function () {
    dropdownButton.classList.toggle('active');
});
});

// TABS

        var tabs = document.querySelectorAll('.tab-item');
        var contents = document.querySelectorAll('.tab-content');

        // Mapa de pestañas y contenidos
        var tabContentMap = {
            'tab-publicaciones': 'content-publicaciones',
            'tab-acerca-de': 'content-acerca-de',
            'tab-seguidores': 'content-seguidores',
            'tab-seguidos': 'content-seguidos',
            'tab-guardado': 'content-guardado',
        };

        // Función para ocultar todos los contenidos
        function hideAllContents() {
            contents.forEach(content => content.style.display = 'none');
        }

        // Función para eliminar la clase 'active' de todas las pestañas
        function deactivateAllTabs() {
            tabs.forEach(tab => tab.classList.remove('active'));
        }

        // Función para activar una pestaña y mostrar su contenido correspondiente
        function activateTab(tabId) {
            document.querySelector(`#${tabId}`).classList.add('active');
            document.querySelector(`#${tabContentMap[tabId]}`).style.display = 'block';
        }

        // Encuentra la pestaña activa por defecto
        var defaultTab = document.querySelector('.tab-item.active');
        var defaultTabId = defaultTab.id;

        // Ocultar todos los contenidos inicialmente
        hideAllContents();

        // Mostrar el contenido correspondiente a la pestaña activa por defecto
        activateTab(defaultTabId);

        // evento de clic a cada pestaña
        tabs.forEach(tab => {
            tab.addEventListener('click', function() {
                deactivateAllTabs();  // Desactivar todas las pestañas
                hideAllContents();    // Ocultar todos los contenidos
                activateTab(this.id); // Activar la pestaña clickeada y mostrar su contenido
            });
        });

// progress bar

    function setProgress(percent) {
        const progressCircle = document.querySelector('.av-donut .progress');
        const radius = progressCircle.r.baseVal.value;
        const circumference = 2 * Math.PI * radius;
        const offset = circumference - (percent / 100) * circumference;

        progressCircle.style.strokeDasharray = `${circumference} ${circumference}`;
        progressCircle.style.strokeDashoffset = offset;
    }

// Progreso aqui
    setProgress(60);
})