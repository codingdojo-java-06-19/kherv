/**
 * 
 */
package com.codingdojo.kent.calcI;

public class Calculator {

	private double operandOne;
	private String operation;
	private double operandTwo;
	private double results;

	public Calculator() {
		this.results = -55.2;

	}

	public void setOperandOne(double inOper1) {
		this.operandOne = inOper1;
	}

	public void setOperation(String inOperation) {
		this.operation = inOperation;
	}

	public void setOperandTwo(double inOper2) {
		this.operandTwo = inOper2;
	}

	public void performOperation() {
		if (this.operation == "+") {
			this.results = this.operandOne + this.operandTwo;
		}
		else if (this.operation == "-") {
			this.results = this.operandOne - this.operandTwo;
		}
	}

	public void getResults() {
		System.out.println("Result is:  " + this.results);
	}

}
