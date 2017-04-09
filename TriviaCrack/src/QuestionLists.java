import java.util.ArrayList;
import java.util.Random;


public class QuestionLists {
	
	private ArrayList<Question> entertainment;
	private ArrayList<Question> art;
	private ArrayList<Question> sports;
	private ArrayList<Question> history;
	private ArrayList<Question> science;
	private ArrayList<Question> geography;
	
	private Random rand = new Random();
	
	public QuestionLists() {
		entertainment = new ArrayList<Question>();
		art = new ArrayList<Question>();
		sports = new ArrayList<Question>();
		history = new ArrayList<Question>();
		science = new ArrayList<Question>();
		geography = new ArrayList<Question>();
	}
	
	public QuestionLists(ArrayList<Question> entertainment, ArrayList<Question> art, ArrayList<Question> sports,
			ArrayList<Question> history, ArrayList<Question> science, ArrayList<Question> geography) {
		this.entertainment = entertainment;
		this.art = art;
		this.sports = sports;
		this.history = history;
		this.science = science;
		this.geography = geography;
	}
	
	public void addQuestion(Question q) {
		switch (q.getCategory()) {
		case ENTERTAINMENT:
			entertainment.add(q);
			break;
		case ART:
			art.add(q);
			break;
		case SPORTS:
			sports.add(q);
			break;
		case HISTORY:
			history.add(q);
			break;
		case SCIENCE:
			science.add(q);
			break;
		case GEOGRAPHY:
			geography.add(q);
			break;
		default:
			System.out.println("Question not added.");
			break;
		}
	}
	
	public Question getQuestion(int i) {
		// 0 - entertainment, 1 - art, 2 - sports, 3 - history, 4 - science, 5 - geography
		
		Question q;
		
		switch (i) {
		case 0:
			q = getEntertainment();
			break;
		case 1:
			q = getArt();
			break;
		case 2:
			q = getSports();
			break;
		case 3:
			q = getHistory();
			break;
		case 4:
			q = getScience();
			break;
		case 5:
			q = getGeography();
			break;
		default:
			q = new Question(Category.ENTERTAINMENT, "Should this questions have ever been called?", "no", "no", "no", "no");
			break;
		}
		
		return q;
	}
	
	public Question getEntertainment() {
		return entertainment.get(rand.nextInt(entertainment.size()));
	}
	public Question getArt() {
		return art.get(rand.nextInt(art.size()));
	}
	public Question getSports() {
		return sports.get(rand.nextInt(sports.size()));
	}
	public Question getHistory() {
		return history.get(rand.nextInt(history.size()));
	}
	public Question getScience() {
		return science.get(rand.nextInt(science.size()));
	}
	public Question getGeography() {
		return geography.get(rand.nextInt(geography.size()));
	}
}
