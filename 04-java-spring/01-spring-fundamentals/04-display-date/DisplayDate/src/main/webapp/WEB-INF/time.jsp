<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="css/timestyle.css">
        <script type="text/javascript" src="js/time.js"></script>
<title>Insert title here</title>
</head>
<body>

<h1>Time Page</h1>

<h2>It is: <c:out value="${timeOut}"/></h2>

</body>
</html>