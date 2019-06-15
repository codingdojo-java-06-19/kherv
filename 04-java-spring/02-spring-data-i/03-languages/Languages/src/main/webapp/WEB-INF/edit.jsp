<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
   <%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit a language </title>
</head>
<body>

<form:form action="/languages/${language.getId()}" method="post" modelAttribute="language">
	<input type="hidden" name="_method" value="put">
		<form:hidden path="id"/>
	<p>
		<form:label path="langName">Language</form:label>
		<form:errors path="langName"/>
		<form:input path="langName"/>
	</p>
	<p>
		<form:label path="creator">Creator</form:label>form:label>
		<form:errors path="creator"/>
		<form:textarea path="creator"/>
	</p>
	<p>
		<form:label path="version">Version</form:label>
		<form:errors path="version"/>
		<form:input path="version"/>
	</p>
	<input type="submit" value="submit"/>


</form:form>

</body>
</html>