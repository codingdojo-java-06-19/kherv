<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="css/styles.css">
<title>Search Results</title>
</head>
<body>
		<div class="container">
			<div class="nav-bar">
				<p>Songs by artist: <c:out value="${search}"/></p>
				<form action="" method="POST">
					<input type="search" name="searchQuery"/>
					<input type="submit" value="New Search"/>
				</form>
				<a href="/dashboard">Dashboard</a>
			</div>
			<table class="search-table">
				<tr>
					<th>Name</th>
					<th>Rating</th>
					<th>Actions</th>
				</tr>
				<c:forEach items="${songsFromArtist}" var="song">
				<tr>
					<td><a href="/songs/${song.id}">${song.title}</a></td>
					<td>${song.rating}</td>
					<td>
						<form action="/songs/${song.id}" method="post">
	    					<input type="hidden" name="_method" value="delete">
	    					<input class="link-style" type="submit" value="Delete">
						</form>
					</td>
				</tr>
				</c:forEach>
			</table>
		</div>
</body>
</html>