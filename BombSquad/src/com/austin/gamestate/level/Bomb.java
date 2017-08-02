package com.austin.gamestate.level;

import java.awt.Color;
import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;

public class Bomb {
	private int level;  // number of previous defuses
	
	private String defuse_code;  // the bomb code
	private boolean defused;
	private boolean detonated;
	
	private Color color;
	private Font font;
	
	// timer variables	
	private Timer timer;
	private int time_in_secs;
	private int time_in_ms;
	private TimerTask task_timer;
	
	private String time_formatted;
	
	private boolean visible;  // blinks when near detonation
	private final int blink_duration = 100;  // the number of milliseconds the timer is not visible
	private int blink_delay;
	
	private final int default_time_in_secs = 45;
	private final int default_digits = 4;
	private final int default_attempts_remaining = 12;
	
	private int digits;
	private boolean digits_repeatable;
	
	private int attempts_remaining;
	
	// positioning
	private final int timer_x = 3;
	private final int timer_y = 174;
	
	Bomb(int level) {
		this.level = level <= 15 ? level : 0;  // restart after capping level at 15
		
		color = new Color(175, 0, 0);
		font = new Font("Courier", Font.BOLD, 46);
		
		timer = new Timer();
		
		init();
	}
	
	private String generateCode(int digits) {
		StringBuilder sb = new StringBuilder();
		
		java.util.Random rand = new java.util.Random();	
		
		while(sb.length() < digits) {
			int i = rand.nextInt(10);
			
			if(digits_repeatable) {
				sb.append(i);  // append random int
			} else {
				if(sb.toString().indexOf(""+i) < 0)  // append random int only if not previously used
					sb.append(i);
			}
		}
		
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	private void setDifficulty(int level) {
		int time_mod;
		
		digits = default_digits + (level / 6);
		
		digits_repeatable = level % 6 > 3 ? true : false;
		
		time_mod = digits_repeatable ? 5 : 10;
		time_in_secs = default_time_in_secs - (time_mod * (level % 6));
		
		attempts_remaining = default_attempts_remaining - (1 * (level % 6));
		
//		switch(level) {
//		case 0:
//		case 1:
//		case 2:
//		case 3:
//		case 4:
//		case 5:
//		case 6:
//		case 7:
//		case 8:
//		case 9:
//		case 10:
//		case 11:
//		case 12:
//		case 13:
//		case 14:
//		case 15:
//		}
	}
	
	private int setBlinkDelay(int time_in_ms) {
		if(time_in_ms < 2000) return 2;  // blink ever quarter second
		if(time_in_ms < 5000) return 5;  // blink every half second
		if(time_in_ms < 10000) return 10;  // blink every second
		
		return 0;
	}
	
	public void enterCode(String user_code) {
		attempts_remaining--;
		
		defused = defuse_code.equals(user_code);
		
		detonated = attempts_remaining == 0 ? true : false;
	}
	
	public int getDigits() { return digits; }
	public int getAttemptsRemaining() { return attempts_remaining; }
	public boolean isDefused() { return defused; }
	
	public void init() {		
		visible = true;
		
		setDifficulty(level);
		
		defuse_code = generateCode(digits);
		
		defused = false;
		
		time_in_ms = time_in_secs * 1000;
		
		task_timer = new TimerTask() {
			
			@Override
			public void run() {
				if(time_in_ms > 0) time_in_ms--;
			}
		};
		
		timer.scheduleAtFixedRate(task_timer, 0, 1);
		
		blink_delay = 1;
	}

	public void update() {
		int centiseconds = time_in_ms % 100;
		int seconds = (time_in_ms / 1000) % 60;
		int minutes = (time_in_ms / (1000 * 60)) % 60; 
		int hours = (time_in_ms / (1000 * 60 * 60)) % 24;
		time_formatted = String.format("%02d:%02d:%02d:%02d", hours, minutes, seconds, centiseconds);
	
		detonated = time_in_ms <= 0 ? true : false;
		
		if(defused || detonated) task_timer.cancel();
	
		if(time_in_ms < 10000) blink_delay = setBlinkDelay(time_in_ms);				
	}
	
	public void draw(java.awt.Graphics g) {
		g.setColor(color);
		g.setFont(font);
		
		if(time_in_ms < 10100) {
			long elapsed = (System.nanoTime() / 1000000) - blink_duration;
			if(time_in_ms > 0 && elapsed / 100 % blink_delay == 0) {
				return;
			}
		}
		
		g.drawString(time_formatted, timer_x, timer_y);
	}

	public String getCode() {
		return defuse_code;
	}
}
