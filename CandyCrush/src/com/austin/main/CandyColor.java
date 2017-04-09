package com.austin.main;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public enum CandyColor {
	RED(Color.valueOf("#b31800")),		// circle
	ORANGE(Color.valueOf("#ff4400")),	// triangle
	YELLOW(Color.GOLD),					// square
	GREEN(Color.GREEN),					// hexagon
	BLUE(Color.ROYALBLUE),				// diamond
	PURPLE(Color.PURPLE);				// octagon
	
	// pentagon, star, heart, crescent, half moon
	
	Color color;
	Shape shape;
	
	CandyColor(Color color) {
		this.color = color;
	}
	
	Color getColor() {		
		return color;
	}
	
	Shape getShape() {		
		return shape;
	}
}
