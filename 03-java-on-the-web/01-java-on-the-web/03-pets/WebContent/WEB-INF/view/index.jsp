<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Make Pet Page</title>
</head>
<body>
<h1>Let's create a pet...Dog or Cat only...no snakes here</h1>

<section>
	<p>Create a Dog</p>	
	<form  action="/pets/Dogs" method="GET">
	
		<label for="name">Name:</label>
		<input type="text" name="name">
		
		<label for="breed">Breed:</label>
		<input type="text" name="breed">
		
		<label for="weight">Weight:</label>
		<input type="text" name="weight">
	
		<input type="submit" value="Create Dog">

	</form>
</section>


<section>
	<p>Create a Cat</p>	
	<form  action="/pets/Cats" method="GET">
	
		<label for="name">Name:</label>
		<input type="text" name="name">
		
		<label for="breed">Breed:</label>
		<input type="text" name="breed">
		
		<label for="weight">Weight:</label>
		<input type="text" name="weight">
	
		<input type="submit" value="Create Cat">

	</form>
</section>


</body>
</html>