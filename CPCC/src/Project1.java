import java.util.Scanner;
import java.util.Stack;

/**
 * Project_01 for 2018SP_CSC249_90 
 * 
 * @author Austin Malmberg
 *
 */


public class Project1 {
	public static void main(String[] args) {
		final String ops = "+*";
		
		Stack<String> operators = new Stack<>();
		Stack<Integer> operands = new Stack<>();
		
		boolean pending_operand = false;
		
		Scanner sc = new Scanner(System.in);
		String input;
		
		System.out.print("Enter a prefix expression: ");
		input = sc.nextLine();
		
		for(String token : input.split("\\s+")) {
			
			if(ops.contains(token)) {
				
				operators.push(token);
				pending_operand = false;
				
			} else if(isInteger(token)) {
				
				operands.push(getInt(token));
				
				if(pending_operand) {
					
					int temp = 0;
					while(!operands.isEmpty()) {
						
						try {
							temp = compute(operands, operators.pop());
						} catch (InvalidOperandException ioe) {
							ioe.printStackTrace();
						}
							
					}
					
					operands.push(temp);
				}
				pending_operand = true;
			} else {
				System.out.println(token + " could not be processed.");
				break;
			}
			
		}
		
		System.out.println(operands.pop());
	}
	
	public static int compute(Stack<Integer> ints, String op) throws InvalidOperandException {
		if(op.equals("+")) return add(ints);
		if(op.equals("*")) return multiply(ints);
		
		throw new InvalidOperandException(op + " is not a valid operand.");
	}
	
	public static int add(Stack<Integer> ints) {
		
		int ans = 0;
		while(!ints.isEmpty()) {
			ans += ints.pop();
		}
		
		return ans;
	}
	
	public static int multiply(Stack<Integer> ints) {
		if(ints.isEmpty()) return 0;
		
		System.out.println(ints);
		
		int ans = 1;
		while(!ints.isEmpty()) {
			ans *= ints.pop();
		}
		
		return ans;
	}
	
	public static boolean isInteger(String token) {
		try {
			Integer.parseInt(token);
			return true;
		} catch(NumberFormatException nfe) {
			System.out.println(token + " is not a valid integer");
		}
		
		return false;
	}
	
	public static int getInt(String str) {
		try {
			return Integer.parseInt(str);
		} catch(NumberFormatException nfe) {
			nfe.printStackTrace();
		}
		
		System.out.println("getInt(" + str + ") called.");
		return 0;
	}

}

@SuppressWarnings("serial")
class InvalidOperandException extends Exception {
	
	public InvalidOperandException(String message) {
		super(message);
	}
}
