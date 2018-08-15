import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// https://coderbyte.com/information/Maximal%20Square

public class Main {

	public static List<OneString> list;
	
	public static String MaximalSquare(String[] strArr) {
		
		list = new ArrayList<>();
		
		for(int x = 0; x < strArr.length; x++) {
			int consecutiveCounter = 0;
			for(int y = strArr[x].indexOf(1 + ""); y < strArr[x].length() && y != -1; y++) {
				if(strArr[x].charAt(y) == '1') {
					addAllConsecutiveOnes(new OneString(x, y-consecutiveCounter, ++consecutiveCounter));
				} else {
					consecutiveCounter = 0;
				}
			}
		}
		
		// sort by descending length
		Collections.sort(list);
		
		// test if square
		for(OneString potentialSquare : list) {
			
			if(completeSquare(potentialSquare, strArr)) {
				return String.valueOf(potentialSquare.length * potentialSquare.length);
			}
				 
		}
		
		return String.valueOf(0);
	}
	
	public static void addAllConsecutiveOnes(OneString ones) {
		/* Adds some consecutive one strings
		* For example, given "1111" the following consecutive ones will be added:
		* x=0, y=0, length=1
		* x=0, y=0, length=2
		* x=0, y=0, length=3
		* x=0, y=0, length=4
		* but consecutive ones such as x=0, y=1, length=3 will not be added.
		*/
		list.add(ones);
		
		// add remaining ones
		for(int i = 1; i < ones.length; i++) {
			list.add(new OneString(ones.starting_x, ones.starting_y+i, ones.length-i));
		}
		
	}
	
	public static boolean completeSquare(OneString o, String[] strArr) {
		// test out of bounds
		if(o.starting_x + o.length > strArr.length) return false;
		if(o.starting_y + o.length > strArr[o.starting_x + o.length - 1].length()) return false;
		
		for(int i = o.starting_x; i < o.starting_x + o.length; i++) {
			// test is square contains a 0
			if(strArr[i].substring(o.starting_y, o.starting_y + o.length).contains("0"))
				return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String[] input = s.nextLine().split("[\\s+]");
		System.out.println(MaximalSquare(input));
	}
}

class OneString implements Comparable<OneString> {
	
	int starting_x;
	int starting_y;
	int length;
	
	public OneString(int x, int y, int length) {
		this.starting_x = x;
		this.starting_y = y;
		this.length = length;
	}
	
	@Override
	public int compareTo(OneString o) {
		return o.length - length;
	}
	
	public String toString() {
		return String.format("(%d, %d) : length=%d", starting_x, starting_y, length);
	}
}
