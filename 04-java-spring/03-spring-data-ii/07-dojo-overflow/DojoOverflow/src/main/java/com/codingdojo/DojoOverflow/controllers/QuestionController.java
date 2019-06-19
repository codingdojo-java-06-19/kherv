package com.codingdojo.DojoOverflow.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.DojoOverflow.models.Question;
import com.codingdojo.DojoOverflow.models.Tag;
import com.codingdojo.DojoOverflow.services.AnswerService;
import com.codingdojo.DojoOverflow.services.QuestionService;
import com.codingdojo.DojoOverflow.services.TagService;

@Controller
@RequestMapping("/questions")
public class QuestionController {
	private final QuestionService questionService;
	private final TagService tagService;
	private final AnswerService answerService;
	
	public QuestionController(QuestionService questionService, TagService tagService, AnswerService answerService) {
		this.questionService = questionService;
		this.answerService = answerService;
		this.tagService = tagService;
	}

	public QuestionService getQuestionService() {
		return questionService;
	}

	//Dashboard, display all questions
	@RequestMapping("")
	public String index( Model model) {
		List<Question> questions = questionService.showAllQuestions();
		model.addAttribute("questions", questions);
		return "index.jsp";
	}
	
	//New Question Create question by user input to post
	//first render page
	@RequestMapping("/new")
	public String addQuestion(@ModelAttribute("questionM") Question question) {
		return "newQuestion.jsp";
	}
	
	//gather post result and process
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String createQuestion(@ModelAttribute("questionM") Question question, @RequestParam("tagString") String tagString  ) {
		System.out.println("Ready to process new question post");
		String[] commaTags =tagString.split(",");
		//limit to three
		final int count= commaTags.length>3? 3: commaTags.length;
		//now loop through to get the value of each tag and put into a tag object
		for(int i=0; i<count; i++) {
			Tag newTag = tagService.findOrCreateTag(commaTags[i]);
			tagService.addTagToQuestion(newTag, question);
		}
		questionService.createOrUpdateQuestion(question);
		return "redirect:/questions";
	}
	
	
	//New Answer Create answer by user input to post
	//First render page showing question, tags, existing answers, and form for entering new answer
	@RequestMapping("/{id}")
	public String showQuestion(@PathVariable ("id") Long id, Model model) {
		Question question1 = questionService.showOneQuestion(id);
		if(question1==null) {
			return "redirect:/questions";
		}
		model.addAttribute("question1", question1);
		
		
		List<Tag> question1Tags = question1.getTags();
		model.addAttribute("thisQuestionsTags", question1Tags);
		
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
	@RequestMapping(value = "/{id}/answers", method = RequestMethod.POST)
	public String createAnswer() {
		System.out.println("Ready to process new answer post");
		
		return "redirect:/questions";
	}
	
	
}
