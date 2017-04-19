package com.austin.challenge238;

import java.util.Random;

public class ConsonantsAndVowels {
	public static final String CONSONANTS = "bcdfghjklmnpqrstvwxyz";
	public static final String VOWELS = "aeiou";
	
	public static void main(String[] args) {
		String[] wordStructures = {"cvcvcc", "CcvV", "cvcvcvcvcvcvcvcvcvcv"};
		
		for(String structure : wordStructures) {
			System.out.println(createWord(structure));
		}
	}
	
	public static String createWord(String s) {		
		Random rnd = new Random();
		
		StringBuilder word = new StringBuilder();
		char letter = '\u0000';
		
		for(char c : s.toCharArray()) {
			// consonants
			if(c == 'C') letter = Character.toUpperCase(CONSONANTS.charAt(rnd.nextInt(CONSONANTS.length())));
			if(c == 'c') letter = CONSONANTS.charAt(rnd.nextInt(CONSONANTS.length()));
			
			// vowels
			if(c == 'V') letter = Character.toUpperCase(VOWELS.charAt(rnd.nextInt(VOWELS.length())));
			if(c == 'v') letter = VOWELS.charAt(rnd.nextInt(VOWELS.length()));
			
			word.append(letter);
		}
		
		return word.toString();
	}
}
