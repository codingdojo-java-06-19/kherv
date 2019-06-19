package com.codingdojo.DojoOverflow.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.DojoOverflow.services.QuestionService;

@Controller
@RequestMapping("/")
public class QuestionController {
	private final QuestionService questionService;
	
	public QuestionController(QuestionService questionService) {
		this.questionService = questionService;
	}

	public QuestionService getQuestionService() {
		return questionService;
	}

}
