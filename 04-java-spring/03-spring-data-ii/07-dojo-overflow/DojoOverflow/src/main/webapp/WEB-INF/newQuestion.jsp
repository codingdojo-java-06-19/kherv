<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="/css/styles.css">
<title>New Question Page</title>
</head>
<body>
			<h1>What is your Question?</h1>

			<h2>Form to gather question will be here</h2>
			<form:form action="/questions" method="post" modelAttribute="questionM">
			
				<div>
					<form:label path="question">Question</form:label>
					<form:errors path="question"/>
					<form:input path="question"/>
				</div>
				
				<div>
					<label >Tags</label>
					<input type=text name="tagString" />
				</div>
				
				<div class="row">
					<input type="submit" value="Create"/>
				</div>
			
			
			</form:form>

</body>
</html>