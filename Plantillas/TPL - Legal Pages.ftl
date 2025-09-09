<div class="av-public-layout">
  <div class="av-public-layout__content">
    <#if (legalPages.getData())?has_content>
        <h1>${legalPages.getData()}</h1>
    </#if>

    <#if FSTitleParagraph.getSiblings()?has_content>
        <#list FSTitleParagraph.getSiblings() as cur_FSTitleParagraph>
            <#if cur_FSTitleParagraph.FSTitleParagraphTitle.getData()?has_content>
                <h2>${cur_FSTitleParagraph.FSTitleParagraphTitle.getData()}</h2>
            </#if>
            <#if cur_FSTitleParagraph.FSTitleParagraphParagraph.getData()?has_content>
                <p>${cur_FSTitleParagraph.FSTitleParagraphParagraph.getData()}</p>
            </#if>
        </#list>
    </#if>
  </div>
</div>