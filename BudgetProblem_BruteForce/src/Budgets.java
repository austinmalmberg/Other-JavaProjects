import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;

public class Budgets {
	
	InputHelper input;
	
	BigDecimal budget;
	ArrayList<BigDecimal> expenses;
	
	
	public Budgets() {
		input = new InputHelper();
		
		expenses = new ArrayList<BigDecimal>();
		
		budget = new BigDecimal(2590.17);
		
		expenses.add(new BigDecimal(161.74));
		expenses.add(new BigDecimal(430.86));
		expenses.add(new BigDecimal(155.23));
		expenses.add(new BigDecimal(101.97));
		expenses.add(new BigDecimal(66.90));
		expenses.add(new BigDecimal(61.43));
		expenses.add(new BigDecimal(3.57));
		expenses.add(new BigDecimal(1043.27));		
		expenses.add(new BigDecimal(86.54));
		expenses.add(new BigDecimal(506.88));
		expenses.add(new BigDecimal(208.49));
		expenses.add(new BigDecimal(216.91));
		
		
		System.out.printf("Budget: $%,.2f%n", budget);
		System.out.printf("Expense Total: $%,.2f%n", getSpending(expenses));
		
		closeNotOver();
	}
	
//	public void getInfo() {
//		// get budget amount
//		budget = new BigDecimal(input.getDouble("Enter the budget amount: $", 0.00, 0.00));
//		
//		BigDecimal d = new BigDecimal(input.getDouble("Enter expense amount (enter 0 to stop): $", 0.00, 0.00));
//		while (d.doubleValue() != 0.0) {  // get expenses
//			expenses.add(d);
//			
//			d = new BigDecimal(input.getDouble("Enter expense amount (enter 0 to stop): $", 0.00, 0.00));			
//		};
//	}
	
	public BigDecimal getSpending(ArrayList<BigDecimal> x) {
		
		
		BigDecimal total = new BigDecimal(0);
		for(int i = 0; i < x.size(); i++) {
			total = total.add(x.get(i));
		}
		
		return total;
	}
	
	public void closeNotOver() {
		BigDecimal overBudget = getSpending(expenses).subtract(budget);
		if(overBudget.doubleValue() <= 0) {
			System.out.printf("Under budget by $%,.2f.%n", overBudget.negate());
			return;
		} else {
			System.out.printf("Over budget by $%,.2f.%n", overBudget);
		}
		
		// warning: complicated loop below
		Random rnd = new Random();
		
		ArrayList<BigDecimal> temp = new ArrayList<>();
		ArrayList<BigDecimal> newTemp = new ArrayList<>();
		ArrayList<BigDecimal> winner = new ArrayList<>();
		winner.add(getSpending(expenses));
		
		for(int i = 0; i < 10000; i++) {
			
			temp = new ArrayList<>(expenses);
			while(getSpending(temp).compareTo(overBudget) > 0) {
				newTemp = new ArrayList<>(temp);
				temp.remove(rnd.nextInt(temp.size()));
			}
			
			// if the list expenses are less than the current winner and greater than or equal to overbudget
			if(getSpending(newTemp).compareTo(getSpending(winner)) < 0 && getSpending(newTemp).compareTo(overBudget) >= 0) {
				winner = new ArrayList<>(newTemp);
			}
		}
		
		System.out.printf("Total: %,.2f%n", getSpending(winner));
		for(int i = 0; i < winner.size(); i++) {
			System.out.printf("%,.2f%n", winner.get(i));
		}
	}
}
