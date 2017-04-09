package house;

import java.util.ArrayList;

import house.Garage;
import house.garage.Car;

public class Main {
	public static void main(String[] args) {
		int test;
		
		//populate garage
		ArrayList<Car> car = new ArrayList<>();
		car.add(new Car("Kia", "Forte Koup", 2010, "silver"));
		car.add(new Car("Chevrolet", "Corvette", 2013, "red"));
		car.add(new Car("Ford", "Mustang Cobra", 2014, "black"));
		car.add(new Car("Toyota", "Prius", 2010, "white"));
		
		System.out.println("Your garage: " + car);
		
		Garage garage = new Garage(car);
		do {
			garage.chooseCar();
			test = garage.chooseActivity();
		} while (test != 1);

	}
	
	
}
