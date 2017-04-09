package ap.people.contacts;

import java.util.ArrayList;

/**
 * A class containing an ArrayList of contacts which is manipulated by ContactManager.  Implements Serializable so this class can be written to a file.
 * 
 * @author Austin Malmberg
 *
 */
public class AddressBook implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	
	protected ArrayList<Contact> contacts;
	
	public AddressBook() {
		contacts = new ArrayList<Contact>();
	}
}
