package SpaceRace;

import MainMenu.Handler;
import MainMenu.ID;
import MainMenu.Player;

import java.awt.*;

public class SRHUD {

    private int scoreP1 = 0;
    private int scoreP2 = 0;
    private int gameLevel;


    private static int timeBarHeight = 240;
    private int timeBarY = SpaceRaceGame.HEIGHT - timeBarHeight;
    private int hudTime = 0;

    Handler handler = SpaceRaceGame.getHandler();
    public void tick() {

        gameLevel = SpaceRaceGame.getGameLevel();

        if(hudTime != SpaceRaceGame.getGameTime()) {
            timeBarHeight -= 3;
            timeBarY += 3 ;
            hudTime++;
            //System.out.println(timeBarHeight + "   " + timeBarY);
        }

        for(int i = 0; i < handler.players.size();i++) {
            Player tmpPlayer = handler.players.get(i);

            if(tmpPlayer.getID() == ID.SRPlayer){
                scoreP1 = tmpPlayer.getPlayerScore();
            }

            if(tmpPlayer.getID() == ID.SRPlayer2){
                scoreP2 = tmpPlayer.getPlayerScore();
            }
        };
    }

    public void render(Graphics g){
        //time bar
        g.setColor(Color.white);
        g.fillRect(600, timeBarY, 15, timeBarHeight);

        //score indicators
        Font currentFont = g.getFont();
        Font newFont = currentFont.deriveFont(currentFont.getSize() * 5.4F);
        g.setFont(newFont);
        printResultString(g, String.valueOf(scoreP1), 100,
                             SpaceRaceGame.WIDTH / 12 * 5,
                             (int)(SpaceRaceGame.WIDTH / 12 * 7.5));
        printResultString(g, String.valueOf(scoreP2), 100,
                            (int)(SpaceRaceGame.WIDTH / 12 * 6.1),
                            (int)(SpaceRaceGame.WIDTH / 12 * 7.5));
        //level indicator
        Font currentFont2 = g.getFont();
        Font newFont2 = currentFont.deriveFont(currentFont.getSize() * 3.4F);
        g.setFont(newFont2);
        g.drawString(String.valueOf("Level:  " + gameLevel), (int)(SpaceRaceGame.WIDTH / 12 * 0.15),
                                    (int)(SpaceRaceGame.WIDTH / 12 * 0.4));

        //announce result when time runs out
        if(timeBarHeight < (int)(SpaceRaceGame.WIDTH / 12 * 0.24)){

            //stop ambient music
            AudioPlayer.getMusic("ambient").stop();
            //play victory theme
            //TODO fix victory music
            AudioPlayer.getSound("victory").play();

            Font currentFont3 = g.getFont();
            Font newFont3 = currentFont.deriveFont(currentFont.getSize() * 7.4F);
            g.setFont(newFont3);
            if(scoreP1 > scoreP2) {
                printResultString(g, "PongPlayer 1 won this Game!", 800, 200, 400);
            }
            else if(scoreP2 > scoreP1){
                printResultString(g, "PongPlayer 2 won this Game!", 800, 200, 400);
            }
            else printResultString(g, "That's a draw!", 800, 200, 400);;
        }
    }

    //The following code segment will center a String by passing the startin x,y and the available width.
    private void printResultString(Graphics g, String s, int width, int XPos, int YPos) {
        Graphics2D g2d = (Graphics2D) g;
        int stringLen = (int) g2d.getFontMetrics().getStringBounds(s, g2d).getWidth();
        int start = width / 2 - stringLen / 2;
        g2d.drawString(s, start + XPos, YPos);
    }

    public int getScoreP1(){
        return scoreP1;
    }

    public int getScoreP2(){
        return scoreP2;
    }

    public int getLevel(){
        return gameLevel;
    }

    public static int getTimeBarHeight(){
        return timeBarHeight;
    }

    public void setScoreP1(int value){
        this.scoreP1 = value;
    }

    public void setScoreP2(int value){
        this.scoreP2 = value;
    }

    public void setLevel(int value){
        this.gameLevel = value;
    }


}
