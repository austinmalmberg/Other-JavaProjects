package com.austin.relationships;

import java.awt.Point;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AdjacentPoints {

	public final Set<Point> absolutePoints;
	
	public AdjacentPoints() {
		absolutePoints = IntStream.rangeClosed(-1, 1).boxed()
				.flatMap(r -> IntStream.rangeClosed(-1, 1)
						.filter(c -> r != 0 || c != 0)
						.mapToObj(c -> new Point(r, c)))
				.collect(Collectors.toSet());
	}
	
	public Stream<Point> absolutePointsAsStream() { return absolutePoints.stream(); }
	public Stream<Point> relativePointsAsStream(Point rel) {
		return absolutePoints.stream()
				.map(abs -> new Point(abs.x + rel.x, abs.y + rel.y));
	}
}
