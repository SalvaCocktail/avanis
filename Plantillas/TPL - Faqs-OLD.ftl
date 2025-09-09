<div class="faqs ">
  <#if (faqsTitle.getData())?has_content>
    <h1>${faqsTitle.getData()}</h1>
    <#if faqsTabs.getSiblings()?has_content>
      <nav class="navbar navbar-collapse-absolute navbar-expand-md navbar-underline navigation-bar navigation-bar-light">
        <#if faqsTabs.getSiblings()??>
          <div class="collapse navbar-collapse" id="navigationBarCollapse-tab1">
            <ul class="navbar-nav" role="tablist">
              <#assign index = 0>
              <#list faqsTabs.getSiblings() as cur_faqsTabs>
                <#if (cur_faqsTabs.faqsTabName.getData())?has_content>
                  <li class="nav-item active" role="presentation">
                    <button aria-controls="tabPanel${index + 1}" aria-selected="false" class="nav-link" data-fragment-namespace="defaultNamespace" id="tab${index + 1}" role="tab">
                      <span class="navbar-text-truncate" data-lfr-editable-id="title${index + 1}" data-lfr-editable-type="text" data-lfr-priority="1" tabindex="-1">
                        ${cur_faqsTabs.faqsTabName.getData()}
                      </span>
                    </button>
										<p>${cur_faqsTabs.faqsTabQuestion.getData()}</p>
                  </li>
                </#if>
                <#assign index = index + 1>
								<h1>
								  <#if cur_faqsTabs.faqsTabQuestion.getSiblings()?has_content>
	                 <#list cur_faqsTabs.faqsTabQuestion.getSiblings() as cur_faqsTabs_faqsTabQuestion>
		                <#if (cur_faqsTabs_faqsTabQuestion.faqsTabQuestion.questionQuestion.getData())??>
	                   ${cur_faqsTabs_faqsTabQuestion.faqsTabQuestion.questionQuestion.getData()}
                    </#if>
	                 </#list>
                 </#if>
								</h1>
              </#list>
            </ul>
          </div>
        </nav>
      <div >
        <#list faqsTabs.getSiblings() as cur_faqsTabs>
          <#if cur_faqsTabs.faqsTabQuestion.getSiblings()?has_content>
            <#list cur_faqsTabs.faqsTabQuestion.getSiblings() as cur_faqsTabs_faqsTabQuestion>
              <div class="tabcontent">
                <#if (cur_faqsTabs_faqsTabQuestion.questionQuestion.getData())?has_content>
                  <h3>${cur_faqsTabs_faqsTabQuestion.questionQuestion.getData()}</h3>
                </#if>
                <#if (cur_faqsTabs_faqsTabQuestion.questionAnswer.getData())?has_content>
                  <p>${cur_faqsTabs_faqsTabQuestion.questionAnswer.getData()}</p>
                </#if>
              </div>
            </#list>

          </#if>
        </#list>
      </div>
    </#if>
  </#if>
	</#if>
</div>

<style>

</style>
<script>
document.addEventListener("DOMContentLoaded", function() {
// Selecciona todos los botones de pestaña
const navLinks = document.querySelectorAll('[role="tab"]');

  // Función para activar una pestaña específica
  function activateTab(index) {
navLinks.forEach((link, idx) => {
link.setAttribute('aria-selected', idx === index);
if (idx === index) {
link.classList.add('active');
} else {
link.classList.remove('active');
}
    });
  }

  // Función para mostrar el contenido de una pestaña específica
  function showTabContent(index) {
const tabContents = document.querySelectorAll('.tabcontent');
tabContents.forEach((content, idx) => {
content.style.display = idx === index? 'block' : 'none';
});
  }

  // Maneja el evento click en los botones de pestaña
  navLinks.forEach((link, index) => {
link.addEventListener('click', function(e) {
e.preventDefault();
activateTab(index);
showTabContent(index);
});
  });

  // Activa la primera pestaña y muestra su contenido por defecto
  activateTab(0);
  showTabContent(0);
});</script>



