


public class DoublyLinkedListImpl<E> {

	public static void main(String[] args) {
		DoublyLinkedList<Integer> ints = new DoublyLinkedList<>();
	}

}

class DoublyLinkedList<E> {
	
	private Node head;
	private Node tail;
	private int size;
	
	public DoublyLinkedList() {
		size = 0;
	}
	
	private int size() { return size; }
	
	public void addFirst(E element) {
		Node temp = new Node(element, null, head);
		
		if(head != null) { head.prev = temp; }
		head = temp;
		
		if(tail == null) { tail = temp; }
		
		size++;
	}
	
	public void addLast(E element) {
		Node temp = new Node(element, tail, null);
		
		if(tail != null) { tail.next = temp; }
		tail = temp;
		
		if(head == null) { tail = temp; }
		
		size++;
	}
	
	public void iterateForward() {
		Node temp = head;
		while(temp != null) {
			System.out.println(temp);
			temp = temp.next;
		}
	}
	
	public void iterateBackward() {
		
	}
	
	
	
	
	
	
	
	private class Node {
		E element;
		Node prev;
		Node next;
		
		Node(E element, Node prev, Node next) {
			this.element = element;
			this.prev = prev;
			this.next = next;
		}
	}
}
