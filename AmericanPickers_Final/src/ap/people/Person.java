package ap.people;

/**
 * Stores information about a person.
 * @author Austin Malmberg
 *
 */
public class Person implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private String firstName;
	private String lastName;
	
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	
	public void setFirstName(String s) {
		firstName = s;
	}
	public void setLastName(String s) {
		lastName = s;
	}
	
	@Override
	public String toString() {
		return firstName + " " + lastName;
	}
}
