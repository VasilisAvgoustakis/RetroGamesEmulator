package SpaceRace;

import MainMenu.Handler;
import MainMenu.ID;
import MainMenu.Player;

import java.awt.*;

public class SRHUD {



    private int scoreP1 = 0;
    private int scoreP2 = 0;
    private int gameLevel;


    private int timeBarHeight = 240;
    private int timeBarY = 635;
    private int hudTime = 0;

    Handler handler = SpaceRaceGame.getHandler();
    public void tick() {

        gameLevel = SpaceRaceGame.getGameLevel();

        if(hudTime != SpaceRaceGame.getGameTime()) {
            timeBarHeight -= 3;
            timeBarY += 3;
            hudTime++;
            System.out.println(timeBarHeight + "   " + timeBarY);
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
        g.drawString(String.valueOf(scoreP1), 530, 800);
        g.drawString(String.valueOf(scoreP2), 625, 800);
        //level indicator
        Font currentFont2 = g.getFont();
        Font newFont2 = currentFont.deriveFont(currentFont.getSize() * 3.4F);
        g.setFont(newFont2);
        g.drawString(String.valueOf("Level:  " + gameLevel), 15, 30);
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
