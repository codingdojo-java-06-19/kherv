package com.codingdojo.DojoOverflow.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.DojoOverflow.models.Question;
import com.codingdojo.DojoOverflow.services.QuestionService;

@Controller
@RequestMapping("/questions")
public class QuestionController {
	private final QuestionService questionService;
	
	public QuestionController(QuestionService questionService) {
		this.questionService = questionService;
	}

	public QuestionService getQuestionService() {
		return questionService;
	}

	//Dashboard, display all questions
	@RequestMapping("")
	public String index(@ModelAttribute("questions") Question question, Model model) {
		List<Question> questions = questionService.showAllQuestions();
		model.addAttribute("questions", questions);
		return "index.jsp";
	}
	
	//New Question Create question by user input to post
	//first render page
	@RequestMapping("/new")
	public String addQuestion(@ModelAttribute("question") Question question) {
		return "newQuestion.jsp";
	}
	
	//gather post result and process
	@RequestMapping(value = "/newQ", method = RequestMethod.POST)
	public String newQuestion() {
		System.out.println("Ready to process new question post");
		
		return "redirect:/questions";
	}
	
	
	//New Answer Create answer by user input to post
	//First render page showing question, tags, existing answers, and form for entering new answer
	@RequestMapping("/{id}")
	public String showQuestion(@PathVariable ("id") Long id) {
//	public String showCategory(@PathVariable ("id") Long id, @ModelAttribute("productCategory") CategoryProduct categoryProduct, Model model) {
////		Category category1 = categoryService.findOne(id);
//		model.addAttribute("category1",  category1);
//		
//		List<Product> productsHave = productService.findProductsWithThisCategory(category1);
//		model.addAttribute("productsHave", productsHave);
//		
//		List<Product> productsNot = productService.findProductsWithoutThisCategory(category1);
//		
//		model.addAttribute("productsNotYetAdded", productsNot);
		
		return "showQuestion.jsp";
	}
	
	//gather post result from new answer and process
	@RequestMapping(value = "/newA", method = RequestMethod.POST)
	public String newAnswer() {
		System.out.println("Ready to process new answer post");
		
		return "redirect:/questions";
	}
	
	
}
