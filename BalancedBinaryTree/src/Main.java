
/**
 * Given a binary tree, write a function that determines whether the tree is balanced
 * 
 * @author Austin Malmberg
 *
 */
public class Main {
	
	static Node root;

	public static void main(String[] args) {
		initTree();
		
		System.out.println(isBalanced_fail(root));
	}
	
	/**
	 * Tree is balanced when the maximum difference between the depth of its branches leaves does not exceed 1.
	 * 
	 * DOES NOT WORK---
	 * If the tree contains an unbalanced subtree
	 * 
	 * @param n
	 * @return
	 */
	public static boolean isBalanced_fail(Node n) {
		return Math.abs(getMaximumDepth_fail(n.left) - getMaximumDepth_fail(n.right)) < 2;
	}
	
	public static int getMaximumDepth_fail(Node n) {		
		if(n == null)
			return 0;
		
		int lDepth = 1 + getMaximumDepth_fail(n.left);
		int rDepth = 1 + getMaximumDepth_fail(n.right);
		
		System.out.printf("Node: %d   lDepth: %d  rDepth: %d%n", n.val, lDepth, rDepth);		
		return Math.max(lDepth, rDepth);
	}
	
	public static void initTree() {
		/**
		 *                   1
		 *                /     \
		 *              2         3
		 *            /   \     /   \
		 *           4     5    6     7
		 *            \        / \   / \
		 *             8      9  10 11 12
		 *                   /
		 *                  13
		 * 
		 */
		root = new Node(1);
		
		
		// depth = 1
		root.left = new Node(2);
		root.right = new Node(3);
		
		
		// depth = 2
		root.left.left = new Node(4);
		root.left.right = new Node(5);
	
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		
		// depth = 3
//		root.left.left.right = new Node(8);
		
		root.right.left.left = new Node(9);
		root.right.left.right = new Node(10);
		
		root.right.right.left = new Node(11);
		root.right.right.right = new Node(12);
		
		
		// depth = 4
		root.right.left.left.left = new Node(13);
	}
	
}

class Node {
	
	int val;
	Node left;
	Node right;
	
	public Node(int val) {
		this.val = val;
	}
}
