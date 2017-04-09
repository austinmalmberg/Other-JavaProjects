package timer;

import java.util.Timer;

public class Stopwatch {
	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new Time(), 0, 1000);
	}
}
