import java.util.Scanner;

public class LetterCapitalize {

	  public static String LetterCapitalize(String str) { 
		  String out = "";
		  for(int i = 0; i < str.length(); i++) {
			  if(Character.isAlphabetic(str.charAt(i)) &&
					  (i == 0 || str.charAt(i-1) == ' ') )
				  out += Character.toUpperCase(str.charAt(i));
			  else
				  out += str.charAt(i);
		  }
		  
		  return out;
	  } 
	  
	  public static void main (String[] args) {  
	    Scanner s = new Scanner(System.in);
	    System.out.print(LetterCapitalize(s.nextLine())); 
	  }
	  

}
