package com.codingdojo.DojoOverflow.services;

import org.springframework.stereotype.Service;

import com.codingdojo.DojoOverflow.models.Answer;
import com.codingdojo.DojoOverflow.models.Question;
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
	
	//Add Answer To Question With Question Object
	public void addAnswerToQuestion(Question question, Answer answer) {
		System.out.println("inside other AddAnswerToQuestion" + answer.getAnswer() + " " + question.getQuestion());
		question.addAnswer(answer);
		System.out.println("we added it");
		questionRepository.save(question);
	}

	//Add Answer To Question with Question ID
	public void addAnswerToQuestion(Long question_id, Answer answer) {
		System.out.println("inside AddAnswerToQuestion " + question_id + " " + answer.getAnswer());
		Question thisQuestion = findOne(question_id);
		addAnswerToQuestion(thisQuestion, answer);
	}
	
	//Find one question (for use within the service file only)
	public Question findOne(Long id) {
		System.out.println("finding one");
		return questionRepository.findById(id).orElse(null);
	}

	public void saveAnswer(Answer answer) {
		answerRepository.save(answer);
	}
	
}
