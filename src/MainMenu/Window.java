package MainMenu;
import javax.swing.*;
import java.awt.*;
import java.io.Serial;

/** The purpose if this class is to create the window for our game. A new Window object is
 * instantiated within the constructor of the the Game class. Window class extends the java.awt.Canvas class.
 * */

public class Window extends Canvas{

    /*Java provides a mechanism, called object serialization where an object can be represented
    as a sequence of bytes that includes the object's data as well as information about the
    object's type and the types of data stored in the object.´
    After a serialized object has been written into a file, it can be read from the file and
    deserialized that is, the type information and bytes that represent the object and its data can be
    used to recreate the object in memory.
    During serialization, java runtime associates a version number with each serializable class.
    This number called serialVersionUID, which is used during deserialization to verify that the
    sender and receiver of a serialized object have loaded classes for that object that are compatible
    with respect to serialization.
     */
    @Serial
    private static final long serialVersionUID = 1637928755853267139L;

    /**Constructor of Class Window*/
    public Window(int width, int height, String title, Game game){
        //An extended version of java.awt.Frame that adds support for the JFC/Swing component architecture.
        JFrame frame = new JFrame(title);
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));

        //Makes the close windows button to work by stopping the game from running.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Makes the window not resizable
        frame.setResizable(false);
        //Makes window spawn in screen middle
        frame.setLocationRelativeTo(null);
        //adds a class of type Game, given in the constructors parameters to the window
        frame.add(game);
        //makes the window visible
        frame.setVisible(true);
        //starts the game by using the start method defined in class Game
        game.start();
    }

}
