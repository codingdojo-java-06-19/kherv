package com.codingdojo.kent.objmaster2;

public class HumanTest {

	public static void main(String[] args) {
		Ninja fred = new Ninja();
		Wizard joe = new Wizard();
		
		Samurai a = new Samurai();
		Samurai b = new Samurai();
		

		fred.displayStatus();

		fred.attack(joe);

		fred.displayStatus();

		joe.displayStatus();
		
		joe.heal(fred);
		
		joe.fireball(fred);
		
		fred.steal(joe);
		fred.runAway();
		
		a.deathBlow(fred);
		b.meditate();
		
		System.out.println("number of Samurai is:  " +Samurai.howMany());
		
		

	}

}
