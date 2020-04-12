package com.game;

import java.awt.*;

public class HUD {

    public static int HEALTH = 100;

    public void tick(){

    }
    public void render(Graphics g){
        g.setColor(Color.darkGray);
        g.fillRect(0, 0, 100, 20);
        g.setColor(Color.gray);
        g.drawRect(0, 0, 100, 20);



    }
}
