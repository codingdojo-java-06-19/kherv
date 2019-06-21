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
			<h1>Soccer Game</h1>
			<div class="row">
				<div class="col">
					<div class="event-info">
						<p>Host: Musk Johnson</p>
						<p>Date: November 30, 2018</p>
						<p>Location: Phoenix, AZ</p>
						<p>People who are attending this event: 3</p>
					</div>
					<table class="tablestyle">
						<tr>
							<th>Name</th>
							<th>Location</th>
						</tr>
						<tr>
							<td>John Doe</td>
							<td>Burbank</td>
						</tr>
						<tr>
							<td></td>
							<td></td>
						</tr>
					</table>
				</div>
				<div class="col">
					<h3>Message Wall</h3>
					<div class="message-wall">
						<div class="message-group">
							<p>Ninja says: Hello Everyone this is a really long sentence just so i can see what happens in the message wall box</p>
							<p>~*~*~*~*~*~*~*~*~**~*~*~</p>
						</div>
					</div>
					<form action="/" method="POST" autocomplete="off">
						<label for="message">Add Comment:</label>
						<textarea></textarea>
						<input type="submit" name="Submit"/>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>