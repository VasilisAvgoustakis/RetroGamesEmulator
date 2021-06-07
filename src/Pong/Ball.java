package Pong;

import javax.swing.*;
import java.awt.*;

import java.util.Random;



public class Ball extends GameObject{

 private Handler handler;
 private Random r = new Random();
 private HUD hud;


 //constructor for a Ball Object
    public Ball(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

        velX = 3;
        velY = 3;
    }
    public Ball(int x, int y, ID id, Handler handler, HUD hud){
        super(x, y, id);
        this.handler = handler;
        this.hud = hud;
        velX = 3;
        velY = 3;

    }

    public Rectangle getBounds() {
        return new Rectangle(x,y,16,16);
    }

//movement of the Ball
    public void tick() {
        x += velX;
        y += velY;

        collision();



    }
    private void collision(){


        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getId() == ID.Player || tempObject.getId() == ID.Player2 || tempObject.getId() == ID.EnemyAI){

                if(getBounds().intersects(tempObject.getBounds())){
                    //collision code

                    if(velX < 0){
                        velX = (float) ((velX -0.5) *(-1));
                    }
                    else{
                        velX = (float) ((velX + 0.5) *(-1));
                    }

                }
            }
        }
        if(y <= 0 || y >= PongGame.HEIGHT-50) {
            velY *= -1;
        }
        else if(hud.getScore2() == 5){

            JOptionPane.showMessageDialog(null,"Player Two won!");
            System.exit(1);
        }
        else if(hud.getScore() == 5){

            JOptionPane.showMessageDialog(null,"Player One won!");
            System.exit(1);
        }

        else if(x <= 0 ){

                handler.removeObject(this);
                hud.setScore2(1);
                handler.addObject(new Ball((PongGame.WIDTH / 2) - 5, (PongGame.HEIGHT / 2) - 5, ID.Ball, handler, this.hud));

        }
        else if(x >= PongGame.WIDTH-30) {

                handler.removeObject(this);
                hud.setScore(1);
                handler.addObject(new Ball((PongGame.WIDTH/2)-5,(PongGame.HEIGHT/2) -5, ID.Ball, handler, this.hud));

        }

    }

//Dimensions of the Ball
    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, y, 20, 20);
    }
    }

