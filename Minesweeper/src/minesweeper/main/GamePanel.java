package minesweeper.main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import minesweeper.board.Board;

public class GamePanel extends JPanel implements Runnable, MouseListener {
	
	public static int WIDTH = 640;
	public static int HEIGHT = 480;
	
	private Thread thread;
	private boolean running;
	
	private BufferedImage image;
	private Graphics g;
	
	private Board board;
	
	public static int TILES_X = 20;
	public static int TILES_Y = 15;
	public static int BOMB_DENSITY = 15;  // percentage of total tiles
	
	public GamePanel() {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		requestFocus();
	}
	
	private void init() {
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = (Graphics) image.getGraphics();
		
		running = true;
		
		board = new Board();
	}
	
	private void update() {
		board.update();
	}
	
	private void draw() {
		board.draw(g);
	}
	
	private void render() {
		Graphics g2 = getGraphics();
		g2.drawImage(image, 0, 0, WIDTH, HEIGHT, null);
		g2.dispose();
	}
	
	public void addNotify() {
		super.addNotify();
		if(thread == null) {
			thread = new Thread(this);
			addMouseListener(this);
			thread.start();
		}
	}
	
	public void run() {
		init();
		
		try {
			while(board == null) {
				Thread.sleep(2);
			}
		} catch(InterruptedException ie) {
			ie.printStackTrace();
		}
		
		while(running) {			
			update();
			draw();
			render();
		}
	}
	
	public void mouseClicked(MouseEvent m) {}
	
	public void mousePressed(MouseEvent m) {
		
	}
	
	public void mouseReleased(MouseEvent m) {
		System.out.println(m.getPoint());
	}

	public void mouseEntered(MouseEvent m) {}
	public void mouseExited(MouseEvent m) {}
}
