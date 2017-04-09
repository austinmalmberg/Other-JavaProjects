package com.austin.map;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Background {

	BufferedImage image;
	
	private double x;
	private double y;
	
	public Background(String s) {
		try {
			image = ImageIO.read(getClass().getResourceAsStream(s));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setPosition(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public void update() {}
	
	public void draw(Graphics g) {
		g.drawImage(image, (int)x, (int)y, null);
	}
}
