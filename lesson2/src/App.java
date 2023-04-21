import uwcse.graphics.GWindow;
import uwcse.graphics.Triangle;
import java.awt.Color;


public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        GWindow window = new GWindow("first one", 800, 700);
        Rectangle r = new Rectangle(100, 50, 150, 75, Color.GREEN, true);
    }
}
