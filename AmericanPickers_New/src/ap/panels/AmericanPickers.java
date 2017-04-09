package ap.panels;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;


public class AmericanPickers extends JPanel implements Runnable, MouseListener {
	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 900;
	public static final int HEIGHT = 600;
	
	private Thread thread;
	private boolean running;
	
	private PanelManager pm;
	
	public AmericanPickers() {
		super();
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true);
	}
	
	public void addNotify() {
		super.addNotify();
		if(thread == null) {
			thread = new Thread(this);
			addMouseListener(this);
			thread.start();
		}
	}
	
	public void run() {
		
		init();
		
		while (running) {
			
//			loop stuff
			update();
			draw();
			
//			try {
//				Thread.sleep(100);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
		}
		
	}
	
	private void init() {
		running = true;
		
		pm = new PanelManager();
	}
	
	public void update() {
		
		pm.update();
	}
	
	public void draw() {
		add(pm.getCurrentPanel());
	}
	
	public void mouseClicked(MouseEvent m) {	
		// pass the component that was clicked into the PanelManager
		pm.mouseClicked(m.getComponent().getComponentAt(m.getX(), m.getY()));
	}
	
	public void mousePressed(MouseEvent m) {}
	public void mouseReleased(MouseEvent m) {}
	public void mouseEntered(MouseEvent m) {}
	public void mouseExited(MouseEvent m) {}
}
