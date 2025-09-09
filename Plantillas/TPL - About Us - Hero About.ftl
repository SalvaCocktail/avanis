<div class="about-us-hero-about">
    <div class="about-us-hero-about__left">
        <#if (aboutHeroAboutTitle.getData())?has_content>
            <h1 class="about-us-hero-about__title">
                ${aboutHeroAboutTitle.getData()}
            </h1>
        </#if>
        <#if (aboutHeroAboutDescriptionLeft.getData())?has_content>
            <div class="about-us-hero-about__description">
                ${aboutHeroAboutDescriptionLeft.getData()}
            </div>
        </#if>
    </div>
    <div class="about-us-hero-about__right"         <#if (aboutHeroAboutImage.getData())?has_content && aboutHeroAboutImage.getData() != "">
            style="background-image: url(${aboutHeroAboutImage.getData()})"
        </#if>>
        <#if (aboutHeroAboutDescriptionRight.getData())?has_content>
            <div class="about-us-hero-about__description">
                ${aboutHeroAboutDescriptionRight.getData()}
            </div>
        </#if>

    </div>
</div>