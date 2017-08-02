package com.austin.standup.panels;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.austin.standup.log.LogManager;
import com.austin.standup.timer.MyTimer;

@SuppressWarnings("serial")
public class StandUpPanel extends JPanel implements Runnable, KeyListener, MouseListener {

	public static final int PANEL_WIDTH = 300;
	public static final int PANEL_HEIGHT = 200;

	public static final int SITTING = 0;
	public static final int STANDING = 1;
	public static final int AWAY = 2;
	
	private boolean running;
	private Thread thread;
	
	private JButton btn_orientation;
	
	private boolean sitting;
	
	private MyTimer timer;
	
	private TimePanel timePanel;
	private JLabel lbl_total;
	private JLabel lbl_session;

	private LogManager logs;	
	
	public StandUpPanel() {
		super();
		setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		setFocusable(true);
		requestFocus();
		
		btn_orientation = new JButton();
		btn_orientation.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT/4));
		btn_orientation.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		btn_orientation.addMouseListener(this);
		add(btn_orientation);
		
		timePanel = new TimePanel(this);
		timePanel.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT/5));
		add(timePanel);
		
		lbl_total = new JLabel();
		lbl_total.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_total.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT/5));
		add(lbl_total);
		
		lbl_session = new JLabel();
		lbl_session.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_session.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT/5));
		add(lbl_session);
	}
	
	@Override
	public void addNotify() {
		super.addNotify();
		if(thread == null) {
			thread = new Thread(this);
			addKeyListener(this);
			thread.start();
		}
	}
	
	private void init() {
		running = true;
		
		sitting = true;
		updateButtonOrientationText();
		
		timer = new MyTimer();
		timer.start();
		
		if(logs == null)
			logs = new LogManager();
	}
	
	@Override
	public void run() {
		init();
		
		while(running) {
			
			if(timePanel.playing() || timePanel.paused()) {
				
				//  flashing while paused?
				// add date/time to log
				
				lbl_total.setText("Total:         " + logs.formatTime(logs.getTotal(status()) + timer.getTime()));
				lbl_session.setText("Session:   " + logs.formatTime(timer.getTime()));
				
			} else if(timePanel.stopped()) {
				
				lbl_total.setText("Standing:   " + logs.formatTime(logs.getTotal(STANDING)));
				lbl_session.setText("Sitting:    " + logs.formatTime(logs.getTotal(SITTING)));
				
			}
			
			try {
				Thread.sleep(10);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private void restartTimer() {
		timer.stop();
		timer = new MyTimer();
		timer.start();
	}
	
	private int status() {
		return timePanel.paused() ? AWAY : (sitting ? SITTING : STANDING);
	}
	
	private void updateButtonOrientationText() {
		btn_orientation.setText(sitting ? "Stand" : "Sit");
	}
	
	//  MouseListener----------------------------
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getComponent() == btn_orientation) {			
			if(!timePanel.paused()) {
				logs.save(status(), timer.getTime());
				restartTimer();
			}
			
			sitting = !sitting;
			updateButtonOrientationText();
		}
		
		if(timePanel.contains(e.getComponent())) {
			if(!timePanel.stopped()) logs.save(status(), timer.getTime());
			
			timePanel.updateState(e);
			
			if(!timePanel.stopped()) {
				restartTimer();
			} else {
				timer.stop();
				
				// implement write to file????
				
				logs.print();
				
				logs.purge();
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
	
	
	//  KeyListener------------------------------
	
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}
}
