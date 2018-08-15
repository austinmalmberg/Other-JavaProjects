import java.util.Arrays;
import java.util.Scanner;

// https://coderbyte.com/information/Kaprekars%20Constant

public class Main {
	
	static final int KAPREKARS_CONSTANT = 6174;
	static IntSort sort;

	public static int KaprekarsConstant(int num) {	
		sort = new IntSort();
		return countUntilRepetition(0, num);
	}
	
	public static int countUntilRepetition(int prev, int curr) {
		if(curr == KAPREKARS_CONSTANT) return 0;
		
		int asc = sort.ascending(curr);
		int desc = sort.descending(curr);
		
		System.out.printf("%d - %d = %d%n", desc, asc, desc - asc);
		
		return 1 + countUntilRepetition(curr, desc - asc);
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println(KaprekarsConstant(Integer.parseInt(s.nextLine())));
	}
}

class IntSort {
	
	public IntSort() { }
	
	/* PUBLIC METHODS */
	
	public int sorted(int num, boolean ascending) {
		int[] arr = numToArray(num);
		int[] sortedArr = ascending ? ascendingAsArr(arr) : descendingAsArr(arr);
		
		return arrayToNum(sortedArr);
	}
	
	public int ascending(int num) { 
		return sorted(num, true);
	}
	
	public int descending(int num) { 
		return sorted(num, false);
	}
	
	/* PRIVATE METHODS */
	
	private int[] numToArray(int num) {
		String numStr = String.valueOf(num); 
		int[] numArr = new int[4];
		
		for(int i = 0; i < numStr.length(); i++) {
			numArr[numArr.length-1 - i] = Integer.parseInt(numStr.charAt(numStr.length()-1 - i) + "");
		}
		
		return numArr;
	}
	
	private int arrayToNum(int[] numArr) {
		String numStr = "";
		for(int i = 0; i < numArr.length; i++) {
			numStr += numArr[i];
		}
		
		return Integer.valueOf(numStr);
	}
	
	private int[] ascendingAsArr(int[] arr) {
		Arrays.sort(arr);
		
		return arr;
	}
	
	private int[] descendingAsArr(int[] arr) {
		Arrays.sort(arr);
		
		int[] out = new int[arr.length];
		
		// reverse the array
		int shift = arr.length-1;
		for(int i = 0; i < arr.length; i++) {
			out[i] = arr[shift - i];
		}
		
		return out;
	}
}
