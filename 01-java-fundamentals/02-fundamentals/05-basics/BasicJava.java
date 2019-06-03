import java.util.ArrayList; 
import java.util.Arrays;
public class BasicJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Do Print 1-255
		BasicJava.allTo255();
		
		//Do Odd 1-255
		BasicJava.oddTo255();
		
		//Do Sum 1-255
		BasicJava.sumTo255();
		
		//Do Iterating an array
		int a[]={1,3,5,7,9,13};
		BasicJava.printArray(a);
		
		// Do Find Max
		int b[]={-3, -5, -7};
		BasicJava.findMax(b);
		

		// Do Find Average
		int c[]={2, 10, 3};
		BasicJava.findAverage(c);
		
		// Do arrayOdds
		BasicJava.ArrayWithOdds();
		
		//Do greaterThanY
		int y =3;
		int d[] = {1, 3, 5, 7};
		BasicJava.greaterThanY(d, y);
		
		//Do squareTheValues
		int e[] = {1, 5, 10, -2};
		BasicJava.squareTheValues(e);
		
		//Do eliminateNegativeNumbers
		int f[] = {1, 5, 10, -2};
		BasicJava.eliminateNegativeNumbers(f);
		
		//Do minMaxAverage
		int g[] = {1, 5, 10, -2};
		int z[] = BasicJava.minMaxAverage(g);
		System.out.println(Arrays.toString(z));
		System.out.println("\nEnding output for minMaxAverage");
		
		//Do shiftValuesArray
		int h[] = {1, 5, 10, -2};
		int w[] = BasicJava.shiftValuesArray(h);
		System.out.println(Arrays.toString(w));
		System.out.println("\nEnding output for shiftValuesArray");
		
		
		
		
	} // end main method
		
		
		
	public static void allTo255() {
		System.out.println("Starting output for allto255");
		for (int i=1; i<=255; i++) {
			System.out.println(i);
		}
		System.out.println("Ending output for allto255\n");
	}
	
	
	public static void oddTo255() {
		System.out.println("Starting output for oddTo255");
		for (int i=1; i<=255; i++) {
			if (i%2!=0) { //i is odd
				System.out.println(i);		
			}
		}
		System.out.println("Ending output for oddTo255\n");
	}
	
	public static void sumTo255() {
		System.out.println("Starting output for sumTo255");
		int sumAll;
		sumAll = 0;
		for (int i=1; i<=255; i++) {
			sumAll += i;
			System.out.println("New number: : " + i + " Sum: " + sumAll);
		}
		System.out.println("Ending output for sumTo255\n");
	}
	
	private static void printArray (int [] a) {
		System.out.println("Starting output for printArray");
		for (int i=0; i <a.length; i++) {
			System.out.print(a[i] + ", ");
		}
		System.out.println("Ending output for printArray\n");
	}
	
	private static void findMax (int [] inArray) {
		System.out.println("Starting output for findMax");
		int arrMax = inArray[0]; 
		for (int i=1; i <inArray.length; i++) {
			if(arrMax < inArray[i]) {
				arrMax = inArray[i];
			}
		}
		System.out.println("max value in array is:  " + arrMax);
		System.out.println("Ending output for findMax\n");
	}
	
	private static void findAverage (int [] inArray) {
		System.out.println("Starting output for findAverage");
		int sumAll;
		sumAll = 0;
		for (int i=0; i <inArray.length; i++) {
			sumAll += inArray[i];
		}
		System.out.println("average is:  " + sumAll/inArray.length);
		System.out.println("Ending output for findAverage\n");
	}
	
	private static void ArrayWithOdds() {
		System.out.println("Starting output for ArrayWithOdds");
		ArrayList<Integer> y = new ArrayList<Integer>();
		for (int i=1; i<=255; i++) {
			if (i%2!=0) { //i is odd
				y.add(i);		
			}
		}
		System.out.println(y);
		System.out.println("Ending output for ArrayWithOdds\n");
	}
	
	
	static void greaterThanY(int [] inArray, int numThreshold) {
		System.out.println("Starting output for greaterThanY");
		int countGreater =0;
		for(int i=0; i<inArray.length; i++) {
			if (inArray[i]>numThreshold) {
				countGreater++;
			}
		}
		System.out.println("Number of array values greater than threshold is: " + countGreater);
		
		System.out.println("Ending output for greaterThanY");
	}
	
	
	static void squareTheValues(int [] inArray ) {
		System.out.println("Starting output for squareTheValues");
		for(int i =0; i<inArray.length; i++) {
			inArray[i] *= inArray[i];
			System.out.print(inArray[i] + " ");
		}
		System.out.println("\nEnding output for squareTheValues");
	}
	

	
	static void eliminateNegativeNumbers(int [] inArray ) {
		System.out.println("Starting output for eliminateNegativeNumbers");
		for(int i =0; i<inArray.length; i++) {
			if(inArray[i]<0) {
				inArray[i] = 0;
			}
		System.out.print(inArray[i] + " ");
		}
		System.out.println("\nEnding output for eliminateNegativeNumbers");
	}
	
	
	
	static int[] minMaxAverage(int [] inArray) {
		System.out.println("Starting output for minMaxAverage");
		int sum =0;
		int min =inArray[0];
		int max = inArray[0];
		for(int i=0; i<inArray.length; i++) {
			sum += inArray[i];
			if (inArray[i] >max) {
				max =inArray[i]; 
			}
			if (inArray[i]<min ) {
				min =inArray[i];
			}
		}
		int x[] ={max, min, sum/inArray.length};
		return x;
	}
	
	static int[] shiftValuesArray(int [] inArray) {
		for(int i=0; i<inArray.length-1; i++) {
			inArray[i]=inArray[i+1];
		}
		inArray[inArray.length-1]=0;
		return inArray;
	}
	
	
	

} // end BasicJava class
