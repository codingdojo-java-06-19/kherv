package com.codingdojo.kent.zoo1;

public class Mammal {
	protected int energyLevel;

	public Mammal() {
		this.energyLevel = 100;
	}

	public int displayEnergy() {
		System.out.println("Current Engergy is " + energyLevel);
		return energyLevel;
	}

}
