package com.codingdojo.events.controllers;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.events.models.Event;
import com.codingdojo.events.models.User;
import com.codingdojo.events.services.ApiService;

@Controller
@RequestMapping("/events")
public class EventController {
	private final ApiService apiService;
	
	public EventController(ApiService apiService) {
		this.apiService = apiService;
	}
	
	@RequestMapping("/")
	public String showDashboard(@ModelAttribute("event") Event event, HttpSession session, RedirectAttributes redirectAttributes, Model model) {
		//First, check if the user is properly logged in (i.e. if there is an id in session)
		//If there isn't...
		if(session.getAttribute("userId")==null) {
			//Send them back to the login/reg page with a warning.
			redirectAttributes.addFlashAttribute("preLogIn", "Please log in in order to access the events page.");
			return "redirect:/";
		}
		//But if there is an id in session...
		Long userId = (Long)session.getAttribute("userId");
		//Find the user...
		User loggedInUser = apiService.findUserById(userId);
		//...and add them to the model.
		model.addAttribute("user", loggedInUser);
		return "events/showEvents.jsp";
	}
	
	@RequestMapping("/{id}")
	public String showOneEvent(@RequestParam("id") Long id) {
		return "events/showEvent.jsp";
	}
	
	@RequestMapping("/events/3/edit")
	public String editOneEvent() {
		return "events/editEvent.jsp";
	}
		
}
