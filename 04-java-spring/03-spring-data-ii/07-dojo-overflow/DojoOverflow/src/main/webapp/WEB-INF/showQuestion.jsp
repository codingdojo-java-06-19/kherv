<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="/css/styles.css">
<title>Question Profile</title>
</head>
<body>
	<body>
		<div class="container">
				<h1>The Question: ${question1.question}</h1>
				<div class="tagsDisplay">
				<h2>The Tags will display here</h2>
									<ul>
						<c:forEach items="${thisQuestionsTags}" var="tags"> 
							<li>
								<c:out value="${tags.subject}"/>
							</li>
		        		</c:forEach>
					</ul>
				
				
				</div> <!-- end of tagsDisplay -->
			
					<div class="AnswersAndAddAnswer">
								<div class="AnswerList">
								<p>The list of answers will display here
			
								<p>Categories this product is in:</p>
								<ul>
			
									<c:forEach items="${answerThisQuestion}" var="category"> 
										<li>
											<c:out value="${answer.answer}"/>
										</li>
					        		</c:forEach>
								</ul>
			
			
							</div> <!-- end AnswerList -->
							
			
							<div class ="AddAnswer">
			
								The form to add another answer will display here
							</div> <!-- End AddAnswer -->
		
					</div> <!-- end AnswersAndAddAnswer -->

		</div> <!-- End Container -->
	</body>


</body>
</html>