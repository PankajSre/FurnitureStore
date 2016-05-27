<%@page import="com.saini.model.Products"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="header.jsp" %>
<section style="width: 600px;height: 500px;padding-left: 150px;">
<input type="hidden" value="${product.productId}"> 
<form:form action="${pageContext.request.contextPath}/editProcess" method="POST" commandName="edit" class="form-horizontal">
 
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="productId">Product ID :</label>
                <div class="col-md-7">
                    <form:input path="productId"  value="" class="form-control input-sm" disabled="true"/>
                    
                    </div>
                </div>
            </div>
        
          <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="groupName">Group Name:</label>
                <div class="col-md-7">
                   <form:input path="groupName"  value="${product.groupName }" class="form-control input-sm" disabled="true"/>
                    
                    </div>
                </div>
            </div>
            <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="name"> Name:</label>
                <div class="col-md-7">
                   <form:input path="name"  value="${product.name }" class="form-control input-sm"/>
                    
                    </div>
                </div>
            </div>
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="description">Description:</label>
                <div class="col-md-7">
                    <form:input path="description" value="${product.description}" class="form-control input-sm"/>
                    
                    </div>
                </div>
           
         <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="quantity">Quantity:</label>
                <div class="col-md-7">
                     <form:input path="quantity"  value="${product.quantity}" class="form-control input-sm"/>
                    
                    </div>
                </div>
           
             <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="price">Price:</label>
                <div class="col-md-7">
                     <form:input path="price"  value="${product.price }" class="form-control input-sm"/>
                    
                    </div>
                </div>
         
             <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="imagePath">File name:</label>
                <div class="col-md-7">
                     <form:input path="imagePath" type="file" name="Upload image" class="form-control input-sm"/>
                    
                    </div>
                </div>
           
        
 
        <div class="row">
            <div class="form-actions floatRight">
                <input type="submit" value="Update" class="btn btn-primary btn-sm">
            </div>
        </div>
    </form:form>
</section>
<%@ include file="footer.jsp" %>