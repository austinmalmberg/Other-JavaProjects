import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;


public class Main {
	public static void main(String[] args) {
		new EstimatePi("circle1.png").calculate();
		new EstimatePi("circle2.png").calculate();		
	}
}

class EstimatePi {
	
	private BufferedImage image;
	
	private int pixels;  // black pixels to make up circle
	private int d;  // diameter
	
	public EstimatePi(String file) {
		try {
			image = ImageIO.read(new File(file));
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		pixels = 0;
		d = 0;
	}
	
	public void calculate() {  // area = Pi * (d/2)^2
		findDimensions();
				
		System.out.println("Pi estiamted at: " + pixels / Math.pow((d / 2), 2)); // Pi = area / r^2
	}
	
	private void findDimensions() {  // calculates area and diameter
		int width;  // width of the circle (the largest one will be the diameter)
		
		for(int y = 0; y < image.getHeight(); y++) {
			width = 0;
			
			for (int x = 0; x < image.getWidth(); x++) {				
				if(image.getRGB(x, y) != -1) {
					pixels++;
					width++;
				}
			}
			
			if(width > d) d = width;
		}
	}
}
