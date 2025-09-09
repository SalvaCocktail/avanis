<#-- Obtengo a través del Layout de la display page template la URL el título de la noticia-->
<#assign urlTitle = themeDisplay.getURLCurrent()?keep_before("?")?keep_after_last("/")
blogsEntryLocalService = serviceLocator.findService("com.liferay.blogs.service.BlogsEntryLocalService")
         dlFileEntryLocalService = serviceLocator.findService("com.liferay.document.library.kernel.service.DLFileEntryLocalService")
         blogsEntry=blogsEntryLocalService.getEntry(groupId, urlTitle)
/>

<#-- Obtengo los Datos de la noticia y los convierto a formato ISO 8601-->
<#assign iso8601PublishDate = blogsEntry.getDisplayDate()?string("yyyy-MM-dd'T'HH:mm:ss'Z'")>
<#assign iso8601ModifiedDate = blogsEntry.getModifiedDate()?string("yyyy-MM-dd'T'HH:mm:ss'Z'")>
<#assign title = blogsEntry.getModifiedDate()?string("yyyy-MM-dd'T'HH:mm:ss'Z'")>

<#-- Obtengo la imagen de portada-->
    <#if (blogsEntry.getCoverImageFileEntryId()?? && blogsEntry.getCoverImageFileEntryId() != 0)>
        <#assign coverImage = blogsEntry.getCoverImageURL(themeDisplay)>
        <img src="${coverImage}" alt="Cover Image">
    </#if>

<#-- Uso la etiqueta liferay-util:html-top para agregar una metaetiqueta al head -->
<@liferay_util["html-top"] outputKey="htmltop">
    <meta property="article:published_time" content="${iso8601PublishDate}" />
	<meta property="article:modified_time" content="${iso8601ModifiedDate}" />

	<script type="application/ld+json">
    {
"@context": "https://schema.org",
"@type": "NewsArticle",
"headline": "${blogsEntry.getTitle()}",
"image": [
"${coverImage}"
],
"datePublished": "${iso8601PublishDate}",
"dateModified": "${iso8601ModifiedDate}",
"author": [{
"@type": "Person",
"name": "${blogsEntry.getUserName()}"
}]
    }
    </script>
</@>

