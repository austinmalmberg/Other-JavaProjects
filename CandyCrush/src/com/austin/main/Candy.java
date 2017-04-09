package com.austin.main;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

public class Candy extends StackPane {
	
	public static final double scale = 0.9; 
	public static final double radius = CandyCrush.TILE_SIZE * scale / 2;
	
	private CandyColor color;
	private CandyType type;
	private Shape shape;

	private int row;
	private int col;
	
	private boolean moveable;
	
	public Candy(CandyType type, CandyColor color, int x, int y) {
		row = 0;	// value set in move(x, y)
		col = 0;	// value set in move(x, y)
		
		this.type = type;
		this.color = color;
		
		shape = new Circle(radius);
		shape.setFill(color.getColor());
		shape.setStroke(Color.DARKGRAY);
		
		// centers candy in tile
		setTranslateX((CandyCrush.TILE_SIZE - 2 * radius) / 2);
		setTranslateY((CandyCrush.TILE_SIZE - 2 * radius) / 2);
		
		move(x, y);
		
		getChildren().add(shape);
	}
	
	public boolean isMovable() {
		// false is on bottom row
		// false if tile below, left, and right are blocked
		// false if tile below, left, and right are blocked
		
		return moveable;
	}
	public void isMoveable(boolean moveable) {
		this.moveable = moveable;
	}
	
	public void setCandy(CandyType type, CandyColor color) {
		this.type = type;
		this.color = color;
				
		shape.setFill(color.getColor());
	}
	
	public CandyColor getCandyColor() {
		return color;
	}
	
	public CandyType getCandyType() {
		return type;
	}
	
	public void move(int x, int y) {
		row = x;
		col = y;
		
		setLayoutX(x * CandyCrush.TILE_SIZE);
		setLayoutY(y * CandyCrush.TILE_SIZE);
	}
	
	public int getRow() {
		return row;
	}
	public int getCol() {
		return col;
	}
}
