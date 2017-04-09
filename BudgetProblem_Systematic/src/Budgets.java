import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
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
		System.out.printf("Expense Total: $%,.2f%n", getTotal(expenses));
		
		// if expenses are more than the budget, find out which expenses should be removed
		// to get as close as possible to the budget cap without exceeding it
		if(getTotal(expenses).compareTo(budget) > 0) {
			displayFinal(getUnderBudget(expenses));
		} else {
			System.out.printf("You are under budget by %,.2f!%n", budget.subtract(getTotal(expenses)));
		}
	}
	
	/**
	 * Find the overAmt (how much the expenses are over the budget) so we can begin adding numbers together
	 * to find the smallest possible number over the overAmt.  Adding all the other expenses together will
	 * put us under the budget.
	 * 
	 * @param lst
	 * @return
	 */
	private ArrayList<BigDecimal> getUnderBudget(ArrayList<BigDecimal> lst) {
		// sort ArrayList
		ArrayList<BigDecimal> sorted = new ArrayList<>(sortBigDecimalArrayList(lst));
		
		// find the amount over budget
		BigDecimal overAmt = getTotal(expenses).subtract(budget);
		
		int indexSmallestOver = 0;  // smallest index where all numbers are used
		int indexLargestOver;  // largest index 
		
		// continues to add the smallest expense to an ArrayList until it's exceeded the overAmt
		ArrayList<BigDecimal> smallExpenses = new ArrayList<>();
		for (int i = 0; i < sorted.size(); i++) {
			if(getTotal(smallExpenses).compareTo(overAmt) < 0) {
				smallExpenses.add(sorted.get(i));
				indexSmallestOver = i;
			}
		}
		System.out.println(indexSmallestOver);
		System.out.println(getTotal(smallExpenses));
		
		// loops 0-size through the array
		
		
		
		
		
		
		
		
		
		
		
		return sorted;
	}
	
	
	
	
	
	
	private ArrayList<BigDecimal> sortBigDecimalArrayList(ArrayList<BigDecimal> lst) {
		ArrayList<BigDecimal> sortedLst = new ArrayList<>();
		
		// convert to double array
		double[] dArr = new double[lst.size()];
		for(int i = 0; i < dArr.length; i++) {
			dArr[i] = lst.get(i).doubleValue();
		}
		
		// sort array
		Arrays.sort(dArr);
		
		// convert back to BigDecimal
		for(int i = 0; i < dArr.length; i++) {
			sortedLst.add(new BigDecimal(dArr[i]));
		}
		
		return sortedLst;
	}
	
	private BigDecimal getTotal(ArrayList<BigDecimal> lst) {
		BigDecimal total = new BigDecimal(0);
		
		if(!lst.isEmpty()) {
			for(BigDecimal d: lst) {
				total = total.add(d);
			}
		}
		
		return total;
	}
	
	private void displayFinal(ArrayList<BigDecimal> lst) {
		System.out.printf("Get within $%,.2f of your budget by removing the following expenses: %n", getTotal(lst));
		for(BigDecimal d: lst) {
			System.out.printf("%,.2f%n", d);
		}
	}
}
