
public class Main {

	public static void main(String[] args) {
		String[] hex = {
				"35351405274666",
				"35351405274667",
				"35351405274696",
				"35351405274739",
				"35351405274767",
				"35351405274740",
				"35351405274797",
				"35351405274798",
				"35351405274799",
				"35351405274800",
				"35351405274773",
				"35351405274829",
				"35351405274746",
				"35351405274760",
				"35351405274817",
				"35351405274780",
				"35351405274625",
				"35351405274823",
				"35351405274810",
				"35351405274669",
				"35351405274812",
				"35351405274826",
				"35351405274828",
				"35351405274673",
				"35351405274675",
				"99000329206599"};
		
		for(int i = 0; i < hex.length; i++) {
			System.out.println(hex[i] + " : " + convert(hex[i]));
		}


	}
	
	public static long convert(String s) {
		long output = 0;
		
		try{
			output = Long.parseLong(s, 16);
		} catch (NumberFormatException nfe) { }
		
	    return output;
	    
	}

}
