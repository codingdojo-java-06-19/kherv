<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="css/styles.css">
<title>New License Page</title>
</head>
<body>
			<h1>New License</h1>

<form:form action="/licenses/new" method="post" modelAttribute="license">

	<div class="row">
		<div class="col-25">
			<label for="person">Person:</label>
		</div>
		<div class="col-75">
			<select name="person" path="person">
				<c:forEach items="${persons}" var="person">
					<option value="<c:out value="${person.id}"/>"><c:out value="${person.firstName}"/> <c:out value="${person.lastName}"/></option>
			  	</c:forEach>
			</select>
		</div>
	</div>





	<div>
		<form:label path="state">State</form:label>
		<form:errors path="state"/>
		<form:textarea path="state"/>
	</div>
		<div>
		<form:label path="expirationDate">Expiration Date</form:label>
		<form:errors path="expirationDate"/>
		<form:input type="date" path="expirationDate"/>
	</div>
	<input type="submit" value="Create"/>
</form:form>

</body>
</html>