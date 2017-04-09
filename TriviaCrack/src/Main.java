import java.util.ArrayList;


public class Main {
	public static void main(String[] args) {
		ArrayList<Question> entertainment = new ArrayList<Question>();
		ArrayList<Question> art = new ArrayList<Question>();
		ArrayList<Question> sports = new ArrayList<Question>();
		ArrayList<Question> history = new ArrayList<Question>();
		ArrayList<Question> science = new ArrayList<Question>();
		ArrayList<Question> geography = new ArrayList<Question>();
		
		entertainment.add(new Question(Category.ENTERTAINMENT, "Are you not entertained?", "Yes", "", "", ""));
		art.add(new Question(Category.ART, "How do you make green?", "Yes", "", "", ""));
		sports.add(new Question(Category.SPORTS, "What shape is a basketball?", "Yes", "", "", ""));
		history.add(new Question(Category.HISTORY, "When did 9/11 happen?", "Yes", "", "", ""));
		science.add(new Question(Category.SCIENCE, "What is your largest organ?", "Yes", "", "", ""));
		geography.add(new Question(Category.GEOGRAPHY, "Where are you?", "Yes", "", "", ""));
		
		GameManager gm = new GameManager(new QuestionLists(entertainment, art, sports, history, science, geography), new Player("Bob"), new Player("Joe"));
		gm.startGame();
	}
}
