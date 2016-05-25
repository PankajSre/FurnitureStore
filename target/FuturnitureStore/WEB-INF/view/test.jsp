<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Example - example-example98-production</title>
  

  <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular.min.js"></script>
  
<style>
h1 {
    border-bottom: 3px solid #cc9900;
    color: #996600;
    font-size: 30px;
}
table, th , td {
    border: 1px solid grey;
    border-collapse: collapse;
    padding: 5px;
}
table tr:nth-child(odd) {
    background-color: #f1f1f1;
}
table tr:nth-child(even) {
    background-color: #ffffff;
}
</style>
  
</head>
<body >
<div class="table responsive" data-ng-app="">
<div class="table">
  <div data-ng-init="friends =[
                  {productId : 1001,groupName :'Classic',Name : 'Dholak',Price : 3000, Quantity: 4,Desc : 'This is used by the ladies',image: 'resources/images/products/dholak.jpg'},
                  {productId : 1002,groupName :'Pop',Name : 'Guitar',Price : 6000, Quantity: 5,Desc : 'The guitar is a popular musical',image: 'resources/images/products/guitar.jpg'},
                  {productId : 1003,groupName :'Indian',Name : 'Band',Price : 10000, Quantity: 6,Desc : 'This is an indian Instrument',image: 'resources/images/products/secong.jpg'},
                  {productId : 1004,groupName :'Parsian',Name : 'Tabla',Price : 2500, Quantity: 20,Desc : 'This came from Persian People',image: 'resources/images/products/third.jpg'}
                	
                ]"></div>
<div style="height: 50px;padding-left:240px;width:500px;">
<label>Search Element <input data-ng-model="searchText"></label>
</div>
<section style="padding-left:200px">
<table id="searchTextResults">
  <tr><th>Product ID</th><th>Group Name</th><th>Product Name</th><th>Product Price</th><th>Quantity</th><th>Description</th><th>Image</th></tr>
  <tr data-ng-repeat="search in friends | filter:searchText">
    <td>{{search.productId}}</td>
    <td>{{search.groupName}}</td>
    <td>{{search.Name}}</td>
    <td>{{search.Price}}</td>
    <td>{{search.Quantity}}</td>
    <td>{{search.Desc}}</td>
    <td><img data-ng-src="{{search.image}}" height="60" width="100" ></td>
  </tr>
</table>
</section>
</div>
</div>
<footer id="footer" class="midnight-blue">
        <div class="container">
            <div class="row">
                <div class="col-sm-6">
                    &copy; 2016  All Rights Reserved.
                </div>
                <div class="col-sm-6">
                    <ul class="pull-right">
                        <li><a href="index">Home</a></li>
                        <li><a href="about">About Us</a></li>
                        <li><a href="contact">Contact Us</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </footer>
	
</body>
</html>
