public class ListTester {
	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();
		sll.add(3).add(4).add(10).add(5).add(15).add(2);
		
		sll.printValues();
		
		sll.remove();
		sll.printValues();
		
		sll.remove();
		
		sll.printValues();

	}
}