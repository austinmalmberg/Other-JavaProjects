package ap.inventory;

import java.math.BigDecimal;

public class Asset {
	
	String description;
	
	String dPurchased;
	String seller;
	BigDecimal purchasePrice;
	
	String dSold;
	String buyer;
	double salePrice;
	
	public Asset(String description, String dPurchased, String seller, double purchasePrice) {
		this.description = description;
		this.dPurchased = dPurchased;
		this.seller = seller;
		this.purchasePrice = new BigDecimal(purchasePrice).setScale(2, BigDecimal.ROUND_HALF_EVEN);
		
		dSold = "";
		buyer = "";
		salePrice = 0.0;
	}
	
	public String getDescription() {
		return description;
	}
	public String getSeller() {
		return seller;
	}
	public BigDecimal getPurchasePrice() {
		return purchasePrice;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = new BigDecimal(purchasePrice).setScale(2, BigDecimal.ROUND_HALF_EVEN);
	}
	
	public String toString() {
		return description;
	}
}
