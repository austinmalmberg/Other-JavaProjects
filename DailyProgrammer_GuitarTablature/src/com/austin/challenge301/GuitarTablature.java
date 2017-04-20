package com.austin.challenge301;

import java.io.File;
import java.nio.file.Files;

// fix file path

public class GuitarTablature {
	
	static char[][] strings;
	
	static String[] notes = {
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
		
		for(int i = 0; i < notes.length; i++) {
			if(notes[i].equals(String.valueOf(stringNote))) {
				index = (i + increment) % 12;
			}
		}
		
		return notes[index];			
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
