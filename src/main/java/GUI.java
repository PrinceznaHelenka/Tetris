package main.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GUI extends JFrame implements KeyListener{
    int size = 30;
    private GameBoard gameBoard;
    private Field boardOfField[][];
    private Tetromino tetromino;
    private MyCanvas canvas = new MyCanvas();

    public GUI(GameBoard gameBoard) { //public GUI(Field boardOfField)
        this.gameBoard = gameBoard;
        boardOfField = gameBoard.getBoardOfField();
        setLayout(new BorderLayout());
        setTitle("Helenčin Tetris");
        setSize(302, 638);
        setVisible(true);
        add("Center", canvas);
        addKeyListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void repaint() {
        canvas.paint(canvas.getGraphics());
    }


    private class MyCanvas extends Canvas {

        public void paint(Graphics graphics) {
            tetromino = gameBoard.getTetromino();


            //vykreslení políček
            int i, j;
            for (i = 0; i < 10; i++) {
                for (j = 0; j < 20; j++) {

                    if (boardOfField[i][j].isAvaiable()) {
                        graphics.drawRect(i * size, j * size, size, size);
                        graphics.setColor(Color.blue);
                        graphics.fillRect(i * size, j * size, size - 1, size - 1);
                    } else { //mrtvý ttmna a padající?
                        graphics.drawRect(i * size, j * size, size, size);
                        graphics.setColor(boardOfField[i][j].getColorOfField());
                        graphics.fillRect(i * size, j * size, size - 1, size - 1);
                    }
                }
            }
            if (tetromino != null) {
                graphics.drawRect(tetromino.getX() * size, tetromino.getY() * size, size, size);
                graphics.setColor(tetromino.getColorOfTetromino());
                graphics.fillRect(tetromino.getX() * size, tetromino.getY() * size, size - 1, size - 1);
            }

        }

    }

    public void keyPressed(KeyEvent evt) { //POŠÉFIT, ABY MI NELEZLY TTMNA ZA ROH

        int key = evt.getKeyCode();  // keyboard code for the pressed key

        if (key == KeyEvent.VK_LEFT) {  // left arrow key
            System.out.println("Left");
            tetromino.moveLeft();
        }
        else if (key == KeyEvent.VK_RIGHT) {  // right arrow key
            System.out.println("right");
            tetromino.moveRight();
        }
        else if (key == KeyEvent.VK_UP) {  // up arrow key
            System.out.println("top");
        }
        else if (key == KeyEvent.VK_DOWN) {  // down arrow key
            System.out.println("down");
            tetromino.moveDown();
        }
        else if (key == KeyEvent.VK_SPACE){
            System.out.println("space");
            tetromino.moveDownDown();
        }

    }
    public void keyReleased(KeyEvent evt) {
    }
    public void keyTyped(KeyEvent evt) {
    }
}
