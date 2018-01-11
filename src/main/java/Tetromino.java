package main.java;

import java.awt.*;

public interface Tetromino {
        int Shape = 1;

        int move();
        boolean isFirstMove();
        int moveRight();
        int moveLeft();
        int moveDown();
     //   void moveDownDown();
        int transformShape();
     //   boolean canIMove();
        void die();
        int getX();
        int getY();
        Color getColorOfTetromino();
}
