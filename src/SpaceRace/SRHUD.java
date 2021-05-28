package SpaceRace;

import MainMenu.Game;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class SRHUD {
    public static int time = 240;
    public void tick() {
        time -= 1;
    }

    public void render(Graphics g){
        g.setColor(Color.white);
        g.fillRect(600, 635 , 15, time);
    }
}
