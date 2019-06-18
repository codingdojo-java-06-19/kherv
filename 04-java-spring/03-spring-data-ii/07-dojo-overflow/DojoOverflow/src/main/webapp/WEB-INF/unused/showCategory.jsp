<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="css/styles.css">
<title>Category Page</title>
</head>
<body>
	<body>
		<div class="container">
			<h1>Category Name: <c:out value="${category1.name}"/></h1>
		
			<div class="ProdListAndAddProd">
				<div class="ProdList">
					<p>Products this category has</p>
					<ul>
	
						<c:forEach items="${productsHave}" var="product"> 
							<li>
								<c:out value="${product.name}"/>
							</li>
		        		</c:forEach>
					</ul>
					

				</div> <!-- end ProdList -->
				

				<div class ="AddProd">

					<form:form action="/categories/addProduct/${category1.id}" method="POST" modelAttribute="productCategory">
					<form:hidden path="category" value="${category1.id}"/>

						<div class="row">
							<div class="col-25">
								<label for="product">Add Products for this category:</label>
							</div>
							<div class="col-75">
								<form:select path="product">
									<option value="NONE">--- Select ---</option> 
									<form:options items="${productsNotYetAdded}" itemLabel="name"/>

								</form:select>
							</div>
						</div>
						<div class="row">
							<input type="submit" value="Add"/>
						</div>




					</form:form>
				</div> <!-- End AddProd -->

			</div> <!-- end ProdListAndAddProd -->

		</div> <!-- End Container -->
	</body>


</body>
</html>