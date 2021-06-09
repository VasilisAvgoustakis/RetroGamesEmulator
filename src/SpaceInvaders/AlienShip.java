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
    int moveCounter = 0;
    boolean bounce;
    private int originalX;
    private static int shipTotal = 1;
    private int shipNum = 1;
    //TODO find the formula to assign the right column number to every ship object
    private int columnNum;


    public AlienShip(int x, int y, ID id, int column) throws IOException {
        super(x, y, id);
        originalX = x;
        columnNum = column;
        shipNum = shipTotal;
        System.out.println("Column: " + columnNum + " ship: " + shipNum);
        shipTotal++;

    }

    @Override
    public void tick() {
        int randomMoveFactor = (int) (Math.random() * 2 + 1);
        moveCounter++;
        if(moveCounter % 10 == 0 && !bounce) {
            x += 4 + randomMoveFactor;
            if(x >= (((SpaceInvadersGame.WIDTH - 50)- ((SpaceInvadersGame.getAlienArmyColumns()
                    - columnNum) * 50)))){
                y += 60;
                bounce = true;
            }
        }

        if(moveCounter % 10 == 0 && bounce) {
            x -= 4 - randomMoveFactor;
            if (x <= ((columnNum - 1) * 50)){
                y += 60;
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
            if(Math.abs(x) % 2 == 0)g.drawImage(SHIP2_OPEN, x, y, 30, 30, null);
            else g.drawImage(SHIP2_CLOSED, x, y, 30, 30, null);

        }
        if(id == ID.AlienShip3) {
            if(Math.abs(x) % 2 == 0) g.drawImage(SHIP3_OPEN, x, y, 30, 30, null);
            else g.drawImage(SHIP3_CLOSED, x, y, 30, 30, null);
        }
        if(id == ID.AlienUfo) {
            g.drawImage(UFO, x, y, 30, 30, null);
        }
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 30, 30);
    }

    @Override
    public void hide() {

    }

    public int getShipNum(){ return shipNum;}
}