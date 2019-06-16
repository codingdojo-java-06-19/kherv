<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="css/styles.css">
<title>New Song Page</title>
</head>
<body>

<a href="/dashboard">Dashboard</a>

<form:form action="/songs" method="post" modelAttribute="song">
	<div>
		<form:label path="title">Song Title Name</form:label>
		<form:errors path="title"/>
		<form:input path="title"/>
	</div>
	<div>
		<form:label path="artist">Artist</form:label>
		<form:errors path="artist"/>
		<form:textarea path="artist"/>
	</div>
	<div>
		<form:label path="rating">Rating</form:label>
		<form:errors path="rating"/>
		
		<form:select path="rating">
			<form:option  value="1"/>
			<form:option  value="2"/>
			<form:option  value="3"/>
			<form:option  value="4"/>
			<form:option  value="5"/>
			<form:option  value="6"/>
			<form:option  value="7"/>
			<form:option  value="8"/>
			<form:option  value="9"/>
			<form:option  value="10"/>
			</form:select>
		
		
		
		
	</div>
	<input type="submit" value="Add Song"/>
</form:form>

</body>
</html>