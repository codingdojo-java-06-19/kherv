<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="css/styles.css">
<title>New Category Page</title>
</head>
<body>
			<h1>New Category</h1>

<form:form action="/categories/new" method="post" modelAttribute="category">

	<div>
		<form:label path="name">Name</form:label>
		<form:errors path="name"/>
		<form:input path="name"/>
	</div>		


	<input type="submit" value="Create"/>
</form:form>

</body>
</html>