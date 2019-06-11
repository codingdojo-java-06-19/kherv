<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	    <link rel="stylesheet" href="styles.css">
	<meta charset="UTF-8">
	<title><c:out value="${thisTeam.getName()}"/>: New Player</title>
</head>
	<body>
	<div class="container">
			<h1 class="header">Add a player to team <c:out value="${thisTeam.getName()}"/></h1>
			<div class="player-form-group">
				<form action="Players" method="POST" autocomplete="off">
				<div class="row">
					<div class="col-25">
						<label for="firstName">First Name:</label>	
					</div>
					<div class="col-75">
						<input type="text" name="firstName"/>
					</div>
				</div>
				<div class="row">
					<div class="col-25">
						<label for="lastName">Last Name:</label>
					</div>
					<div class="col-75">
						<input type="text" name="lastName"/>
					</div>
				</div>
				<div class="row">
					<div class="col-25">
						<label for="age">Age:</label>
					</div>
					<div class="col-75">
						<input type="number" name="age" min="15" max="50"/>
					</div>
				</div>
				<div class="row">
					<input class="player-btn" type="submit" value="Add">
				</div>
			</form>
			</div>
		</div>
	</body>
</html>