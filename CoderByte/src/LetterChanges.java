import java.util.Scanner;

// https://coderbyte.com/information/Letter%20Changes

public class LetterChanges {

	public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
	public static final String VOWELS = "aeiou";
	
	public static String LetterChanges(String str) {
		String out = "";
		
		for(char ch : str.toLowerCase().toCharArray()) {
			
			if(ALPHABET.contains( String.valueOf(ch) )) {
				
				char newCh = nextLetter(ch);
				out += VOWELS.contains( String.valueOf(newCh) ) ?
						Character.toUpperCase(newCh) : newCh;
			} else {
				out += ch;
			}			
		}
		
		return out;
	}
	
	public static char nextLetter(char ch) {
		return ALPHABET.charAt( (ALPHABET.indexOf(ch) + 1) % ALPHABET.length() );
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println(LetterChanges(s.nextLine()));
	}
}
