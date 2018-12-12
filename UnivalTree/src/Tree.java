
public class Tree {

	private Node t0;
	private Node t1;
	
	public static void main(String[] args) {
		System.out.println(new Tree().countUnivalTrees());
	}
	
	public Tree() {
		
		t0 = new Node(0);
			t0.left = new Node(1);
			t0.right = new Node(0);
				t0.right.left = new Node(1);
					t0.right.left.left = new Node(1);
					t0.right.left.right = new Node(1);
				t0.right.right = new Node(0);		
		
		t1 = new Node(3,
				new Node(2),
				new Node(3,
						null,
						new Node(2,
							new Node(2),
							new Node(2))));
	}
	
	public int countUnivalTrees() {
		return t0.countUnival();
	}
}
