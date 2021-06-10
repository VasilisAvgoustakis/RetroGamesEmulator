package MainMenu;

import java.awt.*;

/** An abstract class from which all game objects inherit. */

public abstract class GameObject{
    //x and y used to set the GameObjects location
    protected int x, y;
    // Object ID to differantiate through differebte kind of objects
    protected ID id;
    // velocity of object movement
    protected int velX, velY;

    //CONSTRUCTORS
    public GameObject(int x, int y, ID id){
        this.x = x;
        this.y = y;
        this.id = id;
    }

    //abstract methods
    public abstract void tick();
    public abstract void render(Graphics g) throws InterruptedException;
    public abstract Rectangle getBounds();
    public abstract void hide();
    public abstract void destroyObject(int objectNum);

    //getter & setters
    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void setID(ID id){
        this.id = id;
    }

    public ID getID(){
        return id;
    }

    public int getObjectNum(){ return 0; }

    public void setVelX(int velX){
        this.velX = velX;
    }

    public void setVelY(int velY){
        this.velY = velY;
    }

    public int getVelX(){
        return velX;
    }

    public int getVelY(){
        return velY;
    }


}
