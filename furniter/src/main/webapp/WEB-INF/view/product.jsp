 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <html>
<head>
  <title>Gogadgets.com</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
 <style>  <link rel="stylesheet" href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css"></style>
<script type="text/javascript" src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
  <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
 
</head>
<body>


<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <div class="Header">
  <img src="C:\Users\UdayShravan\Project\furniter\src\main\webapp\resources\Images\mainlogo.jpg" class="img-rounded" alt="Main Logo" width="50" height="50">
  
  <ul class="nav navbar-nav navbar-right">
   <li><a href="Home">
          <span class="glyphicon glyphicon-home"></span>HOME</a><li>
        
        </ul></div>
    </div>
    </div>
    </nav>
    <div class="table-responsive">
    
  <table id="product" class="table table-striped table-hover" cellspacing="0" width="100%">
    <thead>
      <tr>
        <th>ID</th>
        <th>Category</th>
         <th>Price</th>
        <th>Product name</th>
        
      </tr>
      </thead>
      <tbody>
              <c:if test="${!empty plist}">  
          
            <c:forEach var="product" items="${listProduct}">
                <tr>
                    <td>${product.id}</td>
                      <td>${product.category}</td>
                    <td>${product.price}</td>
                    <td>${list.productname}</td>
                    
              
                </tr>
            </c:forEach>
            
            </c:if>
           
        
    
            </tbody>
    
    </table>
    
    <script>
$(document).ready(function(){
    $('#product').dataTable();
});
</script>
<a href="addproduct" class="btn btn-info" role="button">Add</a>
</div>
    
    <div class="Footer">
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
</head>
<body>

</body>
</html>