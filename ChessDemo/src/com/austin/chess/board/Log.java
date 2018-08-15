package com.austin.chess.board;
import com.austin.chess.ChessDemo;
import com.austin.chess.board.objects.Coordinate;
import com.austin.chess.board.objects.Piece;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class Log extends StackPane {

	public static final int WIDTH = 400; 
	
	private Board board;
	
	public Log(Board board) {
		this.board = board;
		
		setPrefSize(WIDTH, ChessDemo.HEIGHT);
		
		setTranslateX(Board.WIDTH);
		setTranslateY(0);
		
		setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, null, null)));
	}

	public void update(Piece piece, Coordinate src, Coordinate dest) {
		
		
	}
}
