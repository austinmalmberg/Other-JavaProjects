package com.austin.chess.board;
import javafx.scene.paint.Color;

public enum Player {
	BLACK(Color.BLACK),
	WHITE(Color.WHITE);
	
	private Color color;
	
	Player(Color color) {
		this.color = color;
	}
	
	public Color getColor() { return color; }
}
