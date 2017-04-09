package ap.inventory;

import java.util.Set;
import java.util.TreeSet;

public class Inventory {

	private Set<Asset> assets;
	private Set<Asset> sold;
	
	public Inventory() {
		assets = new TreeSet<>();
		sold = new TreeSet<>();
		
		assets.add(new Asset("test1 description", 200.00, "Joe Shmoe"));
		assets.add(new Asset("test2 description", 100.00, "Joe Doe"));
		
		sold.add(new Asset("test3 description", 20.00, "Joe Bloe"));
	}
}
