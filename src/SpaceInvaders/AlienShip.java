package SpaceInvaders;

import MainMenu.*;
import SpaceRace.SpaceRaceGame;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class AlienShip extends GameObject {


    private final File PATH = new File("Images/SpaceInvadersIcons");

    private final BufferedImage SHIP2_OPEN = ImageIO.read(new File(PATH, "alienShip2open.png"));
    private final BufferedImage SHIP2_CLOSED = ImageIO.read(new File(PATH, "alienShip2closed.png"));
    private final BufferedImage SHIP3_OPEN = ImageIO.read(new File(PATH, "alienShip3open.png"));
    private final BufferedImage SHIP3_CLOSED = ImageIO.read(new File(PATH, "alienShip3closed.png"));
    private final BufferedImage UFO = ImageIO.read(new File(PATH, "ufo.png"));
    //private final Toolkit toolkit = Toolkit.getDefaultToolkit();
    private final BufferedImage explosion = ImageIO.read(new File (PATH, "/alienexplosion.gif"));
    int moveCounter = 0;
    boolean bounce;
    boolean explode = false;
    private int originalX;
    private static int shipTotal = 1;
    private int shipNum = 1;
    private int rowNum, columnNum, pixelsToMove;
    private int rowModifier = 1;
    private int movingSpeed = 20;


    public AlienShip(int x, int y, ID id, int row, int column) throws IOException {
        super(x, y, id);
        originalX = x;
        rowNum = row;
        columnNum = column;
        shipNum = shipTotal;
        //System.out.println("Column: " + columnNum + " ship: " + shipNum);
        shipTotal++;

    }

    @Override
    public void tick() {
        collision();

        int randomMoveFactor = (int) (Math.random() * 2 + 1);
        moveCounter++;

        //moving to the right
        if(moveCounter % 10 == 0 && !bounce) {
            //alternating the speed for the whole row
            if((rowNum + rowModifier) % 2 == 0){
                pixelsToMove = 4; //+ randomMoveFactor;
                rowModifier -= 1;
            }else {
                pixelsToMove = 2;// + randomMoveFactor;
                rowModifier += 1;
            }
            x += pixelsToMove;
            if(x >= (((SpaceInvadersGame.WIDTH - 50)- ((SpaceInvadersGame.getAlienArmyColumns()
                    - columnNum) * 50)))){
                y += 60;
                movingSpeed -= 2;
                bounce = true;
            }
        }
        //moving to the left
        if(moveCounter % 10 == 0 && bounce) {
            //alternating the speed for the whole row
            if((rowNum + rowModifier) % 2 == 0){
                pixelsToMove = 4; // + randomMoveFactor;
                rowModifier -= 1;
            }else {
                pixelsToMove = 2; // + randomMoveFactor;
                rowModifier += 1;
            }
            x -= pixelsToMove;
            if (x <= ((columnNum - 1) * 50)){
                y += 60;
                movingSpeed -= 2;
                bounce = false;
            }
        }

    }

    @Override
    public void render(Graphics g) {
        //scaffolding code lets the bounds of the object appear
        //Graphics2D g2d = (Graphics2D) g;
        //g.setColor(Color.red);
        //g2d.draw(getBounds());

        //g.setColor(Color.white);


        if(id == ID.AlienShip2) {
            if((rowNum + rowModifier) % 2 == 0)g.drawImage(SHIP2_OPEN, x, y, 30, 30, null);
            else g.drawImage(SHIP2_CLOSED, x, y, 30, 30, null);

        }
        if(id == ID.AlienShip3) {
            if((rowNum + rowModifier) % 2 == 0) g.drawImage(SHIP3_OPEN, x, y, 30, 30, null);
            else g.drawImage(SHIP3_CLOSED, x, y, 30, 30, null);
        }
        if(id == ID.AlienUfo) {
            g.drawImage(UFO, x, y, 30, 30, null);
        }

        if(explode){
            System.out.println("BOOM");
            g.drawImage(explosion, 40, 40 , null);
            SpaceInvadersGame.handler.objects.remove(this);
        }

    }

    public void collision(){

    }


    @Override
    public void destroyObject(int shipNum) {
        //remove Projectile from list
        for(int i = 0; i < SpaceInvadersGame.handler.objects.size(); i++) {
            //System.out.println("removed");
            GameObject tempObject = SpaceInvadersGame.handler.objects.get(i);
            if (tempObject.getObjectNum() == shipNum) {
                explode = true;
                //System.out.println("removed");
                //SpaceInvadersGame.handler.objects.remove(tempObject);
            }
        }
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 30, 30);
    }

    @Override
    public void hide() {

    }

    public int getObjectNum(){ return shipNum;}
}