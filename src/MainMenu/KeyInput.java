package MainMenu;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    protected Handler handler;

    public KeyInput(Handler handler){
        this.handler = handler;
    }
    @Override
    public void keyPressed(KeyEvent e){
    }
    @Override
    public void keyReleased(KeyEvent e) {
    }
}
