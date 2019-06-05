package com.codingdojo.kent.phone;

public class Galaxy extends Phone implements Ringable {

	public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
		super(versionNumber, batteryPercentage, carrier, ringTone); // calls constructor in Phone which has those four
																	// parameters

	}

	public String ring() {
		return "Galaxy " + this.versionNumber + " says " + ringTone;
	}

	public String unlock() {
		return "unlocking via fingerprint";
	}

	public void displayInfo() {
		System.out.println("Galaxy" + this.versionNumber + "from" + this.carrier);

	}

}

// overriden methods (ring, unlock, displayInfo) from the IPhone and Galaxy
