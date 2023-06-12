import java.awt.Color;
import java.awt.Point;

import uwcse.graphics.GWindow;
import uwcse.graphics.Line;
import uwcse.graphics.Oval;
import uwcse.graphics.Rectangle;
import uwcse.graphics.Shape;

/**
 * The representation and display of an Alien
 */

public class Alien extends MovingObject {
	// Size of an Alien
	public static final int RADIUS = 5;

    // posisble colors of the aliens 
    public static Color[] colors = {Color.RED, Color.GREEN, Color.YELLOW};

	// Number of lives in this Alien
	// When 0, this Alien is dead
	private int lives;

	/**
	 * Creates an alien in the graphics window
	 * 
	 * @param window the GWindow this Alien belongs to
	 * @param center the center Point of this Alien
	 */
	public Alien(GWindow window, Point center) {
		super(window, center);
		this.lives = (int) (Math.random() * 3 + 1);

		// Display this Alien
		this.draw();
	}

	/**
	 * The alien is being shot. Decrement its number of lives and erase it from the
	 * graphics window if it is dead.
	 */
	public void isShot() {
        lives --;
        if(lives == 0){
            erase();
        }
	}

	/**
	 * Is this Alien dead?
	 */
	public boolean isDead() {
		return this.lives == 0;
	}

	/**
	 * Returns the location of this Alien
	 */
	public Point getLocation() {
		return this.center;
	}

	/**
	 * Moves this Alien As a start make all of the aliens move downward. If an alien
	 * reaches the bottom of the screen, it reappears at the top.
	 */
	public void move() {
        // Distance covered by the space ship in the one step
        int step = boundingBox.getHeight() / 2;

        // move the alien down
        center.y += step;

        // if the alien is past the bottom of the window, move it back to the top.
        if(center.y + boundingBox.getHeight() / 2 > window.getWindowHeight()) {
            center.y = 10 * Alien.RADIUS;
        }

        // Show the new location of this alien
        this.erase(); 
        this.draw();
	}

	/**
	 * Displays this Alien in the graphics window
	 */
	protected void draw() {
        if(lives == 0){
            return;
        }
        
		// pick the color (according to the number of lives left)
		Color color = colors[lives - 1]; // all red but change this

		// Graphics elements for the display of this Alien
		// A circle on top of an X
		this.shapes = new Shape[3];
		this.shapes[0] = new Line(this.center.x - 2 * RADIUS, this.center.y - 2 * RADIUS, this.center.x + 2 * RADIUS,
				this.center.y + 2 * RADIUS, color);
		this.shapes[1] = new Line(this.center.x + 2 * RADIUS, this.center.y - 2 * RADIUS, this.center.x - 2 * RADIUS,
				this.center.y + 2 * RADIUS, color);
		this.shapes[2] = new Oval(this.center.x - RADIUS, this.center.y - RADIUS, 2 * RADIUS, 2 * RADIUS, color, true);

		for (int i = 0; i < this.shapes.length; i++)
			this.window.add(this.shapes[i]);

		// Bounding box of this Alien
		this.boundingBox = new Rectangle(this.center.x - 2 * RADIUS, this.center.y - 2 * RADIUS, 4 * RADIUS,
				4 * RADIUS);

		this.window.doRepaint();
	}
}