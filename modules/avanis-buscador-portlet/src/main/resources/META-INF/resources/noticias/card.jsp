<%@ include file="../init.jsp" %>

<c:forEach var="noticia" items="${listaNoticias}">
    <li class="card-page-item card-page-item-asset">
        <div class="card publication__card">
            <div class="card-body widget-topbar card-container">
                <div class="autofit-row card-title item-title">
                    <div class="autofit-col autofit-col-expand">
                        <h3 class="title">
                            <a class="title-link" href="${noticia.url}">${noticia.titulo}</a>
                        </h3>
                    </div>
                </div>

                <div class="item-img">
                    <div class="av-card-news">
                        <figure>
                            <a class="title-link" href="${noticia.url}">
                                <img alt="thumbnail" src="${noticia.imagen}">
                            </a>
                        </figure>
                    </div>

                    <div class="publication__av-reading-time">
                        <c:choose>
                            <c:when test="${noticia.tiempoLectura == 1}">
                                <p>${noticia.tiempoLectura} minuto de lectura</p>
                            </c:when>
                            <c:otherwise>
                                <p>${noticia.tiempoLectura} minutos de lectura</p>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>

                <div class="item-data">
                    <div class="autofit-row widget-metadata">
                        <div class="autofit-col autofit-col-expand">
                            <div class="autofit-row">
                                <div class="autofit-col autofit-col-expand">
                                    <div class="text-truncate-inline">
                                        ${noticia.autor}
                                    </div>
                                    <div class="publication__date">
                                        <fmt:formatDate value="${noticia.fechaPublicacion}" pattern="d MMMM yyyy" />
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="publication__card-tags item-tags">
                    <ul class="publication__article-tags">
                        <c:forEach var="categoria" items="${noticia.categorias}" varStatus="status">
                            <li>
                                <a class="asset-category mb-1 mr-1 pr-2 text-uppercase" href="${noticia.categoryUrls[status.index]}">
                                    ${categoria}
                                </a>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
    </li>
    <div class="separator"></div>
</c:forEach>