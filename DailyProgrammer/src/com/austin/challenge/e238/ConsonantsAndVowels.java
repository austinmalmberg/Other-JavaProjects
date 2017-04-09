package com.austin.challenge.e238;

import java.util.Random;

public class ConsonantsAndVowels {
	public static void main(String[] args) {
		String[] wordStructures = {"cvcvcc", "CcvV", "cvcvcvcvcvcvcvcvcvcv"};
		
		for(String structure : wordStructures) {
			System.out.println(createWord(structure));
		}
	}
	
	public static String createWord(String s) {
		// error handling
		if(s.isEmpty()) return "Empty string.";
		if(s.matches("[^CcVv]")) return "String should only contain the letters 'C' and 'V'.";	// check that string only contains C and V
		
		
		String consonants = "bcdfghjklmnpqrstvwxyz";
		String vowels = "aeiou";
		
		Random rnd = new Random();
		
		StringBuilder word = new StringBuilder();
		char letter = '\u0000';
		
		for(char c : s.toCharArray()) {
			// consonants
			if(c == 'C') letter = Character.toUpperCase(consonants.charAt(rnd.nextInt(consonants.length())));
			if(c == 'c') letter = consonants.charAt(rnd.nextInt(consonants.length()));
			
			// vowels
			if(c == 'V') letter = Character.toUpperCase(vowels.charAt(rnd.nextInt(vowels.length())));
			if(c == 'v') letter = vowels.charAt(rnd.nextInt(vowels.length()));
			
			word.append(letter);
		}
		
		return word.toString();
	}
}
