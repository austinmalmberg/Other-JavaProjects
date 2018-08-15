import java.util.ArrayList;
import java.util.Comparator;

public class Main {
	
	public static final double GRAMS_PER_POUND = 453.592;
	
	public static ArrayList<Protein> proteins = new ArrayList<>();
	
	public static void main(String[] args) {
		
		addProteinBrands();
		
		proteins.stream().sorted(new Comparator<Protein>() {
				@Override
				public int compare(Protein b1, Protein b2) {
					if(b1.truePricePerPound() == b2.truePricePerPound())
						return 0;
					
					if(b1.truePricePerPound() > b2.truePricePerPound())
						return 1;
					
					return -1;
				}
			}).forEach(System.out::println);
	}
	
	public static void addProteinBrands() {
		proteins.add(new Protein("Optimum Nutrition, Extreme Milk Chocolate, 5lb", 53.99, 24, 32, 71));
		proteins.add(new Protein("MusclePharm Combat, Vanilla, 4lb", 31.25, 25, 33.6, 54));
		proteins.add(new Protein("MusclePharm Combat, Chocolate Milk, 10lb", 85.94, 25, 34.9, 129));
		proteins.add(new Protein("Isopure Zero Carb, Creamy Vanilla, 3lb", 37.99, 25, 31, 44));
		proteins.add(new Protein("Isopure Low Carb, Dutch Chocolate, 4.5lb", 59.39, 25, 33, 62));
		proteins.add(new Protein("Isopure Low Carb, Dutch Chocolate, 7.5lb", 90.86, 25, 33, 104));
		proteins.add(new Protein("MuscleTech Phase8, Milk Chocolate, 4.6lb", 32.24, 26, 42, 50));
		proteins.add(new Protein("BPI Sports ISO HD, Vanilla Cookie, 4.9lb", 54.99, 25, 32, 70));
		proteins.add(new Protein("ALLMAX ISOFLEX, Peanut Butter Chocolate, 5lb", 70.95, 27, 30, 75));
		proteins.add(new Protein("MuscleTech Nitrotech, Milk Chocolate, 10lb", 80.69, 30, 44, 103));
		proteins.add(new Protein("MuscleTech Nitrotech, Milk Chocolate, 5lb", 34.12, 30, 46, 40));
		proteins.add(new Protein("Dymatize ISO 100, Gourmet Chocolate, 5lb", 63.59, 25, 32, 71));
		proteins.add(new Protein("Promix Grass Fed, Unflavored, 5lb", 79.99, 25, 30, 76));
		proteins.add(new Protein("MusclePharm 100% Whey Isolate, Chocolate Milk, 5lb", 73.34, 24, 27, 84));
		proteins.add(new Protein("MusclePharm 100% Whey Protein, Chocolate Milk, 5lb", 38.60, 25, 33, 68));
		proteins.add(new Protein("Muscle Feast 100% Grass Fed Whey, Chocolate, 5lb", 50.34, 19.1, 25, 90));
	}
}

class Protein {

	String name;
	double price;
	double proteinPerServing;
	double gramsPerServing;
	int servingsPerContainer;
	
	public Protein(String name, double price, double proteinPerServing, double gramsPerServing, int servingsPerContainer) {
		this.name = name;
		this.price = price;
		this.proteinPerServing = proteinPerServing;
		this.gramsPerServing = gramsPerServing;
		this.servingsPerContainer = servingsPerContainer;	
	}
	
	public double percentProtein() {
		return proteinPerServing / gramsPerServing * 100;
	}
	
	/**
	 * Price per pound of protein (does not account for filler ingredients)
	 * 
	 * @return
	 */
	public double truePricePerPound() {
		return price / (proteinPerServing * servingsPerContainer / Main.GRAMS_PER_POUND);
	}
	
	@Override
	public String toString() {
		return String.format("%s ($%.2f)--%n    True price per pound: $%.2f (%.1f%% protein per scoop)%n", 
				name, price, truePricePerPound(), percentProtein());
	}
	
}
