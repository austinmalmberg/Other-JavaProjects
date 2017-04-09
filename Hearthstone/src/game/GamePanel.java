package game;

import game.state.GameStateManager;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements Runnable, MouseListener, KeyListener {
	
	// dimensions
	public static final int WIDTH = 720;
	public static final int HEIGHT = 450;
	public static final int SCALE = 2;
	
	// game thread
	private Thread thread;
	private boolean running;
	private int FPS = 60;
	private long targetTime = 1000 / FPS;
	
	// image
	private BufferedImage image;
	private Graphics2D g;
	
	// game state manager
	private GameStateManager gsm;
	
	public GamePanel() {
		super();
		setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		setFocusable(true);
		requestFocus();
	}
	
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
		image = new BufferedImage(WIDTH,HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D) image.getGraphics();
		
		running = true;
		
		gsm = new GameStateManager();
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
			drawToScreen();
			
			elapsed = System.nanoTime() - start;
			wait = targetTime - elapsed / 1000000;
			if (wait < 0) {
				wait = 0;
			}
			
			try {
				Thread.sleep(wait);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
	}
	
	private void update() {
		gsm.update();
	}
	private void draw() {
		gsm.draw(g);
	}
	private void drawToScreen() {
		Graphics g2 = getGraphics();
		g2.drawImage(image, 0, 0, WIDTH * SCALE, HEIGHT * SCALE, null);
		g2.dispose();
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
	public void keyTyped(KeyEvent k) {}
	
	@Override
	public void mouseClicked(MouseEvent m) {
		gsm.mouseClicked(m.getSource());
	}
	@Override
	public void mouseEntered(MouseEvent m) {
		gsm.mouseEntered(m.getSource());
	}
	@Override
	public void mouseExited(MouseEvent m) {
		gsm.mouseExited(m.getSource());
	}
	@Override
	public void mousePressed(MouseEvent m) {
		gsm.mousePressed(m.getSource());
	}
	@Override
	public void mouseReleased(MouseEvent m) {
		gsm.mouseReleased(m.getSource());
	}
}
