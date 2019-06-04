public class SinglyLinkedList {
	public Node head;

	public SinglyLinkedList() {
		this.head = null;

		// your code here
	}

	// SLL methods go here. As a starter, we will show you how to add a node to the
	// list.
	public SinglyLinkedList add(int value) {
		Node newNode = new Node(value);
		if (head == null) {
			head = newNode;
		} else {
			Node runner = head;
			while (runner.next != null) {
				runner = runner.next;
			}
			runner.next = newNode;
		}
		return this;

	}

	public void remove() {
		if (head == null) {
			System.out.println("there is no list");
		} else if (head.next == null) {
			// does our head have a next
			head = null;
		} else {
			Node runner = head;
			while (runner.next.next != null) {
				runner = runner.next;
			}
			System.out.println("Removing the node with value of:  " + runner.next.value);
			runner.next = null;
		}
	}

	public void printValues() {
		System.out.println("beginning to print list values");
		Node runner = head;
		while(runner!=null) {
			System.out.println("The value of this node is:  " + runner.value);
			runner = runner.next;
		}
		
	}

} // end class
