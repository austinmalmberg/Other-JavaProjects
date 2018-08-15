import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

// https://www.reddit.com/r/dailyprogrammer/comments/8eger3/20180423_challenge_358_easy_decipher_the_seven/

public class Main {

	public static void main(String[] args) {
		String[] filenames = {
				"challenge1.txt",
				"challenge2.txt",
				"challenge3.txt",
				"challenge4.txt"
		};
		
		
		for(String file : filenames) {
			
			SevenSegment seg = new SevenSegment(getFileAsStringArray(file));
			System.out.println(seg.toString());
			
		}
	}
	
	public static String[] getFileAsStringArray(String fileName) {
		
		try {
			return Files.lines(new File(fileName).toPath()).toArray(String[]::new);
		} catch(IOException io) {
			io.printStackTrace();
		}
		
		return null;
	}
}
