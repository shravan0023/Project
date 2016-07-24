
<!DOCTYPE html>  
 <html>  
 <head>  
   <title>product table </title>  
   <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">  
   <script src="http://code.angularjs.org/1.4.8/angular.js"></script>  
   <script src="http://code.angularjs.org/1.4.8/angular-resource.js"></script>  
   <script src="http://angular-ui.github.io/bootstrap/ui-bootstrap-tpls-0.11.0.js"></script>  
   <script>  
     var app = angular.module('customerproduct', ['ui.bootstrap', 'ngResource']);  
     app.controller('myCtrl', function ($scope) {  
       $scope.predicate = 'name';  
       $scope.reverse = true;  
       $scope.currentPage = 1;  
       $scope.order = function (predicate) {  
         $scope.reverse = ($scope.predicate === predicate) ? !$scope.reverse : false;  
         $scope.predicate = predicate;  
       };  
       $scope.product = ${myJson};  //This code is extracting the string object being sent from controller
       $scope.totalItems = $scope.product.length;  
       $scope.numPerPage = 5;  
       $scope.paginate = function (value) {  
         var begin, end, index;  
         begin = ($scope.currentPage - 1) * $scope.numPerPage;  
         end = begin + $scope.numPerPage;  
         index = $scope.product.indexOf(value);  
         return (begin <= index && index < end);  
       };  
     });  
   </script> 
    
   <style>  
     .odd {  
       background-color: antiquewhite;  
       color: #008b8b;  
     }  
     td th {  
       height: 30px;  
       min-width: 100px;  
     }  
     thead {  
       background-color: darkgray;  
       color: white;  
       height: 30px;  
     }  
   </style>  
 </head>  
 <body ng-app="customerproduct">  
   <div ng-controller="myCtrl">  
     <h3>List product</h3>  
     <div class="container-fluid">  
        
       <hr />  
       <table class="table table-striped">  
         <thead>  
           <tr>  
             <th>Edit</th>
             <th>  
               <a href="" ng-click="order('id')">Id</a>  
             </th>   
             <th>  
               <a href="" ng-click="order('Name')">Name</a>  
             </th>  
             <th><a href="" ng-click="order('category')">Category</a> </th>  
             <th><a href="" ng-click="order('price')">Price</a> </th>  
           </tr>  
         </thead>  
         <tbody>  
           <tr>  
             <td>Filter =>></td>  
             <td> <input type="text" ng-model="search.id" /></td>  
             <td> <input type="text" ng-model="search.Name" /></td>  
             <td> <input type="text" ng-model="search.age" /> </td>  
             <td><input type="text" ng-model="search.gender" /> </td>  
           </tr>  
           <tr ng-repeat="listProduct in product | orderBy:predicate:reverse | filter:paginate| filter:search" ng-class-odd="'odd'">  
             <td>  
               <li><a href="productDescription">Details</a></li>  
             </td>
             <td>{{ listProduct.id}}</td>  
             <td>{{ listProduct.name}}</td>  
             <td>{{ listProduct.category}}</td>  
             <td>{{ listProduct.price}}</td>  
           </tr>  
         </tbody>  
       </table>  
       <pagination total-items="totalItems" ng-model="currentPage"  
             max-size="5" boundary-links="true"  
             items-per-page="numPerPage" class="pagination-sm">  
       </pagination>  
     </div>  
   </div>  
   
   <%-- ${myJson} --%>
   
 </body>  
 </html>
