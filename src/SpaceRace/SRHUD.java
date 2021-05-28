package SpaceRace;

import MainMenu.Game;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class SRHUD {

    long startTime = System.currentTimeMillis();
    int tempTime;
    private static int time = 240;
    private static int y = 635;
    public void tick() {
        long elapsedTime = System.currentTimeMillis();
        int sec = (int) ((elapsedTime - startTime) / 1000F);

        System.out.println(sec);
        time -= 1;
        y += 1;
    }

    public void render(Graphics g){
        g.setColor(Color.white);
        g.fillRect(600, y , 15, time);
    }
}
