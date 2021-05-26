package Pong;

import java.util.Random;

public class Spawn {

    private Handler handler;
    private HUD hud;
    private Random r = new Random();



    public Spawn(Handler handler, HUD hud){
        this.handler = handler;
        this.hud = hud;


    }

    public void tick(){



        handler.addObject(new Ball(r.nextInt(550)+1,r.nextInt(450)+1, ID.Ball, handler));

    }


}
