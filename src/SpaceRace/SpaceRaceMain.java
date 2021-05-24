package SpaceRace;

import java.awt.Graphics;
import javax.swing.JFrame;
import java.awt.*;

/** The Main class for the game SpaceRace*/

public class SpaceRaceMain {




    public static void main(String[] args){
        // the window that will contain the canvas.
        JFrame frame = new JFrame("SpaceRace");
        // create canvas object and add it to the frame.
        Canvas canvas = new SpaceRaceCanvas();
        frame.add(canvas);
        //Pack the frame (resize it) to fit the canvas, and display it on the screen.
        frame.pack();
        frame.setVisible(true);
        Graphics g = canvas.getGraphics();
        canvas.paint(g);




        Ship leftShip = new Ship(20);
        Ship rightShip = new Ship(60);
        leftShip.update();
    }


}
