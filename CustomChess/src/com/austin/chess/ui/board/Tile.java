package com.austin.chess.ui.board;

import java.awt.Point;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends StackPane {
	
	public static final int WIDTH = 100;
	public static final int HEIGHT = 100;

	private Point position;
	
	private Rectangle background;
	
	public Tile(ChessBoard board, Point position, Color color) {
		this.position = position;
		
		background = new Rectangle(WIDTH, HEIGHT);
		background.setFill(color);
		
		getChildren().add(background);
		
		setOnMouseClicked(this::onMouseClicked);
	}
	
	public void onMouseClicked(MouseEvent e) {
		System.out.println(position.toString());
	}
	
	public Point getPosition() { return position; }
}
