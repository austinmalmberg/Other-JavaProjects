package GameState;

import java.awt.*;
import java.awt.event.KeyEvent;

public class MenuState extends GameState {

	// private Background bg;  // not needed
	
	private int currentChoice = 0;
	private String title = "PONG!";
	private String[] options = { "PLAY", "QUIT" };
	
	private Color titleColor;
	private Font titleFont;
	private Font font;
	
	public MenuState(GameStateManager gsm) {
		this.gsm = gsm;
		
		try {
			// background?
			
			titleColor = new Color(255, 255, 255);
			titleFont = new Font("Courier New", Font.PLAIN, 48);
			
			font = new Font("Courier", Font.PLAIN, 20);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void init() { }

	public void draw(Graphics2D g) {
		// draw title
		g.setColor(titleColor);
		g.setFont(titleFont);
		g.drawString(title, 95, 90);
		
		g.setFont(font);
		for (int i = 0; i < options.length; i++) {
			if (i == currentChoice) {
				g.setColor(Color.GRAY);
			} else {
				g.setColor(Color.WHITE);
			}
			g.drawString(options[i], 140, 160 + i * 20);
		}
		
	}
	
	public void update() { }
	
	private void select() {
		if (currentChoice == 0) {
			gsm.setState(GameStateManager.LEVELSTATE);
		}
		if (currentChoice == 1) {
			System.exit(0);
		}
	}

	public void keyPressed(int k) {
		if (k == KeyEvent.VK_ENTER) {
			select();
		}
		
		if (k == KeyEvent.VK_UP) {
			currentChoice--;
			if (currentChoice == -1) {
				currentChoice = options.length - 1;
			}
		}
		
		if (k == KeyEvent.VK_DOWN) {
			currentChoice++;
			if (currentChoice == options.length) {
				currentChoice = 0;
			}
		}
		
	}

	public void keyReleased(int k) { }

}
