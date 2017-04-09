package com.austin.main;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
	
public class Tile extends Rectangle {
	
	private int row;
	private int col;
	
	private double x_pos;
	private double y_pos;
	
	TileType type;
	private Candy candy;	
	
	public Tile(TileType type, int x, int y) {
		this.type = type;
		
		candy = null;
		
		row = x;
		col = y;
		
		x_pos = x * CandyCrush.TILE_SIZE;
		y_pos = y * CandyCrush.TILE_SIZE;
		
		setWidth(CandyCrush.TILE_SIZE);
		setHeight(CandyCrush.TILE_SIZE);
		
		setLayoutX(x_pos);
		setLayoutY(y_pos);

		setFill(Color.ALICEBLUE);
		setStroke(Color.BLACK);
	}
	
	public boolean hasCandy() {
		return candy != null;
	}
	
	public Candy getCandy() {
		return candy;
	}
	
	public void setCandy(Candy candy) {
		this.candy = candy;
	}
	
	public TileType getTileType() {
		return type;
	}
	
	public double getX_Pos() {
		return x_pos;
	}
	public double getY_Pos() {
		return y_pos;
	}
	
	public int getRow() {
		return row;
	}
	public int getCol() {
		return col;
	}
}
