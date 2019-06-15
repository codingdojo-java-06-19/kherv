package com.codingdojo.Languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.Languages.models.Language;
import com.codingdojo.Languages.services.LanguageService;



@Controller
@RequestMapping("/languages")
public class LanguagesController {
	private final LanguageService languageService;
	
	public LanguagesController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@RequestMapping("")
	public String index(Model model) {
		List<Language> languages = languageService.allLanguages();
		model.addAttribute("langs", languages);
		return "index.jsp";
	}
	
	@RequestMapping("/new")
	public String newLang(@ModelAttribute("language") Language language) {
		return "new.jsp";
	}
	
	//Make new language
	@RequestMapping(value="", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("language") Language language, BindingResult result) {		
		if (result.hasErrors()) {
			return "new.jsp";
		} 	
		languageService.createLanguage(language);
		return "redirect:/languages";
	}
	// show one language
    @RequestMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model) {    
    model.addAttribute("langs", languageService.findLang(id));
    return "show.jsp";
    }
    
    //update a language
    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public String update(@PathVariable("id") Long id, @Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
            languageService.updatedLanguage(language);
            return "redirect:/languages";
        }
    }
    
    @RequestMapping("/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
    	Language language = languageService.findLang(id);
    	model.addAttribute("language", language);
    	return "edit.jsp";
    }
    
    //delete a language
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id, RedirectAttributes redirectattrs) {    	
    	languageService.deleteLanguage(id);
    	redirectattrs.addFlashAttribute("success", "Successully Deleted!!");
    	return "redirect:/languages";
    }
    
} // class
