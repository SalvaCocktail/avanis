<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="avanis.tu.explotacion.sb.model.Explotacion" %>
<%@ page import="com.liferay.asset.kernel.model.AssetEntry" %>
<%@ page import="com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil" %>
<%@ page import="com.liferay.asset.kernel.model.AssetCategory" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ include file="./init.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<portlet:actionURL var="deleteURL" name="deletePlot"/>
<div id="loadingSpinner" class="loading-spinner loading-spinner-eliminar " style="display: none;">
  <div class="spinner"></div>
  <p>Eliminando</p>
</div>
<div class="av-main__header plots-cabecera">
  <img class="go-to-menu" onClick="displayMenu()" class="mr-2" src="<%=request.getContextPath()%>/images/arrow-left.png" alt="arrow left"/>
  <h2 class="av-mp-gp__h2">
    Mi explotación
  </h2>
  <h4 class="plots-subtitulo">
    Parcelas
  </h4>
</div>

<c:choose>
  <c:when test="${empty plots}">
    <div class="av-empty-plot-box">
      <img src="<%=request.getContextPath()%>/images/add-plot-ico.png">
      <p>
        Agrega tu primera explotación para poder gestionarla desde Avanis
      </p>
      <a class="link-avanis" href="${themeDisplay.getURLHome()}/mi-perfil-privado/edit" class="av-menu__profile__link">
        <div class="av-btn">
          Añadir Parcela
        </div>
      </a>
    </div>
  </c:when>
  
  <c:otherwise>
    <c:forEach var="plot" items="${plots}" varStatus="status">
      <c:set var="plotId" value="${plot.explotacionId}"/>
      <div class="av-plot-card">
        <div class="av-plot-photo">
          <img src="<%=request.getContextPath()%>/images/parcela.jpg">
        </div>
        <div class="av-plot-data">
        
          <div class="av-mp-gp__plot-data-sec av-mp-gp__plot-data-sec--001">
            <h3 class="av-mp-gp__h4 h3-plot">
              ${plot.name}
            </h3>
            <div class="av-plot-locality">
              ${plot.location}, ${plot.provincia}
            </div>
            <div class="av-plot-tamano" data-size-unit="${plot.sizeUnit}">
            </div>
            <div class="av-plot-modified">
              Actualizado el <fmt:formatDate value="${plot.modifiedDate}" pattern="dd/MM/yyyy" />
            </div>
            <div class="av-plot-use">
              <ul>
                  <%
                      long id = (Long) pageContext.getAttribute("plotId");
                      AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(Explotacion.class.getName(), id);
                      if (assetEntry != null) {
                          List<AssetCategory> categories = assetEntry.getCategories();

                          pageContext.setAttribute("categories", categories);
                      } else {
                          pageContext.setAttribute("categories", null);
                      }
                  %>
                  <c:forEach var="category" items="${categories}">
                      <li><span>${category.name}</span></li>
                  </c:forEach>
              </ul>
            </div>
          </div>

          <div class="av-mp-gp__plot-data-sec av-mp-gp__plot-data-sec--002">

            
            <div class="av-plot-buttons">
              <aui:form action="${deleteURL}" method="post">
                <aui:input type="hidden" value="plots" name="focusedTab"/>
                <aui:input type="hidden" name="plotId" value="${plotId}"/>
                <aui:button id="btn-eliminar-plot" cssClass="btn-eliminar-plot av-btn-link" type="submit" value="Eliminar"/>
              </aui:form>
              <a class="link-avanis" href="${themeDisplay.getURLHome()}/mi-perfil-privado/edit?id=${plot.explotacionId}" class="av-menu__profile__link">
                <div class="av-btn-secondary-small plot-btn-editar">
                  Editar
                </div>
              </a>
            </div>                                            
          </div>

          
            
        </div>
        
      </div>
      <c:if test="${!status.last}">
        <div class="separator"></div>
      </c:if>

    </c:forEach>
      
    <div class="av-mp-gp__btn-add-plot">
      <a class="link-avanis" href="${themeDisplay.getURLHome()}/mi-perfil-privado/edit" class="av-menu__profile__link">
        <div class="av-btn av-te__btn av-te__btn--primary">
          Añadir Parcela
        </div>
      </a>
    </div>
  </c:otherwise>
</c:choose>

<script>
  Liferay.on('allPortletsReady', function () {
    document.querySelectorAll('.av-plot-tamano').forEach(function(div) {
      var sizeUnit = div.getAttribute('data-size-unit');
      var numericSizeUnit = parseFloat(sizeUnit.replace(',', '.'));
      if (numericSizeUnit && numericSizeUnit !== 0) {
        div.textContent = sizeUnit + ' Hectáreas';
      } else {
        div.textContent = '';
      }
    });
  });

  $(document).ready(function() {
    $('.btn-eliminar-plot').on('click', function() {
      $('.loading-spinner-eliminar').show();
    });
  });
</script>
<style>
  .loading-spinner {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(255, 255, 255, 0.8);
    display: flex;
    justify-content: center;
    align-items: center;
    z-index: 9999; /* Asegúrate de que esté encima de otros elementos */
    flex-direction: column;
    p{
      color: gray;
    }
  }

  .spinner {
    border: 4px solid rgba(0, 0, 0, 0.1);
    border-left-color: #000;
    border-radius: 50%;
    width: 40px;
    height: 40px;
    animation: spin 1s linear infinite;
  }

</style>
<!--
<a href="explotacion/edit">Añadir parcela</a>
-->