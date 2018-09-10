import java.util.ArrayDeque;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

	public static void main(String[] args) {
//		int[] inputs = {4}; //, 8, 10, 20, 25, 32};
//		for(int i : inputs) {
//			new MondrianPuzzle(i).solve();
		
		
		Combinations combos = new Combinations();
		ArrayDeque<Integer> range = IntStream.range(0, 4).mapToObj(Integer::valueOf).collect(Collectors.toCollection(ArrayDeque::new));
		
		combos.get(range);
		
	}
	
	public static List<Integer> combin(List<Integer> list) {
		ArrayDeque<Integer> deque = new ArrayDeque<>(list);
		deque.
		
		 return IntStream.range(0, list.size()).boxed()
			.flatMap(i -> combin(list.subList(i+1, list.size())));
	}
	
	
}
