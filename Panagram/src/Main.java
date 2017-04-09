import java.util.TreeMap;

public class Main {
	public static void main(String[] args) {
		new Panagram("The quick brown fox jumps over the lazy dog.").test();
		new Panagram("Pack my box with five dozen liquor jugs").test();
		new Panagram("Saxophones quickly blew over my jazzy hair").test();
	}
}

class Panagram {	
	TreeMap<Character, Integer> chars;
	
	String s;
	
	public Panagram(String s) {
		chars = new TreeMap<>();
		
		this.s = s;
	}

	public void test() {
		for(char c : s.toLowerCase().replaceAll("[^a-z]", "").toCharArray()) {
			if(chars.containsKey(c)) {
				chars.put(c, chars.get(c) + 1);
			} else {
				chars.put(c, 1);
			}
		}
		
		System.out.print(chars.size() == 26 ? "True " : "False ");		
		System.out.println(chars.toString());
	}
}
