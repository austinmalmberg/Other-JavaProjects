package com.chess.engine.board;

import java.util.HashMap;
import java.util.Map;

import com.chess.engine.piece.Piece;

public abstract class Tile {

	protected final int tileCoordinate;
	
	private static final Map<Integer, EmptyTile> EMPTY_TILES = createAllEmptyTiles();
	
	private static Map<Integer, EmptyTile> createAllEmptyTiles() {
		
		final Map<Integer, EmptyTile> emptyTileMap = new HashMap<>();
		
		for(int i = 0; i < 64; i++) {
			emptyTileMap.put(i, new EmptyTile(i));
		}
		
		return ImmutableMap.copyOf(emptyTileMap);
	}
	
	Tile(final int tileCoordinate) {
		this.tileCoordinate = tileCoordinate;
	}
	
	public abstract boolean isOccupied();
	public abstract Piece getPiece();
	
	public static final class EmptyTile extends Tile {
		
		EmptyTile(int tileCoordinate) {
			super(tileCoordinate);
		}
		
		@Override
		public boolean isOccupied() {
			return false;
		}
		
		@Override
		public Piece getPiece() {
			return null;
		}
	}
	
	public static final class OccupiedTile extends Tile {
		
		private final Piece piece;
		
		OccupiedTile(int tileCoordinate, Piece piece) {
			super(tileCoordinate);
			this.piece = piece;
		}
		
		@Override
		public boolean isOccupied() {
			return true;
		}
		
		@Override
		public Piece getPiece() {
			return piece;
		}
	}
}
