<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="css/styles.css">
<title>New Product Page</title>
</head>
<body>
			<h1>New Product</h1>

<form:form action="/products/new" method="post" modelAttribute="product">

	<div>
		<form:label path="name">Name</form:label>
		<form:errors path="name"/>
		<form:input path="name"/>
	</div>	
	
	
		<div>
		<form:label path="description">Description</form:label>
		<form:errors path="description"/>
		<form:input path="description"/>
	</div>	
	
	<div>
		<form:label path="price">Price</form:label>
		<form:errors path="price"/>
		<form:input path="price"/>
	</div>	
	
	
	
	
	
	
	
	
	
		
	<input type="submit" value="Create"/>
</form:form>

</body>
</html>