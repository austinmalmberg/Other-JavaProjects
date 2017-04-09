package ap.person;

import java.util.ArrayList;

public class Pickers {
	
	private ArrayList<Picker> pickers;
	
	public Pickers() {
		pickers = new ArrayList<Picker>();
		
		// add picker profiles
		pickers.add(new Picker("Danielle", "Cushman", "001"));
		pickers.add(new Picker("Frank", "Fritz", "002"));
		pickers.add(new Picker("Mike", "Wolfe", "003"));
	}
	
	public void addPicker(Picker p) {		
		pickers.add(p);
	}
	
	public Picker getPicker(int i) {
		return pickers.get(i);
	}
	
	public boolean isPicker(String id) {
		for (Picker picker: pickers) {
			if (picker.getID().equals(id)) {
				System.out.printf("You've selected %s.%n", picker.getName());
				return true;
			}
		}
		
		System.out.println("There is not an American Picker with this ID.");
		return false;
	}
}
