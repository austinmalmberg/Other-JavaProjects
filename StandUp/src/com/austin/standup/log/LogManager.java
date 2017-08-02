package com.austin.standup.log;
import java.util.ArrayList;

import com.austin.standup.panels.StandUpPanel;

public class LogManager {
	public static final String[] statuses = {"Sitting", "Standing", "Away"};
	
	private ArrayList<Log> logs;
	
	public LogManager() {
		logs = new ArrayList<>();
	}
	
	public void save(int orientation, int seconds) {
		if(seconds < 2) return;
		logs.add(new Log(orientation, seconds));
		
		System.out.println(orientation+ " " + seconds);
		print();
	}
	
	public void purge() {
		logs.clear();
	}
	
	public int getTotalTime() {
		if(logs.isEmpty()) return 0;
		
		return logs.stream()
				.mapToInt(l -> l.seconds())
				.sum();
	}
	
	public int getTotal(int status) {
		if(logs.isEmpty()) return 0;
		
		return logs.stream()
				.filter(l -> l.status() == status)
				.mapToInt(l -> l.seconds())
				.sum();
	}
	
	public String formatTime(int seconds) {
		int secs = (seconds%3600) % 60;
		int mins = (seconds%3600) / 60;
		int hrs = seconds / 3600;
		
		return String.format("%02d:%02d:%02d", hrs, mins, secs);
	}
	
	
	public void print() {		
		System.out.println("Time spent standing:  " + formatTime(getTotal(StandUpPanel.STANDING)));
		System.out.println("Time spent sitting:   " + formatTime(getTotal(StandUpPanel.SITTING)));
		System.out.println("Time spent away:      " + formatTime(getTotal(StandUpPanel.AWAY)));
		System.out.println("------------------------------");
		System.out.println("          Total:      " + formatTime(getTotalTime()));
		System.out.println();
		
		System.out.println("----------Breakdown-----------");
		for(Log l : logs) {
			System.out.printf("    %-8s%18s%n", statuses[l.status()],
					formatTime(l.seconds()));
		}
		
		System.out.println("\n"); //  two blank lines
	}
}

class Log {
	private int status;
	private int seconds;
	
	public Log(int status, int seconds) {
		this.status = status;
		this.seconds = seconds;
	}
	
	public int status() {
		return status;
	}
	public int seconds() {
		return seconds;
	}
}
