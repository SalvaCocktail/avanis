<div class="home-hero-register">
    <#if (homeHeroRegisterTitle.getData())?has_content>
        <div class="home-hero-register__title"> ${homeHeroRegisterTitle.getData()}</div>
    </#if>
    <div class="home-hero-register__steps">
        <#if homeHeroRegisterSteps.getSiblings()?has_content>
            <#list homeHeroRegisterSteps.getSiblings() as cur_homeHeroRegisterSteps>
                <div class="home-hero-register__steps__step">
                    <#if (cur_homeHeroRegisterSteps.fsRegisterStepImage.getData())?has_content && cur_homeHeroRegisterSteps.fsRegisterStepImage.getData() != "">
                        <img class="home-hero-register__steps__step__image" alt="${cur_homeHeroRegisterSteps.fsRegisterStepImage.getAttribute("alt")}" data-fileentryid="${cur_homeHeroRegisterSteps.fsRegisterStepImage.getAttribute("fileEntryId")}" src="${cur_homeHeroRegisterSteps.fsRegisterStepImage.getData()}" />
                    </#if>

                    <#if (cur_homeHeroRegisterSteps.fsRegisterStepText.getData())?has_content>
                        <div class="home-hero-register__steps__step__description">${cur_homeHeroRegisterSteps.fsRegisterStepText.getData()}</div>
                    </#if>
                </div>
            </#list>
        </#if>
        <div class="home-hero-register__btn">
            <#if (homeHeroRegisterLastStep.registerBtnTextBtnText.getData())?has_content>
                ${homeHeroRegisterLastStep.registerBtnTextBtnText.getData()}
            </#if>
            <#if (homeHeroRegisterLastStep.registerBtnTextBtnBtn.fsBtnText.getData())?has_content>
                <a class="home-hero-register__btn" data-senna-off="true" href="${homeHeroRegisterLastStep.registerBtnTextBtnBtn.fsBtnLink.getData()}">
                    ${homeHeroRegisterLastStep.registerBtnTextBtnBtn.fsBtnText.getData()}
                </a>
            </#if>
        </div>
    </div>
</div>