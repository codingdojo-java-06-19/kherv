<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="css/styles.css">
<title>Show Ninjas in Dojo</title>
</head>
<body>
	<body>
		<div class="container">
			<h1><c:out value="${dojo.name}"/> Ninjas</h1>
		
			<table class="ninjas">
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Age</th>
				</tr>
				<c:forEach items="${ninjas}" var="ninja">
					<tr>
            			<td><c:out value="${ninja.firstName}"/></td>
            			<td><c:out value="${ninja.lastName}"/></td>
            			<td><c:out value="${ninja.age}"/></td>
        			</tr>
        		</c:forEach>
			</table>
		</div>
	</body>


</body>
</html>