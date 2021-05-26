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

public class SRPlayer extends Player implements ActionListener{
    private final File PATH = new File("Images/SpaceRaceIcons/");
    private final BufferedImage SHIP = ImageIO.read(new File(PATH, "space-invaders.png"));

    public SRPlayer(int x, int y, ID id) throws IOException {
        super(x, y, id);
    }


    @Override
    public void render(Graphics g) {
        if(id == ID.SRPlayer) g.setColor(Color.black);
        else if(id == ID.SRPlayer2) g.setColor(Color.blue);
        g.drawImage(SHIP, x, y, 50, 50, Color.white, null);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(y < 100) velY = 0;

    }
}
