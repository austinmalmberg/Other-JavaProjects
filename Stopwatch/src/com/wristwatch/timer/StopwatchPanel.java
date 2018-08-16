package com.wristwatch.timer;

import java.awt.Color;
import java.awt.Dimension;

import com.wristwatch.userinterface.UserInterface;

/**
 * A timer with no upper bound.
 * 
 * @author Austin Malmberg
 *
 */
public class StopwatchPanel extends MyTimer {
	
	MyTimer timer;
	
	public StopwatchPanel() {
		super();
		
		setBackground(Color.RED);
		
		timer = new MyTimer();
	}	
	
}
