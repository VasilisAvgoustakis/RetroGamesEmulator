package JetFighter;

import MainMenu.Handler;
import MainMenu.ID;
import MainMenu.KeyInput;
import MainMenu.Player;

import java.awt.event.KeyEvent;

public class JFKeyInput extends KeyInput {

    private Handler handler;
    private boolean[] keyDown = new boolean[8];

    public JFKeyInput(Handler handler) {
        super(handler);

        this.handler = handler;

        keyDown[0] = false;
        keyDown[1] = false;
        keyDown[2] = false;
        keyDown[3] = false;
        keyDown[4] = false;
        keyDown[5] = false;
        keyDown[6] = false;
        keyDown[7] = false;


    }

    @Override
    public void keyPressed(KeyEvent e) {
        //???
        super.keyPressed(e);
        int key = e.getKeyCode();

        // loop through object
        for (int i = 0; i < handler.objects.size(); i++) {
            Player tempObject = handler.players.get(i);
            //player one
            if(tempObject.getID() == ID.JFPlayer){

                if(key == KeyEvent.VK_W){
                    tempObject.setVelY(-10);
                    keyDown[0] = true;
                }
                if(key == KeyEvent.VK_S){
                    tempObject.setVelY(10);
                    keyDown[1] = true;
                }
                if(key == KeyEvent.VK_A){
                    tempObject.setVelX(-10);
                    keyDown[2] = true;
                }
                if(key == KeyEvent.VK_D){
                    tempObject.setVelX(10);
                    keyDown[3] = true;
                }

            }
            //PongPlayer two
            if(tempObject.getID() == ID.JFPlayer2){

                if(key == KeyEvent.VK_UP){
                    tempObject.setVelY(-10);
                    keyDown[4] = true;
                }
                if(key == KeyEvent.VK_DOWN){
                    tempObject.setVelY(10);
                    keyDown[5] = true;
                }
                if(key == KeyEvent.VK_LEFT){
                    tempObject.setVelX(-10);
                    keyDown[6] = true;
                }
                if(key == KeyEvent.VK_RIGHT){
                    tempObject.setVelX(10);
                    keyDown[7] = true;
                }

            }

        }
        if (key == KeyEvent.VK_ESCAPE) {
            System.exit(1);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        // loop through object
        for (int i = 0; i < handler.objects.size(); i++) {
            Player tempObject = handler.players.get(i);
            //player one
            if(tempObject.getID() == ID.JFPlayer){

                if(key == KeyEvent.VK_W){
                    keyDown[0] = false;
                }
                if(key == KeyEvent.VK_S){
                    keyDown[1] = false;
                }
                if(key == KeyEvent.VK_A){
                    keyDown[2] = false;
                }
                if(key == KeyEvent.VK_D){
                    keyDown[3] = false;
                }
                if (!keyDown[0] && !keyDown[1]) {
                    tempObject.setVelY(0);
                }
                    if (!keyDown[2] && !keyDown[3]) {
                        tempObject.setVelX(0);
                    }
                }
            //PongPlayer two
            if(tempObject.getID() == ID.JFPlayer2){

                if(key == KeyEvent.VK_UP){
                    keyDown[4] = false;
                }
                if(key == KeyEvent.VK_DOWN){
                    keyDown[5] = false;
                }
                if(key == KeyEvent.VK_LEFT){
                    keyDown[6] = false;
                }
                if(key == KeyEvent.VK_RIGHT){
                    keyDown[7] = false;
                }
                if (!keyDown[4] && !keyDown[5]) {
                    tempObject.setVelY(0);
                }
                if (!keyDown[6] && !keyDown[7]) {
                    tempObject.setVelX(0);
                }

            }

        }
    }
}
