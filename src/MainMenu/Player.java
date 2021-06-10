package MainMenu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**PongPlayer class extends PongGameObject. To be used as the parent Class of all PongPlayer classes
 * within each game Package directory.*/
public class Player extends GameObject {
    public Handler handler;
    public int playerScore = 0;

    //Constructor
    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
    }


    //originaly defined in PongGameObject Class as an abstract method. Here it is used
    //to move the PongPlayer Object by adding to objects x and y vars
    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

    }

    @Override
    public Rectangle getBounds() {
        return null;
    }

    @Override
    public void hide() {

    }

    public int getPlayerScore(){
        return playerScore;
    }

    public void setPlayerScore(int value){
        playerScore = value;
    }

}
