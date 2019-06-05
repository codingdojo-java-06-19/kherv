package com.codingdojo.kent.phone;

public class PhoneTester {

	public static void main(String[] args) {
		Galaxy s9 = new Galaxy("S9", 99, "Verizon", "Ring, Ring, Ring!"); // uses the type Galaxy from class Galaxy
																			// whose constructor is looking for version
																			// number, batterypercentage, carrier, and
																			// ringtone
		IPhone iphoneTen = new IPhone("X", 100, "AT&T", "Zing");

		s9.displayInfo();
		System.out.println(s9.ring());
		System.out.println(s9.unlock());

		iphoneTen.displayInfo();
		System.out.println(iphoneTen.ring());
		System.out.println(iphoneTen.unlock());

	}

}
