import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class Frame extends JFrame implements MouseListener {
	
	public static final int WIDTH = 900;
	public static final int HEIGHT = 600;
	
	LayoutManager lm;
	
	public Frame(String title) {
		super(title);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		pack();
		setVisible(true);
		
		lm = new LayoutManager();
		init();
	}
	
	public void init() {
		add(lm.getCurrentPanel());
		
//		// show login page
//		add(new LoginPanel());
		
//		add(new UserPanel(), BorderLayout.NORTH);
//		add(new MainPanel(), BorderLayout.CENTER);
//		add(new ButtonPanel(), BorderLayout.SOUTH);
	}

	@Override
	public void mouseClicked(MouseEvent m) {		
		System.out.println("testing");
		System.out.println(m.getComponent().toString());
		lm.mouseClicked(m.getComponent());
	}

	@Override
	public void mouseEntered(MouseEvent m) {}

	@Override
	public void mouseExited(MouseEvent m) {}

	@Override
	public void mousePressed(MouseEvent m) {}

	@Override
	public void mouseReleased(MouseEvent m) {}
}
