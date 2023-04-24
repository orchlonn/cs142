
import java.awt.Color;
import uwcse.graphics.*;

/**
 * A class to draw an apple tree
 */

public class AppleTree {

	// Declare your instance fields here
	private int x, y;
	// scale of the drawing
	private double scale;
	// graphics window that displays the mountation
	private GWindow window;
	// colors
	Color brown = new Color (129, 60, 25); 
	Color treeColor = new Color (26, 126, 42);
	Color appleColor = Color.red;
	/**
	 * Creates an apple tree
	 * 
	 * @param x      the x coordinate of the tree location
	 * @param y      the y coordinate of the tree location
	 * @param scale  the scale of the drawing of the tree
	 * @param window the graphics window that displays the tree
	 */
	
	public AppleTree(int x, int y, double scale, GWindow window) {
		this.x = x;
		this.y = y;
		this.scale = scale;
		this.window = window;
		
		// draw the apple tree
		draw();
	}

	/**
	 * Draws an apple tree
	 */
	private void draw() {
		// creating dimensions
		int height = (int) (100 * scale);
		int width  = (int) (100 * scale);
		


		// tree components		
		treeBottom(x, y, (int)(width / 7.2), (int) (height / 1.8));
		treeTop((int)(x - height / 5.5), y - width / 3, width);
	}
	
	private void treeBottom(int x, int y, int width, int height) {
		Rectangle tree = new Rectangle(x, y, width, height, brown, true);
		window.add(tree);
	}
	
	private void treeTop(int x, int y, int width ) {
		Oval tree = new Oval(x, y, width / 2, width / 2,treeColor, true);
		window.add(tree);
		// I decided to include redApple function inside the treeTop function. Since it's drawn on the tree. Also, redApple includes the x and y positions by it's props(arguemtns).
		redApple((int)(x - width / 5.5), y - width / 3, width);
	}
	
	private void redApple(int x, int y, int width) {
		// creat variables for width and color, since these values are constant.
		int appleWidth = width / 16;

		
		// creating 4 apple trees       x - axis,               y - axis, 		   width,       height,		 Color,   filled		
		Oval firstApple = new Oval((int)(x + width / 3.3), (int)(y + width / 1.9), appleWidth, appleWidth, appleColor, true);
		Oval secondApple = new Oval((int)(x + width / 2.6), (int)(y + width / 2.4), appleWidth, appleWidth, appleColor, true);
		Oval thirdApple= new Oval((int)(x + width / 2.1), (int)(y + width / 1.6), appleWidth, appleWidth, appleColor, true);
		Oval fourthApple = new Oval((int)(x + width / 1.7), (int)(y + width / 1.9), appleWidth, appleWidth, appleColor, true);
		
		// add apples
		window.add(firstApple);
		window.add(secondApple);
		window.add(thirdApple);
		window.add(fourthApple);
	}
	
	
}