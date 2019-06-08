package com.codingdojo.web.models;

public class Animal {
	protected String name;
	protected String breed;
	protected int weight;
	
	public Animal() {
		this.name ="fakename";
		this.breed = "fakebreed";
		this.weight = 1000;
	}
	
	public Animal(String inName, String inBreed, int inWeight) {
		this.name = inName;
		this.breed = inBreed;
		this.weight = inWeight;
	}
	
	
	
	

} // end Animal class
