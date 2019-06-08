<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Checkerboard Creator</title>
</head>
<link rel="stylesheet" href="styles.css" />
<body>
<p>Create checkerboard by using URL such as:  http://localhost:8080/Checkerboard/checkerboard.jsp?width=7&#38;height=7</p>

<% String rowsString = (request.getParameter("height"));
String colsString = request.getParameter("width");
%>

<%  int cols;
int rows;

rows = (rowsString==null? 2 : Integer.parseInt(rowsString));

cols = (colsString==null? 2 : Integer.parseInt(colsString));

%>


<p>Number of columns:  <%=cols %></p>
<p>Number of rows:  <%=rows %></p>
    
    <%! public boolean areBothEvenOdd(int i, int r){return ((i+r)%2==0)?  true:  false;} %>
   
   <% for(int col =0; col <cols; col++) { %>
   <div class="col"></div>
	    <% for(int index = 0; index < rows; index++) { %>
		<div class = "box" style='background-color: <%=areBothEvenOdd(index, col)? "black" : "white" %>'>
		</div>
		<% } %>
 	<% } %>
    
</body>
</html>