package SpaceRace;
import MainMenu.*;

import java.io.IOException;

/** The Main class for the game space Invaders */

public class SpaceRaceGame extends Game {

    public SpaceRaceGame(String gameTitle) throws IOException {
        super(gameTitle);
        this.addKeyListener(new SRKeyInput(handler));
        handler.addPlayer(new SRPlayer(300, 775, ID.SRPlayer));
        handler.addPlayer(new SRPlayer(900, 775, ID.SRPlayer2));
    }

    public static void main(String[] args) throws IOException {
        new SpaceRaceGame("Space Race");

    }

    //TODO add array for space debris

}
