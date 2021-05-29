package MainMenu;

import java.util.concurrent.TimeUnit;

public class Timer extends Thread {

    private int countdownSec = 0;

    public Timer(int seconds){
        this.countdownSec = seconds;
        try{
            TimeUnit.MILLISECONDS.sleep(1000);
            countdownSec--;
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }


    public int getCountdownSec(){
        return countdownSec;
    }
}
