
public class Cipher {
	
	private char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
	   		   				   'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

	/**
	 * Empty constructor
	 */
	public Cipher() {}
	
	/**
	 * Loops through each char of the str and compares it with each letter in the alphabet.
	 * Once found, the char will be "encrypted" (based on its position in the alphabet) and
	 * added to a new string.  The string is printed along with the number of non-alphabetic
	 * characters that weren't printed.
	 * 
	 * @param str
	 */
	public void encrypt(String str) {		
		String encrypted = "";
		int notAlphabetic = 0;
		
		for (int i = 0; i < str.length(); i++) {  // loop through each char in str
			if (Character.isLetter(str.charAt(i))) {  //test if char is alphabetic
				for (int j = 0; j < alphabet.length; j++) {  // loop through each letter of the alphabet
					if (Character.toUpperCase(str.charAt(i)) == alphabet[j]) {  // compare letters
						encrypted += convertChar(str.charAt(i), j); // encrypt and add to final string
						break;  // break alphabet (inner) for loop
					}
				}
			} else {
				notAlphabetic++;  // tracks number of non-alphabetic characters
			}
		}
		
		System.out.print(str + " ==> " + encrypted);
		
		if (notAlphabetic > 0) {
			System.out.printf(" (%d non-alphabetic character(s) detected)%n", notAlphabetic);
		} else {
			System.out.println();
		}
		

	}
	
	/**
	 * Finds and returns the encrypted character after checking its case.
	 * 
	 * @param c original character
	 * @param i position of the original character in the alphabet
	 * @return encrypted character
	 */
	private char convertChar(char c, int i) {
		char newChar;
		
		// convert letter
		if (i <= (alphabet.length / 2) - 1) {
			newChar = alphabet[i + (alphabet.length / 2)];
		} else {
			newChar = alphabet[i % (alphabet.length / 2)];
		}
		
		// return char based on case of the original
		if (Character.isUpperCase(c)) {
			return Character.toUpperCase(newChar);
		} else {
			return Character.toLowerCase(newChar);
		}
	}
}
