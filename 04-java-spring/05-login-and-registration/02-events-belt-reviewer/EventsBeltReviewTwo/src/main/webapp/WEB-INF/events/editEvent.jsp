<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="/css/styles.css"/>
<meta charset="ISO-8859-1">
<title>Events Edit</title>
</head>

<body>

	<div class="container">
		<h3>Welcome, ${user.firstName} ${user.lastName}</h3>
		<h1>${event.name}, ${event.id}, <fmt:formatDate pattern="MM/dd/yyyy" value="${event.eventDate}"  />, ${event.city}, ${event.state}</h1>
		<div class="row">
			<div class="col-40">
				<h3>Edit Event</h3>
				<span class="bad">${eventError}</span>
				<form:form action="/events/${event.id}" method="POST" modelAttribute="event">
					<input type="hidden" name="_method" value="put">
					<form:hidden value="${userId}" path="host"/>
					<div class="row">
						<div class="col-25">
							<form:label path="name">Name</form:label>
							<form:errors path="name"></form:errors>
						</div>
						<div class="col-75">
							<form:input path="name"></form:input>
						</div>
					</div>
					<div class="row">
						<div class="col-25">
							<form:label path="eventDate">Date</form:label>
							<form:errors path="eventDate"></form:errors>
						</div>
						<div class="col-75">
							<fmt:formatDate pattern="yyyy-MM-dd" value="${event.eventDate}" var="theFormattedDate" />
							<form:input path="eventDate" value="${theFormattedDate}"></form:input>
						</div>
					</div>
						<div class="row">
							<div class="col-25">
								<form:label path="city">Location</form:label>
								<form:errors path="eventDate"></form:errors>
							</div>
							<div class="col-75">
								<div class="col-80">
									<form:input path="city"></form:input>						
								</div>
								<div class="col-20">
									<select name="state">
										<option selected="selected">${event.state}</option>option>
										<option value="AL">AL</option>
										<option value="AR">AR</option>
										<option value="TX">TX</option>
									</select>
								</div>
							</div>
						</div>
						<div class="row">
							<div class=col-75>
							</div>
							<div class="col-20">
								<input type="hidden" name="host" value="${user.getId()}"/>
								<input type="submit" value="Edit Event"/>
							</div>
					</div>
				</form:form>
			</div>
		</div>
	
	
	
	
	<a href="/events">Go to Events Page</a>
	</div> <!-- End container -->

</body>
</html>