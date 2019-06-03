
public class StringManipulator {

	public String varInt = "abcd";

	public static void main(String args[]) {
		StringManipulator manipulator = new StringManipulator();
		String str = manipulator.trimAndConcat("    Hello     ", "     World    ");
		System.out.println(str);
		
		char letter = 'o';
		Integer a = manipulator.getIndexOrNull("Coding", letter);
		Integer b = manipulator.getIndexOrNull("Hello World", letter);
		Integer c = manipulator.getIndexOrNull("Hi", letter);
		System.out.println(a); // 1
		System.out.println(b); // 4
		System.out.println(c); // null
		
		String word = "Hello";
		String subString = "llo";
		String notSubString = "world";
		Integer aa = manipulator.getIndexOrNull(word, subString);
		Integer bb = manipulator.getIndexOrNull(word, notSubString);
		System.out.println(aa); // 2
		System.out.println(bb); // null
		
		
		StringManipulator manipulator2 = new StringManipulator();
		String word2 = manipulator2.concatSubstring("Hello", 1, 2, "world");
		System.out.println(word2);
		
	}

	public String trimAndConcat(String string1, String string2) {
		return (string1.trim() + string2.trim());
	}
	
	public Integer getIndexOrNull(String string1, char char1) {
		int result = string1.indexOf(char1);
		return result;
	}
	
	public Integer getIndexOrNull(String string1, String string2) {
		int result = string1.indexOf(string2);
		return result;
	}
	

	public String concatSubstring(String string1, int int1, int int2, String string2) {
		String result = string1.substring(int1, int2);
		result = result + string2;
		return result;
	}
	
	
	
}
