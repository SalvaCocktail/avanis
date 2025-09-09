<div class="home-hero-partners">
    <#if (homeHeroPartnersTitle.getData())?has_content>
        <h2 class="home-hero-partners__title">
            ${homeHeroPartnersTitle.getData()}
        </h2>
    </#if>
    <#if homeHeroPartnersPartner.getSiblings()?has_content>
        <div class="home-hero-partners__list-partner">
            <#list homeHeroPartnersPartner.getSiblings() as cur_homeHeroPartnersPartner>
                <#if (cur_homeHeroPartnersPartner.FSBtnImgLinkLink.getData())?has_content>
                    <#if (cur_homeHeroPartnersPartner.FSBtnImgLinkImage.getData())?has_content && cur_homeHeroPartnersPartner.FSBtnImgLinkImage.getData() != "">
                        <a class="home-hero-partners__list-partner__logo" href="${cur_homeHeroPartnersPartner.FSBtnImgLinkLink.getData()}" target="_blank">
                            <img class="home-hero-partners__partner__image" alt="${cur_homeHeroPartnersPartner.FSBtnImgLinkImage.getAttribute("alt")}" data-fileentryid="${cur_homeHeroPartnersPartner.FSBtnImgLinkImage.getAttribute("fileEntryId")}" src="${cur_homeHeroPartnersPartner.FSBtnImgLinkImage.getData()}" />
                        </a>
                    </#if>
                </#if>
            </#list>
        </div>
    </#if>
</div>
