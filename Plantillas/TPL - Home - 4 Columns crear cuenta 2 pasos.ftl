
<style>
.dos_pasos_fosfo{
background-color: #c6e75a;
border-radius: 24px;
padding: 40px 64px;

.home-3-columns__opinion__card__autor__image {
width: auto!important;
min-width: 40px !important;
height: 40px !important;
min-height: 40px !important;
border-radius: unset !important;
gap: 8px;
}
@media (min-width: 769px) {
.home-4-columns__opinion__panel {
display: grid;
grid-template-columns: repeat(4, 1fr);
}
.home-3-columns__opinion__card__autor__image {
height: 48px !important;
min-height: 48px !important;
gap: 8px;
}
}
@media (max-width: 809px) {
.home-3-columns__opinion__card {
border: 0;
padding: 13px;
display: flex;
flex-direction: column;
gap: 16px;
/* max-width: 194px; */
}
.dynNew202406__carousel {
/* width: calc(100vw + 20px); */
padding: 0 40px 0 0;
/* display: flex; */
align-items: flex-start;
gap: 20px;
overflow-x: auto;
scroll-snap-type: x mandatory;
}
.dynNew202406 {
padding: unset;

}

}

@media (max-width: 769px) {
.dynNew202403__card img, .dynNew202406__card img {
width: 100%;
min-height: 170px;
border-radius: unset !important;
object-fit: cover;
aspect-ratio: 15 / 10;
}
.dynNew202406__carousel {
/* width: calc(100vw + 20px); */
padding: 0 40px 0 0;
display: flex;
align-items: flex-start;
gap: 20px;
flex-direction: column;
overflow-x: auto;
scroll-snap-type: x mandatory;
}
.home-3-columns__opinion__card {
border: 0;
padding: 13px;
display: flex;
flex-direction: row;
gap: 16px;
max-width: 88%;
}
}
}

</style>

<section class="dynNew202406">
	<div class="dynNew202406__container home-3-columns__opinion dos_pasos_fosfo">
        <#if (CopyOfhome3ColumnsOpinionTitle.getData())?has_content>
            <h2 class="home-3-columns__opinion__title">${CopyOfhome3ColumnsOpinionTitle.getData()}</h2>
        </#if>
        <#if CopyOfhome3ColumnsOpinionCardOpinion.getSiblings()?has_content>
			<div class="dynNew202406__carousel js-dynNew202406-carousel home-4-columns__opinion__panel">
                <#list CopyOfhome3ColumnsOpinionCardOpinion.getSiblings() as cur_home3ColumnsOpinionCardOpinion>
                    <div class="dynNew202406__card js-dynNew202406-card home-3-columns__opinion__card">
                        <div class="home-3-columns__opinion__card">
                            <div class="home-3-columns__opinion__card__autor">
                                <#if (cur_home3ColumnsOpinionCardOpinion.FSCardOpinionImage.getData())?has_content && cur_home3ColumnsOpinionCardOpinion.FSCardOpinionImage.getData() != "">
                                    <img class="home-3-columns__opinion__card__autor__image" alt="${cur_home3ColumnsOpinionCardOpinion.FSCardOpinionImage.getAttribute("alt")}" data-fileentryid="${cur_home3ColumnsOpinionCardOpinion.FSCardOpinionImage.getAttribute("fileEntryId")}" src="${cur_home3ColumnsOpinionCardOpinion.FSCardOpinionImage.getData()}" />
                                </#if>
                                <div>
                                    <#if (cur_home3ColumnsOpinionCardOpinion.FSCardOpinionAuthor.getData())?has_content>
                                        <h3 class="home-3-columns__opinion__card__autor__title">${cur_home3ColumnsOpinionCardOpinion.FSCardOpinionAuthor.getData()}</h3>
                                    </#if>
                                    <#if (cur_home3ColumnsOpinionCardOpinion.FSCardOpinionPosition.getData())?has_content>
                                        <p class="home-3-columns__opinion__card__autor__position">${cur_home3ColumnsOpinionCardOpinion.FSCardOpinionPosition.getData()}</p>
                                    </#if>
                                </div>
                            </div>
                            <#if (cur_home3ColumnsOpinionCardOpinion.FSCardOpinionDescription.getData())?has_content>
                                <div class="home-3-columns__opinion__card-description">${cur_home3ColumnsOpinionCardOpinion.FSCardOpinionDescription.getData()}</div>
                            </#if>
                        </div>
                    </div>
                </#list>
            </div>
        </#if>


  </div>
</section>

