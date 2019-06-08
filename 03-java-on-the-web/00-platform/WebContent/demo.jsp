<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Demo JSP</title>
</head>
<link rel="stylesheet" href="lib/styles.css" />
<body>
<h1>An H1 header that should be red.</h1>
<%!
	public int add(int a, int b) {
		return a + b;
	}

	int i =2;
	int j= 4;
%>

<h2><%=add(i,j) %></h2>

<% for(int index = 0; index < 5; index++) { %>
	<h3><%= index %></h3>
<% } %>

<p>
The time is:  <%= new Date() %>
</p>


</body>
</html>