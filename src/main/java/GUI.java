package main.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class GUI extends JFrame {

    Timer timer;

    int size = 30;

    private Field boardOfField[][];

    private MyCanvas canvas = new MyCanvas();


    public GUI() { //public GUI(Field boardOfField)
        timer.start();
        timer.setDelay(50);
        timer.addActionListener(e -> timerAction(e));

        boardOfField = boardOfField;
        setLayout(new BorderLayout());
        setTitle("Helenčin Tetris");
        setSize(302, 638);
        setVisible(true);
        add("Center", canvas);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // boardOfField[2][3].

    }

    private class MyCanvas extends Canvas {

        public void paint(Graphics graphics) { //GB
            int i, j;
            for (i = 0; i < 10; i++) {
                for (j = 0; j < 20; j++) {

                    graphics.drawRect(i * size, j * size, size, size);
                    graphics.setColor(Color.blue);
                    graphics.fillRect(i * size, j * size, size - 1, size - 1);
                }
            }
        }
    }

    private void timerAction(ActionEvent e) {
        Tetromino.move();
    }


}
