package com.austin.gamestate.level;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import com.austin.gamestate.GameState;
import com.austin.gamestate.GameStateManager;
import com.austin.map.Background;

public class LevelState extends GameState {
	
	private Background bg;
	
	private Bomb bomb;
	
	private KeyPad kp;
	
	private Font clipboard_font;
	private Color correct_number;  // green color to indicate the correct number and the incorrect position
	private Color correct_position;
	
	private Color key_press_color;
	
	private StringBuilder code;  // user inputted code
	
	private boolean running;
	private boolean winner;
	private String outcome;
	
	private int defuses;  // the number of consecutive defuses.  more defuses increase difficulty
	
	private ArrayList<String> clipboard;  // stores previous attempts
	
	private boolean keyEntered;
	private int keyVal;
	
	// used to draw strings on clipboard
	private int digit_padding;
	private int cb_x;
	private int cb_y;
	
	// positioning
	private final int code_x = 341;
	private final int code_y = 174;
	
	private final int clipboard_x = 43;
	private final int clipboard_y = 287;
	
	private final int attempts_x = 16;
	private final int attempts_y = 235;
	
	private final int outcome_x = 11;
	private final int outcome_y = 77;
	
	public LevelState(GameStateManager gsm) {	
		
		this.gsm = gsm;
		
		bg = new Background("/Backgrounds/level_bg.png");
		
		kp = new KeyPad();
		
		clipboard_font = new Font("Tempus Sans ITC", Font.PLAIN, 28);
		correct_number = new Color(0, 140, 0);
		correct_position = new Color(175, 0, 0);
		
		key_press_color = new Color(255, 255, 255, 170);
		
		keyEntered = false;
		
		defuses = 0;
	}
	
	private void resetInput(int digits) {
		code.setLength(0);
		
		while(code.length() < digits)
			code.append("*");
	}
	
	private void addDigitToCode(int i) {
		code.deleteCharAt(0);
		code.append(i);
	}
	
	@Override
	public void init() {
		System.out.println("LevelState initialized!");
		
		code = new StringBuilder();
		
		clipboard = new ArrayList<>();
		
		bomb = new Bomb(defuses);
		
		running = true;
		winner = false;		
		
		resetInput(bomb.getDigits());
	}

	@Override
	public void update() {
		bg.update();
		
		// bomb.update() sometimes throws a NullPointerException.  Sleep thread until bomb can be initialized
		while(bomb == null) {
			try {
				System.out.println("Bomb null! Thread sleeping 2ms.");
				Thread.sleep(2);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
		
		bomb.update();
		
		if(code.toString().matches("[0-9]{" + bomb.getDigits() + "}")) {  // valid 4 digit code
			
			// test with bomb_code
			bomb.enterCode(code.toString());
			
			clipboard.add(code.toString());
			
			resetInput(bomb.getDigits());
		}
		
		if(bomb.isDefused()) {
			defuses++;
			winner = true;
			running = false;
		}

		// if time expires or no more attempts
		
		
		
		if(!running) {
			
			if(winner)
				outcome = "Bomb defused!";
			else
				outcome = "The bomb exploded, and you with it.";
		}
	}

	@Override
	public void draw(Graphics g) {
		bg.draw(g);
		
		bomb.draw(g);
		
		// draw input on keypad
		g.drawString(code.toString(), code_x, code_y);
		
		// draw clipboard
		g.setFont(clipboard_font);
		g.setColor(Color.BLACK);
		g.drawString("Attempts remaining: " + bomb.getAttemptsRemaining(), attempts_x, attempts_y);

		// draw rectangle for keypad press
		g.setColor(key_press_color);
		if(keyEntered) {
			java.awt.Point p = kp.getKey(keyVal);
			g.fillRect(p.x, p.y, KeyPad.key_width, KeyPad.key_height);
		}
		
//		// print each attempt to the clipboard
//		for(int i = 0; i < clipboard.size(); i++) {
//			digit_padding = 0;
//			
//			cb_x = clipboard_x + (130 * (i / 6));
//			cb_y = clipboard_y + (28 * (i % 6));
//			
//			// the numbers within the strings are colored respective to their position in the bomb_code 
//			for(int j = 0; j < clipboard.get(i).length(); j++) {
//				if(clipboard.get(i).charAt(j) == bomb_code.charAt(j)) {
//					g.setColor(correct_position);
//				} else if (bomb_code.indexOf(clipboard.get(i).charAt(j)) >= 0) {
//					g.setColor(correct_number);
//				} else {
//					g.setColor(Color.BLACK);
//				}
//				
//				g.drawString("" + clipboard.get(i).charAt(j), cb_x + digit_padding, cb_y);
//				digit_padding += 20;
//			}
//		}
		
		
		// print final outcome
		if(!running) {
			g.setColor(Color.BLACK);
			g.setFont(new Font("Arial", Font.BOLD, 36));
			g.drawString(outcome, outcome_x, outcome_y);
			g.setFont(new Font("Arial", Font.BOLD, 22));
			g.drawString("Press Enter to continue...", outcome_x, outcome_y + 22);
		}
	}

	@Override
	public void keyPressed(int k) {
		if(!running && k == KeyEvent.VK_ENTER) {
			if(winner) gsm.setState(GameStateManager.LEVEL_STATE);
			else gsm.setState(GameStateManager.MENU_STATE);
		}
		if(!running) return;
		
		if(k >= KeyEvent.VK_0 && k <= KeyEvent.VK_9) {
			keyEntered = true;
			keyVal = Integer.parseInt(KeyEvent.getKeyText(k));
			
			addDigitToCode(keyVal);
		}
		
		if(k >= KeyEvent.VK_NUMPAD0 && k <= KeyEvent.VK_NUMPAD9) {
			keyEntered = true;
			keyVal = Integer.parseInt(KeyEvent.getKeyText(k - (KeyEvent.VK_NUMPAD0 - KeyEvent.VK_0)));
			
			addDigitToCode(keyVal);
		}
		
		
	}

	@Override
	public void keyReleased(int k) {
		keyEntered = false;
	}
	
	@Override
	public void mousePressed(int x, int y) {
		if(x < KeyPad.keypad_x || y < KeyPad.keypad_y) return;
		
		if(kp.getKey(x, y) != -1) {
			keyEntered = true;
			keyVal = kp.getKey(x, y);
			
			addDigitToCode(keyVal);
		}
	}
	
	@Override
	public void mouseReleased(int x, int y) {
		keyEntered = false;
	}
}
