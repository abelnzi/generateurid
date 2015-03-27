<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>
<%@ include file="template/localHeader.jsp"%>

<!-- Bootstrap framework -->
            <link href="<c:url value='resources/bootstrap/css/bootstrap.min.css'  />" rel="stylesheet"/>
        <!-- jQuery UI theme -->

            <link href="<c:url value='resources/lib/jquery-ui/css/Aristo/Aristo.css'  />" rel="stylesheet"/>
        <!-- tooltips-->

            <link href="<c:url value='resources/lib/jBreadcrumbs/css/BreadCrumb.css'  />" rel="stylesheet"/>
        <!-- tooltips-->

            <link href="<c:url value='resources/lib/qtip2/jquery.qtip.min.css'  />" rel="stylesheet"/>
		<!-- colorbox -->

            <link href="<c:url value='resources/lib/colorbox/colorbox.css'  />" rel="stylesheet"/>
        <!-- code prettify -->
 
            <link href="<c:url value='resources/lib/google-code-prettify/prettify.css'  />" rel="stylesheet"/> 
        <!-- sticky notifications -->

            <link href="<c:url value='resources/lib/sticky/sticky.css'  />" rel="stylesheet"/>    
        <!-- aditional icons -->

            <link href="<c:url value='resources/img/splashy/splashy.css'  />" rel="stylesheet"/>
		<!-- flags -->

            <link href="<c:url value='resources/img/flags/flags.css'  />" rel="stylesheet"/>	
        <!-- datatables -->

            <link href="<c:url value='resources/lib/datatables/extras/TableTools/media/css/TableTools.css'  />" rel="stylesheet"/>


        <!-- main styles -->

            <link href="<c:url value='resources/css/style.css'  />" rel="stylesheet"/>
		<!-- theme color-->

            <link href="<c:url value='resources/css/blue.css'  />" rel="stylesheet"/>	
            

			<link href="<c:url value='http://fonts.googleapis.com/css?family=PT+Sans'  />" rel="stylesheet"/>
        <!-- favicon -->
			<link href="<c:url value='resources/shortcut icon'  />" rel="stylesheet"/>
		
			
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
	    <th><input type="text" size="5" name="numToGenerate" id="numToGenerate" class="form-control"/></th>
	  </tr>
	  <tr>
	    <td colspan="2">
	    	<input type="submit" value='<spring:message code="generateurid.generate.gutterlink" />'  class="btn btn-info" />
	    </td>
	  </tr>
	</table>
</form>


 	<script src="<c:url value='resources/js/jquery.min.js' />"></script>

    <script src="<c:url value='resources/js/jquery-migrate.min.js' />"></script>

    <script src="<c:url value='resources/lib/jquery-ui/jquery-ui-1.10.0.custom.min.js' />"></script>
    <!-- touch events for jquery ui-->

	<script src="<c:url value='resources/js/forms/jquery.ui.touch-punch.min.js' />"></script>
    <!-- easing plugin -->

	<script src="<c:url value='resources/js/jquery.easing.1.3.min.js' />"></script>
    <!-- smart resize event -->

	<script src="<c:url value='resources/js/jquery.debouncedresize.min.js' />"></script>
    <!-- js cookie plugin -->

	<script src="<c:url value='resources/js/jquery_cookie_min.js' />"></script>
    <!-- main bootstrap js -->

	<script src="<c:url value='resources/bootstrap/js/bootstrap.min.js' />"></script>
    <!-- bootstrap plugins -->

	<script src="<c:url value='resources/js/bootstrap.plugins.min.js' />"></script>
	<!-- typeahead -->

	<script src="<c:url value='resources/lib/typeahead/typeahead.min.js' />"></script>
    <!-- code prettifier -->

	<script src="<c:url value='resources/lib/google-code-prettify/prettify.min.js' />"></script>
    <!-- sticky messages -->

	<script src="<c:url value='resources/lib/sticky/sticky.min.js' />"></script>
    <!-- tooltips -->

	<script src="<c:url value='resources/lib/qtip2/jquery.qtip.min.js' />"></script>
    <!-- lightbox -->

	<script src="<c:url value='resources/lib/colorbox/jquery.colorbox.min.js' />"></script>
    <!-- jBreadcrumbs -->

	<script src="<c:url value='resources/lib/jBreadcrumbs/js/jquery.jBreadCrumb.1.1.min.js' />"></script>
	<!-- hidden elements width/height -->

	<script src="<c:url value='resources/js/jquery.actual.min.js' />"></script>
	<!-- custom scrollbar -->

	<script src="<c:url value='resources/lib/slimScroll/jquery.slimscroll.js' />"></script>
	<!-- fix for ios orientation change -->

	<script src="<c:url value='resources/js/ios-orientationchange-fix.js' />"></script>
	<!-- to top -->

	<script src="<c:url value='resources/lib/UItoTop/jquery.ui.totop.min.js' />"></script>
	<!-- mobile nav -->

	<script src="<c:url value='resources/js/selectNav.js' />"></script>

	<!-- common functions -->

	<script src="<c:url value='resources/js/gebo_common.js' />"></script>

	<!-- validation -->

    <script src="<c:url value='resources/lib/validation/jquery.validate.min.js' />"></script>
	<!-- validation functions -->

    <script src="<c:url value='resources/js/gebo_validation.js' />"></script>


<%@ include file="/WEB-INF/template/footer.jsp"%>