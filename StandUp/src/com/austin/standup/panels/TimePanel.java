package com.austin.standup.panels;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TimePanel extends JPanel {
	
	public static final int PLAY_STATE = 0;
	public static final int PAUSE_STATE = 1;
	public static final int STOP_STATE = 2;	
	
	private JButton btn_play;
	private JButton btn_pause;
	private JButton btn_stop;
	
	private ArrayList<JButton> buttons;
	
	private int curr_state;
	
	public TimePanel(StandUpPanel sup) {
		super();
		
		buttons = new ArrayList<>();
		
//		ImageIcon play_icon = new ImageIcon("U:/JavaProjects/StandUp/src/2isbfdh.gif");
		
		btn_play = new JButton("Play");
		buttons.add(btn_play);
		
		btn_pause = new JButton("Pause");
		buttons.add(btn_pause);
		
		btn_stop = new JButton("Stop");
		buttons.add(btn_stop);
		
		for(JButton b : buttons) {
			b.addMouseListener(sup);
			add(b);
		}
		
		curr_state = PLAY_STATE;
		btn_play.setEnabled(false);
	}
	
	public int getCurrentState() {
		return curr_state;
	}
	
	public boolean playing() {
		return curr_state == PLAY_STATE;
	}
	
	public boolean paused() {
		return curr_state == PAUSE_STATE;
	}
	
	public boolean stopped() {
		return curr_state == STOP_STATE;
	}
	
	public void updateState(MouseEvent e) {
		// update visibility
		for(JButton b : buttons) {
			if(e.getComponent() == b) {
				b.setEnabled(false);
			} else {
				b.setEnabled(true);
			}
		}
		
		// change state
		curr_state = buttons.indexOf(e.getComponent());
	}
	
	public boolean contains(Component c) {
		return buttons.contains(c);
	}
}
