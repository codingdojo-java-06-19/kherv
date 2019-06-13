package com.codingdojo.TheCode;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CodeTheController {
	String correctGuess = "bushido";
	@RequestMapping("/")
	public String index() {
		return "secret.jsp";
	}

	@RequestMapping(value="/codeGuess", method=RequestMethod.POST)
	public String code(@RequestParam(value="theGuess") String theGuessStr, RedirectAttributes redirectAttributes) {
		System.out.println("here");
		if(theGuessStr.equals(correctGuess)) {
			System.out.printf("correct guess");
			return "redirect:/code";
		}
		else {
			System.out.printf("entered code is wrong");
			

		    redirectAttributes.addFlashAttribute("error", "A You must train harder!");

			return "redirect:/";
		}
		
	}
	
	@RequestMapping("/code") 
	public String goBack() {
		return "bushido.jsp";
	
		
	}

}
