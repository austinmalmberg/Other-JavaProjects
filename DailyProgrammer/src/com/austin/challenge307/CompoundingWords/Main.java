package com.austin.challenge307.CompoundingWords;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * 
 * Description
 * What is the longest word you can build in a game of Scrabble one letter at a time?
 * That is, starting with a valid two-letter word, how long a word can you build by playing
 * one letter at a time on either side to form a valid three-letter word, then a valid four-letter word,
 * and so on? (For example, HE could become THE, then THEM, then THEME, then THEMES, for a six-letter result.)
 * 
 * Formal Inputs & Outputs
 * Input Description
 * Using words found in a standard English language dictionary (or enable1.txt).
 * Output description
 * 
 * Print your solution word and the chain you used to get there.
 * 
 * @author mac9812e
 *
 */
public class Main {
	public static void main(String[] args) {
		CompoundingWords sc = new CompoundingWords("dictionary.txt");
		
		sc.run(2);
		sc.print();
	}
}

class CompoundingWords {
	private List<String> dictionary;
	private List<String> minLetterWords;
	
	private List<String> winList;
	private List<String> currList;
	private int longestElement;
	
	private String testWord;
	
	CompoundingWords(String filename) {
		loadDictionary(filename);
		
		winList = new ArrayList<>();
		currList = new ArrayList<>();
	}
	
	void run(int minLength) {
//		minLetterWords = new ArrayList<>();
//		minLetterWords.add("in");
		
		minLetterWords = dictionary.stream().filter(w -> w.length() == minLength).collect(Collectors.toList());
		longestElement = 0;
		find();
		
//		System.out.println("minletterwords: " + minLetterWords.toString());
//		System.out.println("current: " + currList.toString());
//		System.out.println(currList.size());
	}
	
	private void find() {
		for(String str : minLetterWords) {
			
			currList = dictionary.stream()
					.filter(w -> w.length() > str.length() && w.contains(str))
					.sorted(Comparator.comparingInt(String::length))
					.collect(Collectors.toList());
			
			// loop longest -> shortest
			for(int i = currList.size()-1; i >= 0; i--) {
				// will break loop after finding a compound word and checking all other words of the same length
				if(currList.get(i).length() < longestElement) break;
				
				int l = 0;
				
				testWord = currList.get(i);
				isCompoundWord(str, testWord);
				
				if(winList.size() > l) {
					l  = winList.size();
					longestElement = winList.get(winList.size() - 1).length();
				}
			}
			
			currList.clear();
			
//			System.out.println(temp.toString());
		}
	}
	
	private void isCompoundWord(String base, String word) {
		if(!word.contains(base)) return;
		
		if(word.equals(base)) {
			winList.add(testWord);
		}
		
		if(currList.contains(word)) {
			isCompoundWord(base, word.substring(1));
			isCompoundWord(base, word.substring(0, word.length() -1));
		}
	}
	
	void print() {
		System.out.println(winList);
		
		return;
//		
//		String longest = null;
//		
//		for(String word : winList) {
//			if(longest == null || longest.length() < word.length()) {
//				longest = word;
//			}
//		}
//		
//		String longerest = longest;
//		List<String> temp = winList.stream().filter(w -> longerest.contains(w)).collect(Collectors.toList());
//		System.out.println(temp);
	}
	
	String shave(String s, boolean begin) {		
		return begin ? s.substring(1) : s.substring(0, s.length() - 1);
	}
	
	String grow(String base, String full, boolean fromStart) {		
		// print message if the word contains multiple base segments
		if (full.indexOf(base) != full.lastIndexOf(base)) System.out.println(full + " contains multiple segments of " + base); 
		
		int startIndex = fromStart ? full.indexOf(base) - 1 : full.indexOf(base);
		
		String s = full.substring(startIndex, startIndex + base.length() + 1);
		
		return s;
	}
	
	private int getIndex(String s) {
		return dictionary.indexOf(s);
	}
	
	@SuppressWarnings("unused")
	private String getWord(int i) {
		return dictionary.get(i);
	}
	
	private void loadDictionary(String filename) {
		String directory = "/Users/mac9812e/Eclipse Workspace/DailyProgrammer/src/";
		
		try {
			dictionary = Files.lines(Paths.get(directory + filename))
					.collect(Collectors.toList());
		} catch (Exception e) {
			System.out.println("Could not load " + filename);e.printStackTrace();
		}
	}
}