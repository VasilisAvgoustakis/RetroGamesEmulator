package Pong;

import java.awt.*;
import java.util.LinkedList;


//A class to "handle" all the objects in a <linked list> to set and remove Objects
public class PongHandler {

    LinkedList<PongGameObject> object = new LinkedList<>();

    public void tick(){
        for(int i = 0; i < object.size(); i++){
            PongGameObject tempObject = object.get(i);

            tempObject.tick();
        }
    }
    public void render(Graphics g){
        for (int i = 0; i < object.size(); i++) {
            PongGameObject tempObject = object.get(i);

            tempObject.render(g);
        }
    }
    public void addObject(PongGameObject object){
        this.object.add(object);
    }
    public void removeObject(PongGameObject object){
        this.object.remove(object);
    }
}
