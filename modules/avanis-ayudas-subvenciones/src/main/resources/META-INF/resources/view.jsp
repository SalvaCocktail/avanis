<%@ include file="/init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    boolean isLoggedIn = themeDisplay.isSignedIn();
%>



<div class="ayudas-container-widget">
    <h4 class="av-widget--title h4 separador">Ayudas y subvenciones</h4>

    <c:forEach var="article" items="${articlesData}">
        <div class="ayuda-card">
                <p class="entidad">${article.entidad}</p>
                <h5>
                    <a class="a-enlace" href="${article.url}" >
                        ${article.titulo}
                    </a>
                </h5>
                <p class="descripcionCorta">
                    <c:choose>
                        <c:when test="${fn:length(article.descripcionCorta) > 100}">
                            ${fn:substring(article.descripcionCorta, 0, 97)}...
                        </c:when>
                        <c:otherwise>
                            ${article.descripcionCorta}
                        </c:otherwise>
                    </c:choose>
                </p>
                <div class="fecha">
                    <svg width="16" height="16" viewBox="0 0 16 16" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path fill-rule="evenodd" clip-rule="evenodd" d="M4.66659 1.33301C5.03478 1.33301 5.33325 1.63148 5.33325 1.99967V2.66634H10.6666V1.99967C10.6666 1.63148 10.9651 1.33301 11.3333 1.33301C11.7014 1.33301 11.9999 1.63148 11.9999 1.99967V2.66636C12.3059 2.66655 12.5728 2.66843 12.7966 2.68672C13.0602 2.70825 13.3223 2.7558 13.5746 2.88433C13.9509 3.07608 14.2569 3.38204 14.4486 3.75836C14.5771 4.01061 14.6247 4.27276 14.6462 4.53632C14.6666 4.78603 14.6666 5.0892 14.6666 5.44063V11.8921C14.6666 12.2435 14.6666 12.5466 14.6462 12.7964C14.6247 13.0599 14.5771 13.3221 14.4486 13.5743C14.2569 13.9506 13.9509 14.2566 13.5746 14.4484C13.3223 14.5769 13.0602 14.6244 12.7966 14.646C12.5469 14.6664 12.2437 14.6664 11.8923 14.6663H4.10754C3.75612 14.6664 3.45295 14.6664 3.20323 14.646C2.93967 14.6244 2.67753 14.5769 2.42527 14.4484C2.04895 14.2566 1.74299 13.9506 1.55124 13.5743C1.42271 13.3221 1.37517 13.0599 1.35363 12.7964C1.33323 12.5466 1.33324 12.2435 1.33325 11.892V5.44065C1.33324 5.08921 1.33323 4.78604 1.35363 4.53632C1.37517 4.27276 1.42271 4.01061 1.55124 3.75836C1.74299 3.38204 2.04895 3.07607 2.42527 2.88433C2.67753 2.7558 2.93967 2.70825 3.20323 2.68672C3.42709 2.66843 3.6939 2.66655 3.99992 2.66636V1.99967C3.99992 1.63148 4.2984 1.33301 4.66659 1.33301ZM4.13325 3.99967C3.74888 3.99967 3.5007 4.00019 3.31181 4.01563C3.1307 4.03042 3.06356 4.05554 3.03059 4.07234C2.90515 4.13625 2.80316 4.23824 2.73925 4.36368C2.72245 4.39664 2.69734 4.46379 2.68254 4.6449C2.6671 4.83379 2.66659 5.08197 2.66659 5.46634V5.99967H13.3333V5.46634C13.3333 5.08197 13.3327 4.83379 13.3173 4.6449C13.3025 4.46379 13.2774 4.39664 13.2606 4.36368C13.1967 4.23824 13.0947 4.13625 12.9692 4.07234C12.9363 4.05554 12.8691 4.03042 12.688 4.01563C12.4991 4.00019 12.251 3.99967 11.8666 3.99967H4.13325ZM13.3333 7.33301H2.66659V11.8663C2.66659 12.2507 2.6671 12.4989 2.68254 12.6878C2.69734 12.8689 2.72245 12.936 2.73925 12.969C2.80316 13.0944 2.90515 13.1964 3.03059 13.2603C3.06356 13.2771 3.1307 13.3023 3.31181 13.3171C3.5007 13.3325 3.74888 13.333 4.13325 13.333H11.8666C12.251 13.333 12.4991 13.3325 12.688 13.3171C12.8691 13.3023 12.9363 13.2771 12.9692 13.2603C13.0947 13.1964 13.1967 13.0944 13.2606 12.969C13.2774 12.936 13.3025 12.8689 13.3173 12.6878C13.3327 12.4989 13.3333 12.2507 13.3333 11.8663V7.33301Z" fill="#101717"></path>
                    </svg>
                    <span class="padding-left">${article.fechaFinSolicitud}</span> ${article.estado}
                </div>
                <div class="tags">
                    <c:forEach var="category" items="${article.categories}">
                        <span class="tag" style="text-align: center;">${category}</span>
                    </c:forEach>
                </div>
        </div>
    </c:forEach>

    <a href="/es/ayudas" class="ver-todas av-event-header-link-span">Ver todas las ayudas</a>
</div>

<script>

    //Calendario AYUDAS
    $(document).ready(function() {
        // Selecciona todos los <td> dentro del <tbody> de la tabla con clase "calendar"
        // Escuchamos el evento click en los días del calendario
        $(document).on('click', '.calendar td', function() {
            // Removemos la clase 'selected-day' de cualquier otro día
            $('.calendar td').removeClass('selected-day');

            // Añadimos la clase 'selected-day' al día clicado
            $(this).addClass('selected-day');
        });
    });
</script>