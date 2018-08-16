import java.util.Scanner;
import java.util.Stack;

public class Palindrome {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String input;
		do {
			System.out.print("Enter a word to test (type \"exit\" to exit): ");
			input = sc.nextLine().trim();
			
			System.out.println(isPalindrome(input) ? input + " is a palindrome!" : input + " is NOT a palindrome.");
		} while(!input.equals("exit"));
		
		sc.close();
	}
	
	public static boolean isPalindrome(String input) {
		String rev = "";	// reversed string
		
		Stack<Character> stack = new Stack<>();
		
		// adds each character to a stack
		for(int i = 0; i < input.length(); i++) {
			stack.push(input.charAt(i));
		}
		
		// reverses stack to a string
		while(!stack.isEmpty()) {
			rev += stack.pop();
		}
		
		return input.equals(rev);
	}
}
