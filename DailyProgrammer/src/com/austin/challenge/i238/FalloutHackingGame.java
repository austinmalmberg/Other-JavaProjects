package com.austin.challenge.i238;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class FalloutHackingGame {
	public static void main(String[] args) throws InsufficientElementsException {
		Scanner sc = new Scanner(System.in);
		
		WordList wl = new WordList("/com/austin/challenge/238i/enable1.txt");
		Random rnd = new Random();
		
		boolean correct = false;
		int guessesLeft = 5;
		
		ArrayList<String> terminal = wl.getList(6, 8);
		String ans = terminal.get(rnd.nextInt(terminal.size()));
		
		// game loop
		while(!correct && guessesLeft > 0) {
			showTerminal(terminal);
			
			System.out.print("Guess (" + guessesLeft + " left)? ");
			String choice = sc.nextLine().trim();
			
			// win/lose condition
			correct = compareOptions(ans, choice);
			if(!correct) {
				guessesLeft--;
				if(guessesLeft <= 0) System.out.println("Access denied.");
			}
		}
		
		sc.close();
	}
	
	public static void showTerminal(ArrayList<String> terminal) {
		for(String option : terminal) {
			System.out.println(option);
		}
	}
	
	public static boolean compareOptions(String ans, String choice) {
		choice = choice.toUpperCase();
		
		if(ans.equalsIgnoreCase(choice)) {
			System.out.println("Access granted.");
			return true;
		}
		
		int sameLetter = 0;
		
		int shortest = ans.length() < choice.length() ? ans.length() : choice.length();
		for(int i = 0; i < shortest; i++) {
			if(ans.charAt(i) == choice.charAt(i)) sameLetter++;
		}
		
		System.out.printf("%d/%d correct%n", sameLetter, ans.length());
		return false;
	}
}

class WordList {
	
	List<ArrayList<String>> lists;
	Random rnd;
	
	public WordList(String source) {
		lists = new ArrayList<ArrayList<String>>();
		rnd = new Random();
		
		for(int i = 0; i < 30; i++) {
			lists.add(new ArrayList<String>());
		}
		
		populateListsArray(source);
	}
	
	private void populateListsArray(String source) {
		try {	// get contents of source file			
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(getClass().getResource(source).toURI()))));
			
			String line;
			while((line = br.readLine()) != null) {	// read each line and write it to the appropriate list
				lists.get(line.length()).add(line.trim().toUpperCase());
			}
			
			br.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean sufficientElements(int elements, int wordLength) {
		return lists.get(wordLength).size() >= elements;
	}
	
	public ArrayList<String> getList(int elements, int wordLength) throws InsufficientElementsException {
		ArrayList<String> list = new ArrayList<>();
		
		if(lists.get(wordLength).size() < elements) {
			throw new InsufficientElementsException("Elements in word list: " + lists.get(wordLength).size() + "  Minimum elements needed: " + elements);
		}
		
		for(int i = 0; i < elements; i++) {
			list.add(lists.get(wordLength).get(rnd.nextInt(lists.get(wordLength).size())));
		}
		
		return list;
	}
}

class InsufficientElementsException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public InsufficientElementsException(String error) {
		System.out.println(error);
	}
}