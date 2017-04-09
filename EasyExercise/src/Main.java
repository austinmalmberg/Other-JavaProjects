
public class Main {
	public static void main(String[] args) {
		Author malmberga = new Author ("Austin Malmberg", "here@there.com", 'M');
		
		Book b1 = new Book("Java!", malmberga, 19.95, 1000);
		Book b2 = new Book("Java 2!", new Author("Bill Gates", "bill@thegates.com", 'M'), 29.95, 888);
		
		System.out.println(b1.toString());
		System.out.println(b2.toString());
	}
}
