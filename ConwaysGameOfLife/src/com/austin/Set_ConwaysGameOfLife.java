package com.austin;
import java.awt.Point;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.austin.patterns.Oscillators;

public class Set_ConwaysGameOfLife implements Runnable {
	
	public static final int WAIT_TIME = 700;

	private Set<Point> currState;
	private AdjacentPoints adjPoints;
	
	// formatting variables
	private int initialRowPadding = 2;
	
	private boolean running;
	
	public static void main(String[] args) {
//		new BoardSet(Stills.BLOCK).run();
		new Set_ConwaysGameOfLife(Oscillators.PULSAR).run();
	}
	
	public Set_ConwaysGameOfLife(boolean[][] pattern) {
		currState = IntStream.range(0, pattern.length).boxed()
				.flatMap(r -> IntStream.range(0, pattern[r].length)
						.filter(c -> pattern[r][c])
						.mapToObj(c -> new Point(r, c)))
				.collect(Collectors.toSet());
		
		adjPoints = new AdjacentPoints();
		
		running = true;
	}

	@Override
	public void run() {

		while(running) {
			print();
			update();
			wait(WAIT_TIME);
		}
	}
	
	private void wait(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			// do nothing
		}
	}
	
	private void print() {
		if(currState.isEmpty())
			return;
		
		int lastRow = currState.stream().mapToInt(p -> p.x).max().getAsInt();
		int rowPadding = currState.stream().mapToInt(p -> p.x).min().getAsInt();
		
		printEmptyRows(rowPadding);
		
		IntStream.rangeClosed(rowPadding, lastRow)
				.mapToObj(this::rowToString)
				.forEach(System.out::println);

		printEmptyRows(rowPadding);
	}
	
	private void printEmptyRows(int i) {
		IntStream.range(0, i).forEach(j -> System.out.println());
	}
	
	private String rowToString(int r) {		
		return rowToIntStream(r).collect(
				() -> new StringBuilder(emptyStringOfLength(initialRowPadding + 100)),
				(sb, i) -> sb.setCharAt(i, '#'),
				(sb1, sb2) -> sb1.append(sb2.toString())).toString();
	}
	
	private IntStream rowToIntStream(int r) {
		return currState.stream()
				.filter(p -> p.x == r)		// filter points on specified row
				.mapToInt(p -> p.y);		// get column indexes as IntStream
	}
	
	private String emptyStringOfLength(int len) {
		return IntStream.rangeClosed(0, len).collect(StringBuilder::new, (sb, i) -> sb.append(" "), StringBuilder::append).toString();
	}

	private void update() {
		currState = Stream.concat(currState.stream(), currState.stream().flatMap(adjPoints::relativePointsAsStream))	// all current and adj points
				.filter(this::isOnNextState).collect(Collectors.toSet());	// filter only those that will be on next state
	}
	
	private boolean isOnNextState(Point p) {
		int neighbors = (int) adjPoints.relativePointsAsStream(p)	// get adj points
				.filter(currState::contains).count();	// count those that are on in the current state
		return neighbors == 3 || (currState.contains(p) && neighbors == 2);
	}
}
