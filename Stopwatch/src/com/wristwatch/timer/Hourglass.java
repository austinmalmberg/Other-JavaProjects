package com.wristwatch.timer;

/**
 * A timer that counts down from a specified time
 * 
 * @author Austin Malmberg
 *
 */
public class Hourglass implements TimeKeeper {
	
	private MyTimer timer;
	private long limit;
	
	public Hourglass() {
		timer = new MyTimer();
	}
	
	public Hourglass(long millis) {
		this();
		
		limit = millis;
	}
	
	public Hourglass(int hours, int minutes, int seconds) {
		this();
		
		limit = new TimeFormatter().toMillis(0, hours, minutes, seconds, 0);
	}
	
	@Override
	public void start() {
		timer.start();
	}
	
	@Override
	public void stop() {
		timer.stop();
	}
	
	@Override
	public void reset() {
		timer.reset();
	}

	@Override
	public long elapsed() {
		return limit - timer.elapsed();
	}
	
	@Override
	public String toString() {
		return timer.toString();
	}
}
