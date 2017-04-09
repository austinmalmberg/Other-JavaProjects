package com.austin.challenge.i305;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main_i305 {

	
	public static void main(String[] args) {
		Conjunctions c = new Conjunctions("/Users/mac9812e/Eclipse Workspace/DailyProgrammer/bin/com/austin/challenge/i305/dictionary.txt");
//		System.out.println("Index = " + conj.getIndex("infomercial"));
		
//		c.find("methylenedioxymethamphetamine", 2);

//		c.find("infomercial", 2);
//		c.find("infrared", 2);
//		c.find("permeability", 2);
//		c.find("methylenedioxymethamphetamine", 2); // error
//		c.find("roentgenographic", 2);
		c.find("unintelligibleness", 2);
//		c.find("roadworthiness", 1);
		
		System.out.println("Conjunction list--");
		for(List<String> conj : c.getList()) {
			System.out.println(conj.toString());
		}
		
		System.out.println("Longest Conjunction--");
		System.out.println(c.getLongestConjunction());
	}
}

class Conjunctions {
	private List<String> dictionary;
	private List<String> subwords;
	private List<List<String>> conjunctions;
	
	private String word;
	private int minLength;
	
	Conjunctions(String dictionaryPath) {
		
		dictionary = loadDictionary(dictionaryPath);
		subwords = new ArrayList<>();
		conjunctions = new ArrayList<>();
		
		minLength = 1;
	}
	
	private List<String> loadDictionary(String path) {
		List<String> lst = null;
		
		// loads dictionary into list
		try {
			lst = Files.lines(Paths.get(path))
					.collect(Collectors.toList());
		} catch(IOException e) {
			System.out.println("Dictionary could not be loaded.");
			e.printStackTrace();
		}
		
		return lst;
	}
	
	void find(String word, int min) {
		this.word = word;
		this.minLength = min;
		
		// word not found in dictionary
		if(getIndex(word) < 0) {
			System.out.println(word + " is not a word in the dictionary.");
			return;
		}
		
		// get all subwords contained in word 
		subwords.clear();
		for(String w: dictionary) {
			if(w.length() >= min && word.contains(w)) subwords.add(w);
		}
		
		System.out.println(subwords.size() + " " + subwords.toString());
		
		generateConjunctionList(new ArrayList<String>(), word);
	}
	
	boolean rollback = false;
	
	/*
	 * Takes arguments for new list and continues to add to this list until the wordSegment < minLength or nothing is returned by finding the next letter
	 * Tests the current list with the word.  if correct, adds word to conjunction list.  otherwise, rolls back changes
	 */
	private void generateConjunctionList(List<String> currentTree, String wordSegment) {
		
		List<String> nextSequence = wordSegment.length() < minLength ? new ArrayList<>() : findByStartingString(wordSegment.substring(0, minLength));
		
		System.out.println("---------------");
		System.out.println("currentTree: " + currentTree.toString());
		System.out.println("wordSegment: " + wordSegment);
		System.out.println("nextSequence: " + nextSequence.toString());
		
		if(nextSequence.isEmpty()) {
			if(test(currentTree)) conjunctions.add(new ArrayList<>(currentTree));
			
			System.out.println("starting rollback " + currentTree.get(currentTree.size() - 1));
			rollback = true;

			return;
		}
		
		for(String sub : nextSequence) {			
			if(rollback) {  
				rollback(currentTree, sub);

				rollback = false;
				System.out.println("rollback complete. " + currentTree);
			}
			
			currentTree.add(sub);
			
			System.out.println("added \"" + sub + "\" to currentTree");
			
			generateConjunctionList(currentTree, wordSegment.substring(sub.length()));
		}
	}
	
	private void rollback(List<String> lst, String s) {		
		for(int i = lst.size() - 1; i >= 0; i--) {
			System.out.println("removing " + lst.get(i));
			
			String temp = lst.get(i);
			
			lst.remove(i);
			
			if(temp.startsWith(s.substring(0, minLength))) break;
		}
	}
	
	private String concat(List<String> lst) {
		StringBuilder sb = new StringBuilder();
		
//		lst.stream().forEach(sb::append);
		for(String s : lst) sb.append(s);
		
		return sb.toString();
	}
	
	boolean test(List<String> lst) {
		if(concat(lst).equals(word.toLowerCase())) return true;
		
		return false;
	}
	
	private List<String> findByStartingString(String cs) {
		return subwords.stream().filter(w -> w.startsWith(cs)).collect(Collectors.toList());
	}
	
	int getIndex(String word) { return dictionary.indexOf(word);	}
	String getWord(int i) {	return dictionary.get(i); }
	
	List<List<String>> getList() { return conjunctions; }
	
	List<String> getLongestConjunction() {
		List<String> lst = new ArrayList<>();
		
		for(List<String> conj : conjunctions) {
			if(conj.size() > lst.size()) lst = conj;
		}
		
		return lst;
	}
}
