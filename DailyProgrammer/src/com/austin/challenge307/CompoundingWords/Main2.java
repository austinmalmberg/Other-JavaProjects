package com.austin.challenge307.CompoundingWords;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main2 {
	static Map<String, List<String>> buildMap;
	static int minLength = 2;
	
	public static void main(String[] args) throws IOException{
		long start = System.currentTimeMillis();
		
		Set<String> words = Files.lines(Paths.get("/Users/mac9812e/Eclipse Workspace/DailyProgrammer/src/dictionary.txt"))
	    		.collect(Collectors.toCollection(HashSet::new));
		
		// creates map of valid words and a list of valid words on  
	    buildMap = words.stream()
	    	.flatMap(w -> Stream.of(										// returns a stream of all word segments.  i.e. key=umble, value=tumble
	    			new SimpleEntry<>(w.substring(1), w),
	    			new SimpleEntry<>(w.substring(0, w.length() - 1), w)))
	        .filter(e -> words.contains(e.getKey()))						// filter word segments that exist in the dictionary
	        .collect(Collectors.groupingBy(
	        		t -> t.getKey(),	// buildMap.key = subword
	        		Collectors.mapping(t -> t.getValue(), Collectors.toList())));	// buildMap.value = string list of words that contains the subword with subword.length + 1
	    
	    buildMap.keySet().stream()
	    	.filter(l -> l.length() == minLength)
	    	.map(s -> new ArrayDeque<>(Arrays.asList(s)))
	    	.flatMap(Main2::buildRoute)
	        .collect(Collectors.groupingBy(k -> k.size(), TreeMap::new,Collectors.toList()))
	        .lastEntry().getValue().forEach(System.out::println);
	    
	    System.out.println(System.currentTimeMillis() - start);
	}
	
	private static Stream<ArrayDeque<String>> buildRoute(ArrayDeque<String> input){
		return buildMap.containsKey(input.peekLast()) ?
				buildMap.get(input.peekLast()).stream()
					.map(l -> copyAndAdd(input, l))
					.flatMap(s -> buildRoute(s)) : 
				Stream.of(input);
	}
	
	private static ArrayDeque<String> copyAndAdd(ArrayDeque<String> input, String l){		
	    return Stream.concat(input.stream(), Stream.of(l)).collect(Collectors.toCollection(ArrayDeque::new));
	}
}
