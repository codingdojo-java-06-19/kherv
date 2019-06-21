package com.codingdojo.events.controllers;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.events.models.Event;
import com.codingdojo.events.models.Message;
import com.codingdojo.events.models.User;
import com.codingdojo.events.services.ApiService;

@Controller
@RequestMapping("/events/")
public class EventController {
	private final ApiService apiService;
	
	public EventController(ApiService apiService) {
		this.apiService = apiService;
	}
	
	@RequestMapping("")
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
		
		//Grab all of the events that match the users' state and add them to the model...
		List<Event> eventsInState = apiService.eventsInYourState(userId);
		model.addAttribute("eventsInState", eventsInState);
		
		//...as well as all of the events not in the users' state
		List<Event> eventsNotInState = apiService.eventsNotInYourState(userId);
		model.addAttribute("eventsNotInState", eventsNotInState);
		
		return "events/showEvents.jsp";
	}
	
	@PostMapping("/new")
	public String addEvent(@ModelAttribute("event") Event event, BindingResult result, RedirectAttributes redirectAttributes) {
		if(result.hasErrors()) {
			redirectAttributes.addFlashAttribute("eventError", "Event could not be created. Please try again.");
			return "redirect:/events/";
		}
		apiService.createOrUpdateEvent(event);
		redirectAttributes.addFlashAttribute("eventSuccess", "You've successfully added an event!");
		return "redirect:/events/";
	}
	
	@RequestMapping("/{id}")
	public String showOneEvent(HttpSession session, RedirectAttributes redirectAttributes, @PathVariable("id") Long eventId, Model model){
		System.out.println("here>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		//First, check if the user is properly logged in (i.e. if there is an id in session)
				//If there isn't...
				if(session.getAttribute("userId")==null) {
					//Send them back to the login/reg page with a warning.
					redirectAttributes.addFlashAttribute("preLogIn", "Please log in in order to access the events page.");
					return "redirect:/";
				}
		//But if there is an id in session...
		//For this page we'll need the event in our model...
		Event thisEvent = apiService.findThisEvent(eventId);
		model.addAttribute("event", thisEvent);
		
		//...along with the info about our logged in user....
		Long userId = (Long)session.getAttribute("userId");
		User loggedInUser = apiService.findUserById(userId);
		model.addAttribute("loggedInUser", loggedInUser);
		
		//We'll also need to view all of the messages that have been added to this event
		List<Message> messages = apiService.findMessagesForThisEvent(eventId);
		model.addAttribute("messages", messages);
		
		return "events/showEvent.jsp";
	}
	
	@PostMapping("/newMessage/{id}")
	public String newMessage(@PathVariable("id") Long eventId, @RequestParam("author") Long authorId, @RequestParam("content") String content) {
		apiService.createMessage(content, authorId, eventId);
		return "redirect:/events/"+eventId;
	}
	
	@RequestMapping("/events/3/edit")
	public String editOneEvent() {
		return "events/editEvent.jsp";
	}
		
}

