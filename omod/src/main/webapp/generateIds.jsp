<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>

<%@ include file="template/localHeader.jsp"%>
<!-- openmrs:htmlInclude file="/moduleResources/@MODULE_ID@/scripts/jquery.PrintArea.js" / -->
<openmrs:htmlInclude file="/moduleResources/generateurid/scripts/jquery.PrintArea.js" />

<script>

var $sig = jQuery.noConflict();

$sig(document).ready(function(){
	$sig("#print_button").click(function(){
		$sig("#printGeneratedIDs").printArea();
	});
});

</script>

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
	<b class="boxHeader">
		Generated IDs<span style="float:right;">
			<!-- input id="print_button" value="Printout IDs" type="button" / -->
			<input type="image" id="print_button" src="/moduleResources/generateurid/images/print_btn.png" alt="Printout IDs" />
		</span>
	</b>
	<div id="printGeneratedIDs" class="box">
		<div style="text-align: center;">
			<div style="float: left;">
				<table>
					<tr>
						<td>SITE: </td>
						<td><b>${location.name}</b></td>
						<td>CODE:</td>
						<td><b>${location.postalCode}</b></td>
					</tr>
				</table>
			</div>
			<div style="float: right;">
				<table>
					<tr>
						<td>Printed on:</td>
						<td><b><openmrs:formatDate date="${currentDate}" type="medium"/></b></td>
					</tr>
				</table>
			</div>
		</div>
		<br/><hr/>
		<div style="clear: both;">
			<table>
			  <tr>
			    <th>#</th>
			    <th>Generated IDs</th>
			  </tr>
			  <c:forEach var="genId" items="${listIds}" varStatus="status">
				  <tr>
				    <td><b>${status.count}.</b></td>
				    <td>${genId}</td>
				  </tr>
			  </c:forEach>
			</table>
		</div>
	</div>
</c:if>


<%@ include file="/WEB-INF/template/footer.jsp"%>