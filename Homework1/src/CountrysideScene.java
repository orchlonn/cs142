//
//import java.awt.Color; //graphics library
//import java.util.Random;
//
//import uwcse.graphics.*; // uw graphics library
//
///**
// * CSC 142 homework 1
// * 
// * Create a landscape that features 4 different types of elements (3 of the
// * types must be a mountain, an apple tree, and a car)
// * 
// * @author (Write your name here)
// */
//
//public class CountrysideScene {
//	/**
//	 * Creates a countryside scene
//	 */
//	public CountrysideScene() {
////		// The graphics window
////		// the dimensions of the window is 500 by 400 pixels.
//		GWindow window = new GWindow("Countryside scene");
//		window.setExitOnClose();
////
////		// The ground
//		Color groundColor = new Color(152, 251, 152); // pale green color
////		// to select color, use for example
////		// https://www.rapidtables.com/web/color/index.html
////		Rectangle ground = new Rectangle(0, 0, window.getWindowWidth(), window.getWindowHeight(), groundColor, true);
////		window.add(ground);
////
////		// the sky covers the upper quarter of the window
////		Color skyColor = new Color(135, 206, 250); // light sky blue
////		Rectangle sky = new Rectangle(0, 0, window.getWindowWidth(), window.getWindowHeight() / 4, skyColor, true);
////		window.add(sky);
////		
////		// creates random variable
////		 Random rand = new Random();   
////
////		// Draw the elements in the window
////		// Sun
////		new SunAndCloud(55, 10, 1, window);
////		
////		// three mountains
////		new Mountain(50, 20, 0.9, window);
////		new Mountain(110, 25, 1.8, window);
////		new Mountain(260, 40, 1.6, window);
////		
////		// three apple tree
////		new AppleTree(330, 110, 0.9, window);
////		new AppleTree(390, 100, 1.3, window);
////		new AppleTree(450, 150, 1.55, window);
////		
////		// three cars 
////		new Car(30, 230, 1.2, window, rand.nextBoolean());
////		new Car(230, 300, 1.7, window, rand.nextBoolean());
////		new Car(370, 200, 0.7, window, rand.nextBoolean());
////		
//		new FunnyPicture(100, 50, 1, window);
//		// Show the scene
//		window.doRepaint();
//	}
//
//	/**
//	 * Starts the application
//	 */
//	public static void main(String[] args) {
//		new CountrysideScene();
//	}
//}
