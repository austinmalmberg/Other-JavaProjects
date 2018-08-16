package com.wristwatch.timer;

import java.awt.Dimension;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

import com.wristwatch.userinterface.UserInterface;

public class MyTimer extends JPanel implements TimeKeeper {
	
	public static final int WIDTH = UserInterface.WIDTH;
	public static final int HEIGHT = UserInterface.HEIGHT * 14/15;

	private Timer t;
	
	private int elapsed;
	
	private boolean running;
	
	private TimeFormatter formatter;
	
	public MyTimer() {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		t = new Timer();
		
		elapsed = 0;
		
		formatter = new TimeFormatter();
	}
	
	public void start() {
		t.schedule(new TimerTask() {			
			@Override
			public void run() {
				elapsed += 1;
			}
		}, 0, 1);
		running = true;
	}
	
	public void stop() {
		t.cancel();
		running = false;
	}
	
	public void reset() {
		elapsed = 0;
	}
	
	public long elapsed() { return elapsed; }
	public boolean running() { return running; }
	
	public String toString() { return formatter.toString(elapsed); }
}
