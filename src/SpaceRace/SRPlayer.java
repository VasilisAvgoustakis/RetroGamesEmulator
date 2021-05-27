package SpaceRace;

import MainMenu.ID;
import MainMenu.Player;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SRPlayer extends Player {
    private final File PATH = new File("Images/SpaceRaceIcons/");
    private final BufferedImage SHIP = ImageIO.read(new File(PATH, "spaceship.png"));

    public SRPlayer(int x, int y, ID id) throws IOException {
        super(x, y, id);
    }


    @Override
    public void render(Graphics g) {
        if(id == ID.SRPlayer) g.setColor(Color.black);
        else if(id == ID.SRPlayer2) g.setColor(Color.blue);
        g.drawImage(SHIP, x, y, 50, 50, Color.white, null);
    }

    //originaly defined in GameObject Class as an abstract method. Here it is used
    //to move the Player Object by adding to objects x and y vars
    @Override
    public void tick() {
        if(x < 1200) x += velX;
        if(y > 4 && y < 776) y += velY;
        else if(y == 0) y = 5;
        else if(y > 775) y = 775;
    }



}
