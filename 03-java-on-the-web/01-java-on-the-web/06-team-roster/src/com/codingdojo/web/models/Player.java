package com.codingdojo.web.models;



public class Player {
	private String firstName;
	private String lastName;
	private int age;
	//This will keep track of all the players created. This is "Static" so that all instances have access to the same information (rather than specific for this instance)
	private static int playerCount=0;
	private int id;
	
	//This method is for taking in variables and creating a new Player with those variables
	public Player(String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		//As we increment players, each new player created will have a default value (which is id) of that number.
		//i.e. the first player created will have an id of 0, 2nd will have an id of 1...etc
		id = playerCount++;
	}
	
	public int getid() {
		return this.id;
	}

	public String getFirstName() {
		return this.firstName;
	}
	
	public void setFirstName(String name) {
		this.firstName = name;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setLastName(String name) {
		this.lastName = name;
	}
	
	public Integer getAge() {
		return this.age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
}

