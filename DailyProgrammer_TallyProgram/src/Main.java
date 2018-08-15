import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

// https://www.reddit.com/r/dailyprogrammer/comments/8jcffg/20180514_challenge_361_easy_tally_program/

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		
//		printCountFromStream(input);
		printCountFromLoop(input);
	}
	
	public static void printCountFromStream(String input) {
		
		input.chars().mapToObj(i -> (char) i)	// map to Character stream
			.collect(							// collect as Map<Character, Integer>
				Collectors.groupingBy(
						ch -> Character.toLowerCase(ch),
						Collectors.reducing(0, ch -> Character.isLowerCase(ch) ? 1 : -1, Integer::sum)))
			.entrySet().stream()				// entrySet stream
				.sorted(Comparator.comparingInt(e -> -e.getValue()))	// sort entrySet based on value in desc order
				.forEach(System.out::println);
	}
	
	public static void printCountFromLoop(String input) {
		Map<Character, Integer> map = new HashMap<>();

		for(char ch : input.toCharArray()) {
			char lowercase = Character.toLowerCase(ch);
			
			int val = map.containsKey(lowercase) ? map.get(lowercase) : 0;
			map.put(lowercase, Character.isLowerCase(ch) ? val+1 : val-1);
		}
		
		System.out.println(map.entrySet().stream()
			.sorted(Comparator.comparingInt(i -> -i.getValue()))
			.map(Object::toString)
			.collect(Collectors.joining(", ")));
	}
}