package timer;

import java.util.*;

public class Time extends TimerTask {
	
	@SuppressWarnings("deprecation")
	public void run() {
		Date time = new Date();
		System.out.format("%n%02d:%02d:%02d", time.getHours(),	time.getMinutes(), time.getSeconds());
		time = null;
	}
}


