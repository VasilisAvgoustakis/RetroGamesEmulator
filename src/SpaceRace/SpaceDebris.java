package SpaceRace;

import MainMenu.GameObject;
import MainMenu.ID;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class SpaceDebris extends GameObject {

    private String direction;
    private int gameLevel = SpaceRaceGame.getGameLevel();

    public SpaceDebris (int x, int y, ID id, String direction) {
        super(x,y,id);
        this.direction = direction;
    }

    @Override
    public void tick() {

        if(this.direction.equals("left")) x += gameLevel;
        if(this.direction.equals("right")) x -= gameLevel;
    }

    @Override
    public void render(Graphics g) {
        //scaffolding code lets the bounds of the object appear
        //Graphics2D g2d = (Graphics2D) g;
        //g.setColor(Color.red);
        //g2d.draw(getBounds());

        g.setColor(Color.white);
        g.fillOval(x, y, 7, 7);
    }

    @Override
    public Rectangle getBounds(){
        return new Rectangle(x, y, 7, 7);
    }

    @Override
    public void hide() {
        
    }
}
