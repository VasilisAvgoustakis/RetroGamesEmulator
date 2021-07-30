package SpaceRace;
import MainMenu.GameObject;
import MainMenu.ID;

import java.awt.*;

public class Particle extends GameObject {

    private int x;
    private int y;
    private int dx;
    private int dy;
    private int size;
    private int life;
    private Color color;

    public Particle(int x, int y, int dx, int dy, int size, int life, Color c, ID id){
        super(x,y,id);
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.size = size;
        this.life = life;
        this.color = c;
    }

    public boolean update(){
        x += dx;
        y += dy;
        life--;
        if(life <= 0)
            return true;
        return false;
    }

    @Override
    public void tick() {

    }

    public void render(Graphics g){
        Graphics2D g2d = (Graphics2D) g.create();

        g2d.setColor(color);
        g2d.fillRect(x-(size/2), y-(size/2), size, size);

        g2d.dispose();
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }

    @Override
    public void hide() {

    }

    @Override
    public void destroyObject(int objectNum) {

    }

}
