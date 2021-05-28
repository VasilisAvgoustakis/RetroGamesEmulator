package SpaceRace;

import MainMenu.*;

import java.awt.event.KeyEvent;

public class SRKeyInput extends KeyInput{
    public SRKeyInput(Handler handler) {
        super(handler);
    }

    @Override
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        //System.out.println(key);

        for(int i = 0; i < handler.players.size(); i++){
            Player tempPlayer = handler.players.get(i);
            if(tempPlayer.getID() == ID.SRPlayer){
                //key events for Player 1
                if(key == KeyEvent.VK_W ) tempPlayer.setVelY(-5);
                if(key == KeyEvent.VK_S) tempPlayer.setVelY(5);
                //if(key == KeyEvent.VK_D) tempObject.setVelX(5);
                //if(key == KeyEvent.VK_A) tempObject.setVelX(-5);
            }
            if(tempPlayer.getID() == ID.SRPlayer2){
                //key events for Player 2
                if(key == KeyEvent.VK_UP) tempPlayer.setVelY(-5);
                if(key == KeyEvent.VK_DOWN) tempPlayer.setVelY(5);
                //if(key == KeyEvent.VK_RIGHT) tempObject.setVelX(5);
                //if(key == KeyEvent.VK_LEFT) tempObject.setVelX(-5);
            }
            //exits the game
            if(key == KeyEvent.VK_ESCAPE) System.exit(1);
        }
    }

    @Override
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        for(int i = 0; i < handler.players.size(); i++){
            Player tempPlayer = handler.players.get(i);

            if(tempPlayer.getID() == ID.SRPlayer){
                //key events for Player 1
                if(key == KeyEvent.VK_W) tempPlayer.setVelY(0);
                if(key == KeyEvent.VK_S) tempPlayer.setVelY(0);
                if(key == KeyEvent.VK_D) tempPlayer.setVelX(0);
                if(key == KeyEvent.VK_A) tempPlayer.setVelX(0);
            }
            if(tempPlayer.getID() == ID.SRPlayer2){
                //key events for Player 2
                if(key == KeyEvent.VK_UP) tempPlayer.setVelY(0);
                if(key == KeyEvent.VK_DOWN) tempPlayer.setVelY(0);
                if(key == KeyEvent.VK_RIGHT) tempPlayer.setVelX(0);
                if(key == KeyEvent.VK_LEFT) tempPlayer.setVelX(0);
            }
        }

    }
}
