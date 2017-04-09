package com.austin.gamestate;

import java.awt.*;
import java.awt.event.KeyEvent;

import com.austin.map.Background;

public class MenuState extends GameState {

	private final String title = "Bomb Squad";
	
	private Background bg;
	
	private int current_choice = 0;
	private String[] options = {"Start", "Help", "Quit"};  // last option should always quit
	
	private final int title_x = 240;
	private final int title_y = 145;
	
	private final int options_x = 453;
	private final int options_y = 230;
	
	private final int option_padding = 60;
	
	private Color titleColor;
	private Font titleFont;
	private Font font;
	
	public MenuState(GameStateManager gsm) {
		this.gsm = gsm;
		
		bg = new Background("/Backgrounds/menu_bg.png");
		
		titleColor = new Color(128, 0, 0);
		titleFont = new Font("Calibri", Font.BOLD, 72);
		
		font = new Font("Calibri", Font.PLAIN, 50);
	}
	
	@Override
	public void init() {
		System.out.println("MenuState initialized!");
	}

	@Override
	public void update() {
		bg.update();
	}

	@Override
	public void draw(Graphics g) {
		bg.draw(g);
		
		// draw title
		g.setColor(titleColor);
		g.setFont(titleFont);
		g.drawString(title, title_x, title_y);
		
		g.setFont(font);
		for (int i = 0; i < options.length; i++) {
			if(i == current_choice) {
				g.setColor(Color.RED);
			} else {
				g.setColor(Color.BLACK);
			}
			g.drawString(options[i], options_x, options_y + i * option_padding);
		}
	}

	private void select() {
		if(current_choice == 0)
			gsm.setState(GameStateManager.LEVEL_STATE);
		
		if(current_choice == 1) {}
			// help menu
		
		if(current_choice == options.length - 1)
			System.exit(0);  // last option quits game
	}
	
	@Override
	public void keyPressed(int k) {
		if(k == KeyEvent.VK_ENTER) select();
		
		// wrap around
		if(k == KeyEvent.VK_UP) {
			current_choice--;
			if(current_choice < 0) current_choice = options.length - 1;
		}
		if(k == KeyEvent.VK_DOWN) {
			current_choice++;
			if(current_choice > options.length - 1) current_choice = 0;
		}
	}
		
	@Override
	public void mousePressed(int x, int y) {
		
	}
	
	
	
	
	
	@Override
	public void keyReleased(int k) {}
	
	@Override
	public void mouseReleased(int x, int y) {}

}
