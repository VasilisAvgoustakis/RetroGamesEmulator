package SpaceInvaders;

import MainMenu.*;
import SpaceRace.AudioPlayer;

import java.awt.*;
import java.awt.event.KeyEvent;

public class SIProjectile extends GameObject {

    private boolean onTarget = false;

    public SIProjectile(int x, int y, ID id){
        super(x, y, id);

    }

    @Override
    public void tick() {
        y -= 15;
        collision();
    }

    @Override
    public void render(Graphics g) throws InterruptedException {
        //onTarget is true if projectile hits target
        if(onTarget){
            hide();
        }

        //scaffolding code lets the bounds of the object appear
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.red);
        g2d.draw(getBounds());

        g.setColor(Color.GREEN);
        g.fillOval(x, y,3,30);


    }

    @Override
    public void hide() {
        y = -100;
    }

    public void collision(){
        for(int i = 0; i < SpaceInvadersGame.handler.objects.size(); i++){
            GameObject tmpObject = SpaceInvadersGame.handler.objects.get(i);
            if(tmpObject.getID() == ID.AlienShip1 ||
                    tmpObject.getID() == ID.AlienShip2 ||
                    tmpObject.getID() == ID.AlienShip3){
                if(getBounds().intersects(tmpObject.getBounds())){
                    //collision code: what happens when collision occurs
                    onTarget = true;
                    //play collision sound
                    //AudioPlayer.getSound("collision").play();
                }
            }

        }
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 3, 30);
    }


}
