package ap.inventory;

public class Asset {
	
	private String description;
	
	private String datePurchased;
	private double purchasePrice;
	private String seller;
	
	private String dateSold;
	private double salePrice;
	private String buyer;
	
	private double profit;
	
	public Asset(String description, double purchasePrice, String seller) {
		this.description = description;
		this.purchasePrice = purchasePrice;
		this.seller = seller;
	}
	
	public String toString() {
		return description;
	}
}
