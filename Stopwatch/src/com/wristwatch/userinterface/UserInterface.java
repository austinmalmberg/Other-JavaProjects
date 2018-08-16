package com.wristwatch.userinterface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import com.wristwatch.timer.MyTimer;
import com.wristwatch.timer.StopwatchPanel;

@SuppressWarnings("serial")
public class UserInterface extends JPanel implements MouseListener, Runnable {
	
	public static final int WIDTH = 400;
	public static final int HEIGHT = 300;
	
	public static final int FPS = 60;
	public static final int FRAME_DELAY = 1000 / FPS;
	
	Thread thread;
	boolean running;
	
	ArrayList<MyTimer> timers;
	
	public UserInterface() {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setLayout(new BorderLayout());
		
		timers = new ArrayList<>();
	}
	
	@Override
	public void addNotify() {
		super.addNotify();
		if(thread == null) {
			thread = new Thread(this);
			addMouseListener(this);
			thread.start();
		}
	}
	
	private void init() {
		running = true;
		
		// add one timer
		addStopwatch();
	}
	
	public void addStopwatch() {
		StopwatchPanel stopwatch = new StopwatchPanel();
		timers.add(stopwatch);
		
		add(stopwatch, BorderLayout.SOUTH);
	}

	@Override
	public void run() {

		init();
		
		while(running) {
			
			
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) { }

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) { }

	@Override
	public void mouseExited(MouseEvent e) { }

}
