package Pong;

import java.awt.*;

public class HUD {

    private int x;
    private int y;
    private int z;
    private int u;



    public int score = 0;
    public int score2= 0;



    public HUD(int x, int y, int z, int u) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.u = u;

    }

    public void tick() {

    }


    public void render(Graphics g) {

       g.drawString("Score:" + getScore(), x, y);
       g.drawString("Score:" + getScore2(), z, u);

    }
    public void setScore(int score) {
        this.score = this.score + score;
    }
    public int getScore() {
        return score;
    }



    public void setScore2(int score2) {
        this.score2 = this.score2 + score2;
    }
    public int getScore2() {
        return score2;
    }

}
