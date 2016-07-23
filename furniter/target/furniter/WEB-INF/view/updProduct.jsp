<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products Page</title>
<link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">   
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<link rel="stylesheet" href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css">
<script type="text/javascript" src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script>
$(document).ready(function(){
    $('#myTable').dataTable();
});
</script>
 <style>
  .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 70%;
      margin: auto;

  </style>
</head>
<body bgcolor="silver">
<div class="header">
  <nav class="navbar navbar-default">
  	<div class="container-fluid">
        <div align="right" class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" style="color:#0000FF;background:#EEEEEE;">
    	     <img src="C:\Users\user\Documents\Presentation1\logo.png" align=left> 
      				<ul class="nav navbar-nav navbar-right">
						<li><a href="product">Product</a></li>
						<li><a href="index">Home</a></li>
						<li><a href="Register">Register</a></li>
					</ul>
		</div>
  </div>
</nav>
</div>
<div class="container">

	<br />

	<spring:url value="/updProduct" var="userActionUrl" />

	<form:form class="form-horizontal" method="get" modelAttribute="product" action="${userActionUrl}">

		<spring:bind path="name">
		  	<label class="col-sm-2 control-label">Product Name:</label>
			<form:input path="name" type="text" class="form-control" id="name" placeholder="Product Name" />
		</spring:bind>
<br/>
		<spring:bind path="category">
			<label class="col-sm-2 control-label">Category</label>
			<form:input path="category" class="form-control" id="category" placeholder="Category" />
		</spring:bind>
<br/>
		<spring:bind path="price">
			<label class="col-sm-2 control-label">Price</label>
			<form:input path="price" class="form-control" id="price" placeholder="price" />
		</spring:bind>

		
		<td colspan="2">
            <c:if test="${empty product.name}">
                <input type="submit" value="<spring:message text="Edit Product"/>" />
            </c:if>
           
        </td>
      </form:form>
<div align="left" style="color:#0000FF;background:pink;">
<font size=3><a href="">About Us</a><a href="">Contact</a></font>
   <img src="C:\Users\user\Documents\Presentation1\fb.png" width=25 height=25 align=right>
  <img src="C:\Users\user\Documents\Presentation1\twitter.png" width=25 height=25 align=right>
  <img src="C:\Users\user\Documents\Presentation1\g+.png" width=25 height=25 align=right>

  </div>
</body>
</html>