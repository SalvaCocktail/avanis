<style>
  @import url('https://fonts.googleapis.com/css2?family=Inter:wght@100..900&display=swap');

  .hidden {
    display: none !important;
  }

  body {
    background-color: #ffffff;
  }

  .cookies-dropdown__tab-question {
    align-items: flex-start;
    border-bottom: 1px solid #bfc7c6;
    display: flex;
    flex-direction: column;
    gap: 24px;
    justify-content: flex-start;
    padding: 24px 0;
    width: 100%;
  }

  .cookies-dropdown__tab-question:hover {
    cursor: pointer;
  }

  .cookies-dropdown__tab-question-header {
    align-items: center;
    display: flex;
    justify-content: space-between;
    width: 100%;
  }

  .cookies-dropdown__question {
    color: #101717;
    font-family: 'Inter', sans-serif;
    font-size: 20px;
    font-weight: 600;
    line-height: 32px;
    text-align: left;
  }

  .cookies-dropdown__question-chevron {
    background-position: center center;
    background-repeat: no-repeat;
    background-size: contain;
    height: 32px;
    min-height: 24px;
    min-width: 24px;
    transition: all 0.3s;
    width: 32px;
  }

  .cookies-dropdown__question-chevron--down {
    background-image: url('/documents/d/guest/faq-more');
  }

  .cookies-dropdown__question-chevron--up {
    background-image: url('/documents/d/guest/faq-minus');
  }

  .cookies-dropdown__answer {
    display: inline-block;
    transition: all 0.3s;
    width: 100%;
  }

  .cookies-dropdown__answer.cookies-dropdown__answer--collapsed {
    display: none;
  }

  .cookies-dropdown__answer p {
    color: #101717;
    font-family: 'Inter', sans-serif;
    font-size: 16px;
    font-weight: 400;
    line-height: 24px;
    text-align: left;
  }
</style>

<div class="av-public-layout">
  <div class="av-public-layout__content">
    <div class="center-cookies" style="margin-right: 10%; border: 1px solid; margin-left: 10%; text-align: center;">
      <#if (cookieSubtitle.getData())?has_content>
        <p style="margin-top: 1em; margin-bottom: 1em; text-align: center;">${cookieSubtitle.getData()}</p>
      </#if>
      <div>
        <strong>
          <a href="#" id="toggleModal"
             style="border: none; background: none; cursor: pointer; text-decoration: underline !important;">CONFIGURAR
            COOKIES</a>
        </strong>
      </div>
    </div>

    <#if (cookieTitle.getData())?has_content>
      <h1>${cookieTitle.getData()}</h1>
    </#if>

    <#if (cookiesPrologue.getData())?has_content>
      <p>${cookiesPrologue.getData()}</p>
    </#if>

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
    const toggleLink = document.getElementById('toggleModal');

    toggleLink.addEventListener('click', function (event) {
      event.preventDefault();
      let element = document.getElementById("onetrust-pc-sdk");
      element.classList.remove("ot-hide");
      element.removeAttribute("style");
    });
  });

  // Función para inicializar los dropdown
  function initializeQuestionEvents() {
    document.querySelectorAll('.cookies-dropdown__tab-question').forEach(function (tabQuestion) {
      tabQuestion.addEventListener('click', function (event) {
        const answerElement = tabQuestion.querySelector('.cookies-dropdown__answer');
        const chevronElement = tabQuestion.querySelector('.cookies-dropdown__question-chevron');

        if (answerElement) {
          answerElement.classList.toggle('cookies-dropdown__answer--collapsed');
        }

        if (chevronElement) {
          chevronElement.classList.toggle('cookies-dropdown__question-chevron--up');
          chevronElement.classList.toggle('cookies-dropdown__question-chevron--down');
        }
      });
    });
  }

  // Función principal para inicializar todo
  function initializeFaqs() {
    initializeQuestionEvents();
  }

  // Inicializar los eventos cuando todos los portlets estén listos
  Liferay.on('allPortletsReady', function () {
    initializeFaqs();
  });

  // Detectar cambios de página y reinicializar los eventos
  Liferay.on('singlePageAppViewLoaded', function (event) {
    // Verificar si estamos en la página de Cookies
    if (event.path.includes('/cookies')) {
      initializeFaqs();
    }
  });
</script>