package SpaceInvaders;
import MainMenu.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

/** The Main class for the game space Invaders */

public class SpaceRaceGame extends Game {

    public SpaceRaceGame(String gameTitle) throws IOException {
        super(gameTitle);
        this.addKeyListener(new SRKeyInput(handler));
        handler.addPlayer(new SRPlayer(300, 800, ID.SRPlayer));
        handler.addPlayer(new SRPlayer(900, 800, ID.SRPlayer2));
    }

    public static void main(String[] args) throws IOException {
        new SpaceRaceGame("Space Race");
    }


}
