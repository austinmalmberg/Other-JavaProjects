package com.austin.challenge349i;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Description
You run a moving truck business, and you can pack the most in your truck when you have stacks of equal size
- no slack space. So, you're an enterprising person, and you want to write some code to help you along.

Input Description
You'll be given two numbers per line. The first number is the number of stacks of boxes to yield. The second
is a list of boxes (heights), one integer per size, to pack.

Example:

3 34312332
That says "make three stacks of boxes with sizes 3, 4, 3, 1 etc".

Output Description
Your program should emit the stack of boxes as a series of integers, one stack per line. From the above example:

331
322
34
If you can't make equal sized stacks, your program should emit nothing.

Challenge Input
3 912743471352
3 42137586
9 2 
4 064876318535318
Challenge Output
9124
7342
7135

426
138
75

(nothing)

0665
4733
8315
881

 * 
 * 
 * @author Austin Malmberg
 *
 */
public class Main {

	public static void main(String[] args) {
		
		String example = "3 34312332";
		String[] challenges = {
				"3 912743471352",
				"3 42137586",
				"9 2",
				"4 064876318535318"
		};
		
		String[] parsedString = parseString(example/*challenges[3]*/);		
		List<Integer> boxHeights = stringToIntArray(parsedString[1]);
		
		Shipment shipment = new Shipment(Integer.parseInt(parsedString[0]), boxHeights);
		shipment.printEqualStacks();
	}
	
	public static String[] parseString(String string) {
		return string.split("\\s+", 2);
	}
	
	public static List<Integer> stringToIntArray(String intString) {
		return intString.chars()
				.mapToObj(Character::getNumericValue)
				.collect(Collectors.toList());
	}
}
