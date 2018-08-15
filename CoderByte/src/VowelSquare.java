import java.util.Scanner;

public class VowelSquare {

	public static final int SQUARE_SIZE = 2;
	public static final String VOWELS = "aeiou";
	
	public static String VowelSquare(String[] strArr) { 
		
		for(int row = 0; row <= strArr.length - SQUARE_SIZE; row++) {
			
			for(int col = 0; col <= strArr[row].length() - SQUARE_SIZE; col++) {
				
				if(isVowelSquare(strArr, row, col))
					return String.format("%d-%d%n", row, col);
			}
		}
		  
		return "not found";
	}
	
	public static boolean isVowelSquare(String[] arr, int startRow, int startCol) {
		for(int i = 0; i < SQUARE_SIZE; i++) {
			
			for(int j = 0; j < SQUARE_SIZE; j++) {
				if(!isVowel(arr[startRow+i].charAt(startCol+j))) return false;
			}
		}
		
		return true;
	}
	
	public static boolean isVowel(char ch) {
		return VOWELS.contains(Character.toString(ch));
	}
	
	public static void main(String[] args) {
		// keep this function call here     
//		Scanner s = new Scanner(System.in);
//	    System.out.print(VowelSquare(s.nextLine()));
		
		System.out.println(VowelSquare(new String[]{"aqrst", "ukaei", "ffooo"}));
	}

}
