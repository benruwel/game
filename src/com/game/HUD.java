package com.game;

import java.awt.*;

public class HUD {

    public static int HEALTH = 100;
    private int score = 0;
    private int level = 1;

    public void tick(){

        HEALTH = Game.clamp(HEALTH, 100, 0);

        score ++;
    }

    public void render(Graphics g){
        g.setColor(Color.darkGray);
        g.fillRect(0, 0, 100, 20);
        g.setColor(Color.green);
        g.fillRect(0, 0, HEALTH, 20);
        g.setColor(Color.white);
        g.drawRect(0, 0, 100, 20);

        g.drawString("Score: " + score, 120, 15);
        g.drawString("Level: " + level, 200, 15);

    }

    public void score(int score){
        this.score = score;
    }
    public int getScore(){
        return score;
    }
    public int getLevel(){
        return level;
    }
    public void setLevel(int level){
        this.level = level;
    }
}
