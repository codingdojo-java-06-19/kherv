package com.codingdojo.EventsBeltReviewTwo.models;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;




@Entity
@Table(name = "users_events")

public class UserEvent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	
	//look back to Users  this connects teh 
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id") //a foreign key for users table
	private User user;
	
	//look back to Events
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "event_id") //a foreign key
	private Event event;
	
	public UserEvent() {
		
	}
	
	
	
}
