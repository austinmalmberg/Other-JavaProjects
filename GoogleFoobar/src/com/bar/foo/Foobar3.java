import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Foobar3 {
	public static void main(String[] args) {
		
		int[] arr1 = {3, 1, 4, 1};
		int[] arr2 = {3, 1, 4, 1, 5, 9};
		int[] arr3 = {0, 1, 2, 3};
		
		answer(arr3);
		
//		System.out.println( answer(arr1));
//		System.out.println( answer(arr2));
	}
	
	public static int answer(int[] arr) {
		
		for(int length = arr.length; length > 0; length--) {
			for(int[] a : combinations(arr, length)) {
				System.out.println(Arrays.toString(a));
//				if( elementSumDivisibleBy3(a) )
//					return getLargestNumber(a);
			}
		}
		
		return 0;
	}
	
	public static List<int[]> combinations(int[] arr, int length) {
		List<int[]> combinations = new ArrayList<>();
		
		/**
		 * {0, 1, 2, 3, 4}
		 * 0 1 2
		 * 0 1 3
		 * 0 2 3
		 * 1 2 3
		 */
		
		int[] combo = new int[length];
		
		for(int i = 0; i < arr.length - combo.length+1; i++) {
			
			int end = i + length == arr.length ? i+length : i+length+1;
			int[] sub = Arrays.copyOfRange(arr, i, end);
			
			if(sub.length == length) {
				combinations.add(sub);
			} else {
				
				for(int j = sub.length-1; j > 0; j--) {
					combinations.add( subArrayExcluded(sub, j));
				}
			}
		}
		
		return combinations;
		
	}
	
	public static int[] subArrayExcluded(int[] arr, int exclude) {
		int[] sub = new int[arr.length-1];
		int sub_index = 0;
		
		for (int i = 0; i < arr.length; i++) {
			
			if(i != exclude) {
				sub[sub_index++] = arr[i];
			}
		}
		
		return sub;
	}
	
	public static int getLargestNumber(int[] arr) {
		// sort arr from largest to smallest
		
		// concatenate to string
		
		// return number
		return 0;
	}
	
	public static boolean elementSumDivisibleBy3(int[] a) {
		int sum = 0;
		for(int i : a) {
			sum += i;
		}
		
		return sum % 3 == 0;
	}
}