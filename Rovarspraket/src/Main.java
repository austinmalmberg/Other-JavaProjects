
public class Main {
	public static void main(String[] args) {
		Rovarspraket rovarspraket = new Rovarspraket();
		
		rovarspraket.encode("I'm speaking Robber's language!");
		
		rovarspraket.decode("Tothohisos isos Rorovovarorsospoprorakoketot.");
	}
}

class Rovarspraket {
	private final String CONSONANTS = "bcdfghjklmnpqrstvwxzBCDFGHJKLMNPQRSTVWXZ";
	
	public void encode(String s) {
		if(s.isEmpty()) return;
		
		StringBuilder sb = new StringBuilder();
		
		for(char c : s.toCharArray()) {
			sb.append(c);
			if(CONSONANTS.indexOf(c) >= 0) {
				sb.append("o" + Character.toLowerCase(c));
			}
		}
			
		System.out.println(sb.toString());
	}
	
	public void decode(String s) {
		if(s.isEmpty()) return;
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			sb.append(c);
			if(CONSONANTS.indexOf(c) >= 0) {
				i += 2;
			}
		}
		
		System.out.println(sb.toString());
	}
}
