


<div class="home-hero">
	<div class="home-hero__left">
        <#if (Fieldset55343208.titulo.getData())?has_content>
	         <div class="home-hero__title">${Fieldset55343208.titulo.getData()}</div>
        </#if>
    </div>
	<div class="home-hero__right">
	<#if (Fieldset55343208.imagen.getData())?? && Fieldset55343208.imagen.getData() != "">
	<img alt="${Fieldset55343208.imagen.getAttribute("alt")}" data-fileentryid="${Fieldset55343208.imagen.getAttribute("fileEntryId")}" src="${Fieldset55343208.imagen.getData()}" />
</#if>
	</div>
</div>

