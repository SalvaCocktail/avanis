<section class="dynNew202406">
	<div class="dynNew202406__container home-3-columns__opinion">
        <#if (home3ColumnsOpinionTitle.getData())?has_content>
            <h2 class="home-3-columns__opinion__title">${home3ColumnsOpinionTitle.getData()}</h2>
        </#if>
        <#if home3ColumnsOpinionCardOpinion.getSiblings()?has_content>
			<div class="dynNew202406__carousel js-dynNew202406-carousel home-3-columns__opinion__panel">
                <#list home3ColumnsOpinionCardOpinion.getSiblings() as cur_home3ColumnsOpinionCardOpinion>
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

    <div class="dynNew202406__bottom">
      <div class="dynNew202406__indicator-container">
        <div class="dynNew202406__indicator js-dynNew202406-indicator">
          <span class="dynNew202406__indicator-item dynNew202406__indicator-item--preselected" style="background-color: #aaa"></span>
          <span class="dynNew202406__indicator-item"></span>
          <span class="dynNew202406__indicator-item"></span>
        </div>
      </div>
      <div class="dynNew202406__arrows js-dynNew202406-arrows">
        <span class="dynNew202406__arrow js-dynNew202406-arrow-left"></span>
        <span class="dynNew202406__arrow dynNew202406__arrow--right js-dynNew202406-arrow-right"></span>
      </div>
    </div>
  </div>
</section>

<script>
  Liferay.on('allPortletsReady', function () {
// Control del carrusel de noticias dinámicas.
if (typeof galleryMapDN202406 === 'undefined') {
var galleryMapDN202406 = document.querySelector('.js-dynNew202406-carousel');
}
    if (typeof lastScrollLeftDN === 'undefined') {
var lastScrollLeftDN = galleryMapDN202406.scrollLeft;
}
    if (typeof prevButton202406 === 'undefined') {
var prevButton202406 = document.querySelector('.js-dynNew202406-arrow-left');
}
    if (typeof nextButton202406 === 'undefined') {
var nextButton202406 = document.querySelector('.js-dynNew202406-arrow-right');
}
    if (typeof indicatorsDN202406 === 'undefined') {
var indicatorsDN202406 = document.querySelectorAll(
'.js-dynNew202406-indicator span'
);
}

    galleryMapDN202406.addEventListener('scroll', function () {
const currentScrollLeftDN202406 = galleryMapDN202406.scrollLeft;
if (currentScrollLeftDN202406 !== lastScrollLeftDN) {
const cards202406 = galleryMapDN202406.querySelectorAll('.js-dynNew202406-card');
cards202406.forEach((card, index) => {
if (
card.offsetLeft <= currentScrollLeftDN202406 + 180 &&
card.offsetLeft + card.offsetWidth > currentScrollLeftDN202406 + 180
) {
cards202406.forEach((t) => t.classList.remove('active'));
card.classList.add('active');
const indicatorsDN202406 = document.querySelectorAll(
'.js-dynNew202406-indicator span'
);
indicatorsDN202406.forEach((indicator, i) => {
if (i === index) {
indicator.style.backgroundColor = '#aaaaaa';
} else {
indicator.style.backgroundColor = '#329c5e';
}
            });
          }
        });
        lastScrollLeftDN = currentScrollLeftDN202406;
      }
    });

    // Marcar la primera tarjeta como activa por defecto.
    const firstCardActive202406 = galleryMapDN202406.querySelector('.js-dynNew202406-card');
    firstCardActive202406.classList.add('active');

    // Iterar sobre los indicadores y agregar el event listener para cada uno.
    indicatorsDN202406.forEach((indicator, index) => {
indicator.addEventListener('click', () => {
// Seleccionar todas las tarjetas de la galería.
const cards202406 = galleryMapDN202406.querySelectorAll('.js-dynNew202406-card');
if (typeof tarjetaObjetivoDN202406 === 'undefined') {
var tarjetaObjetivoDN202406 = cards202406[index];
}

        // Encontrar la tarjeta activa.
        cards202406.forEach((card, cardIndex) => {
if (card.classList.contains('active')) {
tarjetaObjetivoDN202406 = card;

console.log(
'tarjetaObjetivoDN202406.offsetLeft - 0',
tarjetaObjetivoDN202406.offsetLeft
);

// Calcular el valor de desplazamiento.
const newLeft202406 =
card.offsetLeft + (index - cardIndex) * card.offsetWidth;
console.log(
'tarjetaObjetivoDN202406.offsetLeft - 2',
tarjetaObjetivoDN202406.offsetLeft
);
console.log('newLeft202406', newLeft202406);

// Realizar el desplazamiento.
galleryMapDN202406.scrollTo({
left: newLeft202406,
behavior: 'smooth',
});
          }
        });
      });
    });

    // Event listener para el botón de flecha izquierda.
    prevButton202406.addEventListener('click', () => {
scrollGallery202406(-1); // Desplazar hacia la izquierda.
});

    // Event listener para el botón de flecha derecha.
    nextButton202406.addEventListener('click', () => {
scrollGallery202406(1); // Desplazar hacia la derecha.
});

    // Función para desplazar la galería.
    function scrollGallery202406(direction) {
const cards202406 = galleryMapDN202406.querySelectorAll('.js-dynNew202406-card');
let tarjetaObjetivoDN202406 = null;

// Encontrar la tarjeta activa.
cards202406.forEach((card) => {
if (card.classList.contains('active')) {
tarjetaObjetivoDN202406 = card;
}
      });

      // Calcular el nuevo valor de desplazamiento.
      const newLeft202406 =
        tarjetaObjetivoDN202406.offsetLeft +
        direction * tarjetaObjetivoDN202406.offsetWidth;

      // Realizar el desplazamiento.
      galleryMapDN202406.scrollTo({
left: newLeft202406,
behavior: 'smooth',
});
    }

    // Cortar el texto de las noticias dinámicas en un número de caracteres y añadir puntos suspensivos.
    function funCutText202406(cardText, limit) {
let cutText202406 = cardText.textContent;
if (cutText202406.length > limit) {
cardText.textContent = cutText202406.substring(0, limit) + '...';
}
    }

    if (typeof cardTexts202406 === 'undefined') {
var cardTexts202406 = document.querySelectorAll(
'.js-dynNew202406-card-paragraph'
);
}

    cardTexts202406.forEach((cardText) => {
funCutText202406(cardText, 140);
});
  });
</script>