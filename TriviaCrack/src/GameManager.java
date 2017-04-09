import java.util.Random;

public class GameManager {
	
	private Random rand = new Random();
	private InputHelper input = new InputHelper();
	
	private Player p1;
	private Player p2;
	
	private QuestionLists questions;
	
	public GameManager(Player p1, Player p2) {
		this.p1 = p1;
		this.p2 = p2;
		
		questions = new QuestionLists();
	}
	public GameManager(QuestionLists questions, Player p1, Player p2) {
		this.p1 = p1;
		this.p2 = p2;
		
		this.questions = questions;
	}
	
	public void startGame() {
		getFirstTurn();
		
		
		
		// game loop
		do {
			// if neither player wins, carry on
			if (!p2.wins()) { play(p1); }
			if (!p1.wins()) { play(p2); }
			
			p1.setTurn(true);
			p2.setTurn(true);
		} while(!p1.wins() && !p2.wins());
	}
	
	private void play(Player p) {
		if (!p.getTurn()) { return; }
		
		int choice;
		
		System.out.println("\n" + p.name + "'s turn!");
		
		do {
			if (answerQuestion(rand.nextInt(Category.size()))) {  // answer question
				if(p.counterFull()) {  // if the counter is full
					choice = chooseCategory(p);  // choose category
					if (answerQuestion(choice)) {  // ask another question
						p.setCategory(choice, true);  // if correct, set category to true
					}
				}
			} else {
				p.setTurn(false);
			}
		} while(p.getTurn() && !p.wins());
		
		if (p.wins()) {
			System.out.println(p.name + "wins!!!");
		}
	}
	
	private boolean answerQuestion(int category) {
		
		Question q;
		int ans;
		
		q = questions.getQuestion(category);
		q.print();  // ask question based on category
		ans = input.getInt("Your choice: ", 1, 4) - 1;  // get answer
		
		if (q.isCorrect(ans)) {
			System.out.println("You're correct!");
			return true;
		} else {
			System.out.println("Sorry, the correct answer was \"" + q.getAnswer() + "\"");
			return false;
		}
	}
	
	private int chooseCategory(Player p) {
		int ans;
		boolean invalid = true;
		
		System.out.println("The next question is for a dude.  Choose your category:");
		
		for (int i = 0; i < p.getCategories().length; i++) {
			if(!p.getCategories()[i]) {  // if category is false, print
				System.out.println((i + 1) + ". " + Category.getCategoryName(i));
			}
		}
		
		do {
			ans = input.getInt("Your choice: ", 1, 6) - 1;  // subtract 1 to align with array
			if (!p.getCategories()[ans]) {  // if the selected category is false then break loop
				invalid = false;
			} else {
				System.out.println("You already have that dude!");
			}
		} while(invalid);
		
		return ans;
	}
	
	private void getFirstTurn() {
		p2.setTurn(true);
		
		if (rand.nextBoolean()) {	// p1 goes first
			p1.setTurn(true);
		} else {					// p2 goes first
			p1.setTurn(false);
		}
	}
}
