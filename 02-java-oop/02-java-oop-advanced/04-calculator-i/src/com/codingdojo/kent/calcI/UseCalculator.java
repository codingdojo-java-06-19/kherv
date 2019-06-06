/**
 * 
 */
package com.codingdojo.kent.calcI;

public class UseCalculator implements java.io.Serializable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Calculator firstCalc = new Calculator();

		firstCalc.setOperandOne(10.5);

		firstCalc.setOperation("+");

		firstCalc.setOperandTwo(5.2);

		firstCalc.performOperation();

		firstCalc.getResults();
		
		firstCalc.setOperation("-");
		
		firstCalc.performOperation();
		
		firstCalc.getResults();

	}

}
