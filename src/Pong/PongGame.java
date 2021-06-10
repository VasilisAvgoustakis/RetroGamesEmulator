package Pong;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class PongGame extends Canvas implements Runnable {

    //frame dimensions
    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
    private PongHUD hud;
    private PongSpawn spawn;


    //threat variables
    private Thread thread;
    private boolean running = false;

    //PongHandler variable
    private PongHandler handler;


    //PongGame constructor; creates window and pases in frame details
    public PongGame(){
        handler = new PongHandler();
        this.addKeyListener(new PongKeyInput(handler));

        new PongWindow(WIDTH, HEIGHT, "Welcome to Pong", this);


        hud = new PongHUD(215, 15, 350, 15);
        spawn = new PongSpawn(handler, hud);

            handler.addObject(new PongPlayer(10, 240, PongID.Player));
           // handler.addObject(new PongPlayer(600, 240, PongID.Player2));
            handler.addObject(new PongBall((PongGame.WIDTH/2)-5,(PongGame.HEIGHT/2) -5, PongID.Ball, handler, hud));

            handler.addObject(new PongEnemyAI(600, 240, PongID.EnemyAI, handler));



    }

    //starts and stops the thread
    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running= true;
    }
    public synchronized void stop(){
        try{
            thread.join();
            running = false;
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    //runs a gameloop (showing frames),

    public void run() {
        this.requestFocus();

        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                tick();
                delta--;
            }
            if(running)
                render();
            frames++;
            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }
    private void tick(){
        handler.tick();
        hud.tick();



    }

    //runns the buffer to run lower framenumbers
    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        handler.render(g);
        hud.render(g);


        g.dispose();
        bs.show();
    }

    public static int clamp(int var, int min, int max){
        if(var >= max){
            return var = max;
            }
        else if(var <= min){
            return var = min;
            }
        else{
            return var;
        }
    }

}
