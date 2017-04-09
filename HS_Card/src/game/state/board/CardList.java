package game.state.board;

import game.card.Minion;

import java.util.ArrayList;

public class CardList {
	private ArrayList<Minion> board;
	
	public CardList() {
		
	}
	
	public void add(Minion m) {
		board.add(m);
	}
	
	public ArrayList<Minion> get() {
		return board;
	}
}
