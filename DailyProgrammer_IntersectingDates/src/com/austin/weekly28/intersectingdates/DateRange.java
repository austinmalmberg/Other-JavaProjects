package com.austin.weekly28.intersectingdates;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateRange {
	
	private SimpleDateFormat df;
	
	private Date start;
	private Date end;
	
	public DateRange(String[] dates) throws ParseException {
		df = new SimpleDateFormat("MM/dd/yyyy");
		
		start = df.parse(dates[0]);
		end = df.parse(dates[1]);
	}
	
	public boolean intersects(DateRange range) {
		
		return range.includes(start) || range.includes(end) || 
				this.includes(range.getStart()) || this.includes(range.getEnd());
		
	}
	
	public boolean includes(Date date) {
		return date.after(start) && date.before(end);
	}
	
	public String toString() {
		return String.format("%s - %s", df.format(start), df.format(end));
	}
	
	public Date getStart() { return start; }
	public Date getEnd() { return end; }
}
