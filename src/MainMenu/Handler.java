package MainMenu;

import java.awt.*;
import java.util.LinkedList;

/** Maintains, renders and updates all objects in our game
 * loops through all objects in our game and individually updates and renders
 * them on screen*/
public class Handler {
    //List will contain all game objects in existence
    //Cause we dont know how many they are going to be we choose LinkedList
    public LinkedList<GameObject> objects = new LinkedList<GameObject>();
    public LinkedList<Player> players = new LinkedList<Player>();

    public void tick(){
        for(int i = 0; i < objects.size(); i++){
            GameObject tempObject = objects.get(i);
            tempObject.tick();
        }

        for(int i = 0; i < players.size(); i++){
            Player tempPlayer = players.get(i);
            tempPlayer.tick();
        }
    }

    public void render(Graphics g){
        for(int i = 0; i < objects.size(); i++){
            GameObject tempObject = objects.get(i);
            tempObject.render(g);
        }

        for(int i = 0; i < players.size(); i++){
            Player tempPlayer = players.get(i);
            tempPlayer.render(g);
        }
    }

    public void addObject(GameObject object){
        this.objects.add(object);
    }
    public void addPlayer(Player player){
        this.players.add(player);
    }


    public void removeObject(GameObject object){
        this.objects.remove(object);
    }
    public void removePlayer(Player player){
        this.players.remove(player);
    }
}
