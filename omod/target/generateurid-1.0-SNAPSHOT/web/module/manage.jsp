<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>

<%@ include file="template/localHeader.jsp"%>


<<<<<<< HEAD
	<form:select path="idLocation">
		<form:option value="">Select Location</form:option>
		<c:forEach items="${locations}" var="location">
			<form:option value="${location.locationId}">${location.name}</form:option>
		</c:forEach>
	</form:select>

</form:form>
=======
<p>Hello ${user.systemId}!</p>

>>>>>>> 807adc7d45151da2f7053964928d07f18269d39f

<%@ include file="/WEB-INF/template/footer.jsp"%>