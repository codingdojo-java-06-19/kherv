package com.codingdojo.kent.objmaster2;

public class Wizard extends Human {

	public Wizard() {
		this.health = 50;
		this.intelligence = 8;
		
	}

	public void heal(Human otherPerson) {
		otherPerson.health += this.intelligence; 
		
		
		
	}
	
	public void fireball(Human otherPerson) {
		otherPerson.health -=this.intelligence *3;
		
	}
	
	
	
	
}
