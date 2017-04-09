package ap.person;

public class Picker extends Person {
	
	private String id;

	public Picker(String firstName, String lastName) {
		super(firstName, lastName);
	}
	public Picker(String firstName, String lastName, String id) {
		super(firstName, lastName);
		
		this.id = id;
	}
	
	// getters and setters
	public String getID() {
		return id;
	}
	
	public void setID(String id) {
		this.id = id;
	}

	
}
