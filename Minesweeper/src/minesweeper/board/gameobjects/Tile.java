package minesweeper.board.gameobjects;

import java.awt.Color;
import java.awt.event.MouseEvent;

public class Tile extends GameObject {
	
	private int value;
	
	public static int WIDTH = 20;
	public static int HEIGHT = 20;
	
	public Tile(int x, int y, int value) {
		this.x = x;
		this.y = y;
		
		this.width = WIDTH;
		this.height = HEIGHT;
		
		this.value = value;
		
		visible = true;  // value is visible when true, hidden when false
	}
	
	public void setValue(int value) { this.value = value; }
	public int getValue() { return value; }
	
	// override tile dimensions so they can't be changed
	public void setHeight(int height) { return; }
	public void setWidth(int width) { return; }
	
	public void init() {
		
	}
	
	public void update() {
		
	}
	
	public void draw(java.awt.Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(x, y, WIDTH, HEIGHT);
		
		if(visible) {
			g.setColor(Color.WHITE);
			
			g.drawString(""+value, x + WIDTH / 3, (int)(y + HEIGHT / 1.5));
		}
	}
	
	public void mousePressed(MouseEvent m) {
		
	}
	
	public void mouseReleased(MouseEvent m) {
		
	}
}
