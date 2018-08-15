package com.austin.weekly28.boxesandconveyors;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Stream;

public class Main {
	
	public static void main(String[] args) {
		
		String[] input_files = {
				"input1.txt",
				"input2.txt",
				"input3.txt",
				"input4.txt",
				"input5.txt"
		};
		
		BeltManager bm = new BeltManager();
		Stream.of(input_files).forEach(file -> {
			bm.set(getFile(file));
			bm.run_ResultOnly();
		});

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
