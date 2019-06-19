package com.codingdojo.DojoOverflow.services;

import org.springframework.stereotype.Service;

import com.codingdojo.DojoOverflow.repositories.QuestionRepository;

@Service
public class QuestionService {
	private final QuestionRepository questionRepository;
	
	public QuestionService(QuestionRepository questionRepository) {
		this.questionRepository = questionRepository;
	}
}
