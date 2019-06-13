<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="css/styles.css">
<title>Survey Index</title>
</head>
<body>
	<h1> Survey Index page</h1>

<p class="error"><c:out value="${error}"/></p>
<form action="result" method="POST" >

	<label for="personName">Your Name</label>	
	<input type="text" name="personName"/>
	
		<label for="dojoLocation">Dojo Location</label>	
	<input type="text" name="dojoLocation"/>
	
		<label for="favoriteLanguage">Favorite Language</label>	
	<input type="text" name="favoriteLanguage"/>
	
		<label for=" userComment">Comment</label>	
	<input type="text" name="userComment"/>
	
	
	<input  type="submit" value="Try Code">
</form>

//<p>Name:  <c:out value="${personName}"/></p>
//<p>Dojo Location:  <c:out value="${dojoLocation}"/></p>
//<p>Favorite Language:  <c:out value="${favoriteLanguage}"/></p>
//<p>Comment:  <c:out value="${userComment}"/></p>

<h1><c:out value="${dojoName}"/></h1>


</body>
</html>