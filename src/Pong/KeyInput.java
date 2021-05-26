package Pong;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private Handler handler;

    public KeyInput(Handler handler){
        this.handler = handler;

    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();


// loop through object
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            //player one
            if(tempObject.getId() == ID.Player){

                if(key == KeyEvent.VK_W) {
                    tempObject.setVelY(-5);
                }
                if(key == KeyEvent.VK_S) {
                    tempObject.setVelY(5);
                }
            }
            //player two
            if(tempObject.getId() == ID.Player2){
                if(key == KeyEvent.VK_UP) {
                    tempObject.setVelY(-5);
                }
                if(key == KeyEvent.VK_DOWN) {
                    tempObject.setVelY(5);
                }
            }
        }
        if(key == KeyEvent.VK_ESCAPE){
            System.exit(1);
        }
    }


    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        //stop movement
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            //player one
            if(tempObject.getId() == ID.Player){
                //Key events Player one
                if(key == KeyEvent.VK_W) {
                    tempObject.setVelY(0);
                }
                if(key == KeyEvent.VK_S) {
                    tempObject.setVelY(0);
                }
            }
            //player two
            if(tempObject.getId() == ID.Player2){
                if(key == KeyEvent.VK_UP) {
                    tempObject.setVelY(0);
                }
                if(key == KeyEvent.VK_DOWN) {
                    tempObject.setVelY(0);
                }
            }
        }
    }
}
