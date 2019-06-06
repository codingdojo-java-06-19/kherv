package com.codingdojo.kent.CalcII;
/**
 * 
 */


public class UseCalculator implements java.io.Serializable {

	public static void main(String[] args) {
		Calculator firstCalc = new Calculator();

		firstCalc.performOperation(10.5);

		firstCalc.performOperation("+");

		firstCalc.performOperation(5.2);

		firstCalc.performOperation("*");

		firstCalc.performOperation(10);

		// firstCalc.performOperation("=")

		firstCalc.getResults();
		
		


		firstCalc.getResults();

	}

}
