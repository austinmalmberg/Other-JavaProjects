package ap.profiles;

public class Profile {

	String id;
	String firstName;
	String lastName;
	
	public Profile() {
		
	}
	public Profile(String id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getID() { return id; }
	public String getFirstName() { return firstName; }
	public String getLastName() { return lastName; }
	
	public void addProfile(String id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
}
