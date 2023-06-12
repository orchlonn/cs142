import java.awt.Color;
import java.awt.Point;

import uwcse.graphics.GWindow;
import uwcse.graphics.Oval;
import uwcse.graphics.Rectangle;
import uwcse.graphics.Shape;
public class HealingStar extends MovingObject {
    // Size of a healing star
	public static final int RADIUS = 15;

    SpaceShip spaceShip;

    public HealingStar(GWindow window, Point center) {        
		super(window, center);

		// Display this healing star
		this.draw();
	}

     /**
	 * Returns the location of this healing start
	 */
	public Point getLocation() {
		return this.center;
	}


    @Override
    public void move() {
        // Distance covered by the space ship in the one step
        int step = boundingBox.getWidth() / 5;

        // move the alien down
        center.x += step;

        // if the healing star is past the bottom of the window, move it back to the top.
        if(center.x + boundingBox.getWidth() / 2 > window.getWindowWidth() - 300) {
            center.x = 1 * HealingStar.RADIUS;
        }

        // Show the new location of this healing star
        this.erase(); 
        this.draw();
    }

    @Override
	protected void draw() {
		// pick the color (according to the number of lives left)
		Color color = Color.YELLOW; // all red but change this

        this.shapes = new Shape[1];
		this.shapes[0] = new Oval(this.center.x - RADIUS, this.center.y - RADIUS, 2 * RADIUS, 2 * RADIUS, color, true);

		for (int i = 0; i < this.shapes.length; i++)
			this.window.add(this.shapes[i]);

		// Bounding box of this Alien
		this.boundingBox = new Rectangle(this.center.x - 3 * RADIUS, this.center.y -3 * RADIUS, 5 * RADIUS,
				5 * RADIUS);
		this.window.doRepaint();
	}
}
