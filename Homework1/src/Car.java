import java.awt.Color;

import uwcse.graphics.GWindow;
import uwcse.graphics.Oval;
import uwcse.graphics.Rectangle;

public class Car {
	// Declare your instance fields here
	private int x, y;
	// scale of the drawing
	private double scale;
	// graphics window that displays the mountation
	private GWindow window;
	// check the car's position
	private boolean isRight;
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
	public Car(int x, int y, double scale, GWindow window, boolean isRight) {
		this.x = x;
		this.y = y;
		this.scale = scale;
		this.window = window;
		this.isRight = isRight;
		
		// draw the car
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
		int carTopWidth = (int)(width / 1.8);
		int carBottomHeight = height / 6;
		int carBottomWidth = width;
		
		carBottom(x, y + carTopHeight, carBottomWidth, carBottomHeight);
		carTop(x + (int)(carTopWidth / 2.5), y, carTopWidth, carTopHeight);		
		
	}
	
	private void carBottom(int x, int y, int width, int height) {
		Rectangle carBottom = new Rectangle(x, y, width, height, carColor, true);
		window.add(carBottom);
		// I decided to include carLight and carTire function sinside the carBottom function. Since these are drawn on the bottom side of the car.
		carLight(x, y, width, height);
		carTire(x + width / 7, y, width, height);
		carTire((int)(x + width /1.5), y, width, height);
	}
	
	private void carTop(int x, int y, int width, int height) {
		Rectangle carTop = new Rectangle(x, y, width, height, carColor, true);
		window.add(carTop);
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
		if(isRight == true) {
			// if the car located to the right side, these following 2 lines of code would work.
			Oval carLight = new Oval(x + width - lightWidth, y, lightWidth, lightHeight, carLightColor, true);
			window.add(carLight);
		} else {
			// if the car located to the left side, these following 2 lines of code would work. (without any changes on x axis)
			Oval carLight = new Oval(x, y, lightWidth, lightHeight, carLightColor, true);
			window.add(carLight);
		};
	
	}
	
	private void carTire(int x, int y, int width, int height) {
		// dimensions of car tire
		int tireHeight = (int) (height);
		int tireWidth = (int) (width / 6);
		// creating a car tire 
		Oval carTire = new Oval(x, (int)(y + tireHeight / 2), tireWidth, tireHeight, carTireColor, true);
		// adding created tire to a display
		window.add(carTire);
	}
}