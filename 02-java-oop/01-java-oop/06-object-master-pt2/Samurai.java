package com.codingdojo.kent.objmaster2;

public class Samurai extends Human {
	private static int  numSamurai =0;

	public Samurai() {
		this.health = 200;
		numSamurai +=1;
	}

	public void deathBlow(Human otherPerson) {
		this.health = this.health/2;
		otherPerson.health =0;
		
	}
	
	public void meditate() {
		this.health = 200;
	}
	
	public static int howMany() {
		return numSamurai;
	}
	
} // end of class
