
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class ListException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Object> myList = new ArrayList<Object>();
		myList.add(Integer.parseInt("13"));
		myList.add("hello world");
		myList.add(48);
		myList.add("Goodbye World");

		for (int i = 0; i < myList.size(); i++) {
			try {
				Integer castedValue = (Integer) myList.get(i);
				System.out.println("The casted result is:  " + castedValue);
			}

			catch (ClassCastException e) {
				System.out.println(
						"The error is:  " + e.getMessage() + " and index of " + i + " with value of " + myList.get(i));

			} catch (Exception e) {
				System.out.println("Some other error occured");

			}

		}

		// String number = "10";
		// int result = Integer.parseInt(number);
		// System.out.println(result);

	}

}
