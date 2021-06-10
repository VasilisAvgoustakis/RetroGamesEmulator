package SpaceInvaders;

import MainMenu.*;

import java.awt.*;

public class SIProjectile extends GameObject {

    private boolean onTarget = false;

    public SIProjectile(int x, int y, ID id){
        super(x, y, id);

    }

    @Override
    public void tick() {
        y -= 15;
        collision();

        //remove projectile after exiting game screen
        if(y <= 0)hide();
    }

    @Override
    public void render(Graphics g) throws InterruptedException {
        //onTarget is true if projectile hits target
        //if(onTarget){
        //    hide();
        //}

        //scaffolding code lets the bounds of the object appear
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.red);
        g2d.draw(getBounds());

        g.setColor(Color.GREEN);
        g.fillOval(x, y,3,30);

    }

    @Override
    public void hide() {
        //remove Projectile from list
        for(int i = 0; i < SpaceInvadersGame.handler.objects.size(); i++) {
            //System.out.println("removed");
            GameObject tempObject = SpaceInvadersGame.handler.objects.get(i);
            if (tempObject.getID() == ID.SIProjectile) {
                //System.out.println("removed");
                SpaceInvadersGame.handler.objects.remove(tempObject);
            }
        }
    }

    @Override
    public void destroyObject(int objectNum) {

    }

    public void collision(){
        for(int i = 0; i < SpaceInvadersGame.handler.objects.size(); i++){
            GameObject tmpObject = SpaceInvadersGame.handler.objects.get(i);
            ID tempID = tmpObject.getID();
            if(tempID == ID.AlienShip1 ||
                    tempID == ID.AlienShip2 ||
                    tempID == ID.AlienShip3){
                if(getBounds().intersects(tmpObject.getBounds())){
                    //collision code: what happens when collision occurs
                    //onTarget = true;
                    hide();
                    tmpObject.destroyObject(tmpObject.getObjectNum());
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
