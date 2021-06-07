package Pong;

import java.awt.*;

public class EnemyAI extends GameObject{

    public int ball;
    public Handler handler;


    public EnemyAI(int x, int y, ID id, Handler handler) {

        super(x, y, id);
        this.handler = handler;

    }

    public Rectangle getBounds() {
        return new Rectangle(x,y,15,80);
    }

    public void tick() {

        movmentEnemy();





            y = Game.clamp(y, 3, Game.HEIGHT-120);


    }


    public void render(Graphics g) {
        if(id == ID.EnemyAI){
            g.setColor(Color.RED);
        }
        g.fillRect(x, y, 15, 80);
    }
    public void movmentEnemy(){

        for (int i = 0; i < handler.object.size(); i++) {

            GameObject tempObject = handler.object.get(i);
            if(tempObject.getId() == ID.Ball){

                ball = handler.object.get(i).getY();

                if(ball == this.y){

                }
                else if(ball > this.y){
                    if(this.y <= Game.HEIGHT - 125){
                        this.y += 3;
                    }
                }
                else if(this.y < this.y +75){
                    if(this.y >= 20){
                        this.y -= 2;
                    }
                }
            }


            }
    }



}
