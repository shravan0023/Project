<html>
<head>
<title>Registration Form</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
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
        
        </ul>
  </div>
    </div>

</div>
</nav>

<div class="container" id="container1">
        <div class="row centered-form">
            <div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title text-center">Please Register</h3>
                    </div>
                    <div class="panel-body">
                        <form role="form">
                            <div class="form-group">
                                <input type="text" name="first_name" id="first_name" class="form-control input-sm" placeholder="First Name">
                            </div>

                            <div class="form-group">
                                <input type="text" name="last_name" id="last_name" class="form-control input-sm" placeholder="Last Name">
                            </div>
                            <div class="form-group">
                                <input type="number" number="mobile_number" id="mobile_number" class="form-control input-sm" placeholder="Mobile Number">
                            </div>

                            <div class="form-group">
                                <input type="email" name="email" id="email" class="form-control input-sm" placeholder="Email Address">
                            </div>

                            <div class="row">
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        <input type="password" name="password" id="password" class="form-control input-sm" placeholder="Password">
                                    </div>
                                </div>
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        <input type="password" name="password_confirmation" id="password_confirmation" class="form-control input-sm" placeholder="Confirm Password">
                                    </div>
                                </div>
                            </div>

                            <input type="submit" value="Register" class="btn btn-info btn-block">
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

<style>
#container1 {
    background-color: #e2dada;
}

.centered-form {
    margin-top: 120px;
    margin-bottom: 120px;
}

.centered-form .panel {
    background: rgba(255, 255, 255, 0.8);
    box-shadow: rgba(0, 0, 0, 0.3) 20px 20px 20px;
}
</style>
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
</body>
</html>