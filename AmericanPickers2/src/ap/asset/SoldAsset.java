package ap.asset;
import ap.person.Buyer;


public class SoldAsset extends Asset {
	
	private double salePrice;
	private double profit;
	private Buyer buyer;

	public SoldAsset(String description, double purchasePrice) {
		super(description, purchasePrice);
	}
	public SoldAsset(String description, double purchasePrice, double salePrice, Buyer buyer) {
		super(description, purchasePrice);
		
		this.salePrice = salePrice;
		calculateProfit();
		this.buyer = buyer;
	}
	
	// getters
	public double getSalePrice() {
		return salePrice;
	}
	public double getProfit() {
		return profit;
	}
	public Buyer getBuyer() {
		return buyer;
	}
	
	// setters
	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
		calculateProfit();
	}
	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}
	
	public void showDetails() {
		System.out.printf("Description: %,.2f%n", description);
		System.out.printf("Buyer: %,.2f%n", buyer.getName());
		System.out.printf("Purchase Price: %,.2f%n", purchasePrice);
		System.out.printf("Sale Price: %,.2f%n" + salePrice);
		System.out.printf("Profit: %,.2f%n", profit);
	}
	
	private void calculateProfit() {
		profit = salePrice - purchasePrice;
	}
	
}
