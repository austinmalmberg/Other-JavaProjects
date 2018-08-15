package v2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import helpers.FileImporter;

public class Main {
	
	public static final double COMMISSION_RATE = 0.062;
	
	// Map<AgentName, Map<itemName, double[revenue, expenses]>>
	public static Map<String, Map<String, double[]>> salespersons;
	
	public static void main(String[] args) {
		
		salespersons = new HashMap<>();
		
		FileImporter fi = new FileImporter();
		String[][] file = fi.getFileAs2DArray("Challenge1.txt", "\\s+");
		
		String[][] revenueTable = getTable(file, "Revenue", "Expenses");
		String[][] expenseTable = getTable(file, "Expenses", "Revenue");
		
		parseDataBySalesperson(revenueTable);
		parseDataBySalesperson(expenseTable);
		
		for(Entry<String, Map<String, double[]>> agent : salespersons.entrySet()) {
			double commission = 0.0;
			for(Entry<String, double[]> item : agent.getValue().entrySet()) {
				double revenue = item.getValue()[0];
				double expenses = item.getValue()[1];
				commission += revenue > expenses ? revenue - expenses : 0;
			}
			
			commission *= COMMISSION_RATE;
			System.out.printf("%s-- $%.2f%n", agent.getKey(), commission);
		}
	}
	
	public static void parseDataBySalesperson(String[][] file) {
		for(int col = 0; col < file[0].length; col++) {
			String agentName = file[0][col];
			for(int row = 1; row < file.length; row++) {
				add(agentName, file[row][0], Double.parseDouble(file[row][col+1]));
			}
		}
	}
	
	public static String[][] getTable(String[][] file, String start, String end) {
		ArrayList<String[]> lines = new ArrayList<>();
		
		boolean copy = false;
		for(int i = 0; i < file.length; i++) {
			if(copy) {
				if(file[i][0].equalsIgnoreCase(end)) break;
				lines.add(file[i]);
			}
			
			if(file[i][0].equals(start))
				copy = true;
		}
		
		return lines.toArray(new String[lines.size()][]);
	}

	public static void add(String agentName, String itemName, double val) {
		if(!salespersons.containsKey(agentName))
			salespersons.put(agentName, new HashMap<>());
		
		if(!salespersons.get(agentName).containsKey(itemName)) {
			salespersons.get(agentName).put(itemName, new double[]{val, 0});
		} else {
			double rev = salespersons.get(agentName).get(itemName)[0];
			salespersons.get(agentName).put(itemName, new double[]{rev, val});
		}
	}
}
