import java.awt.Point;

public enum Direction {

	NNE(new Point(1, -2)),
	ENE(new Point(2, -1)),
	ESE(new Point(2, 1)),
	SSE(new Point(1, 2)),
	SSW(new Point(-1, 2)),
	WSW(new Point(-2, 1)),
	WNW(new Point(-2, -1)),
	NNW(new Point(-1, -2));
	
	Point p;
	
	Direction(Point p) {
		this.p = p;
	}
	
	int getX() { return p.x; }
	int getY() { return p.y; }
}
