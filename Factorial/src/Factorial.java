import java.util.Scanner;

public class Factorial {

	public static int FirstFactorial(int num) {
		if(num < 1) return 0;
		if(num == 1) return 1;
		
		return num * FirstFactorial(--num);
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println(FirstFactorial(Integer.parseInt(s.nextLine())));
	}
}
