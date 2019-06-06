package com.codingdojo.kent.CalcII;

/**
 * Needs more work to convert this calculator to an "order of operations" calculator given a list of operands and operators
 * 
 * Seems like the solution is to feed the nums and operators into a string or array...then search the array for the first *  or /  then operator using that operator with the preceding and following num...then replace that triplet of num operator num with the result...then repeat until no  or / left
Then repeat for + and - until the string or array is just one value

Alternate:  instead of replacing contents in the original array, use a second array
 */

public class CalculatorII {

	// private double operandOne;
	private String operation;
	// private double operandTwo;
	private double results;
	private double theOperand;

	public CalculatorII() {
		this.results = 0;

	}

	public void performOperation(double inValue) {
		this.theOperand = inValue;
	}

	public void performOperation(String inOp) {
		this.operation = inOp;
		if (this.operation == "+") {
			this.results = this.results + this.theOperand;
		} else if (this.operation == "-") {
			this.results = this.results - this.theOperand;
		} else if (this.operation == "*") {
			this.results = this.results * this.theOperand;
		} else if (this.operation == "/") {
			this.results = this.results / this.theOperand;
		}

	}

	public void getResults() {
		System.out.println("Result is:  " + this.results);
	}

}
