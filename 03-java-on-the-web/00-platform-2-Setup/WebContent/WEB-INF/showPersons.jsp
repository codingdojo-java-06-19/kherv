<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %> <!--  removed this when added JSTL:  import="com.codingdojo.web.models.Person"  -->
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Person page</title>
</head>
<body>

	<!-- removed this when added JSTL perc Person person = (Person) request.getAttribute("person"); perc> -->
	<h1><c:out value="${person.greeting()}"/></h1> <!-- modified to c:out after JSTL was person.greeting()-->
	


	<h1>Hello World Platform follow-along</h1>
</body>
</html>