package Pong;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {

    //frame dimensions
    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
    private NetLine netLine;
    private HUD hudPlayerOne;
    private HUD hudPlayerTwo;

    //threat variables
    private Thread thread;
    private boolean running = false;

    //Handler variable
    private Handler handler;

    //random instance
    private Random r;


    //Game constructor; creates window and pases in frame details
    public Game(){
        handler = new Handler();
        this.addKeyListener(new KeyInput(handler));

        new Window(WIDTH, HEIGHT, "Welcome to Pong", this);
        netLine = new NetLine();
        hudPlayerOne = new HUD(215, 15);
        hudPlayerTwo = new HUD(350, 15);


        r = new Random();

            handler.addObject(new Player(10, 240, ID.Player));
            handler.addObject(new Player(600, 240, ID.Player2));
            handler.addObject(new Ball(r.nextInt(550),r.nextInt(450), ID.Ball, handler));



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
    @Override
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
                //System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }
    private void tick(){
        handler.tick();
        netLine.tick();
        hudPlayerOne.tick();
        hudPlayerTwo.tick();

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
        netLine.render(g);
        hudPlayerOne.render(g);
        hudPlayerTwo.render(g);

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
