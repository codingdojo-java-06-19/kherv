<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="css/styles.css">
<title>Survey Result Page</title>
</head>
<body>
	<h1> Survey Result Page</h1>

<h1><c:out value="${dojoName}"/></h1>

<fieldset>
<p>Name:  <c:out value="${personName}"/></p>
<p>Dojo Location:  <c:out value="${dojoLocation}"/></p>
<p>Favorite Language:  <c:out value="${favoriteLanguage}"/></p>
<p>Comment:  <c:out value="${userComment}"/></p>



</fieldset>







</body>
</html>