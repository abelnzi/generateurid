<spring:htmlEscape defaultHtmlEscape="true" />
<ul id="menu">
	<li class="first"><a href="${pageContext.request.contextPath}/admin"><spring:message code="admin.title.short" /></a></li>

	<li	<c:if test='<%= request.getRequestURI().contains("/generateIds") %>'>class="active"</c:if>>
		<a href="${pageContext.request.contextPath}/module/generateurid/generateIds.form"><spring:message code="generateurid.generate.gutterlink" /></a>
	</li>
	<li	<c:if test='<%= request.getRequestURI().contains("/manage") %>'>class="active"</c:if>>
		<a href="${pageContext.request.contextPath}/module/generateurid/manage.form"><spring:message code="generateurid.manage" /></a>
	</li>
	
	<!-- Add further links here -->
</ul>
<h2>
	<spring:message code="generateurid.title" />
</h2>
