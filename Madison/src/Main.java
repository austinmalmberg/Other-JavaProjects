import java.util.Scanner;


public class Main {
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		
		int weight;
		int boardingDays;
		
		String grooming;
		int groomingPrice = 0;
		
		System.out.println("Madison Kennel & Grooming\n");
		
		System.out.print("Enter the dog's weight in pounds:  ");
		weight = sc.nextInt();  //get weight
		
		System.out.print("Enter the number of boarding days:  ");
		boardingDays = sc.nextInt();  //get days boarding
		
		sc.nextLine();  //does nothing functionally, included to advance the scanner to the next line
		do {
			System.out.print("Would you like a grooming service?  Enter Y for Yes and N for No:  ");
			grooming = sc.nextLine();  //get grooming choice
			
			if (grooming.equalsIgnoreCase("y")) {  //if grooming is yes, give options
				groomingPrice = groomingPrice(sc);
			}
			
			if (grooming.equalsIgnoreCase("y") || grooming.equalsIgnoreCase("n")) {  //display message if not "y" or "n"
				break;  // break loop if "y" or "n"
			} else {
				System.out.println("Invalid choice.");
			}
		} while (true);  //continuous loop.  breaks only if grooming is "y" or "n"
		
		checkout(weight, boardingDays, groomingPrice);
	}
	
	public static int groomingPrice(Scanner sc) {
		int choice = 0;
		
		System.out.println("\nSelect a grooming option:\n");
		System.out.println("1. Standard Grooming Package:\n   back, haircut and spritz - $45.00");
		System.out.println("2. Deluxe Grooming Package:\n   Standard Grooming plus nail trim: $55.00");
		System.out.println("3. Premium Grooming Package:\n   Standard and Deluxe Grooming plus ear and teeth cleaning: $70.00\n");
		
		do {
			System.out.print("Your choice:  ");
			choice = sc.nextInt();
			if (choice < 1 || choice > 3) {
				System.out.println("Invalid choice.");
			}
		} while(choice < 1 || choice > 3);  // loop if not 1, 2, or 3

		switch (choice) {
		case 1:
			return 45;  //standard
		case 2:
			return 55;  //deluxe
		case 3:
			return 70;  //premium
		default:
			return 0;  //should never be called
		}
	}
	
	public static void checkout(int weight, int boardingDays, int groomingPrice) {
		double pricePerDay = 10;  //
		double tax = 0.06;
		
		double boardingTotal = pricePerDay * boardingDays;
		double total = (boardingTotal + groomingPrice) * (1 + tax);
		
		System.out.println("\nMadison Kennel & Grooming\n");
		System.out.println("The dog's weight:  " + weight + " pounds");
		System.out.println("The number of boarding days:  " + boardingDays + " day(s)");
		System.out.println("Tax:  $" + ((boardingTotal + groomingPrice) * tax));
		if (groomingPrice > 0) {
			System.out.print("Total service (plus grooming and tax):  $");
		} else {
			System.out.print("Total service (plus tax):  $");
		}
		System.out.println(total);
	}
}
