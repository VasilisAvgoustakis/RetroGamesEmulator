package SpaceRace;
import MainMenu.*;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/** The Main class for the game space Invaders */

public class SpaceRaceGame extends Game {

    SRHUD hud;
    long startTime = System.currentTimeMillis();

    public SpaceRaceGame(String gameTitle) throws IOException, InterruptedException {
        super(gameTitle);
        this.addKeyListener(new SRKeyInput(handler));


        //add hud
        hud = new SRHUD();

        //load sounds and music
        AudioPlayer.load();

        //play ambient music
        AudioPlayer.getMusic("ambient").loop();

        //add players
        handler.addPlayer(new SRPlayer((SpaceRaceGame.WIDTH / 12 * 3),
                        (int)(SpaceRaceGame.WIDTH / 12 * 7.75), ID.SRPlayer, handler));
        handler.addPlayer(new SRPlayer(SpaceRaceGame.WIDTH / 12 * 9,
                        (int)(SpaceRaceGame.WIDTH / 12 * 7.75), ID.SRPlayer2, handler));

        //start timer
        //SRTimer = new Timer(60);

        //add debris
        int max = SpaceRaceGame.WIDTH / 12 * 7; //max y to spawn debris
        int min = (int)(SpaceRaceGame.WIDTH / 12 * 0.05); //min y to spawn debris
        int randomY1, randomY2;
        start();
        while (SRHUD.getTimeBarHeight() > (int)(SpaceRaceGame.WIDTH / 12 * 0.24)) {
            TimeUnit.MILLISECONDS.sleep(2000 / gameLevel);
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
        long elapsedTime = System.currentTimeMillis();
        int elapsedSec =(int) ((elapsedTime - startTime) / 1000F);
        //if(((double)gameTime + 1.0) < )
        setGameTime(elapsedSec);
        //System.out.println(SRTimer.getCountdownSec());



    }

    @Override
    public void render() throws InterruptedException {
        //The BufferStrategy class represents the mechanism with which
        //to organize complex memory on a particular Canvas or PongWindow.
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
        // From here -> handler -> PongGameObject -> to actual gameObject
        // that extends PongGameObject Class
        handler.render(g);
        hud.render(g);
        //Disposes of this graphics context and releases any system resources that it is using.
        g.dispose();
        //Makes the next available buffer visible by either copying the memory (blitting)
        // or changing the display pointer (flipping).
        bs.show();
    }

    /**Is the beating heart of the game. Sets time and rhythm for renewing frame and objects.*/
    @Override
    public void run(){
        //automatically gives controls to the game window so that you dont have to click on it
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            //System.out.println(delta);
            lastTime = now;
            while(delta >= 1){
                tick();
                delta--;
            }
            if(running) {
                try {
                    render();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            frames++;

            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                //System.out.println("FPS:   " + frames);
                frames = 0;
            }
        }
        stop();
    }


    public static Handler getHandler(){
        return handler;
    }

    public static void main (String[]args) throws IOException, InterruptedException {
        new SpaceRaceGame("Space Race");
    }

}
