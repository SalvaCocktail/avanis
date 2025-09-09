<%--
  Created by IntelliJ IDEA.
  User: jesusblasco
  Date: 18/7/24
  Time: 23:39
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/init.jsp" %>

<%@ include file="./init.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<portlet:actionURL var="savePreferencesURL" name="savePreferences"/>


<aui:form method="post" cssClass="av-form-my-account" action="${savePreferencesURL}" name="fma"
          enctype="multipart/form-data">

    <div class="mb-3">
        <p>Agricultura</p>
        <aui:select label="" cssClass="av-form-select" id="multiple-select-field1"
                    name="selectedAgricultureCategories" data-placeholder="Choose anything" multiple="true">
            <c:forEach var="agricultureCategory" items="${agricultureCategories}">
                <aui:option value="${agricultureCategory.name}"
                            selected='${userInterests.contains(agricultureCategory.getName().toLowerCase())}'>${agricultureCategory.name}</aui:option>
            </c:forEach>
        </aui:select>
    </div>

    <div class="mb-3">
        <p>Ganadería</p>
        <aui:select label="" cssClass="av-form-select" id="multiple-select-field2"
                    name="selectedStockbreadingCategories" data-placeholder="Choose anything" multiple="true">
            <c:forEach var="stockbreadingCategory" items="${stockbreadingCategories}">
                <aui:option value="${stockbreadingCategory.name}"
                            selected='${userInterests.contains(stockbreadingCategory.getName().toLowerCase())}'>${stockbreadingCategory.name}</aui:option>
            </c:forEach>
        </aui:select>
    </div>

    <div class="mb-3">
        <p>Otros</p>
        <aui:select label="" cssClass="av-form-select" id="multiple-select-field2"
                    name="selectedOtherCategories" data-placeholder="Choose anything" multiple="true">
            <c:forEach var="otherCategory" items="${otherCategories}">
                <aui:option value="${otherCategory.name}"
                            selected='${userInterests.contains(otherCategory.getName().toLowerCase())}'>${otherCategory.name}</aui:option>
            </c:forEach>
        </aui:select>
    </div>
    <div class="mb-3">
        Newsletter:
        <aui:input name="allowNewsLetter" value="${allowNewsLetter}" type="checkbox"/>
    </div>

    <div class="av-control-buttons">
        <button class="av-btn-secondary mr-3">Cancelar</button>
        <aui:button type="submit" value="Guardar"/>
    </div>
</aui:form>