package ap.people.contacts;

import ap.people.Person;

/**
 * Extends the Person class.  Contains additional contact information.
 * 
 * @author Austin Malmberg
 *
 */
public class Contact extends Person {
	private static final long serialVersionUID = 1L;
	
	private String city;
	private String state;
	
	private String phoneNumber;
	
	public Contact (String firstName, String lastName, String phoneNumber, String city, String state) {
		super(firstName, lastName);
		
		this.phoneNumber = phoneNumber;
		this.city = city;
		this.state = state;
	}
	
	public String getLocation() {
		return city + " " + state;
	}
	
	public void setCity(String s) {
		city = s;
	}
	public void setState(String s) {
		state = s;
	}
	
	public String toString() {
		return super.toString() + ", " + city + " " + state + "  " + phoneNumber;
	}
}
