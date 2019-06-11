<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	 <link rel="stylesheet" href="styles.css">
	<meta charset="UTF-8">
	<title>Team</title>
</head>
	<body>
	<div class="container">
		<h1 class="header"><c:out value="${thisTeam.getName()}"/></h1>
		<a class="right-link" href="Players?id=<c:out value="${thisTeam.getId()}"/>">Add Player</a>
		<table class="roster">
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Age</th>
				<th>Actions</th>
			</tr>
			<c:forEach items="${thisTeam.getPlayers()}" var="player">
			<tr>
				<td>${player.getFirstName()}</td>
				<td>${player.getLastName()}</td>
				<td>${player.getAge()}</td>
				<td> 
					<form action="DeletePlayer?teamid=${thisTeam.getId()}" method="POST">
						<!-- <input type="hidden" name="teamid" value="<c:out value="${thisTeam.getId()}"/>">-->
						<input type="hidden" name="playerid" value="<c:out value="${player.getid()}"/>">
						<input class="normal-link" type="submit" value="Delete">
					</form>
				</td>
			</tr>
			</c:forEach>
		</table>
	</div>
	</body>
</html>