<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page...testing first JSP in Spring</title>
</head>
<body>
	<h1> Hello World..first JSP in Spring</h1>

<c:out value="${2+2}"/>

<h1><c:out value="${dojoName}"/></h1>
</body>
</html>