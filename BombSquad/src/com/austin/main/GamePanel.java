package com.austin.main;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import com.austin.gamestate.GameStateManager;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements Runnable, KeyListener, MouseListener {
	
	// dimensions
	public static final int WIDTH = 640;
	public static final int HEIGHT = 480;
	
	// thread
	private Thread thread;
	private boolean running;
	private int FPS = 60;
	private long targetTime = 1000 / FPS;
	
	// image
	private BufferedImage image;
	private Graphics g;
	
	// game states
	private GameStateManager gsm;
	
	public GamePanel() {
		super();
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true);
		requestFocus();
	}
	
	@Override
	public void addNotify() {
		super.addNotify();
		if(thread == null) {
			thread = new Thread(this);
			addKeyListener(this);
			addMouseListener(this);
			thread.start();
		}
	}
	
	private void init() {
		System.out.println("GamePanel initialized!");
		
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D) image.getGraphics();
		
		running = true;
		
		gsm = new GameStateManager();
	}
	
	private void update() {
		gsm.update();
	}
	
	private void draw() {
		gsm.draw(g);
	}
	
	private void render() {
		Graphics g2 = getGraphics();
		g2.drawImage(image, 0, 0, WIDTH, HEIGHT, null);
		g2.dispose();
	}
	
	@Override
	public void run() {
		init();
		
		long start;
		long elapsed;
		long wait;
		
		// game loop
		while(running) {
			start = System.nanoTime();
			
			update();
			draw();
			render();
			
			elapsed = System.nanoTime() - start;
			wait = targetTime - elapsed / 1000000;
			if (wait < 0) wait = 0;
			
			try {
				Thread.sleep(wait);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent k) {
		gsm.keyPressed(k.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent k) {
		gsm.keyReleased(k.getKeyCode());
	}
	
	@Override
	public void mousePressed(MouseEvent m) {
		gsm.mousePressed(m.getX(), m.getY());
	}

	@Override
	public void mouseReleased(MouseEvent m) {
		gsm.mouseReleased(m.getX(), m.getY());
	}
	
	
	
	
	@Override
	public void keyTyped(KeyEvent k) { }

	@Override
	public void mouseClicked(MouseEvent m) { }
	
	@Override
	public void mouseEntered(MouseEvent m) { }

	@Override
	public void mouseExited(MouseEvent m) { }
}
