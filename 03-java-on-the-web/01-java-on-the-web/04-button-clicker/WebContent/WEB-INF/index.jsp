<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Clicker</title>
</head>
<body>
<h1>This is the Clicker Page...or the Click It page</h1>

<form action = "/ButtonClicker/Counter" method="POST">
	<input type = "submit" value="Click Me!">
</form>

<p>You have clicked this button <c:out value="${sessionScope.numSess2}"/> times</p>
		<h1>Also works<c:out value="${sessionScope.numSess2}"/> times.</h1>





</body>
</html>