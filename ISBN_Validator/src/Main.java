
public class Main {
	public static void main(String[] args) {
		ISBN_Validator isbn = new ISBN_Validator();
		
		isbn.test("0-7475-3269-9");
	}
}

class ISBN_Validator {
	
	public ISBN_Validator() {}
	
	public void test(String s) {
		String validMsg = "\"" + s +"\" is a valid ISBN.";
		String invalidMsg = "\"" + s +"\" is NOT a valid ISBN.";
		
		String str = s.replaceAll("-", "").trim().toUpperCase();  // format string
		
		// test that the string has 10 digits with 0-9 for the first 9 digits then 0-9 OR X for the last digit
		if(str.matches("[0-9]{9}[0-9[X]]")) {
			System.out.println(verifyISBN(str) ? validMsg : invalidMsg);
		} else {
			System.out.println(invalidMsg);
		}
	}
	
	private boolean verifyISBN(String s) {		
		int sum = 0;
		
		for(int i = 0; i < s.length(); i++) {  // calculate
			if(i == s.length() - 1 && s.charAt(i) == 'X') {  // if X is the last digit
				sum += 10 * (s.length() - i);
			} else {
				sum += parse(s.charAt(i)) * (s.length() - i);
			}
		}
		
		return sum % 11 == 0 ? true : false;
	}
	
	private int parse(char c) {
		int i = 0;
		
		try {
			i = Integer.parseInt(""+c);
		} catch(NumberFormatException nfe) {
			System.out.println("Problem converting " + c + " to integer.");
		}
		
		return i;
	}
}
