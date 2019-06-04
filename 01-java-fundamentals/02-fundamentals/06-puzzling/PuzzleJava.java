
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class PuzzleJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> result = PuzzleJava.arraySumGreater();
		String str = Arrays.toString(result.toArray());
		System.out.println("filtered string is;  " + str);
		System.out.println("end arraySumGreater\n\n");

		ArrayList<String> strLong = PuzzleJava.arrayStrings();
		System.out.println("longer names are:  " + strLong);
		System.out.println("end arrayStrings\n\n");

		PuzzleJava.shuffleAlphabet();
		System.out.println("\nEnd ShuffleAlpha\n\n");

		ArrayList<Integer> result2 = PuzzleJava.generate10Random();
		String str2 = Arrays.toString(result2.toArray());
		System.out.println("Random numbers are:  " + str2);
		System.out.println("\nEnd generate10Random");

		ArrayList<Integer> result3 = PuzzleJava.generate10RandomSort();
		String str3 = Arrays.toString(result3.toArray());
		System.out.println("Random sorted numbers are:  " + str3);
		System.out.println("\nEnd generate10RandomSort");

		System.out.println("begin random5CharString");
		PuzzleJava.random5CharString();
		System.out.println("\nEnd random5CharString");
		
		System.out.println("begin tenRandom5CharString");
		PuzzleJava.tenRandom5CharString();
		System.out.println("\nEnd tenRandom5CharString");
		
		
		

	} // end main method

	static ArrayList arraySumGreater() {
		int a[] = { 3, 5, 1, 2, 7, 9, 8, 13, 25, 32 };
		int numThreshold = 10;
		int countGreater = 0;
		int sumArray = 0;
		ArrayList<Integer> arrayGreater = new ArrayList<Integer>();
		for (int i = 0; i < a.length; i++) {
			sumArray += a[i];
			if (a[i] > numThreshold) {
				arrayGreater.add(a[i]);
			}
		}
		System.out.println("Sum of numbers in array is: " + sumArray);
		return arrayGreater;
	}

	static ArrayList arrayStrings() {
		ArrayList<String> greaterThan5 = new ArrayList<String>();
		String a[] = { "Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa" };
		ArrayList<String> inputArray = new ArrayList<String>(Arrays.asList(a));
		System.out.println("names before shuffling:  " + Arrays.toString(inputArray.toArray()));
		Collections.shuffle(inputArray);
		System.out.println("names after shuffling:  " + Arrays.toString(inputArray.toArray()));
		for (int i = 0; i < inputArray.size(); i++) {
			if (inputArray.get(i).length() > 5) {
				greaterThan5.add(inputArray.get(i));
			}
		}
		return greaterThan5;
	}

	static void shuffleAlphabet() {
		String[] alphabet = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
				"s", "t", "u", "v", "w", "x", "y", "z" };
		ArrayList<String> inputArray = new ArrayList<String>(Arrays.asList(alphabet));
		System.out.println("Alphabet before shuffling:  " + Arrays.toString(inputArray.toArray()));
		Collections.shuffle(inputArray);
		System.out.println("Alphabet after shuffling:  " + Arrays.toString(inputArray.toArray()));
		String lastLetter = inputArray.get(inputArray.size() - 1);
		System.out.println("last letter of shuffled array is:  " + lastLetter);
		String[] vowelArray = { "a", "e", "i", "o", "u" };
		ArrayList<String> vowelList = new ArrayList<String>(Arrays.asList(vowelArray));
		String firstLetter = inputArray.get(0);
		System.out.print("first letter of shuffled array is:  " + firstLetter);
		if (vowelList.contains(firstLetter)) {
			System.out.println(" which is a vowel");
		}
	}

	static ArrayList generate10Random() {
		ArrayList<Integer> randomNums = new ArrayList<Integer>();
		for (int i = 0; i <= 10; i++) {
			Random r = new Random();
			int result = r.nextInt(45) + 55;
			randomNums.add(result);
		}
		return randomNums;
	}

	static ArrayList generate10RandomSort() {
		ArrayList<Integer> randomNums = new ArrayList<Integer>();
		for (int i = 0; i <= 10; i++) {
			Random r = new Random();
			int result = r.nextInt(45) + 55;
			randomNums.add(result);
		}
		Collections.shuffle(randomNums);
		System.out.println("minimum is:  " + randomNums.get(0));
		System.out.println("maximum value is:  " + randomNums.get(randomNums.size() - 1));
		return randomNums;

	}

	static String random5CharString() {
		String[] alphabet = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
				"s", "t", "u", "v", "w", "x", "y", "z" };
		String randomString = "";
		for (int i = 0; i <= 5; i++) {
			Random r = new Random();
			int index = r.nextInt(26);
			randomString += (alphabet[index]);
		}
		System.out.println("Random String is:  " + randomString);
		return randomString;
	}

	static void tenRandom5CharString() {
		String ArrrayOfStrings[] = new String[10];
		for (int i = 0; i < 10; i++) {
			ArrrayOfStrings[i] = PuzzleJava.random5CharString();
		}
		System.out.println(Arrays.toString(ArrrayOfStrings));
	}

} // end class PuzzleJava
