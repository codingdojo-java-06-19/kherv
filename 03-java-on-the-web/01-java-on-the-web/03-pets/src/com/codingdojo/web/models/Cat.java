package com.codingdojo.web.models;

public class Cat extends Animal implements Pet {
	
	public Cat() {
		super();
	}

	public Cat (String inName, String inBreed, int inWeight) {
		super(inName, inBreed, inWeight);
	}
	
	
	public String showAffection() { 
		return "Your " + this.breed + " cat, " + this.name + ", looked at you with some affection. You think.";

	}
	
	
	

} // end Cat class
