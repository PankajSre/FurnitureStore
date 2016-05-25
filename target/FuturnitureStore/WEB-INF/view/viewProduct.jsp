<%@ include file="header.jsp" %>
	<section class="container" data-ng-app="cartApp" style="height: 430px;">

		<div class="row">
			<div class="col-md-6">
				<img src="${product.imagePath}" height="150" width=150 />
			</div>
			<div class="col-md-6">
                <h2 style="color: blue;">Product Information</h2>
				<h3>${product.name}</h3>
				<p>${product.description}</p>
				<p>
					<strong>Item Code : </strong><span class="label label-warning">${product.productId}</span>
				</p>
				<p>
					<strong>Product Group :</strong> : ${product.groupName}
				</p>
				<p>
					<strong>Quantity</strong> : ${product.quantity}
				</p>
				
				<h4>Rs &nbsp;${product.price}  &nbsp;INR</h4>
			
				<p data-ng-controller="cartController">
					<a href="<spring:url value="/products" />" class="btn btn-success">
						<span class="glyphicon-circle-arrow-left glyphicon"></span> back
					</a> 
					<a href="#" data-ng-click = "addToCart('${product.productId}')" class="btn btn-warning btn-large"> <span
						class="glyphicon-shopping-cart glyphicon"> </span> Order Now
					</a>
				</p>
			
			</div>
		</div>
	</section>
	<%@ include file="footer.jsp" %>