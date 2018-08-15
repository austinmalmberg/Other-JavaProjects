import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Game {
	
	private int season;
	private Date date;
	private DateFormat df;
	
	private Team winner;
	private int winner_score;
	
	private Team loser;
	private int loser_score;
	
	public Game() {
		df = new SimpleDateFormat("yyyy-MM-dd");
	}
	
	public Game(int season, Date date, Team winner, int winner_score, Team loser, int loser_score) {
		this();
		
		this.season = season;
		this.date = date;
		
		this.winner = winner;
		this.winner_score = winner_score;
		
		this.loser = loser;
		this.loser_score = loser_score;
	}
	
	public int getSeason() { return season; }
	public Team getWinner() { return winner; }
	public Team getLoser() { return loser; }
	
	public String toString() {
		return String.format("%s beat %s %d-%d on %s", winner.toString(), loser.toString(), winner_score, loser_score, df.format(date));
	}
}
