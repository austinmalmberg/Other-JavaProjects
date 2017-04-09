import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		
		System.out.print("Enter a number:  ");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.close();
		
		for (int i = 0; i < num; i++) {
			
			for (int j = 0; j < i + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
