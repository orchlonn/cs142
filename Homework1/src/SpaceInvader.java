
// Write your compliance statement here:
// What are your 4 extra features?
// How is your new alien different from the one described by the Alien class?
//
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import uwcse.graphics.GWindow;
import uwcse.graphics.GWindowEvent;
import uwcse.graphics.GWindowEventAdapter;
import uwcse.graphics.Oval;
import uwcse.graphics.Rectangle;
import uwcse.graphics.TextShape;

/**
 * A SpaceInvader displays a fleet of alien ships and a space ship. The player
 * directs the moves of the spaceship and can shoot at the aliens.
 */

public class SpaceInvader extends GWindowEventAdapter {
	// Possible actions from the keyboard
	/** No action */
	public static final int DO_NOTHING = 0;

	/** Steer the space ship */
	public static final int SET_SPACESHIP_DIRECTION = 1;

	/** To shoot at the aliens */
	public static final int SHOOT = 2;

	// Period of the animation (in ms)
	// (the smaller the value, the faster the animation)
	private int animationPeriod = 100;

	// Current action from the keyboard
	private int action;

	// Game window
	private GWindow window;

	// The space ship
	private SpaceShip spaceShip;

	// Direction of motion given by the player
	private int dirFromKeyboard = MovingObject.LEFT;

	// The aliens
	private ArrayList<Alien> aliens;

	//! The healingStar
	private ArrayList<HealingStar> healingStar;

	// Is the current game over?
    private String messageGameOver = "Congratulations, you saved the earth!";

	//! Lost message
	private String lostMessage = "You lost :(";


	//! user score
	private int userScore = 0;
	/**
	 * Constructs a space invader game
	 */
	public SpaceInvader() {
		this.window = new GWindow("Space invaders", 800, 500);
		this.window.setExitOnClose();
		this.window.addEventHandler(this); // this SpaceInvader handles all of
		// the events fired by the graphics
		// window

		// Display the game rules
		String rulesOfTheGame = "Save the Earth! Destroy all of the aliens ships.\n" + "To move left, press '<'.\n"
				+ "To move right, press '>'.\n" + "To shoot, press the space bar.\n" + "To quit, press 'Q'.";
		// JOptionPane.showMessageDialog(null, rulesOfTheGame, "Space invaders", JOptionPane.INFORMATION_MESSAGE);
		this.initializeGame();
	}

	/**
	 * Initializes the game (draw the background, aliens, and space ship)
	 */
	public void initializeGame() {
		// Clear the window
		this.window.erase();

		// Background (starry universe)
		Rectangle background = new Rectangle(0, 0, this.window.getWindowWidth(), this.window.getWindowHeight(),
				Color.black, true);
		this.window.add(background);
		// Add 50 stars here and there (as small circles)
		Random rnd = new Random();
		for (int i = 0; i < 50; i++) {
			// Random radius between 1 and 3
			int radius = rnd.nextInt(3) + 1;
			// Random location (within the window)
			// Make sure that the full circle is visible in the window
			int x = rnd.nextInt(this.window.getWindowWidth() - 2 * radius);
			int y = rnd.nextInt(this.window.getWindowHeight() - 2 * radius);
			this.window.add(new Oval(x, y, 2 * radius, 2 * radius, Color.WHITE, true));
		}

		// ArrayList of aliens
		this.aliens = new ArrayList<Alien>();
		
		//! ArrayList of healign stars
		this.healingStar = new ArrayList<HealingStar>();

		// Create 12 aliens
		// Initial location of the aliens
		// (Make sure that the space ship can fire at them)
		int x = 2 * SpaceShip.WIDTH;
		int y1 = 10 * Alien.RADIUS;
		int y2 = 50 * Alien.RADIUS;
		int y;
		for (int i = 0; i < 15; i++) {
			y = y1 + (int)(Math.random() * (y2 - y1));
			this.aliens.add(new Alien(this.window, new Point(x, y)));
			x += 6 * Alien.RADIUS;
		}

		for(int i = 0; i < 1; i++) {
			y = y1 + (int)(Math.random() * (y2 - y1));
			this.healingStar.add(new HealingStar(this.window, new Point(x, y)));	
		}

		// Create the space ship at the bottom of the window
		x = this.window.getWindowWidth() / 2;
		y = this.window.getWindowHeight() - SpaceShip.HEIGHT / 2;
		this.spaceShip = new SpaceShip(this.window, new Point(x, y));

		//! side menu bar
		sideMenuBar();
		
		// start timer events
		this.window.startTimerEvents(this.animationPeriod);
	}

