import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter a number:  ");
		int num = sc.nextInt();
		sc.close();
		
		int last, current, previous;
		last = current = previous = 1;
		while (last <= num) {
			System.out.print(current + " ");
			current = previous + last;
			previous = last;
			last = current;	
		}
	}
}


