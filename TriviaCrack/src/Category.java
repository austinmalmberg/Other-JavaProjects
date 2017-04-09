
public enum Category {
	ENTERTAINMENT(0),
	ART(1),
	SPORTS(2),
	HISTORY(3),
	SCIENCE(4),
	GEOGRAPHY(5);
	
	private int id;

	private Category(int id) {
		this.id = id;
	}
	
	public static int size() {
		return values().length;
	}
	
	public int getID() {
		return id;
	}
	
	public static String getCategoryName(int i) {		
		switch(i) {
		case 0:
			return "Entertainment";
		case 1:
			return "Art";
		case 2:
			return "Sports";
		case 3:
			return "History";
		case 4:
			return "Science";
		case 5:
			return "Geography";
		default:
			return null;
		}
	}

}


