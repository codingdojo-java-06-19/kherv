package com.codingdojo.EventsBeltReviewTwo.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.EventsBeltReviewTwo.models.User;
import com.codingdojo.EventsBeltReviewTwo.services.ApiService;
import com.codingdojo.EventsBeltReviewTwo.validator.UserValidator;

@Controller
public class LoginRegController {
	private final ApiService apiService;
	private final UserValidator userValidator;
	
	public LoginRegController(ApiService apiService, UserValidator userValidator) {
		this.apiService = apiService;
		this.userValidator = userValidator;
	}
	
	@RequestMapping("/")
	public String goHome(@ModelAttribute("user") User user) {
		return "loginReg.jsp";
	}
	
	
	@PostMapping("/register")
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session, RedirectAttributes redirectAttributes) {
		System.out.println("here");
		userValidator.validate(user, result);
		if(result.hasErrors()) {
			redirectAttributes.addFlashAttribute("registrationError", "try again");
			return "redirect:/";
		}
		try { 
			//First, we'll try to register a new user. If the email credentials are not duplicates, then we'll be prompted to login.
			apiService.registrationUser(user);
			//redirectAttributes.addFlashAttribute("preLoginMessage", "try again");
			session.setAttribute("userId", user.getId());
			redirectAttributes.addFlashAttribute("preLoginMessage", "Registration successful! Please log in with your new credentials.");
			return "redirect:/";
		}
		catch(Exception exception) {
			//If we already have a matching email address in our system, then we will generate flash messages and prompt the user to go back to the registration page.
			redirectAttributes.addFlashAttribute("registrationError", "Duplicate Credentials. Please try again with a different email address or log in with your existing account.");
			return "redirect:/";
		}
	}
	
	@PostMapping("/login")
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, RedirectAttributes redirectAttributes, HttpSession session) {
		if(apiService.authenticateUser(email, password)) {
			User user = apiService.findByEmail(email);
			session.setAttribute("userId", user.getId());
			return "redirect:/events/";
		}
		redirectAttributes.addFlashAttribute("loginError", "try again");
		return "redirect:/";
	}
	
	@PostMapping("/logout")
	public String logout(HttpSession session, RedirectAttributes redirectAttributes) {
		session.invalidate();
		redirectAttributes.addFlashAttribute("logoutSuccess", "success");
		
		return "redirect:/";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
