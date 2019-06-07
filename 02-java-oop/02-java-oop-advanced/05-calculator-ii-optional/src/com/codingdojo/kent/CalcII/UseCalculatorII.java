package com.codingdojo.kent.CalcII;
/**
 * 
 */


public class UseCalculatorII implements java.io.Serializable {

	public static void main(String[] args) {
		CalculatorII firstCalc = new CalculatorII();

		firstCalc.performOperationII(10.5);
		
		firstCalc.performOperationII("+");
		
		firstCalc.performOperationII(5.2);

		firstCalc.performOperationII("*");

		firstCalc.performOperationII(10);
		

		firstCalc.performOperationII("=");
		


		firstCalc.getResults();
		
		




	} // end main

} // end class
