package com.codingdojo.kent.phone;

public class IPhone extends Phone implements Ringable {

	public IPhone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
		super(versionNumber, batteryPercentage, carrier, ringTone);
	}

	public String ring() {
		return "iPhone " + this.versionNumber + " says " + ringTone;
	}

	public String unlock() {
		return "unlocking via facial recognition";
	}

	public void displayInfo() {
		System.out.println("IPhone" + this.versionNumber + "from" + this.carrier);
	}

}

// overriden methods (ring, unlock, displayInfo) from the IPhone and Galaxy
