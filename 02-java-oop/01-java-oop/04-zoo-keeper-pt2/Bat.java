package com.codingdojo.kent.zoo2;

public class Bat extends Mammal {

	public Bat() {
		// TODO Auto-generated constructor stub
		this.energyLevel = 300;
	}

	public void fly() {
		System.out.println("sound of bat taking off");
		energyLevel -= 50;

	}

	public void eatHumans() {
		energyLevel += 25;

	}

	public void attackTown() {
		System.out.println("sound of town on fire");
		energyLevel -= 100;

	}

}
