import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class QuestionsMarks {

	public static String QuestionsMarks(String str) {
		
//		String regex = "\\d{1}[^\\d]*\\d{1}";
//		
//		Pattern pattern = Pattern.compile(regex);
//		Matcher matcher = pattern.matcher(str);
//		
//		while(matcher.find()) {
//			System.out.printf("start: %d, end: %d%n", matcher.start(), matcher.end());
//		}
		
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < str.length(); i++) {
			if(Character.isDigit(str.charAt(i))) {
				map.put(i, Character.getNumericValue(str.charAt(i)));
			}
		}
		
		
		int[] indices = digitIndices(str);
		int[] digits = new int[indices.length];
		
		for(int i = 0; i < indices.length; i++) {
			digits[i] = Character.getNumericValue(str.charAt(indices[i]));
		}
		
		for(int i = 0; i < digits.length-1; i++) {
			if(digits[i] + digits[i+1] == 10 && countQuestionMarks(str.substring(indices[i], indices[i+1]+1)) == 3) {
				return "true";
			}
		}
		
		return Arrays.toString(digits);
	}
	
	public static int countQuestionMarks(String str) {
		return count("\\?", str);
	}
	
	public static int countDigits(String str) {
		return count("\\d", str);
	} 
	
	public static int count(String regex, String str) {
		return str.replaceAll("[^" + regex + "]", "").length();
	}
	
	public static int[] digitIndices(String str) {
		int[] indices = new int[countDigits(str)];
		
		int curr = 0;
		for(int i = 0; i < str.length(); i++) {
			if(Character.isDigit(str.charAt(i))) {
				indices[curr] = i;
				curr++;
			}
		}
		
		return indices;
	}
	
	public static void main (String[] args) {     
		Scanner s = new Scanner(System.in);
		System.out.print(QuestionsMarks(s.nextLine())); 
	}
}
