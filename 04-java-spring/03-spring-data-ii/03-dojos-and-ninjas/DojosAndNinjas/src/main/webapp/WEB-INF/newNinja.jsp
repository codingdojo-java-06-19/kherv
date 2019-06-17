<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="css/styles.css">
<title>New Ninjas Page</title>
</head>
<body>
			<h1>New Ninjasss--the real D&J port 8080</h1>

<form:form action="/ninjas/new" method="post" modelAttribute="ninjas">

				<div class="row">
					<div class="col-25">
						<label for="dojo">Dojo:</label>
					</div>


					<div class="col-75">
						<form:select path="dojo">
		
							<form:option value="NONE" label="--- Select ---"/>
							<form:options items="${dojoList}" itemLabel="name" itemValue="id" />
		
						</form:select>
					</div>
				
				</div>
				<div>
					<form:label path="firstName">First Name</form:label>
					<form:errors path="firstName"/>
					<form:input path="firstName"/>
				</div>
				
				<div>
					<form:label path="lastName">Last Name</form:label>
					<form:errors path="lastName"/>
					<form:input path="lastName"/>
				</div>		
				
				<div>
					<form:label path="Age">Age</form:label>
					<form:errors path="Age"/>
					<form:input path="Age"/>
				</div>			
				
				<div class="row">
					<input type="submit" value="Create"/>
				</div>
				


</form:form>

</body>
</html>