<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="css/styles.css">
<title>Details for One Song</title>
</head>
<body>
<a href="/dashboard">Dashboard</a>
<p>Song ID <c:out value="${songs.id}"></c:out></p>
<p>Song Title  <c:out value="${songs.title}"></c:out></p>
<p>Artist <c:out value="${songs.artist}"/></p>
<p>Rating (1-10): <c:out value="${songs.rating}"/></p>


	<form action="/songs/${song.id}" method="post">
		<input type="hidden" name="_method" value="delete">
		<input class="link-style" type="submit" value="Delete">
	</form>


</body>
</html>