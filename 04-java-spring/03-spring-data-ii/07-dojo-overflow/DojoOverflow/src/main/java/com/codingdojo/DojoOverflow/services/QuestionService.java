package com.codingdojo.DojoOverflow.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.DojoOverflow.models.Answer;
import com.codingdojo.DojoOverflow.models.Question;
import com.codingdojo.DojoOverflow.repositories.QuestionRepository;

@Service
public class QuestionService {
	private final QuestionRepository questionRepository;
	
	public QuestionService(QuestionRepository questionRepository) {
		this.questionRepository = questionRepository;
	}

	public List<Question> showAllQuestions(){
		return questionRepository.findAll();
	}
	
	//Create a question
	public Question createOrUpdateQuestion(Question question) {
		return questionRepository.save(question);
	}
	
	//retrieve one question by id
	public Question showOneQuestion(Long id) {
		return questionRepository.findById(id).orElse(null);
	}
	

	//Return one Question
	public Question findOne(Long id) {
		return questionRepository.findById(id).orElse(null);
	}
	
	//Add answer to question using the question id
	public void addAnswerToQuestion(Long question_id, Answer answer) {
		Question question = findOne(question_id);
		addAnswerToQuestion(question, answer);
	}
	
	//Add Answer To Question With Question Object
	public void addAnswerToQuestion(Question question, Answer answer) {
		question.addAnswer(answer);
		questionRepository.save(question);
	}
	
	
	
	
}
