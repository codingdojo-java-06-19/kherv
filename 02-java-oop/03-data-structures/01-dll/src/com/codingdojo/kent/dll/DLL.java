package com.codingdojo.kent.dll;

public class DLL {
    public Node head;
    public Node tail;
    
    public DLL() {
        this.head = null;
        this.tail = null;
    }
    
    // the push method will add a new node to the end of the list
    public void push(Node newNode) {
        // if there is no head in the list, aka, an empty list, we set the newNode to be the head and tail of the list
        if(this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            return;
        }
        
        // first find the lastNode in the list
        // then, set the lastNode's next to be the newNode;
        // then, we have to set the previous of the lastNode to the lastNode that we found previously.
        // finally, set the list's tail to be the node that we have added
        Node lastNode = this.tail;
        lastNode.next = newNode;
        newNode.previous = lastNode;
        this.tail = newNode;
    }
    
    public void printValuesForward() {
        // find the first node, aka head.
        Node current = this.head;
        
        // while the current node exists...copy
        while(current != null) {
            // print it's value
            System.out.println(current.value);
            // and move on to it's next node.
            current = current.next;
        }
    }
    
    public void printValuesBackward() {
        // find the first node, aka head.
        Node current = this.tail;
        
        // while the current node exists...copy
        while(current != null) {
            // print it's value
            System.out.println(current.value);
            // and move on to it's next node.
            current = current.previous;
        }
    }
    
    
   public int pop() {
	   Node current = this.tail;
	   this.tail = current.previous;
	   return current.value;
   }
    
   public int size() {
       // find the first node, aka head.
       Node current = this.tail;
       int countNodes =0;
       
       // while the current node exists...copy
       while(current != null) {
           // print it's value
           countNodes +=1;
           // and move on to it's next node.
           current = current.previous;
       }
       return countNodes;
   }
   
   public boolean contains(int inValue) {
       // find the first node, aka head.
       Node current = this.tail;
       
       while(current != null) {
           // print it's value
           if(current.value == inValue) return true;
           // and move on to it's next node.
           current = current.previous;
       }
       return false;
   }
   
   
} // end class