package com.codingdojo.authentication.models;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;



@Entity
@Table(name = "users_events") //could be called attenders because this table tracks attenders by name and event
public class trashUserEvent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	
	//look back to Users  this connects teh 
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id") //this field in this table points back to users...a foreign key
	private User user;
	
	
	//look back to Events
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "event_id")  //this field in this table points back to events...a foreign key
	
	
	
	
	
	
	
	
	


	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
	

}
