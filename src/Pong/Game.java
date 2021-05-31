package Pong;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {

    //frame dimensions
    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
    private HUD hud;
    private Spawn spawn;

    //threat variables
    private Thread thread;
    private boolean running = false;

    //Handler variable
    private Handler handler;


    //Game constructor; creates window and pases in frame details
    public Game(){
        handler = new Handler();
        this.addKeyListener(new KeyInput(handler));

        new Window(WIDTH, HEIGHT, "Welcome to Pong", this);


        hud = new HUD(215, 15, 350, 15);
        spawn = new Spawn(handler, hud);

            handler.addObject(new Player(10, 240, ID.Player));
//            handler.addObject(new Player(600, 240, ID.Player2));

            handler.addObject(new Ball((Game.WIDTH/2)-5,(Game.HEIGHT/2) -5, ID.Ball, handler, hud));
            handler.addObject(new EnemyAI(600, 240, ID.EnemyAI, handler));


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
