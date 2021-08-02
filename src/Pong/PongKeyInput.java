package Pong;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PongKeyInput extends KeyAdapter {

    private PongHandler handler;
    private boolean[] keyDown = new boolean[4];


    public PongKeyInput(PongHandler handler) {
        this.handler = handler;

        keyDown[0] = false;
        keyDown[1] = false;
        keyDown[2] = false;
        keyDown[3] = false;


    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();


// loop through object
        for (int i = 0; i < handler.object.size(); i++) {
            PongGameObject tempObject = handler.object.get(i);
            //player one
            if (tempObject.getId() == PongID.Player) {

                if (key == KeyEvent.VK_W) {
                    tempObject.setVelY(-10);
                    keyDown[0] = true;
                }
                if (key == KeyEvent.VK_S) {
                    tempObject.setVelY(10);
                    keyDown[1] = true;
                }
            }
            //player two
            if (tempObject.getId() == PongID.Player2) {
                if (key == KeyEvent.VK_UP) {
                    tempObject.setVelY(-10);
                    keyDown[2] = true;
                }
                if (key == KeyEvent.VK_DOWN) {
                    tempObject.setVelY(10);
                    keyDown[3] = true;
                }
            }
        }
        if (key == KeyEvent.VK_ESCAPE) {
            System.exit(1);
        }
    }


    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        //stop movement
        for (int i = 0; i < handler.object.size(); i++) {
            PongGameObject tempObject = handler.object.get(i);
            //player one
            if (tempObject.getId() == PongID.Player) {
                //Key events PongPlayer one
                if (key == KeyEvent.VK_W) {
                    keyDown[0] = false;

                }
                if (key == KeyEvent.VK_S) {
                    keyDown[1] = false;
                }
                //vertical movment
                if (!keyDown[0] && !keyDown[1]) {
                    tempObject.setVelY(0);
                }
                //player two
            if (tempObject.getId() == PongID.Player2) {
                if (key == KeyEvent.VK_UP) {
                        keyDown[2] = false;
                    }
                if (key == KeyEvent.VK_DOWN) {
                        keyDown[3] = false;
                    }
               if (!keyDown[2] && !keyDown[3]) {
                        tempObject.setVelY(0);
                    }
                }
            }
        }
    }
}
