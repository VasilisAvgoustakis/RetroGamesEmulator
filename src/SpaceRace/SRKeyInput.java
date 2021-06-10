package SpaceRace;

import MainMenu.*;

import java.awt.event.KeyEvent;

public class SRKeyInput extends KeyInput{
    public SRKeyInput(Handler handler) {
        super(handler);
    }

    public static boolean restart = false;
    private int spaceButtonCounter = 0;

    @Override
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        //System.out.println(key);

        for(int i = 0; i < handler.players.size(); i++) {
            Player tempPlayer = handler.players.get(i);
            if (tempPlayer.getID() == ID.SRPlayer) {
                //key events for PongPlayer 1
                if (key == KeyEvent.VK_W) tempPlayer.setVelY(-5);
                if (key == KeyEvent.VK_S) tempPlayer.setVelY(5);

            }
            if (tempPlayer.getID() == ID.SRPlayer2) {
                //key events for PongPlayer 2
                if (key == KeyEvent.VK_UP) tempPlayer.setVelY(-5);
                if (key == KeyEvent.VK_DOWN) tempPlayer.setVelY(5);
            }
        }
        //exits the game
        if(key == KeyEvent.VK_ESCAPE) System.exit(1);

        //pause game
       //if(key == KeyEvent.VK_SPACE){
       //    spaceButtonCounter += 1;
       //    System.out.println(spaceButtonCounter);
       //    if(spaceButtonCounter % 2 != 0) {
       //        System.out.println("false");
       //        SpaceRaceGame.setRunningStatus(false);
       //    }
       //    else if(spaceButtonCounter % 2 == 0){
       //        System.out.println("true");
       //        SpaceRaceGame.setRunningStatus(true);
       //    }
       //}

        //if(SRHUD.getTimeBarHeight() < 45 && key == KeyEvent.VK_ENTER){
          //  SpaceRaceGame.setRunningStatus(false);

        //}

    }

    @Override
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        for(int i = 0; i < handler.players.size(); i++){
            Player tempPlayer = handler.players.get(i);

            if(tempPlayer.getID() == ID.SRPlayer){
                //key events for PongPlayer 1
                if(key == KeyEvent.VK_W) tempPlayer.setVelY(0);
                if(key == KeyEvent.VK_S) tempPlayer.setVelY(0);
                if(key == KeyEvent.VK_D) tempPlayer.setVelX(0);
                if(key == KeyEvent.VK_A) tempPlayer.setVelX(0);
            }
            if(tempPlayer.getID() == ID.SRPlayer2){
                //key events for PongPlayer 2
                if(key == KeyEvent.VK_UP) tempPlayer.setVelY(0);
                if(key == KeyEvent.VK_DOWN) tempPlayer.setVelY(0);
                if(key == KeyEvent.VK_RIGHT) tempPlayer.setVelX(0);
                if(key == KeyEvent.VK_LEFT) tempPlayer.setVelX(0);
            }

        }

    }

    public static boolean getRestart(){
        return restart;
    }

}
