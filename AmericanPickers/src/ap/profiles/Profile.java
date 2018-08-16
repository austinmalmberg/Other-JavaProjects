package ap.profiles;

import java.io.Serializable;

import ap.inventory.Inventory;
import ap.people.Person;

/**
 * Contains profile ID, user's name, and inventory.
 * 
 * @author Austin Malmberg
 *
 */
public class Profile implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private Person person;
	
	public Inventory inventory;
	
	public Profile (String id, Person person, Inventory inventory) {
		this.id = id;
		this.person = person;
		this.inventory = inventory;
	}
	
	/**
	 * @return Returns Profile ID.
	 */
	public String getID() {
		return id;
	}
	/**
	 * @return Returns Profile name.
	 */
	public String getName() {
		return person.getFirstName() + " " + person.getLastName();
	}
	/**
	 * @return Returns Profile inventory.
	 */
	public Inventory getInventory() {
		return inventory;
	}
	
	/**
	 * Sets Profile ID.
	 * @param id 
	 */
	public void setID (String id) {
		this.id = id;
	}
	/**
	 * Sets the first name of the Profile.
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		person.setFirstName(firstName);
	}
	/**
	 * Sets the last name of the Profile.
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		person.setLastName(lastName);
	}
	/**
	 * Sets the inventory for the Profile.
	 * @param inventory
	 */
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
}
