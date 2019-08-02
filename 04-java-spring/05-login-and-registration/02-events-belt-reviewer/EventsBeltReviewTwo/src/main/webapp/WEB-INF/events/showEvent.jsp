
    
    <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
    
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/css/styles.css?v=3">


<meta charset="ISO-8859-1">
<title>${event.name}</title>
</head>

<body>
	<div class="container">
		Welcome, ${loggedInUser.firstName} ${loggedInUser.lastName}
		<h3>${event.name}</h3>
		<div class="leftSide">
			<h4>Host: ${event.host.firstName} ${event.host.lastName}</h4>
			<h4>
				Date:  <fmt:formatDate type = "date" dateStyle = "long" value = "${event.eventDate}" />
			</h4>
			<h4>Location:  ${event.city}, ${event.state}</h4>
			<h4>People who are attending this event: ${event.members.size() }</h4>
			<table class="tablestyle">
				<thead>
					<tr>
						<th>Name</th>
						<th>Location</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="member" items="${event.getMembers()}">
						<tr>
							<td>
							${member.firstName}
							</td>
							<td>
							${member.city}
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div> <!-- end leftSide -->
	
		<div class="rightSide">
		
			<h3>Message Wall</h3>
			<div class="message-box">
				<c:forEach var="message" items="${event.getMessages()}">
				<p>${message.author.firstName} says ${message.content}</p>
				<p>*~*~*~*~*~**</p>
				</c:forEach>
			</div>
			<form action="/events/${event.id}/comment" method="post">
				<label for="comment">Add Comment</label>
				${error}
				<textarea name="comment" id="comment"></textarea>
				<div class="col-75"></div>
				<div class="col-25">
				<button>Submit</button>		
				</div>
			</form>
			
		
		
		
		
		</div>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	<a href="/events">Go to Events Page</a>
	
	
	</div >

</body>
</html>