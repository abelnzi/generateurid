<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>

<%@ include file="template/localHeader.jsp"%>

<p>Hello ${user.systemId}!</p>

<form:form method="POST" commandName="locationparam" action="/module/generateurid/add.form">

	<form:select path="idLocation">
		<form:option value="">Select Location: </form:option>
		<c:forEach items="${locations}" var="location">
			<form:option value="${location.locationId}">${location.name}</form:option>
		</c:forEach>
	</form:select>

	<!--  <form:select path="location" items="${locations}" 	itemValue="locationId" itemLabel="name" />-->
</form:form>

<%@ include file="/WEB-INF/template/footer.jsp"%>