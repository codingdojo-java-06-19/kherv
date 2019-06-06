package com.codingdojo.kent.CalcII;

/**
 * 
 */

public class Calculator {

	// private double operandOne;
	private String operation;
	// private double operandTwo;
	private double results;
	private double theOperand;

	public Calculator() {
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
