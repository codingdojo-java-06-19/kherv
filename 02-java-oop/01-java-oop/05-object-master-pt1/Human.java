package com.codingdojo.kent.objmaster1;

public class Human {
	private int strength;
	private int stealth;
	private int intelligence;
	private int health;

	public Human() {
		this.strength = 3;
		this.stealth = 3;
		this.intelligence = 3;
		this.health = 100;
	}

	public void attack(Human human) {
		human.health += this.health;
		this.health = 0;

	}

	public void displayStatus() {
		System.out.println("Strength:  " + this.strength + " Stealth:  " + this.stealth + " Intelligence:  "
				+ this.intelligence + " Health:  " + this.health);

	}

}
