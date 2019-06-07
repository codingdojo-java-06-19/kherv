package com.codingdojo.kent.dll;
public class DLLTest {
    public static void main(String[] args) {
        DLL dll = new DLL();
        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(50);
        Node n4 = new Node(60);
        Node n5 = new Node(80);
        Node n6 = new Node(100);
        
        dll.push(n1);
        dll.push(n2);
        dll.push(n3);
        dll.push(n4);
        dll.push(n5);
        dll.push(n6);
        
        
        System.out.printf("Printing Values Forward%n");
        dll.printValuesForward();
        
        System.out.printf("number of nodes is:  %d.%n", dll.size());
        
        System.out.printf("Does the list contain 100: %b.%n", dll.contains(100));
        
        
        System.out.printf("%nPrinting Values Backward%n");
        dll.printValuesBackward();
        
        System.out.printf("The last node was removed. It's value was %d.%n", dll.pop());

        System.out.printf("numbr of nodes is:  %d.%n", dll.size());
        
        System.out.printf("Does the list contain 100: %b.%n", dll.contains(100));
    }
}