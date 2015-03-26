<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ include file="template/localHeader.jsp"%>

<form action="/module/generateurid/generateIdForm.form" method="post">
	<table>
	  <tr>
	    <th>Location</th>
	    <th><spring:message code="generateurid.current.year" /></th>
	  </tr>
	  <tr>
	    <td>${location.name}-${location.postalCode}</td>
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

<%@ include file="/WEB-INF/template/footer.jsp"%>