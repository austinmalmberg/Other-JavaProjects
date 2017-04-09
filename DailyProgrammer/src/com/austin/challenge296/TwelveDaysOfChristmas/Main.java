package com.austin.challenge296.TwelveDaysOfChristmas;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
	public static final String DIRECTORY =
		"/Users/mac9812e/Eclipse Workspace/DailyProgrammer/src/com/austin/challenge296/TwelveDaysOfChristmas/";
	
	public static final String[][] days = 
		{{"A", "first"}, {"Two", "second"}, {"Three", "third"}, {"Four", "fourth"}, {"Five", "fifth"}, {"Six", "sixth"},
		{"Seven", "seventh"},{"Eight", "eighth"},{"Nine", "nineth"},{"Ten", "tenth"},{"Eleven", "eleventh"},{"Twelve", "twelfth"}};
	
	public static void main(String[] args) {
		String[] gifts = load("twelvedays.txt");

		for(int i = 0; i < days.length; i++) {
			System.out.printf("On the %s day of Christmas%nmy true love gave to me:%n", days[i][1]);
			
			// count backwards through gifts
			for(int j = i; j >= 0; j--) {
				System.out.printf("%s%s %s%n",
						j == 0 && i > 0 ? "And " : "",
						j == 0 && i > 0 ? days[j][0].toLowerCase() : days[j][0],
						gifts[j]);
			}
			System.out.println();
		}
	}
	
	public static String[] load(String fileName) {
		try {
			return Files.lines(Paths.get(DIRECTORY+fileName)).toArray(String[]::new);
		} catch(IOException io) {
			System.out.println(fileName + " could not be loaded.");
			io.printStackTrace();
			System.exit(0);
		}
		
		return null;
	}
}
