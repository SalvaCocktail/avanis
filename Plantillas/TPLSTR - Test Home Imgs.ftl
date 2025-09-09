
<div>
<#if (testSatoText.getData())??>
${testSatoText.getData()}
</#if>
</div>

<div>
<#if (testSatoImg.getData())?? && testSatoImg.getData() != "">
<img alt="${testSatoImg.getAttribute("alt")}" data-fileentryid="${testSatoImg.getAttribute("fileEntryId")}" src="${testSatoImg.getData()}" />
    </#if>
  </div>