package com.game;

import java.awt.*;
import java.util.Random;

public class Player extends GameObject {
    Random r = new Random();
    Handler handler;

    public Player(int x, int y, ID id, Handler handler){
        super(x, y ,id);
        this.handler = handler;


    }
    public void tick(){
        x += velX;
        y += velY;

        x = Game.clamp( x, Game.WIDTH - 38, 0);
        y = Game.clamp( y , Game.HEIGHT - 61, 20 );

        collision();

    }

    private void collision(){
        for (int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);

            if(tempObject.getId() == ID.Enemy){
                if(getBounds().intersects(tempObject.getBounds())){  //temp object is enemy
                    //collision code
                    HUD.HEALTH -= 2;
                }
            }

        }
    }

    public void render(Graphics g){
        g.setColor(Color.green);
        g.fillRect(x , y, 5, 64);
    }


    public Rectangle getBounds(){
        return new Rectangle(x , y , 32 ,32);
    }
    public void loadImages() {

    }
}
