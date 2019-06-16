package com.codingdojo.relationshipsDL.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.relationshipsDL.models.Person;
import com.codingdojo.relationshipsDL.services.PersonService;

@Controller
@RequestMapping("/persons")
public class PersonController {
	private final PersonService personService;
	
	public PersonController(PersonService personService) {
		this.personService = personService;
	}
	
	//new person
	@RequestMapping("/new")
	public String newPerson(@ModelAttribute("person") Person person) {
		System.out.println("heretoo");
		return "/WEB-INF/newPerson.jsp";
	}
	
	@RequestMapping(value="/new", method=RequestMethod.POST) 
	public String create(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		System.out.println("here below");
		if (result.hasErrors()) {
			return "/WEB-INF/newperson.jsp";
		}
		personService.createPerson(person);
			return "redirect:/persons/new";
		}

	 @RequestMapping("/{id}")
	    public String show(@PathVariable("id") Long id, Model model) {
	    	Person person = personService.findPerson(id);
	    	if(person==null) {
	    		return "redirect:/persons/new";
	    	}
	    	else {
		    	model.addAttribute("person", person);
		    	return "/WEB-INF/show.jsp";
	    	}
	    }
	
	
	
	

} // end of person controller class
