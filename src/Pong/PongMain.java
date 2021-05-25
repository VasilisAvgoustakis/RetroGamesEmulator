package Pong;

import java.awt.*;

/** The main class for the game Pong*/

public class PongMain extends Canvas implements Runnable {

    private static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
    private Thread thread;
    private boolean running = false;

    public PongMain(){
        new Window(WIDTH, HEIGHT, "Welcome to Pong", this);
    }

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


    public void run() {

    }

    public static void main(String[] args){
        new PongMain();

           }
}
