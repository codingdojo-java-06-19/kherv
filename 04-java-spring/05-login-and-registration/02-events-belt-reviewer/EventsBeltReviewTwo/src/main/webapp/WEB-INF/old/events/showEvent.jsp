<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="/css/styles.css"/>
	<title>Soccer Game</title>
</head>
	<body>
		<div class="container">
			<h1>${event.name}</h1>
			<div class="row">
				<div class="col">
					<div class="event-info">
						<p>Host: ${event.host.getFirstName()}</p>
						<p>Date: ${event.formatEventDate()}</p>
						<p>Location: ${event.city}, ${event.state}</p>
						<p>People who are attending this event: ${event.members.size()}</p>
					</div>
					<table class="tablestyle">
						<tr>
							<th>Name</th>
							<th>Location</th>
						</tr>
						<c:forEach items="${event.getMembers()}" var="user">
						<tr>
							<td>${user.getFirstName()} ${user.getLastName()}</td>
							<td>${user.getCity()}</td>
						</tr>
						</c:forEach>
						<tr>
							<td></td>
							<td></td>
						</tr>
					</table>
				</div>
				<div class="col">
					<h3>Message Wall</h3>
					<p class="bad">${messageError}</p>
					<div class="message-wall">
						<c:forEach items="${messages}" var="message">
						<div class="message-group">
							<p>${message.getAuthor().firstName} says: ${message.getContent()}</p>
							<p>~*~*~*~*~*~*~*~*~**~*~*~</p>
						</div>
						</c:forEach>
					</div>
					<form:form action="/events/newMessage/${event.getId()}" method="POST" modelAttribute="message" autocomplete="off">
						<label for="message">Add Comment:</label>
						<textarea name="content"></textarea>
						<input type="hidden" name="author" value="${loggedInUser.getId()}"/>
						<input type="submit" name="Submit"/>
					</form:form>
				</div>
			</div>
		</div>
	</body>
</html>