package SpaceRace;

import MainMenu.GameObject;
import MainMenu.ID;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class SpaceDebris extends GameObject {

    public SpaceDebris (int x, int y, ID id){
        super(x,y,id);
    }

    @Override
    public void tick() {
        x += 1;
    }

    @Override
    public void render(Graphics g) throws InterruptedException {

        g.setColor(Color.white);
       // g.drawOval(x, y, 5, 5);
        g.fillOval(x, y, 5, 5);
    }
}
