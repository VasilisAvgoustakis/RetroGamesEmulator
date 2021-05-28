package SpaceRace;

import MainMenu.GameObject;
import MainMenu.ID;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class SpaceDebris extends GameObject {

    private String direction;

    public SpaceDebris (int x, int y, ID id, String direction) {
        super(x,y,id);
        this.direction = direction;
    }

    @Override
    public void tick() {

        if(this.direction.equals("left")) x += 1;
        if(this.direction.equals("right")) x -= 1;
    }

    @Override
    public void render(Graphics g) {
        //scaffolding code lets the bounds of the object appear
        //Graphics2D g2d = (Graphics2D) g;
        //g.setColor(Color.red);
        //g2d.draw(getBounds());

        g.setColor(Color.white);
        g.fillOval(x, y, 5, 5);
    }

    @Override
    public Rectangle getBounds(){
        return new Rectangle(x, y, 5, 5 );
    }

    @Override
    public void hide() {
        
    }
}
