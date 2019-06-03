
public class FizzBuzz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int testNum = 5;

		System.out.println(fizzbuzz(testNum));

	}

	public static String fizzbuzz(int number) {
		String result = "";
		if (number % 3 == 0 && number % 5 == 0) {
			result = "FizzBuzz";
		} else if (number % 3 == 0) {
			result = "Buzz";
		} else if (number % 5 == 0) {
			result = "Fizz";
		} else {
			result = String.valueOf(number);
		}

		return result;
	}

}
