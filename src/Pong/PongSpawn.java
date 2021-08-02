package Pong;

import java.util.Random;

public class PongSpawn {

    private PongHandler handler;
    private PongHUD hud;
    private Random r = new Random();



    public PongSpawn(PongHandler handler, PongHUD hud){
        this.handler = handler;
        this.hud = hud;


    }

    public void tick(){



        handler.addObject(new PongBall(r.nextInt(550)+1,r.nextInt(450)+1, PongID.Ball, handler));

    }


}
