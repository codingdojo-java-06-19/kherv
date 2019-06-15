<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="css/styles.css">
<title>Lookify Index</title>
</head>
<body>
<p><c:out value="${success}" /></p>
<div class="nav-bar">
	<a href="/songs/new">Add New</a>
	
	<a href="/search/topTen">Top Songs</a>
	<form action="/search" method="POST">
		<input type="search" name="searchQuery">
		<input type="submit" value="Search Artists" />
	</form>
</div>
<table>
	<thead>
		<tr>
			<th>ID</th>
			<th>Song Title Name</th>
			<th>Artist</th>
			<th>Rating</th>
			<th>Actions</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${songs}" var ="song">
		<tr>
		<td><a href=""><c:out value = "${song.id}"/></a></td>
		<td>
			<a href="/songs/${song.id}">  ${song.title}  </a>
		</td>
		<td><c:out value = "${song.artist}"/></td>
		<td><c:out value="${song.rating}"/></td>
		<td>
		<form action="songs/${song.id}" method="post">
		<input type="hidden" name="_method" value="delete">
		<input class="link-style" type="submit" value="Delete"/>
		</form>
		
		
		</td>
		</tr>
		</c:forEach>
	</tbody>
	
	
	
</table>
</body>
</html>