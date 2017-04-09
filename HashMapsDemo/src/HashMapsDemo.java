import java.util.HashMap;


public class HashMapsDemo {

	static HashMap<String, Double> map = new HashMap<>();
	
	public static void main(String[] args) {
		map.put("Kenny", 2.12);
		map.put("Joe", 5.65);
		
		map.get("Kenny");
		
		System.out.println(map.get("Kenny"));
	}
}
