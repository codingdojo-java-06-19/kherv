package com.codingdojo.kent.CalcII;
/**
 * 
 */


public class UseCalculatorII implements java.io.Serializable {

	public static void main(String[] args) {
		CalculatorII firstCalc = new CalculatorII();

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
