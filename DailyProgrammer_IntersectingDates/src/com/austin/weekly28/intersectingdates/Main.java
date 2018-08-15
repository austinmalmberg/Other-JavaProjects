package com.austin.weekly28.intersectingdates;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.ParseException;

public class Main {

	
	public static void main(String[] args) throws ParseException {
		
		String[] input = getFile("input.txt");
		
		DateRange range = new DateRange(input[0].split("\\s+"));
		DateRange selection = new DateRange(input[1].split("\\s+"));
		
		if(selection.intersects(range))
			System.out.println(selection.toString() + " intersects " + range.toString());
		else
			System.out.println(selection.toString() + " DOES NOT intersect " + range.toString());
	}

	public static String[] getFile(String fileName) {
		
		try {
			return Files.lines(new File(fileName).toPath()).toArray(String[]::new);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
