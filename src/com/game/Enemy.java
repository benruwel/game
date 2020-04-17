package com.game;

import javax.swing.*;
import java.awt.*;

public class Enemy extends GameObject {

    private int scl = 20;

    public Enemy(int x, int y, ID id){

        super(x, y , id);

        x += velX;
        y +=velY;
    }

    public void tick() {
        x += velX;
        y += velY;

        //if (y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
       // if (x <= 0 || x >= Game.WIDTH - 16) velX *= -1;

        x = Game.clamp( x, Game.WIDTH - 38, 0);
        y = Game.clamp( y , Game.HEIGHT - 61, 20 );
    }

    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x , y, 20, 20);
    }

    public Rectangle getBounds(){
        return new Rectangle(x , y , scl ,scl);
    }

    public void loadImages() {
        ImageIcon iia = new ImageIcon("src/resources/apple.png");
        Image apple = iia.getImage();
    }
}
