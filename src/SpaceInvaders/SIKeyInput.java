package SpaceInvaders;

import MainMenu.*;

import java.awt.event.KeyEvent;

public class SIKeyInput extends KeyInput {
    public SIKeyInput(Handler handler) {
        super(handler);
    }

    public static boolean restart = false;

    @Override
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        //System.out.println(key);

        for(int i = 0; i < handler.players.size(); i++) {
            Player tempPlayer = handler.players.get(i);
            if (tempPlayer.getID() == ID.SIPlayer) {
                //key events for Player 1
                if (key == KeyEvent.VK_W) tempPlayer.setVelY(-5);
                if (key == KeyEvent.VK_S) tempPlayer.setVelY(5);
                if (key == KeyEvent.VK_A) tempPlayer.setVelX(-5);
                if (key == KeyEvent.VK_D) tempPlayer.setVelX(5);

            }
        }
        //exits the game
        if(key == KeyEvent.VK_ESCAPE) System.exit(1);

    }

    @Override
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        for(int i = 0; i < handler.players.size(); i++){
            Player tempPlayer = handler.players.get(i);

            if(tempPlayer.getID() == ID.SIPlayer){
                //key events for SIPlayer
                if(key == KeyEvent.VK_W) tempPlayer.setVelY(0);
                if(key == KeyEvent.VK_S) tempPlayer.setVelY(0);
                if(key == KeyEvent.VK_D) tempPlayer.setVelX(0);
                if(key == KeyEvent.VK_A) tempPlayer.setVelX(0);
            }

        }

    }

    public static boolean getRestart(){
        return restart;
    }

}


