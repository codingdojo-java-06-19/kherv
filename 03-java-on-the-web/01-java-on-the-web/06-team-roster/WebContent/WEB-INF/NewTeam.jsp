<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Team</title>
</head>
<body>
<h1>Create a new Team</h1>

		<form action="/TeamRoster/Teams" method="POST">

			<label for="name">Team Name:</label> <input type="text" name="teamName">

			<input type="submit" value="Create">

		</form>

</body>
</html>