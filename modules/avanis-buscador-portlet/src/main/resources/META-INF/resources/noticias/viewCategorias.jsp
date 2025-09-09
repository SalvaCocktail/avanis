<%@ include file="../init.jsp" %>
<jsp:directive.page contentType="text/html" pageEncoding="UTF-8" />

<portlet:resourceURL var="cargarMasNoticias" id="/cargarMasNoticias"/>
<portlet:resourceURL var="filtrarNoticias" id="/filtrarNoticias"/>

<div class="resultado-busqueda-actualidad">
	<c:choose>
		<c:when test="${empty listaNoticias}">
			<div class="custom-empty-message">
				<img alt="" class="preview-file-image-vectorial" src="https://www.dev.avanis.es/documents/20117/50719/no-results.svg">
				<p>No hay resultados.</p>
			</div>
		</c:when>
		<c:otherwise>
		    <c:if test="${mostrarTitulos}">
                <c:choose>
                    <c:when test="${empty categoriaPrincipal}">
                        <h2>#${categoria}</h2>
                    </c:when>
                    <c:otherwise>
                        <h2>#${categoriaPrincipal} / #${categoria}</h2>
                    </c:otherwise>
                </c:choose>
            </c:if>

            <div class="div-search-categorias" style="display: flex;align-items: center;gap: 1rem;">
                <div class="categorias"></div>
                <div class="av-lm-cr__search-input-box">
                    <input type="search" id="buscar-productos" placeholder="Buscar" class="av-lm-cr__search-input">
                    <div class="av-theme__icon-box-24 av-lm-cr__search-icon">
                        <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                            <path fill-rule="evenodd" clip-rule="evenodd" d="M11 4C7.13401 4 4 7.13401 4 11C4 14.866 7.13401 18 11 18C14.866 18 18 14.866 18 11C18 7.13401 14.866 4 11 4ZM2 11C2 6.02944 6.02944 2 11 2C15.9706 2 20 6.02944 20 11C20 13.1242 19.2641 15.0765 18.0334 16.6159L21.7074 20.2932C22.0978 20.6839 22.0975 21.3171 21.7068 21.7074C21.3161 22.0978 20.6829 22.0975 20.2926 21.7068L16.6195 18.0304C15.0796 19.2629 13.1259 20 11 20C6.02944 20 2 15.9706 2 11ZM10 6C10 5.44772 10.4477 5 11 5C14.3137 5 17 7.68629 17 11C17 11.5523 16.5523 12 16 12C15.4477 12 15 11.5523 15 11C15 8.79086 13.2091 7 11 7C10.4477 7 10 6.55228 10 6Z" fill="#101717"></path>
                        </svg>
                    </div>
                </div>
            </div>

            <h4 id="totalResultados">
                Resultados encontrados: ${totalBlogs}
            </h4>

			<ul class="noticias-list av-columns-responsive-3" id="list-noticias">
				<%@ include file="card.jsp" %>
			</ul>

			<div id="loadMoreContainer" class="av-load-more__container">
                <button id="loadMore" class="av-load-more__btn gtm-load-more-btn" data-start="6" data-total="${totalBlogs}">
                    Cargar más
                </button>
            </div>
		</c:otherwise>
	</c:choose>
</div>

