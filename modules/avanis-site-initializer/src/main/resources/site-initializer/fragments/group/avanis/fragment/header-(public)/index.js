const header = document.querySelector('.header-container');
const navMenIco = document.querySelector('.navbar__menu-icons-mobile');

function openNavbar() {
  header.classList.toggle('navbar-opened');
}
navMenIco.addEventListener('click', openNavbar);