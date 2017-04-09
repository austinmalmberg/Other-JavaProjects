package ap.inventory;

import ap.InputHelper;
import ap.people.contacts.ContactManager;
import ap.people.contacts.Contact;
import ap.profiles.Profile;

/**
 * This class contains the user interface while also managing and manipulating inventory data.
 * 
 * @author Austin Malmberg
 *
 */
public class InventoryManager {

	private InputHelper input;
	
	private Profile p;
	private Inventory i;
	
	private ContactManager cm;
	
	public InventoryManager() {
		input = new InputHelper();
	}
	
	/**
	 * Loads profile and Address Book information into InventoryManager.
	 * @param p Profile
	 * @param cm ContactManager
	 */
	public void load(Profile p, ContactManager cm) {
		this.p = p;
		
		i = p.getInventory();
		
		this.cm = cm;
	}
	
	/**
	 * @return Returns Profile.
	 */
	public Profile getProfile() {
		return p;
	}
	
	/**
	 * Clears Profile and Inventory from InventoryManager.
	 */
	public void clear() {
		p = null;
		i = null;
	}
	
	/**
	 * Prompts user for new asset information and adds to user's inventory.
	 */
	private synchronized void addItemToInventory() {
		System.out.println("\n----------ADD ITEM----------");
		String description = input.getString("Enter description: ");
		String datePurchased = input.getDate("Enter purchase date (mm/dd/yy): ");
		double purchasePrice = input.getDouble("Enter purchase price: ", 0.0, 0.0); // non-negative, no max value
		
		// customer information
		String firstName = input.getString("Enter seller's first name: ");
		String lastName = input.getString("Enter seller's last name: ");
		Contact seller = cm.find(firstName, lastName);
		
		
		i.assets.add(new Asset(description, datePurchased, purchasePrice, seller));
		
		System.out.println("\n" + description + " added to inventory!");
	}
	
	/**
	 * Prompts user for sold asset information.  Removes the item from current inventory and adds it to sold inventory.
	 * @param index The index of the asset within the current inventory.
	 */
	private synchronized void saleItem(int index) {
		System.out.println("\n----------SALE ITEM----------");
		
		String dateSold = input.getDate("Enter sale date: ");
		double salePrice = input.getDouble("Enter sale price: ", 0.0, 0.0);
		
		String firstName = input.getString("Enter buyer's first name: ");
		String lastName = input.getString("Enter buyer's last name: ");
		Contact buyer = cm.find(firstName, lastName);
		
		// set sale information
		i.assets.get(index).setDateSold(dateSold);
		i.assets.get(index).setSalePrice(salePrice);
		i.assets.get(index).setBuyer(buyer);
		
		// move asset to sold arraylist
		Asset soldItem = i.assets.remove(index);
		i.sold.add(soldItem);
		
		System.out.printf("%n%s sold.  You profitted $%,.2f!%n", soldItem.getDescription(), soldItem.getProfit());
	}
	
	// MENUS
	
	// main menu layout
		// "0" to logout
		// "1" to add item
		// "2" view current inventory
			// "0" to go back to main menu
			// "1" add new item
			// "2"list number to view details
				// sale item
		// "3" view sold items list
			// "0" to go back to main menu
			// list number to view details
		// "4" view address book
	
	/**
	 * Gives user menu options to manipulate current and sold inventory.
	 */
	public void mainMenu() {		
		String[] options = {"Logout", "Add Item to Current Inventory", "View Current Inventory",
				"View Sold Items", "View Address Book"};
		int choice;
		
		do {
			System.out.println("\n----------MAIN MENU----------");
			for (int i = 0; i < options.length; i++) { // display menu options
				System.out.println(i + ". " + options[i]);
			}
			
			choice = input.getInt("Your choice: ", 0, options.length - 1);
			switch (choice) {
			case 0: // logout
				return;  // exits method
			case 1: // add item to current inventory
				addItemToInventory();
				break;
			case 2: // view current inventory
				currentInventoryMenu();
				break;
			case 3: // view sold item list
				soldInventoryMenu();
				break;
			case 4:
				cm.displayAddressBook();
				break;
			default: // should never be called
				System.out.println("Error in InventoryManager.mainMenu()");
				break;
			}
		} while(choice != 0);
	}
	
	/**
	 * Lists current inventory.
	 */
	private void currentInventoryMenu() {		
		System.out.println("\n----------CURRENT INVENTORY----------");
		
		if(i.assets.isEmpty()) {
			System.out.println("You have no items in this inventory.");
			return;
		}
		
		int counter = 1;
		double totalValue = 0.0;
		for (Asset a: i.assets) { // list current inventory
			System.out.println(counter + ". " + a.getDescription());
			totalValue += a.getPurchasePrice();
			counter++;
		}
		
		System.out.printf("%nInventory valued at $%,.2f.%n", totalValue);
		
		int choice = input.getInt("\nEnter an item number to view details or enter 0 to go back to the Main Menu: ", 0, i.assets.size());
		if (choice != 0) {
			currentInventoryItemDetails(choice - 1);
		}
	}
	
	/**
	 * Lists asset details.
	 * @param index The index of the asset within the current inventory.
	 */
	private void currentInventoryItemDetails(int index) {
		System.out.println("\n----------ITEM DETAILS----------");
		
		// display item
		i.assets.get(index).printDetails();
		
		String[] options = {"Go back to Current Inventory Menu", "Sale item"};
		
		System.out.println();
		for (int j = 0; j < options.length; j++) {
			System.out.println(j + ". " + options[j]);
		}
		
		int choice = input.getInt("Your choice: ", 0, options.length - 1);
		if (choice == 1) {
			saleItem(index);
		}
		
		currentInventoryMenu();
	}
	
	/**
	 * Lists items in user's sold inventory.
	 */
	private void soldInventoryMenu() {		
		System.out.println("\n----------SOLD INVENTORY----------");
		
		if(i.sold.isEmpty()) {
			System.out.println("You have no items in this inventory.");
			return;
		}
		
		int counter = 1;
		double totalProfit = 0.0;
		for (Asset a: i.sold) { // list current inventory
			System.out.println(counter + ". " + a.getDescription());
			totalProfit += a.getProfit();
			counter++;
		}
		
		// display total profits
		System.out.printf("%nTotal profit: $%,.2f.%n", totalProfit);
		
		int choice = input.getInt("\nEnter an item number to view details or enter 0 to go back to the Main Menu: ", 0, i.sold.size());
		if (choice != 0) {
			soldInventoryItemDetails(choice - 1);
		}
	}
	
	/**
	 * Lists sold item details.
	 * @param index The index of the asset within the sold inventory.
	 */
	private void soldInventoryItemDetails(int index) {
		System.out.println("\n----------ITEM DETAILS----------");
		
		// display item
		i.sold.get(index).printDetails();
		
		soldInventoryMenu();
	}
}
