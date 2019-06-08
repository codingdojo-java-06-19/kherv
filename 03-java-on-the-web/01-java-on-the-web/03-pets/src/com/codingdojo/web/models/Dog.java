package com.codingdojo.web.models;

public class Dog extends Animal implements Pet {
	
	public Dog() {
		super();
	}

	public Dog (String inName, String inBreed, int inWeight) {
		super(inName, inBreed, inWeight);
	}
	
	
	public String showAffection() { 
		if(this.weight >30) {
			return this.name +  " curled up with you!";
		}
		return this.name + " hopped into your lap and cuddled with you.";

	}
	
} // end class
