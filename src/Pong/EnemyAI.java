package Pong;

import java.awt.*;

public class EnemyAI extends GameObject{

    private GameObject ball;
    private Handler handler;



    public EnemyAI(int x, int y, ID id, Handler handler) {
        super(x, y, id);

        this.handler = handler;

        for (int i = 0; i < handler.object.size(); i++) {
            if (handler.object.get(i).getId() == ID.Ball) {
                ball = handler.object.get(i);
            }
        }
    }


    public void tick() {

                velY = ball.getX();

            x += velX;
            y += velY;



            y = Game.clamp(y, 3, Game.HEIGHT - 120);

    }

    public void render(Graphics g) {

        if(id == ID.EnemyAI){
            g.setColor(Color.red);
        }
        g.fillRect(x, y, 15, 80);
    }


    public Rectangle getBounds() {
        return new Rectangle(x,y,15,80);
    }
}
