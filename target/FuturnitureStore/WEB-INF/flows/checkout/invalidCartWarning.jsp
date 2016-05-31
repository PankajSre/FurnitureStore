<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="/WEB-INF/view/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Invalid Cart!</h1>
                </div>
            </div>
        </section>

        <section class="container">
            <p><a href="<spring:url value="/product/productList" />" class="btn btn-default">Products</a></p>
        </section>

<%@ include file="/WEB-INF/view/footer.jsp" %>