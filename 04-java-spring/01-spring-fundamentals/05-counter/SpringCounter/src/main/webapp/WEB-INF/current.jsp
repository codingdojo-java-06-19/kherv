<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
            <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Current visit count</title>
</head>
<body>

<h2>You have visited http://your_server  <c:out value="${numTimes}"/> times.</h2>

<h3><a href="/your_server">Test another visit?</a></h3>     

</body>
</html>