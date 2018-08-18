package com.austin.chess.ui.board;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

import com.austin.chess.logic.board.Board;
import com.austin.chess.logic.piece.Piece;
import com.austin.chess.logic.piece.PieceColor;
import com.austin.chess.logic.piece.PieceType;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;

public class ChessBoard extends FlowPane {
	
	// change board constants to these constants
	public static final int ROWS = 8;
	public static final int COLUMNS = 8;
	
	private Board board;
	
	private Map<PieceType, Map<PieceColor, ImageView>> pieceImageMap;
	
	public static final Color[] TILE_COLORS = {Color.BLANCHEDALMOND, Color.GRAY}; 

	public ChessBoard(int boardstate, int ruleset) {
		super();
		
		setPrefSize(COLUMNS * Tile.WIDTH, ROWS * Tile.HEIGHT);		
		
		board = new Board(boardstate, ruleset);
		
		initializePieceImageMap();
		
		Piece[][] pieceArr = board.getBoard();
		for(int r = 0; r < pieceArr.length; r++) {
			for(int c = 0; c < pieceArr.length; c++) {
				Point location = new Point(ROWS-1 - r, c);
				Tile t = new Tile(this, location, TILE_COLORS[(r+c) % 2]);
				getChildren().add(t);
				
				Piece piece = board.getPiece(location);
				if(piece != null) {
					ImageView sprite = pieceImageMap.get(piece.type()).get(piece.color());
					t.setPieceImage(sprite);
				}
			}
		}
		
//		getChildren().add(new ImageView("file:ChessPiecesArray.png"));
		
		setOnMouseDragged(this::onMouseDragged);
		setOnMouseClicked(this::onMouseClicked);
		setOnMousePressed(this::onMousePressed);
		setOnMouseReleased(this::onMouseReleased);
	}
	
	// maybe create class to initialize images?
	@SuppressWarnings("serial")
	public void initializePieceImageMap() {
		pieceImageMap = new HashMap<PieceType, Map<PieceColor, ImageView>>() {
			{
				put(PieceType.ROOK, new HashMap<PieceColor, ImageView>() {
					{
						put(PieceColor.WHITE, new ImageView("file:/resources/Chess_rlt60.png"));
						put(PieceColor.BLACK, new ImageView("file:/resources/Chess_rdt60.png"));
					}
				});
				
				put(PieceType.KNIGHT, new HashMap<PieceColor, ImageView>() {
					{
						put(PieceColor.WHITE, new ImageView("file:/resources/Chess_nlt60.png"));
						put(PieceColor.BLACK, new ImageView("file:/resourcesChess_ndt60.png"));
					}
				});
				
				put(PieceType.BISHOP, new HashMap<PieceColor, ImageView>() {
					{
						put(PieceColor.WHITE, new ImageView("file:/resources/Chess_blt60.png"));
						put(PieceColor.BLACK, new ImageView("file:/resources/Chess_bdt60.png"));
					}
				});
				
				put(PieceType.QUEEN, new HashMap<PieceColor, ImageView>() {
					{
						put(PieceColor.WHITE, new ImageView("file:/resources/Chess_qlt60.png"));
						put(PieceColor.BLACK, new ImageView("file:/resources/Chess_qdt60.png"));
					}
				});
				
				put(PieceType.KING, new HashMap<PieceColor, ImageView>() {
					{
						put(PieceColor.WHITE, new ImageView("file:/resources/Chess_klt60.png"));
						put(PieceColor.BLACK, new ImageView("file:/resources/Chess_kdt60.png"));
					}
				});
				
				put(PieceType.PAWN, new HashMap<PieceColor, ImageView>() {
					{
						put(PieceColor.WHITE, new ImageView("file:/resources/Chess_plt60.png"));
						put(PieceColor.BLACK, new ImageView("file:/resources/Chess_pdt60.png"));
					}
				});
			}
		};
	}
	
	public void onMouseDragged(MouseEvent e) {

	}
	
	public void onMouseClicked(MouseEvent e) {
		
	}
	
	public void onMousePressed(MouseEvent e) {
		
	}
	
	public void onMouseReleased(MouseEvent e) {
		
	}
}
