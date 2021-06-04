package SpaceInvaders;

import MainMenu.*;

import java.io.IOException;

/** The Main class for the game space Invaders */

public class SpaceInvadersGame extends Game {

    private int alienColumns = 10;
    private int alienRows = 5;
    private int initX = (int)(SpaceInvadersGame.WIDTH / 12 * 2.5);
    private int initY = (int)(SpaceInvadersGame.WIDTH / 12 );

    public SpaceInvadersGame (String gameTitle) throws IOException, InterruptedException {
        super(gameTitle);
        this.addKeyListener(new SIKeyInput(handler));

        //setRunningStatus(false);
        //add players
        handler.addPlayer(new SIPlayer((SpaceInvadersGame.WIDTH / 12 * 6),
                (int)(SpaceInvadersGame.WIDTH / 12 * 7.75), ID.SIPlayer, handler));

        //add aliens
        spawnAlienArmy(alienRows, alienColumns, initX, initY);
        // starts the game
        start();
    }

    /**Is the beating heart of the game. Sets time and rhythm for renewing frame and objects.*/
    @Override
    public void run(){
        //automatically gives controls to the game window so that you dont have to click on it
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 2000000000 / amountOfTicks;
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

    public void spawnAlienArmy(int rows, int columns, int initX, int initY) throws IOException {
        int originalX = initX;
        int originalY = initY;
        while(alienColumns != 0) {
            handler.addObject(new AlienShip(initX,
                    initY, ID.AlienShip2));
            initY += 60;
            handler.addObject(new AlienShip(initX,
                    initY, ID.AlienShip2));
            initY += 60;
            handler.addObject(new AlienShip(initX,
                    initY, ID.AlienShip3));
            initY += 60;
            handler.addObject(new AlienShip(initX,
                    initY, ID.AlienShip3));
            alienColumns--;
            initX += 70;
            initY = originalY;
        }
    }


    public static void main(String[] args) throws IOException, InterruptedException {
        new SpaceInvadersGame("Space Invaders");
    }
}
