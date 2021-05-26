package MainMenu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Player extends GameObject implements ActionListener {

    public Player(int x, int y, ID id) {
        super(x, y, id);
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;
    }

    @Override
    public void render(Graphics g) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(y < 100) velY = 0;
    }
}
