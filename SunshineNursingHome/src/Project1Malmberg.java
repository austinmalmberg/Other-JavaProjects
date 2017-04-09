import java.util.Scanner;
/**
 * 
 * This program was created by Austin Malmberg.
 *
 */
public class Project1Malmberg {

	public static void main(String[] args) {
		//declare and initialize variables
		int totalRooms = 0;
		int occupiedRooms = 0;
		int vacantRooms = 0;
		double occupancyRate = 0;

		//create new scanner object
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the total number of rooms in the nursing home:  ");
		totalRooms = sc.nextInt();  //initialize totalRooms based on user input
		
		System.out.print("Enter the number of occupied rooms in the nursing home:  ");
		occupiedRooms = sc.nextInt();  //initialize occupiedRooms based on user input
		
		vacantRooms = totalRooms - occupiedRooms;  //calculate the value of vacantRooms
		occupancyRate = ((double)occupiedRooms / (double)totalRooms) * 100;  //calculate the value of occupancyRate
		
		//output data
		System.out.println();
		System.out.println("Number of rooms:  " + totalRooms);
		System.out.println("Number of occupied rooms:  " + occupiedRooms);
		System.out.println("Number of vaccant rooms:  " + vacantRooms);
		System.out.printf("Occupancy rate:  %.1f%%", occupancyRate);
	}
}
