package SpaceInvaders;

import MainMenu.*;

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
    int moveCounterX = 0;
    int moveCounterY = 0;

    public AlienShip(int x, int y, ID id) throws IOException {
        super(x, y, id);
    }

    @Override
    public void tick() {
        moveCounterY++;
        moveCounterX++;
        System.out.println(moveCounterY);
        //if(moveCounterY / 10 == 0)
        y += 5;
        //if(moveCounterX / 5 == 0)y += 5;

    }

    @Override
    public void render(Graphics g) {
        //scaffolding code lets the bounds of the object appear
        //Graphics2D g2d = (Graphics2D) g;
        //g.setColor(Color.red);
        //g2d.draw(getBounds());

        //g.setColor(Color.white);

        if(id == ID.AlienShip2) {
            g.drawImage(SHIP2_OPEN, x, y, 50, 50, null);
        }
        if(id == ID.AlienShip3) {
            g.drawImage(SHIP3_OPEN, x, y, 50, 50, null);
        }
        if(id == ID.AlienUfo) {
            g.drawImage(UFO, x, y, 50, 50, null);
        }
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 50, 50);
    }

    @Override
    public void hide() {

    }
}