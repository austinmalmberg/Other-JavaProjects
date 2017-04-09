public class Candy {
	
	private CandyColor color;
	private CandyType type;
	
	public Candy(CandyColor c, CandyType t, int x, int y) {
		color = c;
		type = t;
		
		// location information
	}
	
	public CandyColor getColor() {
		return color;
	}
	
	public CandyType getType() {
		return type;
	}
}
