package ap.person;

public class Buyer extends Person {

	private String company;
	
	public Buyer(String firstName, String lastName) {
		super(firstName, lastName);
	}
	public Buyer(String firstName, String lastName, String company) {
		super(firstName, lastName);
		
		this.company = company;
	}
	
	// getters and setters
	public String getCompany() {
		return company;
	}
	
	public void setCompany(String company) {
		this.company = company;
	}
}
