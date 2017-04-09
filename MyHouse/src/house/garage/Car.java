package house.garage;

public class Car {
	private String make;
	private String model;
	private int year;
	private String color;
	
	public Car(){} //not used
	
	public Car(String make, String model, int year, String color) {
		this.make = make;
		this.model = model;
		this.year = year;
		this.color = color;
	}
	
	public String toString() {
		return color + " " + year + " " + make + " " + model;
	}
	
	public void start(){
		System.out.println("\nVroom vroom...");
	}
}
