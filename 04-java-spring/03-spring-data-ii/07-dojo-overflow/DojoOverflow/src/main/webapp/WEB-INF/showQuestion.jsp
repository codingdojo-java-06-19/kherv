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
				<h1>The Question: ${question1.question}  ${question1.id}</h1>
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
								
								<p>Answers</p>
								<ul>
			
									<c:forEach items="${thisQuestionsAnswers}" var="thisAnswers"> 
										<li>
											a<c:out value="${thisAnswers.answer}"/>
										</li>
					        		</c:forEach>
								</ul>
			
			
							</div> <!-- end AnswerList -->
							
			
							<div class ="AddAnswer">
			
								<p>Add your answer</p>

								<form:form action="/questions/${question1.id}/answers" method="post" modelAttribute="answerM">
								<form:hidden path="question" value="${question1.id}"/>
									<div>
										<form:label path="answer">Answer</form:label>
										<form:errors path="answer"/>
										<form:input path="answer"/>
									</div>

									
									<div class="row">
										<input type="submit" value="Answer It"/>
									</div>
								

								</form:form>
								
								
							</div> <!-- End AddAnswer -->
		
					</div> <!-- end AnswersAndAddAnswer -->

		</div> <!-- End Container -->
	</body>


</body>
</html>