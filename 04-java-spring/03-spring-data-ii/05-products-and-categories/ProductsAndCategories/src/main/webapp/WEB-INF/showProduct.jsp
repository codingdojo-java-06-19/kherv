<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="css/styles.css">
<title>Product Page</title>
</head>
<body>
	<body>
		<div class="container">
			<h1>Product Name:<c:out value="${product1.name}"/></h1>
		
			<div class="CatListAndAddCat">
				<div class="CatList">
					<p>Categories this product is in:</p>
					<ul>
						<!--< c forrEach items="${ ninjas }" var="ninja">  Here ninja is the var to use in c:out, but ninjas is the list key from controller -->
						<c:forEach items="${categoriesHave}" var="category"> 
							<li>
								<c:out value="${category.name}"/>
							</li>
		        		</c:forEach>
					</ul>
				</div> <!-- end CatList -->
				

				<div class ="AddCat">

					<form:form action="/products/category" method="POST" modelAttribute="category" autocomplete="off">
						<div class="row">
							<div class="col-25">
								<label for="category">Add Category to this product:</label>
							</div>
							<div class="col-75">
								<select name="category">
									<c:forEach items="${categoriesNotYetAdded}" var="category">
										<option value="<c:out value="${category.id}"/>"><c:out value="${category.name}"/></option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="row">
							<input type="hidden" value="product1.id"/>
							<input type="submit" value="Add"/>
						</div>
					</form:form>
				
				
				
			</div> <!-- end CatListAndAddCat -->

		</div>
	</body>


</body>
</html>