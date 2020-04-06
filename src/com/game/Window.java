package com.game;

import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Dimension;

public class Window {

    private static final long serialVersionUID = 2291740145987424884L;

    public Window(int width, int height, String title, Game game) {

        JFrame frame = new JFrame(title);

        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.add(game);
        game.start();
    }
}
