package Pong;

import java.awt.*;

public class PongEnemyAI extends PongGameObject {

    public int ball;
    public PongHandler handler;


    public PongEnemyAI(int x, int y, PongID id, PongHandler handler) {

        super(x, y, id);
        this.handler = handler;

    }

    public Rectangle getBounds() {
        return new Rectangle(x,y,15,80);
    }

    public void tick() {

        movmentEnemy();





            y = PongGame.clamp(y, 3, PongGame.HEIGHT-120);


    }


    public void render(Graphics g) {
        if(id == PongID.EnemyAI){
            g.setColor(Color.RED);
        }
        g.fillRect(x, y, 15, 80);
    }
    public void movmentEnemy(){

        for (int i = 0; i < handler.object.size(); i++) {

            PongGameObject tempObject = handler.object.get(i);
            if(tempObject.getId() == PongID.Ball){

                ball = handler.object.get(i).getY();

                if(ball == this.y){

                }
                else if(ball > this.y){
                    if(this.y <= PongGame.HEIGHT - 125){
                        this.y += 3;
                    }
                }
                else if(this.y < this.y +75){
                    if(this.y >= 20){
                        this.y -= 3;
                    }
                }
            }


            }
    }



}
