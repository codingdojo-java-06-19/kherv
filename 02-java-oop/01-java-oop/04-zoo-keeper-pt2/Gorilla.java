package com.codingdojo.kent.zoo2;

public class Gorilla extends Mammal {

	public Gorilla() {
		// TODO Auto-generated constructor stub
	}

	public void throwSomething() {
		System.out.println("something was thrown");
		energyLevel -= 5;

	}

	public void eatBananas() {
		System.out.println("That banana was good");
		energyLevel += 10;
	}

	public void climb() {
		System.out.println("Gorilla climed a tree");
		energyLevel -= 10;

	}

}
