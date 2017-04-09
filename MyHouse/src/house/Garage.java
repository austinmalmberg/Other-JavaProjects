package house;

import java.util.ArrayList;

import helpers.SimplePrompt;
import house.garage.Car;

public class Garage {
	SimplePrompt sp = new SimplePrompt();
	ArrayList<Car> car = new ArrayList<>();
	
	private int choice1;
	private int choice2;
	
	public Garage(ArrayList<Car> car) {
		this.car = car;
	}

	public void chooseCar() {
		int choice = 0;
		String strChoice = sp.getInput("\nPick a garage number (1-" + car.size() +"):  ");
		
		switch (strChoice) {
		case "1": case "2": case "3": case "4":
			choice = Integer.parseInt(strChoice) - 1;
			System.out.println("You picked the " + car.get(choice) + ".");
			this.choice1 = choice;
			break;
		default:
			System.out.println("Invalid choice.  Try again.");
			chooseCar();
			break;
		}
	}
	
	public int chooseActivity() {
		String newMake = null;
		String newModel = null;
		int newYear = 0;
		String color = null;

		System.out.println("\n1 - Swap out cars");
		System.out.println("2 - Take for a spin ");
		String strChoice = sp.getInput("\nChoose:  ");

		switch (strChoice) {
		case "1": case "2":
			this.choice2 = Integer.parseInt(strChoice); //convert strChoice to integer value
			switch (choice2) {
			case 1:
				//get info on new car
				System.out.println("\n");
				
				try {
					newMake = sp.getInput("Enter new make:  ");
					newModel = sp.getInput("Enter new model:  ");
					newYear = Integer.parseInt(sp.getInput("Enter new year:  "));
					color = sp.getInput("Enter the color:  ");
				} catch (Exception e) {
					System.out.println("Invalid information.  You can't do anything right.");
					return -1;
				}

				car.set(choice1, new Car(newMake, newModel, newYear, color));
				System.out.println("\nYour updated garage: " + car);

				return 1;
			case 2:
				//drive away
				Car choiceCar = new Car();
				choiceCar.start();
				System.out.println("You drive off into the sunset in your " + car.get(choice1) + ".");

				return 0;
			}
		default:
			System.out.println("\nThat's not a valid option.  Looks like you're walking...");
			return -1;
		}
	}
}
