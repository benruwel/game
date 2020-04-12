package com.game;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Enemy extends GameObject {

    public Enemy(int x, int y, ID id){
        super(x, y , id);
    }

    public void tick() {

    }

    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x , y, 16, 16);
    }

    public void loadImages() {
        ImageIcon iia = new ImageIcon("src/resources/apple.png");
        Image apple = iia.getImage();
    }
}
