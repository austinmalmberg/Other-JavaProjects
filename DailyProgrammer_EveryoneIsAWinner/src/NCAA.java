import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class NCAA {

	private List<Game> games;
	private Map<String, Team> teams;
	
	private GameParser parser;
	
	public NCAA() {
		games = new ArrayList<Game>();
		teams = new TreeMap<String, Team>();
		
		parser = new GameParser(this);
	}
	
	public NCAA(int season, String[] gameList) {
		this();
		
		addNewSeason(season, gameList);
	}
	
	public void addNewSeason(int season, String[] gameList) {		
		for(String game : gameList) {
			games.add(parser.get(season, game));
		}
	}
	
	public Team getTeam(String name) {
		return teams.containsKey(name) ? teams.get(name) : null;
	}
	
	public void addTeam(String name) {
		teams.put(name, new Team(name));
	}
	
	public List<Game> getGamesBySeason(int season) {
		return games.stream().filter(g -> g.getSeason() == season).collect(Collectors.toList());
	}
	
	public void printTeams() {
		teams.values().stream().forEach(System.out::println);
	}
	
	public void printGames() {
		games.stream().forEach(System.out::println);
	}
	
	public void printGamesBySeason(int season) {
		getGamesBySeason(season).stream().forEach(System.out::println);
	}
}
