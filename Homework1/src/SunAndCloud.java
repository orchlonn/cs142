import java.awt.Color;

import uwcse.graphics.GWindow;
import uwcse.graphics.Oval;


public class SunAndCloud {
	// Declare your instance fields here
	private int x, y;
	// graphics window that displays the mountation
	private GWindow window;
	// Declare your instance fields here
	private double scale;

	/**
	 * Creates a Sun
	 * 
	 * @param x      the x coordinate of the sun location
	 * @param y      the y coordinate of the sun location
	 * @param scale  the scale of the drawing of the sun
	 * @param window the graphics window that displays the sun
	 */
	public SunAndCloud(int x, int y, double scale, GWindow window) {
		this.x = x;
		this.y = y;
		this.scale = scale;
		this.window = window;
		
		// draw the sun
		draw();
	}

	/**
	 * Draws a sun and cloud
	 */
	private void draw() {
		int h = (int) (100 * scale);
		Sun();
		Cloud(x + 10, y, (int) (h / 1.5), 22);
		Cloud(x + 150, y + 40,(int) (h / 1.8), 22);
		Cloud(x + 230, y, (int) (h / 1.2), 22);
	}
	
	private void Sun() {
		Oval sun= new Oval(x, y, 50, 50, Color.yellow, true);
		window.add(sun);
	}
	
	private void Cloud(int x, int y, int width, int height) {
		Oval cloud1= new Oval(x + 80, y - 10, width, height, Color.white, true);
		Oval cloud2 = new Oval(x + 60, y + 5, width, height, Color.white, true);
		Oval cloud3 = new Oval(x + 110, y , width, height, Color.white, true);
		Oval cloud4 = new Oval(x + 110, y + 15, width, height, Color.white, true);
		Oval cloud5 = new Oval(x + 75, y + 15, width, height + 5, Color.white, true);
		window.add(cloud1);
		window.add(cloud2);
		window.add(cloud3);
		window.add(cloud4);
		window.add(cloud5);
	}
}

