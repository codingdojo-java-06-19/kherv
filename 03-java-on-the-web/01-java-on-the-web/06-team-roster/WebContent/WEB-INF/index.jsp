<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
    	<link rel="stylesheet" href="styles.css">
    	<link rel="stylesheet" href="/WEB-INF/styles.css" />
<style>
<style>
<%@include file="/WEB-INF/styles.css"%>
</style> 
    	
    	
    	
<meta charset="ISO-8859-1">
<title>Roster</title>
</head>
<body>
<h1>This is the main Roster page</h1>
<h2>Need to include Team Names and number of players and a link over to create a new team at <a href="/TeamRoster/Teams">Click for new team</a></h2>

<div class="container">

	<table class ="roster">
		<tr>
			<th>Team</th>
			<th>Players</th>
			<th>TeamID</th>
			<th>Action</th>
		</tr>
		<!-- The roster knows about the team list, so that is what we iterate -->
		<c:forEach items="${roster.getTeams()}" var="team">
		<tr>
			<td>${team.getName()}</td>
			<td>${team.getPlayers().size()}</td>
			<td>team id:  <td>${team.getId()}</td>
			<td><a href="Teams?id=<c:out value="${team.getId()}"/>">Details</a> 
				<form class="short-form" action="DeleteTeam?teamid=${team.getId()}" method="POST">
					<input class="normal-link" type="submit" value="Delete">
				</form> 
		
			</td>
		</tr>
		</c:forEach>
	
	
	
	
	
	
	
	
	
	</table>








</div>


</body>
</html>