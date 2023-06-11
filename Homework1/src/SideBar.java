import uwcse.graphics.GWindowEventAdapter;
import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import uwcse.graphics.GWindow;
import uwcse.graphics.GWindowEvent;
import uwcse.graphics.GWindowEventAdapter;
import uwcse.graphics.Oval;
import uwcse.graphics.Rectangle;


public class SideBar extends GWindowEventAdapter {
    // Side menu window
	private GWindow window;
    public SideBar() {
		this.window = new GWindow("Side menu", 200, 500);
		this.window.setExitOnClose();
		this.window.addEventHandler(this); // this SpaceInvader handles all of
		// the events fired by the graphics
		// window

	}
}
