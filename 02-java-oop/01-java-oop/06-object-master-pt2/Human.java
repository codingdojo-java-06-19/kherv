package com.codingdojo.kent.objmaster2;

public class Human {
	protected int strength;
	protected int stealth;
	protected int intelligence;
	protected int health;

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
