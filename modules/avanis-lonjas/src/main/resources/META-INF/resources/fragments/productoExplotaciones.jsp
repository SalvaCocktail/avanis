<%@ include file="../init.jsp" %>

<portlet:actionURL name="action_cmd_command" var="updateProductoExplotacionURL">
    <portlet:param name="<%=Constants.CMD%>" value="updateProductoExplotacion" />
</portlet:actionURL>

<div class="av-lm__modal-plot-list">
    <c:if test="${empty explotaciones}">
        <div class="av-lm-cl__favorites-empty-state">
            <div class="av-theme-icon-box-24">
                <svg width="20" height="20" viewBox="0 0 20 20" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <path fill-rule="evenodd" clip-rule="evenodd" d="M10 2C5.58172 2 2 5.58172 2 10C2 14.4183 5.58172 18 10 18C14.4183 18 18 14.4183 18 10C18 5.58172 14.4183 2 10 2ZM0 10C0 4.47715 4.47715 0 10 0C15.5228 0 20 4.47715 20 10C20 15.5228 15.5228 20 10 20C4.47715 20 0 15.5228 0 10ZM5.85 7.3C5.85 6.49919 6.49919 5.85 7.3 5.85C8.10081 5.85 8.75 6.49919 8.75 7.3C8.75 8.10081 8.10081 8.75 7.3 8.75C6.49919 8.75 5.85 8.10081 5.85 7.3ZM11.25 7.3C11.25 6.49919 11.8992 5.85 12.7 5.85C13.5008 5.85 14.15 6.49919 14.15 7.3C14.15 8.10081 13.5008 8.75 12.7 8.75C11.8992 8.75 11.25 8.10081 11.25 7.3ZM6.76808 11.8913C7.49727 11.3609 8.59947 10.8 10 10.8C11.4005 10.8 12.5027 11.3609 13.2319 11.8913C13.5984 12.1578 13.8818 12.4243 14.0759 12.6268C14.1734 12.7285 14.2495 12.8154 14.3036 12.8798C14.3306 12.912 14.3523 12.9388 14.3683 12.9591L14.3883 12.9847L14.3952 12.9937L14.3979 12.9972L14.399 12.9987C14.3992 12.999 14.4 13 13.6 13.6L14.4 13C14.7314 13.4418 14.6418 14.0686 14.2 14.4C13.7596 14.7303 13.1355 14.6424 12.8033 14.2044C12.8028 14.2037 12.8017 14.2024 12.8002 14.2005C12.7955 14.1944 12.7859 14.1825 12.7716 14.1655C12.7431 14.1315 12.6962 14.0777 12.6319 14.0107C12.5026 13.8757 12.3078 13.6922 12.0556 13.5087C11.5473 13.1391 10.8495 12.8 10 12.8C9.15053 12.8 8.45273 13.1391 7.94442 13.5087C7.69219 13.6922 7.49741 13.8757 7.36808 14.0107C7.30383 14.0777 7.25694 14.1315 7.22838 14.1655C7.21413 14.1825 7.20455 14.1944 7.19976 14.2005C7.1984 14.2022 7.19743 14.2034 7.19685 14.2042L7.19836 14.2022L7.19976 14.2005C6.86827 14.6418 6.24163 14.7312 5.8 14.4C5.35817 14.0686 5.26863 13.4418 5.6 13L6.4 13.6C5.6 13 5.59975 13.0003 5.6 13L5.601 12.9987L5.60214 12.9972L5.60479 12.9937L5.61167 12.9847L5.63166 12.9591C5.64775 12.9388 5.66937 12.912 5.69643 12.8798C5.75048 12.8154 5.82664 12.7285 5.92411 12.6268C6.11821 12.4243 6.40156 12.1578 6.76808 11.8913Z" fill="#101717"/>
                </svg>
            </div>
            <div class="text-center">
                <liferay-ui:message key="avanis.lonjas.sin.parcelas" />
            </div>
        </div>
    </c:if>
    <c:if test="${not empty explotaciones}">
        <aui:form action="${updateProductoExplotacionURL}" method="post" name="formPlots" cssClass="av-ac-mp__form" >
            <aui:input type="hidden" name="productoId" value="${productoId}" />
            <aui:input type="hidden" name="idLonja" value="${idLonja}" />
            <c:forEach var="explotacion" items="${explotaciones}" varStatus="status">
                <c:set var="checkedExplot" value="false"/>
                <c:set var="disabledExplot" value="false"/>
                <c:forEach items="${productoExplotacionesIds}" var="productoExplotacionesId">
                    <c:if test="${explotacion.getExplotacionId().toString() == productoExplotacionesId}">
                        <c:set var="checkedExplot" value="true"/>
                    </c:if>
                </c:forEach>
                <c:if test="${!checkedExplot && (ctdaProductosPorExplotacionMax <= ctdaProductosPorExplotacion[status.index])}">
                    <c:set var="disabledExplot" value="true"/>
                </c:if>
                <div class="av-lm__modal-plot-card<c:if test="${disabledExplot}"> disabled </c:if>">
                    <div class="av-lm__modal-plot-column av-lm__modal-plot-column--001">
                        <label>
                            <aui:input checked="${checkedExplot}" disabled="${disabledExplot}" name="explocionIds" value="${explotacion.explotacionId}" label="" type="checkbox"/>
                        </label>
                    </div>
                    <div class="av-lm__modal-plot-column av-lm__modal-plot-column--002">
                       <!-- <img src="/o/theme-avanis/images/temp/sponsors-001.png" alt="Imagen de parcela"> -->
                    </div>
                    <div class="av-lm__modal-plot-column av-lm__modal-plot-column--003">
                        <div class="av-lm__modal-plot-texts">
                            <h4 class="av-lm__modal-plot-title-h4">
                                <liferay-ui:message key="avanis.lonjas.parcela" />: ${explotacion.name}
                            </h4>
                            <p class="av-lm__modal-plot-location">
                                    ${explotacion.location}, ${explotacion.provincia}
                            </p>
                            <p class="av-lm__modal-plot-size">
                                    ${explotacion.sizeUnit} <liferay-ui:message key="avanis.lonjas.parcelas.hectareas" />
                            </p>
                            <p class="av-lm__modal-plot-updated">
                                <liferay-ui:message key="avanis.lonjas.parcelas.updatedate" /> <fmt:formatDate value="${explotacion.modifiedDate}" pattern="dd/MM/yyyy"/>
                            </p>
                            <%
                                Explotacion explotacion = (Explotacion) pageContext.getAttribute("explotacion");
                                long explotacionid_ = explotacion.getExplotacionId();
                                AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(Explotacion.class.getName(), explotacionid_);
                                if (assetEntry != null) {
                                    List<AssetCategory> categories = assetEntry.getCategories();
                                    pageContext.setAttribute("explotacionCategories", categories);
                                } else {
                                    pageContext.setAttribute("explotacionCategories", null);
                                }
                            %>
                            <div class="av-lm__modal-plot-tags">
                                <c:forEach var="explotacionCategory" items="${explotacionCategories}" varStatus="status">
                                <span class="av-lm__modal-plot-tag">
                                        ${explotacionCategory.name}
                                </span>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </aui:form>
    </c:if>
</div>
