/**
 * https://www.reddit.com/r/dailyprogrammer/comments/8ylltu/20180713_challenge_365_hard_tessellations_and/
 * 
 * @author Austin Malmberg
 */

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		String[] fileNames = {
			"Example1.txt",
			"Challenge1.txt",
			"Challenge2.txt",
			"CustomChallenge1.txt"
		};

		for(String fileName: fileNames) {
			Stream.of(new Tessallation(importFile(fileName)).getTessallation())
				.forEach(System.out::println);
			System.out.println();
		}
	}

	public static String[] importFile(String fileName) {		
		try {
			String[] file = Files.lines(new File(fileName).toPath())
					.toArray(String[]::new);
			
			return file;
		} catch(IOException io) {
			io.printStackTrace();
		}
		
		return null;
	}
}
