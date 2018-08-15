import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Tile extends JPanel {
	
	protected int startingIndex;
	protected int currentIndex;
	protected int finalIndex;
	
	protected int x;
	protected int y;
	
	Tile(int x, int y) {
		this.x = x;
		this.y = y;
		
		setPreferredSize(new Dimension(GamePanel.WIDTH / 3, GamePanel.HEIGHT / 3));
		
	}
	
	void setX(int x) { this.x = x; }
	void setY(int y) { this.y = y; }
	
	public void paint(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(x, y, getWidth(), getHeight());
		g.setColor(Color.RED);
		g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));
		g.drawString("Hello", x, y + 12);
	}
	
	public String toString() {
		return "you clicked the tile!";
	}
}
