import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		int[] arr = {10, 5, 15, 7, 2, 9, 31, 5};
		
		new SortedBinaryTree(arr).printAscending();
	}
}

class SortedBinaryTree {
	
	SortableNode root;
	int size;
	
	public SortedBinaryTree() {
		size = 0;
	}
	
	public SortedBinaryTree(int[] arr) {
		if(arr.length == 0) return;
		
		for(int i : arr) {
			add(i);
		}
	}
	
	public void add(int val) {
		
		add(new SortableNode(val));
		size++;
	}
	
	public void add(SortableNode n) {
		
		if(root == null)
			root = n;
		else
			root.add(n);
	}
	
	public void printAscending() {
		int[] sorted = new int[size];
		
		root.populateSortedArray(sorted);
		
		System.out.println(Arrays.toString(sorted));
	}
}

class SortableNode implements Comparable<SortableNode> {

	int val;
	SortableNode left;
	SortableNode right;
	
	int duplicates;
	
	public SortableNode(int val) {
		this.val = val;
		
		duplicates = 0;
	}
	
	public SortableNode(int val, SortableNode left, SortableNode right) {
		this(val);
		
		this.left = left;
		this.right = right;
	}
	
	@Override
	public int compareTo(SortableNode other) {
		return val - other.val;
	}
	
	public void add(SortableNode node) {
		
		if(this.compareTo(node) > 0) {
			
			if(left == null)
				left = node;
			else
				left.add(node);
			
		} else if(this.compareTo(node) < 0) {
			
			if(right == null)
				right = node;
			else
				right.add(node);
			
		} else {
			
			duplicates++;
			
		}
	}
	
	/**
	 * Adds elements to a pre-sized array in ascending order.
	 * 
	 * @param arr The pre-sized array to be populated
	 */
	public void populateSortedArray(int[] arr) {
		populateSortedArray(arr, 0);
	}
	
	/**
	 * Adds elements to a pre-sized array in ascending order.
	 * 
	 * @param arr The pre-sized array to be populated
	 * @param i The next empty index at the time the array is passed to the node
	 * @return The next empty index after all the node's children have been added
	 */
	private int populateSortedArray(int[] arr, int i) {
		int next = i;
		
		if(left != null) {
			next = left.populateSortedArray(arr, next);
		}
		
		arr[next++] = val;
		for(int d = 0; d < duplicates; d++) {
			arr[next++] = val;
		}
		
		if(right != null) {
			return right.populateSortedArray(arr, next);
		}
		
		return next;
	}
}
