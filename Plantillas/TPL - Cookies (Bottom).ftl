<div class="av-public-layout">
  <div class="av-public-layout__content">
    <#if (cookieTitle.getData())?has_content>
      <h1>${cookieTitle.getData()}</h1>
    </#if>

    <#if (cookieSubtitle.getData())?has_content>
      <p>${cookieSubtitle.getData()}</p>
    </#if>

    <div class="modal fade" tabindex="-1" aria-hidden="true" id="exampleModal" style="display: none;">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <div>
              <#if (cookieModal.modalImage.getData())?? && cookieModal.modalImage.getData() !="">
                <img alt="${cookieModal.modalImage.getAttribute(" alt")}"
                  data-fileentryid="${cookieModal.modalImage.getAttribute(" fileEntryId")}"
                  src="${cookieModal.modalImage.getData()}" />
              </#if>
            </div>
            <div>
              <h5 class="modal-title">
                <#if (cookieModal.modalTitle.getData())?has_content>
                  ${cookieModal.modalTitle.getData()}
                </#if>
              </h5>
            </div>
            <button type="button" id="closeModalButton" class="modal-btn-close-custom" data-bs-dismiss="modal"
              aria-label="Close">
              <img src="/documents/20117/0/close1.svg" alt="Close icon">
            </button>
          </div>

          <div class="modal-body" id="modalBody">
            <div class="modal-nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="horizontal">
              <#assign index=0>
                <#list cookieModal.FSTitleParagraph.getSiblings() as cur_cookieModal_FSTitleParagraph>
                  <#if cur_cookieModal_FSTitleParagraph.FSTitleParagraphTitle.getData()?has_content>
                    <a class="modal-nav-link modal-tab <#if index == 0>active</#if>" id="v-pills-tab-${index}"
                      href="#v-pills-${index}" role="tab" aria-controls="v-pills-${index}"
                      aria-selected="<#if index == 0>true<#else>false</#if>">
                      ${cur_cookieModal_FSTitleParagraph.FSTitleParagraphTitle.getData()}
                    </a>
                  </#if>
                  <#assign index=index + 1>
                </#list>
            </div>
            <div class="tab-content" id="v-pills-tabContent">
              <#assign index=0>
                <#list cookieModal.FSTitleParagraph.getSiblings() as cur_cookieModal_FSTitleParagraph>
                  <#if cur_cookieModal_FSTitleParagraph.FSTitleParagraphParagraph.getData()?has_content>
                    <div class="tab-pane fade <#if index == 0>show active</#if>" id="v-pills-${index}" role="tabpanel"
                      aria-labelledby="v-pills-tab-${index}">
                      ${cur_cookieModal_FSTitleParagraph.FSTitleParagraphParagraph.getData()}
                    </div>
                  </#if>
                  <#assign index=index + 1>
                </#list>
            </div>
          </div>

          <div class="modal-footer">
            <div class="modal-item-last">
              <div class="modal-btn-group">
                <#if cookieModal.FSBtnModal.getSiblings()?has_content>
                  <#assign index=0>
                    <#list cookieModal.FSBtnModal.getSiblings() as cur_cookieModal_FSBtnModal>
                      <#if cur_cookieModal_FSBtnModal.FSBtnText.getData()?has_content>
                        <div>
                          <a class="btn <#if index == 0>modal-btn-primary configuration-cookies-btn<#else>modal-btn-secondary accept-cookies-btn</#if> av-btn-small"
                            href="${cur_cookieModal_FSBtnModal.getData()}">
                            ${cur_cookieModal_FSBtnModal.FSBtnText.getData()}
                          </a>
                        </div>
                      </#if>
                      <#assign index=index + 1>
                    </#list>
                </#if>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div id="ot-sdk-cookie-policy"></div>

    <#if FSCookies.getSiblings()?has_content>
      <#list FSCookies.getSiblings() as cur_FSCookies>
        <#if cur_FSCookies.getSiblings()??>
          <div class="cookies-dropdown__tab-question">
            <div class="cookies-dropdown__tab-question-header">
              <!-- Titular/pregunta -->
              <#if (cur_FSCookies.FSTitleParagraphTitle_1.getData())?has_content>
                <h2 class="cookies-dropdown__question">${cur_FSCookies.FSTitleParagraphTitle_1.getData()}</h2>
              </#if>
              <!-- Icono (chevron) -->
              <div
                class="cookies-dropdown__question-chevron cookies-dropdown__question-chevron--down cookies-dropdown__question-chevron--active">
              </div>
            </div>
            <!-- Texto/respuesta -->
            <#if (cur_FSCookies.FSTitleParagraphParagraph_1.getData())?has_content>
              <div class="cookies-dropdown__answer cookies-dropdown__answer--collapsed">${cur_FSCookies.FSTitleParagraphParagraph_1.getData()}</div>
            </#if>
          </div>
        </#if>
      </#list>
    </#if>
  </div>
</div>

<script>
  Liferay.on('allPortletsReady', function () {
const fragmentModal = document.getElementById('exampleModal');
const toggleLink = document.getElementById('toggleModal');
const closeModalButton = document.getElementById('closeModalButton');
const acceptCookiesButton = document.querySelector('.accept-cookies-btn');
const cookieConfigurationButton = document.querySelector('.configuration-cookies-btn');
const modalBody = document.querySelector('.modal-body');
const delay = 200;
let backdrop;

const closeModal = () => {
if (backdrop) {
document.body.removeChild(backdrop);
}
      fragmentModal.classList.remove('show');
      setTimeout(() => fragmentModal.style.display = 'none', delay);
    };

    closeModalButton.addEventListener('click', closeModal);
    acceptCookiesButton.addEventListener('click', function (event) {
event.preventDefault();
document.cookie = "cookiesAccepted=true; path=/";
closeModal();
});

    cookieConfigurationButton.addEventListener('click', function (event) {
event.preventDefault();
closeModal();
});

    toggleLink.addEventListener('click', function (event) {
event.preventDefault();
fragmentModal.style.display = 'block';
setTimeout(() => {
fragmentModal.classList.add('show');
if (window.innerWidth <= 567) {
modalBody.classList.add('scrollable');
}
      }, 10);
      backdrop = document.createElement('div');
      backdrop.className = 'modal-backdrop modal-fade show';
      document.body.appendChild(backdrop);
    });

    const tabLinks = document.querySelectorAll('.modal-nav-link');
    tabLinks.forEach(tab => {
tab.addEventListener('click', function (event) {
event.preventDefault();
tabLinks.forEach(link => link.classList.remove('active'));
const tabContents = document.querySelectorAll('.tab-pane');
tabContents.forEach(content => content.classList.remove('show', 'active'));

const target = document.querySelector(this.getAttribute('href'));
this.classList.add('active');
target.classList.add('show', 'active');

if (window.innerWidth <= 567) {
if (this.getAttribute('id') === 'v-pills-tab-0') {
modalBody.classList.add('scrollable');
} else {
modalBody.classList.remove('scrollable');
}
        }
      });
    });
  });
</script>