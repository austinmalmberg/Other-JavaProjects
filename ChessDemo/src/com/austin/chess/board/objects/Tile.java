package com.austin.chess.board.objects;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends BoardObject {

	public static final int TILE_SIZE = 120; // 120 for 8x8
	
	public static final Color DARK_TILE = Color.DIMGREY;
	public static final Color LIGHT_TILE = Color.CORNSILK;
	
	public static final Color HIGHLIGHT_LIGHT_TILE = Color.ANTIQUEWHITE;
	public static final Color HIGHLIGHT_DARK_TILE = Color.LIGHTGRAY;
	
	
	private Rectangle bg;
	private boolean light;
	
	public Tile(Coordinate pos, boolean light) {
		super(pos);
		this.light = light;
		
		bg = new Rectangle(TILE_SIZE, TILE_SIZE, light ? LIGHT_TILE : DARK_TILE);
		
		getChildren().add(bg);
	}
	
	public void setHighlight(boolean highlight) {
		
		if(highlight)
			bg.setFill(light ? HIGHLIGHT_LIGHT_TILE : HIGHLIGHT_DARK_TILE);
		else
			bg.setFill(light ? LIGHT_TILE : DARK_TILE);
	}
}
