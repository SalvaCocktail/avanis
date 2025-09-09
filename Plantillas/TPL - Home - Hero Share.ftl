
<div class="home-hero-share">
<div class="home-hero-share--container">
    <#if (homeHeroShareBackgroundLeftImage.getData())?has_content && homeHeroShareBackgroundLeftImage.getData() != "">
        <div class="home-hero-share__background left">
			<img class="home-hero-share__image" alt="${homeHeroShareBackgroundLeftImage.getAttribute("alt")}" data-fileentryid="${homeHeroShareBackgroundLeftImage.getAttribute("fileEntryId")}" src="${homeHeroShareBackgroundLeftImage.getData()}" />
        </div>
    </#if>
	<#if (homeHeroShareBackgroundMobileTopImage.getData())?? && homeHeroShareBackgroundMobileTopImage.getData() != "">
        <div class="home-hero-share__background__mobile home-hero-share__background__mobile__top">
            <img alt="${homeHeroShareBackgroundMobileTopImage.getAttribute("alt")}" data-fileentryid="${homeHeroShareBackgroundMobileTopImage.getAttribute("fileEntryId")}" src="${homeHeroShareBackgroundMobileTopImage.getData()}" />
        </div>
    </#if>
	<div class="home-hero-share__body">
        <#if (homeHeroShareTitle.getData())?has_content>
            <h2 class="home-hero-share__title">${homeHeroShareTitle.getData()}</h2>
        </#if>
        <#if (homeHeroShareSubtitle.getData())?has_content>
            <div class="home-hero-share__subtitle">${homeHeroShareSubtitle.getData()}</div>
        </#if>
        <#if (homeHeroShareDescription.getData())?has_content>
            <div class="home-hero-share__description">${homeHeroShareDescription.getData()}</div>
        </#if>
        <#if homeHeroShareSharesButton.getSiblings()?has_content>
            <div class="home-hero-share__rrss">
                <#list homeHeroShareSharesButton.getSiblings() as cur_homeHeroShareSharesButton>
                    <#if (cur_homeHeroShareSharesButton.FSBtnImgLinkImage.getData())?has_content && cur_homeHeroShareSharesButton.FSBtnImgLinkImage.getData() != "">
                        <a class="home-hero-share__rrss__logo" data-senna-off="true" href="${cur_homeHeroShareSharesButton.FSBtnImgLinkLink.getData()}" target="_blank">
                            <img class="home-hero-share__rrss__image alt="${cur_homeHeroShareSharesButton.FSBtnImgLinkImage.getAttribute("alt")}" data-fileentryid="${cur_homeHeroShareSharesButton.FSBtnImgLinkImage.getAttribute("fileEntryId")}" src="${cur_homeHeroShareSharesButton.FSBtnImgLinkImage.getData()}" />
                        </a>
                    </#if>
                </#list>
            </div>
        </#if>
	</div>
	<#if (homeHeroShareBackgroundMobileBottomImage.getData())?? && homeHeroShareBackgroundMobileBottomImage.getData() != "">
	    <div class="home-hero-share__background__mobile home-hero-share__background__mobile__bottom">
            <img alt="${homeHeroShareBackgroundMobileBottomImage.getAttribute("alt")}" data-fileentryid="${homeHeroShareBackgroundMobileBottomImage.getAttribute("fileEntryId")}" src="${homeHeroShareBackgroundMobileBottomImage.getData()}" />
        </div>
    </#if>
    <#if (homeHeroShareBackgroundRightImage.getData())?has_content && homeHeroShareBackgroundRightImage.getData() != "">
        <div class="home-hero-share__background right">
			<img class="home-hero-share__image" alt="${homeHeroShareBackgroundRightImage.getAttribute("alt")}" data-fileentryid="${homeHeroShareBackgroundRightImage.getAttribute("fileEntryId")}" src="${homeHeroShareBackgroundRightImage.getData()}" />
        </div>
    </#if>
</div>
</div>
