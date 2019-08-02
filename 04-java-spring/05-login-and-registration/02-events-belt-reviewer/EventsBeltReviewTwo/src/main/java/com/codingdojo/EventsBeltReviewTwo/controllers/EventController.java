package com.codingdojo.EventsBeltReviewTwo.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.EventsBeltReviewTwo.models.Event;
import com.codingdojo.EventsBeltReviewTwo.models.Message;
import com.codingdojo.EventsBeltReviewTwo.models.User;
import com.codingdojo.EventsBeltReviewTwo.services.ApiService;

@Controller
@RequestMapping("/events")
public class EventController {
	private final ApiService apiService;
	
	public EventController(ApiService apiService) {
		this.apiService = apiService;
	}

	//should arrive here from the login route/page and render the showEvents page
	//which is like an index page
	@RequestMapping("")
	public String showDashboard(@ModelAttribute("event") Event event, HttpSession session, RedirectAttributes redirectAttributes, Model model) {
		// First, check if the user is properly logged in (i.e. if there is an id in
		// session)
		// If there isn't...
		if (session.getAttribute("userId") == null) {
			// Send them back to the login/reg page with a warning.
			redirectAttributes.addFlashAttribute("preLogin", "Please log in in order ot access the events page.");
			return "redirect:/";
		}
		
		// But if there is an id in session
		Long userId = (Long) session.getAttribute("userId");
		// find the user
		User loggedInUser = apiService.findUserById(userId);
		//..add to model
		model.addAttribute("user", loggedInUser);
		
		//Get this user's state
		model.addAttribute("thisUsersState", loggedInUser.getState());
		
		//Get all the events that match the user stage and ad to the model
		List<Event> eventsInState = apiService.eventsInYourState(userId);
		model.addAttribute("eventsInState", eventsInState);
		
		// and ones not in state
		List<Event> eventsNotInState = apiService.eventsNotInYourState(userId);
		model.addAttribute("eventsNotInState", eventsNotInState);
		//print all the in state events
		// print all the in state events
		System.out.println("am inside showDashboard or showEvents or index...number of events in other state " + eventsNotInState.size());
		for (int i = 0; i < eventsNotInState.size(); i++) {
			String bubba = eventsNotInState.get(i).getHost().getFirstName();
			System.out.println("the name is:  " + bubba);
			System.out.println("date is:  " + eventsNotInState.get(i).formatEventDate());
			System.out.println("city is:  " + eventsNotInState.get(i).getCity());
			System.out.println("host's id is:  " + eventsNotInState.get(i).getHost().getId());
			System.out.println("user id is:  " + loggedInUser.getId());
		}
		
		return "events/showEvents.jsp";
	}
	
	// Create Event comes here from the create event page at the bottom of the show
	// events or index page
	@PostMapping("/new")
	public String addEvent(@ModelAttribute("event") @Valid Event event, BindingResult result, RedirectAttributes redirectAttributes ) {
		System.out.println("first of addEvent method");
		System.out.println("event name is:  " + event.getName());
		System.out.println("0event city is:  " + event.getCity());
		System.out.println("event date is:  " + event.getEventDate());
		if (result.hasErrors()) {
			
			System.out.println("we had an error");
			System.out.println("all errors " + result.getAllErrors().toString());
			
			redirectAttributes.addFlashAttribute("eventError", "Event could not be created.  Please try again.");
			return "redirect:/events";
		}

		
		apiService.createOrUpdateEvent(event);
		redirectAttributes.addFlashAttribute("eventSuccess", "Successfully added");
		return "redirect:/events";
		}
	
	// if successful will render the page that shows details for an event
	@RequestMapping("/{id}")
	public String showOneEvent(HttpSession session, RedirectAttributes redirectAttributes, @PathVariable("id") Long eventId, Model model) {
		// First, check if the user is properly logged in (i.e. if there is an id in
		// session)
		// If there isn't...
		if (session.getAttribute("userId") == null) {
			//send them back
			redirectAttributes.addFlashAttribute("preLogin", "please login");
			return "redirect:/";
		}
		//is id in session
		Event thisEvent = apiService.findThisEvent(eventId);
		model.addAttribute("event", thisEvent);
		
		// and info about user
		Long userId = (Long) session.getAttribute("userId");
		User loggedInUser = apiService.findUserById(userId);
		model.addAttribute("loggedInUser",  loggedInUser);
		
		//view messages
		List<Message> messages = apiService.findMessagesForThisEvent(eventId);
		model.addAttribute("messages", messages);
		return "events/showEvent.jsp";
	}
	
	//Creates New Message comes here from the add message form at the bottom of the show event page
	@PostMapping("/newMessage/{id}")
	public String newMessage(@PathVariable("id") Long eventId, @RequestParam("author") Long authorId, @RequestParam("content") String content ) {
		apiService.createMessage(content, authorId, eventId);
		return "redirect:/events/" + eventId;
	}
	
