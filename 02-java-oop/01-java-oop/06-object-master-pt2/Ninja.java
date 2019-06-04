package com.codingdojo.kent.objmaster2;

public class Ninja extends Human {

	public Ninja() {
		this.stealth =10;
	}

	public void steal(Human otherPerson ) {
		otherPerson.health -=this.stealth;
		this.health +=this.stealth;
		
	}
	
	public void runAway() {
		this.health -=10;
	}
	
	
	
} // end class
