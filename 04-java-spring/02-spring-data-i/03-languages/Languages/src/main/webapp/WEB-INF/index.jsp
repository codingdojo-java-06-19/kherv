<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Languages Page</title>
</head>
<body>
<p><c:out value="${success}" /></p>

<table>
	<thead>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Creator</th>
			<th>Version</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${langs}" var ="lang">
		<tr>
		<td><c:out value = "${lang.id}"/></td>
		<td><c:out value = "${lang.langName}"/></td>
		<td><c:out value = "${lang.creator}"/></td>
		<td><c:out value="${lang.version}"/></td>
		</tr>
		</c:forEach>
	</tbody>
	
	
	
</table>
<a href="/languages/new">New Language</a>
</body>
</html>