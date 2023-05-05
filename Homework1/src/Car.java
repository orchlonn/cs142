import java.awt.Color;

import uwcse.graphics.GWindow;
import uwcse.graphics.Oval;
import uwcse.graphics.Rectangle;

public class Car {
	// Declare your instance fields here
	private int x, y, direction;
	
	public static final int LEFT_MOVING = 0;
    public static final int RIGHT_MOVING = 1;

	// scale of the drawing
	private double scale;
	// graphics window that displays the mountation
	private GWindow window;
;

	// car's parts 
	private Rectangle carBottomBody, carTopBody;
	private Oval carLightShape, carTireShape1, carTireShape2;

	// colors
	Color carColor = new Color(184, 46, 96);
	Color carLightColor = Color.yellow;
	Color carTireColor = Color.black;

	/**
	 * Creates a Car
	 * 
	 * @param x      the x coordinate of the car location
	 * @param y      the y coordinate of the car location
	 * @param scale  the scale of the drawing of the car
	 * @param window the graphics window that displays the car
	 */
	public Car(int x, int y, double scale, int direction, GWindow window ) {
		this.x = x;
		this.y = y;
		this.scale = scale;
		this.direction = direction;
		this.direction = direction;
		this.window = window;
		
		// draw the car
		draw();
	}

	/**
	 * Moves the face by the given displacement
	 * 
	 * @param dx x-displacement
	 * @param dy y-displacement
	 */
	public void moveBy(int dx, int dy) {
		// these following 5 lines of codes are removing the copy of the shape after it moved to the another one.
		window.remove(carBottomBody);
		window.remove(carTopBody);
		window.remove(carLightShape);
		window.remove(carTireShape1);
		window.remove(carTireShape2);

		// these following 5 lines of codes are moving to the new place.
		this.carBottomBody.moveBy(dx, dy);
		this.carTopBody.moveBy(dx, dy);
		this.carLightShape.moveBy(dx, dy);
		this.carTireShape1.moveBy(dx, dy);
		this.carTireShape2.moveBy(dx, dy);
		

		// update the position of the car
		
		if(direction == 1){
			if(x  >= this.window.getWindowWidth() - ((int) (100 * scale))){
				direction = 0;
			}
			x += dx; // if the car's direction equals 1, it's directed to the right side.	
		} else {
			x -= dx; // if the car's direction equals zero, it's directed to the left side.
			if(x <= 0){
				direction = 1;
			}
		}
		draw();
	}

	/**
	 * Draws a car
	 */
	private void draw() {
		// height and width
		int height = (int) (100 * scale);
		int width = (int) (100 * scale);
		
		// dimensions of car parts
		int carTopHeight = height / 9; 
		int carTopWidth = (int) (width / 1.8);
		int carBottomHeight = height / 6;
		int carBottomWidth = width;
		
		carBottom(x, y + carTopHeight, carBottomWidth, carBottomHeight);
		carTop(x + (int)(carTopWidth / 2.5), y, carTopWidth, carTopHeight);		
	}
	
	private void carBottom(int x, int y, int width, int height) {
		this.carBottomBody = new Rectangle(x, y, width, height, carColor, true);
		window.add(this.carBottomBody);
		// I decided to include carLight and carTire function sinside the carBottom function. Since these are drawn on the bottom side of the car.
		carLight(x, y, width, height);
		carTire1(x + width / 7, y, width, height);
		carTire2((int)(x + width /1.5), y, width, height);
	}
	
	private void carTop(int x, int y, int width, int height) {
		this.carTopBody = new Rectangle(x, y, width, height, carColor, true);
		window.add(this.carTopBody);
	}
	
	private void carLight(int x, int y, int width, int height) {
		/*
		 * Quick remember!!! ------> carBottomHeight = height / 6 
		 * Also, height is divided by 1.8 again for carLight and the carHeight= totalHeight / 8
		 * Thus, the lightWidth = width / 10.8 since it's oval 
		 * */
		int lightHeight = (int) (height / 1.8);
		int lightWidth = (int) (width/ 10.8);
		// checking the car's positions
		if(direction == 1) {
			// if direction equals one, these following 2 lines of code would work and the car would face to the right side.
			this.carLightShape = new Oval(x + width - lightWidth, y, lightWidth, lightHeight, carLightColor, true);
			window.add(this.carLightShape);
		} else {
			// if direction is not equals one, these following 2 lines of code would work and the car would face to the left side.
			this.carLightShape = new Oval(x, y, lightWidth, lightHeight, carLightColor, true);
			window.add(this.carLightShape);
		};
	
	}
	
	private void carTire1(int x, int y, int width, int height) {
		// dimensions of car tire
		int tireHeight = (int) (height);
		int tireWidth = (int) (width / 6);
		// creating a car tire 
		this.carTireShape1 = new Oval(x, (int)(y + tireHeight / 2), tireWidth, tireHeight, carTireColor, true);
		// adding created tire to a display
		window.add(this.carTireShape1);
	}
	private void carTire2(int x, int y, int width, int height) {
		// dimensions of car tire
		int tireHeight = (int) (height);
		int tireWidth = (int) (width / 6);
		// creating a car tire 
		this.carTireShape2 = new Oval(x, (int)(y + tireHeight / 2), tireWidth, tireHeight, carTireColor, true);
		// adding created tire to a display
		window.add(this.carTireShape2);
	}
}