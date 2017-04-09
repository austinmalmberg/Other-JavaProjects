package ap;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import ap.inventory.Inventory;
import ap.panels.*;

public class AmericanPickers extends JFrame implements Runnable {
	private static final long serialVersionUID = 1L;
	
	
	public static final int WIDTH = 900;
	public static final int HEIGHT = 600;
	
	public Thread thread;
	public boolean running;
	
	TopPanel top;
	MainPanel main;
	BottomPanel bottom;
	
	Inventory inventory;
	
	public AmericanPickers(String title) {
		setTitle(title);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setResizable(false);
		setVisible(true);
	}
	
	private void init() {
		running = true;
		
		inventory = new Inventory();
		
		top = new TopPanel(inventory);
		main = new MainPanel(inventory);
		bottom = new BottomPanel(inventory, main);
		
		// add panels to JFrame
		add(top, BorderLayout.NORTH);
		add(main, BorderLayout.CENTER);
		add(bottom, BorderLayout.SOUTH);
	}
	
	@Override
	public void run() {
		
		init();
		
		while (running) {
			
			top.update();
			main.update();
			bottom.update();
			
			try {
				Thread.sleep(20);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public void addNotify() {
		super.addNotify();
		if(thread == null) {
			thread = new Thread(this);
			thread.setName("pickers");
			thread.start();
		}
	}
}
