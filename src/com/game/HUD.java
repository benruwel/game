package com.game;

import java.awt.*;

public class HUD {

    public static int HEALTH = 100;

    public void tick(){


        HEALTH = Game.clamp(HEALTH, 100, 0);
    }
    public void render(Graphics g){
        g.setColor(Color.darkGray);
        g.fillRect(0, 0, 100, 20);
        g.setColor(Color.green);
        g.fillRect(0, 0, HEALTH, 20);
        g.setColor(Color.white);
        g.drawRect(0, 0, 100, 20);



    }
}
