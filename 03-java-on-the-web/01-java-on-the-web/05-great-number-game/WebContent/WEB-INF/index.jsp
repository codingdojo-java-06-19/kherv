<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Great Number Game</title>
<link rel="stylesheet" href="/WEB-INF/styles.css" />
<style>
<style>
<%@include file="/WEB-INF/styles.css"%>
</style>




</head>
<body>

	<h1>Welcome to the Great Number Game!</h1>
	<h2>I am thinking of a number between 1 and 100</h2>
	<h3>Take a guess!</h3>

	<c:out value='${guessResult }' />
	is guess by session

	<c:out value='${guessResultR}' />
	is guess by request

	<c:if test='${(didGuess=="yes") &&  (guessResultR =="1")}'>
		<div class="alert red">
			<p>Too high!</p>
		</div>
	</c:if>
	<c:if test='${(didGuess=="yes") && (guessResultR=="-1")}'>

		<div class="alert red">
			<p>Too low!</p>
		</div>

	</c:if>

	<c:if test='${(didGuess=="yes") && (guessResultR=="0")}'>
		<div class="alert green">
			<p>
				Yes!
				<c:out value="${targetNumber}" />
				Is the number
			</p>

			<%
				session.removeAttribute("targetNumber");
			%>
			<%
				session.setAttribute("didGuess", "no");
			%>
			<%
				session.setAttribute("showForm", "no");
			%>

			<form action="" method="GET">
				<button type="submit" value="Submit">Play Again</button>
			</form>

		</div>

	</c:if>



	<%
		if (session.getAttribute("showForm") == "yes") {
	%>
	<form action="" method="POST">

		<input type="text" name="inputNumber">

		<button type="submit" value="Submit">Submit</button>

	</form>

	<p>
		Target number is
		<c:out value="${targetNumberR}" />
	</p>

	<%
		}
	%>

</body>
</html>