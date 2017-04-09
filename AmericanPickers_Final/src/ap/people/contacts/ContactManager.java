package ap.people.contacts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import ap.InputHelper;

/**
 * Maintains the AddressBook class.
 * 
 * @author Austin Malmberg
 *
 */
public class ContactManager {
	
	private InputHelper input;
	
	private AddressBook ab;
	
	public ContactManager() {
		input = new InputHelper();
		
		ab = new AddressBook();
	}
	
	/**
	 * Searches through AddressBook entries.  If multiple entries contain the same name, lists the entries and allows the user to choose.
	 * Otherwise, allows user to add the contact to the address book.
	 * @param firstName First name of the contact.
	 * @param lastName Last name of the contact.
	 * @return
	 */
	public Contact find(String firstName, String lastName) {
		Contact tempContact;
		ArrayList<Contact> tempContacts = new ArrayList<Contact>();
		
		for(Contact c: ab.contacts) { // count how many entries have the same first and last name
			if(firstName.equalsIgnoreCase(c.getFirstName()) && lastName.equalsIgnoreCase(c.getLastName())) {
				tempContacts.add(c);
			}
		}
		
		if(tempContacts.size() == 0) { // if no customer entries exist with the same first & last name, add new contact
			System.out.println("Contact not found in the Address Book.");
			addNew(firstName, lastName);
			tempContact = ab.contacts.get(ab.contacts.size() - 1);  // return last entry
		} else {  // display list of customers for user to choose from
			int choice;
			
			System.out.println("\n----------SELECT CONTACT----------");
			System.out.println("0. Add New Contact");
			for(int i = 0; i < tempContacts.size(); i++) { // list customers with same name, let user select which
				System.out.println((i + 1) + ". " + tempContacts.get(i).toString());
			}
			
			choice = input.getInt("Select Contact: ", 0, tempContacts.size());
			
			if(choice == 0) {
				addNew(firstName, lastName);
				tempContact = ab.contacts.get(ab.contacts.size() - 1);  // return last entry
			} else {
				tempContact = tempContacts.get(choice - 1);
			}
		}
		
		tempContacts.clear();
		return tempContact;
	}
	
	/**
	 * Obtains contact inforamtion from the user.
	 * @param firstName First name of the contact.
	 * @param lastName Last name of the contact.
	 */
	private synchronized void addNew(String firstName, String lastName) {
		System.out.println("\n----------ADD NEW CONTACT (" + firstName + " " + lastName + ")----------");
		
		String phoneNumber = input.getString("Enter phone number (xxx)xxx-xxxx: ");
		String city = input.getString("Enter city: ");
		String state = input.getString("Enter state (XX): ");
		
		ab.contacts.add(new Contact(firstName, lastName, phoneNumber, city, state));
	}
	
	/**
	 * Lists contact in the AddressBook.
	 */
	public void displayAddressBook() {
		System.out.println("\n----------ADDRESS BOOK----------");
		
		if(ab.contacts.isEmpty()) {
			System.out.println("No contacts found.");
			return;
		}
		
		for(int i = 0; i < ab.contacts.size(); i++) {
			System.out.println((i+1) + ". " + ab.contacts.get(i).toString());
		}
	}
	
	/**
	 * Saves the AddressBook class to a file.
	 */
	public synchronized void saveAddressBook() {
		String fileName = "contacts.adb";
		
		try {
			ObjectOutputStream o_out = new ObjectOutputStream(new FileOutputStream(fileName, false));  // writes over any existing file
			try {
			o_out.writeObject(ab);
			System.out.println("Address Book saved as \"" + fileName + "\".");
			} finally {
				o_out.close();
			}
		} catch (Exception e) {
			System.out.println("There was a problem saving the Address Book.  Changes you made are probably lost. " + e.toString());
		}	
	}
	
	/**
	 * Loads the address book class from the same directory from where AmericanPickers program is ran.
	 */
	public synchronized void loadAddressBook() {		
		File folder = new File(System.getProperty("user.dir"));
		File[] fileList = folder.listFiles();
		
		if(fileList.length == 0) {  // if there are no files in the directory (this should never be the case)
			System.out.println("No files found in default directory.");
			return;
		}
		
		
		boolean fileFound = false;
		// add the filename to string arraylist
		for(File file: fileList) {
			if(file.getName().equals("contacts.adb")) {
				fileFound = true;
				
				try {					
					ObjectInputStream o_in = new ObjectInputStream(new FileInputStream(file.getName()));
					try {
					ab = (AddressBook) o_in.readObject();
					} finally {
						o_in.close();
					}
					System.out.println();
				} catch (Exception e) {
					System.out.print("Error loading Address Book \"" + file.getName() + "\".  " + e.toString());
				}
			}
		}
		
		if (fileFound) {
			System.out.println("Address Book imported successfully.");
		} else {
			System.out.println("No Address Book found.");
		}
	}

}
