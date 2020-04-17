package com.game;

import java.awt.*;
import java.util.Random;

public class Player extends GameObject {
    private Handler handler;
    Random r = new Random();
    private int total = 1;
    private int[] tail = {};


    public Player(int x, int y, ID id, Handler handler){
        super(x, y ,id);
        this.handler = handler;


    }
    public void tick() {

        for (int i = 0; i < total - 1; i++ ){
            this.tail[i] = tail[ i + 1];
        }
           // this.tail[i] = handler.render(g);

        x += velX;
        y += velY;


        x = Game.clamp(x, Game.WIDTH - 38, 0);
        y = Game.clamp(y, Game.HEIGHT - 61, 20);

        // handler.addObject(new Trail(x , y , ID.Trail, (float) 0.1, handler ));

        collision();

    }

    private void collision(){
        for (int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);

            if(tempObject.getId() == ID.Enemy){
                if(getBounds().intersects(tempObject.getBounds())){  //temp object is enemy
                    //collision code
                    HUD.HEALTH -= 2;
                    handler.removeObject(tempObject);
                    this.total = total++;

                }
            }



        }
    }



    public void render(Graphics g){

        for (int i = 0; i < total; i++){
            g.setColor(Color.green);
            g.fillRect(this.tail[i] , this.tail[i], 20, 20);
        }

        g.setColor(Color.green);
        g.fillRect(x , y, 20, 20);
    }


    public Rectangle getBounds(){
        return new Rectangle(x , y , 20 ,20);
    }
    public void loadImages() {

    }
}
