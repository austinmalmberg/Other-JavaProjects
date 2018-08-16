package HandsOn;

import java.util.stream.IntStream;

public class RecursionDemo {

	public static void main(String[] args) {
		NodeChain<String> chain = new NodeChain<>();
		IntStream.rangeClosed(1, 10).forEach(i -> chain.add( String.valueOf(i) ));	// populate the chain with string values
		
		System.out.println("Chain length: " + count(chain.getFirst()));
		
		while(chain.peek() != null) {
			System.out.println(chain.poll());
		}
		
		System.out.println("Chain length: " + count(chain.getFirst()));
	}
	
	public static <T> int count(Node<T> n) {
		if(n == null) return 0;
		
		return 1 + count(n.getNext());
	}
}

/**
 * A singly linked list
 *
 * @param <T>
 */
class NodeChain<T> {
	
	private Node<T> head;
	private Node<T> tail;
	
	public NodeChain() { }
	
	public void add(T t) {
		Node<T> node = new Node<T>(t, null);
		
		if(tail != null) {
			tail.setNext(node);
			tail = node;
		} else {
			head = tail = node;
		}
	}
	
	/**
	 * Returns but does not remove the first element in the chain
	 * 
	 * @return The element or null if empty
	 */
	public T peek() {
		return head != null ? head.getValue() : null;
	}
	
	/**
	 * Removes and returns the first element in the chain
	 * 
	 * @return The element or null if empty
	 */
	public T poll() {
			
		if(head != null) {
			Node<T> node = head;
			head = head.getNext();
			
			return node.getValue();
		}
		
		return null;
	}
	
	public Node<T> getFirst() {
		return head;
	}
}

class Node<T> {
	
	private T t;
	private Node<T> next;
	
	public Node(T t, Node<T> next) {
		this.t = t;
		this.next = next;
	}
	
	public T getValue() { return t; }
	public Node<T> getNext() { return next; }
	
	public void setNext(Node<T> next) { this.next = next; }
}
