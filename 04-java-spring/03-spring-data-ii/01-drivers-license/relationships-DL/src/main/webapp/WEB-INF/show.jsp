<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="css/styles.css">
<title>Profile Page</title>
</head>
<body>
	<body>
		<div class="container">
			<h1>${person.firstName} ${person.lastName}</h1>
			<p>License Number: ${person.license.number}</p>
			<p>State: ${person.license.state}</p>
			<p>Expiration Date: ${person.license.expirationDate}</p>
		</div>
	</body>


</body>
</html>