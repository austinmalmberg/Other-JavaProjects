package ap.profiles;

import java.util.ArrayList;

public class ProfileManager {
	
	ArrayList<Profile> profiles;
	
	public ProfileManager() {
		profiles = new ArrayList<Profile>();
	}
	
	public Profile getProfile(String id) {
		for (Profile p: profiles) {
			if (id.equals(id)) {
				return p;
			}
		}
		
		return null;
	}
	
	public void addProfile(String firstName, String lastName) {
		String id = ""; // change
		
		
		
		profiles.add(new Profile(id, firstName, lastName));
	}
	
}
