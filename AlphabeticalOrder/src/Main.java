
public class Main {
	public static void main(String[] args) {
		String words = "billowy biopsy chinos defaced chintz sponged bijoux abhors fiddle begins chimps wronged";
		
		for(String word : words.split("\\s+")) {
			System.out.println(testOrder(word));
		}
	}
	
	public static String testOrder(String word) {		
		if(sorted(word)) return word + " IN ORDER";
		if(sorted(new StringBuilder(word).reverse().toString())) return word + " REVERSE ORDER";
		
		return word + " NOT IN ORDER";
	}
	
	private static boolean sorted(String word) {
		int charVal = 97;  // ascii value for 'a'
		
		for(char c : word.toLowerCase().toCharArray()) {
			if((int)c >= charVal) {
				charVal = (int)c;
			} else {
				return false;
			}
		}
		
		return true;
	}
}
