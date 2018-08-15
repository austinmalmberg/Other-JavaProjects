import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements Runnable, KeyListener, MouseListener {
	public static final int WIDTH = 200;
	public static final int HEIGHT = 200;
	
	Thread thread;
	boolean running;
	
	
	Tile t;
	Rectangle test;
	
	BufferedImage image;
	Graphics g;
	
	boolean mousePressed;
	
	GamePanel() {
		super();
		
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true);
		requestFocus();
		
		addKeyListener(this);
		addMouseListener(this);
		
		t = new Tile(0,0);
		add(t);

		running = true;
	}
	
	public void addNotify() {
		if(thread == null) {
			thread = new Thread();
			thread.start();
		}
	}
	
	void pressed() {		
		while(mousePressed) {
			System.out.println("~");
		}
	}
	
	public void paint(Graphics g) {
		t.paint(g);
	}

	public void keyPressed(KeyEvent e) {
	}
	
	public void keyTyped(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
	
	public void mousePressed(MouseEvent e) {
		mousePressed = true;
		
		// boolean for click
		
		// check if valid move
		
		// if yes,
			// update map
			// draw new map
	}

	public void mouseReleased(MouseEvent e) {
		mousePressed = false;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}

	@Override
	public void run() {
		while(running) {
			pressed();
		}
	}


	
}
