public class BinaryTree {

	public static void main(String[] args) throws Exception {
		
		String expr = "((5 + 2) * (2 - 1)) / ((2 + 9) + ((7 - 2) - 1) * 8)";

		TreeNode root = new TreeNode(expr);
		root.print(0);	// print tree
		System.out.printf("%s = %f", root.expr, root.getSolution());
	}

}

class TreeNode {
	
	final String VALID_OPERATORS = "*/+-";
	
	String expr;
	
	char op;	// the operator
	int pos;	// the position of the operator
	
	TreeNode left;
	TreeNode right;
	
	public TreeNode(String expr) throws Exception {		
		this.expr = expr = removeUnnecassaryOuterParentheses(expr);
		
		pos = getOperatorPosition();

		if(pos > 0) {
			op = expr.charAt(pos);
			
			// creates new nodes from the substrings to the left and right of the operator
			left = new TreeNode(expr.substring(0, pos).trim());
			right = new TreeNode(expr.substring(pos+1).trim());
		}
	}
	
	public double getSolution() throws Exception {
		if(op == '\u0000') return Double.parseDouble(expr);
		
		switch(op) {
		case '*':
			return left.getSolution() * right.getSolution();
		case '/':
			return left.getSolution() / right.getSolution();
		case '+':
			return left.getSolution() + right.getSolution();
		case '-':
			return left.getSolution() - right.getSolution();
		}
		
		throw new Exception("Unrecognized operand: " + op);
	}
	
	private int getOperatorPosition() throws Exception {		
		// does not contain an operator
		if(!expr.matches(".*["+VALID_OPERATORS+"].*")) return -1; 
		
		int depth = 0;
		for(int i = 0; i < expr.length(); i++) {
			if(expr.charAt(i) == '(') depth++;
			if(expr.charAt(i) == ')') depth--;
			
			if(depth == 0 && VALID_OPERATORS.contains(expr.charAt(i) + "")) {
				return i;
			}
		}
		
		throw new Exception("Something went wrong here: " + expr);
	}
	
	public String removeUnnecassaryOuterParentheses(String expr) {
		if(!expr.contains("(") || !expr.contains(")")) return expr;
		
		String sub = expr.substring(1, expr.length()-1);
		
		int depth = 0;
		for(int i = 0; i < sub.length(); i++) {
			if(sub.charAt(i) == '(') depth++;
			if(sub.charAt(i) == ')') depth--;
			
			if(depth < 0) return expr;
		}
		
		return depth == 0 ? sub: expr;
	}
	
	public void print(int depth) {
		// for tree formatting
		for(int i = 0; i < depth; i++) {
			System.out.print("____");
		}
		
		System.out.println(op == '\u0000' ? expr : op);
		
		if(left != null) left.print(depth+1);		
		if(right != null) right.print(depth+1);
	}
}