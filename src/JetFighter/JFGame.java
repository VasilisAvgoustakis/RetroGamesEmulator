package JetFighter;

import MainMenu.Game;
import MainMenu.ID;

/** The Main Class for the PongGame JetFighter */

public class JFGame extends Game {

    JFHUD hud;

    /**
     * Constructor of Class Game
     *
     * @param gameTitle
     */
    public JFGame(String gameTitle) {
        super(gameTitle);
        this.addKeyListener(new JFKeyInput(handler));

        //add hud
        hud = new JFHUD();

        //add players
        handler.addPlayer(new JFPlayer(300, 100, ID.JFPlayer, handler));
        handler.addPlayer(new JFPlayer(100, 200, ID.JFPlayer, handler));
    }
}
