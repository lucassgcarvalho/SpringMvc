<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>

<spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />

<title>Account Meu Manager</title>
</head>
<body>
	
	
	<div>${pageContext.request.contextPath}
		<p class="greeting-id">The ID is </p>
		<p class="greeting-content">The content is </p>
	</div>
	
	
	
<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container">
	<div class="navbar-header">
		<a class="navbar-brand" href="#">Spring 3 MVC Project</a>
	</div>
  </div>
</nav>
 
<div class="jumbotron">
  <div class="container">
	<h1>${title}</h1>
	<p>
		<c:if test="${not empty name}">
			Hello ${name}
		</c:if>
 
		<c:if test="${empty name}">
			Welcome Welcome!
		</c:if>
    </p>
    <p>
		<a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a>
	</p>
	</div>
</div>
 
<div class="container">
 
  <div class="row">
	<div class="col-md-4">
		<h2>Heading</h2>
		<p>ABC</p>
		<p>
			<a class="btn btn-default" href="#" role="button">View details</a>
		</p>
	</div>
	<div class="col-md-4">
		<h2>Heading</h2>
		<p>ABC</p>
		<p>
			<a class="btn btn-default" href="#" role="button">View details</a>
		</p>
	</div>
	<div class="col-md-4">
		<h2>Heading</h2>
		<p>ABC</p>
		<p>
			<a class="btn btn-default" href="#" role="button">View details</a>
		</p>
	</div>
  </div>
 
 
  <hr>
  <footer>
	<p>&copy; Lucas Carvalho</p>
  </footer>
</div>
 
	
	
	
	
	
	
</body>

<spring:url value="/resources/jquery/1.6/jquery.js" var="jqueryImport" />
<script src="${jqueryImport}"></script>


<!-- <script type="text/javascript">
	// $(document).ready(function() {
	// 	$.ajax({
	// 		url : "ajaxTeste"
	// 	}).then(function(data) {
	// 		alert(data.user);
	// 		$('.greeting-content').append(data);
	// 	});
	// });
</script> -->
</html>