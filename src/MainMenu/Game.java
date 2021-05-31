package MainMenu;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.io.Serial;
/** The class Game extends java.awt.Canvas and implements the Runnable interface.
 *  This interface is designed to provide a common protocol for objects that wish to execute code
 *  while they are active.
 *  Class Game was made with the thought of using it as a parent Class of the dedicated Game Classes
 *  for each of the other games in the emulator.
 * */
public class Game extends Canvas implements Runnable {

    @Serial
    private static final long serialVersionUID = -5430275344184810031L;



    public static final int WIDTH = 1200, HEIGHT = WIDTH / 12 * 9;
    /*A thread is a thread of execution in a program. The Java Virtual Machine allows an
    application to have multiple threads of execution running concurrently.*/
    private Thread thread;
    private static boolean running = false;
    //declare Handler
    public static Handler handler;
    public static int gameLevel = 1;
    public static int gameTime = 0;

    /**Constructor of Class Game*/
    public Game(String gameTitle){
        //initiate handler
        handler = new Handler();
        //adds a KeyListener to the class. Class listens for pressed keys.
        this.addKeyListener(new KeyInput(handler));
        //instantiate a new Window
        new Window(WIDTH, HEIGHT, gameTitle, this);
    }

    /**Stops objects from going off screen*/
    public static int clamp(int var, int min, int max){
        if(var >= max) return var = max;
        else if(var <= min) return var = min;
        else
            return var;
    }

    /**Starts the Game.
     * Making these methods synchronized has two effects:
     * First, it is not possible for two invocations of synchronized methods on the same object to interleave.
     * When one thread is executing a synchronized method for an object, all other threads that invoke
     * synchronized methods for the same object block (suspend execution).
     * Second, when a synchronized method exits, it automatically establishes a happens-before relationship
     * with any subsequent invocation of a synchronized method for the same object.
     * This guarantees that changes to the state of the object are visible to all threads.
     */
    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    /**Stops the Game.
     * Making these methods synchronized has two effects:
     * First, it is not possible for two invocations of synchronized methods on the same object to interleave.
     * When one thread is executing a synchronized method for an object, all other threads that invoke
     * synchronized methods for the same object block (suspend execution).
     * Second, when a synchronized method exits, it automatically establishes a happens-before relationship
     * with any subsequent invocation of a synchronized method for the same object.
     * This guarantees that changes to the state of the object are visible to all threads.
     */
    public synchronized void stop(){
        try{
            /*When we invoke the join() method on a thread, the calling thread goes into a waiting state.
            It remains in a waiting state until the referenced thread terminates.*/
            thread.join();
            running = false;
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    /**Is the beating heart of the game. Sets time and rhythm for renewing frame and objects.*/
    public void run(){
        //automatically gives controls to the game window so that you dont have to click on it
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
            //System.out.println(delta);
            lastTime = now;
            while(delta >= 1){
                tick();
                delta--;
            }
            if(running) {
                try {
                    render();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            frames++;

            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                //System.out.println("FPS:   " + frames);
                frames = 0;
            }
        }
        stop();
    }

    protected void tick() {
        handler.tick();
    }

    protected void render() throws InterruptedException {
        //The BufferStrategy class represents the mechanism with which
        //to organize complex memory on a particular Canvas or Window.
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }

        //Creates a graphics context for the drawing buffer.
        Graphics g = bs.getDrawGraphics();
        //sets the game background color
        g.setColor(Color.black);
        //fills a rectangle the size of the game window with the color set above
        g.fillRect(0, 0, WIDTH, HEIGHT);
        //Calls the corresponding render method. To draw objects on screen.
        // From here -> handler -> GameObject -> to actual gameObject
        // that extends GameObject Class
        handler.render(g);
        //Disposes of this graphics context and releases any system resources that it is using.
        g.dispose();
        //Makes the next available buffer visible by either copying the memory (blitting)
        // or changing the display pointer (flipping).
        bs.show();
    }


    public static int getGameLevel(){
        return gameLevel;
    }

    public static int getGameTime(){
        return gameTime;
    }

    public static boolean getRunningStatus(){return running;}

    public static void setGameLevel(int level){
        gameLevel = level;
    }

    public static void setGameTime(int seconds){
        gameTime = seconds;
    }

    public static void setRunningStatus(boolean value){ running = value;}


    //public static void main(String[] args) throws IOException {
        //new Game("Test Game");
    //}
}
