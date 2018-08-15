package v1;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import helpers.FileImporter;

public class Main {
	
	public static List<Salesperson> salespersons;
	
	public static void main(String[] args) {
		
		final int ROW_SALESPERSONS = 1;
		final int ROW_REVENUE = ROW_SALESPERSONS+1;
		
		FileImporter fi = new FileImporter();
		String[][] unformattedFile = fi.getFileAs2DArray("Challenge1.txt", "\\s+");
		
		// populate agents
		salespersons = Stream.of(unformattedFile[ROW_SALESPERSONS])
				.map(name -> new Salesperson(name))
				.collect(Collectors.toList());
		
		// get revenue
		int row = ROW_REVENUE;
		String[] item = unformattedFile[row];
		while(!item[0].equals("Expenses")) {			
			for(int i = 1; i < item.length; i++) {
				Item it = new Item(item[0], Integer.parseInt(item[i]));
				salespersons.get(i-1).addItem(it);
			}
			
			item = unformattedFile[++row];
		}
		
		// get expenses
		for(int r = row+2; r < unformattedFile.length; r++) {
			item = unformattedFile[r];
			
			for(int i = 1; i < item.length; i++) {
				salespersons.get(i-1).items.get(item[0]).expenses(Integer.parseInt(item[i]));
			}
		}
		
		// print commission
		salespersons.forEach(person -> {
			System.out.printf("%s -- $%.2f%n", person.name, person.getCommission());
		});
	}
	
	public void printUnformatted2DArray(String[][] unformattedFile) {
		for(String[] s: unformattedFile) {
			System.out.println(Arrays.toString(s));
		}
	}
}

class Salesperson {
	
	public final double COMMISSION_RATE = 0.062;
	
	String name;
	Map<String, Item> items;
	
	public Salesperson(String name) {
		this.name = name;
		items = new HashMap<>();
	}
	
	public void addItem(Item it) {
		items.put(it.name, it);
	}
	
	public double getCommission() {		
		return COMMISSION_RATE * items.values().stream()
				.mapToDouble(item -> item.commissionableAmount())
				.sum();
	}
	
	@Override
	public String toString() { return name; }
}

class Item {
	
	String name;
	private int[] sales;
	
	public Item(String name, int revenue) {
		this(name, revenue, 0);
	}
	
	public Item(String name, int revenue, int expenses) {
		this.name = name;
		sales = new int[2];
		
		sales[0] = revenue;
		sales[1] = expenses;
	}
	
	public int revenue() { return sales[0]; }
	public int expenses() { return sales[1]; }
	
	public void revenue(int i) { sales[0] = i; }
	public void expenses(int i) { sales[1] = i; }
	
	public int commissionableAmount() {		
		if(expenses() >= revenue())
			return 0;
		
		return revenue() - expenses();
	}
}