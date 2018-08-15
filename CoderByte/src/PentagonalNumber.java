import java.util.Scanner;

// https://coderbyte.com/information/Pentagonal%20Number

public class PentagonalNumber {

	public static int PentagonalNumber(int num) {
		if(num == 0) return 1;
		
		return (num-1) * 5 + PentagonalNumber(--num);
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println(PentagonalNumber(Integer.parseInt(s.nextLine())));
	}
}
