package ap.asset;

public class Asset {
	
	protected String description;
	protected double purchasePrice;
	
	public Asset() {}
	public Asset(String description, double purchasePrice) {
		this.description = description;
		this.purchasePrice = purchasePrice;
	}
	
	// getters
	public String getDesc() {
		return description;
	}
	public double getPurchasePrice() {
		return purchasePrice;
	}
	
	// setters
	public void setDesc(String description) {
		this.description = description;
	}
	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	
	public void showDetails() {
		System.out.println("Description: " + description);
		System.out.println("Purchase Price: " + purchasePrice);
	}
}
