<%@page import="com.saini.service.ProductsService"%>
<%@page import="com.saini.model.Products"%>
<%@ include file="header.jsp" %>
<%
     
    
%>

	<section class="container" data-ng-app="cartApp">
		<div data-ng-controller="cartController" data-ng-init="initCartId('${cartId}')">
			<div>
				<a class="btn btn-danger pull-left" data-ng-click="clearCart()"> <span
					class="glyphicon glyphicon-remove-sign"></span> Clear Cart
				</a>
				<c:if
					test="${pageContext.request.userPrincipal.name == null}">
				 <a href="customerRegistration" class="btn btn-success pull-right"> Check out
				
				</a></c:if>
				<script>
				$scope.location = myService.get();
				</script>
				
			</div>
			<table class="table table-hover">
				<tr>
					<th>Product</th>
					<th>Quantity</th>
					<th>Unit price</th>
					<th>Price</th>
					<th>Action</th>
				</tr>
				<tr data-ng-repeat="item in product">
					<td>${p.productId}</td>
					<td>{{item.quantity}}</td>
					<td>{{item.price}}</td>
					<td>{{item.price}}</td>
					<td><a href="#" class="label label-danger" data-ng-click="removeFromCart(item.product.productId)"> <span
							class="glyphicon glyphicon-remove" /></span> Remove
					</a></td>
				</tr>
				<tr>
					<th></th>
					<th></th>
					<th>Grand Total</th>
					<th>{{cart.grandTotal}}</th>
					<th></th>
				</tr>

			</table>
			<a href="<spring:url value="/products" />" class="btn btn-success">
					<span class="glyphicon-circle-arrow-left glyphicon"></span> continue shopping
			</a>
		</div>
	</section>

<%@ include file="footer.jsp" %>