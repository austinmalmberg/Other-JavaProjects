package com.austin.chess.board.objects;
import javafx.scene.layout.StackPane;

public abstract class BoardObject extends StackPane {
	
	protected Coordinate pos;

	public BoardObject(Coordinate pos) {
		this.pos = pos;
		
		setTranslate(pos.getPosX(), pos.getPosY());
	}
	
	protected void setTranslate(double x, double y) {
		setTranslateX(x);
		setTranslateY(y);
	}
	
	public Coordinate getCoordinates() { return pos; }
}