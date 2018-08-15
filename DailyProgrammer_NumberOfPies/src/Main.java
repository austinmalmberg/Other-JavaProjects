import java.util.AbstractMap.SimpleEntry;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://www.reddit.com/r/dailyprogrammer/comments/87rz8c/20180328_challenge_355_intermediate_possible/
 * 
 * Description
 * It's Thanksgiving eve and you're expecting guests over for dinner tomorrow. Unfortunately, you were
 * browsing memes all day and cannot go outside to buy the ingredients needed to make your famous pies.
 * You find some spare ingredients, and make do with what you have. You know only two pie recipes, and
 * they are as follows:
 * 
 * Pumpkin Pie
 * 1 scoop of synthetic pumpkin flavouring (Hey you're a programmer not a cook)
 * 3 eggs
 * 4 cups of milk
 * 3 cups of sugar
 * 
 * Apple Pie
 * 1 apple
 * 4 eggs
 * 3 cups of milk
 * 2 cups of sugar
 * 
 * Your guests have no preference of one pie over another, and you want to make the maximum number of
 * (any kind) of pies possible with what you have. You cannot bake fractions of a pie, and cannot use
 * fractions of an ingredient (So no 1/2 cup of sugar or anything like that)
 * 
 * Input Format
 * You will be given a string of 4 numbers separated by a comma, such as 10,14,10,42,24. Each number is a
 * non-negative integer. The numbers represent the number of synthetic pumpkin flavouring, apples, eggs,
 * milk and sugar you have (In the units represented in the recipes).
 * 
 * For instance, in the example input 10,14,10,42,24, it would mean that you have
 * 10 scoops of synthetic pumpkin flavouring
 * 14 apples
 * 10 eggs
 * 42 cups of milk
 * 24 cups of sugar 
 * 
 * @author Austin Malmberg
 *
 */
public class Main {

	public static void main(String[] args) {
		
		int[] ingredients1 = 	{10, 14, 10, 42, 24};
		int[] ingredients2 = 	{12,  4, 40, 30, 40};
		int[] ingredients3 = 	{12, 14, 20, 42, 24};
		
		final int[] pumpkinPie = 		{ 1,  0,  3,  4,  3};
		final int[] applePie = 		{ 0,  1,  4,  3,  2};
		
		int[] ingredients = ingredients3;
		
		/*
		 * keys: pumpkin pies
		 * values: apple pies that can be made with the remaining ingredients
		 */
		Map<Integer, Integer> map = IntStream.rangeClosed(0, maxPies(ingredients, pumpkinPie))
				.boxed()
				.map(i -> new SimpleEntry<>(i, maxPies(remainingIngredients(ingredients, pumpkinPie, i), applePie)))
				.collect(Collectors.toMap(SimpleEntry::getKey, SimpleEntry::getValue));
		
		// finds the maximum number of pies that can be made by adding pumpkin and apple pies
		int max = map.entrySet().stream()
			.mapToInt(e -> e.getKey() + e.getValue())
			.max().getAsInt();
		
		System.out.println("You can make the following pies with the ingredients on hand:");
		map.entrySet().stream()
			.filter(e -> e.getKey() + e.getValue() == max)
			.forEach(e -> System.out.printf("%d pumpkin pies and %d apple pies%n", e.getKey(), e.getValue()));
		
	}
	
	public static int maxPies(int[] ingredients, int[] recipe) {
		return IntStream.range(0, ingredients.length)
			.map(i -> recipe[i] == 0 ? Integer.MAX_VALUE : ingredients[i] / recipe[i])
			.filter(i -> i != Integer.MAX_VALUE)
			.min().getAsInt();
	}
	
	public static int[] remainingIngredients(int[] ingredients, int[] recipe, int numPies) {
		return IntStream.range(0, ingredients.length)
				.map(i -> ingredients[i] - recipe[i] * numPies)
				.toArray();
	}
}