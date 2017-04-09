package game.state;

import game.GamePanel;
import game.map.Background;

import java.awt.*;
import java.awt.event.KeyEvent;

public class MenuState extends GameState {
	private Background bg;
	
	private int currentChoice = 0;
	private String[] options = { "Play", "View Collection", "Quit" };
	
	private Color titleColor;
	private Font titleFont;
	
	private Color optionColor;
	private Font font;
	
	public MenuState(GameStateManager gsm) {
		this.gsm = gsm;
		
		try {
			bg = new Background("/Menu/menubg.png");
			
			titleColor = new Color(248, 201, 14);
			titleFont = new Font("Century Gothic", Font.PLAIN, 48);
			
			optionColor = new Color(134, 44, 233);
			font = new Font("Ariel", Font.PLAIN, 24);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void init() {
		
	}

	@Override
	public void update() {
	}

	@Override
	public void draw(Graphics2D g) {
		
		
		bg.draw(g);
		
		// draw title
		g.setColor(titleColor);
		g.setFont(titleFont);
		g.drawString("Hearthstone!", (GamePanel.WIDTH / 4), (GamePanel.HEIGHT / 4));
		
		// draw options
		g.setFont(font);
		
		for (int i = 0; i < options.length; i++) {
			if (i == currentChoice) {
				g.setColor(new Color(250, 216, 80));
			} else {
				g.setColor(optionColor);
			}
			g.drawString(options[i], GamePanel.WIDTH / 2, (GamePanel.HEIGHT / 2) + (i * 24));
		}
	}

	private void select() {
		if (currentChoice == 0) gsm.setState(GameStateManager.CLASSSELECTSTATE);
		if (currentChoice == 1) gsm.setState(GameStateManager.COLLECTIONSTATE);
		if (currentChoice == 2) System.exit(0);
	}
	
	@Override
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

	@Override
	public void keyReleased(int k) {
		
	}

	@Override
	public void mouseClicked(Object obj) {
		
	}

	@Override
	public void mouseEntered(Object obj) {
		
	}

	@Override
	public void mouseExited(Object obj) {
		
	}

	@Override
	public void mousePressed(Object obj) {
		
	}

	@Override
	public void mouseReleased(Object obj) {
		
	}

}
