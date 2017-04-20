import java.util.ArrayList;


public class Main {
	public static void main(String[] args) {
		ArrayList<Question> entertainment = new ArrayList<Question>();
		ArrayList<Question> art = new ArrayList<Question>();
		ArrayList<Question> sports = new ArrayList<Question>();
		ArrayList<Question> history = new ArrayList<Question>();
		ArrayList<Question> science = new ArrayList<Question>();
		ArrayList<Question> geography = new ArrayList<Question>();
		
		entertainment.add(new Question(Category.ENTERTAINMENT, "Are you not entertained?", "Yes", "No", "No", "No"));
		art.add(new Question(Category.ART, "How do you make green?", "Blue and Yellow --Correct", "Red and Blue", "Yellow and Red", "Orange"));
		sports.add(new Question(Category.SPORTS, "What shape is a basketball?", "Sphere --Correct", "Circle", "Cube", "Orange"));
		history.add(new Question(Category.HISTORY, "When did 9/11 happen?", "September 11, 2001 --Correct", "November 9, 2001", "September 11, 2002", "Police"));
		science.add(new Question(Category.SCIENCE, "What is your largest organ?", "Skin --Correct", "Liver", "Heart", "Brain"));
		geography.add(new Question(Category.GEOGRAPHY, "Where are you?", "Here --Correct", "There", "Alli", "Alla"));
		
		GameManager gm = new GameManager(new QuestionLists(entertainment, art, sports, history, science, geography), new Player("Bob"), new Player("Joe"));
		gm.startGame();
	}
}