<script>
$(document).ready(function () {
    var url = '${urlPortal}' + '/o/categorias/getCategoriasHijaPorNombre?separator=true&nombre='+'${categoria}';
    var start = Number('${start}');
    var end = Number('${end}');
    const _categoryIds = '${categoryIds}';
    let filtrosBase = ['${categoryIds}'];
    let selectedFilters = [];
    let searchQuery = '';

    const configCategoriasBlogs = {
        name: 'categoriasBlogs',
        type: 'filter',
        multi: true,
        tags: true,
        size: 'normal',
        url: url,
        theme: 'light',
        required: false,
        'limit-of-groups': 10,
        'limit-of-results': 10,
        'error-text': 'Debes seleccionar al menos una opción.',
        'placeholder-selected': 'Seleccionado',
        'placeholder-unselected': 'Filtrar',
        container: '.categorias',
    };

    if(Number('${categoriasHijasSize}') > 0){
        createMultiselectComponent(configCategoriasBlogs);
    }else{
        $(".categorias").hide();
    }

    if (Number('${totalBlogs}') < 6) {
        $("#loadMore").hide();
        $(".av-lm-cr__search-input-box").hide();
    }

    $('.av-theme__ms-options').on('click', '.av-theme__ms-option', function () {
        if ($(this).hasClass('selected')) {
            const dataId = $(this).data('id');
            if (!selectedFilters.includes(dataId)) {
                selectedFilters.push(dataId);
            }
        } else {
            const dataId = $(this).data('id');
            selectedFilters = selectedFilters.filter(id => id !== dataId);
        }
        const searchQuery = $('#buscar-productos').val().trim();

        var formData = new FormData();
        formData.append('<portlet:namespace/>start', 0);
        formData.append('<portlet:namespace/>end', 6);
        formData.append('<portlet:namespace/>searchQuery', searchQuery);
        formData.append('<portlet:namespace/>selectedFilters', selectedFilters.join(","));

        $.ajax({
            url: '${filtrarNoticias}',
            type: 'POST',
            data: formData,
            datatype: 'html',
            cache: false,
            contentType: false,
            processData: false,
            error: function (xhr, status, error) {
                console.log("ERROR al filtrar noticias.");
            },
            success: function (response, status, xhr) {
                $("#list-noticias").html(response);
                const totalResultados = xhr.getResponseHeader('X-Total-Resultados');
                if (totalResultados > 6) {
                    $("#loadMore").show();
                    $("#loadMore").data("start", 6); // Reiniciar el contador
                } else {
                    $("#loadMore").hide();
                }
                $("#totalResultados").text(totalResultados + " resultados encontrados");
            }
        });
    });

    $('.av-theme__ms-options-delete-all').on('click', function () {
        const searchQuery = $('#buscar-productos').val().trim();
        selectedFilters = [];

        var formData = new FormData();
        formData.append('<portlet:namespace/>start', 0);
        formData.append('<portlet:namespace/>end', 6);
        formData.append('<portlet:namespace/>searchQuery', searchQuery);
        formData.append('<portlet:namespace/>selectedFilters', filtrosBase.join(","));

        $.ajax({
            url: '${filtrarNoticias}',
            type: 'POST',
            data: formData,
            datatype: 'html',
            cache: false,
            contentType: false,
            processData: false,
            error: function (xhr, status, error) {
                console.log("ERROR al reiniciar las noticias.");
            },
            success: function (response, status, xhr) {
                $("#list-noticias").html(response);
                const totalResultados = xhr.getResponseHeader('X-Total-Resultados');
                if (totalResultados > 6) {
                    $("#loadMore").show();
                    $("#loadMore").data("start", 6); // Reiniciar el contador
                } else {
                    $("#loadMore").hide();
                }
                $("#totalResultados").text(totalResultados + " resultados encontrados");
            }
        });
    });

    $("#loadMore").on("click", function () {
        const start = $(this).data("start");
        const end = start + 6;
        const searchQuery = $('#buscar-productos').val().trim();

        var formData = new FormData();
        formData.append('<portlet:namespace/>start', start);
        formData.append('<portlet:namespace/>end', end);
        formData.append('<portlet:namespace/>searchQuery', searchQuery);
        if(selectedFilters.length > 0){
            formData.append('<portlet:namespace/>selectedFilters', selectedFilters.join(","));
        }else{
            formData.append('<portlet:namespace/>selectedFilters', filtrosBase.join(","));
        }


        $.ajax({
            url: '${cargarMasNoticias}',
            type: 'POST',
            data: formData,
            datatype: 'html',
            cache: false,
            contentType: false,
            processData: false,
            error: function (xhr, status, error) {
                console.log("ERROR al cargar más noticias.");
            },
            success: function (response, status, xhr) {
                $("#list-noticias").append(response);
                const totalResultados = xhr.getResponseHeader('X-Total-Resultados');
                console.log("totalResultados -> "+totalResultados);
                if (start + 6 >= totalResultados) {
                    $("#loadMore").hide();
                } else {
                    $("#loadMore").data("start", start + 6);
                }
            }
        });
    });

    $('#buscar-productos').on('input', function () {
        const searchQuery = $(this).val().trim();
        if (searchQuery.length < 3 && searchQuery.length > 0) {
            return;
        }

        var formData = new FormData();
        formData.append('<portlet:namespace/>start', 0);
        formData.append('<portlet:namespace/>end', 6);
        formData.append('<portlet:namespace/>searchQuery', searchQuery);
        if(selectedFilters.length > 0){
            formData.append('<portlet:namespace/>selectedFilters', selectedFilters.join(","));
        }else{
            formData.append('<portlet:namespace/>selectedFilters', filtrosBase.join(","));
        }

        $.ajax({
            url: '${filtrarNoticias}',
            type: 'POST',
            data: formData,
            datatype: 'html',
            cache: false,
            contentType: false,
            processData: false,
            error: function (xhr, status, error) {
                console.log("ERROR al realizar la búsqueda.");
            },
            success: function (response, status, xhr) {
                $("#list-noticias").html(response);
                const totalResultados = xhr.getResponseHeader('X-Total-Resultados');
                if (totalResultados > 6) {
                    $("#loadMore").show();
                    $("#loadMore").data("start", 6); // Reiniciar el contador
                } else {
                    $("#loadMore").hide();
                }
                $("#totalResultados").text(totalResultados + " resultados encontrados");
            }
        });
    });

    function realizarBusqueda(query) {
        var formData = new FormData();
        formData.append('<portlet:namespace/>start', 0);
        formData.append('<portlet:namespace/>end', 6);
        formData.append('<portlet:namespace/>searchQuery', query);
        if(selectedFilters.length > 0){
            formData.append('<portlet:namespace/>selectedFilters', selectedFilters.join(","));
        }else{
            formData.append('<portlet:namespace/>selectedFilters', filtrosBase.join(","));
        }

        $.ajax({
            url: '${filtrarNoticias}',
            type: 'POST',
            data: formData,
            datatype: 'html',
            cache: false,
            contentType: false,
            processData: false,
            error: function (xhr, status, error) {
                console.log("ERROR al realizar la búsqueda.");
            },
            success: function (response, status, xhr) {
                $("#list-noticias").html(response);
                const totalResultados = xhr.getResponseHeader('X-Total-Resultados');
                if (totalResultados > 6) {
                    $("#loadMore").show();
                    $("#loadMore").data("start", 6); // Reiniciar el contador
                } else {
                    $("#loadMore").hide();
                }
                $("#totalResultados").text(totalResultados + " resultados encontrados");
            }
        });
    }

    $(document).on('click', '.js-av-theme__ms-input', function() {
        // Comprobar si el div dentro de .av-theme__multiselect tiene las clases necesarias y la clase 'av-theme__hidden'
        var targetDiv = $('.av-theme__multiselect.av-theme__ms.av-theme__ms--tags.normal.light.filter.categoriasBlogs.zindex100')
            .find('.av-theme__ms-options.js-av-theme__ms-options')
            .filter(function() {
                // Comprobar si el div contiene la clase av-theme__hidden
                return $(this).hasClass('av-theme__hidden');
            });

        if (targetDiv.length > 0) {
            // Si no tiene la clase 'av-theme__hidden', aplicar el estilo CSS
            $('.av-theme__ms--tags.filter .av-theme__ms-container').css({
                'flex-flow': 'nowrap'
            });
        } else {


            // Si tiene la clase 'av-theme__hidden', mover el elemento
            $('.av-lm-cr__search-input-box').insertAfter('.av-theme__ms-input.js-av-theme__ms-input.focused');
            $('.av-theme__ms--tags.filter .av-theme__ms-container').css({
                'flex-direction': 'row',
                'flex-wrap': 'wrap'
            });
            $('.av-lm-cr__search-input-box').css({
                'margin-left': '2em'
            });
        }
    });
});
</script>
