<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="/css/styles.css">
<title>Questions Dashboard</title>
</head>
<body>


<h1>Questions Dashboard</h1>




<table>
	<thead>
		<tr>
			<th>ID</th>
			<th>Question</th>
			<th>Tags</th>

		</tr>
	</thead>
	<tbody>
		<c:forEach items="${questions}" var="question">
		<tr>

		<td>${question.id}</td>

		<td><a href="/questions/${question.id}">  ${question.question}  </a></td>
		
		<td>tag, tag</td>

		</td>
		</tr>
		</c:forEach>
	</tbody>

</table>

<a href="/questions/new">New Question</a>


</body>
</html>