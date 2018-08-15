import java.io.File;
import java.nio.file.Files;

// https://www.reddit.com/r/dailyprogrammer/comments/8ewq2e/20180425_challenge_358_intermediate_everyones_a/

public class Main {

	public static void main(String[] args) {
		
		NCAA ncaa = new NCAA();
		ncaa.addNewSeason(2018, getFileAsStringArray("2018_games.txt"));

		TransitiveChampionsList transitiveChamps = new TransitiveChampionsList(ncaa.getGamesBySeason(2018), ncaa.getTeam("Villanova"));
		transitiveChamps.print();
		System.out.println(transitiveChamps.getSize());
	}
	
	public static String[] getFileAsStringArray(String fileName) {
		
		try {
			return Files.lines(new File(fileName).toPath()).toArray(String[]::new);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
