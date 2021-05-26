package Pong;

import java.awt.*;
import java.util.Random;



public class Ball extends GameObject{

 private Handler handler;
 private Random r;


//constructor for a Ball Object
    public Ball(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

        velX = 2;
        velY = 2;
    }

    public Rectangle getBounds() {
        return new Rectangle(x,y,16,16);
    }

//movement of the Ball
    public void tick() {
        x += velX;
        y += velY;

        if(y <= 0 || y >= Game.HEIGHT-50) {
            velY *= -1;
        }
        else if(x <= 0 || x >= Game.WIDTH-50) {
            HUD.POINTS ++;

        }
        collision();
        //adding a trail
        handler.addObject(new Trail(x,y, ID.Trail, Color.white, handler,0.02f));

    }
    private void collision(){
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getId() == ID.Player || tempObject.getId() == ID.Player2){

                if(getBounds().intersects(tempObject.getBounds())){
                    //collicion code
                    velX *= -1;

                }
            }
        }
    }

//Dimensions of the Ball
    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, y, 10, 10);
    }
    }

