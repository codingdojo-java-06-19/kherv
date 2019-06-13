<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="css/styles.css">
<title>The Secret Code Page</title>
</head>
<body>
	<h1> The Secret Code Page</h1>

<p class="error"><c:out value="${error}"/></p>
<form action="/codeGuess" method="POST" >

	<label for="codeGuess">What is the code?</label>	
	<input type="text" name="theGuess"/>
	<input  type="submit" value="Try Code">

</form>

<h1><c:out value="${dojoName}"/></h1>


</body>
</html>