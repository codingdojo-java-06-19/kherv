<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="/css/styles.css"/>
	<title>Events</title>
</head>
	<body>
		<div class="container">
			<h1>Welcome, ${user.firstName} ${user.lastName}!</h1>
			<h3 class="good">${eventSuccess}</h3>
			<form class="right-link" action="/logout" method="POST"><input type="submit" value="Logout"/></form>
			<div class="table-group">
				<p>Here are some of the events in your state:</p>
				<table class="tablestyle">
					<tr>
						<th>Name</th>
						<th>Date</th>
						<th>Location</th>
						<th>Host</th>
						<th>Action/Status</th>
					</tr>
					<c:forEach items="${eventsInState}" var="event">
					<tr>
						<td><a href="/events/${event.getId()}">${event.name}</a></td>
						<td>${event.formatEventDate()}</td>
						<td>${event.city}</td>
						<td>${event.host.getFirstName()}</td>
						<td><a href="/">Join</a> Joining  <a href="/">Cancel</a></td>
					</tr>
					</c:forEach>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
				</table>
			</div>
			<div class="table-group">
				<p>Here are some of the events in other states:</p>
				<table class="tablestyle">
					<tr>
						<th>Name</th>
						<th>Date</th>
						<th>Location</th>
						<th>Host</th>
						<th>Action/Status</th>
					</tr>
					<c:forEach items="${eventsNotInState}" var="event">
					<tr>
						<td><a href="/events/${event.getId()}">${event.name}</a></td>
						<td>${event.formatEventDate()}</td>
						<td>${event.city}</td>
						<td>${event.host.getFirstName()}</td>
						<td><a href="/">Join</a></td>
					</tr>
					</c:forEach>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
				</table>
			</div>
			<div class="row">
				<div class="col-40">
					<h3>Create an Event</h3>
					<form:form action="/events/new" method="POST" modelAttribute="event" autocomplete="off">
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
										<option value="AK">AK</option>
										<option value="AR">AR</option>
										<option value="CA">CA</option>
										<option value="CO">CO</option>
										<option value="CT">CT</option>
										<option value="DE">DE</option>
										<option value="FL">FL</option>
										<option value="GA">GA</option>
										<option value="HI">HI</option>
										<option value="ID">ID</option>
										<option value="IL">IL</option>
										<option value="IN">IN</option>
										<option value="IA">IA</option>
										<option value="KS">KS</option>
										<option value="KY">KY</option>
										<option value="LA">LA</option>
										<option value="ME">ME</option>
										<option value="MD">MD</option>
										<option value="MA">MA</option>
										<option value="MI">MI</option>
										<option value="MS">MS</option>
										<option value="MO">MO</option>
										<option value="MT">MT</option>
										<option value="NE">NE</option>
										<option value="NV">NV</option>
										<option value="NH">NH</option>
										<option value="NJ">NJ</option>
										<option value="NM">NM</option>
										<option value="NY">NY</option>
										<option value="NC">NC</option>
										<option value="ND">ND</option>
										<option value="OH">OH</option>
										<option value="OK">OK</option>
										<option value="OR">OR</option>
										<option value="PA">PA</option>
										<option value="RI">RI</option>
										<option value="SC">SC</option>
										<option value="SD">SD</option>
										<option value="TN">TN</option>
										<option value="TX">TX</option>
										<option value="UT">UT</option>
										<option value="VT">VT</option>
										<option value="VA">VA</option>
										<option value="WA">WA</option>											<option value="WV">WV</option>
										<option value="WI">WI</option>
										<option value="WY">WY</option>
									</select>
								</div>
							</div>
						</div>
						<div class="row">
							<input type="hidden" name="host" value="${user.getId()}"/>
							<input type="submit" value="Create Event"/>
						</div>
					</form:form>
					<p>${eventError}</p>
				</div>
			</div>
		</div>
	</body>
</html>