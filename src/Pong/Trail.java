package Pong;

import java.awt.*;


//making a trail (specific for the Ball)
public class Trail extends GameObject{

    private  float alpha = 1;
    private Handler handler;
    private Color color;
    private float life;

    public Trail(int x, int y, ID id, Color color, Handler handler, float life) {
        super(x, y, id);
        this.color = color;
        this.life = life;
        this.handler = handler;
    }


    public void tick() {
        if(alpha > life){
            alpha -= life - 0.00001f;
        }
        else {
            handler.removeObject(this);
        }
    }


    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(makeTransparent(alpha));
        g.setColor(color);
        g.fillRect(x,y,10, 10);
        g2d.setComposite(makeTransparent(1));
    }

    private AlphaComposite makeTransparent(float alpha){
        int type = AlphaComposite.SRC_OVER;
        return (AlphaComposite.getInstance(type, alpha));
    }


    public Rectangle getBounds() {
        return null;
    }
}
