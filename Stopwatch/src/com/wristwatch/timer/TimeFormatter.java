package com.wristwatch.timer;

public class TimeFormatter {
	
	public static final int MILLISECONDS_IN_SECOND = 1000;
	public static final int SECONDS_IN_MINUTE = 60;
	public static final int MINUTES_IN_HOUR = 60;
	public static final int HOURS_IN_DAY = 24;
	public static final int DAYS_IN_WEEK = 7;

	public TimeFormatter() { }
	
	public long toMillis(int days, int hours, int minutes, int seconds, int millis) {
		return millis +
				(seconds * TimeFormatter.MILLISECONDS_IN_SECOND) +
				(minutes * TimeFormatter.MILLISECONDS_IN_SECOND * TimeFormatter.SECONDS_IN_MINUTE) +
				(hours * TimeFormatter.MILLISECONDS_IN_SECOND * TimeFormatter.SECONDS_IN_MINUTE * TimeFormatter.MINUTES_IN_HOUR) +
				(days * TimeFormatter.MILLISECONDS_IN_SECOND * TimeFormatter.SECONDS_IN_MINUTE * TimeFormatter.MINUTES_IN_HOUR * TimeFormatter.HOURS_IN_DAY);
	}
	
	public String toString(long ms) {
		long days = (ms / (MILLISECONDS_IN_SECOND * SECONDS_IN_MINUTE * MINUTES_IN_HOUR * HOURS_IN_DAY));
		
		long millis = ms % MILLISECONDS_IN_SECOND;
		long seconds = (ms / MILLISECONDS_IN_SECOND) % SECONDS_IN_MINUTE;
		long minutes = (ms / (MILLISECONDS_IN_SECOND * SECONDS_IN_MINUTE)) % MINUTES_IN_HOUR;
		long hours = (ms / (MILLISECONDS_IN_SECOND * SECONDS_IN_MINUTE * MINUTES_IN_HOUR));
		
		if(days > 0) {
			hours %=  HOURS_IN_DAY;
			return String.format("%d:%02d:%02d", days, hours, minutes);
		}
		
		if(hours > 0)
			return String.format("%d:%02d:%02d", hours, minutes, seconds);

		return String.format("%02d:%02d:%03d", minutes, seconds, millis);
	}
}
