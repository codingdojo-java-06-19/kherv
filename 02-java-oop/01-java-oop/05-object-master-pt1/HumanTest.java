package com.codingdojo.kent.objmaster1;

public class HumanTest {

	public static void main(String[] args) {
		Human fred = new Human();
		Human joe = new Human();

		fred.displayStatus();

		fred.attack(joe);

		fred.displayStatus();

		joe.displayStatus();

	}

}
