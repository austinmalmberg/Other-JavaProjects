package ap.inventory;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Inventory {
	
	public ArrayList<Asset> assets;
	public ArrayList<Asset> sold;
	
	public Inventory() {
		assets = new ArrayList<Asset>();
		
		assets.add(new Asset("1999 Ford Escort", "03/15/13", "John Doe", 1300.87));
	}
	
	public void addAsset() {
		assets.add(new Asset("1999 Ford Escort", "03/15/13", "John Doe", 1300.04));
	}
	
	public int getAssetCount() {
		return assets.size();
	}
	
	public BigDecimal getTotalAssetValue() {
		BigDecimal total = new BigDecimal(0.00).setScale(2, BigDecimal.ROUND_HALF_UP);
		
		for (int i = 0; i < assets.size(); i++) {
			total = total.add(assets.get(i).getPurchasePrice());
		}
		
		return total;
	}
}
