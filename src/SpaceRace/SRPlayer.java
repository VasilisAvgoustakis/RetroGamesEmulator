package SpaceRace;

import MainMenu.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SRPlayer extends Player {
    private final File PATH = new File("Images/SpaceRaceIcons/");
    private final BufferedImage SHIP = ImageIO.read(new File(PATH, "spaceship.png"));
    private int gameLevel = SpaceRaceGame.getGameLevel();



    public SRPlayer(int x, int y, ID id, Handler handler) throws IOException {
        super(x, y, id, handler);
        this.handler = handler;
    }


    @Override
    public void render(Graphics g) {
        //scaffolding code lets the bounds of the player appear
        //Graphics2D g2d = (Graphics2D) g;
        //g.setColor(Color.red);
        //g2d.draw(getBounds());
        g.drawImage(SHIP, x, y, 50, 50, null);
    }

    //originaly defined in PongGameObject Class as an abstract method. Here it is used
    //to move the PongPlayer Object by adding to objects x and y vars
    @Override
    public void tick() {
        x += velX;
        y += velY;

        y = Game.clamp(y, 0, Game.HEIGHT - 75);
        collision();
        if(y == 0){
            y = 775;
            playerScore++;
            SpaceRaceGame.setGameLevel(playerScore + 1);
        }

        if(SRHUD.getTimeBarHeight() < (int)(SpaceRaceGame.WIDTH / 12 * 0.24)) {
            y = Game.clamp(y, 775, 775);
        }

    }

    @Override
    public Rectangle getBounds(){
        return new Rectangle(x, y, 50, 50 );
    }


    public void collision(){
        for(int i = 0; i < handler.objects.size(); i++){
            GameObject tmpObject = handler.objects.get(i);

            if(tmpObject.getID() == ID.SRDebris){
                if(getBounds().intersects(tmpObject.getBounds())){
                    //collision code: what happens when collision occurs
                  
                    y = 775;

                    //play collision sound
                    AudioPlayer.getSound("collision").play();
                }
            }

        }
    }

}
