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

            <!-- NUEVO INPUT-->
            <div class="inputs-noticias-buscador">


                <div class="av-theme__ms--tags filter">
                <div class="av-theme__ms-container">
            <div class="av-theme__ms-input js-av-theme__ms-input">
                <div class="av-theme__ms-input-col av-theme__ms-input-col--left">
                    <div class="av-theme__icon-box-24">
                        <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                            <path fill-rule="evenodd" clip-rule="evenodd" d="M9.5 4C8.67157 4 8 4.67157 8 5.5C8 6.32843 8.67157 7 9.5 7C10.3284 7 11 6.32843 11 5.5C11 4.67157 10.3284 4 9.5 4ZM6.14494 4.5C6.57521 3.05426 7.91449 2 9.5 2C11.0855 2 12.4248 3.05426 12.8551 4.5H21C21.5523 4.5 22 4.94772 22 5.5C22 6.05228 21.5523 6.5 21 6.5H12.8551C12.4248 7.94574 11.0855 9 9.5 9C7.91449 9 6.57521 7.94574 6.14494 6.5H3C2.44772 6.5 2 6.05228 2 5.5C2 4.94772 2.44772 4.5 3 4.5H6.14494ZM16.5 10.5C15.6716 10.5 15 11.1716 15 12C15 12.8284 15.6716 13.5 16.5 13.5C17.3284 13.5 18 12.8284 18 12C18 11.1716 17.3284 10.5 16.5 10.5ZM13.1449 11C13.5752 9.55426 14.9145 8.5 16.5 8.5C18.0855 8.5 19.4248 9.55426 19.8551 11H21C21.5523 11 22 11.4477 22 12C22 12.5523 21.5523 13 21 13H19.8551C19.4248 14.4457 18.0855 15.5 16.5 15.5C14.9145 15.5 13.5752 14.4457 13.1449 13H3C2.44772 13 2 12.5523 2 12C2 11.4477 2.44772 11 3 11H13.1449ZM7.5 17C6.67157 17 6 17.6716 6 18.5C6 19.3284 6.67157 20 7.5 20C8.32843 20 9 19.3284 9 18.5C9 17.6716 8.32843 17 7.5 17ZM4.14494 17.5C4.57521 16.0543 5.91449 15 7.5 15C9.08551 15 10.4248 16.0543 10.8551 17.5H21C21.5523 17.5 22 17.9477 22 18.5C22 19.0523 21.5523 19.5 21 19.5H10.8551C10.4248 20.9457 9.08551 22 7.5 22C5.91449 22 4.57521 20.9457 4.14494 19.5H3C2.44772 19.5 2 19.0523 2 18.5C2 17.9477 2.44772 17.5 3 17.5H4.14494Z" fill="white"></path>
                        </svg>
                    </div>
                    <span class="av-theme__ms-placeholder js-av-theme__ms-placeholder">Filtrar</span>
                </div>

                <div class="av-theme__ms-input-col av-theme__ms-input-col--right">
                    <span class="av-theme__ms-counter js-av-theme__ms-counter av-theme__hidden"></span>
                    <div class="av-theme__icon-box-24">
                        <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                            <path fill-rule="evenodd" clip-rule="evenodd" d="M12 16C12.2652 16 12.5196 15.8946 12.7071 15.7071L18.7071 9.70711C19.0976 9.31658 19.0976 8.68342 18.7071 8.29289C18.3166 7.90237 17.6834 7.90237 17.2929 8.29289L12 13.5858L6.70711 8.29289C6.31658 7.90237 5.68342 7.90237 5.29289 8.29289C4.90237 8.68342 4.90237 9.31658 5.29289 9.70711L11.2929 15.7071C11.4804 15.8946 11.7348 16 12 16Z" fill="#101717"></path>
                        </svg>
                    </div>
                </div>
            </div>
        </div>
            </div>


            <div class="search-input-box news" style="margin-left: 2em;">
                <input type="search" id="buscar-productos3" placeholder="Buscar" class="av-lm-cr__search-input">
                <div class="av-theme__icon-box-24 av-lm-cr__search-icon">
                    <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path fill-rule="evenodd" clip-rule="evenodd" d="M11 4C7.13401 4 4 7.13401 4 11C4 14.866 7.13401 18 11 18C14.866 18 18 14.866 18 11C18 7.13401 14.866 4 11 4ZM2 11C2 6.02944 6.02944 2 11 2C15.9706 2 20 6.02944 20 11C20 13.1242 19.2641 15.0765 18.0334 16.6159L21.7074 20.2932C22.0978 20.6839 22.0975 21.3171 21.7068 21.7074C21.3161 22.0978 20.6829 22.0975 20.2926 21.7068L16.6195 18.0304C15.0796 19.2629 13.1259 20 11 20C6.02944 20 2 15.9706 2 11ZM10 6C10 5.44772 10.4477 5 11 5C14.3137 5 17 7.68629 17 11C17 11.5523 16.5523 12 16 12C15.4477 12 15 11.5523 15 11C15 8.79086 13.2091 7 11 7C10.4477 7 10 6.55228 10 6Z" fill="#101717"></path>
                    </svg>
                </div>
            </div>
            </div>

            <!-- FIN NUEVO INPUT-->
            <div class="div-search-categorias" style="display: flex; align-items: center; gap: 1rem;">
                <div class="categorias"></div>
                <div class="av-lm-cr__search-input-box" style="margin-left: 2em;">
                    <input type="search" id="buscar-productos2" placeholder="Buscar" class="av-lm-cr__search-input">
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
                <button id="btnLoadMore" class="av-load-more__btn gtm-load-more-btn" data-start="6" data-total="${totalBlogs}">
                    Cargar más
                </button>
            </div>
        </c:otherwise>
    </c:choose>
