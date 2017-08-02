package com.austin.challenge301;

import java.io.File;
import java.nio.file.Files;

/**
 * Description
 * 
 * Tablature is a common form of notation for guitar music. It is good for beginners as it tells you exactly how to play a note.
 * The main drawback of tablature is that it does not tell you the names of the notes you play. We will be writing a program that
 * takes in tablature and outputs the names of the notes.
 * 
 * In music there are 12 notes named A A# B C C# D D# E F# G and G#. The pound symbol represents a sharp note. Each one of these notes
 * is separated by a semitone. Notice the exceptions are that a semitone above B is C rather than B sharp and a semitone above E is F.
 * 
 * Input Description
 * 
 * In tabs there are 6 lines representing the six strings of a guitar. The strings are tuned so that not pressing down a fret gives you
 * these notes per string:
 * 
 *    E |-----------------|
 *    B |-----------------|
 *    G |-----------------|
 *    D |-----------------|
 *    A |-----------------|
 *    E |-----------------|
 *    
 *    Tabs include numbers which represent which fret to press down. Numbers can be two digits. Pressing frets down on a string adds one
 *    semitone to the open note per fret added. For example, pressing the first fret on the A string results in an A#, pressing the second
 *    fret results in a B.
 * 
 * @author Austin Malmberg
 *
 */
public class GuitarTablature {
	
	static char[][] strings;
	
	public static final String[] NOTES = {
			"A",
			"A#",
			"B",
			"C",
			"C#",
			"D",
			"D#",
			"E",
			"F",
			"F#",
			"G",
			"G#"
	};
	
	public static void main (String[] args) {
		String fileName = "Sample2.txt";
		StringBuilder sb = new StringBuilder("  ");
		
		loadTablature(fileName);
		
		// display tab
		for(int i = 0; i < strings.length; i++) {
			System.out.println(strings[i]);
		}
		
		for(int l = 0; l < strings[0].length; l++) {
			for(int h = 0; h < strings.length; h++) {
				
				int fret = strings[h][l];
				int testFret = 0;
				
				if(Character.isDigit(strings[h][l])) {					
					fret = Integer.parseInt(""+strings[h][l]);
					
					if(Character.isDigit(strings[h][l+1]) && // if the next digit is a character
							(testFret = (fret*10) + Integer.parseInt(""+strings[h][l+1])) > 0 // combine them and check to see if the note is on the fretboard
							&& testFret <= 27) {
						fret = testFret;
						l++; // skip to next column to avoid counting 2 digit numbers twice
					}
					
					sb.append(
							getNote(strings[h][0], Integer.parseInt(String.valueOf(fret))) + " "
					);
				}
			}
		}
		
		// display output answer
		System.out.println(sb.toString());
	}
	
	private static String getNote(char stringNote, int increment) {
		int index = 0;
		
		for(int i = 0; i < NOTES.length; i++) {
			if(NOTES[i].equals(String.valueOf(stringNote))) {
				index = (i + increment) % NOTES.length;
			}
		}
		
		return NOTES[index];			
	}
	
	private static void loadTablature(String fileName) {		
		try {
			
			strings = Files.lines(new File(fileName).toPath())
					.map(String::toCharArray)
					.toArray(char[][]::new);
			
		} catch (Exception e) {
			System.out.println("Tablature could not be loaded.");
			System.exit(0);
		}
	}
}
