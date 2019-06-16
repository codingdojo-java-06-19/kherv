<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="css/styles.css">
<title>New Person Page</title>
</head>
<body>
			<h1>New Person</h1>

<form:form action="/persons/new" method="post" modelAttribute="person">
	<div>
		<form:label path="firstName">First Name</form:label>
		<form:errors path="firstName"/>
		<form:input path="firstName"/>
	</div>
	<div>
		<form:label path="lastName">Last Name</form:label>
		<form:errors path="lastName"/>
		<form:textarea path="lastName"/>
	</div>
	<input type="submit" value="Create"/>
</form:form>

</body>
</html>