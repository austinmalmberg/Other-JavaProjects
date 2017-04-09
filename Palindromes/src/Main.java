import java.io.*;

public class Main {
	public static void main(String[] args) {
		new Palindrome("Palindrome1").test();
		new Palindrome("Palindrome2").test();
	}
}

class Palindrome {
	
	private String filename;
	private StringBuilder sb;
	
	Palindrome(String filename) {
		this.filename = filename;
		
		sb = new StringBuilder();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(filename)));
			
			String line = br.readLine();
			while(line != null) {
				sb.append(line);
				
				line = br.readLine();
			}
			
			br.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void test() {
		StringBuilder formatted = new StringBuilder(sb.toString().toLowerCase().replaceAll("[^a-z]", ""));
		
		System.out.print(filename + ": ");
		System.out.println(formatted.toString().equals(formatted.reverse().toString()) ? "Palindrome." : "Not a palindrome.");
	}
}
