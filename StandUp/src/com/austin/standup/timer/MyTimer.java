package com.austin.standup.timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class MyTimer implements ActionListener {
	
	public final int DELAY = 1000;
	
	private Timer timer;
	private int count;

	public MyTimer() {	
		timer = new Timer(DELAY, this);
		count = 0;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		count++;
	}
	
	public void start() {
		timer.start();
	}
	
	public void stop() {
		timer.stop();
	}
	
	public int getTime() {
		return count;
	}
}
