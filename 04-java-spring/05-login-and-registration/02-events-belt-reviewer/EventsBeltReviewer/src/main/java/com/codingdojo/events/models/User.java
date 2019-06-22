package com.codingdojo.events.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotEmpty
	private String firstName;
	private String lastName;
	@Email
	@NotEmpty
	private String email;
	private String city;
	private String state;
	@NotEmpty
	@Size(min=8)
	private String password;
	//@Transient
	private String passwordConfirmation;
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;

	public User() {
	}
	//this table, users, has three connections to other tables handled below


	//This one to Event many
	@OneToMany(mappedBy="host", fetch = FetchType.LAZY)
	private List<Event> eventsPlanned; //this is about the host/planner who is planning events we need to know what events he has planned

	//This one to Messages many  this accounts for many Messages for each user/author
	@OneToMany(mappedBy="author", fetch = FetchType.LAZY)
	private List<Message> messages;
	
	//This many to events many  this accounts for many users attending many events and many events having the same attender
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name="users_events", //could have been attenders table because that is what it does...each attender will have a record/row showing an id for it as a user and id for the event attending
		joinColumns = @JoinColumn (name = "user_id"),
		inverseJoinColumns = @JoinColumn(name = "event_id")
	)
	private List<Event> eventAttending;  //presumably the events being attended
	
	
	
	


public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Event> getEventsPlanned() {
		return eventsPlanned;
	}

	public void setEventsPlanned(List<Event> eventsPlanned) {
		this.eventsPlanned = eventsPlanned;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public List<Event> getEventAttending() {
		return eventAttending;
	}

	public void setEventAttending(List<Event> eventAttending) {
		this.eventAttending = eventAttending;
	}

@PrePersist
protected void onCreate() {
	this.createdAt = new Date();
}

@PreUpdate
protected void onUpdate() {
	this.updatedAt = new Date();
}



	
} // end users
