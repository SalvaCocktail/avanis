<%@ include file="/init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<c:forEach var="blog" items="${blogs}">
	<a href="/b/${blog.urlTitle}" class="asset-abstract">
		<div class="asset-content">
			<div class="asset-content-section">
				<figure>
					<img src="${blog.getSmallImageURL(themeDisplay)}" alt="">
				</figure>
			</div>
			<div class="asset-content-section">
				<h5 class="asset-summary">
					${blog.getTitle()}
				</h5>

				<span class="metadata-entry metadata-create-date">
					<fmt:formatDate value="${blog.displayDate}" pattern="dd MMM yyyy - HH:mm:ss" />
				</span>
			</div>
		</div>
	</a>
</c:forEach>