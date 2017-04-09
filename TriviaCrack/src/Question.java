import java.util.Collections;
import java.util.ArrayList;


public class Question {

	private Category category;
	private String question;
	private ArrayList<String> choices;
	private String answer;
	
	public Question(Category category, String question, String answer, String c1, String c2, String c3) {
		choices = new ArrayList<String>();
		
		this.category = category;
		this.question = question;
		this.answer = answer;
		
		choices.add(answer);
		choices.add(c1);
		choices.add(c2);
		choices.add(c3);
	}
	
	public Category getCategory() { return category; }
	
	public void print() {
		Collections.shuffle(choices);
		
		System.out.println("\n-----" + category.toString() + "-----");
		System.out.println(question);
		
		for (int i = 0; i < choices.size(); i++) {
			System.out.println((i + 1) + ". " + choices.get(i));
		}
	}
	
	public String getAnswer() { return answer; }
	
	public boolean isCorrect(int i) {
		if (choices.get(i).equals(answer)) { return true; }
		
		return false;
	}
}
