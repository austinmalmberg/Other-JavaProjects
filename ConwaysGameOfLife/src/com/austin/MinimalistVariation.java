package com.austin;

import java.awt.Point;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.austin.patterns.Oscillators;
import com.austin.relationships.AdjacentPoints;

/**
 * Minimal code and methods.  No graphical output.
 * 
 * @author Austin Malmberg
 *
 */
public class MinimalistVariation implements Runnable {
	
	public static void main(String[] args) {
		new MinimalistVariation(Oscillators.BLINKER).run();
	}
	
	public static final int SLEEP_TIME = 1500;
	
	private Set<Point> currState;
	private AdjacentPoints adj;
	
	public MinimalistVariation(boolean[][] initState) {
		currState = IntStream.range(0, initState.length).boxed()		// stream of rows
				.flatMap(r -> IntStream.range(0, initState[r].length)		// stream of cols
						.filter(c -> initState[r][c]).mapToObj(index -> new Point(r, index)))		// filter only true values then map to a point
				.collect(Collectors.toSet());
		adj = new AdjacentPoints();
	}
	
	@Override
	public void run() {
		while(!currState.isEmpty()) {
			currState.forEach(System.out::println);
			System.out.println();
			
			update();
		}
	}
	
	private void update() {
		currState = Stream.concat(currState.stream(), currState.stream().flatMap(adj::relativePointsAsStream))	// get all on points and their neighbors
				.filter(this::nextState).collect(Collectors.toSet());	// collect points that will be on next state
	}
	
	private boolean nextState(Point p) {
		Set<Point> intersectingPoints = new HashSet<Point>(adj.relativePointsAsStream(p).collect(Collectors.toSet()));
		intersectingPoints.retainAll(currState);
		return intersectingPoints.size() == 3 || (currState.contains(p) && intersectingPoints.size() == 2);
	}
}
