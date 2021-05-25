package MainMenu;
import javax.swing.*;
import java.awt.*;
import java.io.Serial;
import java.io.Serializable;

/** The purpose if this class is to create the window for our game*/

public class Window extends Canvas{

    @Serial
    private static final long serialVersionUID = 1637928755853267139L;

    public Window(int width, int height, String title, Game game){
        JFrame frame = new JFrame(title);

        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));

        //makes the close windows button to work by stoping the game from running
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        //makes windows spawn in screen middle
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
        game.start();
    }

}