	public void sideMenuBar(){
		//! side bar 
		Rectangle sideBRectangle = new Rectangle(500, 0, 300, 500,
		Color.white, true);
		this.window.add(sideBRectangle);

		//! game instruction texts
		gameInstructionTexts();

		//! names font and text
		TextShape namesText = new TextShape("Erdenetuya Batgerel and Orchlon Chinbat", 505, 480, Color.black);
		Font namesFont = new Font("Arial", Font.BOLD, 13);
		namesText.setFont(namesFont);
		this.window.add(namesText);	
	}

	public void gameInstructionTexts(){
		// instruction texts 
		String text0 = "Game instruction:";
		String text1 = "Press 'a' to move left.";
		String text2 = "Press 'd' to move right.";
		String text3 = "Press 'w' to move forward.";
		String text4 = "Press 's' to move backward.";
		String text5 = "Press 'q' to quit the game.";
		String text6 = "Press spacebar to shoot.";

		// text shapes
		TextShape textShape0 = new TextShape(text0, 505,0, Color.black);
		TextShape textShape1 = new TextShape(text1, 505,20, Color.black);
		TextShape textShape2 = new TextShape(text2, 505, 35, Color.black);
		TextShape textShape3 = new TextShape(text3, 505, 50, Color.black);
		TextShape textShape4 = new TextShape(text4, 505, 65, Color.black);
		TextShape textShape5 = new TextShape(text5, 505, 80, Color.black);
		TextShape textShape6 = new TextShape(text6, 505, 95, Color.black);

		// instruction fonts and set fonts on the texts
		Font instructionTextsFont1 = new Font("Arial", Font.ITALIC, 14);
		Font instructionTextsFont2 = new Font("Arial", Font.BOLD, 18);
		textShape0.setFont(instructionTextsFont2);
		textShape1.setFont(instructionTextsFont1);
		textShape2.setFont(instructionTextsFont1);
		textShape3.setFont(instructionTextsFont1);
		textShape4.setFont(instructionTextsFont1);
		textShape5.setFont(instructionTextsFont1);
		textShape6.setFont(instructionTextsFont1);

		// add to the display
		this.window.add(textShape0);
		this.window.add(textShape1);
		this.window.add(textShape2);
		this.window.add(textShape3);
		this.window.add(textShape4);
		this.window.add(textShape5);
		this.window.add(textShape6);
	}

	/**
	 * Moves the objects within the graphics window every time the timer fires an
	 * event
	 */
	public void timerExpired(GWindowEvent we) {
		// Perform the action requested by the user?
		switch (this.action) {
		case SpaceInvader.SET_SPACESHIP_DIRECTION:
			this.spaceShip.setDirection(this.dirFromKeyboard);
			break;
		case SpaceInvader.SHOOT:
			this.spaceShip.shoot(this.aliens, this.healingStar);
			break;
		}

		this.action = SpaceInvader.DO_NOTHING; // Don't do the same action
		// twice

		// Show the new locations of the objects
		this.updateGame();
	}

	/**
	 * Selects the action requested by the pressed key
	 */
	public void keyPressed(GWindowEvent e) {
		// Don't perform the actions (such as shoot) directly in this method.
		// Do the actions in timerExpired, so that the alien ArrayList can't be
		// modified at the same time by two methods (keyPressed and timerExpired
		// run in different threads).

		switch (Character.toLowerCase(e.getKey())) // not case sensitive
		{
		// Put here the code to move the space ship with the < and > keys
		case 'a': // move the spaceship to the left
		this.action = SpaceInvader.SET_SPACESHIP_DIRECTION;
		dirFromKeyboard = MovingObject.LEFT;
		break;

		case 'd': // move the spaceship to the right
		this.action = SpaceInvader.SET_SPACESHIP_DIRECTION;
		dirFromKeyboard = MovingObject.RIGHT;
		break;

		case 's': // move the spaceship to the backward
		this.action = SpaceInvader.SET_SPACESHIP_DIRECTION;
		dirFromKeyboard = MovingObject.UP;
		break;

		case 'w': // move the spaceship to the forward
		this.action = SpaceInvader.SET_SPACESHIP_DIRECTION;
		dirFromKeyboard = MovingObject.DOWN;
		break;

		case ' ': // shoot at the aliens
			this.action = SpaceInvader.SHOOT;
			break;

		case 'q': // quit the game
			System.exit(0);

		default: // no new action
			this.action = SpaceInvader.DO_NOTHING;
			break;
		}
	}

