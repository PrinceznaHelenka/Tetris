package main.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class GUI extends JFrame {
    int size = 30;

    private Field boardOfField[][];

    private MyCanvas canvas = new MyCanvas();


    public GUI() { //public GUI(Field boardOfField)
        boardOfField = boardOfField;
        setLayout(new BorderLayout());
        setTitle("Helenčin Tetris");
        setSize(302, 638);
        setVisible(true);
        add("Center", canvas);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private class MyCanvas extends Canvas {
        public void paint(Graphics graphics) {
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

  /*  Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            boardOfField[1][2].color.brighter();
        }
    });

    public void windowOpened(WindowEvent e) {
        windowOpen(e);
    }


    private void windowOpen(WindowEvent e) {
        timer.start();
    }

    public void windowClosed(WindowEvent e) {
        windowClose(e);
    }

    public void windowClose(WindowEvent e){
        timer.stop();
    }
}

 canvas.addWindowListener(new WindowAdapter() {
    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println("this window was opened for the first time");
    }

    @Override
    public void windowActivated(WindowEvent e) {
        System.out.println("this window or a subframe was focused");
    }
});}*/

}