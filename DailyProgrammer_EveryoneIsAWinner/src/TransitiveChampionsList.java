import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class TransitiveChampionsList {

	private Set<Team> champs;
	private List<Game> games;
	
	public TransitiveChampionsList() {
		champs = new TreeSet<Team>();
	}
	
	public TransitiveChampionsList(List<Game> games, Team winner) {
		this();
		this.games = games;
		
		generateSet(winner);
	}
	
	private void generateSet(Team winner) {
		Set<Team> newChampSet = games.stream()
				.filter(game -> !champs.contains(game.getWinner()) && game.getLoser().equals(winner))
				.map(game -> game.getWinner())
				.collect(Collectors.toSet());
		
		champs.addAll(newChampSet);
		
		if(!newChampSet.isEmpty()) newChampSet.stream().forEach(team -> generateSet(team));
	}
	
	public void print() {
		champs.forEach(System.out::println);
	}
	
	public int getSize() { return champs.size(); }
}
