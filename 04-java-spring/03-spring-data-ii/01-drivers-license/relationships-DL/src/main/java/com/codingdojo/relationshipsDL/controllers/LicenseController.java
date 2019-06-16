package com.codingdojo.relationshipsDL.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.relationshipsDL.models.License;
import com.codingdojo.relationshipsDL.models.Person;
import com.codingdojo.relationshipsDL.services.LicenseService;
import com.codingdojo.relationshipsDL.services.PersonService;

@Controller
@RequestMapping("/licenses")
public class LicenseController {

	private final LicenseService licenseService;
	private final PersonService personService;
	
	public LicenseController(LicenseService licenseService, PersonService personService) {
		this.licenseService = licenseService;
		this.personService = personService;
	}
	
	@RequestMapping("/new")
	public String newLicense(@ModelAttribute("license") License license, Model model) {
		System.out.println("Welcome to the new licenses page!");
		List<Person> persons = personService.getAllWithNoLicense();
		model.addAttribute("persons", persons);
		return "/WEB-INF/newLicense.jsp";
	}
	
	@RequestMapping(value="/new", method=RequestMethod.POST)
	public String addLicense(@Valid @ModelAttribute("license") License license, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("Oops, you had some errors: "+result);
			return "/WEB-INF/newLicense.jsp";
		}
		else {
			System.out.println("Success! We're creating a new license and adding it to that person.");
			licenseService.createLicense(license);
			return "redirect:/persons/"+license.getPerson().getId();
		}
	}	
	
	
	
	
	
	

}
