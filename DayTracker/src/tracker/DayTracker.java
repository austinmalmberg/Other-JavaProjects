package tracker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DayTracker {
	
	public static final String START_TIME = "09:00:00";
	public static final String END_TIME = "19:00:00";
	
	private long ms_in_shift;
	
	private GregorianCalendar current;
	
	private GregorianCalendar day_begin;
	private GregorianCalendar day_end;
	
	private GregorianCalendar week_begin;
	private GregorianCalendar week_end;
	
	private String timeWorkedDay;
	private String timeWorkedWeek;
	private String dayRelative5x8;
	
	public DayTracker() {		
		// initialize current date/time
		current = new GregorianCalendar();
		
		week_begin = new GregorianCalendar();
		week_begin.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		week_begin.set(Calendar.HOUR_OF_DAY, Integer.parseInt(START_TIME.substring(0, 2)));
		week_begin.set(Calendar.MINUTE, Integer.parseInt(START_TIME.substring(3, 5)));
		week_begin.set(Calendar.SECOND, Integer.parseInt(START_TIME.substring(6, 8)));
		
		week_end = new GregorianCalendar();
		week_end.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
		week_end.set(Calendar.HOUR_OF_DAY, Integer.parseInt(END_TIME.substring(0, 2)));
		week_end.set(Calendar.MINUTE, Integer.parseInt(END_TIME.substring(3, 5)));
		week_end.set(Calendar.SECOND, Integer.parseInt(END_TIME.substring(6, 8)));
		
		day_begin = new GregorianCalendar();
		day_begin.set(Calendar.HOUR_OF_DAY, Integer.parseInt(START_TIME.substring(0, 2)));
		day_begin.set(Calendar.MINUTE, Integer.parseInt(START_TIME.substring(3, 5)));
		day_begin.set(Calendar.SECOND, Integer.parseInt(START_TIME.substring(6, 8)));
		
		day_end = new GregorianCalendar();
		day_end.set(Calendar.HOUR_OF_DAY, Integer.parseInt(END_TIME.substring(0, 2)));
		day_end.set(Calendar.MINUTE, Integer.parseInt(END_TIME.substring(3, 5)));
		day_end.set(Calendar.SECOND, Integer.parseInt(END_TIME.substring(6, 8)));
		
		ms_in_shift = day_end.getTimeInMillis() - day_begin.getTimeInMillis();
	}
	
	public void update() {
		current.setTime(new Date());
		
		rolloverDates();
		
		if(working()) {
			long time_today = current.getTimeInMillis() - day_begin.getTimeInMillis();
			
			// update time
			timeWorkedDay = getTime(time_today);
			
			int shifts_this_week = 0;
			if(current.get(Calendar.DAY_OF_WEEK) > 2) {
				shifts_this_week = current.get(Calendar.DAY_OF_WEEK) - 2;
			}
			timeWorkedWeek = getTime((ms_in_shift * shifts_this_week) + time_today);
		} else {
			timeWorkedDay = "--:--:--";
			timeWorkedWeek = "--:--:--";
		}
		
	}
	
	public boolean working() {
		if(current.after(day_begin) && current.before(day_end)) {
			return true;
		}
		
		return false;
	}
	
	private void rolloverDates() {		
		if(current.get(Calendar.YEAR) > week_begin.get(Calendar.YEAR) || current.get(Calendar.WEEK_OF_YEAR) > week_begin.get(Calendar.WEEK_OF_YEAR)) {
			week_begin.set(Calendar.YEAR, current.get(Calendar.YEAR));
			week_begin.set(Calendar.WEEK_OF_YEAR, current.get(Calendar.WEEK_OF_YEAR));
			
			week_end.set(Calendar.YEAR, current.get(Calendar.YEAR));
			week_end.set(Calendar.WEEK_OF_YEAR, current.get(Calendar.WEEK_OF_YEAR));
		}
		if(current.get(Calendar.DATE) > day_begin.get(Calendar.DATE)) {
			day_begin.set(Calendar.DATE, current.get(Calendar.DATE));
			
			day_end.set(Calendar.DATE, current.get(Calendar.DATE));
		}
	}
	
	private String getTime(long millis) {
		
		long second = (millis / 1000) % 60;
		long minute = (millis / (1000 * 60)) % 60;
		long hour = (millis / (1000 * 60 * 60));

		return String.format("%02d:%02d:%02d", hour, minute, second);
	}
	
	
	public String getTimeWorkedDay() {
		return timeWorkedDay;
	}

	public String getTimeWorkedWeek() {
		return timeWorkedWeek;
	}
	
	public String getDayRelative5x8() {
		return dayRelative5x8;
	}
}
