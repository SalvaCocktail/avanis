var header = document.querySelector('.header-container');
var navMenIco = document.querySelector('.navbar__menu-icons-mobile');

if (navMenIco && !navMenIco.dataset.eventBound) {
  navMenIco.addEventListener('click', openNavbar);

  navMenIco.dataset.eventBound = true;
}

function openNavbar() {
  header.classList.toggle('navbar-opened');
}