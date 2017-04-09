import java.text.NumberFormat;


public class Main {
	
	public static void main(String[] args) {
		
		int numberOfOlives = 1_000_000;
		
		NumberFormat formatter = NumberFormat.getInstance();
		
		System.out.println(formatter.format(numberOfOlives));
	}
}
