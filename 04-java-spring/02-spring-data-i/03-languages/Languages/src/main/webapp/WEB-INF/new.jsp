<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New language Page</title>
</head>
<body>

<form:form action="/languages" method="post" modelAttribute="language">
	<div>
		<form:label path="langName">Language Name</form:label>
		<form:errors path="langName"/>
		<form:input path="langName"/>
	</div>
	<div>
		<form:label path="creator">Creator</form:label>
		<form:errors path="creator"/>
		<form:textarea path="creator"/>
	</div>
	<div>
		<form:label path="version">Version</form:label>
		<form:errors path="version"/>
		<form:input path="version"/>
	</div>
	<input type="submit" value="submit"/>
</form:form>

</body>
</html>