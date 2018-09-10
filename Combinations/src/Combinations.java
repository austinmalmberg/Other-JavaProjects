import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Combinations {

	private List<List<Integer>> comboList;
	
	public Combinations() {}
	
	public <T> Combinations(ArrayDeque<T> deque) {
		
	}
	
	public <T> List<List<T>> get(ArrayList<T> list) {
		return generate(list).collect(Collectors.toList());
	}
	
	public <T> List<List<T>> get(ArrayList<T> list, int elements) {
		return generate(list)
				.filter(l -> l.size() == elements)
				.collect(Collectors.toList());
	}
	
	private <T> Stream<List<T>> generate(ArrayList<T> list) {
		return generate(list, new Stack());
	}
	
	private <T> Stream<List<T>> generate(ArrayList<T> list, Stack<T> sub) {
		return null;
		
	}
	
	private <T> Stream<T> combine(List<T> workingList, List<T> completeList, int index) {
		return Stream.concat(workingList.stream(), Stream.of(completeList.get(index)));
	}
	
	private void combos(List<Integer> list, List<Integer> sublist) {
		for(int index = 0; index < list.size(); index++) {
			List<Integer> sub = Stream.concat(sublist.stream(), Stream.of(list.get(index)))
					.collect(Collectors.toList());
			combos(list.subList(index+1, list.size()), sub);
			comboList.add(sub);
		}
		
//		for(int i = 0; i < list.size(); i++) {
//			List<Integer> workingList = Stream.concat(sub.stream(), Stream.of(list.get(i))).collect(Collectors.toList());
//			combos(list.subList(i+1, list.size()), workingList);
//		}
	}
}
