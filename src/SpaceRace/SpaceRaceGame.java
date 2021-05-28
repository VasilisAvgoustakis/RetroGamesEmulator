package SpaceRace;
import MainMenu.*;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/** The Main class for the game space Invaders */

public class SpaceRaceGame extends Game {

    SRHUD hud;

    public SpaceRaceGame(String gameTitle) throws IOException, InterruptedException {
        super(gameTitle);
        this.addKeyListener(new SRKeyInput(handler));

        //add hud
        hud = new SRHUD();

        //add players
        handler.addPlayer(new SRPlayer(300, 775, ID.SRPlayer, handler));
        handler.addPlayer(new SRPlayer(900, 775, ID.SRPlayer2, handler));

        //add debris
        int max = 760;
        int min = 5;
        int randomY1, randomY2;
        while (true) {
            TimeUnit.SECONDS.sleep(1);
            randomY1 = (int) (Math.random() * ((max - min) + 1));
            randomY2 = (int) (Math.random() * ((max - min) + 1));
            handler.addObject(new SpaceDebris(0, randomY1, ID.SRDebris, "left"));
            handler.addObject(new SpaceDebris(1200, randomY2, ID.SRDebris, "right"));
        }
    }
    @Override
    public void tick() {
        super.tick();
        hud.tick();
    }

    @Override
    public void render() throws InterruptedException {
        //The BufferStrategy class represents the mechanism with which
        //to organize complex memory on a particular Canvas or Window.
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }

        //Creates a graphics context for the drawing buffer.
        Graphics g = bs.getDrawGraphics();
        //sets the game background color
        g.setColor(Color.black);
        //fills a rectangle the size of the game window with the color set above
        g.fillRect(0, 0, WIDTH, HEIGHT);
        //Calls the corresponding render method. To draw objects on screen.
        // From here -> handler -> GameObject -> to actual gameObject
        // that extends GameObject Class
        handler.render(g);
        hud.render(g);
        //Disposes of this graphics context and releases any system resources that it is using.
        g.dispose();
        //Makes the next available buffer visible by either copying the memory (blitting)
        // or changing the display pointer (flipping).
        bs.show();
    }

    public static void main (String[]args) throws IOException, InterruptedException {
        new SpaceRaceGame("Space Race");

    }

}