	/**
	 * Updates the game (Move aliens + space ship)
	 */
	private void updateGame() {
		// Is the game won (or lost)?
		// Put here code to end the game (= no more aliens)
		if (aliens.size() == 0) {
			if (anotherGame(messageGameOver)) {
				initializeGame();
			} else {
				System.exit(0);	
			}
		}

		this.window.suspendRepaints(); // to speed up the drawing

		// Move the aliens
		for (Alien a : aliens) {
			a.move();

			//! find every aliens locations and spaceship location
			int xLeft = a.getBoundingBox().getX();
			int xRight = a.getBoundingBox().getX() + a.getBoundingBox().getWidth();
			int xBottom = a.getBoundingBox().getY();
			int sLeft = spaceShip.getBoundingBox().getX();
			int sRight = spaceShip.getBoundingBox().getX() + spaceShip.getBoundingBox().getWidth();
			int sTop = spaceShip.getBoundingBox().getY();
	
			//! finding is space ship damaged or not?
			if(xLeft == sLeft  && sRight == xRight && sTop == xBottom){
				//! Since the spaceship is same width as aliens.
				spaceShip.shipLives --;
			}
				
		}

		for (HealingStar star : healingStar) {
			star.move();
		}

		
		// Move the space ship
		this.spaceShip.move();

		// Display it all
		this.window.resumeRepaints();

		//! checking the lives of the ship
		if(spaceShip.shipLives == 0) {
			if (anotherGame(lostMessage)) {
				initializeGame();
				spaceShip.shipLives = 3;
			} else {
				System.exit(0);	
			}	
		}
		
		//! show lives of the ship
		Rectangle livesOfShipRectangle = new Rectangle(520, 130, 250,80, Color.blue, true);	
		String strLives = "" + spaceShip.shipLives;
		TextShape livesofShapeText = new TextShape(strLives, 535, 170, Color.CYAN);
		
		Font shipLiveFont = new Font("Arial", Font.BOLD, 18);
		String totalLivesStr = "Remaining lives";
		TextShape livesOfShapesStr = new TextShape(totalLivesStr, 535, 140, Color.CYAN);
		livesofShapeText.setFont(shipLiveFont);
		livesOfShapesStr.setFont(shipLiveFont);

		this.window.add(livesOfShipRectangle);
		this.window.add(livesofShapeText);
		this.window.add(livesOfShapesStr);


		//! show alien numbers on the screen 
		Rectangle aliensNumberRectangle = new Rectangle(520, 250, 250, 80, Color.LIGHT_GRAY, true);
		String aliensNumber = "" + aliens.size();
		TextShape aliensNumberStr = new TextShape("Aliens remaining", 535, 260, Color.BLACK);
		TextShape aliensNumberText = new TextShape(aliensNumber, 535, 290, Color.BLACK);
		aliensNumberText.setFont(shipLiveFont);
		aliensNumberStr.setFont(shipLiveFont);
		this.window.add(aliensNumberRectangle);
		this.window.add(aliensNumberText);
		this.window.add(aliensNumberStr);


		//! show user score on the screen 
		Rectangle userScoreRectangle = new Rectangle(520, 370, 250, 80, Color.magenta, true);
		userScore = (15 - aliens.size()) * 100;
		String userScoreStr = "" + userScore;
		TextShape userScoreShape = new TextShape("Score", 535, 380, Color.BLACK);
		TextShape userScoreText = new TextShape(userScoreStr, 535, 410, Color.BLACK);
		userScoreText.setFont(shipLiveFont);
		userScoreShape.setFont(shipLiveFont);
		this.window.add(userScoreRectangle);
		this.window.add(userScoreShape);
		this.window.add(userScoreText);
	}
 
	/**
	 * Does the player want to play again?
	 */
	public boolean anotherGame(String s) {
		// this method is useful at the end of a game if you want to prompt the
		// user
		// for another game (s would be a String describing the outcome of the
		// game
		// that just ended, e.g. "Congratulations, you saved the Earth!")
		int choice = JOptionPane.showConfirmDialog(null, s + "\nDo you want to play again?", "Game over",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

		return (choice == JOptionPane.YES_OPTION);
	}

	/**
	 * Starts the application
	 */
	public static void main(String[] args) {
		new SpaceInvader();
	}
}