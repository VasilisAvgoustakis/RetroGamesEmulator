package SpaceRace;
import MainMenu.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/** The Main class for the game space Invaders */

public class SpaceRaceGame extends Game {

    public SpaceRaceGame(String gameTitle) throws IOException, InterruptedException {
        super(gameTitle);
        this.addKeyListener(new SRKeyInput(handler));

        //add players
        handler.addPlayer(new SRPlayer(300, 775, ID.SRPlayer));
        handler.addPlayer(new SRPlayer(900, 775, ID.SRPlayer2));

        //add debris
        int max = 760;
        int min = 5;
        while (true) {
            TimeUnit.SECONDS.sleep(1);
            int randomY = (int) (Math.random() * ((max - min) + 1));
            handler.addObject(new SpaceDebris(0, randomY, ID.SRDebris));
        }
    }

    public static void main (String[]args) throws IOException, InterruptedException {
        new SpaceRaceGame("Space Race");

    }

}
