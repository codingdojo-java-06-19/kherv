<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="/css/styles.css"/>
<meta charset="ISO-8859-1">
<title>Show Events</title>
</head>

<body>
	<div class="container">
		<h1>Welcome, ${user.firstName} ${user.lastName}</h1>
		<h3 class="good">${eventSuccess}</h3>
		<form class="right-link" action="/logout" method="POST">
		<input class="normal-link" type="submit" value="Logout"/></form>
		<h3>Here are some of the events in your state, ${thisUsersState}:</h3>
		<table class="tablestyle">
			<thead>
				<tr>
					<th>Name</th>
					<th>Date</th>
					<th>Location</th>
					<th>Host</th>
					<th>Action/Status</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${eventsInState}" var="event">
					<tr>
						<td><a href="/events/${event.getId()}">${event.name} -- ${event.id}</a></td>
						<td>${event.formatEventDate()}</td>
						<td>${event.city}</td>
						<td>${event.host.firstName} - ${event.host.id}</td>
						<td>
							<c:choose>
								<c:when test="${event.host.id==user.id}">
									<div class ="col-25">
										<a href="/events/${event.getId()}/edit" class="normal-link">Edit</a>
									</div>
									<div class="col-40">
										<form:form action="/events/${event.getId()}" method="POST">
											<input type="hidden" name="_method" value="delete">
											<input class="normal-link" type="submit" value="Delete/Cancel Event">
										</form:form>
									</div>
								</c:when>
								<c:otherwise>
									<c:choose>
										<c:when test="${event.members.contains(user)}"> <!-- user is logged in user -->
											<form:form action="/events/${event.getId()}/users" method="POST">
												<input type="hidden" name="_method" value="delete">
												<input class="normal-link" type="submit" value="Cancel attendance">
											</form:form>
s
										</c:when>
										<c:otherwise>
											<form:form action="/events/${event.getId()}/users" method="POST">
											<input class="normal-link" type="submit" value="Join">
											</form:form> 
										</c:otherwise>
									</c:choose>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
			<h3>Here are some of the events in other states</h3>
		<table class="tablestyle">
			<thead>
				<tr>
					<th>Name</th>
					<th>Date</th>
					<th>Location</th>
					<th>Host</th>
					<th>Action/Status</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${eventsNotInState}" var="event">
					<tr>
						<td><a href="/events/${event.getId()}">${event.name} -- ${event.id}</a></td>
						<td>${event.formatEventDate()}</td>
						<td>${event.city}</td>
						<td>${event.host.firstName} - ${event.host.id}</td>
						<td>
							<c:choose>
								<c:when test="${event.host.id==user.id}">
									<div class ="col-25">
										<span class=tinyText>event is hosted by loggedIn user</span>
										<a href="/events/${event.getId()}/edit" class="normal-link">Edit</a>
									</div>
									<div class="col-40">
										<form:form action="/events/${event.getId()}" method="POST">
											<input type="hidden" name="_method" value="delete">
											<input class="normal-link" type="submit" value="Delete/Cancel Event">
										</form:form>
									</div>
								</c:when>
								<c:otherwise>
									<c:choose>
										<c:when test="${event.members.contains(user)}"> <!-- user is logged in user -->
											<form:form action="/events/${event.getId()}/users" method="POST">
												<input type="hidden" name="_method" value="delete">
												<input class="normal-link" type="submit" value="Cancel attendance">
											</form:form>
											
										</c:when>
										<c:otherwise>
											<form:form action="/events/${event.getId()}/users" method="POST">
											<input class="normal-link" type="submit" value="Join">
											</form:form>
										</c:otherwise>
									</c:choose>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="row">
			<div class="col-40">
				<h3>Create an Event</h3>
				<span class="bad">${eventError}</span>
				<form:form action="/events/new" method="POST" modelAttribute="event">
					<div class="row">
						<div class="col-25">
							<label for="name">Name</label>
						</div>
						<div class="col-75">
							<input type="text" name="name"/>
						</div>
					</div>
					<div class="row">
						<div class="col-25">
							<label for="date">Date</label>
						</div>
						<div class="col-75">
							<input type="date" name="eventDate"/>
						</div>
					</div>
						<div class="row">
							<div class="col-25">
								<label for="location">Location</label>
							</div>
							<div class="col-75">
								<div class="col-80">
									<input class="location" type="text" name="city" placeholder="city"/>
								
								</div>
								<div class="col-20">
									<select name="state">
										<option value="AL">AL</option>
										<option value="AR">AR</option>
										<option value="TX">TX</option>
									</select>
								</div>
							</div>
						</div>
						<div class="row">
							<input type="hidden" name="host" value="${user.getId()}"/>
							<input type="submit" value="Create Event"/>
					</div>
				</form:form>
			</div>
		</div>
		
	
	</div > <!-- End Container -->


</body>
</html>