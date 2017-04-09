package poker.bets;

public class Stack {
	private int stack;
	
	public Stack() {
		stack = 0;
	}
	
	public Stack(int amount) {
		stack = amount;
	}
	
	public int getStack() {
		return stack;
	}
	
	public void setStack(int i) {
		stack = i;
	}
	
	public void change(int i) {
		stack += i;
	}
	
}
