
public class Book {
	private String title;
	private Author author;
	private double price;
	private int qtyInStock;
	
	public Book(String title, Author author, double price) {
		this.title = title;
		this.author = author;
		this.price = price;
	}
	
	public Book(String name, Author author, double price, int qtyInStock) {
		this.title = name;
		this.author = author;
		this.price = price;
		this.qtyInStock = qtyInStock;
	}

	public String getName() {
		return title;
	}
	
	public Author getAuthor() {
		return author;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public int getQtyInStock() {
		return qtyInStock;
	}
	public void setQtyInStock(int qtyInStock) {
		this.qtyInStock = qtyInStock;
	}
	
	public String toString() {
		return "\nBook: " + title + "\nAuthor information: " + author.toString() + "\nPrice: " + price + "\nIn Stock: " + qtyInStock; 
	}
}
