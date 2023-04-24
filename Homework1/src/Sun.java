import java.awt.Color;

import uwcse.graphics.GWindow;
import uwcse.graphics.Oval;


public class Sun {
	// Declare your instance fields here
	private int x, y;
	// graphics window that displays the mountation
	private GWindow window;
	// Declare your instance fields here

	/**
	 * Creates a Sun
	 * 
	 * @param x      the x coordinate of the sun location
	 * @param y      the y coordinate of the sun location
	 * @param scale  the scale of the drawing of the sun
	 * @param window the graphics window that displays the sun
	 */
	public Sun(int x, int y, GWindow window) {
		this.x = x;
		this.y = y;
		this.window = window;
		
		// draw the sun
		draw();
	}

	/**
	 * Draws a sun
	 */
	private void draw() {
		Oval sun= new Oval(x, y, 50, 50, Color.yellow, true);
		window.add(sun);

	}
}