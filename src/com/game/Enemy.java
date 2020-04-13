package com.game;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Enemy extends GameObject {

    public Enemy(int x, int y, ID id){

        super(x, y , id);

        velX = 5;
        velY = 5;
    }

    public void tick() {
        x += velX;
        y += velY;

        if (y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
        if (x <= 0 || x >= Game.WIDTH - 16) velX *= -1;
    }

    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x , y, 8, 8);
    }

    public Rectangle getBounds(){
        return new Rectangle(x , y , 8 ,8);
    }

    public void loadImages() {
        ImageIcon iia = new ImageIcon("src/resources/apple.png");
        Image apple = iia.getImage();
    }
}
