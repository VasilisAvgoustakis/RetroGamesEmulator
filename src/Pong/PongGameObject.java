package Pong;

import java.awt.*;

//Gameobjects (size, id, movment) + methods
public abstract class PongGameObject {

    protected int x, y;
    protected PongID id;
    protected float velX, velY;

    public PongGameObject(int x, int y, PongID id){
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();

    // getter and setter
    public void setX(int x){
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }
    public int getY() {
        return y;
    }

    public void setId(PongID id) {
        this.id = id;
    }

    public PongID getId() {
        return id;
    }

    public void setVelX(int velX) {
        this.velX = velX;
    }

    public float getVelX() {
        return velX;
    }

    public void setVelY(int velY) {
        this.velY = velY;
    }

    public float getVelY() {
        return velY;
    }


}
