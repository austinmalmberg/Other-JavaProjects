package com.austin.customqueue;

public class MyQueueImplementation {

	public static void main(String[] args) {
		
		MyQueue<Integer> queue = new MyQueue<>();
		
		for(int i = 0; i < 10; i++) {	// populate the queue
			queue.enqueue(i+1);
		}
		
		while(!queue.isEmpty()) {	// dequeue and print all elements in the queue
			System.out.println("Element: " + queue.dequeue());
		}
		
	}
}

class MyQueue<E> {
	
	private MyLinkedList<E> linkedList;
	
	public MyQueue() {
		linkedList = new MyLinkedList<>();
	}
	
	public void enqueue(E element) {
		linkedList.add(element);
	}
	
	public E dequeue() {
		return linkedList.remove();
	}
	
	public int size() { return linkedList.size(); }
	public boolean isEmpty() { return linkedList.isEmpty(); }
}

/**
 * A circular, singly linked list that uses a pointer node to keep track of elements
 * The pointer node refers to the newest element in the list while
 * the pointer.getNext() method returns the oldest element in the list.
 * 
 * @author Austin Malmberg
 *
 * @param <E>
 */
class MyLinkedList<E> {
	
	private Node<E> pointer;	// newest list element
	
	private int size;
	
	public MyLinkedList() {
		pointer = null;
		size = 0;
	}
	
	public void add(E element) {
		
		Node<E> node = new Node<E>(element);
		
		if(pointer == null) {	// if this is the first element, link the node to itself
			node.setNext(node);
		} else {
			node.setNext(pointer.getNext());
			pointer.setNext(node);
		}
		
		size++;
		pointer = node;
	}
	
	public E remove() throws NullPointerException {
		
		if(isEmpty()) throw new NullPointerException();
		
		Node<E> node = pointer.getNext();		// node to be removed
		
		if(node == pointer) {
			pointer = null;
		} else {
			pointer.setNext(node.getNext());	// update pointer.next to be the next node in the queue
		}
		
		size--;
		
		return node.getElement();
	}
	
	public int size() { return size; }
	public boolean isEmpty() { return size == 0; }
}

/**
 * Stores an element of a generic object type 
 * 
 * @param <E>
 */
class Node<E> {
	
	private E element;
	private Node<E> next;
	
	public Node(E element) {
		this.element = element;
		this.next = null;
	}
	
	public Node(E element, Node<E> next) {
		this.element = element;		
		this.next = next;
	}
	
	public E getElement() { return element; }
	public Node<E> getNext() { return next; }
	
	public void setNext(Node<E> next) { this.next = next; }
}
