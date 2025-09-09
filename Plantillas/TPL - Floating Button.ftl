<div class="av-btn-floating">
  <#if (floatingButton.fsBtnText.getData())?has_content>
    <a data-senna-off="true" href="${floatingButton.fsBtnLink.getData()}">
	    ${floatingButton.fsBtnText.getData()}
    </a>
  </#if>
</div>
