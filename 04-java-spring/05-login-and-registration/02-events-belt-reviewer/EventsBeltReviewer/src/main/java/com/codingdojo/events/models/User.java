package com.codingdojo.events.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String fname;
	private String lname;
	private String email;
	private String location;
	private String state;
	private String hashpassword;
	
	//this table, users, has three connections to other tables handled below
	
	
	
	
	//This one to Event many
	
	
	//This one to Messages many
	
	
	//This many to Events many
	
	
	
	
	
	
	
	
} // end users
