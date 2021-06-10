package JetFighter;

import MainMenu.Handler;
import MainMenu.ID;
import MainMenu.Player;

import java.awt.*;

public class JFPlayer extends Player {

    public JFPlayer(int x, int y, ID id, Handler handler) {
        super(x, y, id, handler);
        this.handler = handler;
    }

    @Override
    public Rectangle getBounds(){
        return new Rectangle(x, y, 50, 50 );
    }


    @Override
    public void tick(){
        x += velX;
        y += velY;
    }

    //Ship
    @Override
    public void render(Graphics g){

        if(id== ID.JFPlayer){
            g.setColor(Color.BLUE);
        }
        if(id == ID.JFPlayer2){
            g.setColor(Color.RED);
        }

        g.fillRect(x, y, 50, 50);

    }

    //ADD Collision


}
