package SpaceInvaders;

import MainMenu.*;
import org.lwjgl.Sys;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;

/** The Main class for the game space Invaders */

public class SpaceInvadersGame extends Game implements MouseMotionListener {

    private static int alienColumns = 16;
    private int alienRows = 5;
    private int initX = (int)(SpaceInvadersGame.WIDTH / 12 * 2.1);
    private int initY = (int)(SpaceInvadersGame.WIDTH / 12 );


    public SpaceInvadersGame (String gameTitle) throws IOException, InterruptedException {
        super(gameTitle);
        this.addKeyListener(new SIKeyInput(handler));
        this.addMouseMotionListener(this);


        //setRunningStatus(false);
        //add players
        handler.addPlayer(new SIPlayer((SpaceInvadersGame.WIDTH / 12 * 6),
                (int)(SpaceInvadersGame.WIDTH / 12 * 7.75), ID.SIPlayer, handler));

        //add aliens
        //handler.addObject(new AlienShip(initX,
             //   initY, ID.AlienShip2));
        spawnAlienArmy(alienColumns, initX, initY);
        // starts the game
        start();
    }



    /**Is the beating heart of the game. Sets time and rhythm for renewing frame and objects.*/
    @Override
    public void run(){
        //automatically gives controls to the game window so that you don't have to click on it
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

    public void spawnAlienArmy(int columns, int initX, int initY) throws IOException {
        int originalX = initX;
        int originalY = initY;
        int columnNum = 1;
        while(columns != 0) {
            handler.addObject(new AlienShip(initX,
                    initY, ID.AlienShip2,1, columnNum));
            initY += 60;
            handler.addObject(new AlienShip(initX,
                    initY, ID.AlienShip2, 2, columnNum));
            initY += 60;
            handler.addObject(new AlienShip(initX,
                    initY, ID.AlienShip3, 3, columnNum));
            initY += 60;
            handler.addObject(new AlienShip(initX,
                    initY, ID.AlienShip3,4, columnNum));
            columns--;
            columnNum++;
            initX += 50;
            initY = originalY;
        }
    }

    public static int getAlienArmyColumns(){
        return alienColumns;
    }


    public static void main(String[] args) throws IOException, InterruptedException {
        new SpaceInvadersGame("Space Invaders");
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //System.out.println("x = " + e.getX() + " y = " + e.getY());
    }
}
