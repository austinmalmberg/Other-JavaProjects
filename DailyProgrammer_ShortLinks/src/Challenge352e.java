
/**
 * Notes: uses recursion
 * 
 * https://www.reddit.com/r/dailyprogrammer/comments/7yyt8e/20180220_challenge_352_easy_making_imgurstyle/
 * 
 * @author Austin Malmberg
 * @date March 14, 2018
 */
public class Challenge352e {

	public static void main(String[] args) {
		final String[] CHALLENGE_INPUT = {
				"15674",
				"7026425611433322325",
				"187621",				
				"237860461",
				"2187521",
				"18752"
		};
		
		ShortLink sl = new ShortLink();
		
		for(String s : CHALLENGE_INPUT) {
			String converted = sl.convert(Long.parseLong(s));
			
			System.out.printf("%s --> %s --> %s%n", s, converted, sl.decode(converted) );
		}		
	}
}

class ShortLink {
	
	private final String ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public ShortLink() { }
	
	public String convert(long l) {
		/*	-----Convert to base 62-----
		 * 
		 *	187621/ 62	= 	3026 R9 ->	9	
		 *  3026  / 62 	= 	48 R50	->	O
		 * 	48    / 62 	= 	R48 	->	M
		 */
		
		return l == 0 ? "" : 
			ALPHABET.charAt((int) (l % ALPHABET.length()))
				+ convert(l / ALPHABET.length());
	}
	
	public String decode(String s) {	
		return String.valueOf(
				decode_recursion(new StringBuilder(s).reverse().toString()));
	}
	
	private long decode_recursion(String s) {
		return (long) (s.isEmpty() ? 0 : 
			ALPHABET.indexOf(s.charAt(0)) * Math.pow(ALPHABET.length(), s.length() - 1)
				+ decode_recursion(s.substring(1)));
	}
}