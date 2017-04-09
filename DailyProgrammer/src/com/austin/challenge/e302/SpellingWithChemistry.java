package com.austin.challenge.e302;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 *  written by /u/thorwing
 */

public class SpellingWithChemistry {
	static List<List<String>> elements;
	
	static String[] words = {
			"functions",
			"bacon",
			"poison",
			"sickness",
			"ticklish"
	};
	
	public static void main (String[] args) {
		loadElementTable();
		
		Arrays.stream(words)
				.map(w -> findByHeaviest(w, Arrays.asList()))
				.forEach(w -> prettyPrint(w));		
	}
	
	private static void loadElementTable() {
		
		try {
			Path filePath = Paths.get("/Users/mac9812e/Eclipse Workspace/DailyProgrammer/bin/com/austin/challenge/e302/elements.txt");
			
			// converts the elements to a list
			elements = Files.lines(filePath)
					.skip(1)  // ignores column headers
					.map(Pattern.compile("[^\\w\\.]+")::split)
					.map(Arrays::asList)
					.collect(Collectors.toList());
			
		} catch (Exception e) {
			e.printStackTrace();
			
			System.out.println("The element table could not be loaded.");
			System.exit(0);
		}
	}
	
	private static List<List<String>> findByHeaviest(String w, List<List<String>> chosen) {
		if(w.isEmpty()) return chosen;
		
	    return elements.stream()
	    		.filter(e -> w.startsWith(e.get(1).toLowerCase()))
	    		.map(e -> findByHeaviest(w.substring(e.get(1).length()), Stream.concat(chosen.stream(), Stream.of(e)).collect(Collectors.toList())))
	    		.max(Comparator.comparingDouble(e -> e.stream().mapToDouble(l -> Double.parseDouble(l.get(3))).sum()))
	    		.get();
	}
	
	private static void prettyPrint(List<List<String>> w){
		String symbolConcat = w.stream().map(l -> l.get(1)).collect(Collectors.joining());
		
		String elements = w.stream().map(l -> l.get(0)).collect(Collectors.joining(", ", "(", ")"));
		
		System.out.println(symbolConcat + " " + elements);
	}
}
	




