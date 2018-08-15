package com.austin.challenge350e;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
	
	public static void main(String[] args) {
		
		String[] file = getFile("example2.txt");
		BookshelfProblem bsp = new BookshelfProblem(file);
		
		bsp.minimumShelves();
		
		Combinations combo = new Combinations();
		
		List<Integer> test = IntStream.rangeClosed(1, 3).boxed().collect(Collectors.toList());
		
		
		System.out.println(combo.comb2("abc"));
	}
	
	public static String[] getFile(String fileName) {
		
		try {
			return Files.lines(new File(fileName).toPath()).toArray(String[]::new);
		} catch(IOException io) {
			io.printStackTrace();
		}
		
		return null;
	}
}