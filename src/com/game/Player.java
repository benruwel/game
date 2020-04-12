package com.game;

import java.awt.*;
import java.util.Random;

public class Player extends GameObject {
    Random r = new Random();

    public Player(int x, int y, ID id){
        super(x, y ,id);


    }
    public void tick(){
        x += velX;
        y += velY;

        x = Game.clamp( x, Game.WIDTH - 38, 0);
        y = Game.clamp( y , Game.HEIGHT - 61, 20 );

    }
    public void render(Graphics g){
        g.setColor(Color.green);
        g.fillRect(x , y, 32, 32);
    }


    public void loadImages() {

    }
}
