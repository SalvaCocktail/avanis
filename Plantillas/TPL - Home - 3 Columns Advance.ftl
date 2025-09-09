<div class="home-3-columns home-3-columns__advance">
    <#if home3ColumnsCard.getSiblings()?has_content>
        <#list home3ColumnsCard.getSiblings() as cur_home3ColumnsCard>
            <#if cur_home3ColumnsCard.getSiblings()??>
                <div class="home-3-columns__advance__card">
                    <#if (cur_home3ColumnsCard.FSCardImageTitleDescriptionImage.getData())?has_content && cur_home3ColumnsCard.FSCardImageTitleDescriptionImage.getData() != "">
                        <div class="home-3-columns__advance__card__image">
												<img alt="${cur_home3ColumnsCard.FSCardImageTitleDescriptionImage.getAttribute("alt")}" data-fileentryid="${cur_home3ColumnsCard.FSCardImageTitleDescriptionImage.getAttribute("fileEntryId")}" src="${cur_home3ColumnsCard.FSCardImageTitleDescriptionImage.getData()}" />
												</div>
                    </#if>

                    <#if (cur_home3ColumnsCard.FSCardImageTitleDescriptionTitle.getData())?has_content>
                        <h3 class="home-3-columns__advance__card__title">${cur_home3ColumnsCard.FSCardImageTitleDescriptionTitle.getData()}</h3>
                    </#if>

                    <#if (cur_home3ColumnsCard.FSCardImageTitleDescriptionDescription.getData())?has_content>
                        <div class="home-3-columns__advance__card__description">${cur_home3ColumnsCard.FSCardImageTitleDescriptionDescription.getData()}</div>
                    </#if>
                </div>
            </#if>

        </#list>
    </#if>
</div>