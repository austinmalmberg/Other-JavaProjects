package com.austin.chess.ui.board;

import java.awt.Point;
import java.io.File;
import java.nio.file.Paths;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends StackPane {
	
	public static final int WIDTH = 100;
	public static final int HEIGHT = 100;

	private Point position;
	
	private Rectangle background;
	private ImageView piece;
	
	public Tile(ChessBoard board, Point position, Color color) {
		this.position = position;
		
		background = new Rectangle(WIDTH, HEIGHT);
		background.setFill(color);
		
//		File f = new File("resources/Chess_rlt60.png");
		
		piece = new ImageView();
		
		getChildren().add(background);
		getChildren().add(piece);
		
		setOnMouseClicked(this::onMouseClicked);
	}
	
	public void setPieceImage(ImageView image) {
		piece = image;
	}
	
	public void onMouseClicked(MouseEvent e) {

	}
	
	public Point getPosition() { return position; }
}
