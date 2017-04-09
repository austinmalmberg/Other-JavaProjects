import java.util.Scanner;

public class Converter {
	public static void main(String[] args) {
		//declare variables
		Scanner sc = new Scanner(System.in);
		double fahrenheit;
		double celsius;
		
		//get temperature from user (in fahrenheit)
		System.out.print("Enter a temperature in Fahrenheit:  ");
		fahrenheit = sc.nextDouble();
		
		//calculate celsius
		celsius = (fahrenheit - 32) * 5/9;
		
		//print temperatures
		System.out.println("Fahrenheit:  " + fahrenheit);
		System.out.println("Celsius:  " + celsius);
	}
}
