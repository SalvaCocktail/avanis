<style>
@import url('https://fonts.googleapis.com/css2?family=Inter:wght@100..900&display=swap');

	body {
background-color: #fff;
}

.fcl {
width: 100%;
display: flex;
justify-content: center;
align-items: flex-start;
}

.fcl-container {
width: 100%;
height: fit-content;
max-width: 1440px;
display: flex;
flex-direction: column;
justify-content: flex-start;
align-items: center;
}

.fcl__title {
width: 100%;
padding: 16px 0;
text-align: left;
font-family: 'Inter', sans-serif;
font-size: 32px;
font-weight: 600;
line-height: 48px;
text-align: left;
}

.fcl #myTabContent {
width: 100%;
}

.fcl__tab-container{
position: relative;
width: 100%;
margin-bottom: 48px;
display: flex;
justify-content: flex-start;
align-items: center;
flex-wrap: nowrap;


}

.fcl__tab-container-gradient{
position: absolute;
top: 0;
left: 0;
width: 100%;
height: 55px;
z-index: 1;
background: linear-gradient(90deg, rgba(255,255,255,0) 0%, rgba(255,255,255,0) 65%, rgba(255,255,255,1) 100%);
pointer-events: none;
}

.fcl__tabs {
width: 100%;
display: flex;
justify-content: flex-start;
align-items: center;
}

.fcl__tabs li {
display: flex;
justify-content: center;
align-items: center;
}

.fcl__tabs li button,
.fcl__tabs .active,
.nav-tabs .nav-link {
padding: 8px 8px 16px 8px;
font-family: 'Inter', sans-serif;
font-size: 16px;
font-weight: 400;
line-height: 24px;
text-align: left;
color: #101717;
background-color: transparent;
border: none;
}
.nav-tabs .nav-link.active {
font-weight: 600;
background-color: transparent;
border: none;

}

.nav-tabs .nav-link:hover,
.nav-tabs .nav-link.hover {
border: none;
}

.fcl__tabs li:has(.active) {
margin-top: 4px;
border-bottom: 4px solid #107e3e;
}

.fcl-container ul {
display: flex;
gap: 16px;
flex-wrap: nowrap;
border: none;
overflow: scroll;
}

.fcl__tab-question {
width: 100%;
padding: 24px 0;
display: flex;
flex-direction: column;
justify-content: flex-start;
align-items: flex-start;
gap: 24px;
border-bottom: 1px solid #bfc7c6;
}
.fcl__tab-question:hover {
cursor: pointer;
}

.fcl__tab-question-top {
width: 100%;
display: flex;
justify-content: space-between;
align-items: center;
}

.fcl__question {
font-family: 'Inter', sans-serif;
font-size: 20px;
font-weight: 600;
line-height: 32px;
text-align: left;
color: #101717;
}

.fcl__question-arrow {
width: 32px;
height: 32px;
min-width: 24px;
min-height: 24px;

background-repeat: no-repeat;
background-size: contain;
background-position: center center;

transition: all 0.3s;
}

.fcl__question-arrow--more {
background-image: url('/documents/d/guest/faq-more');
}

.fcl__question-arrow--minus {
background-image: url('/documents/d/guest/faq-minus');
}

.fcl__answer {
width: 100%;
display: inline-block;
transition: all 0.3s;
}

.fcl__answer.fcl__answer--collapsed {
display: none;
}

.fcl__answer p {
font-family: 'Inter', sans-serif;
font-size: 16px;
font-weight: 400;
line-height: 24px;
text-align: left;
color: #101717;
}
</style>




