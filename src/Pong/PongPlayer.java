package Pong;

import java.awt.*;

public class PongPlayer extends PongGameObject {



//paddle constructor
    public PongPlayer(int x, int y, PongID id) {
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

        y = PongGame.clamp(y, 3, PongGame.HEIGHT-120);

    }


//Dimensions of the paddle
    public void render(Graphics g) {


        if(id == PongID.Player){
            g.setColor(Color.BLUE);
        }
        else if(id == PongID.Player2){
            g.setColor(Color.red);
        }
        g.fillRect(x, y, 15, 80);
    }


}
