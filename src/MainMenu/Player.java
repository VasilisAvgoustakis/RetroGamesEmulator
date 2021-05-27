package MainMenu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**Player class extends GameObject. To be used as the parent Class of all Player classes
 * within each game Package directory.*/
public class Player extends GameObject {

    //Constructor
    public Player(int x, int y, ID id) {
        super(x, y, id);
    }
    //originaly defined in GameObject Class as an abstract method. Here it is used
    //to move the Player Object by adding to objects x and y vars
    @Override
    public void tick() {
    }

    @Override
    public void render(Graphics g) {

    }


}
