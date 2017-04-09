package com.austin.rise;

import java.util.Timer;
import java.util.TimerTask;

public class MyTimer {

	int time_standing, time_sitting;
	
	State prevState;
	
	Timer t;
	TimerTask tt;
	
	public MyTimer() {
		time_sitting = 0;
		time_standing = 0;
		
		t = new Timer();

		prevState = null;
	}
	
	public void update(State s) {
		if(s.equals(prevState))
			return;
		else
			prevState = s;
		
		if(tt != null) tt.cancel();
		
		tt = new TimerTask(){
			@Override
			public void run() {
				System.out.println("timer created!");
				
				if(s.equals(State.STANDING))
					time_standing++;
				if(s.equals(State.SITTING))
					time_sitting++;
				if(s.equals(State.OUT))
					cancel();
			}
		};
		
		t.scheduleAtFixedRate(tt, 0, 1000);
	}
	
	public int getTimeStanding() { return time_standing; }
	public int getTimeSitting() { return time_sitting; }
}
