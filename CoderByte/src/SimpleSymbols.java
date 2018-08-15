import java.util.Scanner;

// https://coderbyte.com/information/Simple%20Symbols

public class SimpleSymbols {
	
	
	public static String SimpleSymbols(String str) {
		for(int i = 0; i < str.length(); i++) {
			if( Character.isAlphabetic(str.charAt(i) ) ) {
				
				if(i-1 < 0 || i+1 >= str.length())
					return "false";
				
				if(str.charAt(i-1) != '+') return "false";
				if(str.charAt(i+1) != '+') return "false";
			}
		}
		
		return "true";
	}
		  
	public static void main (String[] args) {   
		Scanner s = new Scanner(System.in);
		System.out.print(SimpleSymbols(s.nextLine())); 
	}   

}
