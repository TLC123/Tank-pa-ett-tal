package model;

import org.springframework.beans.factory.annotation.Value;

public class Game {
    //@Value("minsta")
    private int minsta=0                    ;

    //@Value("mesta")
    private int mesta=100;

    private int gissning;

    private int gissningar=0;

    private int highscore=Integer.MAX_VALUE;


    public int resetGame() {
        minsta = 0;
        mesta = 100;
        gissningar=0;

        return 0;
    }

    ;

    public int resetHigScore() {
        highscore = 9999;
        return 0;
    }

    ;

    public int setHighScore(int v) {
        highscore = v;
        return 0;
    }

    ;

    public int getHighScore() {
        return highscore;
    }

    ;

    public int getGissningar() {
        return gissningar;
    }

    public int getGissning() {        return gissning;    }
    public int setGissning(int g) {
        gissning=g;
        return 0;
    }
    public int getMinsta() {
        return minsta;
    }
    public int setMinsta(int g) {
        minsta=g;
        return 0;
    }
    public int getMesta() {
        return mesta;
    }

    public void setMesta(int g) {
        mesta=g;

    }
    public void incGissningar( ) {
        gissningar+=1;

    }

    public void newHigscore()
    {

        if(gissningar<highscore)highscore=gissningar;
    }



}

