package MainMenu;

import java.awt.*;
import java.util.LinkedList;

/** Maintains, renders and updates all objects in our game
 * loops through all objects in our game and individually updates and renders
 * them on screen*/
public class Handler {
    //List will contain all game objects in existence
    //Cause we dont know how many they are going to be we choose LinkedList
    LinkedList<GameObject> object = new LinkedList<GameObject>();

    public void tick(){
        for(int i = 0; i < object.size(); i++){
            GameObject tempObject = object.get(i);
            tempObject.tick();
        }
    }

    public void render(Graphics g){
        for(int i = 0; i < object.size(); i++){
            GameObject tempObject = object.get(i);
            tempObject.render(g);
        }
    }

    public void addObject(GameObject object){
        this.object.add(object);
    }

    public void removeObject(GameObject object){
        this.object.remove(object);
    }
}
