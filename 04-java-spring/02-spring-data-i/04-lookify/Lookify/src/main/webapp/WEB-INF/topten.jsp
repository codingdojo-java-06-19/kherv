<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="css/styles.css">
<title>Top Ten songs</title>
</head>
<body>
<a href="/dashboard">Dashboard</a>

		<div class="container">
			<div class="nav-bar">
				<p>Top Ten Songs:</p>
				<a class="link-right" href="/dashboard">Dashboard</a>
			</div>
			<div class="topten">
			<c:forEach items="${topsongs}" var="song">
				<p>${song.rating} - <a href="/songs/${song.id}">${song.title}</a> - ${song.artist}</p>
			</c:forEach>
			</div>
		</div>






</body>
</html>