	//more restful 
	@PostMapping("/{id}/comment")
	public String Comment(@PathVariable("id") Long eventId, @RequestParam("comment") String content, RedirectAttributes redirs, HttpSession session) {
		Long authorId = (Long) session.getAttribute("userId");
		if(authorId == null) {
			return "redirect:/";
		}
		if(content.equals("")) {
			redirs.addFlashAttribute("error", "Comment must not be blank");
			return "redirect:/events/" +eventId;
		}
		//Event event = this.apiService.findThisEvent(id);
		//User user = this.apiService.findUserById(userId);
		apiService.createMessage(content, authorId, eventId);
		return "redirect:/events/" + eventId;

	}
	
	
	// comes here from the edit link in the tables on the show events or index page
	// and renders the edit event page
	@RequestMapping("/{id}/edit")
	public String editOneEvent(HttpSession session, RedirectAttributes redirectAttributes, @PathVariable("id") Long eventId, Model model) {
		// First, check if the user is properly logged in (i.e. if there is an id in
		// session)
		// If there isn't...
		Long loggedInUserId = (Long)session.getAttribute("userId");
		Event thisEvent = apiService.findThisEvent(eventId);
		
		if(session.getAttribute("userId") == null) {
			//Send them back 
			redirectAttributes.addFlashAttribute("preLogin", "try again");
			return "redirect:/";
		}
		Long hostId = (Long)thisEvent.getHost().getId();
		
		if (thisEvent == null || !hostId.equals(loggedInUserId)) {
			return "redirect:/events";
		}
		System.out.println("logged in wants to edit:  " + eventId);

		// But if there is an id in session...
		// For this page we'll need the event in our model...
		// Event thisEvent = apiService.findThisEvent(eventId);
		User loggedInUser = apiService.findUserById(loggedInUserId);
		//..add to model
		model.addAttribute("user", loggedInUser);
		
		model.addAttribute("event", thisEvent);
		model.addAttribute("userId", loggedInUserId);

		return "events/editEvent.jsp";
	}
	
	///////////needs to be more restful
	// updates event
	@PostMapping("/updateEvent")
	public String updateEvent(@ModelAttribute("event") Event event, BindingResult result, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			redirectAttributes.addFlashAttribute("eventError", "Event could not be updated");
			return "redirect:/events";
		}
			
		System.out.println("event name is:  " + event.getName());
		System.out.println("event date is:  " + event.getEventDate()); // comes back as null for some reason
		
		apiService.createOrUpdateEvent(event);
		return "redirect:/events/"+event.getId();	
	}
	
	///update event...more restful version
	@PutMapping("/{id}")
	public String updateEventRestful(@Valid @ModelAttribute("event")  Event event,  BindingResult result, RedirectAttributes redirectAttributes, HttpSession session, Model model) {
		System.out.println("beginning of updateEventRestful");
		if (result.hasErrors()) {
			System.out.println("we are in error block");
			System.out.println("all errors " + result.getAllErrors().toString());
			redirectAttributes.addFlashAttribute("eventError", "Event could not be updated");
			return "redirect:/events";
		}
		
		apiService.createOrUpdateEvent(event);
		System.out.println("should have updated");
		return "redirect:/events/"+event.getId();
	}
	
	
	
	
	
	//cancel entire event
//	@PostMapping("/delete/{id}")
//	public String deleteEvent(@PathVariable("id") Long eventId) {
//		System.out.println("am here to cancel event");
//		apiService.deleteThisEvent(eventId);
//		return "redirect:/events/";
//	}
	//cancel event redone below to be more restful
	@DeleteMapping("/{id}") //all we need because the delete method makes it unique...do delete event with this id
	public String deleteEvent(@PathVariable("id") Long eventId) {
		apiService.deleteThisEvent(eventId);
		return "redirect:/events";
	}
	
	
	// comes here from a link in table of index or show events page and allows
	// logged in person to join event
	//trying to be more restful, so:
		//add user to course[event]...POST which comes from all courses page...looks like a link...per Jason courses/{courseId}/users[events/eventID/users
		//in that project did not pass in user id because it is the loggedInUser
		//@PostMapping("/{id}/users")
	
	
	// was @RequestMapping("/{id}/join")
	@PostMapping("/{id}/users")
	public String joinEvent(@PathVariable("id") Long eventId, HttpSession session) {
		System.out.println("here is event idx: " + eventId);
		Long userId = (Long) session.getAttribute("userId");
		System.out.println("here is the userId: " + userId);
		apiService.joinThisEvent(eventId, userId);
		return "redirect:/events";
	}
	
	////////needs to be more restful
	// comes here from a link in table of index or show events page and allows
	// logged in person to join event
	@RequestMapping("/{id}/cancel")
	public String cancelAttendance(@PathVariable("id") Long eventId, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		apiService.removeFromEvent(eventId, userId);
		return "redirect:/events";
	}
	
	//redoing Unjoin/cancel to be more restful...removes user from event
	@DeleteMapping("/{id}/users")
	public String removeUserFromEvent(@PathVariable("id") Long eventId, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		apiService.removeFromEvent(eventId, userId);
		return "redirect:/events";
	}
	
	
	
	
	
	
	
}
