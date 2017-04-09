package ap.profiles;

import java.io.*;
import java.util.ArrayList;

import ap.inventory.Inventory;
import ap.people.Person;

/**
 * This class creates, stores, loads and saves profiles.
 * 
 * @author Austin Malmberg
 *
 */
public class ProfileManager {
	
	private ArrayList<Profile> profiles;
	
	public ProfileManager() {		
		profiles = new ArrayList<Profile>();
	}
	
	/**
	 * Creates a new Profile.
	 * @param person
	 */
	public void addNewProfile(Person person) {
		Profile temp = new Profile(generateID(), person, new Inventory());
		
		profiles.add(temp);  // add to array list
		saveProfileToFile(temp);  // save profile
	}
	
	/**
	 * Generates a 3 digit ID for the profile based on the amount of profiles in the "profiles" array list.
	 * @return
	 */
	private String generateID() {
		// returns a 3 number id based on the number of profiles
		
		StringBuilder sb = new StringBuilder(Integer.toString(profiles.size() + 1));
		
		while (sb.length() < 3) {
			sb.insert(0, "0");
		}
		
		System.out.printf("Your profile has been created.  Use the following ID to login: %s%n", sb.toString());
		return sb.toString();
	}
	
	/**
	 * Searches the "profiles" array list.  Returns True if the id parameter matches a Profile ID.  Otherwise, returns False.
	 * @param id
	 * @return
	 */
	public boolean verifyID(String id) {
		for (Profile p: profiles) {
			if (id.equalsIgnoreCase(p.getID())) {
				return true;
			}
		}
		
		System.out.println("Invalid ID.");
		return false;
	}
	
	/**
	 * Returns Profile.
	 * @param id
	 * @return
	 */
	public Profile getProfile(String id) {
		for (Profile p: profiles) {
			if (id.equalsIgnoreCase(p.getID())) {
				System.out.println("\nWelcome back, " + p.getName() + "!");
				return p;
			}
		}
		
		System.out.println("ProfileManager.getProfile() returned a null value.");
		return null; // should never be called
	}
	
	/**
	 * Saves profile to a file within the directory in which the program was ran.
	 * @param p
	 */
	public synchronized void saveProfileToFile(Profile p) {		
		String fileName = "profile" + p.getID() + ".pfl";
		
		try {
			ObjectOutputStream o_out = new ObjectOutputStream(new FileOutputStream(fileName, false));  // writes over any existing file
			try {
				o_out.writeObject(p);
				System.out.println("Profile saved as \"" + fileName + "\".");
			} finally {
				o_out.close();
			}
		} catch (Exception e) {
			System.out.println("There was a problem saving your profile.  Changes you made are probably lost. " + e.toString());
		}		
	}
	/**
	 * Loads all saved profiles into the "profiles" array list.
	 */
	public synchronized void loadProfiles() {
		File folder = new File(System.getProperty("user.dir"));
		File[] fileList = folder.listFiles();
		
		if(fileList.length <= 0) {  // if there are no files in the directory
			System.out.println("No files found in default directory.");
			return;
		}
		
		ArrayList<String> profileNames = new ArrayList<String>();
		
		// if filename begins with profile and ends in .pfl, add the filename to string arraylist
		for(File file: fileList) {
			if(file.getName().startsWith("profile") && file.getName().endsWith(".pfl")) {
				profileNames.add(file.getName());
				
				try {
					ObjectInputStream o_in = new ObjectInputStream(new FileInputStream(file.getName()));
					try {
						profiles.add((Profile) o_in.readObject());
					} finally {
						o_in.close();
					}
				} catch (Exception e) {
					System.out.print("Error loading profile \"" + file.getName() + "\".  " + e.toString());
				}
			}
		}
		
		System.out.println(profiles.size() + " profile(s) imported successfully.");
	}
}
