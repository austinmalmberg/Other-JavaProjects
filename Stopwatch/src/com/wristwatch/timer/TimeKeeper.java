package com.wristwatch.timer;

public interface TimeKeeper {

	void start();
	void stop();
	void reset();
	
	long elapsed();
	String toString();
}
