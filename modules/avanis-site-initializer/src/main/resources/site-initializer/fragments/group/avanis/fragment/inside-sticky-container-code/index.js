document.addEventListener('DOMContentLoaded', function () {
  var control_menu = document.querySelector('.control-menu-container');
  var inside_sticky_element = document.querySelector('.inside-sticky');

  if (layoutMode == 'view') {
    if (control_menu) {
      inside_sticky_element.classList.add('has-control-panel');
    }
  }
});
