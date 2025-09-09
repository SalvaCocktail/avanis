<%@ include file="/init.jsp" %>


<h1>Blog Entries for User ID: ${themeDisplay.getUserId()}</h1>
<c:if test="${empty blogEntries}">
	<p>No blog entries found.</p>
</c:if>
<c:if test="${not empty blogEntries}">
	<ul>
		<c:forEach var="entry" items="${blogEntries}">
			<li>
				<a href="${entry.getUrlTitle()}">${entry.getTitle()}</a>
				<p>Published on: ${entry.getDisplayDate()}</p>
			</li>
		</c:forEach>
	</ul>
</c:if>
