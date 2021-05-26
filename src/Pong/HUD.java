package Pong;

import java.awt.*;

public class HUD {

    private int x;
    private int y;
    public  static int POINTS = 0;

    public HUD(int x, int y) {
       this.x = x;
       this.y = y;

    }

    public void tick() {

    }


    public void render(Graphics g) {
        g.setColor(Color.green);
        g.fillRect(x, y, 50, 30);
        g.setColor(Color.cyan);
        g.drawRect(x, y, 50, 30);
    }

}
