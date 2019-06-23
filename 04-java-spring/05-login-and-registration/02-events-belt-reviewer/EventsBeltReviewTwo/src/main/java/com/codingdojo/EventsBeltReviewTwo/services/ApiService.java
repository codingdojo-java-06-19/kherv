package com.codingdojo.EventsBeltReviewTwo.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.codingdojo.EventsBeltReviewTwo.models.Event;
import com.codingdojo.EventsBeltReviewTwo.models.Message;
import com.codingdojo.EventsBeltReviewTwo.models.User;
import com.codingdojo.EventsBeltReviewTwo.repositories.EventRepository;
import com.codingdojo.EventsBeltReviewTwo.repositories.MessageRepository;
import com.codingdojo.EventsBeltReviewTwo.repositories.UserRepository;

@Service
public class ApiService {
	private final UserRepository userRepo;
	private final EventRepository eventRepo;
	private final MessageRepository messageRepo;
	
	//ApiService needs these three variables because it manages these repositories...the repository knows how to talk to database
	public ApiService(UserRepository userRepo, EventRepository eventRepo, MessageRepository messageRepo) {
		this.userRepo = userRepo;
		this.eventRepo = eventRepo;
		this.messageRepo = messageRepo;
	}
	
	//// Register
	public User registrationUser(User user) {
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashed);
		return userRepo.save(user);
	}
	
	//find user by email
	public User findByEmail(String email) {
		return userRepo.findByEmail(email);
	}
	
	// find user by id
	public User findUserById(Long id) {
		Optional<User> u = userRepo.findById(id);
		if(u.isPresent()) {
			return u.get();
		}
		else {
			return null;
		}
	}
	
	// authenticate user
	public boolean authenticateUser(String email, String password) {
		User user = userRepo.findByEmail(email);
		
		if(user == null ) {
			return false;
		}
		else {
			if(BCrypt.checkpw(password, user.getPassword())) {
				return true;
			}
			else {
				return false;
			}
		}
	}
	
	//
	
	//Save to database
	public Event createOrUpdateEvent(Event event) {
		return eventRepo.save(event);
	}
	
	//Return state for user
	  public String thisUsersState(Long user_id) {
		  User thisUser = userRepo.findById(user_id).orElse(null); 
		  return thisUsersState(thisUser);
	  }
	
	  public String thisUsersState(User user) {
		  return user.getState();
	  }
	  
	//Return all Events from users state
	  public List<Event> eventsInYourState(Long user_id) {
		  String myState = thisUsersState(user_id);
		  return eventRepo.findByState(myState);
	  }
	
	//Return all Events Not from User state
	  public List<Event> eventsNotInYourState(Long user_id){
		  String myState = thisUsersState(user_id);
		  return eventRepo.findByStateIsNot(myState);
	  }
	
	//Find one Event by Id=select * from event databse where id=eventId....
	  public Event findThisEvent(Long eventId) {
		  Event thisEvent = eventRepo.findById(eventId).orElse(null);
		  return thisEvent;
	  }
	
	//Host cancels event
	  public void deleteThisEvent(Long eventId) {
		  Event thisEvent = findThisEvent(eventId);
		  eventRepo.delete(thisEvent);
	  }
	
	//member joins event
	  public void joinThisEvent(Long eventId, Long userId) {
		  Event thisEvent = findThisEvent(eventId);
		  User thisUser = userRepo.findById(eventId).orElse(null);
		  thisEvent.addMember(thisUser); //calling addMember on "thisEvent"
		  eventRepo.save(thisEvent);
	  }
	
	//somebody removed from event
	  public void removeFromEvent(Long eventId, long userId) {
		  Event thisEvent = findThisEvent(eventId);
		  User thisUser = userRepo.findById(userId).orElse(null);
		  thisEvent.getMembers().remove(thisUser);
		  eventRepo.save(thisEvent);
	  }
	
	/////////////////
	  public Message createMessage(String content, Long authorId, Long eventId) {
		  Event thisEvent = eventRepo.findById(eventId).orElse(null);
		  User author = userRepo.findById(authorId).orElse(null);
		  Message message = new Message(content, author, thisEvent);
		  return messageRepo.save(message);
	  }
	
	public List<Message> findMessagesForThisEvent(Long eventId){
		Event thisEvent = eventRepo.findById(eventId).orElse(null);
		return thisEvent.getMessages();
	}

}
