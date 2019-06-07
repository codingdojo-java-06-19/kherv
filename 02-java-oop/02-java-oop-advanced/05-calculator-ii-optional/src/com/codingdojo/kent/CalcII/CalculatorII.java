package com.codingdojo.kent.CalcII;

import java.util.ArrayList;
import java.util.Arrays;

/**
See readme file

 */

public class CalculatorII {
	
	private static ArrayList<String> operandsAndOperators = new ArrayList<String>(); //Populated by user's input
	

	// private double operandOne;
	private String operation;
	// private double operandTwo;
	private double results;
	private double theOperand;
	private static String tempString;

	public CalculatorII() {
		this.results = 0;

	}
	
	public void performOperationII(int inValue) {
		double tempDouble = (double) inValue;
		performOperationII(tempDouble);
	}
	
	public void performOperationII(Double inOp) {
		String tempString = Double.toString(inOp); //confirmed works..next step is to push into ArrayList operandsAndOperators
		operandsAndOperators.add(tempString);
		//below is temp for dev
		tempString = Arrays.toString(operandsAndOperators.toArray());
		String getLast = operandsAndOperators.get(operandsAndOperators.size()-1);
		//String doNothing = ""; //needed to be able to see above in debug mode
	}
	
	public void performOperationII(String inOp) {
		if( inOp.equals("=")) {
			doTheMath();
			return;
		}
		operandsAndOperators.add(inOp);
	}

	
	public void doTheMath() {
		System.out.printf("this doTheMath method will make the calculations\n");
		//demonstrate iterating array looking back and forth at found operators
		//look for * and /
		for (int i=0; i<operandsAndOperators.size(); i++) {
			if(operandsAndOperators.get(i).equals("*") || operandsAndOperators.get(i).equals("/")) {
				System.out.printf("We found a match for %s at index of %d%n", operandsAndOperators.get(i), i);
				System.out.printf("So we need to operate on values and indices of  %d and %d.%n", i-1, i+1);
				//then put result in i-1, then delete i and i+1.
				double tempResult = Double.parseDouble(operandsAndOperators.get(i-1)) * Double.parseDouble(operandsAndOperators.get(i+1));
				//needs more work to handle division
				String tempResult2 = Double.toString(tempResult);
				operandsAndOperators.set((i-1), tempResult2);
				operandsAndOperators.remove(i);
				operandsAndOperators.remove(i);// repeat i again because what was i + 1 is now just i
			}
		//get did all the multiplication and got rid of the extra stuff
		}
		// Now let's do some adding...
		for (int i=0; i<operandsAndOperators.size(); i++) {
			if(operandsAndOperators.get(i).equals("+") || operandsAndOperators.get(i).equals("-")) {
				//put result in i-1, then delete i and i+1..
				double tempResult = Double.parseDouble(operandsAndOperators.get(i-1)) + Double.parseDouble(operandsAndOperators.get(i+1));
				//needs more work to do subtraction
				String tempResult2 = Double.toString(tempResult);
				operandsAndOperators.set((i-1), tempResult2);
				operandsAndOperators.remove(i);
				operandsAndOperators.remove(i);// repeat i again because what was i + 1 is now just i
			}
		
		}
		System.out.printf("%n%nThe answer is:  %s.", operandsAndOperators.get(0));
		
		
		
		
	}
	
	public void getResults() {
		System.out.println("Result is:  " + this.results);
	}

	public void printArray() {
		tempString = Arrays.toString(operandsAndOperators.toArray());
		System.out.printf("Printed array as string is: %s%n", tempString);
	}
	
	
	
	
} // end class
