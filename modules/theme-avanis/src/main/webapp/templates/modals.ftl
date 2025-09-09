<!-- Explicación en: modules/theme-avanis/src/main/webapp/templates/modal-global-template.html -->

<div
  id="js-modal"
  class="av-theme__modal js-modal av-theme__hidden"
>
  <div class="av-theme__modal-backdrop js-close-modal"></div>
  <div class="av-theme__modal-container">
    <div class="av-theme__modal-header">
      <h5 id="js-modal-title"></h5>
      <div class="av-theme__icon-box-32 js-close-modal">
        <svg
          width="18"
          height="18"
          viewBox="0 0 18 18"
          fill="none"
          xmlns="http://www.w3.org/2000/svg"
        >
          <path
            d="M1 1L17 17M17 1L1 17"
            stroke="#101717"
            stroke-width="2"
            stroke-linecap="round"
            stroke-linejoin="round"
          />
        </svg>
      </div>
    </div>
    <div
      id="js-modal-body"
      class="av-theme__modal-body"
    ></div>
    <div
      id="js-modal-footer"
      class="av-theme__modal-footer"
    ></div>
  </div>
</div>