package com.codingdojo.web.models;
// this is a model
public class Person {
	private String name;
	private int age;
	
	public Person() {
		
	}
	public Person (String name, int age) {
		this.name = name;
		this.age = age;
	}
	 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String greeting() {
		return "Hello! My name is " + name + ", and I am " + age + " years old.";
	}
	
} // end of class
