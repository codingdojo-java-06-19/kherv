package com.codingdojo.DojoOverflow.services;

import org.springframework.stereotype.Service;

import com.codingdojo.DojoOverflow.repositories.AnswerRepository;
import com.codingdojo.DojoOverflow.repositories.QuestionRepository;

@Service
public class AnswerService {
	private final AnswerRepository answerRepository;
	private final QuestionRepository questionRepository;
	
	public AnswerService(AnswerRepository answerRepo, QuestionRepository questionRepo) {
		this.answerRepository=answerRepo;
		this.questionRepository=questionRepo;
	}
	
	

}
