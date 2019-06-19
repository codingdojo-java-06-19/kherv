package com.codingdojo.DojoOverflow.services;

import java.util.List;

import org.springframework.stereotype.Service;


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
	
	
	
}
