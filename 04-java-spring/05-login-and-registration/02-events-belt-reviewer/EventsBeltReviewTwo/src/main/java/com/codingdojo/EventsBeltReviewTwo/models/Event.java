package com.codingdojo.EventsBeltReviewTwo.models;

import java.text.SimpleDateFormat;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="events")
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Future
	@DateTimeFormat(pattern ="yyyy=MM=dd")
	private Date eventDate;
	@NotEmpty
	private String name;
	@NotEmpty
	private String city;
	private String state;
	
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	
	public Event() {
		
	}
	
	//This table, events, has connections to three other tables handled below
	
	//This one to many messages...accounts for each event having many messages
	@OneToMany(mappedBy="event", fetch = FetchType.LAZY)
	private List<Message> messages;
	
	//This many to one User...accounts for many Events planned by just one user/planner/host
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User host; //Over in the User table there is @OneToMany(mappedBy="host", fetch = FetchType.LAZY)
	
	
	//This many to users many....this accounts for many events having many attenders and many attenders having same attender
	//Accomplished through the join table:  users_events
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "users_events", // could have been attenders or members
		joinColumns = @JoinColumn (name = "event_id"),  //User has "user_id" here
		inverseJoinColumns = @JoinColumn (name = "user_id") //User has "event_id" here
		)
	private List<User> members;
	
	public void addMember(User user) {
		members.add(user);
	}
	
	public String formatEventDate() {
		Date date = this.eventDate;
		SimpleDateFormat format = new SimpleDateFormat("MMMM d, yyyy");
		String formattedDate = format.format(date);
		return formattedDate;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public User getHost() {
		return host;
	}

	public void setHost(User host) {
		this.host = host;
	}

	public List<User> getMembers() {
		return members;
	}

	public void setMembers(List<User> members) {
		this.members = members;
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
	

}
