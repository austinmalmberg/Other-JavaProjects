package chords;

public class Chord {
	

	
	public Chord(){}
	
	public void show(char[] tuning, int[] arr) {
		for (int i = arr.length - 1; i >= 0; i--) {
			System.out.print(tuning[i] + " ");
			switch (arr[i]) {
			case -1:
				System.out.println("|---|---|---|---|---| X");
				break;
			case 0:
				System.out.println("|---|---|---|---|---| O");
				break;
			case 1:
				System.out.println("|-x-|---|---|---|---| O");
				break;
			case 2:
				System.out.println("|---|-x-|---|---|---| O");
				break;
			case 3:
				System.out.println("|---|---|-x-|---|---| O");
				break;
			case 4:
				System.out.println("|---|---|---|-x-|---| O");
				break;
			case 5:
				System.out.println("|---|---|---|---|-x-| O");
				break;
			default:
				System.out.println("|---|---|---|---|---| O");
				break;
			}
		}
		System.out.println();
	}
}
