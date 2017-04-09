package ap;

import ap.inventory.InventoryManager;
import ap.people.contacts.ContactManager;
import ap.profiles.ProfileManager;

/**
 * Tracks inventory, both current and sold, for multiple users.
 * Also maintains a shared address book of previous buyers and sellers for all users.
 * 
 * @author Austin Malmberg
 *
 */
public class AmericanPickers implements Runnable {

	private InputHelper input;
	
	private ProfileManager pm;
	private InventoryManager im;
	private ContactManager cm;
	
	public boolean running; 
	
	public AmericanPickers() {
		input = new InputHelper();
		
		pm = new ProfileManager();
		im = new InventoryManager();
		cm = new ContactManager();
		
		running = true;
	}
	
	/**
	 * Overridden method implemented from Runnable
	 */
	public void run() {
		pm.loadProfiles();  // load profiles	
		cm.loadAddressBook();  // load contacts
		
		System.out.println("\nWelcome to American Pickers Inventory Manager!");
		
		while (running) {
			
			login();
			
			im.mainMenu(); // loops until logout
			
			ap.profiles.Profile p = im.getProfile();
			pm.saveProfileToFile(p); // save to file
			
			cm.saveAddressBook(); // save address book
			
			// clears profile information from inventory manager
			im.clear();
		}
	}

	/**
	 * Loops while login ID is unrecognized.  Provides additional options to create new profile or exit.
	 */
	private void login() {
		String id;
		boolean unrecognizedID = true;
		
		while (unrecognizedID) {
			id = input.getString("\nEnter user ID to begin (enter 0 to add new user or X to exit): ");
			
			if (id.equals("0")) { // to create new profile
				String firstName = input.getString("Enter your first name: ");
				String lastName = input.getString("Enter your last name: ");
				
				pm.addNewProfile(new ap.people.Person(firstName, lastName));
			} else if (id.equalsIgnoreCase("x")) { // exit
				running = false;
				System.exit(0);	
			} else {
				if (pm.verifyID(id)) {  // if valid profile
					
					// load profile (containing the inventory data) into the inventory manager
					im.load(pm.getProfile(id), cm);
					
					unrecognizedID = false;  // break loop
				}
			}
		}
	}
}
