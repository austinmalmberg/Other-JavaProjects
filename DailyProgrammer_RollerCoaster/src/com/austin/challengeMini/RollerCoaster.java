package com.austin.challengeMini;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// update path

/**
 * Roller Coaster Words
 * 
 * Given: A roller coaster word is a word with letters that alternate between going forward and backward in alphabet.
 * One such word is "decriminalization". Can you find other examples of roller coaster words in the English dictionary?
 * 
 * Output: Your program should emit any and all roller coaster words it finds in a standard English language dictionary
 * (or enable1.txt) longer than 4 letters. An example is "decriminalization".
 * 
 * @author Austin Malmberg
 *
 */
public class RollerCoaster {
	private static String dictionaryFileName = "dictionary.txt";
	
	public static void main(String[] args) {
		List<String> dictionary = loadDictionary(dictionaryFileName);
		
		List<String> rcWords = new ArrayList<String>();		
		
		long start = System.currentTimeMillis();
		
		dictionary.stream().forEach(w -> {
			if(w.length() > 4 && isRollerCoaster(w))
				rcWords.add(w);
		});
		
		long elapsed = System.currentTimeMillis() - start;
		
		System.out.println("Time elapsed: " + elapsed + "\nNumber of Roller Coaster Words: " + rcWords.size());
		
		// print each roller coaster word
//		for(String w : rcWords) {
//			System.out.println(w);
//		}
	}
	
	/**
	 * Recursion inspired by comment.
	 * 
	 * Average time = 22 ms
	 * 
	 * @param word
	 * @param prevSign
	 * @return
	 */
	@SuppressWarnings("unused")
	private static boolean isRollerCoaster(String word, int prevSign) {
	    if(word.length() == 1) return true;
	    
	    int sign = Integer.signum(word.charAt(1)-word.charAt(0));
	    if(sign == prevSign || sign == 0)
	    	return false;
	    
    	return isRollerCoaster(word.substring(1), sign);
	}
	
	/**
	 * 'b' is true if letter at index i precedes index i+1 in the alphabet, false otherwise
	 * 
	 * Is not a roller coaster word if:
	 * val = 0 (indicating two consecutive letters are the same), OR
	 * val is negative or positive for two consecutive letters
	 * 
	 * Average time = 14 ms 
	 * 
	 * @param word
	 * @return
	 */
	private static boolean isRollerCoaster(String word) {
		boolean b = true;
		int val = 0;
		
		for(int i = 0; i < word.length() - 1; i++) {			
			val = word.charAt(i) - word.charAt(i+1);
			if(i == 0) b = val < 0 ? true : false;	// set initial value (opposite of first result)
			
			if(val == 0) return false;
			
			if(val > 0  && b) return false;	 
			if(val < 0 && !b) return false;
			
			b = !b;
		}
		
		return true;
	}
	
	/**
	 * Loads wordlist to List<String>.
	 * 
	 * @param filename
	 */
	private static List<String> loadDictionary(String filename) {
		try {
			return Files.lines(new File(filename).toPath())
					.collect(Collectors.toList());
		} catch (Exception e) {
			System.out.println("Cannot load dictionary.");
			System.exit(0);
		}
		
		return null;
	}
}
