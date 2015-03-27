<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>

<%@ include file="template/localHeader.jsp"%>

<form action="${pageContext.request.contextPath}/module/generateurid/generateIds.form" method="post">
	<table>
	  <tr>
	    <th><spring:message code="Location.title" /></th>
	    <th><spring:message code="generateurid.current.year" /></th>
	  </tr>
	  <tr>
	    <td>${location.name}-<b>${location.postalCode}</b></td>
	    <td>${currentYear}</td>
	  </tr>
	  <tr>
	    <th><spring:message code="generateurid.number.to.generate" /></th>
	    <th><input type="text" size="5" name="numToGenerate" id="numToGenerate" /></th>
	  </tr>
	  <tr>
	    <td colspan="2">
	    	<input type="submit" value='<spring:message code="generateurid.generate.gutterlink" />' />
	    </td>
	  </tr>
	</table>
</form>

<c:if test="${not empty listIds}">
	<b class="boxHeader">Generated IDs<span style="float:right;"><a href="${pageContext.request.contextPath}/module/generateurid/printOutIds.form">Print the out</a></span></b>
	<div class="box">
		<table>
		  <tr>
		    <th>#</th>
		    <th>Generated IDs</th>
		    <th>Creator</th>
		    <th>Creation date</th>
		  </tr>
		  <c:forEach var="genId" items="${listIds}" varStatus="status">
			  <tr>
			    <td><b>${status.count}.</b></td>
			    <td>${genId.patientIdentifiant}</td>
			    <td>${genId.creator.person.familyName}</td>
			    <td><openmrs:formatDate date="${genId.dateCreated}" type="medium"/></td>
			  </tr>
		  </c:forEach>
		</table>
	</div>
</c:if>


<%@ include file="/WEB-INF/template/footer.jsp"%>