<%@ include file="header.jsp" %>
	<section>
	 <div align="center">
        <form:form action="prodRegistration.do" method="get" commandName="prodRegistration">
           <div class="table-responsive">
            <table>
                <tr>
                    <td colspan="2" align="center"><h2>Product Registration</h2></td>
                </tr>
                <tr>
                    <td>Product Id:</td>
                    <td><form:input path="productId" id="myId" /></td>
                </tr>
                <tr>
                    <td>Group Name:</td>
                    <td><form:input path="groupName" /></td>
                </tr>
                <tr>
                    <td>Product Name:</td>
                    <td><form:input path="name" /></td>
                </tr>
                <tr>
                    <td>Description:</td>
                    <td><form:input path="description" /></td>
                </tr>
                <tr>
                    <td>Product Quantity:</td>
                    <td><form:input path="quantity" /></td>
                </tr>
                <tr>
                    <td>Product Price:</td>
                    <td><form:input path="price" /></td>
                </tr>
                <tr>
                    <td>Product Image:</td>
                    <td><form:input path="imagePath" /></td>
                </tr>
                
                
            </table>
            <div style="display: table-footer-group;">
                    <input type="submit" name="action" value="Add" onclick="/products">
                     <input type="submit" name="action" value="Edit">
                     <td> <input type="submit" name="action" value="Delete">
                      <input type="submit" name="action" value="Search">
            
            </div>
            </div>
        </form:form>
        
    </div>
	</section>
	<%@ include file="footer.jsp" %>