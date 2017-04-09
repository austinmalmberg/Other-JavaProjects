package tracker;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class UserInterface extends JPanel implements Runnable {

	public static final int WIDTH = 300;
	public static final int HEIGHT = 100;
	
	private Thread thread;
	private boolean running;
	
	private DayTracker dt;
	
	private JLabel label1;
	private JLabel timeWorkedDay;
	
	private JLabel label2;
	private JLabel timeWorkedWeek;
	
	private JLabel label3;
	private JLabel dayRelative5x8;
	
	public UserInterface() {
		
		setLayout(new GridLayout(3, 2));
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true);
		requestFocus();
	}
	
	public void addNotify() {
		
		super.addNotify();
		if(thread == null) {
			thread = new Thread(this);
			thread.start();
		}
	}
	
	private void init() {
		
		dt = new DayTracker();
		
		running = true;
		
		
		label1 = new JLabel("Time worked today: ", JLabel.RIGHT);
		timeWorkedDay = new JLabel("", JLabel.CENTER);
		
		label2 = new JLabel("Time worked this week: ", JLabel.RIGHT);
		timeWorkedWeek = new JLabel("", JLabel.CENTER);
		
		label3 = new JLabel("Day relative 5x8s: ", JLabel.RIGHT);
		dayRelative5x8 = new JLabel("", JLabel.CENTER);
		
		add(label1);
		add(timeWorkedDay);
		
		add(label2);
		add(timeWorkedWeek);
		
		add(label3);
		add(dayRelative5x8);
	}
	
	private void update() {
		
		dt.update();
		
		timeWorkedDay.setText(dt.getTimeWorkedDay());
		timeWorkedWeek.setText(dt.getTimeWorkedWeek());
		dayRelative5x8.setText(dt.getDayRelative5x8());
	}
	
	public void run() {
		
		init();
		
		while(running) {
			
			update();
			
			try {
				if (dt.working()) {
					Thread.sleep(1000);
				} else {
					Thread.sleep(10000);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
