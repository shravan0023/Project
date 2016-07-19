<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <h2>Add Product Details</h2>
  <form class="form-horizontal" role="form">
    <div class="form-group">
      <label class="col-sm-2 control-label">ProductID:</label>
      <div class="col-sm-10">
        <input class="form-control" id="Add Product ID" type="text" value="product id">
      </div>
    </div>
    <div class="form-group">
      <label class="col-sm-2 control-label">Product Name:</label>
      <div class="col-sm-10">
        <input class="form-control" id="Add Product Name" type="text" value="product name">
      </div>
    </div>
    <div class="form-group">
      <label class="col-sm-2 control-label">Product Category:</label>
      <div class="col-sm-10">
        <input class="form-control" id="Add Product Category" type="text" value="product category">
      </div>
    </div>
    <div class="form-group">
      <label class="col-sm-2 control-label">Product Price:</label>
      <div class="col-sm-10">
        <input class="form-control" id="Add Product Price" type="text" value="product price">
      </div>
    </div>
    
        <div class="alert alert-success alert-dismissable">
            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">ADD</button>
            Success!product added successfully.
        </div>
    <button class="btn btn-danger" type="reset">Reset</button>
    <a href="product" class="btn btn-warning" role="button">Cancel</a>
    
    

  </form>
</div>

</body>
</html>
