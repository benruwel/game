package com.game;

import java.awt.*;
import java.awt.Graphics2D;

public class Trail extends GameObject {

    private float alpha = 1;
    private Handler handler;
    private float life;
    //life = 0.001 - 0.1

    public Trail(int x , int y, ID id, float life, Handler handler){
        super(x , y , id);

        this.life = life;
        this.handler = handler;

    }
    public void tick(){
        if (alpha > life){
            alpha -= life - 0.001;
        }else handler.removeObject(this);

    }
    public void render(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(makeTransparent(alpha));

        g.setColor(Color.green);
        g.fillRect(x , y , 25, 25);

        g2d.setComposite(makeTransparent(1));

    }
    //this method renders the trail's transparency.
    private AlphaComposite makeTransparent(float alpha){
        int type = AlphaComposite.SRC_OVER;
        return (AlphaComposite.getInstance(type, alpha));
    }

    public Rectangle getBounds(){
        return null;
    }


    public void loadImages() {

    }
}
