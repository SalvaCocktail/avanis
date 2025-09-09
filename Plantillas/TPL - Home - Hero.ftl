<div class="home-hero">
	<div class="home-hero__left">
		<#if (homeHeroTitle.getData())??>
			<h1 class="home-hero__title">${homeHeroTitle.getData()}</h1>
		</#if>
		<#if homeHeroBtn.getSiblings()?has_content>
			<div class="home-hero__buttons">
				<div class="home-hero__button gtm-home-hero-btn">
					<#if (homeHeroBtn.fsBtnText.getData())??>
						<a data-senna-off="true" href="${homeHeroBtn.fsBtnLink.getData()}">
							${homeHeroBtn.fsBtnText.getData()}
						</a>
					</#if>
				</div>
				<div class="home-hero__button secondary">
					<#if (homeHeroSecondaryBtn.Field98812464.getData())??>
						<a data-senna-off="true" href="${homeHeroSecondaryBtn.Field51883831.getData()}">
							${homeHeroSecondaryBtn.Field98812464.getData()}
						</a>
					</#if>
				</div>
			</div>
		</#if>
		</div>
	<div class="home-hero__right">

<#if (homeHeroImage.getData())?? && homeHeroImage.getData() != "">
			<img class="home-hero__image" alt="${homeHeroImage.getAttribute("alt")}" data-fileentryid="${homeHeroImage.getAttribute("fileEntryId")}" src="${homeHeroImage.getData()}" />
		</#if>

</div>
</div>