<div class="faqs-container-lfr fcl">
  <div class="fcl-container">

    <!-- Titulo -->
    <#if (faqsTitle.getData())?has_content>
      <h2 class="fcl__title">
        ${faqsTitle.getData()}
      </h2>
    </#if>

		<!-- Pestañas -->
		<#if faqsTabs.getSiblings()?has_content>
      <div class="fcl__tab-container">

        <div class="fcl__tab-container-gradient"></div>

				<ul class="nav nav-tabs fcl__tabs" id="myTab" role="tablist">
					<#list faqsTabs.getSiblings() as cur_faqsTabs>
						<#if (cur_faqsTabs.getData())??>

							<#assign rawTabId = cur_faqsTabs.faqsTabName.getData()>
							<#assign tabId = rawTabId?replace("[^a-zA-Z0-9]", "", "r")>

							<#if (cur_faqsTabs.faqsTabName.getData())?has_content>
								<li class="nav-item" role="presentation">
									<button class="nav-link fcl__tab-btn" id="home-tab" data-toggle="tab" data-target="#${tabId}" type="button" role="tab" aria-controls="home" aria-selected="true">
										${cur_faqsTabs.faqsTabName.getData()}
									</button>
								</li>
							</#if>

						</#if>
					</#list>
				</ul>

      </div>
    </#if>

    <!-- Preguntas y Respuestas -->
    <#if faqsTabs.getSiblings()?has_content>
      <#list faqsTabs.getSiblings() as cur_faqsTabs>
        <#if (cur_faqsTabs.getData())??>

          <#if cur_faqsTabs.faqsTabQuestion.getSiblings()?has_content>
            <#list cur_faqsTabs.faqsTabQuestion.getSiblings() as cur_faqsTabs_faqsTabQuestion>
              <#if (cur_faqsTabs_faqsTabQuestion.getData())??>

              <#assign rawTabId = cur_faqsTabs.faqsTabName.getData()>
              <#assign tabId = rawTabId?replace("[^a-zA-Z0-9]", "", "r")>

              <div class="tab-content" id="myTabContent">
                <div class="tab-pane fade fcl__tab-question" id="${tabId}" role="tabpanel" aria-labelledby="home-tab">

                  <div class="fcl__tab-question-top">

                    <!-- Pregunta -->
                    <#if (cur_faqsTabs_faqsTabQuestion.questionQuestion.getData())?has_content>
                      <h4 class="fcl__question">
                        ${cur_faqsTabs_faqsTabQuestion.questionQuestion.getData()}
                      </h4>
                    </#if>

                    <!-- Flechitas -->
                    <div class="fcl__question-arrow fcl__question-arrow--more fcl__question-arrow--active"></div>

                  </div>

                  <!-- Respuesta -->
                  <#if (faqsTabs.faqsTabQuestion.questionAnswer.getData())?has_content>
                    <div class="fcl__answer fcl__answer--collapsed">
                      ${faqsTabs.faqsTabQuestion.questionAnswer.getData()}
                    </div>
                  </#if>

                </div>
              </div>

              </#if>
            </#list>
          </#if>

        </#if>
      </#list>
    </#if>

  </div>
</div>

<script>
// Función para inicializar los eventos de las pestañas.
function initializeTabEvents() {
// Seleccionar todos los elementos con la clase "fcl__tab-btn".
var tabButtons = document.querySelectorAll('.fcl__tab-btn');

    // Función para manejar los clics en los botones de las pestañas.
    function handleTabClick(event) {
// Obtener el botón clickado.
var clickedButton = event.currentTarget;

// Remover la clase "active" del botón "fcl__tab-btn" que la tiene actualmente.
document
.querySelector('.fcl__tab-btn.active')
?.classList.remove('active');

// Añadir la clase "active" al botón clickado.
clickedButton.classList.add('active');

// Obtener el valor de "data-target" del botón clickado.
var targetId = clickedButton.getAttribute('data-target').substring(1);

// Remover las clases "show" y "active" de los elementos "fcl__tab-question".
document
.querySelectorAll('.fcl__tab-question.show, .fcl__tab-question.active')
.forEach(function (element) {
element.classList.remove('show', 'active');
});

        // Añadir las clases "show" y "active" a todos los elementos "fcl__tab-question" cuyo id corresponde al "data-target".
        document
.querySelectorAll('.fcl__tab-question[id="' + targetId + '"]')
.forEach(function (element) {
element.classList.add('show', 'active');
});
}

// Añadir el event listener a cada botón.
tabButtons.forEach(function (button) {
button.addEventListener('click', handleTabClick);
});

// Activar el primer botón y su correspondiente contenido al cargar la página.
if (tabButtons.length > 0) {
tabButtons[0].classList.add('active');
var firstDataTarget = tabButtons[0]
.getAttribute('data-target')
.substring(1);
document
.querySelectorAll('.fcl__tab-question[id="' + firstDataTarget + '"]')
.forEach(function (element) {
element.classList.add('show', 'active');
});
}
}

// Función para inicializar los eventos de las preguntas.
function initializeQuestionEvents() {
document.querySelectorAll('.fcl__tab-question').forEach(function (tabQuestion) {
tabQuestion.addEventListener('click', function (event) {
const answerElement = tabQuestion.querySelector('.fcl__answer');
            const arrowElement = tabQuestion.querySelector('.fcl__question-arrow');

            if (answerElement) {
answerElement.classList.toggle('fcl__answer--collapsed');
}

            if (arrowElement) {
arrowElement.classList.toggle('fcl__question-arrow--more');
arrowElement.classList.toggle('fcl__question-arrow--minus');
}
        });
    });
}

// Función principal para inicializar todo.
function initializeFaqs() {
initializeTabEvents();
initializeQuestionEvents();
}

// Inicializar los eventos cuando todos los portlets estén listos.
Liferay.on('allPortletsReady', function () {
initializeFaqs();
});

// Detectar cambios de página y reinicializar los eventos.
Liferay.on('singlePageAppViewLoaded', function (event) {
// Verificar si estamos en la página de FAQs.
if (event.path.includes('/faqs')) {
initializeFaqs();
}
});

</script>
