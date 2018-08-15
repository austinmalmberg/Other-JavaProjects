import java.util.ArrayList;
import java.util.List;

public class Team implements Comparable<Team>{

	String name;
	List<Game> games;
	
	public Team(String name) {
		this.name = name;
		
		games = new ArrayList<Game>();
	}
	
	public String toString() { return name; }

	@Override
	public int compareTo(Team o) {
		return name.compareTo(o.name);
	}
}
