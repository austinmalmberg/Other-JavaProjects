package ap.inventory;

import java.util.ArrayList;

public class Inventory implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	
	protected ArrayList<Asset> assets;
	protected ArrayList<Asset> sold;
	
	public Inventory() {
		assets = new ArrayList<Asset>();
		sold = new ArrayList<Asset>();
	}
}
