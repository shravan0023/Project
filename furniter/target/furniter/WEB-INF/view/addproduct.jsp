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
  }

  </style>
</head>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <div class="Header">
  <img src="C:\Users\UdayShravan\Project\furniter\src\main\webapp\resources\Images\mainlogo.jpg" class="img-rounded" alt="Main Logo" width="50" height="50">
  </div>
    </div>
    <ul class="nav navbar-nav navbar-right">
						<li><a href="Products">Product</a></li>
						<li><a href="index">Home</a></li>
						
					  <li><a href="addProduct">AddProduct</a></li>
					</ul>
		</div>
  </div>
</nav>
</div>
<div class="container">

	<br />

	<spring:url value="/addProduct" var="userActionUrl" />

	<form:form class="form-horizontal" method="get" modelAttribute="product" action="${userActionUrl}">
<c:if test="${!empty product.name}">
     <form:label path="id"><spring:message text="ID"/></form:label>
      <form:input path="id" readonly="true" size="8"  disabled="true" /><br/>
            <!-- <form:hidden path="id" /> -->
    </c:if>
	<!-- 	<form:hidden path="id" />  -->

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

		
		
            <c:if test="${empty product.name}">
                <input type="submit" value="<spring:message text="Add Product"/>" />
            </c:if>
        </td>
        <c:if test="${empty product.name}">
                <input type="submit" value="<spring:message text="Edit Product"/>" />
            </c:if>
      </form:form>
   </div>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-footer">
      
    </div>
    <ul class="nav navbar-nav navbar-left">
    <li><a href="#"><span class="aboutus"></span> About Us</a></li>
      <li><a href="#"><span class="contactus"></span> Contact Us</a></li>
     
    </ul>
  </div>
  <div class="footer">
  <ul class="nav navbar-nav navbar-right">
<li><a href="#"><i class="fa fa-facebook-official" style="font-size:48px;color:#3B5998"></i></a></li>
<li><a href="#"><i class="fa fa-twitter-square" style="font-size:48px;color: #55acee"></i></a></li>
<li><a href="#"><i class="fa fa-google-plus-square" style="font-size:48px;color:#dd4b39"></i></a></li>     
  </ul>
  </div>
</nav>
</body>
</html>