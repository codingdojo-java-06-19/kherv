package com.codingdojo.DojosAndNinjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.DojosAndNinjas.models.Dojo;
import com.codingdojo.DojosAndNinjas.models.Ninja;
import com.codingdojo.DojosAndNinjas.services.DojoService;
import com.codingdojo.DojosAndNinjas.services.NinjaService;
import com.codingdojo.Languages.models.Language;

@Controller
@RequestMapping("/dojos")
public class DojoController {
	private final DojoService dojoService;
	public DojoController(DojoService dojoService) {
		this.dojoService = dojoService;
	}
		
	//new dojo
	@RequestMapping("/new")
	public String addDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "newDojo.jsp";
	}
	
	@RequestMapping(value="/new", method=RequestMethod.POST)
	public String newDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("Errors: "+result);
			return "newDojo.jsp";
		}
		else {
			dojoService.create(dojo);
			return "redirect:/ninjas/new";
		}
	}
	
	//show all ninjas in a dojo
	@RequestMapping("/{id}") //id coming in is of the dojo
	public String showDojoForNinjas(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dojoService.findOne(id);
		if(dojo==null) {
			return "redirect:/ninjas/new"; //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		}
		else {
			List<Ninja> ninjas = dojo.getNinjas();
			model.addAttribute("dojo", dojo);
			model.addAttribute("ninjas", ninjas);
			return "showdojoninjas.jsp";
		}

    	
	}
	
} // end dojoController
