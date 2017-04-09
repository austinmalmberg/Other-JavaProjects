package com.austin.challenge.e240;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Typoglycemia {
	
	public static void main(String[] args) {
		
		String paragraph = "According to a research team at Cambridge University, it doesn't matter in what order "
				+ "the letters in a word are, the only important thing is that the first and last letter be in the "
				+ "right place. The rest can be a total mess and you can still read it without a problem. This is "
				+ "because the human mind does not read every letter by itself, but the word as a whole. Such a "
				+ "condition is appropriately called Typoglycemia.";
		
		System.out.println(jumble(paragraph));
	}
	
	public static String jumble(String s) {
		StringBuilder jumbled = new StringBuilder();
		StringBuilder word = new StringBuilder();
		
		for(char c : s.toCharArray()) {
			if(Character.isLetter(c)) {	// if char is letter
				word.append(c);
			} else {	// if char is not letter
				jumbled.append(shuffleWord(word.toString()));
				
				word.setLength(0);	// clear word
				jumbled.append(c);	// jumble letters in word and add it to output along with the non-alphabetical character
			}
		}
		
		return jumbled.toString();
	}
	
	public static String shuffleWord(String s) {
		if(s.equals("Typoglycemia")) return s;
		if(s.length() <= 3) return s;
		if(s.length() == 4) return ""+ s.charAt(0) + s.charAt(2) + s.charAt(1) + s.charAt(3);
		
		// add all but the first and last letters to arraylist
		List<Character> chars = new ArrayList<>();
		for(int i = 1; i < s.length() - 1; i++) {
			chars.add(s.charAt(i));
		}
		
		Collections.shuffle(chars);
		
		// turn list back into string
		StringBuilder output = new StringBuilder();
		for(Character ch : chars) {
			output.append(ch);
		}
		
		// add the first and last characters
		output.insert(0, s.charAt(0));
		output.append(s.charAt(s.length() - 1));
		
		if(output.toString().equals(s)) {
			return shuffleWord(s);
		} else {		
			return output.toString();
		}
	}
}
