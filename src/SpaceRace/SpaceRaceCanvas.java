package SpaceRace;

import javax.swing.*;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Color;


public class SpaceRaceCanvas extends Canvas {
    int width, height;


    public SpaceRaceCanvas(){
        this.width = 800;
        this.height = 800;
        this.setSize(this.width, this.height);
        this.setBackground(Color.pink);
    }

    public void paint(Graphics g) {
        g.fillOval(100, 100, 200, 200);
    }
}
