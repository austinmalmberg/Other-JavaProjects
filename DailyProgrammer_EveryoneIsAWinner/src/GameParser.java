import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GameParser {
	
	private NCAA ncaa;
	
	private DateFormat df;
	
	public GameParser(NCAA ncaa) {
		this.ncaa = ncaa;
		
		df = new SimpleDateFormat("yyyy-MM-dd");
	}
	
	public Game get(int season, String input) {
		
		try {
			String winningTeamName = input.substring(11, 36).trim().replaceAll("@", "");			
			if(ncaa.getTeam(winningTeamName) == null)
				ncaa.addTeam(winningTeamName);
			
			String losingTeamName = input.substring(39, 65).trim().replaceAll("@", "");
			if(ncaa.getTeam(losingTeamName) == null)
				ncaa.addTeam(losingTeamName);
			
			Date date = df.parse(input.substring(0, 10).trim());
			Team winner = ncaa.getTeam(winningTeamName);
			int winnersScore = Integer.parseInt(input.substring(36, 39).trim());
			Team loser = ncaa.getTeam(losingTeamName);
			int losersScore = Integer.parseInt(input.substring(65, 68).trim());
			
			return new Game(season, date, winner, winnersScore, loser, losersScore);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
