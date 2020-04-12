package com.game;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {
    private static final long serialVersionUID = 2748474426917688944L;
    private Thread thread;
    private boolean running = false;
    private Random r;
    private HUD hud;

    private Handler handler;

    public static final int WIDTH = 640, HEIGHT = WIDTH/12*9;

    public Game(){

        handler = new Handler();

        this.addKeyListener(new KeyInput(handler));

        new Window(WIDTH, HEIGHT, "Master Game!", this);

        r = new Random();
        hud = new HUD();

        for (int i = 0; i < 1; i++){

            handler.addObject(new Enemy( r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.Enemy));

        }
        handler.addObject(new Player( 100, 100, ID.Player));

    }

    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }
    public synchronized void stop(){
        try{
            thread.join();
            running = false;
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void run(){

            this.requestFocus();

            long lastTime = System.nanoTime(); // get current time to the nanosecond
            double amountOfTicks = 60.0; // set the number of ticks
            double ns = 1000000000 / amountOfTicks; // this determines how many times we can divide 60 into 1e9 of nano seconds or about 1 second
            double delta = 0; // change in time
            long timer = System.currentTimeMillis(); // get current time
            int frames = 0; // set frame variable
            while(running){
                long now = System.nanoTime(); // get current time in nanoseconds during current loop
                delta += (now - lastTime) / ns; // add the amount of change since the last loop
                lastTime = now;  // set lastTime to 'now' to prepare for next loop
                while(delta >= 1){
                    // one tick of time has passed in the game this
                    //ensures that we have a steady pause in our game loop
                    //so we don't have a game which runs way too fast
                    //basically we are waiting for enough time to pass so we
                    // have about 60 frames per one second interval determined to the nanosecond (accuracy)
                    // after this pause we render the next frame
                    tick();
                    delta--;  // lower our delta back to 0 to start our next frame wait
                }
                if(running){
                    render(); // render the visuals of the game
                }
                frames++; // note that a frame has passed
                if(System.currentTimeMillis() - timer > 1000 ){ // if one second has passed
                    timer+= 1000; // add a thousand to our timer for next time
                    //System.out.println("FPS: " + frames); // print out how many frames have happened in the last second
                    frames = 0; // reset the frame count for the next second
                }
            }
            stop(); // no longer running stop the thread
        }
    private void tick(){

        handler.tick();
        hud.tick();
        }
     private void render(){
            BufferStrategy bs = this.getBufferStrategy();
            if (bs == null){
                this.createBufferStrategy(3);
                return;
            }
            Graphics g = bs.getDrawGraphics();

            g.setColor(Color.BLACK);
            g.fillRect(0, 0, WIDTH, HEIGHT);


            handler.render(g);
            hud.render(g);
            g.dispose();
            bs.show();
        }


        public static int clamp(int val, int max, int min){
            if(val >= max)
                return val = max;
            else return Math.max(val, min);
        }

    public static void main(String[]args){
        new Game();
    }
}

