import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter a number:  ");
		int num = sc.nextInt();
		sc.close();
		
		testInt(num);
	}

	public static void testInt(int i) {
		if (i % 2 == 0) {
			System.out.println("The number you entered is even!");
		} else {
			System.out.println("The number you entered is odd!");
		}
		
	}
}


