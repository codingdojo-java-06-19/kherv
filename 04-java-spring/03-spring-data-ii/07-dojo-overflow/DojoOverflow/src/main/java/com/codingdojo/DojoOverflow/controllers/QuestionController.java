package com.codingdojo.DojoOverflow.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.DojoOverflow.models.Answer;
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
		model.addAttribute("questions", questions); //needed to make questions available on view
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
	public String showQuestion(@ModelAttribute("answerM") Answer answer, @PathVariable ("id") Long id, Model model) {
		//the answerM model attribute above automatically adds answer to the model...so the view can use it
		//answerM must match the post ModelAttribute and also that in the form
		//pathvariable means getting from url....param is about getting data from the browser..probably form
		Question question1 = questionService.showOneQuestion(id);
		if(question1==null) {
			return "redirect:/questions";
		}
		model.addAttribute("question1", question1); //addS to model ...which is key value pairs communicating with the view
			
		List<Tag> question1Tags = question1.getTags();
		model.addAttribute("thisQuestionsTags", question1Tags);
		
		List<Answer> question1Answers =question1.getAnswers();

			model.addAttribute("thisQuestionsAnswers", question1Answers);

		return "showQuestion.jsp";
	}
	
	//gather post result from new answer and process
	@RequestMapping(value = "/{id}/answers", method = RequestMethod.POST)
	public String createAnswer(@Valid @ModelAttribute("answerM") Answer answer, BindingResult result, @PathVariable("id") Long question_id) {
		System.out.println("Ready to process new answer post");
		System.out.println("question number should b" + answer.getQuestion()); //answer is not in the database, but question is
		System.out.println("answer should be " + answer.getAnswer() ); //we already know the answer here because it came in from the form and attached to model attribute
		//questionService.addAnswerToQuestion(question_id, answer);
		if(result.hasErrors()) {
			//more needs to happen than just the below rendering because the page needs to know the question and the answers and tags
			return "showQuestion.jsp";
		}
		//don't need to save the question because it has not changed
		answerService.saveAnswer(answer);
		
//		Question thisQuestion = questionService.showOneQuestion(question_id);
//		
//		//Use the parameters submitted through our form to populate a new Answer with content...
//		answer.setAnswer(answer.getAnswer());
//		answer.setQuestion(thisQuestion);
//		System.out.println("Our answer contains the following content: "+answer.getAnswer());
//		answerService.saveAnswer(answer);
//		
//		System.out.println("Our answer contains the following content: "+answer.getAnswer());
//		
//		answerService.addAnswerToQuestion(question_id, answer);
//		//...then save that answer.
//		
//		System.out.println("Our question has the following answers: "+thisQuestion.getAnswers());
//		questionService.createOrUpdateQuestion(thisQuestion);
//		System.out.println("here");
		
		return "redirect:/questions";
	}
	
	
}
