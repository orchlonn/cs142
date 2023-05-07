
import java.awt.Color;

import uwcse.graphics.GWindow;
import uwcse.graphics.GWindowEvent;
import uwcse.graphics.GWindowEventAdapter;
import uwcse.graphics.Rectangle;

/**
 * CSC 142 homework 2
 * 
 * A CountrysideScene object displays apple trees, cars, mountains, and a fourth
 * element of your choice in a graphics window.
 * 
 * Add a line to declare an instance field of type the new type that you defined
 * in hw1, then complete the method addGraphicsElements. Leave all the rest of
 * the code unchanged.
 * 
 * @author Orchlon
 */

public class CountrysideScene extends GWindowEventAdapter {

	// The graphics window that displays the picture
	private GWindow window;

	// The elements in the picture
	// 2 cars that move back and forth
	private Car car1, car2;
	// 3 mountains with receding snow cover
	private Mountain mountain1, mountain2, mountain3;
	// 3 apple trees whose apples change colors
	private AppleTree tree1, tree2, tree3;

	// my elements
	private SunAndCloud myElement;

	// Add here the declaration of an instance field of the type
	// that you created in hw1
	// YOU MUST NAME THIS VARIABLE: myElement.
	// Thus your statement should be (replacing
	// classname with the name of your class)
	// private classname myElement; (e.g. private Moon myElement if your fourth
	// element is a Moon).

	// To keep track of the duration of the animation
	private int animationCounter;

	/**
	 * Creates a countryside scene
	 */
	public CountrysideScene() {
		// The graphics window
		// the dimensions of the window is 500 by 400 pixels.
		this.window = new GWindow("Countryside scene");
		this.window.setExitOnClose();

		// The ground
		Color groundColor = new Color(152, 251, 152); // pale green color
		// to select color, use for example
		// https://www.rapidtables.com/web/color/index.html
		Rectangle ground = new Rectangle(0, 0, window.getWindowWidth(), window.getWindowHeight(), groundColor, true);
		this.window.add(ground);

		// the sky covers the upper quarter of the window
		Color skyColor = new Color(135, 206, 250); // light sky blue
		Rectangle sky = new Rectangle(0, 0, window.getWindowWidth(), window.getWindowHeight() / 4, skyColor, true);
		this.window.add(sky);

		// Add the graphics elements
		this.addGraphicsElements();

		// Code to do the animation
		this.window.addEventHandler(this);
		this.window.startTimerEvents(150);
	}

	/**
	 * One step of the animation 
	 */
	public void timerExpired(GWindowEvent we) {
		this.window.suspendRepaints();

		this.myElement.doAction(2, 2);
		// Change the colors of the apples on the trees
		this.tree1.ripen();
		this.tree2.ripen();
		this.tree3.ripen();

		// Move the cars
		this.car1.moveBy(10,1);
		this.car2.moveBy(20,1);

		// Change the size of the snow on the mountains
		this.mountain1.meltSnow(animationCounter);
		this.mountain2.meltSnow(animationCounter);
		this.mountain3.meltSnow(animationCounter);



		this.window.resumeRepaints();

		// Run the animation 100 times (about 15 s)
		this.animationCounter++;
		if (this.animationCounter >= 100)
			this.window.stopTimerEvents();
	}

	/**
	 * Instantiates in this method the elements of the scene.
	 * 
	 * This is the only method that you need to modify in this class
	 */
	private void addGraphicsElements() {
		// You can change the coordinates and scales that appear
		// in the constructors (but don't change the names of the variables)
		this.car1 = new Car(90, 250, 0.5, Car.RIGHT_MOVING, this.window);
		this.car2 = new Car(310, 350, 0.9, Car.LEFT_MOVING, this.window);

		this.tree1 = new AppleTree(320, 120, .5, this.window);
		this.tree2 = new AppleTree(380, 120, .8, this.window);
		this.tree3 = new AppleTree(440, 180, 1.1, this.window);

		this.mountain1 = new Mountain(50, 20, 0.9, this.window);
		this.mountain2 = new Mountain(110, 25, 1.8, this.window);
		this.mountain3 = new Mountain(250, 45, 1.5, this.window);

		this.myElement =  new SunAndCloud(55, 10, 1, this.window);
	}

	/**
	 * Starts the application
	 */
	public static void main(String[] args) {
		new CountrysideScene();
	}

}