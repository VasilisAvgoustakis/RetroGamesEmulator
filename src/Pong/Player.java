package Pong;

import java.awt.*;

public class Player extends GameObject{



//paddle constructor
    public Player(int x, int y, ID id) {
        super(x, y, id);
            }

    //collide
    public Rectangle getBounds() {
        return new Rectangle(x,y,15,80);
    }

    //movement of the paddle
    public void tick() {
        x += velX;
        y += velY;

        y = Game.clamp(y, 3, Game.HEIGHT-120);

    }


//Dimensions of the paddle
    public void render(Graphics g) {


        if(id == ID.Player){
            g.setColor(Color.blue);
        }
        else if(id == ID.Player2){
            g.setColor(Color.red);
        }
        g.fillRect(x, y, 15, 80);
    }


}
