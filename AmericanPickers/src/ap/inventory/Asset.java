package ap.inventory;

import ap.people.contacts.Contact;

/**
 * Contains asset information.
 * 
 * @author Austin Malmberg
 *
 */
public class Asset implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	

	private String description;
	
	private double purchasePrice;
	private String datePurchased;
	private Contact seller;
	
	private double salePrice;
	private String dateSold;
	private Contact buyer;
	private double profit;
	
	public Asset(String description, String datePurchased, double purchasePrice, Contact seller) {
		this.description = description;
		this.datePurchased = datePurchased;
		this.purchasePrice = purchasePrice;
		this.seller = seller;
	}
	
	public String getDescription() {
		return description;
	}
	public double getPurchasePrice() {
		return purchasePrice;
	}
	public String getDatePurchased() {
		return datePurchased;
	}
	public Contact getSeller() {
		return seller;
	}
	public double getSalePrice() {
		return salePrice;
	}
	public String getDateSold() {
		return dateSold;
	}
	public Contact getBuyer() {
		return buyer;
	}
	public double getProfit() {
		return profit;
	}

	public void setDescription(String s) {
		this.description = s;
	}
	public void setPurchasePrice(double d) {
		this.purchasePrice = d;
	}
	public void setDatePurchased(String date) {
		this.datePurchased = date;
	}
	public void setSeller(Contact c) {
		this.seller = c;
	}
	public void setSalePrice(double d) {
		this.salePrice = d;
		profit = salePrice - purchasePrice;
	}
	public void setDateSold(String s) {
		this.dateSold = s;
	}
	public void setBuyer(Contact c) {
		this.buyer = c;
	}
	
	public void printDetails() {
		System.out.println("Description: " + description);
		System.out.println("Date Purchased: " + datePurchased);
		System.out.println("Seller: " + seller.toString());
		System.out.printf("Purchase Price: $%,.2f%n", purchasePrice);
		
		if(dateSold != null) { // if date sold is not empty, display sale information
			System.out.println();
			System.out.println("Date Sold: " + dateSold);
			System.out.printf("Sale Price: $%,.2f%n", salePrice);
			System.out.println("Buyer: " + buyer.toString());
			System.out.println();
			System.out.printf("Profit: $%,.2f%n", profit);
		}
	}
}
