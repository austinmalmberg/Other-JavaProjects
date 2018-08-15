import java.util.Scanner;
import java.util.Stack;

public class Reverse {
	public static void main(String[] args) {
		Stack<String> words = getWordStack();
		
		System.out.println("-----Your words in reverse order-----");
		while(!words.isEmpty()) {
			System.out.println(words.pop());
		}
		
	}
	
	public static Stack<String> getWordStack() {
		Scanner sc = new Scanner(System.in);
		Stack<String> words = new Stack<>();
		String exitWord = "exit";
		
		String input;
		
		// loop that adds words to the stack until an exit word is entered
		do {
			
			System.out.printf("Enter a word (type \"%s\" when finished): ", exitWord);
			input = sc.nextLine().trim();
			
			if(validWord(input, exitWord)) {
				words.push(input);
				System.out.println(input + " was added to the stack.");
			}
			
		} while(!input.equals(exitWord));
		
		sc.close();
		return words;
	}
	
	public static boolean validWord(String input, String exitWord) {
		
		// returns false if the input is empty
		if(input.length() == 0) {
			System.out.println("Word cannot be empty.");
			return false;
		}
		
		// returns false if the word contains a space		
		if(input.contains(" ")) {
			System.out.println("Input should only contain a single word.");
			return false;
		}
		
		if(input.equals(exitWord)) return false;
		
		return true;
	}
}
