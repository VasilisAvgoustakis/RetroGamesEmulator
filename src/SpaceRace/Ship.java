package SpaceRace;
import java.awt.*;

public class Ship {
    int score, r, height, width, x, y;
    boolean isUp, isDown;

    public Ship(int x){
        this.x = x;
        this.score = 0;
        this.respawn();
        this.r = 10;
    }

    public void respawn(){
        this.y = height - 20;
        this.isUp = false;
        this.isDown = false;
    }

    public void update(){
        if(this.isUp && this.y > 0){
            this.up();
        } else if (this.isDown && this.y < height - 20) {
            this.down();
        }
    }

    public void display(SpaceRaceCanvas canvas){
        Graphics g = canvas.getGraphics();
        g.setColor(Color.white);
        g.fillOval(this.x, this.y, this.r * 2, this.r * 2);
    }

    public void up(){
        this.y--;
    }

    public void down(){
        this.y++;
    }

    public boolean hasPlayerScoredAPoint(){
        if(this.y <= 0){
            return true;
        }
        return false;
    }
}
