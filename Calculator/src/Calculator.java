import java.util.Scanner;


public class Calculator {
	public static Scanner sc;
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		
		// regular expressions
		String numRegex = "\\d*\\.?\\d*";
		String modRegex = "[+\\-[\\*|x]/]{1}+";
		
		// user inputs
		double first = Double.parseDouble(get("Enter a number: ", numRegex));
		double second = Double.parseDouble(get("Enter another number: ", numRegex));
		char mod = get("Enter a modifier (+, -, x|*, /): ", modRegex).charAt(0);
		
		double result = 0;
		
		sc.close();
		
		// calculation part
		if(mod == '+') result = first+second;
		if(mod == '-') result = first-second;
		if(mod == 'x' || mod == '*') result = first*second;
		if(mod == '/') result = first/second;
		
		if(mod == '/' && second == 0)
			System.out.println("Cannot divide by 0.");
		else
			// format and output
			System.out.printf("%,." + decimalsOf(first) + "f %s %,." + decimalsOf(second) + "f = %,." + decimalsOf(result) + "f",
					first, mod, second, result);
	}
	
	/**
	 * Prompts the user for input then tests the input with the regular expression provided.  Loops until criteria has been met.
	 * 
	 * @param prompt the prompt that is printed to console
	 * @param regex the regular expression
	 * @return a string value that matches the given regex
	 */
	public static String get(String prompt, String regex) {
		String s = null;
		
		do {
			System.out.print(prompt);
			s = sc.nextLine();
			
			if(s.matches(regex)) return s;
			else System.out.println(s + " is not valid.");
		} while(true);
	}
	
	/**
	 * This method returns the number of useful decimal points for any given double.  The number returned ignores any trailing zeroes.
	 * 
	 * @param d raw double value
	 * @return the number of useful decimal points
	 */
	public static int decimalsOf(double d) {	
		String s = Double.toString(d);
		
		int dec = 0;
		boolean count = false;
		
		// loops backwards until the decimal point
		for(int i = s.length() - 1; i > 0; i--) {
			if(s.charAt(i) == '.') break;
			
			// ignore irrelevant 0s
			if(!count && s.charAt(i) == '0') {}
			else count = true;
			
			if(count) dec++;
		}
		
		return dec;
	}
}
