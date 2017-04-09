package com.austin.gamestate.level;

import java.awt.Point;

public class KeyPad {
	
	// positioning variables
	protected static int keypad_x = 325;
	protected static int keypad_y = 205;
	
	protected static int key_width = 104;
	protected static int key_height = 68;
	
	public KeyPad() {}	
	
	public int getKey(int x, int y) {
		int key = -1;
		
		outer:
		for(int i = 1; i < 5; i++) {
			if(y < keypad_y + key_height * i) {
				for(int j = 1; j < 4; j++) {
					if( x < keypad_x + key_width * j) {
						key = j + (i - 1) * 3;
						break outer;
					}
				}
			}
		}
		
		if(key == 10 || key > 11) return -1;  // return -1 if * or #
		return key == 11 ? 0 : key;
	}
	
	public Point getKey(int k) {
		int mod_x = 0;
		int mod_y = 0;
		
		if(k >= 1 && k <= 3) mod_y = 0;
		if(k >= 4 && k <= 6) mod_y = 1;
		if(k >= 7 && k <= 9) mod_y = 2;
		
		if(k == 1 || k == 4 || k == 7) mod_x = 0;
		if(k == 2 || k == 5 || k == 8) mod_x = 1;
		if(k == 3 || k == 6 || k == 9) mod_x = 2;
		
		if(k == 0) {
			mod_x = 1;
			mod_y = 3;
		}
		
		return new Point(keypad_x + key_width * mod_x, keypad_y + key_height * mod_y);
	}
}
