const notificationIcons = document.querySelectorAll(
 '.navbar__cta .user-avatar-link a'
);
const notificationIconBells = document.querySelectorAll(
  '.navbar__cta .navbar__cta-bottom-bell-icon'
);
const notificationIconBellsMobile = document.querySelectorAll(
  '.navbar__cta.navbar__cta--top > img'
);

const avnfPopover = document.querySelector('.av-nf-popover');
const avnfBackdrop = document.querySelector('.av-nf-modal-backdrop');

notificationIcons.forEach(function (item) {
  item.addEventListener('click', function (event) {
    event.preventDefault();
    avnfPopover.classList.toggle('avnfVisible');
    addUnreadCircle();
  });
});

notificationIconBells.forEach(function (item) {
  item.addEventListener('click', function (event) {
    event.preventDefault();
    avnfPopover.classList.toggle('avnfVisible');
    addUnreadCircle();
  });
});

notificationIconBellsMobile.forEach(function (item) {
  item.addEventListener('click', function (event) {
    event.preventDefault();
    avnfPopover.classList.toggle('avnfVisible');
    addUnreadCircle();
  });
});

avnfBackdrop.addEventListener('click', function (event) {
  avnfPopover.classList.toggle('avnfVisible');
});

function addUnreadCircle() {
  var contentElements = document.querySelectorAll(
    '.av-nf-popover .list-group-item.list-group-item-flex.list-group-item-primary'
  );

  contentElements.forEach(function (contentElement) {
    var unreadNotification = document.createElement('div');
    unreadNotification.classList.add('unread-notification');

    contentElement.appendChild(unreadNotification);
  });
}
