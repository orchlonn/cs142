
import java.awt.Color; //graphics library
import uwcse.graphics.*; // uw graphics library

/**
 * CSC 142 homework 1
 * 
 * Create a landscape that features 4 different types of elements (3 of the
 * types must be a mountain, an apple tree, and a car)
 * 
 * @author (Write your name here)
 */

public class CountrysideScene {
	/**
	 * Creates a countryside scene
	 */
	public CountrysideScene() {
		// The graphics window
		// the dimensions of the window is 500 by 400 pixels.
		GWindow window = new GWindow("Countryside scene");
		window.setExitOnClose();

		// The ground
		Color groundColor = new Color(152, 251, 152); // pale green color
		// to select color, use for example
		// https://www.rapidtables.com/web/color/index.html
		Rectangle ground = new Rectangle(0, 0, window.getWindowWidth(), window.getWindowHeight(), groundColor, true);
		window.add(ground);

		// the sky covers the upper quarter of the window
		Color skyColor = new Color(135, 206, 250); // light sky blue
		Rectangle sky = new Rectangle(0, 0, window.getWindowWidth(), window.getWindowHeight() / 4, skyColor, true);
		window.add(sky);

		// Draw the elements in the window
		// two mountains
		new Mountain(50, 20, 0.9, window);
		new Mountain(110, 25, 1.8, window);

		// Show the scene
		window.doRepaint();
	}

	/**
	 * Starts the application
	 */
	public static void main(String[] args) {
		new CountrysideScene();
	}
}
