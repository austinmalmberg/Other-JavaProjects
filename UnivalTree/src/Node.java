

public class Node implements Comparable<Node> {

	private int value;
	
	Node left;
	Node right;
	
	public Node(int value) {
		this.value = value;
	}
	
	public Node(int value, Node left, Node right) {
		this.value = value;
		
		this.left = left;
		this.right = right;
	}
	
	
	@Override
	public int compareTo(Node other) {
		return value - other.value;
	}
	
	public boolean isUnival() {
		if(left == null && right == null) return true;
		if(left == null || right == null) return false;
		
		if(this.compareTo(left) == 0 && left.compareTo(right) == 0) return true;
		
		return false;
	}
	
	public int countUnival() {		
		if(left != null && right != null)
			return (isUnival() ? 1 : 0) + left.countUnival() + right.countUnival();
		
		if(left != null)
			return left.countUnival();
		
		if(right != null)
			return right.countUnival();
		
		return (isUnival() ? 1 : 0);
	}
}