</div>

<script>
$(document).ready(function () {
    var url = '${urlPortal}' + '/o/categorias/getCategoriasBlogsMasFiltros?separator=true';
    var start = Number('${start}');
    var end = Number('${end}');
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

    createMultiselectComponent(configCategoriasBlogs);

    $('.av-theme__ms-options').on('click', '.av-theme__ms-option', function () {
        if ($(this).hasClass('selected')) {
            const dataId = $(this).data('id');
			console.log("ABRO");
            if (!selectedFilters.includes(dataId)) {
                selectedFilters.push(dataId);
            }
        } else {
			console.log("CIERRO");
            const dataId = $(this).data('id');
            selectedFilters = selectedFilters.filter(id => id !== dataId);
        }
        const searchQuery = $('#buscar-productos2').val().trim();

        var formData = new FormData();
        formData.append('<portlet:namespace/>start', 0); // Reiniciar desde el inicio
        formData.append('<portlet:namespace/>end', 6); // Mostrar los primeros 6
        formData.append('<portlet:namespace/>searchQuery', searchQuery); // Incluir el texto de búsqueda
        formData.append('<portlet:namespace/>selectedFilters', selectedFilters.join(",")); // Enviar los filtros seleccionados

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
                    $("#btnLoadMore").show();
                    $("#btnLoadMore").data("start", 6); // Reiniciar el contador
                } else {
                    $("#btnLoadMore").hide();
                }
                $("#totalResultados").text(totalResultados + " resultados encontrados");
            }
        });
    });

    $('.av-theme__ms-options-delete-all').on('click', function () {
        selectedFilters = [];
        const searchQuery = $('#buscar-productos2').val().trim();

        var formData = new FormData();
        formData.append('<portlet:namespace/>start', 0);
        formData.append('<portlet:namespace/>end', 6);
        formData.append('<portlet:namespace/>searchQuery', searchQuery);
        formData.append('<portlet:namespace/>selectedFilters', "");

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
                    $("#btnLoadMore").show();
                    $("#btnLoadMore").data("start", 6); // Reiniciar el contador
                } else {
                    $("#btnLoadMore").hide();
                }
                $("#totalResultados").text(totalResultados + " resultados encontrados");
            }
        });
    });

    $("#btnLoadMore").on("click", function () {
        const start = $(this).data("start");
        const end = start + 6;
        const searchQuery = $('#buscar-productos2').val().trim();

        var formData = new FormData();
        formData.append('<portlet:namespace/>start', start);
        formData.append('<portlet:namespace/>end', end);
        formData.append('<portlet:namespace/>searchQuery', searchQuery);
        formData.append('<portlet:namespace/>selectedFilters', selectedFilters.join(","));

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
                if (start + 6 >= totalResultados) {
                    $("#btnLoadMore").hide();
                } else {
                    $("#btnLoadMore").data("start", start + 6);
                }
            }
        });
    });

    $('#buscar-productos2').on('input', function () {
        const searchQuery = $(this).val().trim();
        if (searchQuery.length < 3 && searchQuery.length > 0) {
            return;
        }

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
                console.log("ERROR al realizar la búsqueda.");
            },
            success: function (response, status, xhr) {
                $("#list-noticias").html(response);
                const totalResultados = xhr.getResponseHeader('X-Total-Resultados');
                if (totalResultados > 6) {
                    $("#btnLoadMore").show();
                    $("#btnLoadMore").data("start", 6);
                } else {
                    $("#btnLoadMore").hide();
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
                console.log("ERROR al realizar la búsqueda.");
            },
            success: function (response, status, xhr) {
                $("#list-noticias").html(response);
                const totalResultados = xhr.getResponseHeader('X-Total-Resultados');
                if (totalResultados > 6) {
                    $("#btnLoadMore").show();
                    $("#btnLoadMore").data("start", 6); // Reiniciar el contador
                } else {
                    $("#btnLoadMore").hide();
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


    $('#buscar-productos3').on('input', function() {
        // Obtener el valor actual del campo de entrada
        var valor = $(this).val();
        // Establecer el mismo valor en el segundo campo de búsqueda
        $('#buscar-productos2').val(valor);
        // Disparar el evento 'input' en el segundo campo de búsqueda
        $('#buscar-productos2').trigger('input');
    });

    $('.inputs-noticias-buscador .js-av-theme__ms-input').on('click', function() {
        // Encontrar el segundo "Filtrar" basado en su posición relativa o alguna otra característica
        $('.categorias .js-av-theme__ms-input').trigger('click');
    });



});
</script>
