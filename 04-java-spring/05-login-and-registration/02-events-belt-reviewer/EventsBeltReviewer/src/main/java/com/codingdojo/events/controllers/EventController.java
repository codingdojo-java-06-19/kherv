package com.codingdojo.events.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	// should arrive here from the login route/page and render the showEvents page
	// which is like an index page
	@RequestMapping("")
	public String showDashboard(@ModelAttribute("event") Event event, HttpSession session,
			RedirectAttributes redirectAttributes, Model model) {
		// First, check if the user is properly logged in (i.e. if there is an id in
		// session)
		// If there isn't...
		if (session.getAttribute("userId") == null) {
			// Send them back to the login/reg page with a warning.
			redirectAttributes.addFlashAttribute("preLogIn", "Please log in in order to access the events page.");
			return "redirect:/";
		}
		// But if there is an id in session...
		Long userId = (Long) session.getAttribute("userId");
		// Find the user...
		User loggedInUser = apiService.findUserById(userId);
		// ...and add them to the model.
		model.addAttribute("user", loggedInUser);

		// Grab all of the events that match the users' state and add them to the
		// model...
		List<Event> eventsInState = apiService.eventsInYourState(userId);
		model.addAttribute("eventsInState", eventsInState);

		// ...as well as all of the events not in the users' state
		List<Event> eventsNotInState = apiService.eventsNotInYourState(userId);
		model.addAttribute("eventsNotInState", eventsNotInState);
		// print all the in state events
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
	public String addEvent(@ModelAttribute("event") Event event, BindingResult result,
			RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			redirectAttributes.addFlashAttribute("eventError", "Event could not be created. Please try again.");
			return "redirect:/events/";
		}
		apiService.createOrUpdateEvent(event);
		redirectAttributes.addFlashAttribute("eventSuccess", "You've successfully added an event!");
		return "redirect:/events/";
	}

	// if successful will render the page that shows details for an event
	@RequestMapping("/{id}")
	public String showOneEvent(HttpSession session, RedirectAttributes redirectAttributes,
			@PathVariable("id") Long eventId, Model model) {
		System.out.println("here>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		// First, check if the user is properly logged in (i.e. if there is an id in
		// session)
		// If there isn't...
		if (session.getAttribute("userId") == null) {
			// Send them back to the login/reg page with a warning.
			redirectAttributes.addFlashAttribute("preLogIn", "Please log in in order to access the events page.");
			return "redirect:/";
		}
		// But if there is an id in session...
		// For this page we'll need the event in our model...
		Event thisEvent = apiService.findThisEvent(eventId);
		model.addAttribute("event", thisEvent);

		// ...along with the info about our logged in user....
		Long userId = (Long) session.getAttribute("userId");
		User loggedInUser = apiService.findUserById(userId);
		model.addAttribute("loggedInUser", loggedInUser);

		// We'll also need to view all of the messages that have been added to this
		// event
		List<Message> messages = apiService.findMessagesForThisEvent(eventId);
		model.addAttribute("messages", messages);

		return "events/showEvent.jsp";
	}

	// Creates New Message comes here from the add message form at the bottom of the
	// show event page
	@PostMapping("/newMessage/{id}")
	public String newMessage(@PathVariable("id") Long eventId, @RequestParam("author") Long authorId,
			@RequestParam("content") String content) {
		apiService.createMessage(content, authorId, eventId);
		return "redirect:/events/" + eventId;
	}

	// comes here from the edit link in the tables on the show events or index page
	// and renders the edit event page
	@RequestMapping("/{id}/edit")
	public String editOneEvent(HttpSession session, RedirectAttributes redirectAttributes,
			@PathVariable("id") Long eventId, Model model) {
		// First, check if the user is properly logged in (i.e. if there is an id in
		// session)
		// If there isn't...
		Long userId = (Long)session.getAttribute("userId");
		Event thisEvent = apiService.findThisEvent(eventId);

		if (session.getAttribute("userId") == null) {
			// Send them back to the login/reg page with a warning.
			redirectAttributes.addFlashAttribute("preLogIn", "Please log in in order to access the events page.");
			return "redirect:/";
		}
		Long hostId = (Long)thisEvent.getHost().getId();
		
		if (thisEvent == null || !hostId.equals(userId)) {
			return "redirect:/events/";
		}
		System.out.println("logged in wants to edit:  " + eventId);

		// But if there is an id in session...
		// For this page we'll need the event in our model...
		// Event thisEvent = apiService.findThisEvent(eventId);
		model.addAttribute("event", thisEvent);

		return "events/editEvent.jsp";
	}
	// comes here from the edit form on the show event page
//	@PutMapping("/{id}")
//	public String Update(@Valid @ModelAttribute("event") Event event, BindingResult result, @PathVariable("id") Long id, HttpSession session, Model model) {
//		System.out.println("trying to update event " + id);
//		if(result.hasErrors()) {
//			//redirectAttributes.addFlashAttribute("eventError", "Event could not be updated. Please try again.");
//			return "redirect:/events/";
//		}
//		apiService.createOrUpdateEvent(event);
//		return "redirect:/events"+event.getId();
//	}

	// updates event
	@PostMapping("/updateEvent")
	public String updateEvent(@ModelAttribute("event") Event event, BindingResult result,
			RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			redirectAttributes.addFlashAttribute("eventError", "Event could not be updated. Please try again.");
			return "redirect:/events/";
		}

		System.out.println("event name is:  " + event.getName());
		System.out.println("event date is:  " + event.getEventDate()); // comes back as null for some reason

		apiService.createOrUpdateEvent(event);
		return "redirect:/events/" + event.getId();
	}

	// cancel entire event
	@PostMapping("/delete/{id}")
	public String deleteEvent(@PathVariable("id") Long eventId) {
		System.out.println("am here to cancel event");
		apiService.deleteThisEvent(eventId);
		return "redirect:/events/";
	}

	// comes here from a link in table of index or show events page and allows
	// logged in person to join event
	@RequestMapping("/{id}/join")
	public String joinEvent(@PathVariable("id") Long eventId, HttpSession session) {
		System.out.println("here is event id:  " + eventId);
		Long userId = (Long) session.getAttribute("userId");
		apiService.joinThisEvent(eventId, userId);
		return "redirect:/events/";
	}

	// comes here from a link in table of index or show events page and allows
	// logged in person to join event
	@RequestMapping("/{id}/cancel")
	public String cancelAttendance(@PathVariable("id") Long eventId, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		apiService.removeFromEvent(eventId, userId);
		return "redirect:/events/";
	}

}
